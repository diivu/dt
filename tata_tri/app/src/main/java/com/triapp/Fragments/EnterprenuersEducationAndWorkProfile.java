package com.triapp.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.triapp.Adapter.CurrentIncomeListAdapter;
import com.triapp.Adapter.EducationQualificationListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class EnterprenuersEducationAndWorkProfile extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "EnterprenuersEducationAndWorkProfile";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private SessionManager mSessionManager;
    private DatabaseHelper mDatabaseHelper;
    private LinearLayout linearEditProfile, linearEnterpeneurTrainingDetails, linearEnterpreneurPropensity, linearExistingEnterpriseDetails, linearExpenditureDetails, linearCreditProfile, linearIncomeProfile, linearFamilyProfile, linearEducationAndWorkProfile;
    private TextView txtAddMoreWorkExperience, txtSubmitt,txtSaveWorkExperience, txtWorkExperience, txtSaveSpecialTraining, txtAddMoreSpecialTraining, txtSpecialTraining, txtSaveEducationAndWorkProfile, txtAddMoreEducationAndWorkProfile, txtEducationAndWorkProfile;
    private LinearLayout linearWorkExperienceButtons, linearDynamicWorkExperience, linearWorkExperienceMain, linearSpecialTrainingButtons, linearDynamicSpecialTraining, linearSpecialTrainingMain, linearEducationQualificationButtons, linearDynamicEducationAndWorkProfile, linearEducationAndWorkprofileMain;
    private View addmoreEducationDataView, addmoreSpecialTraining, addMoreWorkExperience;
    private TextView txtTitleNameOfOrganisation, txtNoOfWorkExperience, txtTitleQualification, txtNoOfItemsForEducation, txtTitleSubject, txtNoOfTraining;
    private EditText edtDurationWork, edtJobProfileWork, edtDesignationWork, edtNameOfOrganisationWork, edtLearningTraining, edtDurationTraining, edtInstituteTraining, edtSubjectTraining, edtMajorSubjects, edtyearOfPassing, edtUniversity, edtQualification;
    private ImageView imgEditViewWOrkExperience, imgEditView, imgEditViewTraining;
    private Dialog dialogEducationList, dialogEducationEditView;
    private ListView listEducation;
    private EducationQualificationListAdapter mEducationQualificationListAdapter;
    private int year = 0,getEditedPositionForEducation = 0, getEditedPositionForTraining = 0 ,getEditedPositionForWorkExperience=0;
    private ArrayList<CreateEnterpreneurModel.ListSpecialTrainingBean> specialTrainingBeanArrayList;
    private ArrayList<CreateEnterpreneurModel.ListEducationalQualificationBean> educationalQualificationBeanArrayList;
    private ArrayList<CreateEnterpreneurModel.ListWorkExperienceBean> workExperienceBeanArrayList;
    private boolean isBusinessPlanSubmitted;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strEducationAndWorkProfile));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.enterpreneur_education_workprofile, container, false);

        setIds();
        setOnClicks();

        return mView;

    }


    @Override
    public void onResume() {
        super.onResume();

    }

    private void setIds() {

        mActivity = getActivity();
        mContext = getActivity();

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

        //Initialize navigation controll
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


        //GET YEAR FOR COMPARING EDUCATION YEAR.
        Calendar mCalendar = Calendar.getInstance();
        year = mCalendar.get(Calendar.YEAR);

        txtEducationAndWorkProfile = (TextView) mView.findViewById(R.id.txtEducationAndWorkProfile);
        txtAddMoreEducationAndWorkProfile = (TextView) mView.findViewById(R.id.txtAddMoreEducationAndWorkProfile);
        txtSaveEducationAndWorkProfile = (TextView) mView.findViewById(R.id.txtSaveEducationAndWorkProfile);
        txtSpecialTraining = (TextView) mView.findViewById(R.id.txtSpecialTraining);
        txtAddMoreSpecialTraining = (TextView) mView.findViewById(R.id.txtAddMoreSpecialTraining);
        txtSaveSpecialTraining = (TextView) mView.findViewById(R.id.txtSaveSpecialTraining);
        txtWorkExperience = (TextView) mView.findViewById(R.id.txtWorkExperience);
        txtAddMoreWorkExperience = (TextView) mView.findViewById(R.id.txtAddMoreWorkExperience);
        txtSaveWorkExperience = (TextView) mView.findViewById(R.id.txtSaveWorkExperience);
        txtSubmitt = (TextView) mView.findViewById(R.id.txtSubmitt);

        linearEducationAndWorkprofileMain = (LinearLayout) mView.findViewById(R.id.linearEducationAndWorkprofileMain);
        linearDynamicEducationAndWorkProfile = (LinearLayout) mView.findViewById(R.id.linearDynamicEducationAndWorkProfile);
        linearEducationQualificationButtons = (LinearLayout) mView.findViewById(R.id.linearEducationQualificationButtons);
        linearSpecialTrainingMain = (LinearLayout) mView.findViewById(R.id.linearSpecialTrainingMain);
        linearDynamicSpecialTraining = (LinearLayout) mView.findViewById(R.id.linearDynamicSpecialTraining);
        linearSpecialTrainingButtons = (LinearLayout) mView.findViewById(R.id.linearSpecialTrainingButtons);
        linearWorkExperienceMain = (LinearLayout) mView.findViewById(R.id.linearWorkExperienceMain);
        linearDynamicWorkExperience = (LinearLayout) mView.findViewById(R.id.linearDynamicWorkExperience);
        linearWorkExperienceButtons = (LinearLayout) mView.findViewById(R.id.linearWorkExperienceButtons);

        //Get Enterprenuer education data from database
        displayEducationData(false);

        //Display auto fill training data
        displaySpecialTrainingData(false);

        //Display work experience data
        dislayWorkExperienceData(false);

        //CHECK IF BUSINESS PLAN IS ALREADY SUBMITTED
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getIsBusinessPlanSubmited() == 1) {
                isBusinessPlanSubmitted = true;
                makeViewUnEditable();
            }
        }



    }

    private void makeViewUnEditable() {

        txtAddMoreEducationAndWorkProfile.setVisibility(View.GONE);
        txtSaveEducationAndWorkProfile.setVisibility(View.GONE);
        txtAddMoreSpecialTraining.setVisibility(View.GONE);
        txtSaveSpecialTraining.setVisibility(View.GONE);
        txtAddMoreWorkExperience.setVisibility(View.GONE);
        txtSaveWorkExperience.setVisibility(View.GONE);
        txtSubmitt.setVisibility(View.GONE);

    }

    private void setOnClicks() {

        //ON CLICKS FOR EDUCATION DATA'S
        txtEducationAndWorkProfile.setOnClickListener(this);
        txtAddMoreEducationAndWorkProfile.setOnClickListener(this);
        txtSaveEducationAndWorkProfile.setOnClickListener(this);
        linearEducationAndWorkprofileMain.setOnClickListener(this);
        linearDynamicEducationAndWorkProfile.setOnClickListener(this);
        linearEducationQualificationButtons.setOnClickListener(this);

        //ON CLICKS FOR SPECIAL TRAINING DATA'S
        txtSpecialTraining.setOnClickListener(this);
        txtAddMoreSpecialTraining.setOnClickListener(this);
        txtSaveSpecialTraining.setOnClickListener(this);
        linearSpecialTrainingMain.setOnClickListener(this);
        linearDynamicSpecialTraining.setOnClickListener(this);
        linearSpecialTrainingButtons.setOnClickListener(this);

        //ON CLICKS FOR WORK EXPERIENCE DATA'S
        txtWorkExperience.setOnClickListener(this);
        txtAddMoreWorkExperience.setOnClickListener(this);
        txtSaveWorkExperience.setOnClickListener(this);
        linearWorkExperienceMain.setOnClickListener(this);
        linearDynamicWorkExperience.setOnClickListener(this);
        linearWorkExperienceButtons.setOnClickListener(this);

        txtSubmitt.setOnClickListener(this);
    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtEducationAndWorkProfile:

                //HIDE SHOW LAYOUT AS PER OPEN CLOSE VIEW
                if (linearEducationAndWorkprofileMain.getVisibility() == View.VISIBLE) {
                    linearEducationAndWorkprofileMain.setVisibility(View.GONE);
                } else {
                    linearEducationAndWorkprofileMain.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.txtAddMoreEducationAndWorkProfile:

                //SET FLAG AS PER REQUIREMENTS IF USER CLICK ON ADD MORRE BUTTON THEN ITS TRUE
                saveEducationDataInToDatabase(true);

                break;
            case R.id.txtSaveEducationAndWorkProfile:

                //SET FLAG AS PER REQUIREMENTS IF USER CLICK ON ADD MORRE BUTTON THEN ITS FALSE
                saveEducationDataInToDatabase(false);

                break;

            case R.id.txtSpecialTraining:

                //HIDE SHOW LAYOUT AS PER OPEN CLOSE VIEW
                if (linearSpecialTrainingMain.getVisibility() == View.VISIBLE) {
                    linearSpecialTrainingMain.setVisibility(View.GONE);
                } else {
                    linearSpecialTrainingMain.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.txtAddMoreSpecialTraining:

                saveEnterprenuerTrainingDetails(true);

                break;
            case R.id.txtSaveSpecialTraining:

                saveEnterprenuerTrainingDetails(false);

                break;

            case R.id.txtWorkExperience:

                //HIDE SHOW LAYOUT AS PER OPEN CLOSE VIEW
                if (linearWorkExperienceMain.getVisibility() == View.VISIBLE) {
                    linearWorkExperienceMain.setVisibility(View.GONE);
                } else {
                    linearWorkExperienceMain.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.txtAddMoreWorkExperience:

                saveEnterprenuerWorkExperienceData(true);

                break;
            case R.id.txtSaveWorkExperience:

                saveEnterprenuerWorkExperienceData(false);

                break;

            case R.id.txtSubmitt:

                saveAllChanges();

                break;

        }

    }




    //OTHER METHOD FOR EDUCATION DETAILS
    private void displayEducationData(boolean isFromAddButton) {

        //Remove All Views from dynamic added layout
        linearDynamicEducationAndWorkProfile.removeAllViews();
        int arraySize = 0;

        //Get Saved education Data From Database
        educationalQualificationBeanArrayList = mDatabaseHelper.getAllEntrepreneurEducationQualificationList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));

        //Inflate view as per arraylist size for different scenarios
        if (educationalQualificationBeanArrayList.size() != 0 && !isFromAddButton) {
            arraySize = educationalQualificationBeanArrayList.size();
        } else if (educationalQualificationBeanArrayList.size() != 0 && isFromAddButton) {
            arraySize = (educationalQualificationBeanArrayList.size() + 1);
        } else {
            arraySize = 1;
        }


        for (int i = 0; i < arraySize; i++) {

            //------(Add dynamic views as per array list size)-------//
            addmoreEducationDataView = mActivity.getLayoutInflater().inflate(R.layout.dynamic_view_education, linearDynamicEducationAndWorkProfile, false);

            //------(Find views)-------//
            txtNoOfItemsForEducation = (TextView) addmoreEducationDataView.findViewById(R.id.txtNoOfItemsForEducation);
            txtTitleQualification = (TextView) addmoreEducationDataView.findViewById(R.id.txtTitleQualification);

            edtQualification = (EditText) addmoreEducationDataView.findViewById(R.id.edtQualification);
            edtUniversity = (EditText) addmoreEducationDataView.findViewById(R.id.edtUniversity);
            edtyearOfPassing = (EditText) addmoreEducationDataView.findViewById(R.id.edtyearOfPassing);
            edtMajorSubjects = (EditText) addmoreEducationDataView.findViewById(R.id.edtMajorSubjects);
            imgEditView = (ImageView) addmoreEducationDataView.findViewById(R.id.imgEditView);

            //Set title compulsory
            txtTitleQualification.setText(CommonMethods.spannableString(getResources().getString(R.string.strQualification)));

            //set seriel no. to the dynamic added view
            txtNoOfItemsForEducation.setText("" + (i + 1));

            //MAKE EDIT ICON GONE
            if(isBusinessPlanSubmitted){
                imgEditView.setVisibility(View.GONE);
            }


            //----(Set already existing data)-----//
            if (educationalQualificationBeanArrayList.size() != 0) {

                if (educationalQualificationBeanArrayList.size() > i) {

                    edtQualification.setText(educationalQualificationBeanArrayList.get(i).getQualificationName());
                    edtUniversity.setText(educationalQualificationBeanArrayList.get(i).getUniversityName());
                    edtyearOfPassing.setText(educationalQualificationBeanArrayList.get(i).getPassingYear());
                    edtMajorSubjects.setText(educationalQualificationBeanArrayList.get(i).getMajorSubject());

                    edtQualification.setFocusableInTouchMode(false);
                    edtQualification.setClickable(false);
                    edtUniversity.setFocusableInTouchMode(false);
                    edtyearOfPassing.setFocusableInTouchMode(false);
                    edtMajorSubjects.setFocusableInTouchMode(false);

                } else {
                    //Hide edit view image if data is newley added or click on add more button
                    imgEditView.setVisibility(View.GONE);
                }


            } else {
                //Hide edit view image if data is newley added or click on add more button
                imgEditView.setVisibility(View.GONE);
            }


            //Adding view to dynamic layout
            linearDynamicEducationAndWorkProfile.addView(addmoreEducationDataView);
            final int position = linearDynamicEducationAndWorkProfile.indexOfChild(addmoreEducationDataView);
            imgEditView.setTag(position);
            edtQualification.setTag(position);


            //----(use position for delete view)-----//
            imgEditView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    getEditedPositionForEducation = (Integer) v.getTag();
                    editEducationData(getEditedPositionForEducation);


                }
            });


            edtQualification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int clickedPosition = (Integer) v.getTag();

                    if (clickedPosition == educationalQualificationBeanArrayList.size()) {

                        dialogEducationList = new Dialog(getActivity(), R.style.MY_DIALOG);
                        dialogEducationList.setContentView(R.layout.general_list_dialog);

                        dialogEducationList.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

                        ImageView imgBack = (ImageView) dialogEducationList.findViewById(R.id.imgBack);
                        TextView txtTitle = (TextView) dialogEducationList.findViewById(R.id.txtTitle);
                        txtTitle.setText(getResources().getString(R.string.strSelectEducation));


                        listEducation = (ListView) dialogEducationList.findViewById(R.id.listItems);
                        mEducationQualificationListAdapter = new EducationQualificationListAdapter(mContext, getResources().getStringArray(R.array.arrayEducationList));
                        listEducation.setAdapter(mEducationQualificationListAdapter);

                        listEducation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                dialogEducationList.dismiss();

                                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                                String strCasteFromSelection = textView.getText().toString();
                                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                                edtQualification.setText(strCasteFromSelection);

                            }
                        });

                        imgBack.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogEducationList.dismiss();
                            }
                        });

                        dialogEducationList.setCanceledOnTouchOutside(false);
                        dialogEducationList.setCancelable(true);
                        dialogEducationList.show();

                    }
                }
            });
        }


        edtyearOfPassing.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() > 3) {

                    if (Integer.parseInt(s.toString()) >= 1970 && Integer.parseInt(s.toString()) <= year) {

                    } else {
                        CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorYearSelection) + year);
                        edtyearOfPassing.setText("");
                    }
                }
            }
        });

    }


    private void editEducationData(final Integer getEditedPositionForEducation) {

        final android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.edit_view_education_data, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();


        final TextView tvNoOfEducationEditView = (TextView) dialogView.findViewById(R.id.tvNoOfEducationEditView);
        final TextView txtTitleQualificationEditView = (TextView) dialogView.findViewById(R.id.txtTitleQualificationEditView);

        final TextView txtCacelEducationEditView = (TextView) dialogView.findViewById(R.id.txtCacelEducationEditView);
        final TextView txtDeleteEducationEditView = (TextView) dialogView.findViewById(R.id.txtDeleteEducationEditView);
        final TextView txtUpdateEducationEditView = (TextView) dialogView.findViewById(R.id.txtUpdateEducationEditView);

        final EditText etQualificationEditView = (EditText) dialogView.findViewById(R.id.etQualificationEditView);
        final EditText etUniversityEditView = (EditText) dialogView.findViewById(R.id.etUniversityEditView);
        final EditText etYearOfPassingEditView = (EditText) dialogView.findViewById(R.id.etYearOfPassingEditView);
        final EditText etMajorSubjectEditView = (EditText) dialogView.findViewById(R.id.etMajorSubjectEditView);

        //Set title compulsory
        txtTitleQualificationEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strQualification)));


        tvNoOfEducationEditView.setText("" + (getEditedPositionForEducation + 1));

        etQualificationEditView.setText(educationalQualificationBeanArrayList.get(getEditedPositionForEducation).getQualificationName());
        etUniversityEditView.setText(educationalQualificationBeanArrayList.get(getEditedPositionForEducation).getUniversityName());
        etYearOfPassingEditView.setText(educationalQualificationBeanArrayList.get(getEditedPositionForEducation).getPassingYear());
        etMajorSubjectEditView.setText(educationalQualificationBeanArrayList.get(getEditedPositionForEducation).getMajorSubject());


        etQualificationEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEducationList = new Dialog(getActivity(), R.style.MY_DIALOG);
                dialogEducationList.setContentView(R.layout.general_list_dialog);
                dialogEducationList.setCancelable(false);

                dialogEducationList.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

                ImageView imgBack = (ImageView) dialogEducationList.findViewById(R.id.imgBack);
                TextView txtTitle = (TextView) dialogEducationList.findViewById(R.id.txtTitle);
                txtTitle.setText(getResources().getString(R.string.strSelectEducation));


                listEducation = (ListView) dialogEducationList.findViewById(R.id.listItems);
                mEducationQualificationListAdapter = new EducationQualificationListAdapter(mContext, getResources().getStringArray(R.array.arrayEducationList));
                listEducation.setAdapter(mEducationQualificationListAdapter);

                listEducation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        dialogEducationList.dismiss();

                        TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                        String strEducationItem = textView.getText().toString();
                        TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                        etQualificationEditView.setText(strEducationItem);

                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogEducationList.dismiss();
                    }
                });

                dialogEducationList.setCanceledOnTouchOutside(false);
                dialogEducationList.setCancelable(true);
                dialogEducationList.show();


            }
        });


        etYearOfPassingEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() > 3) {

                    if (Integer.parseInt(s.toString()) >= 1970 && Integer.parseInt(s.toString()) <= year) {

                    } else {
                        CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorYearSelection) + year);
                        etYearOfPassingEditView.setText("");
                    }
                }
            }
        });


        //----(Dismiss popup)-----//
        txtCacelEducationEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });

        //----(Delet selected view from list)-----//
        txtDeleteEducationEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openEducationDeleteDialog(getEditedPositionForEducation);
                mAlertDialog.dismiss();


            }
        });
        //----(Dismiss popup)-----//
        txtUpdateEducationEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert furniture data in to database
                if (checkValidationEducationData()) {

                    mDatabaseHelper.updateEducationData(
                            Long.valueOf("" + mSessionManager.getPreferenceInt(Constants.USER_ID)), //1
                            Long.valueOf("" + mSessionManager.getPreferenceInt(Constants.USER_ID)), //2
                            educationalQualificationBeanArrayList.get(getEditedPositionForEducation).getCreatedDate(), //3
                            educationalQualificationBeanArrayList.get(getEditedPositionForEducation).getId(), //4
                            etQualificationEditView.getText().toString(), //5
                            etUniversityEditView.getText().toString(),
                            etYearOfPassingEditView.getText().toString(), //7
                            etMajorSubjectEditView.getText().toString(), //6
                            Long.valueOf("" + getArguments().getString(Constants.ENTERPRENEUR_ID)), //9
                            0 //10
                    );


                    // reset dynamic view
                    displayEducationData(false);
                    mAlertDialog.dismiss();
                }

            }

            private boolean checkValidationEducationData() {

                if (etQualificationEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterQualification));
                    etQualificationEditView.requestFocus();
                    return false;
                } else if (etUniversityEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterUniversity));
                    etUniversityEditView.requestFocus();
                    return false;
                } else if (etYearOfPassingEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnteYearOfPassing));
                    etYearOfPassingEditView.requestFocus();
                    return false;
                } else if (!(Integer.parseInt(etYearOfPassingEditView.getText().toString()) >= 1970 && Integer.parseInt(etYearOfPassingEditView.getText().toString()) <= year)) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorYearSelection) + year);
                    etYearOfPassingEditView.requestFocus();
                    return false;
                } else if (etMajorSubjectEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnteMajorSubjectName));
                    etMajorSubjectEditView.requestFocus();
                    return false;
                } else {
                    return true;
                }


            }
        });


        mAlertDialog.show();


    }

    private void saveEducationDataInToDatabase(boolean isFromAddButton) {

        if (educationalQualificationBeanArrayList.size() != 0) {

            //check if data already saved in database
            if (edtQualification.getText().toString().equals(educationalQualificationBeanArrayList.get(educationalQualificationBeanArrayList.size() - 1).getQualificationName())) {
                displayEducationData(isFromAddButton);

                if (!isFromAddButton) {
                    //Hide view and display success messege
                    linearEducationAndWorkprofileMain.setVisibility(View.GONE);
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strEducationDataSavedSuccessfully));

                }
            } else {

                if (checkValidationForEducation()) {
                    insertEducationData(isFromAddButton);
                }
            }
        } else {

            if (checkValidationForEducation()) {
                insertEducationData(isFromAddButton);
            }
        }

    }

    private void insertEducationData(boolean isFromAddButton) {

        mDatabaseHelper.insertEdicationQualificationList(
                Long.valueOf("" + mSessionManager.getPreferenceInt(Constants.USER_ID)), //1
                Long.valueOf("" + mSessionManager.getPreferenceInt(Constants.USER_ID)), //2
                System.currentTimeMillis(), //3
                System.currentTimeMillis(), //4
                edtQualification.getText().toString(), //5
                edtUniversity.getText().toString(),
                edtyearOfPassing.getText().toString(), //7
                edtMajorSubjects.getText().toString(), //6
                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)), //9
                0 //10
        );
        // reset dynamic view
        displayEducationData(isFromAddButton);
        if (!isFromAddButton) {
            //Hide view and display success messege
            linearEducationAndWorkprofileMain.setVisibility(View.GONE);
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEducationDataSavedSuccessfully));

        }
    }

    private boolean checkValidationForEducation() {

        if (edtQualification.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidationQualification));
            return false;
        } else if (edtyearOfPassing.length() != 0 && (!(Integer.parseInt(edtyearOfPassing.getText().toString()) >= 1970 && Integer.parseInt(edtyearOfPassing.getText().toString()) <= year))) {

            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorYearSelection) + year);
            return false;
        } else {

            return true;
        }
    }

    private void openEducationDeleteDialog(final Integer getEditedPositionForEducation) {

        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_remove_view_dialog, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();

        TextView txtUsername = (TextView) dialogView.findViewById(R.id.txtUsername);
        TextView txtRemove = (TextView) dialogView.findViewById(R.id.txtRemove);
        txtUsername.setText(getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        txtRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteEdicationQualificationSellDatabyID(educationalQualificationBeanArrayList.get(getEditedPositionForEducation).getId());
                displayEducationData(false);
                mAlertDialog.dismiss();
            }
        });


        mAlertDialog.show();
    }

    //OTHER METHOD FOR SPECIAL TRAINING DETAILS
    private void displaySpecialTrainingData(boolean isFromAddButton) {

        //Remove All Views from dynamic added layout
        linearDynamicSpecialTraining.removeAllViews();
        int arraySize = 0;

        //Get Enterprenuer Special Trining data from database
        specialTrainingBeanArrayList = mDatabaseHelper.getAllEntrepreneurSpecialTrainingList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));


        //Inflate view as per arraylist size for different scenarios
        if (specialTrainingBeanArrayList.size() != 0 && !isFromAddButton) {
            arraySize = specialTrainingBeanArrayList.size();
        } else if (specialTrainingBeanArrayList.size() != 0 && isFromAddButton) {
            arraySize = (specialTrainingBeanArrayList.size() + 1);
        } else {
            arraySize = 1;
        }


        for (int i = 0; i < arraySize; i++) {

            //------(Add dynamic views as per array list size)-------//
            addmoreSpecialTraining = mActivity.getLayoutInflater().inflate(R.layout.dynamic_view_training, linearDynamicSpecialTraining, false);

            //------(Find views)-------//
            txtNoOfTraining = (TextView) addmoreSpecialTraining.findViewById(R.id.txtNoOfTraining);
            txtTitleSubject = (TextView) addmoreSpecialTraining.findViewById(R.id.txtTitleSubject);

            edtSubjectTraining = (EditText) addmoreSpecialTraining.findViewById(R.id.edtSubjectTraining);
            edtInstituteTraining = (EditText) addmoreSpecialTraining.findViewById(R.id.edtInstituteTraining);
            edtDurationTraining = (EditText) addmoreSpecialTraining.findViewById(R.id.edtDurationTraining);
            edtLearningTraining = (EditText) addmoreSpecialTraining.findViewById(R.id.edtLearningTraining);

            imgEditViewTraining = (ImageView) addmoreSpecialTraining.findViewById(R.id.imgEditViewTraining);


            //Set title compulsory
            txtTitleSubject.setText(CommonMethods.spannableString(getResources().getString(R.string.strSubject)));

            //set seriel no. to the dynamic added view
            txtNoOfTraining.setText("" + (i + 1));

            //MAKE EDIT ICON GONE
            if(isBusinessPlanSubmitted){
                imgEditView.setVisibility(View.GONE);
            }


            //----(Set already existing data)-----//
            if (specialTrainingBeanArrayList.size() != 0) {

                if (specialTrainingBeanArrayList.size() > i) {

                    edtSubjectTraining.setText(specialTrainingBeanArrayList.get(i).getSubject());
                    edtInstituteTraining.setText(specialTrainingBeanArrayList.get(i).getInstitute());
                    edtDurationTraining.setText(specialTrainingBeanArrayList.get(i).getDuration());
                    edtLearningTraining.setText(specialTrainingBeanArrayList.get(i).getLearning());


                    if (specialTrainingBeanArrayList.get(i).getIsEditable() != 1) {

                        edtSubjectTraining.setFocusableInTouchMode(false);
                        edtInstituteTraining.setFocusableInTouchMode(false);
                        edtDurationTraining.setFocusableInTouchMode(false);
                        edtLearningTraining.setFocusableInTouchMode(false);


                    }
                } else {
                    //Hide edit view image if data is newley added or click on add more button
                    imgEditViewTraining.setVisibility(View.GONE);
                }


            } else {
                //Hide edit view image if data is newley added or click on add more button
                imgEditViewTraining.setVisibility(View.GONE);
            }


            //Adding view to dynamic layout
            linearDynamicSpecialTraining.addView(addmoreSpecialTraining);
            final int position = linearDynamicSpecialTraining.indexOfChild(addmoreSpecialTraining);

            imgEditViewTraining.setTag(position);
            edtDurationTraining.setTag(position);

            //----(use position for delete view)-----//
            imgEditViewTraining.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    getEditedPositionForTraining = (Integer) v.getTag();
                    openTrainingEditViewDialog(getEditedPositionForTraining);

                }
            });

            edtDurationTraining.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //USE SAME DIALOG FOR LIST DURATION
                    int clickedPosition = (Integer) v.getTag();
                    if (clickedPosition == specialTrainingBeanArrayList.size()) {

                        dialogEducationList = new Dialog(getActivity(), R.style.MY_DIALOG);
                        dialogEducationList.setContentView(R.layout.general_list_dialog);
                        dialogEducationList.setCancelable(false);

                        dialogEducationList.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

                        ImageView imgBack = (ImageView) dialogEducationList.findViewById(R.id.imgBack);
                        TextView txtTitle = (TextView) dialogEducationList.findViewById(R.id.txtTitle);
                        txtTitle.setText(getResources().getString(R.string.strSelectDuration));


                        listEducation = (ListView) dialogEducationList.findViewById(R.id.listItems);
                        mEducationQualificationListAdapter = new EducationQualificationListAdapter(mContext, getResources().getStringArray(R.array.arraySpecialtraining));
                        listEducation.setAdapter(mEducationQualificationListAdapter);

                        listEducation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                dialogEducationList.dismiss();

                                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                                String strDurationItem = textView.getText().toString();

                                edtDurationTraining.setText(strDurationItem);

                            }
                        });

                        imgBack.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogEducationList.dismiss();
                            }
                        });

                        dialogEducationList.setCanceledOnTouchOutside(false);
                        dialogEducationList.setCancelable(true);
                        dialogEducationList.show();

                    }


                }
            });


        }


    }


    private void saveEnterprenuerTrainingDetails(boolean isFromAddButton) {

        if (specialTrainingBeanArrayList.size() != 0) {

            //check if data already saved in database
            if (edtSubjectTraining.getText().toString().equals(specialTrainingBeanArrayList.get(specialTrainingBeanArrayList.size() - 1).getSubject())) {
                displaySpecialTrainingData(isFromAddButton);

                if (!isFromAddButton) {
                    //Hide view and display success messege
                    linearSpecialTrainingMain.setVisibility(View.GONE);
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strMsgTrainingDataSavedSuccessfully));

                }
            } else {

                if (checkValidationForTraining()) {

                    insertTrainingDataInToDatabase(isFromAddButton);
                }
            }
        } else {

            if (checkValidationForTraining()) {

                insertTrainingDataInToDatabase(isFromAddButton);
            }
        }

    }


    private boolean checkValidationForTraining() {

        if (edtSubjectTraining.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterSubject));
            return false;
        } else {
            return true;
        }
    }

    private void insertTrainingDataInToDatabase(boolean isFromAddButton) {

        mDatabaseHelper.insertSpecialTrainingList(
                System.currentTimeMillis(), //1
                edtSubjectTraining.getText().toString(), //2
                edtInstituteTraining.getText().toString(), //3
                edtDurationTraining.getText().toString(), //4
                edtLearningTraining.getText().toString(), //5
                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)) //6
        );

        // reset dynamic view
        displaySpecialTrainingData(isFromAddButton);
        if (!isFromAddButton) {
            //Hide view and display success messege
            linearSpecialTrainingMain.setVisibility(View.GONE);
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strMsgTrainingDataSavedSuccessfully));

        }
    }

    private void openTrainingEditViewDialog(final Integer getEditedPositionForTraining) {


        final android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.edit_view_training, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();


        final TextView tvNoOfTrainingEditview = (TextView) dialogView.findViewById(R.id.tvNoOfTrainingEditview);
        final TextView txtTitleSubjectEditView = (TextView) dialogView.findViewById(R.id.txtTitleSubjectEditView);
        final TextView txtCacelTrainingEditView = (TextView) dialogView.findViewById(R.id.txtCacelTrainingEditView);
        final TextView txtDeleteTrainingEditView = (TextView) dialogView.findViewById(R.id.txtDeleteTrainingEditView);
        final TextView txtUpdateTrainingEditView = (TextView) dialogView.findViewById(R.id.txtUpdateTrainingEditView);

        final EditText etSubjectTrainingEditview = (EditText) dialogView.findViewById(R.id.etSubjectTrainingEditview);
        final EditText etInstituteTrainingEditview = (EditText) dialogView.findViewById(R.id.etInstituteTrainingEditview);
        final EditText etDurationTrainingEditview = (EditText) dialogView.findViewById(R.id.etDurationTrainingEditview);
        final EditText etLearningTrainingEditview = (EditText) dialogView.findViewById(R.id.etLearningTrainingEditview);


        //set item count
        tvNoOfTrainingEditview.setText("" + (getEditedPositionForTraining + 1));

        //Set title compulsory
        txtTitleSubjectEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strSubject)));

        etSubjectTrainingEditview.setText(specialTrainingBeanArrayList.get(getEditedPositionForTraining).getSubject());
        etInstituteTrainingEditview.setText(specialTrainingBeanArrayList.get(getEditedPositionForTraining).getInstitute());
        etDurationTrainingEditview.setText(specialTrainingBeanArrayList.get(getEditedPositionForTraining).getDuration());
        etLearningTrainingEditview.setText(specialTrainingBeanArrayList.get(getEditedPositionForTraining).getLearning());


        etDurationTrainingEditview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogEducationList = new Dialog(getActivity(), R.style.MY_DIALOG);
                dialogEducationList.setContentView(R.layout.general_list_dialog);
                dialogEducationList.setCancelable(false);

                dialogEducationList.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

                ImageView imgBack = (ImageView) dialogEducationList.findViewById(R.id.imgBack);
                TextView txtTitle = (TextView) dialogEducationList.findViewById(R.id.txtTitle);
                txtTitle.setText(getResources().getString(R.string.strSelectDuration));


                listEducation = (ListView) dialogEducationList.findViewById(R.id.listItems);
                mEducationQualificationListAdapter = new EducationQualificationListAdapter(mContext, getResources().getStringArray(R.array.arraySpecialtraining));
                listEducation.setAdapter(mEducationQualificationListAdapter);

                listEducation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        dialogEducationList.dismiss();

                        TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                        String strDurationItem = textView.getText().toString();

                        etDurationTrainingEditview.setText(strDurationItem);

                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogEducationList.dismiss();
                    }
                });

                dialogEducationList.setCanceledOnTouchOutside(false);
                dialogEducationList.setCancelable(true);
                dialogEducationList.show();


            }
        });


        //----(Dismiss popup)-----//
        txtCacelTrainingEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });

        //----(Delet selected view from list)-----//
        txtDeleteTrainingEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTrainingDeleteDialog(getEditedPositionForTraining);
                mAlertDialog.dismiss();


            }
        });
        //----(Dismiss popup)-----//
        txtUpdateTrainingEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert furniture data in to database
                if (checkValidationTrainingData()) {

                    mDatabaseHelper.updateSpecialTrainingList(
                            specialTrainingBeanArrayList.get(getEditedPositionForTraining).getId(), //1
                            etSubjectTrainingEditview.getText().toString(), //2
                            etInstituteTrainingEditview.getText().toString(), //3
                            etDurationTrainingEditview.getText().toString(), //4
                            etLearningTrainingEditview.getText().toString(), //5
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)) //6
                    );

                    // reset dynamic view
                    displaySpecialTrainingData(false);
                    mAlertDialog.dismiss();
                }

            }

            private boolean checkValidationTrainingData() {

                if (etSubjectTrainingEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterSubject));
                    etSubjectTrainingEditview.requestFocus();
                    return false;
                } else if (etInstituteTrainingEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterInstitute));
                    etInstituteTrainingEditview.requestFocus();
                    return false;
                } else if (etDurationTrainingEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterDuration));
                    etDurationTrainingEditview.requestFocus();
                    return false;
                } else if (etLearningTrainingEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterLearning));
                    etLearningTrainingEditview.requestFocus();
                    return false;
                } else {
                    return true;
                }

            }
        });

        mAlertDialog.show();

    }

    private void openTrainingDeleteDialog(final Integer getEditedPositionForTraining) {
        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_remove_view_dialog, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();

        TextView txtUsername = (TextView) dialogView.findViewById(R.id.txtUsername);
        TextView txtRemove = (TextView) dialogView.findViewById(R.id.txtRemove);
        txtUsername.setText(getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        txtRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteSpecialTrainingByID(specialTrainingBeanArrayList.get(getEditedPositionForTraining).getId());
                displaySpecialTrainingData(false);
                mAlertDialog.dismiss();
            }
        });


        mAlertDialog.show();

    }

    //OTHER METHOD'S FOR WORK EXPERIENCE
    private void dislayWorkExperienceData(boolean isFromAddButton) {

        //Remove All Views from dynamic added layout
        linearDynamicWorkExperience.removeAllViews();
        int arraySize = 0;

        //Get Enterprenuer work experience data from database
        workExperienceBeanArrayList = mDatabaseHelper.getAllEntrepreneurWorkExperienceList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));


        //Inflate view as per arraylist size for different scenarios
        if (workExperienceBeanArrayList.size() != 0 && !isFromAddButton) {
            arraySize = workExperienceBeanArrayList.size();
        } else if (workExperienceBeanArrayList.size() != 0 && isFromAddButton) {
            arraySize = (workExperienceBeanArrayList.size() + 1);
        } else {
            arraySize = 1;
        }


        for (int i = 0; i < arraySize; i++) {

            //------(Add dynamic views as per array list size)-------//
            addMoreWorkExperience = mActivity.getLayoutInflater().inflate(R.layout.dynamic_view_work_experience, linearDynamicWorkExperience, false);

            //------(Find views)-------//
            txtNoOfWorkExperience = (TextView) addMoreWorkExperience.findViewById(R.id.txtNoOfWorkExperience);
            txtTitleNameOfOrganisation = (TextView) addMoreWorkExperience.findViewById(R.id.txtTitleNameOfOrganisation);

            edtNameOfOrganisationWork = (EditText) addMoreWorkExperience.findViewById(R.id.edtNameOfOrganisationWork);
            edtDesignationWork = (EditText) addMoreWorkExperience.findViewById(R.id.edtDesignationWork);
            edtJobProfileWork = (EditText) addMoreWorkExperience.findViewById(R.id.edtJobProfileWork);
            edtDurationWork = (EditText) addMoreWorkExperience.findViewById(R.id.edtDurationWork);

            imgEditViewWOrkExperience = (ImageView) addMoreWorkExperience.findViewById(R.id.imgEditViewWOrkExperience);


            //set seriel no. to the dynamic added view
            txtNoOfWorkExperience.setText("" + (i + 1));

            //Set title compulsory
            txtTitleNameOfOrganisation.setText(CommonMethods.spannableString(getResources().getString(R.string.strNameOfOrganisation)));

            //MAKE EDIT ICON GONE
            if(isBusinessPlanSubmitted){
                imgEditView.setVisibility(View.GONE);
            }


            //----(Set already existing data)-----//
            if (workExperienceBeanArrayList.size() != 0) {

                if (workExperienceBeanArrayList.size() > i) {

                    edtNameOfOrganisationWork.setText(workExperienceBeanArrayList.get(i).getOrganisation());
                    edtDesignationWork.setText(workExperienceBeanArrayList.get(i).getDesignation());
                    edtJobProfileWork.setText(workExperienceBeanArrayList.get(i).getJobProfile());
                    edtDurationWork.setText(workExperienceBeanArrayList.get(i).getDuration());


                    if (workExperienceBeanArrayList.get(i).getIsEdited() != 1) {

                        edtNameOfOrganisationWork.setFocusableInTouchMode(false);
                        edtDesignationWork.setFocusableInTouchMode(false);
                        edtJobProfileWork.setFocusableInTouchMode(false);
                        edtDurationWork.setFocusableInTouchMode(false);


                    }
                } else {
                    //Hide edit view image if data is newley added or click on add more button
                    imgEditViewWOrkExperience.setVisibility(View.GONE);
                }


            } else {
                //Hide edit view image if data is newley added or click on add more button
                imgEditViewWOrkExperience.setVisibility(View.GONE);
            }


            //Adding view to dynamic layout
            linearDynamicWorkExperience.addView(addMoreWorkExperience);
            final int position = linearDynamicWorkExperience.indexOfChild(addMoreWorkExperience);
            imgEditViewWOrkExperience.setTag(position);

            //----(use position for delete view)-----//
            imgEditViewWOrkExperience.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                getEditedPositionForWorkExperience = (Integer) v.getTag();
                openWorkExperienceEditDialog(getEditedPositionForWorkExperience);

                }
            });


        }

    }

    private void saveEnterprenuerWorkExperienceData(boolean isFromAddButton) {

        if (workExperienceBeanArrayList.size() != 0) {

            //check if data already saved in database
            if (edtNameOfOrganisationWork.getText().toString().equals(workExperienceBeanArrayList.get(workExperienceBeanArrayList.size() - 1).getOrganisation())) {
                dislayWorkExperienceData(isFromAddButton);

                if (!isFromAddButton) {
                    //Hide view and display success messege
                    linearWorkExperienceMain.setVisibility(View.GONE);
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strMsgWorkDataSavedSuccessfully));

                }
            } else {

                if (checkValidationForWorkExperience()) {

                    insertWorkProfileData(isFromAddButton);
                }
            }
        } else {

            if (checkValidationForWorkExperience()) {

                insertWorkProfileData(isFromAddButton);
            }
        }

    }



    private boolean checkValidationForWorkExperience() {

        if (edtNameOfOrganisationWork.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterOrganisationName));
            return false;
        }else if (!(edtDurationWork.getText().toString().length() == 0) && edtDurationWork.getText().toString().equals("0")) {

            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterDurationValid));
            return false;

        } else{
            return true;
        }

    }

    private void insertWorkProfileData(boolean isFromAddButton) {

        mDatabaseHelper.insertWorkExperienceList(
                System.currentTimeMillis(), //1
                edtNameOfOrganisationWork.getText().toString(), //2
                edtDesignationWork.getText().toString(), //3
                edtJobProfileWork.getText().toString(), //4
                edtDurationWork.getText().toString(), //5
                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)) //6
        );
        // reset dynamic view
        dislayWorkExperienceData(isFromAddButton);
        if (!isFromAddButton) {
            //Hide view and display success messege
            linearWorkExperienceMain.setVisibility(View.GONE);
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strMsgWorkDataSavedSuccessfully));

        }

    }

    private void openWorkExperienceEditDialog(final Integer getEditedPositionForWorkExperience) {

        final android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.edit_view_work_experience, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();

        final TextView tvNoOfWorkExperienceEditView = (TextView) dialogView.findViewById(R.id.tvNoOfWorkExperienceEditView);
        final TextView txtTitleNameOfOrganisation = (TextView) dialogView.findViewById(R.id.txtTitleNameOfOrganisation);
        final TextView txtCacelWorkExperienceEditView = (TextView) dialogView.findViewById(R.id.txtCacelWorkExperienceEditView);
        final TextView txtDeleteWorkExperienceEditView = (TextView) dialogView.findViewById(R.id.txtDeleteWorkExperienceEditView);
        final TextView txtUpdateWorkExperienceEditView = (TextView) dialogView.findViewById(R.id.txtUpdateWorkExperienceEditView);

        final EditText edtNameOfOrganisationWorkEditView = (EditText) dialogView.findViewById(R.id.edtNameOfOrganisationWorkEditView);
        final EditText edtDesignationWorkEditView = (EditText) dialogView.findViewById(R.id.edtDesignationWorkEditView);
        final EditText edtJobProfileWorkEditView = (EditText) dialogView.findViewById(R.id.edtJobProfileWorkEditView);
        final EditText edtDurationWorkEditView = (EditText) dialogView.findViewById(R.id.edtDurationWorkEditView);

        //Set item count
        tvNoOfWorkExperienceEditView.setText("" + (getEditedPositionForWorkExperience + 1));

        //Set title compulsory
        txtTitleNameOfOrganisation.setText(CommonMethods.spannableString(getResources().getString(R.string.strNameOfOrganisation)));


        edtNameOfOrganisationWorkEditView.setText(workExperienceBeanArrayList.get(getEditedPositionForWorkExperience).getOrganisation());
        edtDesignationWorkEditView.setText(workExperienceBeanArrayList.get(getEditedPositionForWorkExperience).getDesignation());
        edtJobProfileWorkEditView.setText(workExperienceBeanArrayList.get(getEditedPositionForWorkExperience).getJobProfile());
        edtDurationWorkEditView.setText(workExperienceBeanArrayList.get(getEditedPositionForWorkExperience).getDuration());


        //----(Dismiss popup)-----//
        txtCacelWorkExperienceEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });

        //----(Delet selected view from list)-----//
        txtDeleteWorkExperienceEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openWorkExperienceDeleteItemDialog(getEditedPositionForWorkExperience);
                mAlertDialog.dismiss();


            }
        });
        //----(Dismiss popup)-----//
        txtUpdateWorkExperienceEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert furniture data in to database
                if (checkValidationWorkExperienceEditView()) {

                    mDatabaseHelper.updateWorkExperienceList(
                            workExperienceBeanArrayList.get(getEditedPositionForWorkExperience).getId(), //1
                            edtNameOfOrganisationWorkEditView.getText().toString(), //2
                            edtDesignationWorkEditView.getText().toString(), //3
                            edtJobProfileWorkEditView.getText().toString(), //4
                            edtDurationWorkEditView.getText().toString(), //5
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)) //6
                    );


                    // reset dynamic view
                    dislayWorkExperienceData(false);
                    mAlertDialog.dismiss();
                }

            }

            private boolean checkValidationWorkExperienceEditView() {

                if (edtNameOfOrganisationWorkEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterOrganisationName));
                    edtNameOfOrganisationWorkEditView.requestFocus();
                    return false;
                } else if (edtDesignationWorkEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterDesignation));
                    edtDesignationWorkEditView.requestFocus();
                    return false;
                } else if (edtJobProfileWorkEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterJobProfile));
                    edtJobProfileWorkEditView.requestFocus();
                    return false;
                } else if (edtDurationWorkEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterDuration));
                    edtDurationWorkEditView.requestFocus();
                    return false;
                } else if (edtDurationWorkEditView.getText().toString().length()>0 && Integer.parseInt(edtDurationWorkEditView.getText().toString()) == 0) {
                    CommonMethods.displayToast(mActivity, getResources().getString(R.string.strEnterDurationValid));
                    edtDurationWorkEditView.requestFocus();
                    return false;
                } else {
                    return true;
                }

            }
        });


        mAlertDialog.show();


    }

    private void openWorkExperienceDeleteItemDialog(final Integer getEditedPositionForWorkExperience) {

        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_remove_view_dialog, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();
        TextView txtUsername = (TextView) dialogView.findViewById(R.id.txtUsername);
        TextView txtRemove = (TextView) dialogView.findViewById(R.id.txtRemove);
        txtUsername.setText(getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        txtRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteWorkExperienceByItemID(workExperienceBeanArrayList.get(getEditedPositionForWorkExperience).getId());
                dislayWorkExperienceData(false);
                mAlertDialog.dismiss();
            }
        });


        mAlertDialog.show();
    }

    private void saveAllChanges() {


        mDatabaseHelper.deleteEntrepreneurEduJobRegistration(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));

        mDatabaseHelper.insertEntrepreneurEduJobRegistration(
                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)),//1
                new Gson().toJson(educationalQualificationBeanArrayList),//2
                new Gson().toJson(specialTrainingBeanArrayList),//3
                new Gson().toJson(workExperienceBeanArrayList)//4
        );

        CommonMethods.displayToast(mContext, getResources().getString(R.string.strDataSavedSuccesfully));

        //move to enterpreneur details screen.
        navController.popBackStack(R.id.enterprenuerDetails, false);


    }


}

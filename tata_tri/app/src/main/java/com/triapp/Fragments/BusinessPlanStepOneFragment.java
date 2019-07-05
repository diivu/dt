package com.triapp.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.triapp.Adapter.VillageListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.Models.SaveEnterpriseModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class BusinessPlanStepOneFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, DatePickerDialog.OnDateSetListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "BusinessPlanStep1";

    private static final String SECTION_NUMBER = "sectionNumber";
    private static final String ENTERPRENUER_ID = "enterprenuerID";
    private static final String TYPE_OF_ENTERPRISE = "typeOfEnterprise";


    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtSubmitt, txtIsGovtLisance, txtTitleOwnershipStructure, txtTitleProductsDescription, txtTitleEnterpriseType, txtTitlePinCode, txtTitleAddress, txtTitleVillege, txtTitleBlock, txtTitleDistrict, txtTitleState, txtTitleNameOfUnit, txtMainView;
    private LinearLayout lineraGoveMentLicence, linearViewHideShow;
    private EditText edtGovtLicenseRegNo, edtGovtLicenseDate, edtOwnershipStructure, edtProductsDescription, edtEnterpriseType, edtPincode, edtAddressOfUnit, edtVillege, edtBlock, edtDistrict, edtState, edtNameOfUnit;
    private RadioGroup rgGovtLicense;
    private RadioButton rbtNotApplicable, rbtNo, rbtYes;
    private String strIsGovtLicence, strEnterpriseType;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<CreateEnterpreneurModel.DataBean> mEnterpreneurBeanList = new ArrayList<>();
    private Long lngVillegeID, lngBlockID, lngDistrictID, lngStateID;
    private Dialog dialogVillege;
    private ListView listVillege;
    private VillageListAdapter mVillageListAdapter;
    private DatePickerDialog mDatePickerDialog;
    private Long longGovermentLicenceDate = 0L;
    private ArrayList<SaveEnterpriseModel> saveEnterpriseModelArrayList;
    private boolean isStepOneAlreadySave = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public BusinessPlanStepOneFragment() {


    }

    public static BusinessPlanStepOneFragment newInstance(int sectionNumber, String strEnterprenuerID , String typeOfEnterprise) {
        BusinessPlanStepOneFragment fragment = new BusinessPlanStepOneFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        args.putString(ENTERPRENUER_ID, strEnterprenuerID);
        args.putString(TYPE_OF_ENTERPRISE, typeOfEnterprise);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.business_plan_step_one_fragment, container, false);

        setIds();
        setOnclicks();

        return mView;


    }


    @Override
    public void onResume() {
        super.onResume();
    }

    private void setIds() {

        //getArguments().getString(Constants.ENTERPRENEUR_ID)

        mActivity = getActivity();
        mContext = getActivity();

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtMainView = (TextView) mView.findViewById(R.id.txtMainView);
        txtTitleNameOfUnit = (TextView) mView.findViewById(R.id.txtTitleNameOfUnit);
        txtTitleState = (TextView) mView.findViewById(R.id.txtTitleState);
        txtTitleDistrict = (TextView) mView.findViewById(R.id.txtTitleDistrict);
        txtTitleBlock = (TextView) mView.findViewById(R.id.txtTitleBlock);
        txtTitleVillege = (TextView) mView.findViewById(R.id.txtTitleVillege);
        txtTitleAddress = (TextView) mView.findViewById(R.id.txtTitleAddress);
        txtTitlePinCode = (TextView) mView.findViewById(R.id.txtTitlePinCode);
        txtTitleEnterpriseType = (TextView) mView.findViewById(R.id.txtTitleEnterpriseType);
        txtTitleProductsDescription = (TextView) mView.findViewById(R.id.txtTitleProductsDescription);
        txtTitleOwnershipStructure = (TextView) mView.findViewById(R.id.txtTitleOwnershipStructure);
        txtIsGovtLisance = (TextView) mView.findViewById(R.id.txtIsGovtLisance);
        txtSubmitt = (TextView) mView.findViewById(R.id.txtSubmitt);

        edtNameOfUnit = (EditText) mView.findViewById(R.id.edtNameOfUnit);
        edtState = (EditText) mView.findViewById(R.id.edtState);
        edtDistrict = (EditText) mView.findViewById(R.id.edtDistrict);
        edtBlock = (EditText) mView.findViewById(R.id.edtBlock);
        edtVillege = (EditText) mView.findViewById(R.id.edtVillege);
        edtAddressOfUnit = (EditText) mView.findViewById(R.id.edtAddressOfUnit);
        edtPincode = (EditText) mView.findViewById(R.id.edtPincode);
        edtEnterpriseType = (EditText) mView.findViewById(R.id.edtEnterpriseType);
        edtProductsDescription = (EditText) mView.findViewById(R.id.edtProductsDescription);
        edtOwnershipStructure = (EditText) mView.findViewById(R.id.edtOwnershipStructure);
        edtGovtLicenseDate = (EditText) mView.findViewById(R.id.edtGovtLicenseDate);
        edtGovtLicenseRegNo = (EditText) mView.findViewById(R.id.edtGovtLicenseRegNo);

        rgGovtLicense = (RadioGroup) mView.findViewById(R.id.rgGovtLicense);
        rbtYes = (RadioButton) mView.findViewById(R.id.rbtYes);
        rbtNo = (RadioButton) mView.findViewById(R.id.rbtNo);
        rbtNotApplicable = (RadioButton) mView.findViewById(R.id.rbtNotApplicable);

        linearViewHideShow = (LinearLayout) mView.findViewById(R.id.linearViewHideShow);
        lineraGoveMentLicence = (LinearLayout) mView.findViewById(R.id.lineraGoveMentLicence);

        //SET TITLE TO MENDETORY FIELDS
        txtTitleNameOfUnit.setText(CommonMethods.spannableString(getResources().getString(R.string.strNameOfUnit)));
        txtTitleVillege.setText(CommonMethods.spannableString(getResources().getString(R.string.strVillage)));
        txtTitleAddress.setText(CommonMethods.spannableString(getResources().getString(R.string.strAddressOfUnit)));
        txtTitleEnterpriseType.setText(CommonMethods.spannableString(getResources().getString(R.string.strType)));
        txtTitleProductsDescription.setText(CommonMethods.spannableString(getResources().getString(R.string.strDiscription)));
        txtTitleOwnershipStructure.setText(CommonMethods.spannableString(getResources().getString(R.string.strOwnershipStructure)));

        //SET DEFAULT VALUE
        strIsGovtLicence = getActivity().getResources().getString(R.string.strNotApplicable);

        //MAKE OFF-LINE BUSINESS PLAN ID
        //IT SHOULD BE UNIQUE AND CREATE NEW FOR EVERY BUSINESS PLAN
        mSessionManager.updatePreferenceString(Constants.BUSINESS_PLAN_ID, "" + (String.valueOf(mSessionManager.getPreferenceInt(Constants.USER_ID)).length() - 1) + getArguments().getString(Constants.ENTERPRENEUR_ID));
        //  Log.e(TAG, "BUSINESS ID : "+mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID));


        //GET PRE- REGISTERED ENTERPRENUER DATA
        mEnterpreneurBeanList = mDatabaseHelper.getEnterpreneurList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));

        //GET DATA FROM BEAN LIST
        lngStateID = mEnterpreneurBeanList.get(0).getStateID();
        lngDistrictID = mEnterpreneurBeanList.get(0).getDistrictID();
        lngBlockID = mEnterpreneurBeanList.get(0).getBlockID();
        lngVillegeID = mEnterpreneurBeanList.get(0).getVillegeID();

        //SET DAFALULT VALUES FROM DATA
        if (mEnterpreneurBeanList.get(0).getEnterpriseType().equalsIgnoreCase("1")) {
            edtNameOfUnit.setText("" + mEnterpreneurBeanList.get(0).getNameOfEntereprise());
        } else {
            edtNameOfUnit.setText("");
        }

        edtState.setText("" + mDatabaseHelper.getStateDataFromStateID(lngStateID).get(0).getStrStateName());
        edtDistrict.setText("" + mDatabaseHelper.getDistrinctDataFromID(lngDistrictID).get(0).getStrDistrictName());
        edtBlock.setText("" + mDatabaseHelper.getBlockDataFromID(lngBlockID).get(0).getBlockName());
       // edtEnterpriseType.setText("" + mEnterpreneurBeanList.get(0).getTypeOfEnterprise());
        edtProductsDescription.setText("" + mEnterpreneurBeanList.get(0).getDescription());
        edtOwnershipStructure.setText(getResources().getString(R.string.strIndividual));
        edtEnterpriseType.setText(getArguments().getString(Constants.TYPE_OF_ENTERPRISE));


        //CHECK IF BUSINESS PLAN STEP 1 IS ALREADY FILLED BY USER
        saveEnterpriseModelArrayList = mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
        if (saveEnterpriseModelArrayList.size() != 0) {

            isStepOneAlreadySave = true;

            edtNameOfUnit.setText(saveEnterpriseModelArrayList.get(0).getNameOfUnit());
            edtState.setText("" + mDatabaseHelper.getStateDataFromStateID(lngStateID).get(0).getStrStateName());
            edtDistrict.setText("" + mDatabaseHelper.getDistrinctDataFromID(lngDistrictID).get(0).getStrDistrictName());
            edtBlock.setText("" + mDatabaseHelper.getBlockDataFromID(lngBlockID).get(0).getBlockName());
            edtVillege.setText("" + mDatabaseHelper.getVillegeDataFromID(saveEnterpriseModelArrayList.get(0).getVillageId()).get(0).getVillegeName());
            edtAddressOfUnit.setText("" + saveEnterpriseModelArrayList.get(0).getAddressOfUnit());
            edtPincode.setText("" + saveEnterpriseModelArrayList.get(0).getPincode());
            edtEnterpriseType.setText("" + saveEnterpriseModelArrayList.get(0).getType());
            edtProductsDescription.setText("" + saveEnterpriseModelArrayList.get(0).getSector());

            // CHECK OWNERSHIP STRUCTURE
            if (String.valueOf(saveEnterpriseModelArrayList.get(0).getNatureOfUnitId()).equalsIgnoreCase("1")) {
                edtOwnershipStructure.setText("" + getResources().getString(R.string.strIndividual));
            }

            //CHECK IF GOVT LICENCE IS AVAILABLE OR NOT
            if (saveEnterpriseModelArrayList.get(0).getGovtLicense().equalsIgnoreCase(getActivity().getResources().getString(R.string.strYes))) {

                strIsGovtLicence = getActivity().getResources().getString(R.string.strYes);

                rbtYes.setChecked(true);
                rbtNo.setChecked(false);
                rbtNotApplicable.setChecked(false);

                lineraGoveMentLicence.setVisibility(View.VISIBLE);

                if (saveEnterpriseModelArrayList.get(0).getLicenseDate() != 0) {
                    edtGovtLicenseDate.setText(new SimpleDateFormat(Constants.COMMON_DATE_FORMAT).format(new Date(saveEnterpriseModelArrayList.get(0).getLicenseDate())));
                }
                if (!saveEnterpriseModelArrayList.get(0).getRegisterNo().isEmpty()) {
                    edtGovtLicenseRegNo.setText(saveEnterpriseModelArrayList.get(0).getRegisterNo());
                }

            } else if (saveEnterpriseModelArrayList.get(0).getGovtLicense().equalsIgnoreCase(getActivity().getResources().getString(R.string.strNo))) {

                strIsGovtLicence = getActivity().getResources().getString(R.string.strNo);

                rbtYes.setChecked(false);
                rbtNo.setChecked(true);
                rbtNotApplicable.setChecked(false);

                lineraGoveMentLicence.setVisibility(View.GONE);

                edtGovtLicenseDate.setText("");
                edtGovtLicenseRegNo.setText("");
            } else {

                strIsGovtLicence = getActivity().getResources().getString(R.string.strNotApplicable);

                rbtYes.setChecked(false);
                rbtNo.setChecked(false);
                rbtNotApplicable.setChecked(true);

                lineraGoveMentLicence.setVisibility(View.GONE);

                edtGovtLicenseDate.setText("");
                edtGovtLicenseRegNo.setText("");
            }

            //Make View Not Clickble if Business Plan is already Saved.
            setAllItemsNotClickble();

        }


    }

    private void setOnclicks() {

        txtMainView.setOnClickListener(this);

        //CHECK IF BUSINESS PLAN STEP ONE IS ALREADY SAVED
        if(!isStepOneAlreadySave){
            txtSubmitt.setOnClickListener(this);
            edtVillege.setOnClickListener(this);
           // edtEnterpriseType.setOnClickListener(this);
            edtGovtLicenseDate.setOnClickListener(this);

            //SET RADIO BUTTON CLICKS
            rgGovtLicense.setOnCheckedChangeListener(this);

        }

    }

    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtMainView:

                //HIDE SHOW LAYOUT AS PER OPEN CLOSE VIEW
                if (linearViewHideShow.getVisibility() == View.VISIBLE) {
                    linearViewHideShow.setVisibility(View.GONE);
                } else {
                    linearViewHideShow.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.edtVillege:

                openVillageListDialog();

                break;
            case R.id.edtEnterpriseType:

                openEnterpriseTypeDialog();

                break;
            case R.id.edtGovtLicenseDate:

                openGovermentLicenceDateDialog();

                break;
            case R.id.txtSubmitt:

                if (checkValidation()) {

                    openDataSaveWarningDialog();

                }

                break;
        }

    }
    private void setAllItemsNotClickble() {

        isStepOneAlreadySave = true;

        edtNameOfUnit.setFocusableInTouchMode(false);
        edtState.setFocusableInTouchMode(false);
        edtDistrict.setFocusableInTouchMode(false);
        edtBlock.setFocusableInTouchMode(false);
        edtVillege.setFocusableInTouchMode(false);
        edtAddressOfUnit.setFocusableInTouchMode(false);
        edtPincode.setFocusableInTouchMode(false);
        edtEnterpriseType.setFocusableInTouchMode(false);
        edtProductsDescription.setFocusableInTouchMode(false);
        edtOwnershipStructure.setFocusableInTouchMode(false);
        edtGovtLicenseDate.setFocusableInTouchMode(false);
        edtGovtLicenseRegNo.setFocusableInTouchMode(false);


        rbtYes.setClickable(false);
        rbtNo.setClickable(false);
        rbtNotApplicable.setClickable(false);

        txtSubmitt.setVisibility(View.GONE);


    }

    private void openDataSaveWarningDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.business_plan_step_one_warning_dailog, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog mAlertDialog = dialogBuilder.create();
        TextView txtConfirm = (TextView) dialogView.findViewById(R.id.txtConfirm);
        TextView txtCancel = (TextView) dialogView.findViewById(R.id.txtCancel);
        TextView username = (TextView) dialogView.findViewById(R.id.username);

        username.setText(getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");


        txtConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveBusinessPlanStepOne();
                mAlertDialog.dismiss();
            }
        });

        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();
            }
        });
        mAlertDialog.show();

    }

    private void saveBusinessPlanStepOne() {

        //NATURE OF UNIT ID MEANS OWNERSHIP STRUCTURE
        //CURRENTLY WE ARE SET DEFAULT INDIVIDUAL
        //1 = INDIVIDUAL, 2 = GROUP
        Long ownershipID = 1L;

        mDatabaseHelper.insertEntrepreneurBP_1_0_step(
                edtNameOfUnit.getText().toString(),//1
                edtAddressOfUnit.getText().toString(),//2
                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)),//3
                Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//4 --> BusinessPlanId
                ownershipID,//5
                strIsGovtLicence,//6
                edtPincode.getText().toString(),//7
                lngStateID,//8
                lngDistrictID,//9
                lngBlockID,//10
                lngVillegeID,//11
                longGovermentLicenceDate,//12
                edtGovtLicenseRegNo.getText().toString(),//13
                edtEnterpriseType.getText().toString(),//14
                edtProductsDescription.getText().toString(),//15
                System.currentTimeMillis(),//16
                0,//17
                1,
                0,
                0);//18//Sync Status 1 = offline 2 = sync on web

        //Data Save success
        CommonMethods.displayToast(mContext, getResources().getString(R.string.strDataSavedSuccesfully));

        //Make View Not Clickble if Business Plan is already Saved.
        setAllItemsNotClickble();

        //UPDATE BUSINESS PLAN STATUS IN ENTERPRENUER LIST
        //1- MEANS BUSINESS PLAN STEP ONE SUBMITED SUCCESSFULLY
        mDatabaseHelper.updateEnterpreneurBusinessPlansCreattatus(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)) ,1);

        //UPDATE FLAG IN STEP ONE ENTRY
        mDatabaseHelper.updateEntrepreneurBP_1_0_step(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)),1 );


    }

    private void openGovermentLicenceDateDialog() {

        DateFormat format = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);

        Calendar calenderToDate = Calendar.getInstance();
        Calendar calenderFromDate = Calendar.getInstance();

        mDatePickerDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(this,
                calenderToDate.get(Calendar.YEAR),
                calenderToDate.get(Calendar.MONTH),
                calenderToDate.get(Calendar.DAY_OF_MONTH)
        );
        mDatePickerDialog.setMaxDate(calenderToDate);
        mDatePickerDialog.setCancelColor(Color.BLACK);
        mDatePickerDialog.setOkColor(Color.BLACK);
        mDatePickerDialog.show(getActivity().getFragmentManager(), "Datepickerdialog");

    }

    private void openEnterpriseTypeDialog() {

        final Dialog dialogEnterpriseType = new Dialog(getActivity(), R.style.listDialog);
        dialogEnterpriseType.setContentView(R.layout.dialog_enterprisetype);

        RadioGroup rgEnterpriseType = (RadioGroup) dialogEnterpriseType.findViewById(R.id.rgEnterpriseType);
        RadioButton rbtnManufacturing = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnManufacturing);
        RadioButton rbtnTrading = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnTrading);
        RadioButton rbtnOther = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnOther);

        if (!(edtEnterpriseType.getText().toString().isEmpty())) {

            if (edtEnterpriseType.getText().toString().equals(getResources().getString(R.string.strMenufacturing))) {
                rbtnManufacturing.setChecked(true);
                rbtnTrading.setChecked(false);
                rbtnOther.setChecked(false);

            } else if (edtEnterpriseType.getText().toString().equals(getResources().getString(R.string.strTrading))) {
                rbtnTrading.setChecked(true);
                rbtnManufacturing.setChecked(false);
                rbtnOther.setChecked(false);

            } else if (edtEnterpriseType.getText().toString().equals(getResources().getString(R.string.strService))) {
                rbtnOther.setChecked(true);
                rbtnManufacturing.setChecked(false);
                rbtnTrading.setChecked(false);

            }
        } else {
            rbtnManufacturing.setChecked(false);
            rbtnTrading.setChecked(false);
            rbtnOther.setChecked(false);

        }


        rgEnterpriseType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                        strEnterpriseType = btn.getText().toString();
                        edtEnterpriseType.setText(strEnterpriseType);

                        //CLEAR PRODUCT DESCRIPTION IF ENTERPRISE TYPE CHANGE
                        edtProductsDescription.setText("");
                        dialogEnterpriseType.dismiss();
                    }
                }
            }
        });

        dialogEnterpriseType.setCancelable(true);
        dialogEnterpriseType.show();

    }

    private void openVillageListDialog() {

        dialogVillege = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogVillege.setContentView(R.layout.general_list_search_dialog);

        dialogVillege.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogVillege.findViewById(R.id.imgBack);
        SearchView edtSearchView = (SearchView) dialogVillege.findViewById(R.id.edtSearchItem);

        int id = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) edtSearchView.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterVillegeName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setTextSize(14);

        int id1 = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View v1 = edtSearchView.findViewById(id1);
        v1.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) edtSearchView.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listVillege = (ListView) dialogVillege.findViewById(R.id.listItems);
        mVillageListAdapter = new VillageListAdapter(mContext, mDatabaseHelper.getVillegeListFromBlockCode(lngBlockID));
        listVillege.setAdapter(mVillageListAdapter);

        edtSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mVillageListAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listVillege.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogVillege.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();
                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                edtVillege.setText(strCasteFromSelection);
                lngVillegeID = Long.valueOf(tvStateId.getText().toString());

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogVillege.dismiss();
            }
        });

        dialogVillege.setCanceledOnTouchOutside(false);
        dialogVillege.setCancelable(true);
        dialogVillege.show();

    }

    private boolean checkValidation() {

        if (edtNameOfUnit.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterNameOfUnit));
            edtNameOfUnit.requestFocus();
            return false;
        } else if (edtVillege.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterVillageAtBP));
            edtVillege.requestFocus();
            return false;
        } else if (edtAddressOfUnit.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterAddressOfUnit));
            edtAddressOfUnit.requestFocus();
            return false;
        } else if (!edtPincode.getText().toString().isEmpty() && edtPincode.length() < 6) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnter6DigitPincode));
            edtPincode.requestFocus();
            return false;
        } else if (!edtPincode.getText().toString().isEmpty() && !(edtPincode.length() < 6) && edtPincode.getText().toString().equals("000000")) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnter6DigitPincodeValid));
            edtPincode.requestFocus();
            return false;
        } else if (edtEnterpriseType.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterTypeOfUnit));
            edtEnterpriseType.requestFocus();
            return false;
        } else if (edtProductsDescription.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strValidationEnterDescription));
            edtProductsDescription.requestFocus();
            return false;
        } else if (!edtGovtLicenseRegNo.getText().toString().isEmpty() && Double.valueOf(edtGovtLicenseRegNo.getText().toString()) == 0.0) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorEnterGovRegNoValid));
            edtGovtLicenseRegNo.requestFocus();
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        int childCount = radioGroup.getChildCount();
        for (int x = 0; x < childCount; x++) {
            RadioButton btn = (RadioButton) radioGroup.getChildAt(x);
            if (btn.getId() == checkedId) {
                strIsGovtLicence = btn.getText().toString();
                if (strIsGovtLicence.equalsIgnoreCase(getActivity().getResources().getString(R.string.strYes))) {
                    lineraGoveMentLicence.setVisibility(View.VISIBLE);
                } else {
                    lineraGoveMentLicence.setVisibility(View.GONE);

                    //CLEAR DATA
                    edtGovtLicenseDate.setText("");
                    edtGovtLicenseRegNo.setText("");
                }

            }
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        edtGovtLicenseDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        longGovermentLicenceDate = CommonMethods.getLongDateFromStringDate(edtGovtLicenseDate.getText().toString());
    }
}

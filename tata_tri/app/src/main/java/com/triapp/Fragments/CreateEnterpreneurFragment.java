package com.triapp.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.triapp.Activities.MainActivity;
import com.triapp.Adapter.BlockListAdapter;
import com.triapp.Adapter.CasteAdapter;
import com.triapp.Adapter.CurrentIncomeListAdapter;
import com.triapp.Adapter.DistrictListAdapter;
import com.triapp.Adapter.ExpectedIncomeListAdapter;
import com.triapp.Adapter.ReligionAdapter;
import com.triapp.Adapter.StateListAdapter;
import com.triapp.Adapter.VillageListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class CreateEnterpreneurFragment extends Fragment implements View.OnClickListener, com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "CreateEnterpreneurFragment";

    private View mView;

    public NavController navController;

    private SessionManager mSessionManager;
    private TextView txtTitleParticipantName,txtTitleEventName,txtTitleParticipatedInCMREEvent,txtSubmitData, txtTitleMaritalStatus, txtTitleIFSCcode, txtTitleBranchName, txtTitleBankName, txtTitleBankAccountNo, txtTitlePanNo, txtTitleAddharNo, txtTitlePincode, txtTitleResidentAddress, txtTitleVillege, txtTitleGrampunchayat, txtTitleblock, txtTitleDistrict, txtTitleState, txtTitleNoOfDependent,txtTitleSocialCategory, txtTitleEmailId, txtTitleSelectGender, txtTitleDateOfBirth, txtTitleLastName, txtTitleMiddleName, txtTitleFirstName, txtMoreInfoAboutEnterprise, txtTitleTypeOfEnterprise, txtTitleNameOFenterprise, txtTitlExistingOrNew;
    private EditText edtParticipantName,edtEventName,edtNoOfDependent, edtMaritalStatus, edtIFSCcode, edtBranchName, edtBankName, edtBankAccountNo, edtPanNo, edtAdharNo, edtPincode, edtResidentAddress, edtVillege, edtGrampunchayat, edtblock, edtDistrict, edtState, edtSocialCategory, edtEmailId, edtSelectGender, edtDateOfBirth, edtLastName, edtMiddleName, edtFirstName, edtTypeOfEnterprise, edtMoreInfoAboutEnterprise, edtNameOfEnterprise;
    private LinearLayout linearParticipatedInCMREEvent,linearExisting;
    private RadioGroup rgParticipatedInCMREEvent,rgExistingOrNew;
    private RadioButton rbtnNo,rbtnYes,rbtnNew, rbtnExiting;
    private com.wdullaer.materialdatetimepicker.date.DatePickerDialog mDatePickerDialog;
    private String strSelectedRadioGender, strMaritalStatus, strEnterpriseType, strExistingOrNew , strEventAttained;
    private Dialog dialogCaste, dialogReligion, dialogState, dialogDistrict, dialogBlock, dialogVillege, dialogExpectedIncome, dialogCurrenIncome;
    private ListView listBlock, listRelegion, listCast, listState, listDistrict, listVillege, listExpectedIncome, listCurrentIncome;
    private ReligionAdapter religionAdapter;
    private DatabaseHelper mDatabaseHelper;
    private Long lngSocialCategoryID, lngStateID = 0L, lngDistrictID, lngBlockID, lngVillegeID;
    private DistrictListAdapter mDistrictListAdapter;
    private BlockListAdapter mBlockListAdapter;
    private VillageListAdapter mVillageListAdapter;
    private CasteAdapter casteAdapter;
    private StateListAdapter mStateListAdapter;
    private ExpectedIncomeListAdapter mExpectedIncomeListAdapter;
    private CurrentIncomeListAdapter mCurrentIncomeListAdapter;
    private ArrayList<CreateEnterpreneurModel.DataBean> mEnterpreneurBeanList = new ArrayList<>();
    private boolean isBusinessPlanSubmitted;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getArguments().getBoolean(Constants.IS_FOR_EDIT)) {
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strUpdateEnterpreneurData));
        } else {
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strCreatEnterpreneur));
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);

        mView = inflater.inflate(R.layout.creat_enterprenuer_fragment, container, false);

        setIds();
        setonClicks();
        return mView;


    }


    @Override
    public void onResume() {
        super.onResume();

    }

    private void setIds() {

        mActivity = getActivity();
        mContext = getActivity();

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


        //SET DEFAULT ENTERPRISE TYPE
        // 0 MEANS NEW AND 1 MEANS EXISTING
        strExistingOrNew = "0";
        strEnterpriseType = "";

        strEventAttained = getResources().getString(R.string.strNo);

        txtTitlExistingOrNew = (TextView) mView.findViewById(R.id.txtTitlExistingOrNew);
        txtTitleNameOFenterprise = (TextView) mView.findViewById(R.id.txtTitleNameOFenterprise);
        txtTitleTypeOfEnterprise = (TextView) mView.findViewById(R.id.txtTitleTypeOfEnterprise);
        txtMoreInfoAboutEnterprise = (TextView) mView.findViewById(R.id.txtMoreInfoAboutEnterprise);
        txtTitleFirstName = (TextView) mView.findViewById(R.id.txtTitleFirstName);
        txtTitleMiddleName = (TextView) mView.findViewById(R.id.txtTitleMiddleName);
        txtTitleLastName = (TextView) mView.findViewById(R.id.txtTitleLastName);
        txtTitleDateOfBirth = (TextView) mView.findViewById(R.id.txtTitleDateOfBirth);
        txtTitleSelectGender = (TextView) mView.findViewById(R.id.txtTitleSelectGender);
        txtTitleEmailId = (TextView) mView.findViewById(R.id.txtTitleEmailId);
        txtTitleSocialCategory = (TextView) mView.findViewById(R.id.txtTitleSocialCategory);
        txtTitleNoOfDependent = (TextView) mView.findViewById(R.id.txtTitleNoOfDependent);
        txtTitleState = (TextView) mView.findViewById(R.id.txtTitleState);
        txtTitleDistrict = (TextView) mView.findViewById(R.id.txtTitleDistrict);
        txtTitleblock = (TextView) mView.findViewById(R.id.txtTitleblock);
        txtTitleVillege = (TextView) mView.findViewById(R.id.txtTitleVillege);
        txtTitleResidentAddress = (TextView) mView.findViewById(R.id.txtTitleResidentAddress);
        txtTitlePincode = (TextView) mView.findViewById(R.id.txtTitlePincode);
        txtTitleAddharNo = (TextView) mView.findViewById(R.id.txtTitleAddharNo);
        txtTitlePanNo = (TextView) mView.findViewById(R.id.txtTitlePanNo);
        txtTitleBankAccountNo = (TextView) mView.findViewById(R.id.txtTitleBankAccountNo);
        txtTitleBankName = (TextView) mView.findViewById(R.id.txtTitleBankName);
        txtTitleBranchName = (TextView) mView.findViewById(R.id.txtTitleBranchName);
        txtTitleIFSCcode = (TextView) mView.findViewById(R.id.txtTitleIFSCcode);
        txtTitleMaritalStatus = (TextView) mView.findViewById(R.id.txtTitleMaritalStatus);
        txtSubmitData = (TextView) mView.findViewById(R.id.txtSubmitData);
        txtTitleParticipatedInCMREEvent = (TextView) mView.findViewById(R.id.txtTitleParticipatedInCMREEvent);
        txtTitleEventName = (TextView) mView.findViewById(R.id.txtTitleEventName);
        txtTitleParticipantName = (TextView) mView.findViewById(R.id.txtTitleParticipantName);


        edtNameOfEnterprise = (EditText) mView.findViewById(R.id.edtNameOfEnterprise);
        edtTypeOfEnterprise = (EditText) mView.findViewById(R.id.edtTypeOfEnterprise);
        edtMoreInfoAboutEnterprise = (EditText) mView.findViewById(R.id.edtMoreInfoAboutEnterprise);
        edtFirstName = (EditText) mView.findViewById(R.id.edtFirstName);
        edtMiddleName = (EditText) mView.findViewById(R.id.edtMiddleName);
        edtLastName = (EditText) mView.findViewById(R.id.edtLastName);
        edtDateOfBirth = (EditText) mView.findViewById(R.id.edtDateOfBirth);
        edtSelectGender = (EditText) mView.findViewById(R.id.edtSelectGender);
        edtEmailId = (EditText) mView.findViewById(R.id.edtEmailId);
        edtSocialCategory = (EditText) mView.findViewById(R.id.edtSocialCategory);
        edtState = (EditText) mView.findViewById(R.id.edtState);
        edtDistrict = (EditText) mView.findViewById(R.id.edtDistrict);
        edtblock = (EditText) mView.findViewById(R.id.edtblock);
        edtVillege = (EditText) mView.findViewById(R.id.edtVillege);
        edtResidentAddress = (EditText) mView.findViewById(R.id.edtResidentAddress);
        edtPincode = (EditText) mView.findViewById(R.id.edtPincode);
        edtAdharNo = (EditText) mView.findViewById(R.id.edtAdharNo);
        edtPanNo = (EditText) mView.findViewById(R.id.edtPanNo);
        edtBankAccountNo = (EditText) mView.findViewById(R.id.edtBankAccountNo);
        edtBankName = (EditText) mView.findViewById(R.id.edtBankName);
        edtBranchName = (EditText) mView.findViewById(R.id.edtBranchName);
        edtIFSCcode = (EditText) mView.findViewById(R.id.edtIFSCcode);
        edtMaritalStatus = (EditText) mView.findViewById(R.id.edtMaritalStatus);
        edtNoOfDependent = (EditText) mView.findViewById(R.id.edtNoOfDependent);
        edtEventName = (EditText) mView.findViewById(R.id.edtEventName);
        edtParticipantName = (EditText) mView.findViewById(R.id.edtParticipantName);

        linearExisting = (LinearLayout) mView.findViewById(R.id.linearExisting);
        linearParticipatedInCMREEvent = (LinearLayout) mView.findViewById(R.id.linearParticipatedInCMREEvent);

        rgExistingOrNew = (RadioGroup) mView.findViewById(R.id.rgExistingOrNew);
        rbtnExiting = (RadioButton) mView.findViewById(R.id.rbtnExiting);
        rbtnNew = (RadioButton) mView.findViewById(R.id.rbtnNew);

        rgParticipatedInCMREEvent = (RadioGroup) mView.findViewById(R.id.rgParticipatedInCMREEvent);
        rbtnYes = (RadioButton) mView.findViewById(R.id.rbtnYes);
        rbtnNo = (RadioButton) mView.findViewById(R.id.rbtnNo);


        //Set mendetory field
        txtTitlExistingOrNew.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseType)));
        txtTitleNameOFenterprise.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseName)));
        txtTitleTypeOfEnterprise.setText(CommonMethods.spannableString(getResources().getString(R.string.strTypeOfEnterprise)));
        txtMoreInfoAboutEnterprise.setText(CommonMethods.spannableString(getResources().getString(R.string.strMoreDescripptionAboutEnterprise)));
        txtTitleFirstName.setText(CommonMethods.spannableString(getResources().getString(R.string.strFirstName)));
        txtTitleDateOfBirth.setText(CommonMethods.spannableString(getResources().getString(R.string.strDateOfBirth)));
        txtTitleSelectGender.setText(CommonMethods.spannableString(getResources().getString(R.string.strSelectGender)));
        txtTitleSocialCategory.setText(CommonMethods.spannableString(getResources().getString(R.string.strSocialCategory)));
        txtTitleState.setText(CommonMethods.spannableString(getResources().getString(R.string.strState)));
        txtTitleDistrict.setText(CommonMethods.spannableString(getResources().getString(R.string.strDistrict)));
        txtTitleblock.setText(CommonMethods.spannableString(getResources().getString(R.string.strBlock)));
        txtTitleVillege.setText(CommonMethods.spannableString(getResources().getString(R.string.strSelectVillege)));
        txtTitleResidentAddress.setText(CommonMethods.spannableString(getResources().getString(R.string.strResidentAddress)));
        txtTitlePincode.setText(CommonMethods.spannableString(getResources().getString(R.string.strPincode)));
        txtTitleMaritalStatus.setText(CommonMethods.spannableString(getResources().getString(R.string.strMaritalStatus)));
        txtTitleNoOfDependent.setText(CommonMethods.spannableString(getResources().getString(R.string.strNoOfDependent)));
        txtTitleParticipatedInCMREEvent.setText(CommonMethods.spannableString(getResources().getString(R.string.strParticipateInCMER)));
        txtTitleEventName.setText(CommonMethods.spannableString(getResources().getString(R.string.strEventName)));
        txtTitleParticipantName.setText(CommonMethods.spannableString(getResources().getString(R.string.strParticipantName)));

        //SET DAFAULT STATE, DISTRICT, AND BLOCK NAME
        edtState.setText(""+mDatabaseHelper.getStateList().get(0).getStrStateName());
        edtDistrict.setText(""+mDatabaseHelper.getDistrictListAll().get(0).getStrDistrictName());
        edtblock.setText(""+mDatabaseHelper.getBlockListALL().get(0).getBlockName());

        lngStateID = mDatabaseHelper.getStateList().get(0).getIntStateID();
        lngDistrictID =  mDatabaseHelper.getDistrictListAll().get(0).getIntDistrinctID();
        lngBlockID =  mDatabaseHelper.getBlockListALL().get(0).getBlockId();

        //Set radiogroup selection
        rgExistingOrNew.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton rbtn = (RadioButton) group.getChildAt(x);
                    if (rbtn.getId() == checkedId) {
                        if (rbtn.getText().toString().equalsIgnoreCase(getResources().getString(R.string.strExisting))) {
                            linearExisting.setVisibility(View.VISIBLE);
                            strExistingOrNew = "1";
                        } else {
                            linearExisting.setVisibility(View.GONE);
                            strExistingOrNew = "0";

                            //IF ENTERPRISE TYPE IS NEW THEN ALL CLEAR ALL ENTERPRISE RELATED DATA
                            edtNameOfEnterprise.setText("");
                            edtTypeOfEnterprise.setText("");
                            edtMoreInfoAboutEnterprise.setText("");

                        }


                    }
                }
            }
        });

        rgParticipatedInCMREEvent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton rbtn = (RadioButton) group.getChildAt(x);
                    if (rbtn.getId() == checkedId) {
                        if (rbtn.getText().toString().equalsIgnoreCase(getResources().getString(R.string.strYes))) {
                            linearParticipatedInCMREEvent.setVisibility(View.VISIBLE);
                            strEventAttained = getResources().getString(R.string.strYes);
                        } else {
                            linearParticipatedInCMREEvent.setVisibility(View.GONE);
                            strEventAttained = getResources().getString(R.string.strNo);

                            //IF ENTERPRISE TYPE IS NEW THEN ALL CLEAR ALL ENTERPRISE RELATED DATA
                            edtEventName.setText("");
                            edtParticipantName.setText("");


                        }


                    }
                }
            }
        });


        //CHECK IF USER COME FOR EDIT DATA
        if (getArguments().getBoolean(Constants.IS_FOR_EDIT)) {

            //CHANGE BUTTON TEXT
            txtSubmitData.setText(mActivity.getResources().getString(R.string.strUpdate));

            //GET DATA FROM ENTERPRENENEUR ID
            mEnterpreneurBeanList = mDatabaseHelper.getEnterpreneurList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
            //UPDATE ENTERPRENEUR TRAINING DATA
            //CommonMethods.printLog("ENTERPRENEUR DATA : ", new Gson().toJson(mEnterpreneurBeanList));

            //SET DAFALULT VALUES FROM DATA
            //SET ENTERPRISE TYPE DATA
            if (mEnterpreneurBeanList.get(0).getEnterpriseType().equalsIgnoreCase("1")) {
                linearExisting.setVisibility(View.VISIBLE);
                strExistingOrNew = "1";

                rbtnExiting.setChecked(true);
                rbtnNew.setChecked(false);

                rbtnExiting.setClickable(false);
                rbtnNew.setClickable(false);


            } else {
                linearExisting.setVisibility(View.GONE);
                strExistingOrNew = "0";

                rbtnExiting.setChecked(false);
                rbtnNew.setChecked(true);

                rbtnExiting.setClickable(false);
                rbtnNew.setClickable(false);
            }


            //SET EVENT DATA
            if (mEnterpreneurBeanList.get(0).getIsEventeAttained().equalsIgnoreCase(getResources().getString(R.string.strYes))) {
                linearParticipatedInCMREEvent.setVisibility(View.VISIBLE);
                strEventAttained = getResources().getString(R.string.strYes);

                rbtnYes.setChecked(true);
                rbtnNo.setChecked(false);


            } else {
                linearParticipatedInCMREEvent.setVisibility(View.GONE);
                strEventAttained = getResources().getString(R.string.strNo);

                rbtnYes.setChecked(false);
                rbtnNo.setChecked(true);

            }

            //SET FIELD NOT EDITABLE
            edtNameOfEnterprise.setFocusableInTouchMode(false);
            edtTypeOfEnterprise.setFocusableInTouchMode(false);
            edtMoreInfoAboutEnterprise.setFocusableInTouchMode(false);


            //GET ALL IDS FROM
            lngSocialCategoryID = mEnterpreneurBeanList.get(0).getSocialCategoryID();
            lngStateID = mEnterpreneurBeanList.get(0).getStateID();
            lngDistrictID = mEnterpreneurBeanList.get(0).getDistrictID();
            lngBlockID = mEnterpreneurBeanList.get(0).getBlockID();
            lngVillegeID = mEnterpreneurBeanList.get(0).getVillegeID();

           /*CommonMethods.printLog("STATE DATA : ", new Gson().toJson(mDatabaseHelper.getStateDataFromStateID(lngStateID)));
            CommonMethods.printLog("DISTRICT DATA : ", new Gson().toJson(mDatabaseHelper.getDistrinctDataFromID(lngDistrictID)));
            CommonMethods.printLog("BLOCK DATA : ", new Gson().toJson(mDatabaseHelper.getBlockDataFromID(lngBlockID)));
            CommonMethods.printLog("VILLEGE DATA : ", new Gson().toJson(mDatabaseHelper.getVillegeDataFromID(lngVillegeID)));
            CommonMethods.printLog("RELIGION DATA : ", new Gson().toJson(mDatabaseHelper.getReligionDateFromID(lngReligionID)));
            CommonMethods.printLog("SOCIAL CATEGORY DATA : ", new Gson().toJson(mDatabaseHelper.getCastDataFromID(lngSocialCategoryID)));*/

            //SET ENTERPRENUER DATA
            edtNameOfEnterprise.setText("" + mEnterpreneurBeanList.get(0).getNameOfEntereprise());
            edtTypeOfEnterprise.setText("" + mEnterpreneurBeanList.get(0).getTypeOfEnterprise());
            edtMoreInfoAboutEnterprise.setText("" + mEnterpreneurBeanList.get(0).getDescription());
            edtFirstName.setText("" + mEnterpreneurBeanList.get(0).getFirstName());
            edtMiddleName.setText("" + mEnterpreneurBeanList.get(0).getMiddleName());
            edtLastName.setText("" + mEnterpreneurBeanList.get(0).getLastName());
            edtDateOfBirth.setText("" + CommonMethods.getDateFromLong(mEnterpreneurBeanList.get(0).getDateOfBirth()));
            edtSelectGender.setText("" + mEnterpreneurBeanList.get(0).getGender());
            edtEmailId.setText("" + mEnterpreneurBeanList.get(0).getEmailID());
            edtSocialCategory.setText("" + mDatabaseHelper.getCastDataFromID(lngSocialCategoryID).get(0).getCastName());
            edtState.setText("" + mDatabaseHelper.getStateDataFromStateID(lngStateID).get(0).getStrStateName());
            edtDistrict.setText("" + mDatabaseHelper.getDistrinctDataFromID(lngDistrictID).get(0).getStrDistrictName());
            edtblock.setText("" + mDatabaseHelper.getBlockDataFromID(lngBlockID).get(0).getBlockName());
            edtVillege.setText("" + mDatabaseHelper.getVillegeDataFromID(lngVillegeID).get(0).getVillegeName());
            edtResidentAddress.setText("" + mEnterpreneurBeanList.get(0).getResidenceAddress());
            edtPincode.setText("" + mEnterpreneurBeanList.get(0).getPinCode());
            edtAdharNo.setText("" + mEnterpreneurBeanList.get(0).getAadharNo());
            edtPanNo.setText("" + mEnterpreneurBeanList.get(0).getPanNo());
            edtBankAccountNo.setText("" + mEnterpreneurBeanList.get(0).getBankAccountNo());
            edtBankName.setText("" + mEnterpreneurBeanList.get(0).getBankName());
            edtBranchName.setText("" + mEnterpreneurBeanList.get(0).getBranchName());
            edtIFSCcode.setText("" + mEnterpreneurBeanList.get(0).getBankIFSCCode());
            edtMaritalStatus.setText("" + mEnterpreneurBeanList.get(0).getMaritalStatus());
            edtNoOfDependent.setText("" +mEnterpreneurBeanList.get(0).getNoOfDependent());
            edtEventName.setText("" +mEnterpreneurBeanList.get(0).getEventName());
            edtParticipantName.setText("" +mEnterpreneurBeanList.get(0).getParicipantName());


            //CHECK IF BUSINESS PLAN IS ALREADY SUBMITTED
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getIsBusinessPlanSubmited() == 1) {
                    isBusinessPlanSubmitted = true;
                }
            }

        }



        if (!isBusinessPlanSubmitted) {

            //AADHAR CARD VALIDATIONS
            edtAdharNo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        if (edtAdharNo.getText().toString().trim().length() > 0 && edtAdharNo.getText().toString().trim().length() < 12) {
                            CommonMethods.displayToast(mContext, getResources().getString(R.string.strPleaseAddProperAadhar));
                        }
                    } else {
                        if (edtAdharNo.getText().toString().trim().length() > 0 && edtAdharNo.getText().toString().trim().length() < 12) {
                            CommonMethods.displayToast(mContext, getResources().getString(R.string.strPleaseAddProperAadhar));
                        }
                    }

                }
            });
        }

    }


    private void setonClicks() {

            edtDateOfBirth.setOnClickListener(this);
            edtSelectGender.setOnClickListener(this);
            edtSocialCategory.setOnClickListener(this);
            edtVillege.setOnClickListener(this);
            edtMaritalStatus.setOnClickListener(this);
            txtSubmitData.setOnClickListener(this);

            //CHECK IF EDIT FLAG TRUE
            // IF FALSE = CLICK, TRUE = NO CLICK
            if (!getArguments().getBoolean(Constants.IS_FOR_EDIT)) {
                edtTypeOfEnterprise.setOnClickListener(this);
            }


        if (isBusinessPlanSubmitted) {
            txtSubmitData.setVisibility(View.GONE);
        }

    }


    @Override
    public void onClick(View mView) {


        switch (mView.getId()) {

            //openReligionDialog();
            //openCurrentIncomDialog();
            //openExpectedIncomDialog();

            case R.id.edtDateOfBirth:
                openDatePickerDialog();
                break;
            case R.id.edtSelectGender:
                openGenderDialog();
                break;
            case R.id.edtSocialCategory:
                openSocialCategoryDialog();
                break;
            case R.id.edtState:
                openStateListDialog();
                break;
            case R.id.edtDistrict:
                if (edtState.getText().toString().length() != 0) {
                    openDistrinctDialog();
                } else {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningSelectState));
                }

                break;
            case R.id.edtblock:
                if (edtDistrict.getText().toString().length() != 0) {
                    openBlockDialog();
                } else {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningSelectDistrict));
                }

                break;
            case R.id.edtVillege:
                if (edtblock.getText().toString().length() != 0) {
                    openVillegeListDialog();
                } else {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningSelectBlock));
                }
                break;

            case R.id.edtMaritalStatus:
                openMaritalStatusDialog();
                break;
            case R.id.edtTypeOfEnterprise:
                openEnterpriseTypeDialog();
                break;
            case R.id.txtSubmitData:

                if (checkValidation()) {

                    //Get Unique enterprenuer number from current millisecon's last four degit + user code
                    String strCurrentMilliSecond = String.valueOf(System.currentTimeMillis());
                    String strUniqueNumber = (strCurrentMilliSecond.substring(strCurrentMilliSecond.length() - 4) + String.valueOf(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)));

                    if (getArguments().getBoolean(Constants.IS_FOR_EDIT)) {

                        //UPDATE DATA IN TO DATABASE
                        mDatabaseHelper.updateCreatedEnterpreneurData(
                                mEnterpreneurBeanList.get(0).getEnterpreneurID(),
                                mEnterpreneurBeanList.get(0).getUserID(),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),
                                strExistingOrNew,
                                edtNameOfEnterprise.getText().toString(),
                                edtTypeOfEnterprise.getText().toString(),
                                edtMoreInfoAboutEnterprise.getText().toString(),
                                edtFirstName.getText().toString(),
                                edtMiddleName.getText().toString(),
                                edtLastName.getText().toString(),
                                CommonMethods.getLongDateFromStringDate(edtDateOfBirth.getText().toString()),
                                edtSelectGender.getText().toString(),
                                edtEmailId.getText().toString(),
                                lngSocialCategoryID,
                                lngStateID,
                                lngDistrictID,
                                lngBlockID,
                                lngVillegeID,
                                edtResidentAddress.getText().toString(),
                                edtPincode.getText().toString(),
                                edtAdharNo.getText().toString(),
                                edtPanNo.getText().toString(),
                                edtBankAccountNo.getText().toString(),
                                edtBankName.getText().toString(),
                                edtBranchName.getText().toString(),
                                edtIFSCcode.getText().toString(),
                                edtMaritalStatus.getText().toString(),
                                mEnterpreneurBeanList.get(0).getIsBusinessPlanCreated(),
                                mEnterpreneurBeanList.get(0).getIsBusinessPlanSubmitted(),
                                mEnterpreneurBeanList.get(0).getIsModelBusinessPlan(),
                                mEnterpreneurBeanList.get(0).getIsEnterpriseRegistred(),
                                edtFirstName.getText().toString() + " " + edtMiddleName.getText().toString() + " " + edtLastName.getText().toString(),
                                System.currentTimeMillis(),
                                Integer.valueOf(edtNoOfDependent.getText().toString()),
                                strEventAttained,
                                edtEventName.getText().toString(),
                                edtParticipantName.getText().toString());

                        //GET ENTERPRENEUR DATA
                        //CommonMethods.printLog("UPDATE ENTERPRENEUR DATA : ", new Gson().toJson(mDatabaseHelper.getEnterpreneurList(0L)));

                    } else {
                        //INSERT DATA IN TO DATABASE
                        mDatabaseHelper.insertCreateEnterpreneurData(
                                Long.valueOf(strUniqueNumber),
                                new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),
                                strExistingOrNew,
                                edtNameOfEnterprise.getText().toString(),
                                edtTypeOfEnterprise.getText().toString(),
                                edtMoreInfoAboutEnterprise.getText().toString(),
                                edtFirstName.getText().toString(),
                                edtMiddleName.getText().toString(),
                                edtLastName.getText().toString(),
                                CommonMethods.getLongDateFromStringDate(edtDateOfBirth.getText().toString()),
                                edtSelectGender.getText().toString(),
                                edtEmailId.getText().toString(),
                                lngSocialCategoryID,
                                lngStateID,
                                lngDistrictID,
                                lngBlockID,
                                lngVillegeID,
                                edtResidentAddress.getText().toString(),
                                edtPincode.getText().toString(),
                                edtAdharNo.getText().toString(),
                                edtPanNo.getText().toString(),
                                edtBankAccountNo.getText().toString(),
                                edtBankName.getText().toString(),
                                edtBranchName.getText().toString(),
                                edtIFSCcode.getText().toString(),
                                edtMaritalStatus.getText().toString(),
                                0,
                                0,
                                0,
                                0,
                                edtFirstName.getText().toString() + " " + edtMiddleName.getText().toString() + " " + edtLastName.getText().toString(),
                                System.currentTimeMillis(),
                                Integer.valueOf(edtNoOfDependent.getText().toString()),
                                strEventAttained,
                                edtEventName.getText().toString(),
                                edtParticipantName.getText().toString());
                    }

                    //Move to created enterpreneur list page
                    navController.popBackStack(R.id.registeredEnterpreneur, false);
                }
                break;


        }


    }

    private boolean checkValidation() {

        if (strExistingOrNew.length() == 0) {

            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationSelectEnterprisType));
            // CommonMethods.displayToast(mContext , "Please select enterprise type");
            return false;
        } else if (strExistingOrNew.equalsIgnoreCase(getString(R.string.strExisting)) && edtNameOfEnterprise.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationEnterpriseName));
            // CommonMethods.displayToast(mContext , "Please enter enterprise name");
            return false;
        } else if (strExistingOrNew.equalsIgnoreCase(getString(R.string.strExisting)) && edtTypeOfEnterprise.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationSelectEnterpriseName));
            //CommonMethods.displayToast(mContext , "Please select enterprise type");
            return false;
        } else if (strExistingOrNew.equalsIgnoreCase(getString(R.string.strExisting)) && edtMoreInfoAboutEnterprise.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationEnterDescription));
            //CommonMethods.displayToast(mContext , "Please enter more description about enterprise and products");
            return false;
        } else if (edtFirstName.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationEnterFirstName));
            //CommonMethods.displayToast(mContext , "Please enter first name");
            return false;
        } else if (edtDateOfBirth.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationDateOfBirth));
            //CommonMethods.displayToast(mContext , "Please select date of birth");
            return false;
        } else if (edtSelectGender.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationGender));
            //CommonMethods.displayToast(mContext , "Please select gender");
            return false;
        }else if (edtEmailId.getText().toString().length() != 0 && !CommonMethods.checkEmailIsCorrect(edtEmailId.getText().toString())) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidEmailID));
            return false;
        }else if (edtSocialCategory.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationCategory));
            // CommonMethods.displayToast(mContext , "Please select social category");
            return false;
        }else if (edtSocialCategory.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationCategory));
            // CommonMethods.displayToast(mContext , "Please select social category");
            return false;
        } else if (edtNoOfDependent.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strPleaseEnterNoOfDependent));
            //CommonMethods.displayToast(mContext , "Please select state");
            return false;
        } else if (edtDistrict.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationDistrict));
            return false;
        } else if (edtblock.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationBLock));
            return false;
        } else if (edtVillege.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationVillege));
            return false;
        } else if (edtResidentAddress.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationResidentAddress));
            return false;
        } else if (edtPincode.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationPincode));
            return false;
        }else if (edtAdharNo.getText().toString().trim().length() > 0 && edtAdharNo.getText().toString().trim().length() < 12) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strPleaseAddProperAadhar));
            return false;
        } else if (edtPanNo.getText().toString().trim().length() > 0 && !CommonMethods.checkPanIsCorrect(edtPanNo.getText().toString())) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strpleasePanFormat));
            return false;
        }else if (edtMaritalStatus.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidationMaritalStatus));
            return false;
        }else if (strEventAttained.equalsIgnoreCase(getResources().getString(R.string.strYes)) && edtEventName.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strPleaseAddEventName));
            return false;
        }else if (strEventAttained.equalsIgnoreCase(getResources().getString(R.string.strYes)) && edtParticipantName.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strPleaseParticipantName));
            return false;
        } else {
            return true;
        }

    }

    private void openEnterpriseTypeDialog() {

        final Dialog dialogEnterpriseType = new Dialog(getActivity(), R.style.listDialog);
        dialogEnterpriseType.setContentView(R.layout.dialog_enterprisetype);

        RadioGroup rgEnterpriseType = (RadioGroup) dialogEnterpriseType.findViewById(R.id.rgEnterpriseType);
        RadioButton rbtnManufacturing = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnManufacturing);
        RadioButton rbtnTrading = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnTrading);
        RadioButton rbtnOther = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnOther);


        if (!(edtTypeOfEnterprise.getText().toString().isEmpty())) {

            if (edtTypeOfEnterprise.getText().toString().equals(getResources().getString(R.string.strMenufacturing))) {
                rbtnManufacturing.setChecked(true);
                rbtnTrading.setChecked(false);
                rbtnOther.setChecked(false);

            } else if (edtTypeOfEnterprise.getText().toString().equals(getResources().getString(R.string.strTrading))) {
                rbtnTrading.setChecked(true);
                rbtnManufacturing.setChecked(false);
                rbtnOther.setChecked(false);

            } else if (edtTypeOfEnterprise.getText().toString().equals(getResources().getString(R.string.strService))) {
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
                        // AlertDialogUtility.SHOW_TOAST(RegisterEnterpreniourActivity.this , btn.getText().toString());
                        strEnterpriseType = btn.getText().toString();
                        edtTypeOfEnterprise.setText(strEnterpriseType);
                        dialogEnterpriseType.dismiss();
                    }
                }
            }
        });


        dialogEnterpriseType.setCancelable(true);
        dialogEnterpriseType.show();

    }

    private void openMaritalStatusDialog() {

        final Dialog dialogMaritalStatus = new Dialog(getActivity(), R.style.listDialog);
        dialogMaritalStatus.setContentView(R.layout.dialog_maritalstatus);

        RadioGroup rgMaritalStatus = (RadioGroup) dialogMaritalStatus.findViewById(R.id.rgMaritalStatus);
        RadioButton rbtnSingle = (RadioButton) dialogMaritalStatus.findViewById(R.id.rbtnSingle);
        RadioButton rbtnMarried = (RadioButton) dialogMaritalStatus.findViewById(R.id.rbtnMarried);
        RadioButton rbtnWidowed = (RadioButton) dialogMaritalStatus.findViewById(R.id.rbtnWidowed);
        RadioButton rbtnSeparated = (RadioButton) dialogMaritalStatus.findViewById(R.id.rbtnSeparated);

        if (!(edtMaritalStatus.getText().toString().isEmpty())) {

            if (edtMaritalStatus.getText().toString().equals(getResources().getString(R.string.single))) {
                rbtnSingle.setChecked(true);
                rbtnMarried.setChecked(false);
                rbtnWidowed.setChecked(false);
                rbtnSeparated.setChecked(false);

            } else if (edtMaritalStatus.getText().toString().equals(getResources().getString(R.string.married))) {
                rbtnMarried.setChecked(true);
                rbtnSingle.setChecked(false);
                rbtnWidowed.setChecked(false);
                rbtnSeparated.setChecked(false);
            } else if (edtMaritalStatus.getText().toString().equals(getResources().getString(R.string.widowed))) {
                rbtnWidowed.setChecked(true);
                rbtnSingle.setChecked(false);
                rbtnMarried.setChecked(false);
                rbtnSeparated.setChecked(false);
            } else if (edtMaritalStatus.getText().toString().equals(getResources().getString(R.string.divorced))) {
                rbtnSeparated.setChecked(true);
                rbtnSingle.setChecked(false);
                rbtnMarried.setChecked(false);
                rbtnWidowed.setChecked(false);
            }
        } else {
            rbtnSingle.setChecked(false);
            rbtnMarried.setChecked(false);
            rbtnWidowed.setChecked(false);
            rbtnSeparated.setChecked(false);
        }


        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                        // AlertDialogUtility.SHOW_TOAST(RegisterEnterpreniourActivity.this , btn.getText().toString());
                        strMaritalStatus = btn.getText().toString();
                        edtMaritalStatus.setText(strMaritalStatus);
                        dialogMaritalStatus.dismiss();
                    }
                }
            }
        });


        dialogMaritalStatus.setCancelable(true);
        dialogMaritalStatus.show();
    }

    private void openCurrentIncomDialog() {


        dialogCurrenIncome = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogCurrenIncome.setContentView(R.layout.general_list_dialog);

        dialogCurrenIncome.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogCurrenIncome.findViewById(R.id.imgBack);
        TextView txtTitle = (TextView) dialogCurrenIncome.findViewById(R.id.txtTitle);
        txtTitle.setText(getResources().getString(R.string.strSelectCurrentIncom));


        listCurrentIncome = (ListView) dialogCurrenIncome.findViewById(R.id.listItems);
        mCurrentIncomeListAdapter = new CurrentIncomeListAdapter(mContext, getResources().getStringArray(R.array.CurrentIncomeList));
        listCurrentIncome.setAdapter(mCurrentIncomeListAdapter);

        listCurrentIncome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogCurrenIncome.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();
                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

              /*edtCurrentIncome.setText(strCasteFromSelection);
                lngCurrentIncomeID = Long.valueOf(tvStateId.getText().toString());*/

                //CLEAR DEPENDENT DATA
                //edtExpectedIncome.setText("");


            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCurrenIncome.dismiss();
            }
        });

        dialogCurrenIncome.setCanceledOnTouchOutside(false);
        dialogCurrenIncome.setCancelable(true);
        dialogCurrenIncome.show();
    }

    private void openExpectedIncomDialog() {


        dialogExpectedIncome = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogExpectedIncome.setContentView(R.layout.general_list_dialog);

        dialogExpectedIncome.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogExpectedIncome.findViewById(R.id.imgBack);
        TextView txtTitle = (TextView) dialogExpectedIncome.findViewById(R.id.txtTitle);
        txtTitle.setText(getResources().getString(R.string.strSelectExpectedIncom));

        listExpectedIncome = (ListView) dialogExpectedIncome.findViewById(R.id.listItems);
        mExpectedIncomeListAdapter = new ExpectedIncomeListAdapter(mContext, getResources().getStringArray(R.array.CurrentIncomeList));
        listExpectedIncome.setAdapter(mExpectedIncomeListAdapter);

        listExpectedIncome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogExpectedIncome.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();
                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

               /* edtExpectedIncome.setText(strCasteFromSelection);
                lngExpectedIncomeID = Long.valueOf(tvStateId.getText().toString());*/

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogExpectedIncome.dismiss();
            }
        });

        dialogExpectedIncome.setCanceledOnTouchOutside(false);
        dialogExpectedIncome.setCancelable(true);
        dialogExpectedIncome.show();
    }

    private void openVillegeListDialog() {

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


    private void openBlockDialog() {

        dialogBlock = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogBlock.setContentView(R.layout.general_list_search_dialog);

        dialogBlock.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogBlock.findViewById(R.id.imgBack);
        SearchView edtSearchView = (SearchView) dialogBlock.findViewById(R.id.edtSearchItem);

        int id = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) edtSearchView.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterBlockName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setTextSize(14);

        int id1 = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View mView = edtSearchView.findViewById(id1);
        mView.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) edtSearchView.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listBlock = (ListView) dialogBlock.findViewById(R.id.listItems);
        mBlockListAdapter = new BlockListAdapter(mContext, mDatabaseHelper.getBlockListFromDistrict(lngDistrictID));
        listBlock.setAdapter(mBlockListAdapter);

        edtSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mStateListAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listBlock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogBlock.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();
                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                edtblock.setText(strCasteFromSelection);
                lngBlockID = Long.valueOf(tvStateId.getText().toString());

                //Clear all other dependent data
                edtVillege.setText("");

                lngVillegeID = 0L;

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBlock.dismiss();
            }
        });

        dialogBlock.setCanceledOnTouchOutside(false);
        dialogBlock.setCancelable(true);
        dialogBlock.show();


    }

    private void openDistrinctDialog() {

        dialogDistrict = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogDistrict.setContentView(R.layout.general_list_search_dialog);

        dialogDistrict.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogDistrict.findViewById(R.id.imgBack);
        SearchView edtSearchView = (SearchView) dialogDistrict.findViewById(R.id.edtSearchItem);

        int id = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) edtSearchView.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterDistrictName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setTextSize(14);

        int id1 = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View mView = edtSearchView.findViewById(id1);
        mView.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) edtSearchView.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listDistrict = (ListView) dialogDistrict.findViewById(R.id.listItems);
        mDistrictListAdapter = new DistrictListAdapter(mContext, mDatabaseHelper.getDistrictListByStateID(lngStateID));
        listDistrict.setAdapter(mDistrictListAdapter);

        edtSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mStateListAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listDistrict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogDistrict.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();

                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                edtDistrict.setText(strCasteFromSelection);
                lngDistrictID = Long.valueOf(tvStateId.getText().toString());

                //Clear all other dependent data
                edtblock.setText("");
                edtVillege.setText("");

                lngBlockID = 0L;
                lngVillegeID = 0L;

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDistrict.dismiss();
            }
        });

        dialogDistrict.setCanceledOnTouchOutside(false);
        dialogDistrict.setCancelable(true);
        dialogDistrict.show();

    }

    private void openStateListDialog() {

        dialogState = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogState.setContentView(R.layout.general_list_search_dialog);

        dialogState.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogState.findViewById(R.id.imgBack);
        SearchView etSearchAirline = (SearchView) dialogState.findViewById(R.id.edtSearchItem);

        int id = etSearchAirline.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) etSearchAirline.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterStateName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));


        searchEditText.setTextSize(14);

        int id1 = etSearchAirline.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View v1 = etSearchAirline.findViewById(id1);
        v1.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) etSearchAirline.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listState = (ListView) dialogState.findViewById(R.id.listItems);
        mStateListAdapter = new StateListAdapter(mContext, mDatabaseHelper.getStateList());
        listState.setAdapter(mStateListAdapter);

        etSearchAirline.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mStateListAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogState.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();

                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                edtState.setText(strCasteFromSelection);
                lngStateID = Long.valueOf(tvStateId.getText().toString());

                //Clear all other dependent data
                edtDistrict.setText("");
                edtblock.setText("");
                edtVillege.setText("");

                lngDistrictID = 0L;
                lngBlockID = 0L;
                lngVillegeID = 0L;


            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogState.dismiss();
            }
        });

        dialogState.setCanceledOnTouchOutside(false);
        dialogState.setCancelable(true);
        dialogState.show();
    }

    private void openSocialCategoryDialog() {
        dialogCaste = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogCaste.setContentView(R.layout.general_list_search_dialog);

        dialogCaste.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogCaste.findViewById(R.id.imgBack);
        SearchView edtSearchView = (SearchView) dialogCaste.findViewById(R.id.edtSearchItem);

        int id = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) edtSearchView.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterSocialCategoryName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setTextSize(14);

        int id1 = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View mView = edtSearchView.findViewById(id1);
        mView.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) edtSearchView.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listCast = (ListView) dialogCaste.findViewById(R.id.listItems);
        casteAdapter = new CasteAdapter(mContext, mDatabaseHelper.getCastList());
        listCast.setAdapter(casteAdapter);

        edtSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                casteAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listCast.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogCaste.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();

                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                edtSocialCategory.setText(strCasteFromSelection);
                lngSocialCategoryID = Long.valueOf(tvStateId.getText().toString());

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCaste.dismiss();
            }
        });

        dialogCaste.setCanceledOnTouchOutside(false);
        dialogCaste.setCancelable(true);
        dialogCaste.show();
    }

    private void openReligionDialog() {
        dialogReligion = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogReligion.setContentView(R.layout.general_list_search_dialog);

        dialogReligion.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogReligion.findViewById(R.id.imgBack);
        SearchView edtSearchView = (SearchView) dialogReligion.findViewById(R.id.edtSearchItem);

        int id = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) edtSearchView.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterReligionName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setTextSize(14);

        int id1 = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View mView = edtSearchView.findViewById(id1);
        mView.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) edtSearchView.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listRelegion = (ListView) dialogReligion.findViewById(R.id.listItems);
        religionAdapter = new ReligionAdapter(mContext, mDatabaseHelper.getReligionList());
        listRelegion.setAdapter(religionAdapter);

        edtSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                religionAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listRelegion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogReligion.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strReligionFromSelection = textView.getText().toString();

                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);
               /* edtReligion.setText(strReligionFromSelection);
                lngReligionID = Long.valueOf(tvStateId.getText().toString());*/


            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogReligion.dismiss();
            }
        });

        dialogReligion.setCanceledOnTouchOutside(false);
        dialogReligion.setCancelable(true);
        dialogReligion.show();

    }

    private void openGenderDialog() {

        final Dialog dialogGender = new Dialog(getActivity(), R.style.listDialog);
        dialogGender.setContentView(R.layout.dialog_gender);

        RadioGroup rgGenderGroup = (RadioGroup) dialogGender.findViewById(R.id.rgGenderGroup);
        RadioButton rbtnMale = (RadioButton) dialogGender.findViewById(R.id.rbtnMale);
        RadioButton rbtnFemale = (RadioButton) dialogGender.findViewById(R.id.rbtnFemale);
        RadioButton rbtnTransgender = (RadioButton) dialogGender.findViewById(R.id.rbtnTransgender);

        if (!(edtSelectGender.getText().toString().isEmpty())) {

            // if(etGender.getText().toString().equals("Male")) {
            if (edtSelectGender.getText().toString().equals(getResources().getString(R.string.strmale))) {
                rbtnMale.setChecked(true);
                rbtnFemale.setChecked(false);
                rbtnTransgender.setChecked(false);
            } else if (edtSelectGender.getText().toString().equals(getResources().getString(R.string.strfemale))) {
                rbtnMale.setChecked(false);
                rbtnFemale.setChecked(true);
                rbtnTransgender.setChecked(false);
            } else if (edtSelectGender.getText().toString().equals(getResources().getString(R.string.strtrans))) {
                rbtnMale.setChecked(false);
                rbtnFemale.setChecked(false);
                rbtnTransgender.setChecked(true);
            }
        } else {
            rbtnMale.setChecked(false);
            rbtnFemale.setChecked(false);
            rbtnTransgender.setChecked(false);
        }

        rgGenderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                        strSelectedRadioGender = btn.getText().toString();
                        edtSelectGender.setText(strSelectedRadioGender);
                        dialogGender.dismiss();
                    }
                }
            }
        });


        dialogGender.setCancelable(true);
        dialogGender.setCanceledOnTouchOutside(true);
        dialogGender.show();
    }

    private void openDatePickerDialog() {

        Date fromDate = null;
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

    @Override
    public void onDateSet(DatePickerDialog view, int selectedYear, int selectedMonth, int selectedDay) {

        int year = selectedYear;
        int month = selectedMonth;
        int day = selectedDay;

        if (Integer.parseInt(getAge(year, month, day)) > 16 && Integer.parseInt(getAge(year, month, day)) < 70) {

            int intAge = Integer.parseInt(getAge(year, month, day));
            edtDateOfBirth.setText(new StringBuilder().append(day).append("/").append(month + 1).append("/").append(year).append(" "));

            String strDate = String.valueOf(month + 1) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

            DateFormat inputFormat = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);

            Date date = null;
            try {
                date = inputFormat.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }


        } else {
            edtDateOfBirth.setText("");
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strenterAgeValidation));
        }
    }

    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }
}

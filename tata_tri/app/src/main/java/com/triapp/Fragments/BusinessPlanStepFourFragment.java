package com.triapp.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.triapp.Activities.MainActivity;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.GetNewBusinessPlanDataModel;
import com.triapp.Models.MeansOfFinanceModel;
import com.triapp.Models.SalesRealisationModel;
import com.triapp.Models.SelectedParticularsModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class BusinessPlanStepFourFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "BusinessPlanStepFourFragment";

    private static final String SECTION_NUMBER = "sectionNumber";
    private static final String ENTERPRENUER_ID = "enterprenuerID";


    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private LinearLayout llProfitabilityProjection, llMeansOfFinance, linearMeansOfFinance;
    private TextView txtSubmitAndCreatModelPlan, txtSubmitBusinessPlan, txtProfitabilityProjection, txtSaveMeansOfFinance, txtTitleBankLoan, txtTitleRemarksFriends, txtTitleRemarksFinance, txtTotalMeansOFFinanace, txtMeansOfFinance;
    private EditText edtSalesRealisationAmount, edtBreakEvenPeriod, edtBreakEvenPoints, edtGrossProfit, edtDepricationAmount, edtInterest, edtSellingdistributionAmount, edtAdministrativeexpensesAmount, edtManpowerCostAmount, edtUtilitiesAmount, edtRawmaterialsAmount, edtMeansOfFinanceBankLoanRemarks, edtMeansOfFinanceBankLoanAmount, edtMeansOfFinanceFriendsRemarks, edtMeansOfFinanceFriendsAmount, edtMeansOfFinanceRemarks, edtMeansOfFinanceAmount;
    private DatabaseHelper mDatabaseHelper;
    private double dblTotalFund = 0.0;
    ArrayList<MeansOfFinanceModel> meansOfFinanceModelArrayList = new ArrayList<>();
    ArrayList<GetNewBusinessPlanDataModel.DataBean.FinanceMeansBean> MeansOfFinanceExperienceDTOModels = new ArrayList<>();
    private ArrayList<SalesRealisationModel> step2_1_OtherIncomeList = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public BusinessPlanStepFourFragment() {


    }

    public static BusinessPlanStepFourFragment newInstance(int sectionNumber, String strEnterprenuerID) {
        BusinessPlanStepFourFragment fragment = new BusinessPlanStepFourFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        args.putString(ENTERPRENUER_ID, strEnterprenuerID);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.business_plan_step_four_fragment, container, false);

        setIds();
        setOnclicks();


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


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        linearMeansOfFinance = (LinearLayout) mView.findViewById(R.id.linearMeansOfFinance);
        llMeansOfFinance = (LinearLayout) mView.findViewById(R.id.llMeansOfFinance);
        llProfitabilityProjection = (LinearLayout) mView.findViewById(R.id.llProfitabilityProjection);

        txtMeansOfFinance = (TextView) mView.findViewById(R.id.txtMeansOfFinance);
        txtTotalMeansOFFinanace = (TextView) mView.findViewById(R.id.txtTotalMeansOFFinanace);
        txtTitleRemarksFinance = (TextView) mView.findViewById(R.id.txtTitleRemarksFinance);
        txtTitleRemarksFriends = (TextView) mView.findViewById(R.id.txtTitleRemarksFriends);
        txtTitleBankLoan = (TextView) mView.findViewById(R.id.txtTitleBankLoan);
        txtSaveMeansOfFinance = (TextView) mView.findViewById(R.id.txtSaveMeansOfFinance);
        txtProfitabilityProjection = (TextView) mView.findViewById(R.id.txtProfitabilityProjection);
        txtSubmitBusinessPlan = (TextView) mView.findViewById(R.id.txtSubmitBusinessPlan);
        txtSubmitAndCreatModelPlan = (TextView) mView.findViewById(R.id.txtSubmitAndCreatModelPlan);

        edtMeansOfFinanceAmount = (EditText) mView.findViewById(R.id.edtMeansOfFinanceAmount);
        edtMeansOfFinanceRemarks = (EditText) mView.findViewById(R.id.edtMeansOfFinanceRemarks);
        edtMeansOfFinanceFriendsAmount = (EditText) mView.findViewById(R.id.edtMeansOfFinanceFriendsAmount);
        edtMeansOfFinanceFriendsRemarks = (EditText) mView.findViewById(R.id.edtMeansOfFinanceFriendsRemarks);
        edtMeansOfFinanceBankLoanAmount = (EditText) mView.findViewById(R.id.edtMeansOfFinanceBankLoanAmount);
        edtMeansOfFinanceBankLoanRemarks = (EditText) mView.findViewById(R.id.edtMeansOfFinanceBankLoanRemarks);
        edtSalesRealisationAmount = (EditText) mView.findViewById(R.id.edtSalesRealisationAmount);
        edtRawmaterialsAmount = (EditText) mView.findViewById(R.id.edtRawmaterialsAmount);
        edtUtilitiesAmount = (EditText) mView.findViewById(R.id.edtUtilitiesAmount);
        edtManpowerCostAmount = (EditText) mView.findViewById(R.id.edtManpowerCostAmount);
        edtAdministrativeexpensesAmount = (EditText) mView.findViewById(R.id.edtAdministrativeexpensesAmount);
        edtSellingdistributionAmount = (EditText) mView.findViewById(R.id.edtSellingdistributionAmount);
        edtInterest = (EditText) mView.findViewById(R.id.edtInterest);
        edtDepricationAmount = (EditText) mView.findViewById(R.id.edtDepricationAmount);
        edtGrossProfit = (EditText) mView.findViewById(R.id.edtGrossProfit);
        edtBreakEvenPoints = (EditText) mView.findViewById(R.id.edtBreakEvenPoints);
        edtBreakEvenPeriod = (EditText) mView.findViewById(R.id.edtBreakEvenPeriod);

        //SET MENDETORY TITLES
        txtTitleRemarksFinance.setText(CommonMethods.spannableString(getResources().getString(R.string.strTitleRemarksFinance)));
        txtTitleRemarksFriends.setText(CommonMethods.spannableString(getResources().getString(R.string.strTitleRemarksFinance)));
        txtTitleBankLoan.setText(CommonMethods.spannableString(getResources().getString(R.string.strTitleRemarksFinance)));


        //CHECK IF MOBILE USER ALLOW TO CREATE MODEL BUSINESS PLAN
        if (mSessionManager.getPreferenceBoolean(Constants.IS_USER_ABLE_TO_MAKE_MODEL_BUSINESS_PLAN)) {
            txtSubmitAndCreatModelPlan.setVisibility(View.VISIBLE);
        }


        //CHECK IF BUSINESS PLAN IS ALREADY SUBMITTED
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getIsBusinessPlanSubmited() == 1) {
                makeViewUnEditable();
            }
        }

        //SET DATA TO STEP 4.0 WHICH IS ALREADY SAVED IN DATABASE
        displayMeansOfFinanceData();
    }


    private void setOnclicks() {

        linearMeansOfFinance.setOnClickListener(this);
        txtSaveMeansOfFinance.setOnClickListener(this);
        txtProfitabilityProjection.setOnClickListener(this);
        txtSubmitBusinessPlan.setOnClickListener(this);
        txtSubmitAndCreatModelPlan.setOnClickListener(this);

    }

    private void makeViewUnEditable() {

        txtSaveMeansOfFinance.setVisibility(View.GONE);
        txtSubmitBusinessPlan.setVisibility(View.GONE);
        txtSubmitAndCreatModelPlan.setVisibility(View.GONE);

        edtMeansOfFinanceAmount.setFocusableInTouchMode(false);
        edtMeansOfFinanceRemarks.setFocusableInTouchMode(false);
        edtMeansOfFinanceFriendsAmount.setFocusableInTouchMode(false);
        edtMeansOfFinanceFriendsRemarks.setFocusableInTouchMode(false);
        edtMeansOfFinanceBankLoanAmount.setFocusableInTouchMode(false);
        edtMeansOfFinanceBankLoanRemarks.setFocusableInTouchMode(false);
    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.linearMeansOfFinance:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (openWarningDialog()) {

                    if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                        if (llMeansOfFinance.getVisibility() == View.VISIBLE) {
                            llMeansOfFinance.setVisibility(View.GONE);
                        } else {
                            llMeansOfFinance.setVisibility(View.VISIBLE);
                        }
                    } else {
                        CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                    }
                }
                break;
            case R.id.txtSaveMeansOfFinance:

                saveMeansOffinace();

                break;
            case R.id.txtProfitabilityProjection:

                openProfitabilityProjectiondata();

                break;
            case R.id.txtSubmitBusinessPlan:

                submitBusinessPlan(false);

                break;
            case R.id.txtSubmitAndCreatModelPlan:

                submitBusinessPlan(true);

                break;


        }

    }


    private boolean openWarningDialog() {

        //Calculate total means of finance from previous steps
        calculateTotalfinance();

        if (dblTotalFund == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strErrorProjectCostShouldNotBeZero));
            return false;
        } else {
            return true;
        }
    }

    private void calculateTotalfinance() {
        Double prOperative = 0.0;
        Double landsAndBuilding1 = 0.0;
        Double landsAndBuilding2 = 0.0;
        Double dblMachinery = 0.0;
        Double dblFurniture = 0.0;
        Double dblWorkingCapital = 0.0;
        Double dblTotalProjectCost = 0.0;


        ArrayList<SelectedParticularsModel> particularsEditedAnswerModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));
        if (particularsEditedAnswerModels.size() != 0) {

            prOperative = (particularsEditedAnswerModels.get(0).getAmount() +
                    particularsEditedAnswerModels.get(1).getAmount() +
                    particularsEditedAnswerModels.get(2).getAmount() +
                    particularsEditedAnswerModels.get(3).getAmount() +
                    particularsEditedAnswerModels.get(4).getAmount());
        }

        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.LandBuildingExpensesBean> mLandAndBuildingList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses();

            if (mLandAndBuildingList.get(0).getOwnership().equals(getResources().getString(R.string.strLeaseBP))) {
                landsAndBuilding1 = mLandAndBuildingList.get(0).getAmount();
            }
            if (mLandAndBuildingList.get(1).getOwnership().equals(getResources().getString(R.string.strLeaseBP))) {
                landsAndBuilding2 = mLandAndBuildingList.get(1).getAmount();
            }

        }

        if (mSessionManager.getPreference(Constants.TOTAL_WORKING_CAPITAL).equals("")) {
            dblWorkingCapital = 0.0;
        } else {
            dblWorkingCapital = Double.valueOf(mSessionManager.getPreference(Constants.TOTAL_WORKING_CAPITAL));
        }


        //Calculate Depriciation from step  3.2
        for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
            dblMachinery = (dblMachinery + mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getAmount());
        }

        //Calculate Depriciation from step  3.3
        for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
            dblFurniture = (dblFurniture + mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getAmount());

        }


        dblTotalProjectCost = (prOperative + landsAndBuilding1 + landsAndBuilding2 + dblMachinery + dblFurniture + dblWorkingCapital);

        txtTotalMeansOFFinanace.setText("" + dblTotalProjectCost.intValue() + "" + getResources().getString(R.string.strRupeeSymbolInBracket));
        dblTotalFund = dblTotalProjectCost.intValue();
    }

    private void saveMeansOffinace() {

        String strOwnInvestmentAmount = edtMeansOfFinanceAmount.getText().toString();
        String strOwnInvestmentRemarks = edtMeansOfFinanceRemarks.getText().toString();

        String strFriendsAmount = edtMeansOfFinanceFriendsAmount.getText().toString();
        String strFriendsRemarks = edtMeansOfFinanceFriendsRemarks.getText().toString();

        String strBankLoanAmount = edtMeansOfFinanceBankLoanAmount.getText().toString();
        String strBankLoanRemarks = edtMeansOfFinanceBankLoanRemarks.getText().toString();

        if (checkValidation(strOwnInvestmentAmount, strOwnInvestmentRemarks,
                strFriendsAmount, strFriendsRemarks,
                strBankLoanAmount, strBankLoanRemarks)) {


            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                meansOfFinanceModelArrayList.clear();
                meansOfFinanceModelArrayList = new ArrayList<MeansOfFinanceModel>();

                MeansOfFinanceModel meansOfFinanceModel = new MeansOfFinanceModel();
                //  meansOfFinanceModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                meansOfFinanceModel.setFinanceMeansParticularId(1L);
                meansOfFinanceModel.setAmount(Double.valueOf(strOwnInvestmentAmount));
                meansOfFinanceModel.setRemarks(strOwnInvestmentRemarks);
                meansOfFinanceModelArrayList.add(meansOfFinanceModel);

                MeansOfFinanceModel meansOfFinanceModel1 = new MeansOfFinanceModel();
                //  meansOfFinanceModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                meansOfFinanceModel1.setFinanceMeansParticularId(2L);
                meansOfFinanceModel1.setAmount(Double.valueOf(strFriendsAmount));
                meansOfFinanceModel1.setRemarks(strFriendsRemarks);
                meansOfFinanceModelArrayList.add(meansOfFinanceModel1);

                MeansOfFinanceModel meansOfFinanceModel2 = new MeansOfFinanceModel();
                //  meansOfFinanceModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                meansOfFinanceModel2.setFinanceMeansParticularId(3L);
                meansOfFinanceModel2.setAmount(Double.valueOf(strBankLoanAmount));
                meansOfFinanceModel2.setRemarks(strBankLoanRemarks);
                meansOfFinanceModelArrayList.add(meansOfFinanceModel2);


                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_4_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {
                    mDatabaseHelper.insertEntrepreneurBP_4_0_step(
                            new Gson().toJson(meansOfFinanceModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                } else {
                    mDatabaseHelper.updateEntrepreneurBP_4_0_step(
                            new Gson().toJson(meansOfFinanceModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                }


                if (llMeansOfFinance.getVisibility() == View.VISIBLE) {
                    llMeansOfFinance.setVisibility(View.GONE);
                } else {
                    llMeansOfFinance.setVisibility(View.VISIBLE);
                }
                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));

            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }


        }
    }

    private boolean checkValidation(String strOwnInvestmentAmount, String strOwnInvestmentRemarks,
                                    String strFriendsAmount, String strFriendsRemarks,
                                    String strBankLoanAmount, String strBankLoanRemarks
    ) {

        boolean isOwnInvestmentInsert = false, isfromFriendInserted = false, isFromBankInserted = false;
        if (strOwnInvestmentAmount.equals("0")) {
            isOwnInvestmentInsert = true;
        }

        if (strFriendsAmount.equals("0")) {
            isfromFriendInserted = true;
        }

        if (strBankLoanAmount.equals("0")) {
            isFromBankInserted = true;
        }

        if (strOwnInvestmentAmount.length() == 0) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterOwnInvestmentAmount));
            edtMeansOfFinanceAmount.requestFocus();
            return false;
        } else if (strOwnInvestmentRemarks.length() == 0 && !isOwnInvestmentInsert) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorPleaseEnterOwnInvestmentRemarks));
            edtMeansOfFinanceRemarks.requestFocus();
            return false;
        } else if (strFriendsAmount.length() == 0) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFriendsAmount));
            edtMeansOfFinanceFriendsAmount.requestFocus();
            return false;
        } else if (strFriendsRemarks.length() == 0 && !isfromFriendInserted) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorPleaseEnterFriendsLoanRemarks));
            edtMeansOfFinanceFriendsRemarks.requestFocus();
            return false;
        } else if (strBankLoanAmount.length() == 0) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterBankLoanAmount));
            edtMeansOfFinanceBankLoanAmount.requestFocus();
            return false;
        } else if (strBankLoanRemarks.length() == 0 && !isFromBankInserted) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorPleaseEnterBankLoan));
            edtMeansOfFinanceBankLoanRemarks.requestFocus();
            return false;
        } else if ((Double.valueOf(strOwnInvestmentAmount) + Double.valueOf(strFriendsAmount) + Double.valueOf(strBankLoanAmount)) != dblTotalFund) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorTotalMeansOfFinance));
            return false;
        } else {
            return true;
        }
    }

    private void displayMeansOfFinanceData() {
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_4_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.FinanceMeansBean> MeansOfFinanceExperienceDTOModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_4_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getFinanceMeans();

            Double dblMeansOfFinanceAmount, MeansOfFinanceFriendsAmount, MeansOfFinanceBankLoanAmount;

            dblMeansOfFinanceAmount = MeansOfFinanceExperienceDTOModels.get(0).getAmount();
            MeansOfFinanceFriendsAmount = MeansOfFinanceExperienceDTOModels.get(1).getAmount();
            MeansOfFinanceBankLoanAmount = MeansOfFinanceExperienceDTOModels.get(2).getAmount();

            edtMeansOfFinanceAmount.setText("" + dblMeansOfFinanceAmount.intValue());
            edtMeansOfFinanceRemarks.setText("" + MeansOfFinanceExperienceDTOModels.get(0).getRemarks());

            edtMeansOfFinanceFriendsAmount.setText("" + MeansOfFinanceFriendsAmount.intValue());
            edtMeansOfFinanceFriendsRemarks.setText("" + MeansOfFinanceExperienceDTOModels.get(1).getRemarks());

            edtMeansOfFinanceBankLoanAmount.setText("" + MeansOfFinanceBankLoanAmount.intValue());
            edtMeansOfFinanceBankLoanRemarks.setText("" + MeansOfFinanceExperienceDTOModels.get(2).getRemarks());
        }
    }

    private void openProfitabilityProjectiondata() {

        if (openWarningDialog()) {

            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {
                getAllCostAmount();
            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }


            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                if (llProfitabilityProjection.getVisibility() == View.VISIBLE) {
                    llProfitabilityProjection.setVisibility(View.GONE);
                } else {
                    llProfitabilityProjection.setVisibility(View.VISIBLE);
                }
            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }
        }


    }

    private void getAllCostAmount() {

        //Get Total from Step 2.0 and 2.1;
        Double dblSalesRealisation = 0.0;
        Double dblOtherAmount = 0.0;
        Double dblTotalIncome = 0.0;

        //CALCULATE TOTAL INCOME
        if (mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size() != 0) {
            for (int i = 0; i < mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
                dblSalesRealisation = (dblSalesRealisation + mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getAmount());
            }
        }

        //Get Other amount form step 2.1
        if (mDatabaseHelper.getBusinessPlanStep2_1_by_id(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            step2_1_OtherIncomeList = mDatabaseHelper.getBusinessPlanStep2_1_by_id(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));
            dblOtherAmount = step2_1_OtherIncomeList.get(step2_1_OtherIncomeList.size() - 1).getAmount();
            //Calculate Total Income
        }
        //Display Total amount from step 2.0 and 2.1
        dblTotalIncome = (dblSalesRealisation + dblOtherAmount);
        edtSalesRealisationAmount.setText("" + dblTotalIncome.intValue());


        //CALCULATE RAW MATERIEL
        // 2.
        Double dblRawMaterial = 0.0;
        Double dblCostOfGoods = 0.0;

        for (int i = 0; i < mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
            dblCostOfGoods = dblCostOfGoods + mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getTotalCostOfGoods();
        }


        if (mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size() != 0) {
            for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
                dblRawMaterial = (dblRawMaterial + mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getTotalValue());
            }
        }
        //Disaplay highest values from RawMateriel OR CostOfGoof
        //Changes Given by Yagnik sir on 17/5/2017
        if (dblCostOfGoods.intValue() > dblRawMaterial) {
            edtRawmaterialsAmount.setText(String.valueOf(dblCostOfGoods.intValue()));
        } else {
            edtRawmaterialsAmount.setText(String.valueOf(dblRawMaterial.intValue()));
        }


        //CALCULATE UTILITES EXPENSE
        //3.
        Double dblUtilities = 0.0;
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> utilitiesModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getUtilities();
            for (int i = 0; i < utilitiesModels.size(); i++) {
                dblUtilities = dblUtilities + utilitiesModels.get(i).getAnnualExpenditure();
            }

        }
        edtUtilitiesAmount.setText(String.valueOf(dblUtilities.intValue()));
        //CALCULATE MANPOWE EXPENSE
        //4.
        Double dblManPower = 0.0;
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean> manPowerModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getManpowers();
            for (int i = 0; i < manPowerModels.size(); i++) {
                dblManPower = dblManPower + manPowerModels.get(i).getAnnualExpenses();
            }

        }
        edtManpowerCostAmount.setText(String.valueOf(dblManPower.intValue()));
        //5.
        Double dblAdministrative = 0.0;
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> administrativeModels = new ArrayList<>();
            administrativeModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getAdministrativeExpenses();
            for (int i = 0; i < administrativeModels.size(); i++) {
                dblAdministrative = dblAdministrative + administrativeModels.get(i).getAmount();
            }

        }
        edtAdministrativeexpensesAmount.setText(String.valueOf(dblAdministrative.intValue()));
        //6.
        Double dblDistribution = 0.0;
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> sellingDistributionExpensModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getSellingDistributionExpenses();
            for (int i = 0; i < sellingDistributionExpensModels.size(); i++) {
                dblDistribution = dblDistribution + sellingDistributionExpensModels.get(i).getAmount();
            }

        }
        edtSellingdistributionAmount.setText(String.valueOf(dblDistribution.intValue()));

        //Calculate Repair and Maintainance from step 3.7
        Double dblTotalRepairAndMaintanence = 0.0, dblRent = 0.0, dblMisc = 0.0;

        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> administrativeExpensesList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getAdministrativeExpenses();
            if (administrativeExpensesList.size() != 0) {
                dblTotalRepairAndMaintanence = administrativeExpensesList.get(7).getAmount();

            }

        }
        //  etRepairsMaintenanceAmount.setText(String.valueOf(dblTotalRepairAndMaintanence.intValue()));


        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            dblRent = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getAdministrativeExpenses().get(5).getAmount();
            dblMisc = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getAdministrativeExpenses().get(6).getAmount();
            dblTotalRepairAndMaintanence = dblRent + dblMisc;


        }
        // etRentAmount.setText(String.valueOf(dblRent.intValue()));
        //etMiscExpenses.setText(String.valueOf(dblMisc.intValue()));

     /*   //9.
        Double dblIntrests = 0.0;
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_4_1_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.InterestsBean> intrestModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_4_1_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getInterests();
            for (int i = 0; i < intrestModels.size(); i++) {
                dblIntrests = dblIntrests + intrestModels.get(i).getTotalInterest();
            }

        }

        //Edited by  ketan
        //Suggested by Yagnik sir 15/03/2018 2:33
        if (!edtMeansOfFinanceFriendsAmount.getText().toString().isEmpty() && !edtMeansOfFinanceBankLoanAmount.getText().toString().isEmpty()) {
            totalInterest = ((Double.parseDouble(edtMeansOfFinanceFriendsAmount.getText().toString()) + (Double.parseDouble(edtMeansOfFinanceBankLoanAmount.getText().toString()))) * .12);

        }
*/

        //Get interest from Credit profile which is selected as a BUSINESS which is given by Khushru sir
        //edtInterest.setText(String.valueOf(dblIntrests + totalInterest));
        //Kets

       /* Double dblEditedInterest = 0.0;
        Double dblAmounttakenAsLoan = 0.0;
        Double finalInterest =0.0;
        for (int i= 0; i< mDatabaseHelper.getAllFamilyCreditsdList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() ; i++){

            if(mDatabaseHelper.getAllFamilyCreditsdList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(i).getLoanTypeCreditHistory() != null) {
                if (mDatabaseHelper.getAllFamilyCreditsdList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(i).getLoanTypeCreditHistory().equals(getResources().getString(R.string.titleBusinesssForInterest))) {

                    dblEditedInterest = dblEditedInterest + mDatabaseHelper.getAllFamilyCreditsdList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(i).getInterestRate();
                    dblAmounttakenAsLoan = dblAmounttakenAsLoan + mDatabaseHelper.getAllFamilyCreditsdList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(i).getLoanAmount();
                }
            }
        }*/

       /* if(!dblEditedInterest.equals(0.0)){

            finalInterest = (dblAmounttakenAsLoan * dblEditedInterest)/100;
        }*/

        //edtInterest.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.##").format(dblIntrests + totalInterest))));
        //edtInterest.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.##").format(finalInterest))));

        // Calculate Depriciation from step 3.2 and 3.3
        Double dblDepriciation = 0.0;

        //Calculate Depriciation from step  3.2
        for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
            dblDepriciation = (dblDepriciation + mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getDepriciation());
        }

        //Calculate Depriciation from step  3.3
        for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
            dblDepriciation = (dblDepriciation + mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getDepriciation());

        }

        //Display Total depriciation from step 3.2 and 3.3
        edtDepricationAmount.setText(String.valueOf(dblDepriciation.intValue()));


        Double B = Double.valueOf(edtRawmaterialsAmount.getText().toString())
                + Double.valueOf(edtUtilitiesAmount.getText().toString())
                + Double.valueOf(edtManpowerCostAmount.getText().toString())
                + Double.valueOf(edtAdministrativeexpensesAmount.getText().toString())
                + Double.valueOf(edtSellingdistributionAmount.getText().toString())
                + Double.valueOf(edtInterest.getText().toString());

        Double A = Double.valueOf(edtSalesRealisationAmount.getText().toString());

        Double A_B = A - B;

        //Calculate Break even points
        //Formula = (Fixed Cost * Sale)/(Sale - Variable Cost)
        //Fixed Cost= Calculate step from business plan(3.0+3.1 + 3.2 + 3.3 + 3.5 + 4.1)
        //Variable Cost= Calculate step from business plan(3.4 + 3.6 + 3.7 + 3.8 + 3.9)

        Double dblBreakEvenPoints = 0.0,
                dblPreoperativeExpenses = 0.0,
                dblLandAndBuilding = 0.0,
                dblPlanAndMachinery = 0.0,
                dblFurnitureData = 0.0,
                dblBreakEvenUtilty = dblUtilities,
                dblBreakEvenInteres = Double.valueOf(edtInterest.getText().toString()),
                dblFixedCost = 0.0;

        ArrayList<SelectedParticularsModel> particularsEditedAnswerModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));
        if (particularsEditedAnswerModels.size() != 0) {

            dblPreoperativeExpenses = (particularsEditedAnswerModels.get(0).getAmount() +
                    particularsEditedAnswerModels.get(1).getAmount() +
                    particularsEditedAnswerModels.get(2).getAmount() +
                    particularsEditedAnswerModels.get(3).getAmount() +
                    particularsEditedAnswerModels.get(4).getAmount());
        }


        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.LandBuildingExpensesBean> mLandAndBuildingList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses();
            dblLandAndBuilding = (mLandAndBuildingList.get(0).getAmount() + mLandAndBuildingList.get(1).getAmount());
        }

        if (mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size() != 0) {
            for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
                dblPlanAndMachinery = (dblPlanAndMachinery + mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getAmount());
            }
        }

        if (mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size() != 0) {

            for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
                dblFurnitureData = (dblFurnitureData + mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getAmount());
            }
        }


        dblFixedCost = (dblPreoperativeExpenses + dblLandAndBuilding + dblPlanAndMachinery + dblFurnitureData + dblBreakEvenUtilty + dblBreakEvenInteres);

        //Calculate Variable Cost
        Double dblBreakEvenRawMateriel = dblRawMaterial,
                dblBreakEvenManPower = dblManPower,
                dblBreakEvenAdministrative = dblAdministrative,
                dblBreakEventSellingDistribution = dblDistribution,
                dblBreakEventWorkingCapital = 0.0,
                dblTotalVariableCost = 0.0;


        if (mSessionManager.getPreference(Constants.TOTAL_WORKING_CAPITAL).equals("")) {
            dblBreakEventWorkingCapital = 0.0;
        } else {
            dblBreakEventWorkingCapital = Double.valueOf(mSessionManager.getPreference(Constants.TOTAL_WORKING_CAPITAL));
        }

        //Total Variable Cost
        dblTotalVariableCost = (dblBreakEvenRawMateriel + dblBreakEvenManPower + +dblBreakEventSellingDistribution + dblBreakEventWorkingCapital);

        if (dblFixedCost != 0 && dblSalesRealisation != 0 && dblTotalVariableCost != 0) {
            dblBreakEvenPoints = (dblFixedCost * dblSalesRealisation) / (dblSalesRealisation - dblTotalVariableCost);
        } else {
            dblBreakEvenPoints = 0.0;
        }

        if (String.valueOf(dblBreakEvenPoints).contains("-")) {
            edtBreakEvenPoints.setText("0");
        } else {

            if (dblBreakEvenPoints == 0.0) {
                edtBreakEvenPoints.setText("0");
            } else {
                edtBreakEvenPoints.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.##").format(dblBreakEvenPoints))));

            }
        }

        //CALCULATE BREAK EVEN PERIOD
        //BREAK EVEN PERIED= BREAK EVEN POINTS/TOTAL SALES AND REVENUE(STEP 2.0)
        Double dblBreakEvenPeriod = 0.0;
        if (dblBreakEvenPoints != 0 && dblSalesRealisation != 0)

        {
            dblBreakEvenPeriod = (dblBreakEvenPoints / dblSalesRealisation) * 12;
        } else

        {
            dblBreakEvenPeriod = 0.0;
        }


        if (String.valueOf(dblBreakEvenPeriod).contains("-")) {
            edtBreakEvenPeriod.setText("0");
        } else {
            edtBreakEvenPeriod.setText(String.valueOf(Double.parseDouble(new DecimalFormat("##.##").format(dblBreakEvenPeriod)) + " " + getResources().getString(R.string.strMonth)));

        }
        edtGrossProfit.setText(String.valueOf((A_B.intValue()) - dblDepriciation.intValue()));

        if (edtGrossProfit.getText().toString().contains("-")) {
            openNagetiveProfiteDialog();
        }

    }

    private void openNagetiveProfiteDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_negetive_profite_dialog, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog mAlertDialog = dialogBuilder.create();
        TextView txtOk = (TextView) dialogView.findViewById(R.id.txtOk);
        TextView txtUsername = (TextView) dialogView.findViewById(R.id.txtUsername);
        txtUsername.setText(getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        txtOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();
            }
        });


        mAlertDialog.show();
    }

    private void submitBusinessPlan(boolean isFromSubmitAndModelButton) {

        //CHECK ALL PROJECT COST.
        getAllCostAmount();

        if (openWarningDialog()) {
            if (checkProjectCost()) {
                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {

                    if (mDatabaseHelper.getEnterpreneurList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getIsBusinessPlanSubmitted() == 1) {

                        openWarningDialogSave(getActivity().getResources().getString(R.string.strAlreadySubmitted), isFromSubmitAndModelButton);

                    } else {

                        if (!edtGrossProfit.getText().toString().contains("-")) {
                            openWarningDialogSave(getActivity().getResources().getString(R.string.strDataSavedSuccesfully), isFromSubmitAndModelButton);
                           //openWarningDialogTrainingDataNotSaved(getResources().getString(R.string.strMesegeNagetiveProfite));
                        }
                    }
                } else {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }
            }
        }

    }

    public boolean checkProjectCost() {


        ArrayList<GetNewBusinessPlanDataModel.DataBean> MeansOfFinanceExperienceDTOModels1 = new ArrayList<>();
        MeansOfFinanceExperienceDTOModels1 = mDatabaseHelper.getEntrepreneurBusinessplan_step_4_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));

        if (MeansOfFinanceExperienceDTOModels1.size() != 0) {
            calculateTotalfinance();
            if ((MeansOfFinanceExperienceDTOModels1.get(0).getFinanceMeans().get(0).getAmount() + MeansOfFinanceExperienceDTOModels1.get(0).getFinanceMeans().get(1).getAmount() + MeansOfFinanceExperienceDTOModels1.get(0).getFinanceMeans().get(2).getAmount() != dblTotalFund)) {
                CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorTotalMeansOfFinance));
                return false;
            } else {
                return true;
            }
        } else {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorProjectCostShouldNotBeZero));
            return false;
        }
    }

    private void openWarningDialogSave(final String message, final boolean isFromSubmitAndModelButton) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_business_step_one_dialog, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog mAlertDialog = dialogBuilder.create();
        TextView txtConfirm = (TextView) dialogView.findViewById(R.id.txtConfirm);
        TextView txtCancel = (TextView) dialogView.findViewById(R.id.txtCancel);
        TextView username = (TextView) dialogView.findViewById(R.id.username);
        TextView messageToShow = (TextView) dialogView.findViewById(R.id.txtWarningMsg);
        username.setText(getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        if (message.equals(getActivity().getResources().getString(R.string.strAlreadySubmitted))) {
            messageToShow.setText(getActivity().getResources().getString(R.string.strAlreadySubmitted));
            txtConfirm.setText(getActivity().getResources().getString(R.string.strOk));
            txtCancel.setVisibility(View.GONE);
        } else {
            messageToShow.setText(getActivity().getResources().getString(R.string.strErrorNewBusinessPlanFinalSubmitWarningMessege));
        }


        txtConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (message.equals(getActivity().getResources().getString(R.string.strAlreadySubmitted))) {

                    mAlertDialog.dismiss();

                } else {

                    //UPDATE BUSINESS PLAN STATUS IN ENTERPRENUER LIST
                    //1- MEANS BUSINESS PLAN SUBMITED SUCCESSFULLY
                    mDatabaseHelper.updateEnterpreneurBusinessPlansSubmittatus(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)), 1);

                    //UPDATE FLAG IS BUSINESS PLAN SUBMITTED
                    mDatabaseHelper.updateEntrepreneurBP_1_0_step_is_business_plan_submitted(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)), 1);


                    //CHECK IF THE MOBILE USER CLICK ON MODEL BUSINESS PLAN BUTTON THEN STATUS WILL CHANGE IN ENTERPRENUER DATA
                    if (isFromSubmitAndModelButton) {

                        mDatabaseHelper.updateEnterpreneurBusinessPlansIsModelStatuse(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)), 1);

                        //UPDATE FLAG IN STEP ONE ENTRY
                        mDatabaseHelper.updateEntrepreneurBP_1_0_step_for_model_plan(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)), 1);

                    }

                    Intent mIntent = new Intent(mActivity, MainActivity.class);
                    startActivity(mIntent);


                }
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

    private void openWarningDialogTrainingDataNotSaved(final String message) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_warning_messege, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog mAlertDialog = dialogBuilder.create();
        TextView txtCancel = (TextView) dialogView.findViewById(R.id.txtCancel);
        TextView txtUsername = (TextView) dialogView.findViewById(R.id.txtUsername);
        TextView messageToShow = (TextView) dialogView.findViewById(R.id.txtWarningMsg);
        txtUsername.setText(getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        messageToShow.setText(message);
        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });
        mAlertDialog.show();


    }


}


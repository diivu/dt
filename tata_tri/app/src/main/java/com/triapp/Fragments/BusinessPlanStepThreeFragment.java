package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.InputFilterMinMax;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.GetNewBusinessPlanDataModel;
import com.triapp.Models.LandBuildingModel;
import com.triapp.Models.ManPowerModel;
import com.triapp.Models.SelectedParticularsModel;
import com.triapp.Models.SubmitLandBuildingData;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class BusinessPlanStepThreeFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "BusinessPlanStepThreeFragment";

    private static final String SECTION_NUMBER = "sectionNumber";
    private static final String ENTERPRENUER_ID = "enterprenuerID";


    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private DatabaseHelper mDatabaseHelper;

    private EditText etPurchaseDateFurnitureEditView, edtPurchaseDateManchineryEditview, etSuppliersNameFurniture, etBookValueFurniture, etDepreciationFurniture, etScrapValueFurniture, etExpectedLifeFurniture, etPurchaseDateFurniture, etAmountinRsFurniture, etPriceFurniture, etTotalValues, etUnitRate, etQuantity, etForMonths, etItem, etMachinNosFurniture, etParticularsFurniture, edtElectrificationInRsManchinery, edtTaxTransInRsManchinery, edtSuppliersNameManchinery, edtBookValueManchinery, edtDepreciationManchinery, edtScrapValueManchinery, edtExpectedLifeManchinery, edtPurchaseDateManchinery, edtAmountinRsManchinery, edtPriceManchinery, edtMachinNosManchinery, edtParticularsManchinery, edtAnyOtherAnnualExpenses, edtAnyOtherWagesSalaries, edtAnyOtherNo, edtOfficeStaffAnnualExpenses, edtOfficeStaffWagesSalaries, edtOfficeStaffNo, edtNoOfMonPreOperativeBuilding, edtNoOfMonPreOperativeLand, edtTotalProjectCost, edtCostWorkingCapital, edtCostEquipment, edtCostMachinary, edtCostLandBuilding, edtCostPreOperative, edtWCTotalWorkingCapitalNeeded, edtProductionExpensesWCAmount, edtProductionExpensesWCQuantity, edtProductionExpensesWCDuration, edtSalesOnCreditWCAmount, edtSalesOnCreditlRate, edtSalesOnCreditWCQuantity, edtSalesOnCreditWCDuration, edtFinishedWCDescription, edtFinishedStockWCAmount, edtFinishesRate, edtFinishedStockWCQuantity, edtFinishedStockWCDuration, edtSemiFinishedWCDescription, edtSemiFinishedWCAmount, edtSemiFinishedRate, edtSemiFinishedWCQuantity, edtSemiFinishedWCDuration, edtRawMaterialWCDescription, edtRawMaterialWCAmount, edtRawMaterialRate, edtRawMaterialWCQuantity, edtRawMaterialWCDuration, edtMiscRemarks, edtMiscAmountInRs, edtCommissionRemarks, edtCommissionAmountInRs, edtFreightRemarks, edtFreightAmountInRs, edtTravelingRemarks, edtTravelingAmountInRs, edtPublicityExpensesRemarks, edtPublicityExpensesAmountInRs, edtStMiscStRemarks, edtStMiscStaAmountInRs, edtStStRepairMeintananceStRemarks, edtStStRepairMeintananceStaAmountInRs, edtStStRentStRemarks, edtStStRentStaAmountInRs, edtStInsuranceStRemarks, edtStInsuranceStaAmountInRs, edtStEntertainmentStRemarks, edtStEntertainmentStaAmountInRs, edtCommunicationStRemarks, edtCommunicationStaAmountInRs, edtStTravelingStRemarks, edtStTravelingStaAmountInRs, edtStRemarks, edtStaAmountInRs, edtUnskilledAnnualExpenses, edtUnskilledWagesSalaries, edtUnskilledNo, edtSemiSkilledAnnualExpenses, edtSemiSkilledWagesSalaries, edtSemiSkilledNo, edtSkilledAnnualExpenses, edtSkilledWagesSalaries, edtSkilledNo, edtAnyOtherRemarks, edtAnyOtherAnnualExpenditure, edtFuelAnnualExpenditure, edtFuelRemarks, edtWaterRemarks, edtWaterAnnualExpenditure, edtRemarks, edtAnnualExpenditure, edtAmountInRsBuilding, edtPriceBuilding, edtAreaInFtBuilding, edtAreaInFtLand, edtPriceLand, edtAmountInRsLand, edtOtherExp, edtEstablishmentExp, edtLegalExp, edtStationeryExp, edtMarketSurveyExp;
    private TextView edtUploadQuotaionsFurniture, txtTitleTotalValues, txtTitleUnitRate, txtTitleQuantity, txtTitleNoOfTimes, txtTitleItem, tvNoOfItems, txtTitleSuppllierNameFurniture, txtTitleBookValueFurniture, txtTitleDepriciatedCalFurniture, txtTitleScrapValueFurniture, txtTitleExpectedLifeFurniture, txtTitlePurchaseDateFurniture, txtTitleAmountInRSFurniture, txtTitlePerUnitPriceFurniture, txtTitleMachineNumberFurniture, txtTitleParticularFurniture, tvNoOfEducationFurniture, txtTitleElectrification, txtTitleTransInRs, txtTitleSuppllierName, txtTitleBookValue, txtTitleDepriciatedCal, txtTitleScrapValue, txtTitleExpectedLife, txtTitlePurchaseDate, txtTitleTotalAmount, txtTitlePerUnitPrice, txtTitleMachineNumber, txtTitlePerticulare, txtUploadQuotationManchinery, txtSrNoManchinery, txtEquipmentFurniture, txtSaveRawMaterial, tvNoOfEducation, txtUtilityAnyOtherExpenditure, txtUtilityFuelExpenditure, txtUtilityWaterExpenditure, txtUtilityPowerExpenditure, txtTitleBuildingAmount, txtTitleLandAmount, txtLandSquarFoot, txtBuildingSquarFoot, txtRawMaterial, txtTotalProjectCost, txtSaveWorkingCapital, txtWorkingCapital, txtSaveSellingDistribution, txtSellingDistribution, txtAdministrativeExpenses, txtSaveManPower, txtManpower, txtSaveUtilities, txtUtilities, txtBtnAddMoreRawMaterial, txtSaveEquipmentFurniture, txtBtnAddMoreEquipmentFurniture, txtSaveMachinery, txtBtnAddMoreMachinery, txtMachinary, txtSaveLandBuilding, txtLandAndBuilding, txtPreOperative, txtPreOperativeSave, txtSaveAdministrativeExpenses;
    private RadioGroup rgOwnershipBuilding, rgOwnershipLand;
    private RadioButton rbBuildingPease, rbBuildingOwn, rbLandLease, rbLandOwn;
    private LinearLayout linearFurnitureQuotations, linearQuotation, llDynamicMachinery, llNoOfMonthsPreBuilding, llNoOfMonthsPre, llLandAndBuilding, llTotalProjectCost, llPreOperative, llWorkingCapital, llSellingDistribution, llAdministrativeExpenses, llManpower, llUtilitiesGone, llUtilities, llDynamicRawMaterial, llRawMaterial, llDynamicEquipmentFurniture, llEquipmentFurniture, llMachinery;
    private String strOwnershipBuilding, strOwnershipLand;
    private View addMoreMachineryView, addMoreFurnitureView, addMoreRawMeterielView;
    private ImageView imgEditView, imgEditViewFurniture;
    private boolean isPlantAndMachinaryQuotation = false, isFromPlsntAndMachineryEditview = false, isFromFurnitureView = false, isFromFurnitureEditView = false, isBusinessPlanSubmitted = false;
    private Date dateEnteredPlantMachinery, dateCurrentPlantMachiney, dateEnteredPlantFurniture, dateCurrentPlantFurniture, dateEnteredPlantFurnitureEditView, dateCurrentPlantFurnitureEditView;
    private int dateDifferencePlantMachinery, dateDifferencePlantFurniture, dateDifferencePlantFurnitureEditView;
    private DatePickerDialog mDatePickerDialog;
    private Integer positionFurnitureView, getPositionFurnitureView, getPositionRawMaterielView;

    private ArrayList<SelectedParticularsModel> step30PreOperativeExpenceListData = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.LandBuildingExpensesBean> step31LandAndBuildingExpenceListData = new ArrayList<>();
    private ArrayList<LandBuildingModel> landBuildingModelArrayList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean> step3_2_GetMachineryAndEquipmentList;
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.FurnituresBean> step3_3_GetFurnitureDataList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.RawMaterialsBean> step3_4_RawMeterielAddMoreModelList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> step3_5_UtilityModelList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> mUtilitiesModelArrayList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean> step3_6_ManPowerModelList = new ArrayList<>();
    private ArrayList<ManPowerModel> mManPowerModelSaveArrayList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> step3_7_AdmistrativeList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> mAdministrativeDataList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> step3_8_SellignAndDistributionList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> mSellingAndDistributionModelList = new ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean> step3_9_WorkingCapitalList = new ArrayList<>();
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean> mWorkingCapitalModelsList = new ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public BusinessPlanStepThreeFragment() {


    }

    public static BusinessPlanStepThreeFragment newInstance(int sectionNumber, String strEnterprenuerID) {
        BusinessPlanStepThreeFragment fragment = new BusinessPlanStepThreeFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        args.putString(ENTERPRENUER_ID, strEnterprenuerID);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.business_plan_step_three_fragment, container, false);

        setIds();
        setOnClick();


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

        //SET DAFAULT DATA
        strOwnershipLand = getActivity().getResources().getString(R.string.strOwnBP);
        strOwnershipBuilding = getActivity().getResources().getString(R.string.strOwnBP);

        edtMarketSurveyExp = (EditText) mView.findViewById(R.id.edtMarketSurveyExp);
        edtStationeryExp = (EditText) mView.findViewById(R.id.edtStationeryExp);
        edtLegalExp = (EditText) mView.findViewById(R.id.edtLegalExp);
        edtEstablishmentExp = (EditText) mView.findViewById(R.id.edtEstablishmentExp);
        edtOtherExp = (EditText) mView.findViewById(R.id.edtOtherExp);
        edtAmountInRsLand = (EditText) mView.findViewById(R.id.edtAmountInRsLand);
        edtPriceLand = (EditText) mView.findViewById(R.id.edtPriceLand);
        edtAreaInFtLand = (EditText) mView.findViewById(R.id.edtAreaInFtLand);
        edtAreaInFtBuilding = (EditText) mView.findViewById(R.id.edtAreaInFtBuilding);
        edtPriceBuilding = (EditText) mView.findViewById(R.id.edtPriceBuilding);
        edtAmountInRsBuilding = (EditText) mView.findViewById(R.id.edtAmountInRsBuilding);
        edtAnnualExpenditure = (EditText) mView.findViewById(R.id.edtAnnualExpenditure);
        edtRemarks = (EditText) mView.findViewById(R.id.edtRemarks);
        edtWaterAnnualExpenditure = (EditText) mView.findViewById(R.id.edtWaterAnnualExpenditure);
        edtWaterRemarks = (EditText) mView.findViewById(R.id.edtWaterRemarks);
        edtFuelRemarks = (EditText) mView.findViewById(R.id.edtFuelRemarks);
        edtFuelAnnualExpenditure = (EditText) mView.findViewById(R.id.edtFuelAnnualExpenditure);
        edtAnyOtherAnnualExpenditure = (EditText) mView.findViewById(R.id.edtAnyOtherAnnualExpenditure);
        edtAnyOtherRemarks = (EditText) mView.findViewById(R.id.edtAnyOtherRemarks);
        edtSkilledNo = (EditText) mView.findViewById(R.id.edtSkilledNo);
        edtSkilledWagesSalaries = (EditText) mView.findViewById(R.id.edtSkilledWagesSalaries);
        edtSkilledAnnualExpenses = (EditText) mView.findViewById(R.id.edtSkilledAnnualExpenses);
        edtSemiSkilledNo = (EditText) mView.findViewById(R.id.edtSemiSkilledNo);
        edtSemiSkilledWagesSalaries = (EditText) mView.findViewById(R.id.edtSemiSkilledWagesSalaries);
        edtSemiSkilledAnnualExpenses = (EditText) mView.findViewById(R.id.edtSemiSkilledAnnualExpenses);
        edtUnskilledNo = (EditText) mView.findViewById(R.id.edtUnskilledNo);
        edtUnskilledWagesSalaries = (EditText) mView.findViewById(R.id.edtUnskilledWagesSalaries);
        edtUnskilledAnnualExpenses = (EditText) mView.findViewById(R.id.edtUnskilledAnnualExpenses);
        edtStaAmountInRs = (EditText) mView.findViewById(R.id.edtStaAmountInRs);
        edtStRemarks = (EditText) mView.findViewById(R.id.edtStRemarks);
        edtStTravelingStaAmountInRs = (EditText) mView.findViewById(R.id.edtStTravelingStaAmountInRs);
        edtStTravelingStRemarks = (EditText) mView.findViewById(R.id.edtStTravelingStRemarks);
        edtCommunicationStaAmountInRs = (EditText) mView.findViewById(R.id.edtCommunicationStaAmountInRs);
        edtCommunicationStRemarks = (EditText) mView.findViewById(R.id.edtCommunicationStRemarks);
        edtStEntertainmentStaAmountInRs = (EditText) mView.findViewById(R.id.edtStEntertainmentStaAmountInRs);
        edtStEntertainmentStRemarks = (EditText) mView.findViewById(R.id.edtStEntertainmentStRemarks);
        edtStInsuranceStaAmountInRs = (EditText) mView.findViewById(R.id.edtStInsuranceStaAmountInRs);
        edtStInsuranceStRemarks = (EditText) mView.findViewById(R.id.edtStInsuranceStRemarks);
        edtStStRentStaAmountInRs = (EditText) mView.findViewById(R.id.edtStStRentStaAmountInRs);
        edtStStRentStRemarks = (EditText) mView.findViewById(R.id.edtStStRentStRemarks);
        edtStStRepairMeintananceStaAmountInRs = (EditText) mView.findViewById(R.id.edtStStRepairMeintananceStaAmountInRs);
        edtStStRepairMeintananceStRemarks = (EditText) mView.findViewById(R.id.edtStStRepairMeintananceStRemarks);
        edtStMiscStaAmountInRs = (EditText) mView.findViewById(R.id.edtStMiscStaAmountInRs);
        edtStMiscStRemarks = (EditText) mView.findViewById(R.id.edtStMiscStRemarks);
        edtPublicityExpensesAmountInRs = (EditText) mView.findViewById(R.id.edtPublicityExpensesAmountInRs);
        edtPublicityExpensesRemarks = (EditText) mView.findViewById(R.id.edtPublicityExpensesRemarks);
        edtTravelingAmountInRs = (EditText) mView.findViewById(R.id.edtTravelingAmountInRs);
        edtTravelingRemarks = (EditText) mView.findViewById(R.id.edtTravelingRemarks);
        edtFreightAmountInRs = (EditText) mView.findViewById(R.id.edtFreightAmountInRs);
        edtFreightRemarks = (EditText) mView.findViewById(R.id.edtFreightRemarks);
        edtCommissionAmountInRs = (EditText) mView.findViewById(R.id.edtCommissionAmountInRs);
        edtCommissionRemarks = (EditText) mView.findViewById(R.id.edtCommissionRemarks);
        edtMiscAmountInRs = (EditText) mView.findViewById(R.id.edtMiscAmountInRs);
        edtMiscRemarks = (EditText) mView.findViewById(R.id.edtMiscRemarks);
        edtRawMaterialWCDuration = (EditText) mView.findViewById(R.id.edtRawMaterialWCDuration);
        edtRawMaterialWCQuantity = (EditText) mView.findViewById(R.id.edtRawMaterialWCQuantity);
        edtRawMaterialRate = (EditText) mView.findViewById(R.id.edtRawMaterialRate);
        edtRawMaterialWCAmount = (EditText) mView.findViewById(R.id.edtRawMaterialWCAmount);
        edtRawMaterialWCDescription = (EditText) mView.findViewById(R.id.edtRawMaterialWCDescription);
        edtSemiFinishedWCDuration = (EditText) mView.findViewById(R.id.edtSemiFinishedWCDuration);
        edtSemiFinishedWCQuantity = (EditText) mView.findViewById(R.id.edtSemiFinishedWCQuantity);
        edtSemiFinishedRate = (EditText) mView.findViewById(R.id.edtSemiFinishedRate);
        edtSemiFinishedWCAmount = (EditText) mView.findViewById(R.id.edtSemiFinishedWCAmount);
        edtSemiFinishedWCDescription = (EditText) mView.findViewById(R.id.edtSemiFinishedWCDescription);
        edtFinishedStockWCDuration = (EditText) mView.findViewById(R.id.edtFinishedStockWCDuration);
        edtFinishedStockWCQuantity = (EditText) mView.findViewById(R.id.edtFinishedStockWCQuantity);
        edtFinishesRate = (EditText) mView.findViewById(R.id.edtFinishesRate);
        edtFinishedStockWCAmount = (EditText) mView.findViewById(R.id.edtFinishedStockWCAmount);
        edtFinishedWCDescription = (EditText) mView.findViewById(R.id.edtFinishedWCDescription);
        edtSalesOnCreditWCDuration = (EditText) mView.findViewById(R.id.edtSalesOnCreditWCDuration);
        edtSalesOnCreditWCQuantity = (EditText) mView.findViewById(R.id.edtSalesOnCreditWCQuantity);
        edtSalesOnCreditlRate = (EditText) mView.findViewById(R.id.edtSalesOnCreditlRate);
        edtSalesOnCreditWCAmount = (EditText) mView.findViewById(R.id.edtSalesOnCreditWCAmount);
        edtProductionExpensesWCDuration = (EditText) mView.findViewById(R.id.edtProductionExpensesWCDuration);
        edtProductionExpensesWCQuantity = (EditText) mView.findViewById(R.id.edtProductionExpensesWCQuantity);
        edtProductionExpensesWCAmount = (EditText) mView.findViewById(R.id.edtProductionExpensesWCAmount);
        edtWCTotalWorkingCapitalNeeded = (EditText) mView.findViewById(R.id.edtWCTotalWorkingCapitalNeeded);
        edtCostPreOperative = (EditText) mView.findViewById(R.id.edtCostPreOperative);
        edtCostLandBuilding = (EditText) mView.findViewById(R.id.edtCostLandBuilding);
        edtCostMachinary = (EditText) mView.findViewById(R.id.edtCostMachinary);
        edtCostEquipment = (EditText) mView.findViewById(R.id.edtCostEquipment);
        edtCostWorkingCapital = (EditText) mView.findViewById(R.id.edtCostWorkingCapital);
        edtTotalProjectCost = (EditText) mView.findViewById(R.id.edtTotalProjectCost);
        edtNoOfMonPreOperativeLand = (EditText) mView.findViewById(R.id.edtNoOfMonPreOperativeLand);
        edtNoOfMonPreOperativeBuilding = (EditText) mView.findViewById(R.id.edtNoOfMonPreOperativeBuilding);
        edtOfficeStaffNo = (EditText) mView.findViewById(R.id.edtOfficeStaffNo);
        edtOfficeStaffWagesSalaries = (EditText) mView.findViewById(R.id.edtOfficeStaffWagesSalaries);
        edtOfficeStaffAnnualExpenses = (EditText) mView.findViewById(R.id.edtOfficeStaffAnnualExpenses);
        edtAnyOtherNo = (EditText) mView.findViewById(R.id.edtAnyOtherNo);
        edtAnyOtherWagesSalaries = (EditText) mView.findViewById(R.id.edtAnyOtherWagesSalaries);
        edtAnyOtherAnnualExpenses = (EditText) mView.findViewById(R.id.edtAnyOtherAnnualExpenses);


        txtSaveAdministrativeExpenses = (TextView) mView.findViewById(R.id.txtSaveAdministrativeExpenses);
        txtPreOperativeSave = (TextView) mView.findViewById(R.id.txtPreOperativeSave);
        txtPreOperative = (TextView) mView.findViewById(R.id.txtPreOperative);
        txtLandAndBuilding = (TextView) mView.findViewById(R.id.txtLandAndBuilding);
        txtSaveLandBuilding = (TextView) mView.findViewById(R.id.txtSaveLandBuilding);
        txtMachinary = (TextView) mView.findViewById(R.id.txtMachinary);
        txtBtnAddMoreMachinery = (TextView) mView.findViewById(R.id.txtBtnAddMoreMachinery);
        txtSaveMachinery = (TextView) mView.findViewById(R.id.txtSaveMachinery);
        txtEquipmentFurniture = (TextView) mView.findViewById(R.id.txtEquipmentFurniture);
        txtBtnAddMoreEquipmentFurniture = (TextView) mView.findViewById(R.id.txtBtnAddMoreEquipmentFurniture);
        txtSaveEquipmentFurniture = (TextView) mView.findViewById(R.id.txtSaveEquipmentFurniture);
        txtBtnAddMoreRawMaterial = (TextView) mView.findViewById(R.id.txtBtnAddMoreRawMaterial);
        txtSaveRawMaterial = (TextView) mView.findViewById(R.id.txtSaveRawMaterial);
        txtUtilities = (TextView) mView.findViewById(R.id.txtUtilities);
        txtSaveUtilities = (TextView) mView.findViewById(R.id.txtSaveUtilities);
        txtManpower = (TextView) mView.findViewById(R.id.txtManpower);
        txtSaveManPower = (TextView) mView.findViewById(R.id.txtSaveManPower);
        txtAdministrativeExpenses = (TextView) mView.findViewById(R.id.txtAdministrativeExpenses);
        txtSellingDistribution = (TextView) mView.findViewById(R.id.txtSellingDistribution);
        txtSaveSellingDistribution = (TextView) mView.findViewById(R.id.txtSaveSellingDistribution);
        txtWorkingCapital = (TextView) mView.findViewById(R.id.txtWorkingCapital);
        txtSaveWorkingCapital = (TextView) mView.findViewById(R.id.txtSaveWorkingCapital);
        txtTotalProjectCost = (TextView) mView.findViewById(R.id.txtTotalProjectCost);
        txtRawMaterial = (TextView) mView.findViewById(R.id.txtRawMaterial);
        txtBuildingSquarFoot = (TextView) mView.findViewById(R.id.txtBuildingSquarFoot);
        txtLandSquarFoot = (TextView) mView.findViewById(R.id.txtLandSquarFoot);
        txtTitleLandAmount = (TextView) mView.findViewById(R.id.txtTitleLandAmount);
        txtTitleBuildingAmount = (TextView) mView.findViewById(R.id.txtTitleBuildingAmount);

        rgOwnershipLand = (RadioGroup) mView.findViewById(R.id.rgOwnershipLand);
        rgOwnershipBuilding = (RadioGroup) mView.findViewById(R.id.rgOwnershipBuilding);

        rbLandOwn = (RadioButton) mView.findViewById(R.id.rbLandOwn);
        rbLandLease = (RadioButton) mView.findViewById(R.id.rbLandLease);
        rbBuildingOwn = (RadioButton) mView.findViewById(R.id.rbBuildingOwn);
        rbBuildingPease = (RadioButton) mView.findViewById(R.id.rbBuildingPease);

        llMachinery = (LinearLayout) mView.findViewById(R.id.llMachinery);
        llDynamicMachinery = (LinearLayout) mView.findViewById(R.id.llDynamicMachinery);
        llEquipmentFurniture = (LinearLayout) mView.findViewById(R.id.llEquipmentFurniture);
        llDynamicEquipmentFurniture = (LinearLayout) mView.findViewById(R.id.llDynamicEquipmentFurniture);
        llRawMaterial = (LinearLayout) mView.findViewById(R.id.llRawMaterial);
        llDynamicRawMaterial = (LinearLayout) mView.findViewById(R.id.llDynamicRawMaterial);
        llUtilities = (LinearLayout) mView.findViewById(R.id.llUtilities);
        llUtilitiesGone = (LinearLayout) mView.findViewById(R.id.llUtilitiesGone);
        llManpower = (LinearLayout) mView.findViewById(R.id.llManpower);
        llAdministrativeExpenses = (LinearLayout) mView.findViewById(R.id.llAdministrativeExpenses);
        llSellingDistribution = (LinearLayout) mView.findViewById(R.id.llSellingDistribution);
        llWorkingCapital = (LinearLayout) mView.findViewById(R.id.llWorkingCapital);
        llPreOperative = (LinearLayout) mView.findViewById(R.id.llPreOperative);
        llTotalProjectCost = (LinearLayout) mView.findViewById(R.id.llTotalProjectCost);
        llLandAndBuilding = (LinearLayout) mView.findViewById(R.id.llLandAndBuilding);
        llNoOfMonthsPre = (LinearLayout) mView.findViewById(R.id.llNoOfMonthsPre);
        llNoOfMonthsPreBuilding = (LinearLayout) mView.findViewById(R.id.llNoOfMonthsPreBuilding);

        //SET LIMIT TO NO OF MONTHS, ITS ALLOW ONLY ENTER ONLY 1 TO 12
        edtNoOfMonPreOperativeBuilding.setFilters(new InputFilter[]{new InputFilterMinMax(1, 12)});
        edtNoOfMonPreOperativeLand.setFilters(new InputFilter[]{new InputFilterMinMax(1, 12)});

        //CHECK IF BUSINESS PLAN IS ALREADY SUBMITTED
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getIsBusinessPlanSubmited() == 1) {
                isBusinessPlanSubmitted = true;
                makeViewUnEditable();
            }
        }

        //DISPLAY AUTO FILL DATA FOR 3.0 IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayPreOperativeExpence();

        //DISPLAY AUTO FILL DATA FOR 3.1 IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayLandAndBuildingExpence();

        //DISPLAY STEP 3.2 MACHINARY AND EQUIPMENTS DATA IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayMachinerAndEquipmentData(false, false);

        //DISPLAY STEP 3.3 FURNITURE AND EQUIPMENTS DATA IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayFurnitureData(false, false);

        //DISPLAY STEP 3.4 RAW MATERIALS DATA IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayRawMaterirelDataData(false, false);

        //DISPLAY STEP 3.5 UTILITY DATA IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayUtilityList();

        //DISPLAY STEP 3.6 MAN POWER DATA IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayManPowerList();

        //DISPLAY STEP 3.7 ADMINISTRATIVE EXPENSES DATA IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displayAdministrativeList();

        //DISPLAY STEP 3.8 ADMINISTRATIVE EXPENSES DATA IF THERE IS DATA IN LOCAL DATABSE ELSE IT SHOULD DISPLAY BLANK
        displaySellingAndDistributionList();

        //Display 3.9 Working Capital Data
        //Set default values in session manager for working capital
        mSessionManager.updatePreferenceString(Constants.TOTAL_WORKING_CAPITAL, "");
        displayWorkingCapitalData();

        //CALCULATE WORKING CAPITAL FOR SAVED DATA
        calculateWorkingCapital();


        //SET ALL CLICK EVENTS ETC. RADIO BUTTON AND RADIO GROUP, EDIT TEXT, TEXT CHANGE LISTNER
        setAllClicks();


    }


    private void setOnClick() {

        txtPreOperative.setOnClickListener(this);
        txtPreOperativeSave.setOnClickListener(this);
        txtLandAndBuilding.setOnClickListener(this);
        txtSaveLandBuilding.setOnClickListener(this);
        txtMachinary.setOnClickListener(this);
        txtBtnAddMoreMachinery.setOnClickListener(this);
        txtSaveMachinery.setOnClickListener(this);
        txtEquipmentFurniture.setOnClickListener(this);
        txtBtnAddMoreEquipmentFurniture.setOnClickListener(this);
        txtSaveEquipmentFurniture.setOnClickListener(this);
        txtRawMaterial.setOnClickListener(this);
        txtBtnAddMoreRawMaterial.setOnClickListener(this);
        txtSaveRawMaterial.setOnClickListener(this);
        txtUtilities.setOnClickListener(this);
        txtSaveUtilities.setOnClickListener(this);
        txtManpower.setOnClickListener(this);
        txtSaveManPower.setOnClickListener(this);
        txtAdministrativeExpenses.setOnClickListener(this);
        txtSaveAdministrativeExpenses.setOnClickListener(this);
        txtSellingDistribution.setOnClickListener(this);
        txtSaveSellingDistribution.setOnClickListener(this);
        txtWorkingCapital.setOnClickListener(this);
        txtSaveWorkingCapital.setOnClickListener(this);
        txtTotalProjectCost.setOnClickListener(this);

    }

    private void makeViewUnEditable() {
        txtSaveAdministrativeExpenses.setVisibility(View.GONE);
        txtPreOperativeSave.setVisibility(View.GONE);
        edtMarketSurveyExp.setFocusableInTouchMode(false);
        edtStationeryExp.setFocusableInTouchMode(false);
        edtLegalExp.setFocusableInTouchMode(false);
        edtEstablishmentExp.setFocusableInTouchMode(false);
        edtOtherExp.setFocusableInTouchMode(false);
        edtAmountInRsLand.setFocusableInTouchMode(false);
        edtPriceLand.setFocusableInTouchMode(false);
        edtAreaInFtLand.setFocusableInTouchMode(false);
        edtAreaInFtBuilding.setFocusableInTouchMode(false);
        edtPriceBuilding.setFocusableInTouchMode(false);
        edtAmountInRsBuilding.setFocusableInTouchMode(false);
        edtAnnualExpenditure.setFocusableInTouchMode(false);
        edtRemarks.setFocusableInTouchMode(false);
        edtWaterAnnualExpenditure.setFocusableInTouchMode(false);
        edtWaterRemarks.setFocusableInTouchMode(false);
        edtFuelRemarks.setFocusableInTouchMode(false);
        edtFuelAnnualExpenditure.setFocusableInTouchMode(false);
        edtAnyOtherAnnualExpenditure.setFocusableInTouchMode(false);
        edtAnyOtherRemarks.setFocusableInTouchMode(false);
        edtSkilledNo.setFocusableInTouchMode(false);
        edtSkilledWagesSalaries.setFocusableInTouchMode(false);
        edtSkilledAnnualExpenses.setFocusableInTouchMode(false);
        edtSemiSkilledNo.setFocusableInTouchMode(false);
        edtSemiSkilledWagesSalaries.setFocusableInTouchMode(false);
        edtSemiSkilledAnnualExpenses.setFocusableInTouchMode(false);
        edtUnskilledNo.setFocusableInTouchMode(false);
        edtUnskilledWagesSalaries.setFocusableInTouchMode(false);
        edtUnskilledAnnualExpenses.setFocusableInTouchMode(false);
        edtStaAmountInRs.setFocusableInTouchMode(false);
        edtStRemarks.setFocusableInTouchMode(false);
        edtStTravelingStaAmountInRs.setFocusableInTouchMode(false);
        edtStTravelingStRemarks.setFocusableInTouchMode(false);
        edtCommunicationStaAmountInRs.setFocusableInTouchMode(false);
        edtCommunicationStRemarks.setFocusableInTouchMode(false);
        edtStEntertainmentStaAmountInRs.setFocusableInTouchMode(false);
        edtStEntertainmentStRemarks.setFocusableInTouchMode(false);
        edtStInsuranceStaAmountInRs.setFocusableInTouchMode(false);
        edtStInsuranceStRemarks.setFocusableInTouchMode(false);
        edtStStRentStaAmountInRs.setFocusableInTouchMode(false);
        edtStStRentStRemarks.setFocusableInTouchMode(false);
        edtStStRepairMeintananceStaAmountInRs.setFocusableInTouchMode(false);
        edtStStRepairMeintananceStRemarks.setFocusableInTouchMode(false);
        edtStMiscStaAmountInRs.setFocusableInTouchMode(false);
        edtStMiscStRemarks.setFocusableInTouchMode(false);
        edtPublicityExpensesAmountInRs.setFocusableInTouchMode(false);
        edtPublicityExpensesRemarks.setFocusableInTouchMode(false);
        edtTravelingAmountInRs.setFocusableInTouchMode(false);
        edtTravelingRemarks.setFocusableInTouchMode(false);
        edtFreightAmountInRs.setFocusableInTouchMode(false);
        edtFreightRemarks.setFocusableInTouchMode(false);
        edtCommissionAmountInRs.setFocusableInTouchMode(false);
        edtCommissionRemarks.setFocusableInTouchMode(false);
        edtMiscAmountInRs.setFocusableInTouchMode(false);
        edtMiscRemarks.setFocusableInTouchMode(false);
        edtRawMaterialWCDuration.setFocusableInTouchMode(false);
        edtRawMaterialWCQuantity.setFocusableInTouchMode(false);
        edtRawMaterialRate.setFocusableInTouchMode(false);
        edtRawMaterialWCAmount.setFocusableInTouchMode(false);
        edtRawMaterialWCDescription.setFocusableInTouchMode(false);
        edtSemiFinishedWCDuration.setFocusableInTouchMode(false);
        edtSemiFinishedWCQuantity.setFocusableInTouchMode(false);
        edtSemiFinishedRate.setFocusableInTouchMode(false);
        edtSemiFinishedWCAmount.setFocusableInTouchMode(false);
        edtSemiFinishedWCDescription.setFocusableInTouchMode(false);
        edtFinishedStockWCDuration.setFocusableInTouchMode(false);
        edtFinishedStockWCQuantity.setFocusableInTouchMode(false);
        edtFinishesRate.setFocusableInTouchMode(false);
        edtFinishedStockWCAmount.setFocusableInTouchMode(false);
        edtFinishedWCDescription.setFocusableInTouchMode(false);
        edtSalesOnCreditWCDuration.setFocusableInTouchMode(false);
        edtSalesOnCreditWCQuantity.setFocusableInTouchMode(false);
        edtSalesOnCreditlRate.setFocusableInTouchMode(false);
        edtSalesOnCreditWCAmount.setFocusableInTouchMode(false);
        edtProductionExpensesWCDuration.setFocusableInTouchMode(false);
        edtProductionExpensesWCQuantity.setFocusableInTouchMode(false);
        edtProductionExpensesWCAmount.setFocusableInTouchMode(false);
        edtWCTotalWorkingCapitalNeeded.setFocusableInTouchMode(false);
        edtCostPreOperative.setFocusableInTouchMode(false);
        edtCostLandBuilding.setFocusableInTouchMode(false);
        edtCostMachinary.setFocusableInTouchMode(false);
        edtCostEquipment.setFocusableInTouchMode(false);
        edtCostWorkingCapital.setFocusableInTouchMode(false);
        edtTotalProjectCost.setFocusableInTouchMode(false);
        edtNoOfMonPreOperativeLand.setFocusableInTouchMode(false);
        edtNoOfMonPreOperativeBuilding.setFocusableInTouchMode(false);
        edtOfficeStaffNo.setFocusableInTouchMode(false);
        edtOfficeStaffWagesSalaries.setFocusableInTouchMode(false);
        edtOfficeStaffAnnualExpenses.setFocusableInTouchMode(false);
        edtAnyOtherNo.setFocusableInTouchMode(false);
        edtAnyOtherWagesSalaries.setFocusableInTouchMode(false);
        edtAnyOtherAnnualExpenses.setFocusableInTouchMode(false);

        txtSaveLandBuilding.setVisibility(View.GONE);
        txtBtnAddMoreMachinery.setVisibility(View.GONE);
        txtSaveMachinery.setVisibility(View.GONE);
        txtBtnAddMoreEquipmentFurniture.setVisibility(View.GONE);
        txtSaveEquipmentFurniture.setVisibility(View.GONE);
        txtBtnAddMoreRawMaterial.setVisibility(View.GONE);
        txtSaveRawMaterial.setVisibility(View.GONE);
        txtSaveUtilities.setVisibility(View.GONE);
        txtSaveManPower.setVisibility(View.GONE);
        txtSaveSellingDistribution.setVisibility(View.GONE);
        txtSaveWorkingCapital.setVisibility(View.GONE);

        rbLandOwn.setClickable(false);
        rbLandLease.setClickable(false);
        rbBuildingOwn.setClickable(false);
        rbBuildingPease.setClickable(false);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtPreOperative:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llPreOperative.getVisibility() == View.VISIBLE) {
                        llPreOperative.setVisibility(View.GONE);
                    } else {
                        llPreOperative.setVisibility(View.VISIBLE);
                    }
                } else {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }

                break;
            case R.id.txtPreOperativeSave:

                //SAVE STEP 3.0 OPERATION DATA IN TO DATABSE
                savePreOperativeData();

                break;

            case R.id.txtLandAndBuilding:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llLandAndBuilding.getVisibility() == View.VISIBLE) {
                        llLandAndBuilding.setVisibility(View.GONE);
                    } else {
                        llLandAndBuilding.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }
                break;

            case R.id.txtSaveLandBuilding:

                //SAVE STPE 3.1 BUILDING AND LAND DATA IN TO DATABASE
                saveLandAndBuildingData();

                break;
            case R.id.txtMachinary:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llMachinery.getVisibility() == View.VISIBLE) {
                        llMachinery.setVisibility(View.GONE);
                    } else {
                        llMachinery.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }
                break;
            case R.id.txtBtnAddMoreMachinery:

                //SAVE DATA IN TO DATABASE AND PER CONDITIONS ID FROM ADD BUTTON OR SAVE BUTTON
                savePlantAndMachineryDataInToDatabase(true);

                break;
            case R.id.txtSaveMachinery:

                //SAVE DATA IN TO DATABASE AND PER CONDITIONS ID FROM ADD BUTTON OR SAVE BUTTON
                if (checkValidationPlantAndMachinery()) {
                    savePlantAndMachineryDataInToDatabase(false);
                    llMachinery.setVisibility(View.GONE);
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strMessagePlantAndMachineryDataSavedSuccessfully));
                }
                break;
            case R.id.txtEquipmentFurniture:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llEquipmentFurniture.getVisibility() == View.VISIBLE) {
                        llEquipmentFurniture.setVisibility(View.GONE);
                    } else {
                        llEquipmentFurniture.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }
                break;

            case R.id.txtBtnAddMoreEquipmentFurniture:

                //sava data in to database and per condition is from ADD button OR SAVE button
                saveFurnitureDataInToDatabase(true);

                break;
            case R.id.txtSaveEquipmentFurniture:

                //sava data in to database and per condition is from ADD button OR SAVE button
                if (checkValidationFurniture()) {
                    saveFurnitureDataInToDatabase(false);
                    llEquipmentFurniture.setVisibility(View.GONE);
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strMessageSaveDurnitureData));
                }
                break;

            case R.id.txtRawMaterial:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llRawMaterial.getVisibility() == View.VISIBLE) {
                        llRawMaterial.setVisibility(View.GONE);
                    } else {
                        llRawMaterial.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }

                break;

            case R.id.txtBtnAddMoreRawMaterial:

                //sava data in to database and per condition is from ADD button OR SAVE button
                tvSaveRawMaterialDataInToDatabase(true);

                break;
            case R.id.txtSaveRawMaterial:
                //sava data in to database and per condition is from ADD button OR SAVE button

                if (checkValidationforRawMateriel()) {
                    tvSaveRawMaterialDataInToDatabase(false);
                    llRawMaterial.setVisibility(View.GONE);
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strMessageSaveRawMeterielData));
                }
                break;
            case R.id.txtUtilities:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llUtilities.getVisibility() == View.VISIBLE) {
                        llUtilities.setVisibility(View.GONE);
                    } else {
                        llUtilities.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }
                break;
            case R.id.txtSaveUtilities:

                //Save Utitlity Items In to database
                saveUtilityItemsInDatabase();

                break;
            case R.id.txtManpower:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llManpower.getVisibility() == View.VISIBLE) {
                        llManpower.setVisibility(View.GONE);
                    } else {
                        llManpower.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }
                break;
            case R.id.txtSaveManPower:

                //Save man power data in to database
                saveManPoweDataIntoDatabase();

                break;
            case R.id.txtAdministrativeExpenses:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llAdministrativeExpenses.getVisibility() == View.VISIBLE) {
                        llAdministrativeExpenses.setVisibility(View.GONE);
                    } else {
                        llAdministrativeExpenses.setVisibility(View.VISIBLE);

                        //Display prepopulated data for rent which is filled in Land and Building
                        //Changed by ketan suggested by Yagnik sir and Riddhi
                        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {

                            Double dblPriceVal = 0.0, dblPriceValBuilding = 0.0;
                            if (!mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses().get(0).getOwnership().equalsIgnoreCase(getActivity().getResources().getString(R.string.strOwnBP)) || !mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses().get(1).getOwnership().equalsIgnoreCase(getActivity().getResources().getString(R.string.strOwnBP))) {

                                if (!mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses().get(0).getOwnership().equalsIgnoreCase(getActivity().getResources().getString(R.string.strOwnBP))) {
                                    dblPriceVal = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses().get(0).getAmount();
                                }

                                if (!mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses().get(1).getOwnership().equalsIgnoreCase(getActivity().getResources().getString(R.string.strOwnBP))) {
                                    dblPriceValBuilding = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses().get(1).getAmount();
                                }
                                edtStStRentStaAmountInRs.setText("" + (dblPriceVal.intValue() + dblPriceValBuilding.intValue()));
                            } else {
                                edtStStRentStaAmountInRs.setText("0");
                            }

                        }
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }


                break;
            case R.id.txtSaveAdministrativeExpenses:

                //Save man power data in to database
                saveAdministrativeData();

                break;

            case R.id.txtSellingDistribution:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llSellingDistribution.getVisibility() == View.VISIBLE) {
                        llSellingDistribution.setVisibility(View.GONE);
                    } else {
                        llSellingDistribution.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }
                break;

            case R.id.txtSaveSellingDistribution:

                //Save man power data in to database
                saveSellingAndDistributionExpenseData();

                break;

            case R.id.txtWorkingCapital:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llWorkingCapital.getVisibility() == View.VISIBLE) {
                        llWorkingCapital.setVisibility(View.GONE);
                    } else {
                        llWorkingCapital.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }

                break;
            case R.id.txtSaveWorkingCapital:

                //Save man power data in to database
                saveWorkingCapitalData();

                break;
            case R.id.txtTotalProjectCost:

                //HIDE KEYBOARD
                CommonMethods.hideKeybord(mActivity);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    if (llTotalProjectCost.getVisibility() == View.VISIBLE) {
                        llTotalProjectCost.setVisibility(View.GONE);
                    } else {
                        llTotalProjectCost.setVisibility(View.VISIBLE);
                        calculateALlEXpenses();
                    }
                } else {

                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }


                break;


        }

    }

    private void displayPreOperativeExpence() {

        //GET PRE-OPERATIVE DATA FROM DATABASE FOR AUTO FILL AND EDIT PURPOSE
        step30PreOperativeExpenceListData = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));

        if (step30PreOperativeExpenceListData.size() != 0 && step30PreOperativeExpenceListData != null) {

            edtMarketSurveyExp.setText("" + step30PreOperativeExpenceListData.get(0).getAmount().intValue());
            edtStationeryExp.setText("" + step30PreOperativeExpenceListData.get(1).getAmount().intValue());
            edtLegalExp.setText("" + step30PreOperativeExpenceListData.get(2).getAmount().intValue());
            edtEstablishmentExp.setText("" + step30PreOperativeExpenceListData.get(3).getAmount().intValue());

            if (step30PreOperativeExpenceListData.size() > 4) {
                edtOtherExp.setText("" + step30PreOperativeExpenceListData.get(4).getAmount().intValue());
            } else {
                edtOtherExp.setText("" + 0.0);
            }

            //DISPLAY TOTAL COST FROM DATABASE IF USER ALREADY ENTERED DATA
            Double TotalCostOfPreOperative = 0.0;
            for (int j = 0; j < step30PreOperativeExpenceListData.size(); j++) {
                TotalCostOfPreOperative = TotalCostOfPreOperative + step30PreOperativeExpenceListData.get(j).getAmount();
            }
            edtCostPreOperative.setText("" + TotalCostOfPreOperative.intValue());


        }
    }

    private void savePreOperativeData() {

        //CHECK IF THERE IS NO DATA FILLED IN EDIT TEXT AND PRESS SAVE BUTTON
        if (edtMarketSurveyExp.getText().toString().isEmpty() && edtStationeryExp.getText().toString().isEmpty() && edtLegalExp.getText().toString().isEmpty() && edtEstablishmentExp.getText().toString().isEmpty() && edtOtherExp.getText().toString().isEmpty()) {

            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterSomeDetailsIN));

        } else {

            //MAKE ARRAYLIST FOR STEP 3.0 LATER WE WILL USE IT FOE SAVE IN TO DATABASE
            ArrayList<SelectedParticularsModel> particularsEditedAnswerModelArrayList = new ArrayList<SelectedParticularsModel>();

            //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
            SelectedParticularsModel selectedParticularsModelMarketSurvey = new SelectedParticularsModel();
            if (edtMarketSurveyExp.getText().toString().isEmpty()) {
                selectedParticularsModelMarketSurvey.setAmount(0.0);
            } else {
                selectedParticularsModelMarketSurvey.setAmount(Double.valueOf(edtMarketSurveyExp.getText().toString()));
            }
            selectedParticularsModelMarketSurvey.setId(1L);
            selectedParticularsModelMarketSurvey.setPreoperativeExpenditureParticularId(1L);
            selectedParticularsModelMarketSurvey.setName(getActivity().getResources().getString(R.string.strMarketSurveyExp));
            particularsEditedAnswerModelArrayList.add(selectedParticularsModelMarketSurvey);

            //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
            SelectedParticularsModel selectedParticularsModelStationary = new SelectedParticularsModel();
            if (edtStationeryExp.getText().toString().isEmpty()) {
                selectedParticularsModelStationary.setAmount(0.0);
            } else {
                selectedParticularsModelStationary.setAmount(Double.valueOf(edtStationeryExp.getText().toString()));
            }
            selectedParticularsModelStationary.setId(2L);
            selectedParticularsModelStationary.setPreoperativeExpenditureParticularId(2L);
            selectedParticularsModelStationary.setName(getActivity().getResources().getString(R.string.strStationeryExp));
            particularsEditedAnswerModelArrayList.add(selectedParticularsModelStationary);

            //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
            SelectedParticularsModel selectedParticularsModelLegalExpence = new SelectedParticularsModel();
            if (edtLegalExp.getText().toString().isEmpty()) {
                selectedParticularsModelLegalExpence.setAmount(0.0);
            } else {
                selectedParticularsModelLegalExpence.setAmount(Double.valueOf(edtLegalExp.getText().toString()));
            }
            selectedParticularsModelLegalExpence.setId(3L);
            selectedParticularsModelLegalExpence.setPreoperativeExpenditureParticularId(3L);
            selectedParticularsModelLegalExpence.setName(getActivity().getResources().getString(R.string.strLegalExp));
            particularsEditedAnswerModelArrayList.add(selectedParticularsModelLegalExpence);

            //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
            SelectedParticularsModel selectedParticularsModelEstalblisExpence = new SelectedParticularsModel();
            if (edtEstablishmentExp.getText().toString().isEmpty()) {
                selectedParticularsModelEstalblisExpence.setAmount(0.0);
            } else {
                selectedParticularsModelEstalblisExpence.setAmount(Double.valueOf(edtEstablishmentExp.getText().toString()));
            }
            selectedParticularsModelEstalblisExpence.setId(4L);
            selectedParticularsModelEstalblisExpence.setPreoperativeExpenditureParticularId(4L);
            selectedParticularsModelEstalblisExpence.setName(getActivity().getResources().getString(R.string.strEstablishmentExp));
            particularsEditedAnswerModelArrayList.add(selectedParticularsModelEstalblisExpence);

            //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
            SelectedParticularsModel selectedParticularsModelOtherExpence = new SelectedParticularsModel();
            if (edtOtherExp.getText().toString().isEmpty()) {
                selectedParticularsModelOtherExpence.setAmount(0.0);
            } else {
                selectedParticularsModelOtherExpence.setAmount(Double.valueOf(edtOtherExp.getText().toString()));
            }
            selectedParticularsModelOtherExpence.setId(5L);
            selectedParticularsModelOtherExpence.setPreoperativeExpenditureParticularId(5L);
            selectedParticularsModelOtherExpence.setName(getActivity().getResources().getString(R.string.strOtherExp));
            particularsEditedAnswerModelArrayList.add(selectedParticularsModelOtherExpence);


            //INSERT STEP 3.0 DATA IN TO DATABASE, LATER WE WILL USE IT FOR PRE-POPULATED
            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_0_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {

                    mDatabaseHelper.insertEntrepreneurBP_3_0_step(
                            new Gson().toJson(particularsEditedAnswerModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );

                } else {

                    mDatabaseHelper.updateEntrepreneurBP_3_0_step(
                            new Gson().toJson(particularsEditedAnswerModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );

                }

                if (llPreOperative.getVisibility() == View.VISIBLE) {
                    llPreOperative.setVisibility(View.GONE);
                } else {
                    llPreOperative.setVisibility(View.VISIBLE);
                }

                //DISPLAY DATA SAVE SUCCESSFULLY MESSAGE
                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));

                Double TotalCostOfPreOperative = 0.0;

                //CALCULATE ALL STEP 3.0 ITEMS VALUES FOR TOTAL COST
                for (int i = 0; i < particularsEditedAnswerModelArrayList.size(); i++) {
                    TotalCostOfPreOperative = TotalCostOfPreOperative + particularsEditedAnswerModelArrayList.get(i).getAmount();
                }
                edtCostPreOperative.setText(String.valueOf(TotalCostOfPreOperative.intValue()));

            } else {

                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }
        }


    }

    private void displayLandAndBuildingExpence() {

        //GET DATA FROM DATABASE FOR AUTO FILL AND EDIT PURPOSE
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            step31LandAndBuildingExpenceListData = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getLandBuildingExpenses();

            //GET DATA FOR LAND;
            strOwnershipLand = step31LandAndBuildingExpenceListData.get(0).getOwnership();
            if (step31LandAndBuildingExpenceListData.get(0).getOwnership().equalsIgnoreCase(getActivity().getResources().getString(R.string.strOwnBP))) {
                rbLandOwn.setChecked(true);
                rbLandLease.setChecked(false);
                llNoOfMonthsPre.setVisibility(View.GONE);
                txtTitleLandAmount.setText(getResources().getString(R.string.strAmount));

            } else {
                rbLandOwn.setChecked(false);
                rbLandLease.setChecked(true);
                llNoOfMonthsPre.setVisibility(View.VISIBLE);
                txtTitleLandAmount.setText(getResources().getString(R.string.strRatePerYear));
            }


            Double dblAmountInRsVal, dblPriceVal;
            dblAmountInRsVal = step31LandAndBuildingExpenceListData.get(0).getAmount();
            dblPriceVal = step31LandAndBuildingExpenceListData.get(0).getPrice();

            edtAreaInFtLand.setText("" + step31LandAndBuildingExpenceListData.get(0).getArea());
            edtNoOfMonPreOperativeLand.setText("" + step31LandAndBuildingExpenceListData.get(0).getPreOperativeMonths());
            edtPriceLand.setText("" + dblPriceVal.intValue());
            edtAmountInRsLand.setText("" + dblAmountInRsVal.intValue());

            //GET DATA FOR BUILDING:
            strOwnershipBuilding = step31LandAndBuildingExpenceListData.get(1).getOwnership();

            if (step31LandAndBuildingExpenceListData.get(1).getOwnership().equalsIgnoreCase(getActivity().getResources().getString(R.string.strOwnBP))) {
                rbBuildingOwn.setChecked(true);
                rbBuildingPease.setChecked(false);
                llNoOfMonthsPreBuilding.setVisibility(View.GONE);
                txtTitleBuildingAmount.setText(getResources().getString(R.string.strAmount));

            } else {
                rbBuildingOwn.setChecked(false);
                rbBuildingPease.setChecked(true);
                llNoOfMonthsPreBuilding.setVisibility(View.VISIBLE);
                txtTitleBuildingAmount.setText(getResources().getString(R.string.strRatePerYear));


            }
            Double dblPrice1, dblAmountInRs1;
            dblPrice1 = step31LandAndBuildingExpenceListData.get(1).getPrice();
            dblAmountInRs1 = step31LandAndBuildingExpenceListData.get(1).getAmount();

            edtAreaInFtBuilding.setText("" + step31LandAndBuildingExpenceListData.get(1).getArea());
            edtNoOfMonPreOperativeBuilding.setText("" + step31LandAndBuildingExpenceListData.get(1).getPreOperativeMonths());
            edtPriceBuilding.setText("" + dblPrice1.intValue());
            edtAmountInRsBuilding.setText("" + dblAmountInRs1.intValue());

            /*Double TotalCostLandBuilding = step31LandAndBuildingExpenceListData.get(0).getAmount() + step31LandAndBuildingExpenceListData.get(1).getAmount();
            edtCostLandBuilding.setText("" + TotalCostLandBuilding.intValue());*/

            Double TotalCostLandBuilding = 0.0;
            if (!strOwnershipLand.equals(getActivity().getResources().getString(R.string.strOwnBP))) {
                TotalCostLandBuilding = step31LandAndBuildingExpenceListData.get(0).getAmount();
            }

            if (!strOwnershipBuilding.equals(getActivity().getResources().getString(R.string.strOwnBP))) {
                TotalCostLandBuilding = (TotalCostLandBuilding + step31LandAndBuildingExpenceListData.get(1).getAmount());
            }
            edtCostLandBuilding.setText("" + TotalCostLandBuilding.intValue());

            edtNoOfMonPreOperativeLand.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    edtAreaInFtLand.setText("");
                    edtPriceLand.setText("");
                    edtAmountInRsLand.setText("");
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            edtNoOfMonPreOperativeBuilding.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    edtAreaInFtBuilding.setText("");
                    edtPriceBuilding.setText("");
                    edtAmountInRsBuilding.setText("");
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }
    }

    private void saveLandAndBuildingData() {

        if (checkValidation()) {
            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                landBuildingModelArrayList = new ArrayList<LandBuildingModel>();
                int intMonthsLand, intMonthsBuilding;

                //CHECK CONDITION BASED ON OWN OR LEASE, OWN= GET DATA FROM VIEW ELSE "0"
                if (strOwnershipLand.equals(getActivity().getString(R.string.strLeaseBP))) {
                    intMonthsLand = Integer.parseInt(edtNoOfMonPreOperativeLand.getText().toString());
                } else {
                    intMonthsLand = 0;
                }

                //CHECK CONDITION BASED ON OWN OR LEASE, OWN= GET DATA FROM VIEW ELSE "0"
                if (strOwnershipBuilding.equals(getActivity().getString(R.string.strLeaseBP))) {
                    intMonthsBuilding = Integer.parseInt(edtNoOfMonPreOperativeBuilding.getText().toString());
                } else {
                    intMonthsBuilding = 0;
                }

                //MAKE MODEL CLASS FOR SAVE DATA FOR EACH VIEW (LAND)
                LandBuildingModel landBuildingModelLand = new LandBuildingModel();
                landBuildingModelLand.setLandBuildingExpensesParticularId(1L);
                landBuildingModelLand.setArea(Long.valueOf(edtAreaInFtLand.getText().toString()));
                landBuildingModelLand.setPrice(Double.valueOf(edtPriceLand.getText().toString()));
                landBuildingModelLand.setAmount(Double.valueOf(edtAmountInRsLand.getText().toString()));
                landBuildingModelLand.setOwnership(strOwnershipLand);
                landBuildingModelLand.setPreOperativeMonths(intMonthsLand);
                landBuildingModelArrayList.add(landBuildingModelLand);

                //MAKE MODEL CLASS FOR SAVE DATA FOR EACH VIEW (BUILDING)
                LandBuildingModel landBuildingModelBuilding = new LandBuildingModel();
                landBuildingModelBuilding.setLandBuildingExpensesParticularId(2L);
                landBuildingModelBuilding.setArea(Long.valueOf(edtAreaInFtBuilding.getText().toString()));
                landBuildingModelBuilding.setPrice(Double.valueOf(edtPriceBuilding.getText().toString()));
                landBuildingModelBuilding.setAmount(Double.valueOf(edtAmountInRsBuilding.getText().toString()));
                landBuildingModelBuilding.setOwnership(strOwnershipBuilding);
                landBuildingModelBuilding.setPreOperativeMonths(intMonthsBuilding);
                landBuildingModelArrayList.add(landBuildingModelBuilding);


                //INSERT DATA IN TO MODEL CLASS
                SubmitLandBuildingData submitLandBuildingData = new SubmitLandBuildingData();
                submitLandBuildingData.setBusinessPlanId(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)));//2
                submitLandBuildingData.setLandBuildingExpensesList(landBuildingModelArrayList);//1
                submitLandBuildingData.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));//3


                //SAVE STEP 3.1 DATA IN TO DATABASE LATER WE WILL USE IT FOR DISPLAY
                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {
                    mDatabaseHelper.insertEntrepreneurBP_3_1_step(
                            new Gson().toJson(landBuildingModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                } else {
                    mDatabaseHelper.updateEntrepreneurBP_3_1_step(
                            new Gson().toJson(landBuildingModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                }


                //MAKE VIEW HIDE SHOW
                if (llLandAndBuilding.getVisibility() == View.VISIBLE) {
                    llLandAndBuilding.setVisibility(View.GONE);
                } else {
                    llLandAndBuilding.setVisibility(View.VISIBLE);
                }
                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));


            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }


            Double TotalCostLandBuilding = 0.0;
            if (!strOwnershipLand.equals(getActivity().getResources().getString(R.string.strOwnBP))) {
                TotalCostLandBuilding = Double.valueOf(edtAmountInRsLand.getText().toString());
            }

            if (!strOwnershipBuilding.equals(getActivity().getResources().getString(R.string.strOwnBP))) {
                TotalCostLandBuilding = (TotalCostLandBuilding + Double.valueOf(edtAmountInRsBuilding.getText().toString()));
            }
            edtCostLandBuilding.setText("" + TotalCostLandBuilding.intValue());
        }

    }

    private boolean checkValidation() {
        if (strOwnershipLand.isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterLandOwnership));
            return false;
        } else if (!strOwnershipLand.isEmpty() && strOwnershipLand.equals(getActivity().getResources().getString(R.string.strLeaseBP)) && edtNoOfMonPreOperativeLand.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPreOperativeMonths));
            edtNoOfMonPreOperativeLand.requestFocus();
            return false;
        } else if (edtAreaInFtLand.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterLandArea));
            edtAreaInFtLand.requestFocus();
            return false;
        } else if (edtPriceLand.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterLandRate));
            edtPriceLand.requestFocus();
            return false;
        } else if (strOwnershipBuilding.isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterBuildingOwnership));
            return false;
        } else if (!strOwnershipBuilding.isEmpty() && strOwnershipBuilding.equals(getActivity().getResources().getString(R.string.strLeaseBP)) && edtNoOfMonPreOperativeBuilding.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPreOperativeMonthsBuilding));
            edtNoOfMonPreOperativeBuilding.requestFocus();
            return false;
        } else if (edtAreaInFtBuilding.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterBuildingArea));
            edtAreaInFtBuilding.requestFocus();
            return false;
        } else if (edtPriceBuilding.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterBuildingRate));
            edtPriceBuilding.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void setAllClicks() {

        //-----------(CALCULATION FOR LAND AND BUILDING)----------//

        //LAND CALCULATION//
        //STEP 3.1 CLICK ON RADIO GROUP FOR LAND EXPENSE
        rgOwnershipLand.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                        // CommonMethods.displayToast(getActivity() , btn.getText().toString());
                        strOwnershipLand = btn.getText().toString();

                        if (strOwnershipLand.equals(getActivity().getResources().getString(R.string.strOwnBP))) {
                            llNoOfMonthsPre.setVisibility(View.GONE);

                            //DISPLAY TITLE AS PER SELECTED LAND AND BUILDING TYPE
                            txtLandSquarFoot.setText(getResources().getString(R.string.strRateFeetOnly));
                            txtTitleLandAmount.setText(getResources().getString(R.string.strAmount));
                        } else {
                            llNoOfMonthsPre.setVisibility(View.VISIBLE);

                            //DISPLAY TITLE AS PER SELECTED LAND AND BUILDING TYPE
                            txtLandSquarFoot.setText(getResources().getString(R.string.strRateFeetPerMonth));
                            txtTitleLandAmount.setText(getResources().getString(R.string.strRatePerYear));


                        }

                        edtAreaInFtLand.setText("");
                        edtPriceLand.setText("");
                        edtAmountInRsLand.setText("");
                        edtNoOfMonPreOperativeLand.setText("");

                    }
                }
            }
        });

        //STEP 3.1 ADD TEXT CHANGED LISTNER OF NUMBER OF MONTH PRE- OPERATIVE LANDS
        edtNoOfMonPreOperativeLand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (strOwnershipLand.equals(getActivity().getResources().getString(R.string.strOwnBP))) {

                } else {

                    edtAreaInFtLand.setText("");
                    edtPriceLand.setText("");
                    edtAmountInRsLand.setText("");

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //STEP 3.1 ADD TEXT CHANGE LISTNER ON AREA OF LAND SQUER FEET
        edtAreaInFtLand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtPriceLand.setText("");
                edtAmountInRsLand.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //STEP 3.1 ADD TEXT CHANGE LISTNER ON PRICE OF AREA SQUER FEET IN LAND
        edtPriceLand.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    if (strOwnershipLand.equals(getResources().getString(R.string.strLeaseBP))) {
                        Double amount = Double.valueOf(edtNoOfMonPreOperativeLand.getText().toString()) * Double.valueOf(edtAreaInFtLand.getText().toString()) * Double.valueOf(edtPriceLand.getText().toString());
                        edtAmountInRsLand.setText(String.valueOf(amount.intValue()));
                    } else {
                        Double amount = Double.valueOf(edtAreaInFtLand.getText().toString()) * Double.valueOf(edtPriceLand.getText().toString());
                        edtAmountInRsLand.setText(String.valueOf(amount.intValue()));
                    }
                } catch (NumberFormatException e) {
                    edtAmountInRsLand.setText("");
                }

            }
        });

        //BUILDING CALCULATION//
        //STEP 3.1 CLICKS ON RADIO GROUP FOR BUILDING EXPENSE
        rgOwnershipBuilding.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                        // CommonMethods.displayToast(RegisterEnterpreniourActivity.this , btn.getText().toString());
                        strOwnershipBuilding = btn.getText().toString();

                        if (strOwnershipBuilding.equals(getActivity().getResources().getString(R.string.strOwnBP))) {
                            llNoOfMonthsPreBuilding.setVisibility(View.GONE);

                            //DISPLAY TITLE AS PER SELECTED LAND AND BUILDING TYPE
                            txtBuildingSquarFoot.setText(getResources().getString(R.string.strRateFeetOnly));
                            txtTitleBuildingAmount.setText(getResources().getString(R.string.strAmount));
                        } else {
                            llNoOfMonthsPreBuilding.setVisibility(View.VISIBLE);

                            //DISPLAY TITLE AS PER SELECTED LAND AND BUILDING TYPE
                            txtBuildingSquarFoot.setText(getResources().getString(R.string.strRateFeetPerMonth));
                            txtTitleBuildingAmount.setText(getResources().getString(R.string.strRatePerYear));
                        }

                        edtAreaInFtBuilding.setText("");
                        edtPriceBuilding.setText("");
                        edtAmountInRsBuilding.setText("");
                        edtNoOfMonPreOperativeBuilding.setText("");

                    }
                }
            }
        });

        //STEP 3.1 ADD TEXT CHANGED LISTNER OF NUMBER OF MONTH PRE-OPERATIVE BUILDINGS
        edtNoOfMonPreOperativeBuilding.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (strOwnershipBuilding.equals(getActivity().getResources().getString(R.string.strOwnBP))) {

                } else {
                    edtAreaInFtBuilding.setText("");
                    edtPriceBuilding.setText("");
                    edtAmountInRsBuilding.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //STEP 3.1 ADD TEXT CHANGE LISTNER ON AREA OF BULDINGS SQUER FEET
        edtAreaInFtBuilding.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtPriceBuilding.setText("");
                edtAmountInRsBuilding.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //STEP 3.1 ADD TEXT CHANGE LISTNER ON PRICE OF AREA SQUARE FEET IN BUILDINGS
        edtPriceBuilding.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    if (strOwnershipBuilding.equals(getResources().getString(R.string.strLeaseBP))) {
                        Double amount1 = Double.valueOf(edtNoOfMonPreOperativeBuilding.getText().toString()) * Double.valueOf(edtAreaInFtBuilding.getText().toString()) * Double.valueOf(edtPriceBuilding.getText().toString());
                        edtAmountInRsBuilding.setText(String.valueOf(amount1.intValue()));
                    } else {
                        Double amount1 = Double.valueOf(edtAreaInFtBuilding.getText().toString()) * Double.valueOf(edtPriceBuilding.getText().toString());
                        edtAmountInRsBuilding.setText(String.valueOf(amount1.intValue()));
                    }
                } catch (NumberFormatException e) {
                    edtAmountInRsBuilding.setText("");
                }
            }
        });


        //ON CLICKS FOR STEP 3.6 MAN POWER
        edtSkilledNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence mCharSequence, int start, int before, int count) {

                if (mCharSequence.equals(0)) {
                    edtSkilledWagesSalaries.setText("0");
                    edtSkilledAnnualExpenses.setText("0");
                } else {
                    edtSkilledWagesSalaries.setText("");
                    edtSkilledAnnualExpenses.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {


                edtSkilledWagesSalaries.setText("");
                edtSkilledAnnualExpenses.setText("");
            }
        });

        edtSkilledWagesSalaries.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    int amount = 12 * Integer.valueOf(edtSkilledWagesSalaries.getText().toString()) * Integer.valueOf(edtSkilledNo.getText().toString());
                    edtSkilledAnnualExpenses.setText(String.valueOf(amount));
                } catch (NumberFormatException e) {
                    edtSkilledAnnualExpenses.setText("");
                }

            }
        });

        edtSemiSkilledNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence mCharSequence, int start, int before, int count) {

                if (mCharSequence.equals(0)) {
                    edtSemiSkilledWagesSalaries.setText("0");
                    edtSemiSkilledAnnualExpenses.setText("0");
                } else {
                    edtSemiSkilledWagesSalaries.setText("");
                    edtSemiSkilledAnnualExpenses.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                edtSemiSkilledWagesSalaries.setText("");
                edtSemiSkilledAnnualExpenses.setText("");
            }
        });

        edtSemiSkilledWagesSalaries.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    int amount = 12 * Integer.valueOf(edtSemiSkilledWagesSalaries.getText().toString()) * Integer.valueOf(edtSemiSkilledNo.getText().toString());
                    edtSemiSkilledAnnualExpenses.setText(String.valueOf(amount));
                } catch (NumberFormatException e) {
                    edtSemiSkilledAnnualExpenses.setText("");
                }

            }
        });

        edtUnskilledNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence mCharSequence, int start, int before, int count) {

                if (mCharSequence.equals(0)) {
                    edtUnskilledWagesSalaries.setText("0");
                    edtUnskilledAnnualExpenses.setText("0");
                } else {
                    edtUnskilledWagesSalaries.setText("");
                    edtUnskilledAnnualExpenses.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                edtUnskilledWagesSalaries.setText("");
                edtUnskilledAnnualExpenses.setText("");
            }
        });

        edtUnskilledWagesSalaries.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    int amount = 12 * Integer.valueOf(edtUnskilledWagesSalaries.getText().toString()) * Integer.valueOf(edtUnskilledNo.getText().toString());
                    edtUnskilledAnnualExpenses.setText(String.valueOf(amount));
                } catch (NumberFormatException e) {
                    edtUnskilledAnnualExpenses.setText("");
                }

            }
        });

        edtOfficeStaffNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence mCharSequence, int start, int before, int count) {

                if (mCharSequence.equals("0")) {
                    edtOfficeStaffWagesSalaries.setText(0);
                    edtOfficeStaffAnnualExpenses.setText("0");
                } else {
                    edtOfficeStaffWagesSalaries.setText("");
                    edtOfficeStaffAnnualExpenses.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                edtOfficeStaffWagesSalaries.setText("");
                edtOfficeStaffAnnualExpenses.setText("");
            }
        });

        edtOfficeStaffWagesSalaries.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    int amount = 12 * Integer.valueOf(edtOfficeStaffWagesSalaries.getText().toString()) * Integer.valueOf(edtOfficeStaffNo.getText().toString());
                    edtOfficeStaffAnnualExpenses.setText(String.valueOf(amount));
                } catch (NumberFormatException e) {
                    edtOfficeStaffAnnualExpenses.setText("");
                }

            }
        });

        edtAnyOtherNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edtAnyOtherWagesSalaries.setText("");
                edtAnyOtherAnnualExpenses.setText("");
            }
        });

        edtAnyOtherWagesSalaries.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    //int amount = 12 * Integer.valueOf(edtAnyOtherWagesSalaries.getText().toString()) * Integer.valueOf(edtAnyOtherNo.getText().toString());
                    int amount = Integer.valueOf(edtAnyOtherWagesSalaries.getText().toString()) * Integer.valueOf(1);
                    edtAnyOtherAnnualExpenses.setText(String.valueOf(amount));
                } catch (NumberFormatException e) {
                    edtAnyOtherAnnualExpenses.setText("");
                }

            }
        });

        //STEP 3.9 WORKING CAPITAL CLICKS
        edtRawMaterialWCDuration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtRawMaterialWCQuantity.setText("");
                edtRawMaterialRate.setText("");
                edtRawMaterialWCAmount.setText("");
                edtWCTotalWorkingCapitalNeeded.setText("");
                mSessionManager.updatePreferenceString(Constants.TOTAL_WORKING_CAPITAL, "" + edtWCTotalWorkingCapitalNeeded.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtSemiFinishedWCDuration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtSemiFinishedWCQuantity.setText("");
                edtSemiFinishedRate.setText("");
                edtSemiFinishedWCAmount.setText("");
                edtWCTotalWorkingCapitalNeeded.setText("");
                mSessionManager.updatePreferenceString(Constants.TOTAL_WORKING_CAPITAL, "" + edtWCTotalWorkingCapitalNeeded.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtFinishedStockWCDuration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtFinishedStockWCQuantity.setText("");
                edtFinishesRate.setText("");
                edtFinishedStockWCAmount.setText("");
                edtWCTotalWorkingCapitalNeeded.setText("");
                mSessionManager.updatePreferenceString(Constants.TOTAL_WORKING_CAPITAL, "" + edtWCTotalWorkingCapitalNeeded.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtSalesOnCreditWCDuration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtSalesOnCreditWCQuantity.setText("");
                edtSalesOnCreditlRate.setText("");
                edtSalesOnCreditWCAmount.setText("");
                edtWCTotalWorkingCapitalNeeded.setText("");
                mSessionManager.updatePreferenceString(Constants.TOTAL_WORKING_CAPITAL, "" + edtWCTotalWorkingCapitalNeeded.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        edtRawMaterialWCQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtRawMaterialRate.setText("");
                edtRawMaterialWCAmount.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtRawMaterialRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    int amount = Integer.valueOf(edtRawMaterialWCQuantity.getText().toString()) * Integer.valueOf(edtRawMaterialRate.getText().toString());
                    edtRawMaterialWCAmount.setText(String.valueOf(amount));

                    //dblTotalWorkingCapitalCose = dblTotalWorkingCapitalCose + amount;

                    //edtWCTotalWorkingCapitalNeeded.setText("" + dblTotalWorkingCapitalCose);

                    //-----Cleared because to calculate Total Working Capital on this field-------/////////////
                    // edtSalesOnCreditlRate.setText("");
                    //  edtWCTotalWorkingCapitalNeeded.setText("");

                } catch (NumberFormatException e) {
                    edtRawMaterialWCAmount.setText("");
                }

            }
        });

        edtSemiFinishedWCQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtSemiFinishedRate.setText("");
                edtSemiFinishedWCAmount.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtSemiFinishedRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int amount = Integer.valueOf(edtSemiFinishedWCQuantity.getText().toString()) * Integer.valueOf(edtSemiFinishedRate.getText().toString());
                    edtSemiFinishedWCAmount.setText(String.valueOf(amount));

                    // dblTotalWorkingCapitalCose = dblTotalWorkingCapitalCose + amount;
                    // edtWCTotalWorkingCapitalNeeded.setText("" + dblTotalWorkingCapitalCose);

                    // edtSalesOnCreditlRate.setText("");
                    // edtWCTotalWorkingCapitalNeeded.setText("");

                } catch (NumberFormatException e) {
                    edtSemiFinishedWCAmount.setText("");
                }
            }
        });

        edtFinishedStockWCQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtFinishesRate.setText("");
                edtFinishedStockWCAmount.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtFinishesRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int amount = Integer.valueOf(edtFinishedStockWCQuantity.getText().toString()) * Integer.valueOf(edtFinishesRate.getText().toString());
                    edtFinishedStockWCAmount.setText(String.valueOf(amount));

                    //dblTotalWorkingCapitalCose = dblTotalWorkingCapitalCose + amount;
                    // edtWCTotalWorkingCapitalNeeded.setText("" + dblTotalWorkingCapitalCose);

                    // edtSalesOnCreditlRate.setText("");
                    //edtWCTotalWorkingCapitalNeeded.setText("");

                } catch (NumberFormatException e) {
                    edtFinishedStockWCAmount.setText("");
                }
            }
        });

        edtSalesOnCreditWCQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtSalesOnCreditlRate.setText("");
                edtSalesOnCreditWCAmount.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtSalesOnCreditlRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int amount = Integer.valueOf(edtSalesOnCreditWCQuantity.getText().toString()) * Integer.valueOf(edtSalesOnCreditlRate.getText().toString());
                    edtSalesOnCreditWCAmount.setText(String.valueOf(amount));

                  /*  //dblTotalWorkingCapitalCose = dblTotalWorkingCapitalCose + amount;

                    int dblAllCount = Integer.valueOf(edtRawMaterialWCAmount.getText().toString())
                            + Integer.valueOf(edtSemiFinishedWCAmount.getText().toString())
                            + Integer.valueOf(edtFinishedStockWCAmount.getText().toString())
                            + Integer.valueOf(edtSalesOnCreditWCAmount.getText().toString());

                    edtWCTotalWorkingCapitalNeeded.setText("" + dblAllCount);*/

                } catch (NumberFormatException e) {
                    edtSalesOnCreditWCAmount.setText("");
                }
            }
        });

        edtRawMaterialWCAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int intRawMaterielAmt = 0, intSemiRawMaterielAmt = 0, intFinishedRawMaterielAmt = 0, intSalesOnCreditMaterielAmt = 0;
                    if (!s.toString().isEmpty()) {
                        intRawMaterielAmt = Integer.valueOf(edtRawMaterialWCAmount.getText().toString());
                    }
                    if (!edtSemiFinishedWCAmount.getText().toString().isEmpty()) {
                        intSemiRawMaterielAmt = Integer.valueOf(edtSemiFinishedWCAmount.getText().toString());
                    }
                    if (!edtFinishedStockWCAmount.getText().toString().isEmpty()) {
                        intFinishedRawMaterielAmt = Integer.valueOf(edtFinishedStockWCAmount.getText().toString());
                    }
                    if (!edtSalesOnCreditWCAmount.getText().toString().isEmpty()) {
                        intSalesOnCreditMaterielAmt = Integer.valueOf(edtSalesOnCreditWCAmount.getText().toString());
                    }

                    int dblAllCount = (intRawMaterielAmt + intSemiRawMaterielAmt + intFinishedRawMaterielAmt + intSalesOnCreditMaterielAmt);

                    // edtWCTotalWorkingCapitalNeeded.setText("" + dblAllCount);

                    //Calculation working capital as per new formula which is already applied on prepopulated data
                    calculateWorkingCapital();

                } catch (NumberFormatException e) {
                    //AlertUtils.loge("Error Ketan: "+e);

                }
            }
        });

        edtSemiFinishedWCAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    int intRawMaterielAmt = 0, intSemiRawMaterielAmt = 0, intFinishedRawMaterielAmt = 0, intSalesOnCreditMaterielAmt = 0;
                    if (!edtRawMaterialWCAmount.getText().toString().isEmpty()) {
                        intRawMaterielAmt = Integer.valueOf(edtRawMaterialWCAmount.getText().toString());
                    }
                    if (!s.toString().isEmpty()) {
                        intSemiRawMaterielAmt = Integer.valueOf(edtSemiFinishedWCAmount.getText().toString());
                    }
                    if (!edtFinishedStockWCAmount.getText().toString().isEmpty()) {
                        intFinishedRawMaterielAmt = Integer.valueOf(edtFinishedStockWCAmount.getText().toString());
                    }
                    if (!edtSalesOnCreditWCAmount.getText().toString().isEmpty()) {
                        intSalesOnCreditMaterielAmt = Integer.valueOf(edtSalesOnCreditWCAmount.getText().toString());
                    }

                    int dblAllCount = (intRawMaterielAmt + intSemiRawMaterielAmt + intFinishedRawMaterielAmt + intSalesOnCreditMaterielAmt);

                    //  edtWCTotalWorkingCapitalNeeded.setText("" + dblAllCount);


                    //Calculation working capital as per new formula which is already applied on prepopulated data
                    calculateWorkingCapital();

                } catch (NumberFormatException e) {
                    // AlertUtils.loge("Error Ketan: "+e);

                }
            }
        });

        edtFinishedStockWCAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    int intRawMaterielAmt = 0, intSemiRawMaterielAmt = 0, intFinishedRawMaterielAmt = 0, intSalesOnCreditMaterielAmt = 0;
                    if (!edtRawMaterialWCAmount.getText().toString().isEmpty()) {
                        intRawMaterielAmt = Integer.valueOf(edtRawMaterialWCAmount.getText().toString());
                    }
                    if (!edtSemiFinishedWCAmount.getText().toString().isEmpty()) {
                        intSemiRawMaterielAmt = Integer.valueOf(edtSemiFinishedWCAmount.getText().toString());
                    }
                    if (!s.toString().isEmpty()) {
                        intFinishedRawMaterielAmt = Integer.valueOf(edtFinishedStockWCAmount.getText().toString());
                    }
                    if (!edtSalesOnCreditWCAmount.getText().toString().isEmpty()) {
                        intSalesOnCreditMaterielAmt = Integer.valueOf(edtSalesOnCreditWCAmount.getText().toString());
                    }

                    int dblAllCount = (intRawMaterielAmt + intSemiRawMaterielAmt + intFinishedRawMaterielAmt + intSalesOnCreditMaterielAmt);

                    //edtWCTotalWorkingCapitalNeeded.setText("" + dblAllCount);


                    //Calculation working capital as per new formula which is already applied on prepopulated data
                    calculateWorkingCapital();

                } catch (NumberFormatException e) {
                    // AlertUtils.loge("Error Ketan: "+e);

                }
            }
        });
        edtSalesOnCreditWCAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {


                    int intRawMaterielAmt = 0, intSemiRawMaterielAmt = 0, intFinishedRawMaterielAmt = 0, intSalesOnCreditMaterielAmt = 0;
                    if (!edtRawMaterialWCAmount.getText().toString().isEmpty()) {
                        intRawMaterielAmt = Integer.valueOf(edtRawMaterialWCAmount.getText().toString());
                    }
                    if (!edtSemiFinishedWCAmount.getText().toString().isEmpty()) {
                        intSemiRawMaterielAmt = Integer.valueOf(edtSemiFinishedWCAmount.getText().toString());
                    }
                    if (!edtFinishedStockWCAmount.getText().toString().isEmpty()) {
                        intFinishedRawMaterielAmt = Integer.valueOf(edtFinishedStockWCAmount.getText().toString());
                    }
                    if (!s.toString().isEmpty()) {
                        intSalesOnCreditMaterielAmt = Integer.valueOf(edtSalesOnCreditWCAmount.getText().toString());
                    }

                    int dblAllCount = (intRawMaterielAmt + intSemiRawMaterielAmt + intFinishedRawMaterielAmt + intSalesOnCreditMaterielAmt);

                    // edtWCTotalWorkingCapitalNeeded.setText("" + dblAllCount);


                    //Calculation working capital as per new formula which is already applied on prepopulated data
                    calculateWorkingCapital();


                } catch (NumberFormatException e) {
                    //AlertUtils.loge("Error Ketan: "+e);

                }
            }
        });


    }


    private void displayMachinerAndEquipmentData(boolean isFromDelete, boolean isFromAddButton) {
        //Remove All Views from dynamic added layout
        llDynamicMachinery.removeAllViews();
        int arraySize = 0;
        //Get Saved Business Plan Data From Database
        step3_2_GetMachineryAndEquipmentList = mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)));

        //Inflate view as per arraylist size for different scenarios
        if (step3_2_GetMachineryAndEquipmentList.size() != 0 && !isFromAddButton) {
            arraySize = step3_2_GetMachineryAndEquipmentList.size();
        } else if (step3_2_GetMachineryAndEquipmentList.size() != 0 && isFromAddButton) {
            arraySize = (step3_2_GetMachineryAndEquipmentList.size() + 1);
        } else {
            arraySize = 1;
        }


        for (int i = 0; i < arraySize; i++) {

            //------(Add dynamic views as per array list size)-------//
            addMoreMachineryView = mActivity.getLayoutInflater().inflate(R.layout.box_machinary_new, llDynamicMachinery, false);

            //------(Find views)-------//
            txtSrNoManchinery = (TextView) addMoreMachineryView.findViewById(R.id.txtSrNoManchinery);
            txtUploadQuotationManchinery = (TextView) addMoreMachineryView.findViewById(R.id.txtUploadQuotationManchinery);

            txtTitlePerticulare = (TextView) addMoreMachineryView.findViewById(R.id.txtTitlePerticulare);
            txtTitleMachineNumber = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleMachineNumber);
            txtTitlePerUnitPrice = (TextView) addMoreMachineryView.findViewById(R.id.txtTitlePerUnitPrice);
            txtTitleTotalAmount = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleTotalAmount);
            txtTitlePurchaseDate = (TextView) addMoreMachineryView.findViewById(R.id.txtTitlePurchaseDate);
            txtTitleExpectedLife = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleExpectedLife);
            txtTitleScrapValue = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleScrapValue);
            txtTitleDepriciatedCal = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleDepriciatedCal);
            txtTitleBookValue = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleBookValue);
            txtTitleSuppllierName = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleSuppllierName);
            txtTitleTransInRs = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleTransInRs);
            txtTitleElectrification = (TextView) addMoreMachineryView.findViewById(R.id.txtTitleElectrification);

            edtParticularsManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtParticularsManchinery);
            edtMachinNosManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtMachinNosManchinery);
            edtPriceManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtPriceManchinery);
            edtAmountinRsManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtAmountinRsManchinery);
            edtPurchaseDateManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtPurchaseDateManchinery);
            edtExpectedLifeManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtExpectedLifeManchinery);
            edtScrapValueManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtScrapValueManchinery);
            edtDepreciationManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtDepreciationManchinery);
            edtBookValueManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtBookValueManchinery);
            edtSuppliersNameManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtSuppliersNameManchinery);
            edtTaxTransInRsManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtTaxTransInRsManchinery);
            edtElectrificationInRsManchinery = (EditText) addMoreMachineryView.findViewById(R.id.edtElectrificationInRsManchinery);

            imgEditView = (ImageView) addMoreMachineryView.findViewById(R.id.imgEditView);

            linearQuotation = (LinearLayout) addMoreMachineryView.findViewById(R.id.linearQuotation);

            //set seriel no. to the dynamic added view
            txtSrNoManchinery.setText("" + (i + 1));


            //SET MENDETOARY FIELDS
            txtTitlePerticulare.setText(CommonMethods.spannableString(getResources().getString(R.string.strParticulars)));
            txtTitleMachineNumber.setText(CommonMethods.spannableString(getResources().getString(R.string.strMachinNos)));
            txtTitlePerUnitPrice.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerUnitPrice)));
            txtTitleTotalAmount.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalAmount)));
            txtTitlePurchaseDate.setText(CommonMethods.spannableString(getResources().getString(R.string.strPurchaseDate)));
            txtTitleExpectedLife.setText(CommonMethods.spannableString(getResources().getString(R.string.strExpectedLife)));
            txtTitleScrapValue.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerAnnum)));
            txtTitleDepriciatedCal.setText(CommonMethods.spannableString(getResources().getString(R.string.strDepriciatedCal)));
            txtTitleBookValue.setText(CommonMethods.spannableString(getResources().getString(R.string.strBookValue)));
            txtTitleSuppllierName.setText(CommonMethods.spannableString(getResources().getString(R.string.strSuppliersName)));
            txtTitleTransInRs.setText(CommonMethods.spannableString(getResources().getString(R.string.strTaxTransInRs)));
            txtTitleElectrification.setText(CommonMethods.spannableString(getResources().getString(R.string.strElectrificationInRs)));


            //----(Set already existing data)-----//
            if (step3_2_GetMachineryAndEquipmentList.size() != 0) {

                if (step3_2_GetMachineryAndEquipmentList.size() > i) {

                    Double dblPriceManchinery = step3_2_GetMachineryAndEquipmentList.get(i).getPrice();
                    Double dblAmountinRsManchinery = step3_2_GetMachineryAndEquipmentList.get(i).getAmount();
                    Double dblDepreciationManchinery = step3_2_GetMachineryAndEquipmentList.get(i).getDepriciation();
                    Double dblBookValueManchinery = step3_2_GetMachineryAndEquipmentList.get(i).getBookValue();
                    Double dblTaxTransInRsManchinery = step3_2_GetMachineryAndEquipmentList.get(i).getTaxTransporatation();
                    Double dblElectrificationInRsManchinery = step3_2_GetMachineryAndEquipmentList.get(i).getElectrification();

                    edtParticularsManchinery.setText("" + step3_2_GetMachineryAndEquipmentList.get(i).getPerticuler());
                    edtMachinNosManchinery.setText("" + step3_2_GetMachineryAndEquipmentList.get(i).getMachineryNo());
                    edtPriceManchinery.setText("" + dblPriceManchinery.intValue());
                    edtAmountinRsManchinery.setText("" + dblAmountinRsManchinery.intValue());
                    edtPurchaseDateManchinery.setText("" + CommonMethods.getDateFromLong(step3_2_GetMachineryAndEquipmentList.get(i).getPurchaseDate()));
                    edtExpectedLifeManchinery.setText("" + step3_2_GetMachineryAndEquipmentList.get(i).getExpectedLife());
                    edtScrapValueManchinery.setText("" + step3_2_GetMachineryAndEquipmentList.get(i).getScrapValue());
                    edtDepreciationManchinery.setText("" + dblDepreciationManchinery.intValue());
                    edtBookValueManchinery.setText("" + dblBookValueManchinery.intValue());
                    edtSuppliersNameManchinery.setText("" + step3_2_GetMachineryAndEquipmentList.get(i).getSuppliersNameAndAddress());
                    edtTaxTransInRsManchinery.setText("" + dblTaxTransInRsManchinery.intValue());
                    edtElectrificationInRsManchinery.setText("" + dblElectrificationInRsManchinery.intValue());
                    txtUploadQuotationManchinery.setText("" + step3_2_GetMachineryAndEquipmentList.get(i).getUploadQuotation());

                    if (step3_2_GetMachineryAndEquipmentList.get(i).getIsDataEditable() != 1) {

                        edtParticularsManchinery.setFocusableInTouchMode(false);
                        edtMachinNosManchinery.setFocusableInTouchMode(false);
                        edtPriceManchinery.setFocusableInTouchMode(false);
                        edtAmountinRsManchinery.setFocusableInTouchMode(false);
                        edtPurchaseDateManchinery.setFocusableInTouchMode(false);
                        edtPurchaseDateManchinery.setClickable(false);
                        edtPurchaseDateManchinery.setFocusable(false);
                        edtExpectedLifeManchinery.setFocusableInTouchMode(false);
                        edtScrapValueManchinery.setFocusableInTouchMode(false);
                        edtDepreciationManchinery.setFocusableInTouchMode(false);
                        edtBookValueManchinery.setFocusableInTouchMode(false);
                        edtSuppliersNameManchinery.setFocusableInTouchMode(false);
                        edtTaxTransInRsManchinery.setFocusableInTouchMode(false);
                        edtElectrificationInRsManchinery.setFocusableInTouchMode(false);
                        txtUploadQuotationManchinery.setFocusableInTouchMode(false);
                        linearQuotation.setVisibility(View.GONE);


                    }
                } else {
                    //Hide edit view image if data is newley added or click on add more button
                    imgEditView.setVisibility(View.GONE);
                }


            } else {
                //Hide edit view image if data is newley added or click on add more button
                imgEditView.setVisibility(View.GONE);
            }

            if (isBusinessPlanSubmitted) {
                imgEditView.setVisibility(View.GONE);
            }


            //Adding view to dynamic layout
            llDynamicMachinery.addView(addMoreMachineryView);
            final int position = llDynamicMachinery.indexOfChild(addMoreMachineryView);
            imgEditView.setTag(position);

            //----(use position for delete view)-----//
            imgEditView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    positionFurnitureView = (Integer) v.getTag();

                    //open edit view dialog
                    openEditPLantAndMachineryDialog(positionFurnitureView);


                }
            });


            //Calculation on manchinery no.
            edtMachinNosManchinery.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    edtPriceManchinery.setText("");
                    edtAmountinRsManchinery.setText("");
                    edtPurchaseDateManchinery.setText("");
                    edtExpectedLifeManchinery.setText("");
                    edtScrapValueManchinery.setText("");
                    edtDepreciationManchinery.setText("");
                    edtBookValueManchinery.setText("");
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            //Calculation on Unit Price edit text
            edtPriceManchinery.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {
                    edtAmountinRsManchinery.setText("");
                    edtPurchaseDateManchinery.setText("");
                    edtExpectedLifeManchinery.setText("");
                    edtScrapValueManchinery.setText("");
                    edtDepreciationManchinery.setText("");
                    edtBookValueManchinery.setText("");


                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {


                    try {
                        Double amount = Double.valueOf(edtMachinNosManchinery.getText().toString()) * Double.valueOf(edtPriceManchinery.getText().toString());
                        edtAmountinRsManchinery.setText(String.valueOf(amount.intValue()));
                    } catch (NumberFormatException e) {
                        edtAmountinRsManchinery.setText("");
                    }
                }
            });

            //Click on purchase date
            edtPurchaseDateManchinery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    edtExpectedLifeManchinery.setText("");
                    edtScrapValueManchinery.setText("");
                    openDatePickerDialogForPlantAndMachinery();

                }
            });

            //Calculation on expected life
            edtExpectedLifeManchinery.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (s.toString().isEmpty()) {
                        edtScrapValueManchinery.setText("");
                        edtDepreciationManchinery.setText("");
                        edtBookValueManchinery.setText("");
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    if (edtExpectedLifeManchinery.getText().toString().equals("0")) {
                        edtExpectedLifeManchinery.setText("");
                        edtScrapValueManchinery.setText("");
                        edtDepreciationManchinery.setText("");
                        edtBookValueManchinery.setText("");
                        CommonMethods.displayToast(mActivity, getActivity().getResources().getString(R.string.strExpectedNotZero));
                    }

                }
            });

            //Calculation on scrap value edit text change listner
            edtScrapValueManchinery.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    try {

                        if (edtPurchaseDateManchinery.getText().toString().length() != 0) {

                            if (s.length() != 0) {
                                Calendar c = Calendar.getInstance();

                                SimpleDateFormat df = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                                String strCurrentDate = df.format(c.getTime());

                                try {
                                    SimpleDateFormat sdf = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                                    dateCurrentPlantMachiney = sdf.parse(strCurrentDate);
                                    dateEnteredPlantMachinery = sdf.parse(edtPurchaseDateManchinery.getText().toString());
                                } catch (ParseException ex) {
                                }

                                Calendar startCalendar = new GregorianCalendar();
                                startCalendar.setTime(dateEnteredPlantMachinery);
                                Calendar endCalendar = new GregorianCalendar();
                                endCalendar.setTime(dateCurrentPlantMachiney);

                                int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                                dateDifferencePlantMachinery = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                                int A = Integer.parseInt(edtAmountinRsManchinery.getText().toString());
                                int B = Integer.parseInt(edtScrapValueManchinery.getText().toString());
                                int C = Integer.parseInt(edtExpectedLifeManchinery.getText().toString());

                                int D = (A - B) / C;
                                edtDepreciationManchinery.setText("" + D);

                                int months = dateDifferencePlantMachinery / 12;

                                int F = A - (D * months);

                                edtBookValueManchinery.setText("" + F);

                            } else {
                                edtDepreciationManchinery.setText("");
                                edtBookValueManchinery.setText("");
                            }
                        }

                    } catch (NumberFormatException e) {
                        edtDepreciationManchinery.setText("");
                        edtBookValueManchinery.setText("");
                    }

                }
            });


            //Click on purchase date
            txtUploadQuotationManchinery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Divya 7 march 2018
                    isPlantAndMachinaryQuotation = true;
                    //checkPermission();


                }
            });


        }
    }

    private void openDatePickerDialogForPlantAndMachinery() {
        Date fromDate = null;
        DateFormat format = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);

        Calendar calenderToDate = Calendar.getInstance();
        Calendar calenderFromDate = Calendar.getInstance();

        mDatePickerDialog = DatePickerDialog.newInstance(this,
                calenderToDate.get(Calendar.YEAR),
                calenderToDate.get(Calendar.MONTH),
                calenderToDate.get(Calendar.DAY_OF_MONTH)
        );
        //mDatePickerDialog.setMaxDate(calenderToDate);
        mDatePickerDialog.setCancelColor(Color.BLACK);
        mDatePickerDialog.setOkColor(Color.BLACK);
        mDatePickerDialog.show(getActivity().getFragmentManager(), "Datepickerdialog");

    }

    private void savePlantAndMachineryDataInToDatabase(boolean isFromAddMoreButton) {

        if (step3_2_GetMachineryAndEquipmentList.size() != 0) {

            //check if data already saved in database
            if (edtParticularsManchinery.getText().toString().equals(step3_2_GetMachineryAndEquipmentList.get(step3_2_GetMachineryAndEquipmentList.size() - 1).getPerticuler())) {
                displayMachinerAndEquipmentData(false, isFromAddMoreButton);
            } else {

                if (checkValidationPlantAndMachinery()) {
                    insertPlantAndMachinaryDataIntoDatabase(isFromAddMoreButton);
                }
            }
        } else {
            //remove all view befor add another view
            if (checkValidationPlantAndMachinery()) {
                insertPlantAndMachinaryDataIntoDatabase(isFromAddMoreButton);
            }
        }

    }

    private boolean checkValidationPlantAndMachinery() {
        if (edtParticularsManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterParticular));
            edtParticularsManchinery.requestFocus();
            return false;
        } else if (edtMachinNosManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterTheMachineNo));
            edtMachinNosManchinery.requestFocus();
            return false;
        } else if (edtPriceManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePrice));
            edtPriceManchinery.requestFocus();
            return false;
        } else if (edtPurchaseDateManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePurchaseDate));
            edtPurchaseDateManchinery.requestFocus();
            return false;
        } else if (edtExpectedLifeManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheExpectedLife));
            edtExpectedLifeManchinery.requestFocus();
            return false;
        } else if (edtScrapValueManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheScrapValue));
            edtScrapValueManchinery.requestFocus();
            return false;
        } else if (edtSuppliersNameManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterNameAndAddress));
            edtSuppliersNameManchinery.requestFocus();
            return false;
        } else if (edtTaxTransInRsManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorNewBusinessPlanTaxAndTransportation));
            edtTaxTransInRsManchinery.requestFocus();
            return false;
        } else if (edtElectrificationInRsManchinery.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterElectification));
            edtElectrificationInRsManchinery.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void insertPlantAndMachinaryDataIntoDatabase(boolean isFromAddMoreButton) {

        //Inset Production and Revenyue
        mDatabaseHelper.insertBusinessPlan3_2_MachineryAddMorNeweModelList(
                System.currentTimeMillis(),
                Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                edtParticularsManchinery.getText().toString(),
                Long.valueOf(edtMachinNosManchinery.getText().toString()),
                Double.valueOf(edtPriceManchinery.getText().toString()),
                Double.valueOf(edtAmountinRsManchinery.getText().toString()),
                CommonMethods.getLongDateFromStringDate(edtPurchaseDateManchinery.getText().toString()),
                Long.valueOf(edtExpectedLifeManchinery.getText().toString()),
                Long.valueOf(edtScrapValueManchinery.getText().toString()),
                Double.valueOf(edtDepreciationManchinery.getText().toString()),
                Double.valueOf(edtBookValueManchinery.getText().toString()),
                edtSuppliersNameManchinery.getText().toString(),
                Double.valueOf(edtTaxTransInRsManchinery.getText().toString()),
                Double.valueOf(edtElectrificationInRsManchinery.getText().toString()),
                txtUploadQuotationManchinery.getText().toString(),
                0);

        // reset dynamic view
        displayMachinerAndEquipmentData(false, isFromAddMoreButton);

    }

    private void openEditPLantAndMachineryDialog(final Integer positionFurnitureView) {


        final android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.box_machinary_new_edit, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();


        final EditText edtParticularsManchineryEditview = (EditText) dialogView.findViewById(R.id.edtParticularsManchineryEditview);
        final EditText edtMachinNosManchineryEditview = (EditText) dialogView.findViewById(R.id.edtMachinNosManchineryEditview);
        final EditText edtPriceManchineryEditview = (EditText) dialogView.findViewById(R.id.edtPriceManchineryEditview);
        final EditText edtAmountinRsManchineryEditview = (EditText) dialogView.findViewById(R.id.edtAmountinRsManchineryEditview);
        edtPurchaseDateManchineryEditview = (EditText) dialogView.findViewById(R.id.edtPurchaseDateManchineryEditview);
        final EditText edtExpectedLifeManchineryEditview = (EditText) dialogView.findViewById(R.id.edtExpectedLifeManchineryEditview);
        final EditText edtScrapValueManchineryEditview = (EditText) dialogView.findViewById(R.id.edtScrapValueManchineryEditview);
        final EditText edtDepreciationManchineryEditview = (EditText) dialogView.findViewById(R.id.edtDepreciationManchineryEditview);
        final EditText edtBookValueManchineryEditview = (EditText) dialogView.findViewById(R.id.edtBookValueManchineryEditview);
        final EditText edtSuppliersNameManchineryEditview = (EditText) dialogView.findViewById(R.id.edtSuppliersNameManchineryEditview);
        final EditText edtTaxTransInRsManchineryEditview = (EditText) dialogView.findViewById(R.id.edtTaxTransInRsManchineryEditview);
        final EditText edtElectrificationInRsManchineryEditview = (EditText) dialogView.findViewById(R.id.edtElectrificationInRsManchineryEditview);
        final LinearLayout linearQuotationEditview = (LinearLayout) dialogView.findViewById(R.id.linearQuotationEditview);
        final TextView txtCancelEditView = (TextView) dialogView.findViewById(R.id.txtCancelEditView);
        final TextView txtDeleteEditView = (TextView) dialogView.findViewById(R.id.txtDeleteEditView);
        final TextView txtCanSaveEditView = (TextView) dialogView.findViewById(R.id.txtUpdateEditView);

        final TextView txtSrNoManchineryEditView = (TextView) dialogView.findViewById(R.id.txtSrNoManchineryEditView);
        final TextView txtUploadQuotationManchineryEditview = (TextView) dialogView.findViewById(R.id.txtUploadQuotationManchineryEditview);
        final TextView txtTitlePerticulareEditView = (TextView) dialogView.findViewById(R.id.txtTitlePerticulareEditView);
        final TextView txtTitleMachineNumberEditView = (TextView) dialogView.findViewById(R.id.txtTitleMachineNumberEditview);
        final TextView txtTitlePerUnitPriceEditView = (TextView) dialogView.findViewById(R.id.txtTitlePerUnitPriceEditview);
        final TextView txtTitleTotalAmountEditView = (TextView) dialogView.findViewById(R.id.txtTitleTotalAmountEditview);
        final TextView txtTitlePurchaseDateEditView = (TextView) dialogView.findViewById(R.id.txtTitlePurchaseDateEditview);
        final TextView txtTitleExpectedLifeEditView = (TextView) dialogView.findViewById(R.id.txtTitleExpectedLifeEditview);
        final TextView txtTitleScrapValueEditView = (TextView) dialogView.findViewById(R.id.txtTitleScrapValueEditview);
        final TextView txtTitleDepriciatedCalEditView = (TextView) dialogView.findViewById(R.id.txtTitleDepriciatedCalEditview);
        final TextView txtTitleBookValueEditView = (TextView) dialogView.findViewById(R.id.txtTitleBookValueEditview);
        final TextView txtTitleSuppllierNameEditView = (TextView) dialogView.findViewById(R.id.txtTitleSuppllierNameEditview);
        final TextView txtTitleTransInRsEditView = (TextView) dialogView.findViewById(R.id.txtTitleTransInRsEditview);
        final TextView txtTitleElectrificationEditView = (TextView) dialogView.findViewById(R.id.txtTitleElectrificationEditview);

        //SET MENDETOARY FIELDS
        txtTitlePerticulareEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strParticulars)));
        txtTitleMachineNumberEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strMachinNos)));
        txtTitlePerUnitPriceEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerUnitPrice)));
        txtTitleTotalAmountEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalAmount)));
        txtTitlePurchaseDateEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPurchaseDate)));
        txtTitleExpectedLifeEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strExpectedLife)));
        txtTitleScrapValueEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerAnnum)));
        txtTitleDepriciatedCalEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strDepriciatedCal)));
        txtTitleBookValueEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strBookValue)));
        txtTitleSuppllierNameEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strSuppliersName)));
        txtTitleTransInRsEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTaxTransInRs)));
        txtTitleElectrificationEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strElectrificationInRs)));


        Double dblPriceManchinery = step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getPrice();
        Double dblAmountinRsManchinery = step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getAmount();
        Double dblDepreciationManchinery = step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getDepriciation();
        Double dblBookValueManchinery = step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getBookValue();
        Double dblTaxTransInRsManchinery = step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getTaxTransporatation();
        Double dblElectrificationInRsManchinery = step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getElectrification();

        edtParticularsManchineryEditview.setText("" + step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getPerticuler());
        edtMachinNosManchineryEditview.setText("" + step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getMachineryNo());
        edtPriceManchineryEditview.setText("" + dblPriceManchinery.intValue());
        edtAmountinRsManchineryEditview.setText("" + dblAmountinRsManchinery.intValue());
        edtPurchaseDateManchineryEditview.setText("" + CommonMethods.getDateFromLong(step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getPurchaseDate()));
        edtExpectedLifeManchineryEditview.setText("" + step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getExpectedLife());
        edtScrapValueManchineryEditview.setText("" + step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getScrapValue());
        edtDepreciationManchineryEditview.setText("" + dblDepreciationManchinery.intValue());
        edtBookValueManchineryEditview.setText("" + dblBookValueManchinery.intValue());
        edtSuppliersNameManchineryEditview.setText("" + step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getSuppliersNameAndAddress());
        edtTaxTransInRsManchineryEditview.setText("" + dblTaxTransInRsManchinery.intValue());
        edtElectrificationInRsManchineryEditview.setText("" + dblElectrificationInRsManchinery.intValue());
        txtUploadQuotationManchineryEditview.setText("" + step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getUploadQuotation());

        txtSrNoManchineryEditView.setText("" + (positionFurnitureView + 1));

        //Calculation on manchinery no.
        edtMachinNosManchineryEditview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtPriceManchineryEditview.setText("");
                edtAmountinRsManchineryEditview.setText("");
                edtPurchaseDateManchineryEditview.setText("");
                edtExpectedLifeManchineryEditview.setText("");
                edtScrapValueManchineryEditview.setText("");
                edtDepreciationManchineryEditview.setText("");
                edtBookValueManchineryEditview.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Calculation on Unit Price edit text
        edtPriceManchineryEditview.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                edtAmountinRsManchineryEditview.setText("");
                edtPurchaseDateManchineryEditview.setText("");
                edtExpectedLifeManchineryEditview.setText("");
                edtScrapValueManchineryEditview.setText("");
                edtDepreciationManchineryEditview.setText("");
                edtBookValueManchineryEditview.setText("");

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                try {
                    Double amount = Double.valueOf(edtMachinNosManchineryEditview.getText().toString()) * Double.valueOf(edtPriceManchineryEditview.getText().toString());
                    edtAmountinRsManchineryEditview.setText(String.valueOf(amount.intValue()));
                } catch (NumberFormatException e) {
                    edtAmountinRsManchineryEditview.setText("");
                }
            }
        });

        //Click on purchase date
        edtPurchaseDateManchineryEditview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isFromPlsntAndMachineryEditview = true;
                edtExpectedLifeManchineryEditview.setText("");
                edtScrapValueManchineryEditview.setText("");
                openDatePickerDialogForPlantAndMachinery();

            }
        });

        //Calculation on expected life
        edtExpectedLifeManchinery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().isEmpty()) {
                    edtScrapValueManchinery.setText("");
                    edtDepreciationManchinery.setText("");
                    edtBookValueManchinery.setText("");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (edtExpectedLifeManchinery.getText().toString().equals("0")) {
                    edtExpectedLifeManchinery.setText("");
                    edtScrapValueManchinery.setText("");
                    edtDepreciationManchinery.setText("");
                    edtBookValueManchinery.setText("");
                    CommonMethods.displayToast(mActivity, getActivity().getResources().getString(R.string.strExpectedNotZero));
                }

            }
        });

        //Calculation on expected life
        edtExpectedLifeManchineryEditview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (s.toString().isEmpty()) {
                    edtScrapValueManchineryEditview.setText("");
                    edtDepreciationManchineryEditview.setText("");
                    edtBookValueManchineryEditview.setText("");
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                if (edtExpectedLifeManchineryEditview.getText().toString().equals("0")) {
                    edtExpectedLifeManchineryEditview.setText("");
                    edtScrapValueManchineryEditview.setText("");
                    edtDepreciationManchineryEditview.setText("");
                    edtBookValueManchineryEditview.setText("");
                    CommonMethods.displayToast(mActivity, getActivity().getResources().getString(R.string.strExpectedNotZero));
                }

            }
        });

        //Calculation on scrap value edit text change listner
        edtScrapValueManchineryEditview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    if (edtPurchaseDateManchineryEditview.getText().toString().length() != 0) {

                        if (s.length() != 0) {
                            Calendar c = Calendar.getInstance();

                            SimpleDateFormat df = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                            String strCurrentDate = df.format(c.getTime());

                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                                dateCurrentPlantMachiney = sdf.parse(strCurrentDate);
                                dateEnteredPlantMachinery = sdf.parse(edtPurchaseDateManchineryEditview.getText().toString());
                            } catch (ParseException ex) {
                            }

                            Calendar startCalendar = new GregorianCalendar();
                            startCalendar.setTime(dateEnteredPlantMachinery);
                            Calendar endCalendar = new GregorianCalendar();
                            endCalendar.setTime(dateCurrentPlantMachiney);

                            int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                            dateDifferencePlantMachinery = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                            int A = Integer.parseInt(edtAmountinRsManchineryEditview.getText().toString());
                            int B = Integer.parseInt(edtScrapValueManchineryEditview.getText().toString());
                            int C = Integer.parseInt(edtExpectedLifeManchineryEditview.getText().toString());

                            int D = (A - B) / C;
                            edtDepreciationManchineryEditview.setText("" + D);

                            int months = dateDifferencePlantMachinery / 12;

                            int F = A - (D * months);

                            edtBookValueManchineryEditview.setText("" + F);

                        } else {
                            edtDepreciationManchineryEditview.setText("");
                            edtBookValueManchineryEditview.setText("");
                        }
                    }

                } catch (NumberFormatException e) {
                    edtDepreciationManchineryEditview.setText("");
                    edtBookValueManchineryEditview.setText("");
                }

            }
        });


        //Click on purchase date
        txtUploadQuotationManchineryEditview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Divya 7 march 2018
                // checkPermission();


            }
        });


        //----(Dismiss popup)-----//
        txtCancelEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });

        //----(Delet selected view from list)-----//
        txtDeleteEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPlanMachineryItemsDeleteDialog(positionFurnitureView);
                mAlertDialog.dismiss();

            }
        });


        //----(Save Edited values in database as well as in current array list)-----//
        txtCanSaveEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkValidationForPlantAndMachineEdive()) {

                    //Inset Production and Revenyue
                    mDatabaseHelper.updateBusinessPlan3_2_MachineryAddMorNeweModelList(
                            step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getId(),
                            step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getBusinessPlanID(),
                            edtParticularsManchineryEditview.getText().toString(),
                            Long.valueOf(edtMachinNosManchineryEditview.getText().toString()),
                            Double.valueOf(edtPriceManchineryEditview.getText().toString()),
                            Double.valueOf(edtAmountinRsManchineryEditview.getText().toString()),
                            CommonMethods.getLongDateFromStringDate(edtPurchaseDateManchineryEditview.getText().toString()),
                            Long.valueOf(edtExpectedLifeManchineryEditview.getText().toString()),
                            Long.valueOf(edtScrapValueManchineryEditview.getText().toString()),
                            Double.valueOf(edtDepreciationManchineryEditview.getText().toString()),
                            Double.valueOf(edtBookValueManchineryEditview.getText().toString()),
                            edtSuppliersNameManchineryEditview.getText().toString(),
                            Double.valueOf(edtTaxTransInRsManchineryEditview.getText().toString()),
                            Double.valueOf(edtElectrificationInRsManchineryEditview.getText().toString()),
                            "", 0);

                    // reset dynamic view
                    displayMachinerAndEquipmentData(false, false);
                    mAlertDialog.dismiss();

                }
            }


            private boolean checkValidationForPlantAndMachineEdive() {


                if (edtParticularsManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterParticular));
                    edtParticularsManchineryEditview.requestFocus();
                    return false;
                } else if (edtMachinNosManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterTheMachineNo));
                    edtMachinNosManchineryEditview.requestFocus();
                    return false;
                } else if (edtPriceManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePrice));
                    edtPriceManchineryEditview.requestFocus();
                    return false;
                } else if (edtPurchaseDateManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePurchaseDate));
                    edtPurchaseDateManchineryEditview.requestFocus();
                    return false;
                } else if (edtExpectedLifeManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheExpectedLife));
                    edtExpectedLifeManchineryEditview.requestFocus();
                    return false;
                } else if (edtScrapValueManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheScrapValue));
                    edtScrapValueManchineryEditview.requestFocus();
                    return false;
                } else if (edtSuppliersNameManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterNameAndAddress));
                    edtSuppliersNameManchineryEditview.requestFocus();
                    return false;
                } else if (edtTaxTransInRsManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorNewBusinessPlanTaxAndTransportation));
                    edtTaxTransInRsManchineryEditview.requestFocus();
                    return false;
                } else if (edtElectrificationInRsManchineryEditview.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterElectification));
                    edtElectrificationInRsManchineryEditview.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }

        });


        mAlertDialog.show();


    }

    private void openPlanMachineryItemsDeleteDialog(final Integer positionFurnitureView) {

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

                mDatabaseHelper.deleteBusinessPlan3_2_MachineryAddMorNeweModelList(step3_2_GetMachineryAndEquipmentList.get(positionFurnitureView).getId());
                displayMachinerAndEquipmentData(true, false);
                mAlertDialog.dismiss();
            }
        });


        mAlertDialog.show();
    }

    private void displayFurnitureData(boolean isFromDelete, boolean isFromAddButton) {

        //Remove All Views from dynamic added layout
        llDynamicEquipmentFurniture.removeAllViews();
        int arraySize = 0;

        //Get Saved Business Plan Data From Database
        step3_3_GetFurnitureDataList = mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)));


        //Inflate view as per arraylist size for different scenarios
        if (step3_3_GetFurnitureDataList.size() != 0 && !isFromAddButton) {
            arraySize = step3_3_GetFurnitureDataList.size();
        } else if (step3_3_GetFurnitureDataList.size() != 0 && isFromAddButton) {
            arraySize = (step3_3_GetFurnitureDataList.size() + 1);
        } else {
            arraySize = 1;
        }


        for (int i = 0; i < arraySize; i++) {

            //------(Add dynamic views as per array list size)-------//
            addMoreFurnitureView = mActivity.getLayoutInflater().inflate(R.layout.box_furniture_new, llDynamicEquipmentFurniture, false);

            //------(Find views)-------//
            tvNoOfEducationFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.tvNoOfEducationFurniture);
            txtTitleParticularFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleParticularFurniture);
            txtTitleMachineNumberFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleMachineNumberFurniture);
            txtTitlePerUnitPriceFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitlePerUnitPriceFurniture);
            txtTitleAmountInRSFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleAmountInRSFurniture);
            txtTitlePurchaseDateFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitlePurchaseDateFurniture);
            txtTitleExpectedLifeFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleExpectedLifeFurniture);
            txtTitleScrapValueFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleScrapValueFurniture);
            txtTitleDepriciatedCalFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleDepriciatedCalFurniture);
            txtTitleBookValueFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleBookValueFurniture);
            txtTitleSuppllierNameFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.txtTitleSuppllierNameFurniture);

            etParticularsFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etParticularsFurniture);
            etMachinNosFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etMachinNosFurniture);
            etPriceFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etPriceFurniture);
            etAmountinRsFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etAmountinRsFurniture);
            etPurchaseDateFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etPurchaseDateFurniture);
            etExpectedLifeFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etExpectedLifeFurniture);
            etScrapValueFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etScrapValueFurniture);
            etDepreciationFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etDepreciationFurniture);
            etBookValueFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etBookValueFurniture);
            etSuppliersNameFurniture = (EditText) addMoreFurnitureView.findViewById(R.id.etSuppliersNameFurniture);
            imgEditViewFurniture = (ImageView) addMoreFurnitureView.findViewById(R.id.imgEditViewFurniture);
            linearFurnitureQuotations = (LinearLayout) addMoreFurnitureView.findViewById(R.id.linearFurnitureQuotations);
            edtUploadQuotaionsFurniture = (TextView) addMoreFurnitureView.findViewById(R.id.edtUploadQuotaionsFurniture);

            //set seriel no. to the dynamic added view
            tvNoOfEducationFurniture.setText("" + (i + 1));

            //SET MENDETOARY FIELDS
            txtTitleParticularFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strParticulars)));
            txtTitleMachineNumberFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strMachinNos)));
            txtTitlePerUnitPriceFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerUnitPrice)));
            txtTitleAmountInRSFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalAmount)));
            txtTitlePurchaseDateFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strPurchaseDate)));
            txtTitleExpectedLifeFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strExpectedLife)));
            txtTitleScrapValueFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerAnnum)));
            txtTitleDepriciatedCalFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strDepriciatedCal)));
            txtTitleBookValueFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strBookValue)));
            txtTitleSuppllierNameFurniture.setText(CommonMethods.spannableString(getResources().getString(R.string.strSuppliersName)));


            //----(Set already existing data)-----//
            if (step3_3_GetFurnitureDataList.size() != 0) {

                if (step3_3_GetFurnitureDataList.size() > i) {

                    Double dblPriceManchinery = step3_3_GetFurnitureDataList.get(i).getPrice();
                    Double dblAmountinRsManchinery = step3_3_GetFurnitureDataList.get(i).getAmount();
                    Double dblDepreciationManchinery = step3_3_GetFurnitureDataList.get(i).getDepriciation();
                    Double dblBookValueManchinery = step3_3_GetFurnitureDataList.get(i).getBookValue();

                    etParticularsFurniture.setText("" + step3_3_GetFurnitureDataList.get(i).getPerticuler());
                    etMachinNosFurniture.setText("" + step3_3_GetFurnitureDataList.get(i).getMachineryNo());
                    etPriceFurniture.setText("" + dblPriceManchinery.intValue());
                    etAmountinRsFurniture.setText("" + dblAmountinRsManchinery.intValue());
                    etPurchaseDateFurniture.setText("" + CommonMethods.getDateFromLong(step3_3_GetFurnitureDataList.get(i).getPurchaseDate()));
                    etExpectedLifeFurniture.setText("" + step3_3_GetFurnitureDataList.get(i).getExpectedLife());
                    etScrapValueFurniture.setText("" + step3_3_GetFurnitureDataList.get(i).getScrapValue());
                    etDepreciationFurniture.setText("" + dblDepreciationManchinery.intValue());
                    etBookValueFurniture.setText("" + dblBookValueManchinery.intValue());
                    etSuppliersNameFurniture.setText("" + step3_3_GetFurnitureDataList.get(i).getSuppliersNameAndAddress());

                    if (step3_3_GetFurnitureDataList.get(i).getIsDataEditable() != 1) {
                        etParticularsFurniture.setFocusableInTouchMode(false);
                        etMachinNosFurniture.setFocusableInTouchMode(false);
                        etPriceFurniture.setFocusableInTouchMode(false);
                        etAmountinRsFurniture.setFocusableInTouchMode(false);
                        etPurchaseDateFurniture.setFocusableInTouchMode(false);
                        etPurchaseDateFurniture.setClickable(false);
                        etExpectedLifeFurniture.setFocusableInTouchMode(false);
                        etScrapValueFurniture.setFocusableInTouchMode(false);
                        etDepreciationFurniture.setFocusableInTouchMode(false);
                        etBookValueFurniture.setFocusableInTouchMode(false);
                        etSuppliersNameFurniture.setFocusableInTouchMode(false);
                        linearFurnitureQuotations.setVisibility(View.GONE);
                    }

                } else {
                    //Hide edit view image if data is newley added or click on add more button
                    imgEditViewFurniture.setVisibility(View.GONE);
                }


            } else {
                //Hide edit view image if data is newley added or click on add more button
                imgEditViewFurniture.setVisibility(View.GONE);
            }
            if (isBusinessPlanSubmitted) {
                imgEditViewFurniture.setVisibility(View.GONE);
            }


            //Adding view to dynamic layout
            llDynamicEquipmentFurniture.addView(addMoreFurnitureView);
            final int position = llDynamicEquipmentFurniture.indexOfChild(addMoreFurnitureView);
            imgEditViewFurniture.setTag(position);

            //----(use position for delete view)-----//
            imgEditViewFurniture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    getPositionFurnitureView = (Integer) v.getTag();
                    //open edit view dialog
                    openEditFurnitureDataDialog(getPositionFurnitureView);

                }
            });

            //---(Open Image picker dialog)------//
            edtUploadQuotaionsFurniture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isPlantAndMachinaryQuotation = false;
                    // checkPermission();
                }
            });


            //Calculation on manchinery no.
            etMachinNosFurniture.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    etPriceFurniture.setText("");
                    etAmountinRsFurniture.setText("");
                    etPurchaseDateFurniture.setText("");
                    etExpectedLifeFurniture.setText("");
                    etScrapValueFurniture.setText("");
                    etDepreciationFurniture.setText("");
                    etBookValueFurniture.setText("");
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            //Calculation on Unit Price edit text
            etPriceFurniture.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {

                    etAmountinRsFurniture.setText("");
                    etPurchaseDateFurniture.setText("");
                    etExpectedLifeFurniture.setText("");
                    etScrapValueFurniture.setText("");
                    etDepreciationFurniture.setText("");
                    etBookValueFurniture.setText("");


                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {


                    try {
                        Double amount = Double.valueOf(etMachinNosFurniture.getText().toString()) * Double.valueOf(etPriceFurniture.getText().toString());
                        etAmountinRsFurniture.setText(String.valueOf(amount.intValue()));
                    } catch (NumberFormatException e) {
                        etAmountinRsFurniture.setText("");
                    }
                }
            });

            //Click on purchase date
            etPurchaseDateFurniture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    isFromFurnitureView = true;
                    etExpectedLifeFurniture.setText("");
                    etScrapValueFurniture.setText("");
                    openDatePickerDialogForPlantAndMachinery();

                }
            });

            //Calculation on expected life
            etExpectedLifeFurniture.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (s.toString().isEmpty()) {
                        etScrapValueFurniture.setText("");
                        etDepreciationFurniture.setText("");
                        etBookValueFurniture.setText("");
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    //Divya 13 march 2018
                    if (etExpectedLifeFurniture.getText().toString().equals("0")) {
                        etExpectedLifeFurniture.setText("");
                        etScrapValueFurniture.setText("");
                        etDepreciationFurniture.setText("");
                        etBookValueFurniture.setText("");
                        CommonMethods.displayToast(mActivity, getActivity().getResources().getString(R.string.strExpectedNotZero));

                    }

                }
            });

            //Calculation on scrap value edit text change listner
            etScrapValueFurniture.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    try {

                        if (etPurchaseDateFurniture.getText().toString().length() != 0) {

                            if (s.length() != 0) {
                                Calendar c = Calendar.getInstance();

                                SimpleDateFormat df = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                                String strCurrentDate = df.format(c.getTime());

                                try {
                                    SimpleDateFormat sdf = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                                    dateCurrentPlantFurniture = sdf.parse(strCurrentDate);
                                    dateEnteredPlantFurniture = sdf.parse(etPurchaseDateFurniture.getText().toString());
                                } catch (ParseException ex) {
                                }

                                Calendar startCalendar = new GregorianCalendar();
                                startCalendar.setTime(dateEnteredPlantFurniture);
                                Calendar endCalendar = new GregorianCalendar();
                                endCalendar.setTime(dateCurrentPlantFurniture);

                                int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                                dateDifferencePlantFurniture = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                                Double A = Double.valueOf(etAmountinRsFurniture.getText().toString());
                                Double B = Double.valueOf(etScrapValueFurniture.getText().toString());
                                Double C = Double.valueOf(etExpectedLifeFurniture.getText().toString());

                                Double D = (A - B) / C;
                                etDepreciationFurniture.setText("" + D);

                                int months = dateDifferencePlantFurniture / 12;

                                Double F = A - (D * months);

                                etBookValueFurniture.setText("" + F);

                            } else {
                                etDepreciationFurniture.setText("");
                                etBookValueFurniture.setText("");
                            }
                        }

                    } catch (NumberFormatException e) {
                        etDepreciationFurniture.setText("");
                        etBookValueFurniture.setText("");
                    }

                }
            });


        }

    }

    private void saveFurnitureDataInToDatabase(boolean isFromAddMoreButton) {

        if (step3_3_GetFurnitureDataList.size() != 0) {

            //check if data already saved in database
            if (etParticularsFurniture.getText().toString().equals(step3_3_GetFurnitureDataList.get(step3_3_GetFurnitureDataList.size() - 1).getPerticuler())) {
                displayFurnitureData(false, isFromAddMoreButton);
            } else {

                if (checkValidationFurniture()) {
                    insertFurnitureDataInTODatabse(isFromAddMoreButton);
                }
            }
        } else {
            //remove all view before add another view
            if (checkValidationFurniture()) {
                insertFurnitureDataInTODatabse(isFromAddMoreButton);
            }
        }

    }

    private boolean checkValidationFurniture() {

        if (etParticularsFurniture.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterParticular));
            etParticularsFurniture.requestFocus();
            return false;
        } else if (etMachinNosFurniture.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterTheFurniture));
            etMachinNosFurniture.requestFocus();
            return false;
        } else if (etPriceFurniture.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePrice));
            etPriceFurniture.requestFocus();
            return false;
        } else if (etPurchaseDateFurniture.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePurchaseDate));
            etPurchaseDateFurniture.requestFocus();
            return false;
        } else if (etExpectedLifeFurniture.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheExpectedLife));
            etExpectedLifeFurniture.requestFocus();
            return false;
        } else if (etScrapValueFurniture.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheScrapValue));
            etScrapValueFurniture.requestFocus();
            return false;
        } else if (etSuppliersNameFurniture.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterNameAndAddress));
            etSuppliersNameFurniture.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void insertFurnitureDataInTODatabse(boolean isFromAddMoreButton) {

        //Insert furniture data in to database
        mDatabaseHelper.insertBusinessPlan3_3_FurnitureAddMorNeweModelList(
                System.currentTimeMillis(),
                Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                etParticularsFurniture.getText().toString(),
                Long.valueOf(etMachinNosFurniture.getText().toString()),
                Double.valueOf(etPriceFurniture.getText().toString()),
                Double.valueOf(etAmountinRsFurniture.getText().toString()),
                CommonMethods.getLongDateFromStringDate(etPurchaseDateFurniture.getText().toString()),
                Long.valueOf(etExpectedLifeFurniture.getText().toString()),
                Long.valueOf(etScrapValueFurniture.getText().toString()),
                Double.valueOf(etDepreciationFurniture.getText().toString()),
                Double.valueOf(etBookValueFurniture.getText().toString()),
                etSuppliersNameFurniture.getText().toString(),
                edtUploadQuotaionsFurniture.getText().toString(),
                0);

        // reset dynamic view
        displayFurnitureData(false, isFromAddMoreButton);
    }

    private void openEditFurnitureDataDialog(final Integer positionFurnitureView) {


        final android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.box_furniture_new_edit, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();

        final TextView tvNoOfEducationFurnitureEditView = (TextView) dialogView.findViewById(R.id.tvNoOfEducationFurnitureEditView);

        final TextView txtTitleParticularFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleParticularFurnitureEditView);
        final TextView txtTitleMachineNumberFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleMachineNumberFurnitureEditView);
        final TextView txtTitlePerUnitPriceFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitlePerUnitPriceFurnitureEditView);
        final TextView txtTitleAmountInRSFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleAmountInRSFurnitureEditView);
        final TextView txtTitlePurchaseDateFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitlePurchaseDateFurnitureEditView);
        final TextView txtTitleExpectedLifeFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleExpectedLifeFurnitureEditView);
        final TextView txtTitleScrapValueFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleScrapValueFurnitureEditView);
        final TextView txtTitleDepriciatedCalFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleDepriciatedCalFurnitureEditView);
        final TextView txtTitleBookValueFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleBookValueFurnitureEditView);
        final TextView txtTitleSuppllierNameFurnitureEditView = (TextView) dialogView.findViewById(R.id.txtTitleSuppllierNameFurnitureEditView);


        final EditText etParticularsFurnitureEditView = (EditText) dialogView.findViewById(R.id.etParticularsFurnitureEditView);
        final EditText etMachinNosFurnitureEditView = (EditText) dialogView.findViewById(R.id.etMachinNosFurnitureEditView);
        final EditText etPriceFurnitureEditView = (EditText) dialogView.findViewById(R.id.etPriceFurnitureEditView);
        final EditText etAmountinRsFurnitureEditView = (EditText) dialogView.findViewById(R.id.etAmountinRsFurnitureEditView);
        etPurchaseDateFurnitureEditView = (EditText) dialogView.findViewById(R.id.etPurchaseDateFurnitureEditView);
        final EditText etExpectedLifeFurnitureEditView = (EditText) dialogView.findViewById(R.id.etExpectedLifeFurnitureEditView);
        final EditText etScrapValueFurnitureEditView = (EditText) dialogView.findViewById(R.id.etScrapValueFurnitureEditView);
        final EditText etDepreciationFurnitureEditView = (EditText) dialogView.findViewById(R.id.etDepreciationFurnitureEditView);
        final EditText etBookValueFurnitureEditView = (EditText) dialogView.findViewById(R.id.etBookValueFurnitureEditView);
        final EditText etSuppliersNameFurnitureEditView = (EditText) dialogView.findViewById(R.id.etSuppliersNameFurnitureEditView);
        final TextView txtCancelEditView = (TextView) dialogView.findViewById(R.id.txtCancelEditView);
        final TextView txtDeleteEditView = (TextView) dialogView.findViewById(R.id.txtDeleteEditView);
        final TextView txtCanSaveEditView = (TextView) dialogView.findViewById(R.id.txtUpdateEditView);

        //SET SR. NUMBER
        tvNoOfEducationFurnitureEditView.setText("" + (positionFurnitureView + 1));

        //SET MENDETOARY FIELDS
        txtTitleParticularFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strParticulars)));
        txtTitleMachineNumberFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strMachinNos)));
        txtTitlePerUnitPriceFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerUnitPrice)));
        txtTitleAmountInRSFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalAmount)));
        txtTitlePurchaseDateFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPurchaseDate)));
        txtTitleExpectedLifeFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strExpectedLife)));
        txtTitleScrapValueFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerAnnum)));
        txtTitleDepriciatedCalFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strDepriciatedCal)));
        txtTitleBookValueFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strBookValue)));
        txtTitleSuppllierNameFurnitureEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strSuppliersName)));


        Double dblPriceManchinery = step3_3_GetFurnitureDataList.get(positionFurnitureView).getPrice();
        Double dblAmountinRsManchinery = step3_3_GetFurnitureDataList.get(positionFurnitureView).getAmount();
        Double dblDepreciationManchinery = step3_3_GetFurnitureDataList.get(positionFurnitureView).getDepriciation();
        Double dblBookValueManchinery = step3_3_GetFurnitureDataList.get(positionFurnitureView).getBookValue();


        etParticularsFurnitureEditView.setText("" + step3_3_GetFurnitureDataList.get(positionFurnitureView).getPerticuler());
        etMachinNosFurnitureEditView.setText("" + step3_3_GetFurnitureDataList.get(positionFurnitureView).getMachineryNo());
        etPriceFurnitureEditView.setText("" + dblPriceManchinery.intValue());
        etAmountinRsFurnitureEditView.setText("" + dblAmountinRsManchinery.intValue());
        etPurchaseDateFurnitureEditView.setText("" + CommonMethods.getDateFromLong(step3_3_GetFurnitureDataList.get(positionFurnitureView).getPurchaseDate()));
        etExpectedLifeFurnitureEditView.setText("" + step3_3_GetFurnitureDataList.get(positionFurnitureView).getExpectedLife());
        etScrapValueFurnitureEditView.setText("" + step3_3_GetFurnitureDataList.get(positionFurnitureView).getScrapValue());
        etDepreciationFurnitureEditView.setText("" + dblDepreciationManchinery.intValue());
        etBookValueFurnitureEditView.setText("" + dblBookValueManchinery.intValue());
        etSuppliersNameFurnitureEditView.setText("" + step3_3_GetFurnitureDataList.get(positionFurnitureView).getSuppliersNameAndAddress());


        //----(Dismiss popup)-----//
        txtCancelEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });

        //----(Delet selected view from list)-----//
        txtDeleteEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFurnitureItemsDeleteDialog(positionFurnitureView);
                mAlertDialog.dismiss();


            }
        });
        //----(Dismiss popup)-----//
        txtCanSaveEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert furniture data in to database
                if (checkValidationFurnitureEditView()) {
                    mDatabaseHelper.updateBusinessPlan3_3_FurnitureAddMorNeweModelList(
                            step3_3_GetFurnitureDataList.get(positionFurnitureView).getId(),
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                            etParticularsFurnitureEditView.getText().toString(),
                            Long.valueOf(etMachinNosFurnitureEditView.getText().toString()),
                            Double.valueOf(etPriceFurnitureEditView.getText().toString()),
                            Double.valueOf(etAmountinRsFurnitureEditView.getText().toString()),
                            CommonMethods.getLongDateFromStringDate(etPurchaseDateFurnitureEditView.getText().toString()),
                            Long.valueOf(etExpectedLifeFurnitureEditView.getText().toString()),
                            Long.valueOf(etScrapValueFurnitureEditView.getText().toString()),
                            Double.valueOf(etDepreciationFurnitureEditView.getText().toString()),
                            Double.valueOf(etBookValueFurnitureEditView.getText().toString()),
                            etSuppliersNameFurnitureEditView.getText().toString(),
                            "",
                            0);

                    // reset dynamic view
                    displayFurnitureData(false, false);
                    mAlertDialog.dismiss();
                }

            }

            private boolean checkValidationFurnitureEditView() {

                if (etParticularsFurnitureEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterParticular));
                    etParticularsFurnitureEditView.requestFocus();
                    return false;
                } else if (etMachinNosFurnitureEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterTheFurniture));
                    etMachinNosFurnitureEditView.requestFocus();
                    return false;
                } else if (etPriceFurnitureEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePrice));
                    etPriceFurnitureEditView.requestFocus();
                    return false;
                } else if (etPurchaseDateFurnitureEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterThePurchaseDate));
                    etPurchaseDateFurnitureEditView.requestFocus();
                    return false;
                } else if (etExpectedLifeFurnitureEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheExpectedLife));
                    etExpectedLifeFurnitureEditView.requestFocus();
                    return false;
                } else if (etScrapValueFurnitureEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterTheScrapValue));
                    etScrapValueFurnitureEditView.requestFocus();
                    return false;
                } else if (etSuppliersNameFurnitureEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPleaseEnterNameAndAddress));
                    etSuppliersNameFurnitureEditView.requestFocus();
                    return false;
                } else {
                    return true;
                }

            }
        });


        //Calculation on manchinery no.
        etMachinNosFurnitureEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etPriceFurnitureEditView.setText("");
                etAmountinRsFurnitureEditView.setText("");
                etPurchaseDateFurnitureEditView.setText("");
                etExpectedLifeFurnitureEditView.setText("");
                etScrapValueFurnitureEditView.setText("");
                etDepreciationFurnitureEditView.setText("");
                etBookValueFurnitureEditView.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Calculation on Unit Price edit text
        etPriceFurnitureEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                etAmountinRsFurnitureEditView.setText("");
                etPurchaseDateFurnitureEditView.setText("");
                etExpectedLifeFurnitureEditView.setText("");
                etScrapValueFurnitureEditView.setText("");
                etDepreciationFurnitureEditView.setText("");
                etBookValueFurnitureEditView.setText("");


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                try {
                    Double amount = Double.valueOf(etMachinNosFurnitureEditView.getText().toString()) * Double.valueOf(etPriceFurnitureEditView.getText().toString());
                    etAmountinRsFurnitureEditView.setText(String.valueOf(amount.intValue()));
                } catch (NumberFormatException e) {
                    etAmountinRsFurnitureEditView.setText("");
                }
            }
        });

        //Click on purchase date
        etPurchaseDateFurnitureEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isFromFurnitureEditView = true;
                etExpectedLifeFurnitureEditView.setText("");
                etScrapValueFurnitureEditView.setText("");
                openDatePickerDialogForPlantAndMachinery();

            }
        });

        //Calculation on expected life
        etExpectedLifeFurnitureEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().isEmpty()) {
                    etScrapValueFurnitureEditView.setText("");
                    etDepreciationFurnitureEditView.setText("");
                    etBookValueFurnitureEditView.setText("");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                //Divya 13 march 2018
                if (etExpectedLifeFurnitureEditView.getText().toString().equals("0")) {
                    etExpectedLifeFurnitureEditView.setText("");
                    etScrapValueFurnitureEditView.setText("");
                    etDepreciationFurnitureEditView.setText("");
                    etBookValueFurnitureEditView.setText("");
                    CommonMethods.displayToast(mActivity, getActivity().getResources().getString(R.string.strExpectedNotZero));

                }


            }
        });

        //Calculation on scrap value edit text change listner
        etScrapValueFurnitureEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    if (etPurchaseDateFurnitureEditView.getText().toString().length() != 0) {

                        if (s.length() != 0) {
                            Calendar c = Calendar.getInstance();

                            SimpleDateFormat df = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                            String strCurrentDate = df.format(c.getTime());

                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
                                dateCurrentPlantFurnitureEditView = sdf.parse(strCurrentDate);
                                dateEnteredPlantFurnitureEditView = sdf.parse(etPurchaseDateFurnitureEditView.getText().toString());
                            } catch (ParseException ex) {
                            }

                            Calendar startCalendar = new GregorianCalendar();
                            startCalendar.setTime(dateEnteredPlantFurnitureEditView);
                            Calendar endCalendar = new GregorianCalendar();
                            endCalendar.setTime(dateCurrentPlantFurnitureEditView);

                            int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                            dateDifferencePlantFurnitureEditView = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);


                            int A = Integer.parseInt(etAmountinRsFurnitureEditView.getText().toString());
                            int B = Integer.parseInt(etScrapValueFurnitureEditView.getText().toString());
                            int C = Integer.parseInt(etExpectedLifeFurnitureEditView.getText().toString());

                            int D = (A - B) / C;
                            etDepreciationFurnitureEditView.setText("" + D);

                            int months = dateDifferencePlantFurnitureEditView / 12;

                            int F = A - (D * months);

                            etBookValueFurnitureEditView.setText("" + F);

                        } else {
                            etDepreciationFurnitureEditView.setText("");
                            etBookValueFurnitureEditView.setText("");
                        }
                    }

                } catch (NumberFormatException e) {
                    etDepreciationFurnitureEditView.setText("");
                    etBookValueFurnitureEditView.setText("");
                }

            }
        });

        mAlertDialog.show();

    }

    private void openFurnitureItemsDeleteDialog(final Integer positionFurnitureView) {

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

                mDatabaseHelper.deleteBusinessPlan3_3_FurnitureAddMorNeweModelList(step3_3_GetFurnitureDataList.get(positionFurnitureView).getId());
                displayFurnitureData(true, false);
                mAlertDialog.dismiss();
            }
        });


        mAlertDialog.show();
    }

    private void displayRawMaterirelDataData(boolean isFromDelete, boolean isFromAddButton) {

        //Remove All Views from dynamic added layout
        llDynamicRawMaterial.removeAllViews();
        int arraySize = 0;

        //Get Saved Business Plan Data From Database
        step3_4_RawMeterielAddMoreModelList = mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)));

        //Inflate view as per arraylist size for different scenarios
        if (step3_4_RawMeterielAddMoreModelList.size() != 0 && !isFromAddButton) {
            arraySize = step3_4_RawMeterielAddMoreModelList.size();
        } else if (step3_4_RawMeterielAddMoreModelList.size() != 0 && isFromAddButton) {
            arraySize = (step3_4_RawMeterielAddMoreModelList.size() + 1);
        } else {
            arraySize = 1;
        }


        for (int i = 0; i < arraySize; i++) {

            //------(Add dynamic views as per array list size)-------//
            addMoreRawMeterielView = mActivity.getLayoutInflater().inflate(R.layout.box_raw_material_new, llDynamicRawMaterial, false);

            //------(Find views)-------//
            tvNoOfItems = (TextView) addMoreRawMeterielView.findViewById(R.id.tvNoOfItems);
            txtTitleItem = (TextView) addMoreRawMeterielView.findViewById(R.id.txtTitleItem);
            txtTitleNoOfTimes = (TextView) addMoreRawMeterielView.findViewById(R.id.txtTitleNoOfTimes);
            txtTitleQuantity = (TextView) addMoreRawMeterielView.findViewById(R.id.txtTitleQuantity);
            txtTitleUnitRate = (TextView) addMoreRawMeterielView.findViewById(R.id.txtTitleUnitRate);
            txtTitleTotalValues = (TextView) addMoreRawMeterielView.findViewById(R.id.txtTitleTotalValues);

            etItem = (EditText) addMoreRawMeterielView.findViewById(R.id.etItem);
            etForMonths = (EditText) addMoreRawMeterielView.findViewById(R.id.etForMonths);
            etQuantity = (EditText) addMoreRawMeterielView.findViewById(R.id.etQuantity);
            etUnitRate = (EditText) addMoreRawMeterielView.findViewById(R.id.etUnitRate);
            etTotalValues = (EditText) addMoreRawMeterielView.findViewById(R.id.etTotalValues);
            imgEditView = (ImageView) addMoreRawMeterielView.findViewById(R.id.imgEditView);

            etForMonths.setFilters(new InputFilter[]{new InputFilterMinMax(1, 365)});


            //set seriel no. to the dynamic added view
            tvNoOfItems.setText("" + (i + 1));

            //SET MENDETORY DATA
            txtTitleItem.setText(CommonMethods.spannableString(getResources().getString(R.string.strItem)));
            txtTitleNoOfTimes.setText(CommonMethods.spannableString(getResources().getString(R.string.strNoOfTimesPerYear)));
            txtTitleQuantity.setText(CommonMethods.spannableString(getResources().getString(R.string.strQuantity)));
            txtTitleUnitRate.setText(CommonMethods.spannableString(getResources().getString(R.string.strUnitRate)));
            txtTitleTotalValues.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalValues)));


            //----(Set already existing data)-----//
            if (step3_4_RawMeterielAddMoreModelList.size() != 0) {

                if (step3_4_RawMeterielAddMoreModelList.size() > i) {

                    Double dblQuantity = Double.valueOf(String.valueOf(step3_4_RawMeterielAddMoreModelList.get(i).getQuantity()));
                    Double dblUnitRate = Double.valueOf(String.valueOf(step3_4_RawMeterielAddMoreModelList.get(i).getRate()));
                    Double dblTotalValues = step3_4_RawMeterielAddMoreModelList.get(i).getTotalValue();


                    etItem.setText("" + step3_4_RawMeterielAddMoreModelList.get(i).getItem());
                    etForMonths.setText("" + step3_4_RawMeterielAddMoreModelList.get(i).getForMonths());
                    etQuantity.setText("" + dblQuantity.intValue());
                    etUnitRate.setText("" + dblUnitRate);

                    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                    String firstNumberAsString = decimalFormat.format(dblTotalValues);
                    etTotalValues.setText(firstNumberAsString);
                    // etTotalValues.setText("" + dblTotalValues);

                    if (step3_4_RawMeterielAddMoreModelList.get(i).getIsEditable() != 1) {
                        etItem.setFocusableInTouchMode(false);
                        etForMonths.setFocusableInTouchMode(false);
                        etQuantity.setFocusableInTouchMode(false);
                        etUnitRate.setFocusableInTouchMode(false);
                        etTotalValues.setFocusableInTouchMode(false);

                    }
                } else {
                    //Hide edit view image if data is newley added or click on add more button
                    imgEditView.setVisibility(View.GONE);
                }


            } else {
                //Hide edit view image if data is newley added or click on add more button
                imgEditView.setVisibility(View.GONE);
            }

            if (isBusinessPlanSubmitted) {
                imgEditView.setVisibility(View.GONE);
            }

            //Adding view to dynamic layout
            llDynamicRawMaterial.addView(addMoreRawMeterielView);
            final int position = llDynamicRawMaterial.indexOfChild(addMoreRawMeterielView);
            imgEditView.setTag(position);

            //----(use position for delete view)-----//
            imgEditView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    getPositionRawMaterielView = (Integer) v.getTag();
                    openRawmaterielEditDialog(getPositionRawMaterielView);

                }
            });

            etQuantity.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    etUnitRate.setText("");
                    etTotalValues.setText("");
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            etUnitRate.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {


                    try {
                        Double amount = (Integer.parseInt(etForMonths.getText().toString()) * Integer.valueOf(etQuantity.getText().toString()) * Double.valueOf(etUnitRate.getText().toString()));

                        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                        String firstNumberAsString = decimalFormat.format(amount);
                        etTotalValues.setText(firstNumberAsString);

                    } catch (NumberFormatException e) {
                        etTotalValues.setText("");
                    }

                }
            });

            etForMonths.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {

                    etUnitRate.setText("");
                    etTotalValues.setText("");
                    etQuantity.setText("");

                }
            });


        }
    }

    private void tvSaveRawMaterialDataInToDatabase(boolean isFromAddMoreButton) {

        if (step3_4_RawMeterielAddMoreModelList.size() != 0) {

            //check if data already saved in database
            if (etItem.getText().toString().equals(step3_4_RawMeterielAddMoreModelList.get(step3_4_RawMeterielAddMoreModelList.size() - 1).getItem())) {
                displayRawMaterirelDataData(false, isFromAddMoreButton);

                //Open Warning messege dialog if Cost of goods and Raw materiels data not matching
                checkCostOfGoodsAndRawmateriel(isFromAddMoreButton);
            } else {

                if (checkValidationforRawMateriel()) {
                    insertRawMeterirlDataIntoDatabase(isFromAddMoreButton);

                }
            }
        } else {
            if (checkValidationforRawMateriel()) {
                insertRawMeterirlDataIntoDatabase(isFromAddMoreButton);
            }
        }

    }

    private boolean checkCostOfGoodsAndRawmateriel(boolean isFromAddMoreButton) {

        Double totalCostOfGoods = 0.0;
        Double totalRawMaterielCost = 0.0;


        mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)));
        mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)));

        for (int i = 0; i < mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
            totalRawMaterielCost = totalRawMaterielCost + mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getTotalValue();
        }


        for (int i = 0; i < mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).size(); i++) {
            totalCostOfGoods = totalCostOfGoods + mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID))).get(i).getTotalCostOfGoods();
        }

        if (totalCostOfGoods.intValue() != totalRawMaterielCost.intValue()) {
            if (!isFromAddMoreButton) {
                openWarningCostOfGoodsAndRawMaterielNotMatching();
            }
        }


        return false;
    }

    private void openWarningCostOfGoodsAndRawMaterielNotMatching() {

        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.warning_dailog_raw_materials_cost_not_match, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();
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

    private boolean checkValidationforRawMateriel() {
        if (etItem.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterItem));
            etItem.requestFocus();
            return false;
        } else if (etForMonths.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterMonths));
            etForMonths.requestFocus();
            return false;
        } else if (etQuantity.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterQuantity));
            etQuantity.requestFocus();
            return false;
        } else if (etUnitRate.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterRate));
            etUnitRate.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    private void insertRawMeterirlDataIntoDatabase(boolean isFromAddMoreButton) {

        //Insert Raw materiels data in to database
        mDatabaseHelper.insertBusinessPlan3_4_RawMeterielAddMoreModelList(
                System.currentTimeMillis(),
                Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                etItem.getText().toString(),
                Long.valueOf(etForMonths.getText().toString()),
                Double.valueOf(etQuantity.getText().toString()),
                Double.valueOf(etUnitRate.getText().toString()),
                Double.valueOf(etTotalValues.getText().toString().replace(",", "")),
                0);

        // reset dynamic view
        displayRawMaterirelDataData(false, isFromAddMoreButton);

        //Open Warning messege dialog if Cost of goods and Raw materiels data not matching
        checkCostOfGoodsAndRawmateriel(isFromAddMoreButton);

    }

    private void openRawmaterielEditDialog(final Integer PositionRawMaterielView) {
        final android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.box_raw_material_new_edit, null);
        dialogBuilder.setView(dialogView);

        final android.app.AlertDialog mAlertDialog = dialogBuilder.create();


        final TextView tvNoOfItemsEditView = (TextView) dialogView.findViewById(R.id.tvNoOfItemsEditView);
        final TextView txtTitleItemEditView = (TextView) dialogView.findViewById(R.id.txtTitleItemEditView);
        final TextView txtTitleNoOfTimesEditView = (TextView) dialogView.findViewById(R.id.txtTitleNoOfTimesEditView);
        final TextView txtTitleQuantityEditView = (TextView) dialogView.findViewById(R.id.txtTitleQuantityEditView);
        final TextView txtTitleUnitRateEditView = (TextView) dialogView.findViewById(R.id.txtTitleUnitRateEditView);
        final TextView txtTitleTotalValuesEditView = (TextView) dialogView.findViewById(R.id.txtTitleTotalValuesEditView);


        final EditText etItemEditView = (EditText) dialogView.findViewById(R.id.etItemEditView);
        final EditText etForMonthsEditView = (EditText) dialogView.findViewById(R.id.etForMonthsEditView);
        final EditText etQuantityEditView = (EditText) dialogView.findViewById(R.id.etQuantityEditView);
        final EditText etUnitRateEditView = (EditText) dialogView.findViewById(R.id.etUnitRateEditView);
        final EditText etTotalValuesEditView = (EditText) dialogView.findViewById(R.id.etTotalValuesEditView);
        final TextView txtCancelEditView = (TextView) dialogView.findViewById(R.id.txtCancelEditView);
        final TextView txtDeleteEditView = (TextView) dialogView.findViewById(R.id.txtDeleteEditView);
        final TextView txtCanSaveEditView = (TextView) dialogView.findViewById(R.id.txtUpdateEditView);

        //SET SR, NUMBER
        tvNoOfItemsEditView.setText("" + (PositionRawMaterielView + 1));

        //SET MENDETORY DATA
        txtTitleItemEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strItem)));
        txtTitleNoOfTimesEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strNoOfTimesPerYear)));
        txtTitleQuantityEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strQuantity)));
        txtTitleUnitRateEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strUnitRate)));
        txtTitleTotalValuesEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalValues)));

        etForMonthsEditView.setFilters(new InputFilter[]{new InputFilterMinMax(1, 365)});

        Double dblQuantity = Double.valueOf(String.valueOf(step3_4_RawMeterielAddMoreModelList.get(PositionRawMaterielView).getQuantity()));
        Double dblUnitRate = Double.valueOf(String.valueOf(step3_4_RawMeterielAddMoreModelList.get(PositionRawMaterielView).getRate()));
        Double dblTotalValues = step3_4_RawMeterielAddMoreModelList.get(PositionRawMaterielView).getTotalValue();


        etItemEditView.setText("" + step3_4_RawMeterielAddMoreModelList.get(PositionRawMaterielView).getItem());
        etForMonthsEditView.setText("" + step3_4_RawMeterielAddMoreModelList.get(PositionRawMaterielView).getForMonths());
        etQuantityEditView.setText("" + dblQuantity.intValue());
        etUnitRateEditView.setText("" + dblUnitRate);


        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String firstNumberAsString = decimalFormat.format(dblTotalValues);
        etTotalValuesEditView.setText(firstNumberAsString);


        //----(Dismiss popup)-----//
        txtCancelEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });

        //----(Delet selected view from list)-----//
        txtDeleteEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRawmaterielDeleteDialog(PositionRawMaterielView);
                mAlertDialog.dismiss();


            }
        });
        //----(Dismiss popup)-----//
        txtCanSaveEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert furniture data in to database
                if (checkValidationRawMeterielsEditView()) {
                    //Insert furniture data in to database
                    mDatabaseHelper.updateBusinessPlan3_4_RawMeterielAddMoreModelList(
                            step3_4_RawMeterielAddMoreModelList.get(PositionRawMaterielView).getId(),
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                            etItemEditView.getText().toString(),
                            Long.valueOf(etForMonthsEditView.getText().toString()),
                            Double.valueOf(etQuantityEditView.getText().toString()),
                            Double.valueOf(etUnitRateEditView.getText().toString()),
                            Double.valueOf(etTotalValuesEditView.getText().toString().replace(",", "")),
                            0);

                    // reset dynamic view
                    displayRawMaterirelDataData(false, false);
                    mAlertDialog.dismiss();
                }

            }

            private boolean checkValidationRawMeterielsEditView() {
                if (etItemEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterItem));
                    etItemEditView.requestFocus();
                    return false;
                } else if (etForMonthsEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterMonths));
                    etForMonthsEditView.requestFocus();
                    return false;
                } else if (etQuantityEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterQuantity));
                    etQuantityEditView.requestFocus();
                    return false;
                } else if (etUnitRateEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterRate));
                    etUnitRateEditView.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });


        etForMonthsEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                etUnitRateEditView.setText("");
                etTotalValuesEditView.setText("");
                etQuantityEditView.setText("");

            }
        });

        etQuantityEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                etUnitRateEditView.setText("");
                etTotalValuesEditView.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etUnitRateEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    Double amount = (Integer.parseInt(etForMonthsEditView.getText().toString()) * Integer.valueOf(etQuantityEditView.getText().toString()) * Double.valueOf(etUnitRateEditView.getText().toString()));

                    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                    String firstNumberAsString = decimalFormat.format(amount);
                    //etTotalValues.setText(firstNumberAsString);
                    etTotalValuesEditView.setText(firstNumberAsString);

                    //etTotalValuesEditView.setText(String.valueOf(amount));
                } catch (NumberFormatException e) {
                    etTotalValuesEditView.setText("");
                }

            }
        });


        mAlertDialog.show();
    }

    private void openRawmaterielDeleteDialog(final Integer positionRawMeterielView) {

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
                mDatabaseHelper.deleteBusinessPlan3_4_RawMeterielAddMoreModelList(step3_4_RawMeterielAddMoreModelList.get(positionRawMeterielView).getId());
                displayRawMaterirelDataData(true, false);
                mAlertDialog.dismiss();
            }
        });

        mAlertDialog.show();

    }

    private void displayUtilityList() {

        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            step3_5_UtilityModelList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getUtilities();
            //AlertUtils.loge("Lol: " + new Gson().toJson(step3_5_UtilityModelList));

            Double dblAnnualExpenditure_, dblWaterAnnualExpenditure_, dblFuelAnnualExpenditure_, dblAnyOtherAnnualExpenditure_;

            dblAnnualExpenditure_ = step3_5_UtilityModelList.get(0).getAnnualExpenditure();
            dblWaterAnnualExpenditure_ = step3_5_UtilityModelList.get(1).getAnnualExpenditure();
            dblFuelAnnualExpenditure_ = step3_5_UtilityModelList.get(2).getAnnualExpenditure();


            edtAnnualExpenditure.setText("" + dblAnnualExpenditure_.intValue());
            edtRemarks.setText(step3_5_UtilityModelList.get(0).getRemarks());

            edtWaterAnnualExpenditure.setText("" + dblWaterAnnualExpenditure_.intValue());
            edtWaterRemarks.setText(step3_5_UtilityModelList.get(1).getRemarks());

            edtFuelAnnualExpenditure.setText("" + dblFuelAnnualExpenditure_.intValue());
            edtFuelRemarks.setText(step3_5_UtilityModelList.get(2).getRemarks());

            try {
                if (step3_5_UtilityModelList.size() == 4) {
                    dblAnyOtherAnnualExpenditure_ = step3_5_UtilityModelList.get(3).getAnnualExpenditure();
                    edtAnyOtherAnnualExpenditure.setText("" + dblAnyOtherAnnualExpenditure_.intValue());
                    edtAnyOtherRemarks.setText("" + step3_5_UtilityModelList.get(3).getRemarks());
                } else {
                    edtAnyOtherAnnualExpenditure.setText("");
                    edtAnyOtherRemarks.setText("");
                }

            } catch (IndexOutOfBoundsException e) {
                edtAnyOtherAnnualExpenditure.setText("");
                edtAnyOtherRemarks.setText("");
            }

        }
    }

    private void saveUtilityItemsInDatabase() {

        String strPowerExpenditure = edtAnnualExpenditure.getText().toString();
        String strPowerRemarks = edtRemarks.getText().toString();
        String strWaterExpanditure = edtWaterAnnualExpenditure.getText().toString();
        String strWaterRemarks = edtWaterRemarks.getText().toString();
        String strFuelExpanditure = edtFuelAnnualExpenditure.getText().toString();
        String strFuelRemarks = edtFuelRemarks.getText().toString();
        String strAnyOtherExpanditure = edtAnyOtherAnnualExpenditure.getText().toString();
        String strAnyOtherRemarks = edtAnyOtherRemarks.getText().toString();

        if (checkValidationForUtility()) {

            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                mUtilitiesModelArrayList.clear();
                mUtilitiesModelArrayList = new ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean>();

                GetNewBusinessPlanDataModel.DataBean.UtilitiesBean mUtilitiesModelPower = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                //  utilitiesModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mUtilitiesModelPower.setUtilitiesParticularId(1L);
                mUtilitiesModelPower.setAnnualExpenditure(Double.valueOf(strPowerExpenditure));
                mUtilitiesModelPower.setRemarks(strPowerRemarks);
                mUtilitiesModelArrayList.add(mUtilitiesModelPower);

                GetNewBusinessPlanDataModel.DataBean.UtilitiesBean utilitiesModeWater = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                //  utilitiesModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                utilitiesModeWater.setUtilitiesParticularId(2L);
                utilitiesModeWater.setAnnualExpenditure(Double.valueOf(strWaterExpanditure));
                utilitiesModeWater.setRemarks(strWaterRemarks);
                mUtilitiesModelArrayList.add(utilitiesModeWater);

                GetNewBusinessPlanDataModel.DataBean.UtilitiesBean utilitiesModeFuel = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                // utilitiesModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                utilitiesModeFuel.setUtilitiesParticularId(3L);
                utilitiesModeFuel.setAnnualExpenditure(Double.valueOf(strFuelExpanditure));
                utilitiesModeFuel.setRemarks(strFuelRemarks);
                mUtilitiesModelArrayList.add(utilitiesModeFuel);

                if (strAnyOtherExpanditure.length() > 0) {
                    GetNewBusinessPlanDataModel.DataBean.UtilitiesBean utilitiesModeOther = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                    //   utilitiesModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                    utilitiesModeOther.setUtilitiesParticularId(4L);
                    utilitiesModeOther.setAnnualExpenditure(Double.valueOf(strAnyOtherExpanditure));
                    utilitiesModeOther.setRemarks(strAnyOtherRemarks);
                    mUtilitiesModelArrayList.add(utilitiesModeOther);
                }


                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {
                    mDatabaseHelper.insertEntrepreneurBP_3_5_step(
                            new Gson().toJson(mUtilitiesModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                } else {
                    mDatabaseHelper.updateEntrepreneurBP_3_5_step(
                            new Gson().toJson(mUtilitiesModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                }
                //We are using step 3.5 utilities values in WORKING CAPITAL formula so we are calulate once again working capital on save button
                //Calculate Working capital
                calculateWorkingCapital();

                if (llUtilities.getVisibility() == View.VISIBLE) {
                    llUtilities.setVisibility(View.GONE);
                } else {
                    llUtilities.setVisibility(View.VISIBLE);
                }

                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));

            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }


        }

    }

    private boolean checkValidationForUtility() {
        if (edtAnnualExpenditure.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPowerExpanditure));
            edtAnnualExpenditure.requestFocus();
            return false;
        } else if (edtWaterAnnualExpenditure.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterWaterExpanditure));
            edtWaterAnnualExpenditure.requestFocus();
            return false;
        } else if (edtFuelAnnualExpenditure.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFuelExpanditure));
            edtFuelAnnualExpenditure.requestFocus();
            return false;
        } else {
            return true;
        }
    }


    private void displayManPowerList() {

        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            step3_6_ManPowerModelList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getManpowers();

            Double dblSkilledWagesSalaries, dblSkilledAnnualExpenses;
            Double dblSemiSkilledWagesSalaries, dblSemiSkilledAnnualExpenses;
            Double dblUnskilledWagesSalaries, dblUnskilledAnnualExpenses;
            Double dblOfficeStaffWagesSalaries, dblOfficeStaffAnnualExpenses;

            dblSkilledWagesSalaries = step3_6_ManPowerModelList.get(0).getWagesPerMonth();
            dblSkilledAnnualExpenses = step3_6_ManPowerModelList.get(0).getAnnualExpenses();

            dblSemiSkilledWagesSalaries = step3_6_ManPowerModelList.get(1).getWagesPerMonth();
            dblSemiSkilledAnnualExpenses = step3_6_ManPowerModelList.get(1).getAnnualExpenses();

            dblUnskilledWagesSalaries = step3_6_ManPowerModelList.get(2).getWagesPerMonth();
            dblUnskilledAnnualExpenses = step3_6_ManPowerModelList.get(2).getAnnualExpenses();

            dblOfficeStaffWagesSalaries = step3_6_ManPowerModelList.get(3).getWagesPerMonth();
            dblOfficeStaffAnnualExpenses = step3_6_ManPowerModelList.get(3).getAnnualExpenses();

            edtSkilledNo.setText("" + step3_6_ManPowerModelList.get(0).getNumber());
            edtSkilledWagesSalaries.setText("" + dblSkilledWagesSalaries.intValue());
            edtSkilledAnnualExpenses.setText("" + dblSkilledAnnualExpenses.intValue());

            edtSemiSkilledNo.setText("" + step3_6_ManPowerModelList.get(1).getNumber());
            edtSemiSkilledWagesSalaries.setText("" + dblSemiSkilledWagesSalaries.intValue());
            edtSemiSkilledAnnualExpenses.setText("" + dblSemiSkilledAnnualExpenses.intValue());

            edtUnskilledNo.setText("" + step3_6_ManPowerModelList.get(2).getNumber());
            edtUnskilledWagesSalaries.setText("" + dblUnskilledWagesSalaries.intValue());
            edtUnskilledAnnualExpenses.setText("" + dblUnskilledAnnualExpenses.intValue());

            edtOfficeStaffNo.setText("" + step3_6_ManPowerModelList.get(3).getNumber());
            edtOfficeStaffWagesSalaries.setText("" + dblOfficeStaffWagesSalaries.intValue());
            edtOfficeStaffAnnualExpenses.setText("" + dblOfficeStaffAnnualExpenses.intValue());

            try {
                Double dblAnyOther_WagesSalaries, dblAnyOther_AnnualExpenses;
                dblAnyOther_WagesSalaries = step3_6_ManPowerModelList.get(4).getWagesPerMonth();
                dblAnyOther_AnnualExpenses = step3_6_ManPowerModelList.get(4).getAnnualExpenses();

                edtAnyOtherNo.setText("" + step3_6_ManPowerModelList.get(4).getNumber());
                edtAnyOtherWagesSalaries.setText("" + dblAnyOther_WagesSalaries.intValue());
                edtAnyOtherAnnualExpenses.setText("" + dblAnyOther_AnnualExpenses.intValue());

            } catch (IndexOutOfBoundsException e) {

                edtAnyOtherNo.setText("");
                edtAnyOtherWagesSalaries.setText("");
                edtAnyOtherAnnualExpenses.setText("");

            }
        }
    }

    private void saveManPoweDataIntoDatabase() {

        String strSkilledNo = edtSkilledNo.getText().toString();
        String strSkilledSalaries = edtSkilledWagesSalaries.getText().toString();
        String strSkilledAnnualExpens = edtSkilledAnnualExpenses.getText().toString();

        String strSemiSkilledNo = edtSemiSkilledNo.getText().toString();
        String strSemiSkilledSalaries = edtSemiSkilledWagesSalaries.getText().toString();
        String strSemiSkilledAnnualExpens = edtSemiSkilledAnnualExpenses.getText().toString();

        String strUnSkilledNo = edtUnskilledNo.getText().toString();
        String strUnSkilledSalaries = edtUnskilledWagesSalaries.getText().toString();
        String strUnSkilledAnnualExpens = edtUnskilledAnnualExpenses.getText().toString();

        String strOfficeStaffNo = edtOfficeStaffNo.getText().toString();
        String strOfficeStaffSalaries = edtOfficeStaffWagesSalaries.getText().toString();
        String strOfficeStaffAnnualExpens = edtOfficeStaffAnnualExpenses.getText().toString();

        String strAnyOtherNo = edtAnyOtherNo.getText().toString();
        String strAnyOtherSalaries = edtAnyOtherWagesSalaries.getText().toString();
        String strAnyOtherAnnualExpens = edtAnyOtherAnnualExpenses.getText().toString();


        if (checkValidationForManPower()) {

            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                mManPowerModelSaveArrayList.clear();
                mManPowerModelSaveArrayList = new ArrayList<>();

                ManPowerModel manPowerModelSkilled = new ManPowerModel();
                //  manPowerModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                manPowerModelSkilled.setNumber(Long.valueOf(strSkilledNo));
                manPowerModelSkilled.setWagesPerMonth(Double.valueOf(strSkilledSalaries));
                if (!strSkilledAnnualExpens.equals("")) {
                    manPowerModelSkilled.setAnnualExpenses(Double.valueOf(strSkilledAnnualExpens));
                } else {
                    if (edtSkilledWagesSalaries.length() != 0 && edtSkilledNo.length() != 0) {
                        manPowerModelSkilled.setAnnualExpenses(Double.valueOf(12 * Integer.valueOf(edtSkilledWagesSalaries.getText().toString()) * Integer.valueOf(edtSkilledNo.getText().toString())));
                    } else {
                        manPowerModelSkilled.setAnnualExpenses(0.0);
                    }
                }
                manPowerModelSkilled.setManpowerParticularId(1L);
                mManPowerModelSaveArrayList.add(manPowerModelSkilled);

                ManPowerModel manPowerModeSemiSkilled = new ManPowerModel();
                //  manPowerModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                manPowerModeSemiSkilled.setNumber(Long.valueOf(strSemiSkilledNo));
                manPowerModeSemiSkilled.setWagesPerMonth(Double.valueOf(strSemiSkilledSalaries));
                if (!strSemiSkilledAnnualExpens.equals("")) {
                    manPowerModeSemiSkilled.setAnnualExpenses(Double.valueOf(strSemiSkilledAnnualExpens));
                } else {
                    if (edtSemiSkilledWagesSalaries.length() != 0 && edtSemiSkilledNo.length() != 0) {
                        manPowerModeSemiSkilled.setAnnualExpenses(Double.valueOf(12 * Integer.valueOf(edtSemiSkilledWagesSalaries.getText().toString()) * Integer.valueOf(edtSemiSkilledNo.getText().toString())));
                    } else {
                        manPowerModeSemiSkilled.setAnnualExpenses(0.0);
                    }
                }
                manPowerModeSemiSkilled.setManpowerParticularId(2L);
                mManPowerModelSaveArrayList.add(manPowerModeSemiSkilled);

                ManPowerModel manPowerModeUnSkilled = new ManPowerModel();
                // manPowerModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                manPowerModeUnSkilled.setNumber(Long.valueOf(strUnSkilledNo));
                manPowerModeUnSkilled.setWagesPerMonth(Double.valueOf(strUnSkilledSalaries));
                if (!strUnSkilledAnnualExpens.equals("")) {
                    manPowerModeUnSkilled.setAnnualExpenses(Double.valueOf(strUnSkilledAnnualExpens));
                } else {
                    if (edtUnskilledWagesSalaries.length() != 0 && edtUnskilledNo.length() != 0) {
                        manPowerModeUnSkilled.setAnnualExpenses(Double.valueOf(12 * Integer.valueOf(edtUnskilledWagesSalaries.getText().toString()) * Integer.valueOf(edtUnskilledNo.getText().toString())));
                    } else {
                        manPowerModeUnSkilled.setAnnualExpenses(0.0);
                    }
                }
                manPowerModeUnSkilled.setManpowerParticularId(3L);
                mManPowerModelSaveArrayList.add(manPowerModeUnSkilled);

                ManPowerModel manPowerModeWidrawByOwners = new ManPowerModel();
                //   manPowerModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                manPowerModeWidrawByOwners.setNumber(Long.valueOf(strOfficeStaffNo));
                manPowerModeWidrawByOwners.setWagesPerMonth(Double.valueOf(strOfficeStaffSalaries));
                if (!strOfficeStaffAnnualExpens.equals("")) {
                    manPowerModeWidrawByOwners.setAnnualExpenses(Double.valueOf(strOfficeStaffAnnualExpens));
                } else {
                    if (edtOfficeStaffWagesSalaries.length() != 0 && edtOfficeStaffNo.length() != 0) {
                        manPowerModeWidrawByOwners.setAnnualExpenses(Double.valueOf(12 * Integer.valueOf(edtOfficeStaffWagesSalaries.getText().toString()) * Integer.valueOf(edtOfficeStaffNo.getText().toString())));
                    } else {
                        manPowerModeWidrawByOwners.setAnnualExpenses(0.0);
                    }
                }
                manPowerModeWidrawByOwners.setManpowerParticularId(4L);
                mManPowerModelSaveArrayList.add(manPowerModeWidrawByOwners);

                if (strAnyOtherSalaries.length() > 0 && strAnyOtherAnnualExpens.length() > 0) {
                    ManPowerModel manPowerModelAnyOther = new ManPowerModel();
                    // manPowerModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                    manPowerModelAnyOther.setNumber(0L);
                    manPowerModelAnyOther.setWagesPerMonth(Double.valueOf(strAnyOtherSalaries));
                    manPowerModelAnyOther.setAnnualExpenses(Double.valueOf(strAnyOtherAnnualExpens));
                    manPowerModelAnyOther.setManpowerParticularId(5L);
                    mManPowerModelSaveArrayList.add(manPowerModelAnyOther);
                }

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {
                    mDatabaseHelper.insertEntrepreneurBP_3_6_step(
                            new Gson().toJson(mManPowerModelSaveArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                } else {
                    mDatabaseHelper.updateEntrepreneurBP_3_6_step(
                            new Gson().toJson(mManPowerModelSaveArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                }

                //We are using step 3.6 Man power values in WORKING CAPITAL formula so we are calulate once again working capital on save button
                //Calculate Working capital
                calculateWorkingCapital();

                if (llManpower.getVisibility() == View.VISIBLE) {
                    llManpower.setVisibility(View.GONE);
                } else {
                    llManpower.setVisibility(View.VISIBLE);
                }

                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));

            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }

        }
    }

    private boolean checkValidationForManPower() {
        if (edtSkilledNo.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterSkilled));
            edtSkilledNo.requestFocus();
            return false;
        } else if (edtSkilledWagesSalaries.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterSkilledWages));
            edtSkilledWagesSalaries.requestFocus();
            return false;
        } else if (edtSemiSkilledNo.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterSemiSkilledNo));
            edtSemiSkilledNo.requestFocus();
            return false;
        } else if (edtSemiSkilledWagesSalaries.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterSemiSkilledWages));
            edtSemiSkilledWagesSalaries.requestFocus();
            return false;
        } else if (edtUnskilledNo.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterUnSkilledNo));
            edtUnskilledNo.requestFocus();
            return false;
        } else if (edtUnskilledWagesSalaries.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterUnSkilledWages));
            edtUnskilledWagesSalaries.requestFocus();
            return false;
        } else if (edtOfficeStaffNo.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterOfficeStaffNo));
            edtOfficeStaffNo.requestFocus();
            return false;
        } else if (edtOfficeStaffWagesSalaries.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterOfficeStaffWages));
            edtOfficeStaffWagesSalaries.requestFocus();
            return false;
        } else if (edtAnyOtherWagesSalaries.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strErrorEnterAnyOtherValuesInManpowerSalary));
            edtAnyOtherWagesSalaries.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void displayAdministrativeList() {


        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            step3_7_AdmistrativeList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getAdministrativeExpenses();

            Double dblStaAmountInRs, dblStTravelingStaAmountInRs, dblCommunicationStaAmountInRs, dblStEntertainmentStaAmountInRs,
                    dblStInsuranceStaAmountInRs, dblStStRentStaAmountInRs, dblStMiscStaAmountInRs, dblStRepairStaAmountInRs;

            dblStaAmountInRs = step3_7_AdmistrativeList.get(0).getAmount();
            dblStTravelingStaAmountInRs = step3_7_AdmistrativeList.get(1).getAmount();
            dblCommunicationStaAmountInRs = step3_7_AdmistrativeList.get(2).getAmount();
            dblStEntertainmentStaAmountInRs = step3_7_AdmistrativeList.get(3).getAmount();
            dblStInsuranceStaAmountInRs = step3_7_AdmistrativeList.get(4).getAmount();
            dblStStRentStaAmountInRs = step3_7_AdmistrativeList.get(5).getAmount();
            dblStMiscStaAmountInRs = step3_7_AdmistrativeList.get(6).getAmount();
            dblStRepairStaAmountInRs = step3_7_AdmistrativeList.get(7).getAmount();


            edtStaAmountInRs.setText("" + dblStaAmountInRs.intValue());
            edtStRemarks.setText(step3_7_AdmistrativeList.get(0).getRemarks());

            edtStTravelingStaAmountInRs.setText("" + dblStTravelingStaAmountInRs.intValue());
            edtStTravelingStRemarks.setText(step3_7_AdmistrativeList.get(1).getRemarks());

            edtCommunicationStaAmountInRs.setText("" + dblCommunicationStaAmountInRs.intValue());
            edtCommunicationStRemarks.setText(step3_7_AdmistrativeList.get(2).getRemarks());

            edtStEntertainmentStaAmountInRs.setText("" + dblStEntertainmentStaAmountInRs.intValue());
            edtStEntertainmentStRemarks.setText(step3_7_AdmistrativeList.get(3).getRemarks());

            edtStInsuranceStaAmountInRs.setText("" + dblStInsuranceStaAmountInRs.intValue());
            edtStInsuranceStRemarks.setText(step3_7_AdmistrativeList.get(4).getRemarks());


            // edtStStRentStaAmountInRs.setText("" + dblStStRentStaAmountInRs.intValue());
            edtStStRentStRemarks.setText(step3_7_AdmistrativeList.get(5).getRemarks());

            edtStStRepairMeintananceStaAmountInRs.setText("" + dblStRepairStaAmountInRs.intValue());
            edtStStRepairMeintananceStRemarks.setText(step3_7_AdmistrativeList.get(7).getRemarks());

            edtStMiscStaAmountInRs.setText("" + dblStMiscStaAmountInRs.intValue());
            edtStMiscStRemarks.setText(step3_7_AdmistrativeList.get(6).getRemarks());


        }

    }

    private void saveAdministrativeData() {

        String strStationaryAmount = edtStaAmountInRs.getText().toString();
        String strStationaryRemarks = edtStRemarks.getText().toString();

        String strTravellingAmount = edtStTravelingStaAmountInRs.getText().toString();
        String strTravellingRemarks = edtStTravelingStRemarks.getText().toString();

        String strCommunicationAmount = edtCommunicationStaAmountInRs.getText().toString();
        String strCommunicationRemarks = edtCommunicationStRemarks.getText().toString();

        String strEntertainmentAmount = edtStEntertainmentStaAmountInRs.getText().toString();
        String strEntertainmentRemarks = edtStEntertainmentStRemarks.getText().toString();

        String strInsuranceAmount = edtStInsuranceStaAmountInRs.getText().toString();
        String strInsuranceRemarks = edtStInsuranceStRemarks.getText().toString();

        String strRentAmount = edtStStRentStaAmountInRs.getText().toString();
        String strRentRemarks = edtStStRentStRemarks.getText().toString();

        String strRepairAmount = edtStStRepairMeintananceStaAmountInRs.getText().toString();
        String strRepairRemarks = edtStStRepairMeintananceStRemarks.getText().toString();

        String strMiscAmount = edtStMiscStaAmountInRs.getText().toString();
        String strMiscRemarks = edtStMiscStRemarks.getText().toString();

        if (checkValidationForAdministrativeData()) {

            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                mAdministrativeDataList.clear();
                mAdministrativeDataList = new ArrayList<>();

                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelStationary = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                //  administrativeModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelStationary.setAdministrativeExpensesParticularId(1L);
                mAdministrativeModelStationary.setAmount(Double.valueOf(strStationaryAmount));
                mAdministrativeModelStationary.setRemarks(strStationaryRemarks);
                mAdministrativeDataList.add(mAdministrativeModelStationary);

                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelTraveling = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                //  administrativeModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelTraveling.setAdministrativeExpensesParticularId(2L);
                mAdministrativeModelTraveling.setAmount(Double.valueOf(strTravellingAmount));
                mAdministrativeModelTraveling.setRemarks(strTravellingRemarks);
                mAdministrativeDataList.add(mAdministrativeModelTraveling);

                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelCommunication = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                //  administrativeModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelCommunication.setAdministrativeExpensesParticularId(3L);
                mAdministrativeModelCommunication.setAmount(Double.valueOf(strCommunicationAmount));
                mAdministrativeModelCommunication.setRemarks(strCommunicationRemarks);
                mAdministrativeDataList.add(mAdministrativeModelCommunication);

                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelEntertainment = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                //  administrativeModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelEntertainment.setAdministrativeExpensesParticularId(4L);
                mAdministrativeModelEntertainment.setAmount(Double.valueOf(strEntertainmentAmount));
                mAdministrativeModelEntertainment.setRemarks(strEntertainmentRemarks);
                mAdministrativeDataList.add(mAdministrativeModelEntertainment);

                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelInsurance = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                // administrativeModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelInsurance.setAdministrativeExpensesParticularId(5L);
                mAdministrativeModelInsurance.setAmount(Double.valueOf(strInsuranceAmount));
                mAdministrativeModelInsurance.setRemarks(strInsuranceRemarks);
                mAdministrativeDataList.add(mAdministrativeModelInsurance);

                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelRent = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                // administrativeModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelRent.setAdministrativeExpensesParticularId(6L);
                mAdministrativeModelRent.setAmount(Double.valueOf(strRentAmount));
                mAdministrativeModelRent.setRemarks(strRentRemarks);
                mAdministrativeDataList.add(mAdministrativeModelRent);


                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelMisc = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                // administrativeModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelMisc.setAdministrativeExpensesParticularId(7L);
                mAdministrativeModelMisc.setAmount(Double.valueOf(strMiscAmount));
                mAdministrativeModelMisc.setRemarks(strMiscRemarks);
                mAdministrativeDataList.add(mAdministrativeModelMisc);

                // For Repair and Maintenance
                GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelRepair = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                // administrativeModel7.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mAdministrativeModelRepair.setAdministrativeExpensesParticularId(8L);
                mAdministrativeModelRepair.setAmount(Double.valueOf(strRepairAmount));
                mAdministrativeModelRepair.setRemarks(strRepairRemarks);
                mAdministrativeDataList.add(mAdministrativeModelRepair);


                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {
                    mDatabaseHelper.insertEntrepreneurBP_3_7_step(
                            new Gson().toJson(mAdministrativeDataList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                } else {
                    mDatabaseHelper.updateEntrepreneurBP_3_7_step(
                            new Gson().toJson(mAdministrativeDataList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                }

                //We are using step 3.7  Administrative Expenses values in WORKING CAPITAL formula so we are calulate once again working capital on save button
                //Calculate Working capital
                calculateWorkingCapital();

                if (llAdministrativeExpenses.getVisibility() == View.VISIBLE) {
                    llAdministrativeExpenses.setVisibility(View.GONE);
                } else {
                    llAdministrativeExpenses.setVisibility(View.VISIBLE);
                }
                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));

            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }

        }
    }

    private boolean checkValidationForAdministrativeData() {

        if (edtStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterStationaryAmount));
            edtStaAmountInRs.requestFocus();
            return false;
        } else if (edtStTravelingStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterTravellingAmount));
            edtStTravelingStaAmountInRs.requestFocus();
            return false;
        } else if (edtCommunicationStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterCommunicationAmount));
            edtCommunicationStaAmountInRs.requestFocus();
            return false;
        } else if (edtStEntertainmentStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEntertainmentAmount));
            edtStEntertainmentStaAmountInRs.requestFocus();
            return false;
        } else if (edtStInsuranceStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterInsuranceAmount));
            edtStInsuranceStaAmountInRs.requestFocus();
            return false;
        } else if (edtStStRentStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterRentAmount));
            edtStStRentStaAmountInRs.requestFocus();
            return false;
        } else if (edtStStRepairMeintananceStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterRepairMaintenanceAmount));
            edtStStRepairMeintananceStaAmountInRs.requestFocus();
            return false;
        } else if (edtStMiscStaAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterMiscAmount));
            edtStMiscStaAmountInRs.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void displaySellingAndDistributionList() {

        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {

            step3_8_SellignAndDistributionList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getSellingDistributionExpenses();

            Double dblPublicityExpensesAmountInRs, dblTravelingAmountInRs, dblFreightAmountInRs,
                    dblCommissionAmountInRs, dblMiscAmountInRs;


            dblPublicityExpensesAmountInRs = step3_8_SellignAndDistributionList.get(0).getAmount();
            dblFreightAmountInRs = step3_8_SellignAndDistributionList.get(1).getAmount();
            dblCommissionAmountInRs = step3_8_SellignAndDistributionList.get(2).getAmount();
            dblMiscAmountInRs = step3_8_SellignAndDistributionList.get(3).getAmount();


            edtPublicityExpensesAmountInRs.setText("" + dblPublicityExpensesAmountInRs.intValue());
            edtPublicityExpensesRemarks.setText(step3_8_SellignAndDistributionList.get(0).getRemarks());

           /* edtTravelingAmountInRs.setText("" + dblTravelingAmountInRs.intValue());
            edtTravelingRemarks.setText(mSWorkingCapitalModelsList.get(1).getRemarks());*/

            edtFreightAmountInRs.setText("" + dblFreightAmountInRs.intValue());
            edtFreightRemarks.setText(step3_8_SellignAndDistributionList.get(1).getRemarks());

            edtCommissionAmountInRs.setText("" + dblCommissionAmountInRs.intValue());
            edtCommissionRemarks.setText(step3_8_SellignAndDistributionList.get(2).getRemarks());

            edtMiscAmountInRs.setText("" + dblMiscAmountInRs.intValue());
            edtMiscRemarks.setText(step3_8_SellignAndDistributionList.get(3).getRemarks());
        }

    }

    private void saveSellingAndDistributionExpenseData() {

        String strPublicityInRs = edtPublicityExpensesAmountInRs.getText().toString();
        String strPublicityRemarks = edtPublicityExpensesRemarks.getText().toString();

        String strTravellingInRs = edtTravelingAmountInRs.getText().toString();
        String strTravellingRemarks = edtTravelingRemarks.getText().toString();

        String strFreightInRs = edtFreightAmountInRs.getText().toString();
        String strFreightRemarks = edtFreightRemarks.getText().toString();

        String strCommissionInRs = edtCommissionAmountInRs.getText().toString();
        String strCommissionRemarks = edtCommissionRemarks.getText().toString();

        String strMiscInRs = edtMiscAmountInRs.getText().toString();
        String strMiscRemarks = edtMiscRemarks.getText().toString();

        if (checkValidationForSaveSellingAndDistributions()) {

            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                mSellingAndDistributionModelList.clear();
                mSellingAndDistributionModelList = new ArrayList<>();

                GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean mSellingDistributionExpensModelPublicity = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                // sellingDistributionExpensModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mSellingDistributionExpensModelPublicity.setSellingDistributionExpenseParticularId(1L);
                mSellingDistributionExpensModelPublicity.setAmount(Double.valueOf(strPublicityInRs));
                mSellingDistributionExpensModelPublicity.setRemarks(strPublicityRemarks);
                mSellingAndDistributionModelList.add(mSellingDistributionExpensModelPublicity);

               /* SellingDistributionExpensModel mSellingDistributionExpensModelTravelling = new SellingDistributionExpensModel();
                // sellingDistributionExpensModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                mSellingDistributionExpensModelTravelling.setSellingDistributionExpenseParticularId(2L);
                mSellingDistributionExpensModelTravelling.setAmount(Double.valueOf(strTravellingInRs));
                mSellingDistributionExpensModelTravelling.setRemarks(strTravellingRemarks);
                mSellingAndDistributionModelList.add(mSellingDistributionExpensModelTravelling);*/

                GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean mSellingDistributionExpensModelFreight = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                // sellingDistributionExpensModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));

                // 10/10/18 By Nirali....change ID of Freight as per Databse Table Id
                //mSellingDistributionExpensModelFreight.setSellingDistributionExpenseParticularId(2L);
                mSellingDistributionExpensModelFreight.setSellingDistributionExpenseParticularId(3L);
                mSellingDistributionExpensModelFreight.setAmount(Double.valueOf(strFreightInRs));
                mSellingDistributionExpensModelFreight.setRemarks(strFreightRemarks);
                mSellingAndDistributionModelList.add(mSellingDistributionExpensModelFreight);

                GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean mSellingDistributionExpensModelCommission = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                // sellingDistributionExpensModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));

                // 10/10/18 By Nirali....change ID of Freight as per Databse Table Id
                // mSellingDistributionExpensModelCommission.setSellingDistributionExpenseParticularId(3L);
                mSellingDistributionExpensModelCommission.setSellingDistributionExpenseParticularId(4L);
                mSellingDistributionExpensModelCommission.setAmount(Double.valueOf(strCommissionInRs));
                mSellingDistributionExpensModelCommission.setRemarks(strCommissionRemarks);
                mSellingAndDistributionModelList.add(mSellingDistributionExpensModelCommission);


                GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean sellingDistributionExpensModeMisc = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                // sellingDistributionExpensModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                // 10/10/18 By Nirali....change ID of Freight as per Databse Table Id

                //sellingDistributionExpensModeMisc.setSellingDistributionExpenseParticularId(4L);
                sellingDistributionExpensModeMisc.setSellingDistributionExpenseParticularId(5L);
                sellingDistributionExpensModeMisc.setAmount(Double.valueOf(strMiscInRs));
                sellingDistributionExpensModeMisc.setRemarks(strMiscRemarks);
                mSellingAndDistributionModelList.add(sellingDistributionExpensModeMisc);

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {
                    mDatabaseHelper.insertEntrepreneurBP_3_8_step(
                            new Gson().toJson(mSellingAndDistributionModelList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                } else {
                    mDatabaseHelper.updateEntrepreneurBP_3_8_step(
                            new Gson().toJson(mSellingAndDistributionModelList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                }

                //We are using step 3.9 Selling and Distribution values in WORKING CAPITAL formula so we are calulate once again working capital on save button
                //Calculate Working capital
                calculateWorkingCapital();

                if (llSellingDistribution.getVisibility() == View.VISIBLE) {
                    llSellingDistribution.setVisibility(View.GONE);
                } else {
                    llSellingDistribution.setVisibility(View.VISIBLE);
                }
                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));


            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }
        }
    }

    private boolean checkValidationForSaveSellingAndDistributions() {
        if (edtPublicityExpensesAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterPublicityExpressAmount));
            edtPublicityExpensesAmountInRs.requestFocus();
            return false;
        } else if (edtFreightAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFreightAmount));
            edtFreightAmountInRs.requestFocus();
            return false;
        } else if (edtCommissionAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterCommissionAmount));
            edtCommissionAmountInRs.requestFocus();
            return false;
        } else if (edtMiscAmountInRs.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterMiscAmount));
            edtMiscAmountInRs.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void displayWorkingCapitalData() {


        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_9_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            step3_9_WorkingCapitalList = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_9_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getWorkingCapitals();

            Double dblWorkingCapital, dblRawMaterialWCAmount, dblSemiFinishedWCAmount, dblFinishedStockWCAmount, dblSalesOnCreditWCAmount, dblProductionExpensesWCAmount;

            dblRawMaterialWCAmount = step3_9_WorkingCapitalList.get(0).getAmount();
            dblSemiFinishedWCAmount = step3_9_WorkingCapitalList.get(1).getAmount();
            dblFinishedStockWCAmount = step3_9_WorkingCapitalList.get(2).getAmount();
            dblSalesOnCreditWCAmount = step3_9_WorkingCapitalList.get(3).getAmount();
            //dblProductionExpensesWCAmount = mSWorkingCapitalModelsList.get(4).getAmount();


            edtRawMaterialWCDuration.setText("" + step3_9_WorkingCapitalList.get(0).getDuration());
            edtRawMaterialWCQuantity.setText("" + step3_9_WorkingCapitalList.get(0).getQuantity());
            edtRawMaterialRate.setText("" + step3_9_WorkingCapitalList.get(0).getRate());
            edtRawMaterialWCAmount.setText("" + dblRawMaterialWCAmount.intValue());
            edtRawMaterialWCDescription.setText("" + step3_9_WorkingCapitalList.get(0).getRateDescriprion());

            edtSemiFinishedWCDuration.setText("" + step3_9_WorkingCapitalList.get(1).getDuration());
            edtSemiFinishedWCQuantity.setText("" + step3_9_WorkingCapitalList.get(1).getQuantity());
            edtSemiFinishedRate.setText("" + step3_9_WorkingCapitalList.get(1).getRate());
            edtSemiFinishedWCAmount.setText("" + dblSemiFinishedWCAmount.intValue());
            edtSemiFinishedWCDescription.setText("" + step3_9_WorkingCapitalList.get(1).getRateDescriprion());

            edtFinishedStockWCDuration.setText("" + step3_9_WorkingCapitalList.get(2).getDuration());
            edtFinishedStockWCQuantity.setText("" + step3_9_WorkingCapitalList.get(2).getQuantity());
            edtFinishesRate.setText("" + step3_9_WorkingCapitalList.get(2).getRate());
            edtFinishedStockWCAmount.setText("" + dblFinishedStockWCAmount.intValue());
            edtFinishedWCDescription.setText("" + step3_9_WorkingCapitalList.get(2).getRateDescriprion());

            edtSalesOnCreditWCDuration.setText("" + step3_9_WorkingCapitalList.get(3).getDuration());
            edtSalesOnCreditWCQuantity.setText("" + step3_9_WorkingCapitalList.get(3).getQuantity());
            edtSalesOnCreditlRate.setText("" + step3_9_WorkingCapitalList.get(3).getRate());
            edtSalesOnCreditWCAmount.setText("" + dblSalesOnCreditWCAmount.intValue());

        /*    edtProductionExpensesWCDuration.setText("" + mSWorkingCapitalModelsList.get(4).getDuration());
            edtProductionExpensesWCQuantity.setText("" + mSWorkingCapitalModelsList.get(4).getQuantity());
            edtProductionExpensesWCAmount.setText("" + dblProductionExpensesWCAmount.intValue());
*/

            int dblAllCount = Integer.valueOf(edtRawMaterialWCAmount.getText().toString())
                    + Integer.valueOf(edtSemiFinishedWCAmount.getText().toString())
                    + Integer.valueOf(edtFinishedStockWCAmount.getText().toString())
                    + Integer.valueOf(edtSalesOnCreditWCAmount.getText().toString());

            Long dblWorkingCapitalPeriod = (step3_9_WorkingCapitalList.get(0).getDuration() +
                    step3_9_WorkingCapitalList.get(1).getDuration() +
                    step3_9_WorkingCapitalList.get(2).getDuration() +
                    step3_9_WorkingCapitalList.get(3).getDuration());

            Double A, B;
            Double C = 0.0;
            Long finalWorkingCapital = 0L;


            if (dblRawMaterialWCAmount == 0 || step3_9_WorkingCapitalList.get(0).getDuration() == 0 || dblWorkingCapitalPeriod == 0) {
                A = 0.0;
            } else {
                A = (dblRawMaterialWCAmount / step3_9_WorkingCapitalList.get(0).getDuration()) * dblWorkingCapitalPeriod;
            }


            if (dblSalesOnCreditWCAmount == 0 || step3_9_WorkingCapitalList.get(3).getDuration() == 0 || dblWorkingCapitalPeriod == 0) {
                B = 0.0;
            } else {
                B = (dblSalesOnCreditWCAmount / step3_9_WorkingCapitalList.get(3).getDuration()) * dblWorkingCapitalPeriod;
            }

            Double dblUtilities = 0.0;
            Double dblManPower = 0.0;
            Double dblAdministrative = 0.0;
            Double dblDistribution = 0.0;
            Double dblFinalExpense = 0.0;

            //Calculate 3.5 step(Utilities)
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> utilitiesModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getUtilities();
                for (int i = 0; i < utilitiesModels.size(); i++) {
                    dblUtilities = dblUtilities + utilitiesModels.get(i).getAnnualExpenditure();
                }

            }

            //Calculate 3.6 step(Man Power)
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean> manPowerModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getManpowers();
                for (int i = 0; i < manPowerModels.size(); i++) {
                    dblManPower = dblManPower + manPowerModels.get(i).getAnnualExpenses();
                }

            }

            //Calculate 3.7 step(Administrative Expenses)
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> administrativeModels = new ArrayList<>();
                administrativeModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getAdministrativeExpenses();
                for (int i = 0; i < administrativeModels.size(); i++) {
                    dblAdministrative = dblAdministrative + administrativeModels.get(i).getAmount();
                }

            }


            //Calculate 3.8 step(Selling and Distribution)
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> sellingDistributionExpensModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getSellingDistributionExpenses();
                for (int i = 0; i < sellingDistributionExpensModels.size(); i++) {
                    dblDistribution = dblDistribution + sellingDistributionExpensModels.get(i).getAmount();
                }

            }

            //Changed by ketan 15/05/02018
            dblFinalExpense = (dblUtilities + dblManPower + dblAdministrative + dblDistribution) / 12;


            //Calculate working capital period
            //(dblFinalExpense/30)*dblWorkingCapitalPeriod
            dblWorkingCapital = dblRawMaterialWCAmount + dblSemiFinishedWCAmount + dblFinishedStockWCAmount + dblSalesOnCreditWCAmount;

            C = (dblFinalExpense + dblWorkingCapital);
            /*edtWCTotalWorkingCapitalNeeded.setText("" + (A + B + C));
            edtCostWorkingCapital.setText("" + (A + B + C));*/

            /*AlertUtils.loge("WWWWorkingCapital_UTILITIES  : " + dblUtilities);
            AlertUtils.loge("WWWWorkingCapital_MANPOWER  : " + dblManPower);
            AlertUtils.loge("WWWWorkingCapital_ADMINISTRATIVE  : " + dblAdministrative);
            AlertUtils.loge("WWWWorkingCapital_DISTRIBUTION  : " + dblDistribution);
            AlertUtils.loge("WWWWorkingCapital_WORKING_CAPITAL  : " + dblWorkingCapital);*/

            edtWCTotalWorkingCapitalNeeded.setText("" + C);
            edtCostWorkingCapital.setText("" + C);

            //Update working capital for further use.
            mSessionManager.updatePreferenceString(Constants.TOTAL_WORKING_CAPITAL, "" + edtWCTotalWorkingCapitalNeeded.getText().toString());

           /* edtWCTotalWorkingCapitalNeeded.setText("" + dblAllCount);
            edtCostWorkingCapital.setText("" + dblAllCount);*/

        }

    }

    private void saveWorkingCapitalData() {

        String strRawMaterialDuration = edtRawMaterialWCDuration.getText().toString();
        String strRawMaterialQuantity = edtRawMaterialWCQuantity.getText().toString();
        String strRawMaterialRate = edtRawMaterialRate.getText().toString();
        String strRawMaterialAmount = edtRawMaterialWCAmount.getText().toString();
        String strRawMaterialDescription = edtRawMaterialWCDescription.getText().toString();

        String strSemiFinishedDuration = edtSemiFinishedWCDuration.getText().toString();
        String strSemiFinishedQuantity = edtSemiFinishedWCQuantity.getText().toString();
        String strSemiFinishedRate = edtSemiFinishedRate.getText().toString();
        String strSemiFinishedAmount = edtSemiFinishedWCAmount.getText().toString();
        String strSemiFinishedDescription = edtSemiFinishedWCDescription.getText().toString();

        String strFinishedStockDuration = edtFinishedStockWCDuration.getText().toString();
        String strFinishedStockQuantity = edtFinishedStockWCQuantity.getText().toString();
        String strFinishedStockRate = edtFinishesRate.getText().toString();
        String strFinishedStockAmount = edtFinishedStockWCAmount.getText().toString();
        String strFinishedDescription = edtFinishedWCDescription.getText().toString();

        String strSalesOnCreditDuration = edtSalesOnCreditWCDuration.getText().toString();
        String strSalesOnCreditQuantity = edtSalesOnCreditWCQuantity.getText().toString();
        String strSalesOnCreditRate = edtSalesOnCreditlRate.getText().toString();
        String strSalesOnCreditAmount = edtSalesOnCreditWCAmount.getText().toString();


        if (checkValidationWorkingCapital()) {

            if (mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID).length() > 0) {

                mWorkingCapitalModelsList.clear();
                mWorkingCapitalModelsList = new ArrayList<>();

                GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                //workingCapitalModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                workingCapitalModel.setDuration(Long.valueOf(strRawMaterialDuration));
                workingCapitalModel.setQuantity(Long.valueOf(strRawMaterialQuantity));
                workingCapitalModel.setRate(Double.valueOf(strRawMaterialRate));
                workingCapitalModel.setAmount(Double.valueOf(strRawMaterialAmount));
                workingCapitalModel.setRateDescriprion(strRawMaterialDescription);
                workingCapitalModel.setWorkingCapitalParticularId(1L);
                mWorkingCapitalModelsList.add(workingCapitalModel);

                GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel1 = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                // workingCapitalModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                workingCapitalModel1.setDuration(Long.valueOf(strSemiFinishedDuration));
                workingCapitalModel1.setQuantity(Long.valueOf(strSemiFinishedQuantity));
                workingCapitalModel1.setRate(Double.valueOf(strSemiFinishedRate));
                workingCapitalModel1.setAmount(Double.valueOf(strSemiFinishedAmount));
                workingCapitalModel1.setRateDescriprion(strSemiFinishedDescription);
                workingCapitalModel1.setWorkingCapitalParticularId(2L);
                mWorkingCapitalModelsList.add(workingCapitalModel1);

                GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel2 = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                // workingCapitalModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                workingCapitalModel2.setDuration(Long.valueOf(strFinishedStockDuration));
                workingCapitalModel2.setQuantity(Long.valueOf(strFinishedStockQuantity));
                workingCapitalModel2.setRate(Double.valueOf(strFinishedStockRate));
                workingCapitalModel2.setAmount(Double.valueOf(strFinishedStockAmount));
                workingCapitalModel2.setRateDescriprion(strFinishedDescription);
                workingCapitalModel2.setWorkingCapitalParticularId(3L);
                mWorkingCapitalModelsList.add(workingCapitalModel2);

                GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel3 = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                //workingCapitalModel.setBusinessPlanId(Long.valueOf(sessionManager.getBusinessPlanId(getActivity())));
                workingCapitalModel3.setDuration(Long.valueOf(strSalesOnCreditDuration));
                workingCapitalModel3.setQuantity(Long.valueOf(strSalesOnCreditQuantity));
                workingCapitalModel3.setRate(Double.valueOf(strSalesOnCreditRate));
                workingCapitalModel3.setAmount(Double.valueOf(strSalesOnCreditAmount));
                workingCapitalModel3.setWorkingCapitalParticularId(4L);
                mWorkingCapitalModelsList.add(workingCapitalModel3);

                Double totalCostOfWorkingCapital = Double.valueOf(strRawMaterialAmount) +
                        Double.valueOf(strSemiFinishedAmount)
                        + Double.valueOf(strFinishedStockAmount) + Double.valueOf(strSalesOnCreditAmount);
                edtCostWorkingCapital.setText(String.valueOf(totalCostOfWorkingCapital.intValue()));

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_9_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() == 0) {
                    mDatabaseHelper.insertEntrepreneurBP_3_9_step(
                            new Gson().toJson(mWorkingCapitalModelsList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                } else {
                    mDatabaseHelper.updateEntrepreneurBP_3_9_step(
                            new Gson().toJson(mWorkingCapitalModelsList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
                    );
                }


                if (llWorkingCapital.getVisibility() == View.VISIBLE) {
                    llWorkingCapital.setVisibility(View.GONE);
                } else {
                    llWorkingCapital.setVisibility(View.VISIBLE);
                }
                CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));

            } else {
                CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strWarningPleaseCompleteSteps));
            }
        }
    }

    private boolean checkValidationWorkingCapital() {

        if (edtRawMaterialWCDuration.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterRawMaterialDuration));
            edtRawMaterialWCDuration.requestFocus();
            return false;
        } else if (edtRawMaterialWCQuantity.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterRawMaterialQuantity));
            edtRawMaterialWCQuantity.requestFocus();
            return false;
        } else if (edtRawMaterialRate.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterRawMaterialRate));
            edtRawMaterialRate.requestFocus();
            return false;
        } else if (edtRawMaterialWCAmount.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterRawMaterialAmount));
            edtRawMaterialWCAmount.requestFocus();
            return false;
        } else if (edtSemiFinishedWCDuration.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterSemiFinishedDuration));
            edtSemiFinishedWCDuration.requestFocus();
            return false;
        } else if (edtSemiFinishedWCQuantity.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterSemiFinishedQuantity));
            edtSemiFinishedWCQuantity.requestFocus();
            return false;
        } else if (edtSemiFinishedRate.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterSemiFinishedRate));
            edtSemiFinishedRate.requestFocus();
            return false;
        } else if (edtSemiFinishedWCAmount.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterSemiFinishedAmount));
            edtSemiFinishedWCAmount.requestFocus();
            return false;
        } else if (edtFinishedStockWCDuration.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedStockDuration));
            edtFinishedStockWCDuration.requestFocus();
            return false;
        } else if (edtFinishedStockWCDuration.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedStockQuantity));
            edtFinishedStockWCDuration.requestFocus();
            return false;
        } else if (edtFinishesRate.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedStockRate));
            edtFinishesRate.requestFocus();
            return false;
        } else if (edtFinishedStockWCAmount.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedStockAmount));
            edtFinishedStockWCAmount.requestFocus();
            return false;
        } else if (edtSalesOnCreditWCDuration.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedSalesDuration));
            edtSalesOnCreditWCDuration.requestFocus();
            return false;
        } else if (edtSalesOnCreditWCQuantity.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedSalesQuantity));
            edtSalesOnCreditWCQuantity.requestFocus();
            return false;
        } else if (edtSalesOnCreditlRate.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedSalesRate));
            edtSalesOnCreditlRate.requestFocus();
            return false;
        } else if (edtSalesOnCreditWCAmount.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterFinishedSalesAmount));
            edtSalesOnCreditWCAmount.requestFocus();
            return false;
        } else {
            return true;
        }
    }


    private void calculateWorkingCapital() {

        Double dblRawmaterialDuration = 0.0, dblSemiFurnishedDuration = 0.0, dblFinishesDuration = 0.0, dbSaleOnCreditDuration = 0.0;
        Double dblRawmaterialAmount = 0.0, dblSemiFurnishedAmount = 0.0, dblFinishesAmount = 0.0, dbSaleOnCreditAmount = 0.0;


        if (!edtRawMaterialWCDuration.getText().toString().equals("")) {
            dblRawmaterialDuration = Double.valueOf(edtRawMaterialWCDuration.getText().toString());
        }


        if (!edtSemiFinishedWCDuration.getText().toString().equals("")) {
            dblSemiFurnishedDuration = Double.valueOf(edtSemiFinishedWCDuration.getText().toString());
        }


        if (!edtFinishedStockWCDuration.getText().toString().equals("")) {
            dblFinishesDuration = Double.valueOf(edtFinishedStockWCDuration.getText().toString());
        }

        if (!edtSalesOnCreditWCDuration.getText().toString().equals("")) {
            dbSaleOnCreditDuration = Double.valueOf(edtSalesOnCreditWCDuration.getText().toString());
        }

        //Rawmaterial Amount
        if (!edtRawMaterialWCAmount.getText().toString().equals("")) {
            dblRawmaterialAmount = Double.valueOf(edtRawMaterialWCAmount.getText().toString());
        }

        //Semifurnished amount
        if (!edtSemiFinishedWCAmount.getText().toString().equals("")) {
            dblSemiFurnishedAmount = Double.valueOf(edtSemiFinishedWCAmount.getText().toString());
        }
        //fnished amount
        if (!edtFinishedStockWCAmount.getText().toString().equals("")) {
            dblFinishesAmount = Double.valueOf(edtFinishedStockWCAmount.getText().toString());
        }
        //Sale on Credit amount
        if (!edtSalesOnCreditWCAmount.getText().toString().equals("")) {
            dbSaleOnCreditAmount = Double.valueOf(edtSalesOnCreditWCAmount.getText().toString());
        }


        Double totalWorkingCapitalPeriod = (dblRawmaterialDuration + dblSemiFurnishedDuration + dblFinishesDuration + dbSaleOnCreditDuration);

        Double A = 0.0, B = 0.0;
        if (edtRawMaterialWCAmount.getText().toString().equals("0") || edtRawMaterialWCAmount.getText().toString().equals("") || edtRawMaterialWCDuration.getText().toString().equals("0") || edtRawMaterialWCDuration.getText().toString().equals("")) {
            A = 0.0;
        } else {
            A = (Double.valueOf(edtRawMaterialWCAmount.getText().toString()) / Double.valueOf(edtRawMaterialWCDuration.getText().toString()) * totalWorkingCapitalPeriod);
        }

        if (edtSalesOnCreditWCAmount.getText().toString().equals("") || edtSalesOnCreditWCAmount.getText().toString().equals("0") || edtSalesOnCreditWCDuration.getText().toString().equals("0") || edtSalesOnCreditWCDuration.getText().toString().equals("")) {
            B = 0.0;
        } else {
            B = (Double.valueOf(edtSalesOnCreditWCAmount.getText().toString()) / Double.valueOf(edtSalesOnCreditWCDuration.getText().toString()) * totalWorkingCapitalPeriod);
        }

        Double C = 0.0;
        Double dblUtilities = 0.0;
        Double dblManPower = 0.0;
        Double dblAdministrative = 0.0;
        Double dblDistribution = 0.0;
        Double dblFinalExpense = 0.0;


        //Calculate 3.5 step(Utilities)
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> utilitiesModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getUtilities();
            for (int i = 0; i < utilitiesModels.size(); i++) {
                dblUtilities = dblUtilities + utilitiesModels.get(i).getAnnualExpenditure();
            }

        }


        //Calculate 3.6 step(Man Power)
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean> manPowerModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getManpowers();
            for (int i = 0; i < manPowerModels.size(); i++) {
                dblManPower = dblManPower + manPowerModels.get(i).getAnnualExpenses();
                //AlertUtils.loge("ANNUAL_EXPENSE" + manPowerModels.get(i).getAnnualExpenses());
            }

        }

        //Calculate 3.7 step(Administrative Expenses)
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> administrativeModels = new ArrayList<>();
            administrativeModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getAdministrativeExpenses();
            for (int i = 0; i < administrativeModels.size(); i++) {
                dblAdministrative = dblAdministrative + administrativeModels.get(i).getAmount();
            }

        }


        //Calculate 3.8 step(Selling and Distribution)
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> sellingDistributionExpensModels = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() - 1).getSellingDistributionExpenses();
            for (int i = 0; i < sellingDistributionExpensModels.size(); i++) {
                dblDistribution = dblDistribution + sellingDistributionExpensModels.get(i).getAmount();
            }

        }


        dblFinalExpense = (dblUtilities + dblManPower + dblAdministrative + dblDistribution) / 12;

        Double dblWorkingCapital = dblRawmaterialAmount + dblSemiFurnishedAmount + dblFinishesAmount + dbSaleOnCreditAmount;

        // AlertUtils.loge("WWWWorkingCapital_UTILITIES  : " + dblUtilities);
        //AlertUtils.loge("WWWWorkingCapital_MANPOWER  : " + dblManPower);
        // AlertUtils.loge("WWWWorkingCapital_ADMINISTRATIVE  : " + dblAdministrative);
        // AlertUtils.loge("WWWWorkingCapital_DISTRIBUTION  : " + dblDistribution);
        //AlertUtils.loge("WWWWorkingCapital_WORKING_CAPITAL  : " + dblWorkingCapital);


        //WORKING CAPITAL FORMULA
        //ALL EXPENSES (A)= 3.5+3.6+3.7+3.8
        //X+Y+Z+W (B) =dblRawmaterialAmount+dblSemiFurnishedAmount+dblFinishesAmount+dbSaleOnCreditAmount
        //WC (C)=(A+B)


        //Calculate working capital period
        //(dblFinalExpense/30)*dblWorkingCapitalPeriod
        C = (dblFinalExpense + dblWorkingCapital);

        // edtWCTotalWorkingCapitalNeeded.setText("" + dblAllCount);
        edtWCTotalWorkingCapitalNeeded.setText(" " + C);
        mSessionManager.updatePreferenceString(Constants.TOTAL_WORKING_CAPITAL, "" + edtWCTotalWorkingCapitalNeeded.getText().toString());

    }

    private void calculateALlEXpenses() {

        Double prOperative = 0.0;
        Double landsAndBuilding = 0.0;
        Double dblMachinery = 0.0;
        Double dblFurniture = 0.0;
        Double dblWorkingCapital = 0.0;
        Double dblTotalProjectCost = 0.0;

        if (!edtCostPreOperative.getText().toString().isEmpty()) {
            prOperative = Double.valueOf(edtCostPreOperative.getText().toString());
        }

        if (!edtCostLandBuilding.getText().toString().isEmpty()) {
            landsAndBuilding = Double.valueOf(edtCostLandBuilding.getText().toString());
        }
        if (!edtWCTotalWorkingCapitalNeeded.getText().toString().isEmpty()) {
            dblWorkingCapital = Double.valueOf(edtWCTotalWorkingCapitalNeeded.getText().toString());
        }


        if (step3_2_GetMachineryAndEquipmentList.size() != 0) {
            for (int i = 0; i < step3_2_GetMachineryAndEquipmentList.size(); i++) {
                dblMachinery = (dblMachinery + step3_2_GetMachineryAndEquipmentList.get(i).getAmount());
            }
        }

        if (step3_3_GetFurnitureDataList.size() != 0) {
            for (int j = 0; j < step3_3_GetFurnitureDataList.size(); j++) {
                dblFurniture = (dblFurniture + step3_3_GetFurnitureDataList.get(j).getAmount());
            }
        }

        edtCostMachinary.setText("" + dblMachinery.intValue());
        edtCostEquipment.setText("" + dblFurniture.intValue());
        edtCostWorkingCapital.setText("" + dblWorkingCapital.intValue());

        dblTotalProjectCost = (prOperative + landsAndBuilding + dblMachinery + dblFurniture + dblWorkingCapital);
        
       /* AlertUtils.loge("111 : " + prOperative);
        AlertUtils.loge("222 : " + landsAndBuilding);
        AlertUtils.loge("333 : " + dblMachinery);
        AlertUtils.loge("444 : " + dblFurniture);
        AlertUtils.loge("555 : " + dblWorkingCapital);*/

        edtTotalProjectCost.setText("" + dblTotalProjectCost.intValue());

        mDatabaseHelper.insertEntrepreneurBP_3_10_step(
                dblTotalProjectCost,//1
                Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))//3
        );

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        if (isFromPlsntAndMachineryEditview) {
            edtPurchaseDateManchineryEditview.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            isFromPlsntAndMachineryEditview = false;
        } else if (isFromFurnitureView) {
            etPurchaseDateFurniture.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            isFromFurnitureView = false;
        } else if (isFromFurnitureEditView) {
            etPurchaseDateFurnitureEditView.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            isFromFurnitureEditView = false;
        } else {
            edtPurchaseDateManchinery.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

        }

    }
}

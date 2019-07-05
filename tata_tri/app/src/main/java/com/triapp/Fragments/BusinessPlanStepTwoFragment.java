package com.triapp.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
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
import com.triapp.Adapter.ModelBusinessPlanListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.InputFilterMinMax;
import com.triapp.CommonClasse.InputFilterditTextName;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.GetNewBusinessPlanDataModel;
import com.triapp.Models.LandBuildingModel;
import com.triapp.Models.ManPowerModel;
import com.triapp.Models.MeansOfFinanceModel;
import com.triapp.Models.SalesRealisationModel;
import com.triapp.Models.SelectedParticularsModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class BusinessPlanStepTwoFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "BusinessPlanStepTwoFragment";

    private static final String SECTION_NUMBER = "sectionNumber";
    private static final String ENTERPRENUER_ID = "enterprenuerID";


    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtSaveOtherIncome, txtTitleOtherIncome, txtSaveProductionAndRevenuePlanning, txtAddMoreProductionAndRevenuePlanning, txtProductionAndRevenuePlanning;
    private EditText edtOtherAmount, edtOtherIncomeDescription;
    private LinearLayout linearProductionAndRevenuePlanningButtons, linearOtherIncome, linearDynamicProductionAndRevenuePlanning, linearProductionAndRevenuePlanning;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<GetNewBusinessPlanDataModel.DataBean.ProductionAndRevenuesBean> productionDetailsModelsList;
    private View addMoreViews;
    private TextView txtTitleTotalCostOfGoods, txtTitleCostPrice, txtTitleAmountPriceRevenue, txtTitleSalePriceRevenue, txtTitleTotalProduction60Per, txtTitleWorkingDays60Per, txtTitleUtilization, txtTitleTotalProduction, txtTitlePerDurationProductionOrSale, txtTtleWorkingDuration, txtTitleProductItems, txtNoOfProduction;
    private EditText edtTotalCostOfGoods, edtCostPrice, edtSaleInPercentage, edtEnterWorkingDays, edtAmaountPriceRevenue, edtSalePriceRevenue, edtTotalProduction60Per, edtWorkingDays60Per, edtTotalProduction, edtWorkingDays, edtProduction;
    private RadioGroup rgHowWay;
    private RadioButton rdbtnday12, rdbtnday52, rdbtnday300;
    private ImageView imgEditView;
    private boolean isBusinessPlanSubmitted = false;
    private String workingUnits = "300", workingUnitsType = Constants.COMMON_DAYS;
    private Double dblSalePriceRevenue, dblTotalProductionUnites, dblworkingDays, dbltotalCostOfGoods, dblAmonutPriceRevenue, dblTotalUtilizationProduction, dblPerDatWeekUtilizationProduction, dblTotalProduction, dblTotalAmount;
    private int intPosition = 0;
    private ArrayList<SalesRealisationModel> businessPlanStep2_1_data = new ArrayList<>();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public BusinessPlanStepTwoFragment() {


    }

    public static BusinessPlanStepTwoFragment newInstance(int sectionNumber, String strEnterprenuerID) {
        BusinessPlanStepTwoFragment fragment = new BusinessPlanStepTwoFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        args.putString(ENTERPRENUER_ID, strEnterprenuerID);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.business_plan_step_two_fragment, container, false);

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


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtProductionAndRevenuePlanning = (TextView) mView.findViewById(R.id.txtProductionAndRevenuePlanning);
        txtAddMoreProductionAndRevenuePlanning = (TextView) mView.findViewById(R.id.txtAddMoreProductionAndRevenuePlanning);
        txtSaveProductionAndRevenuePlanning = (TextView) mView.findViewById(R.id.txtSaveProductionAndRevenuePlanning);
        txtTitleOtherIncome = (TextView) mView.findViewById(R.id.txtTitleOtherIncome);
        txtSaveOtherIncome = (TextView) mView.findViewById(R.id.txtSaveOtherIncome);

        edtOtherIncomeDescription = (EditText) mView.findViewById(R.id.edtOtherIncomeDescription);
        edtOtherAmount = (EditText) mView.findViewById(R.id.edtOtherAmount);

        linearProductionAndRevenuePlanning = (LinearLayout) mView.findViewById(R.id.linearProductionAndRevenuePlanning);
        linearDynamicProductionAndRevenuePlanning = (LinearLayout) mView.findViewById(R.id.linearDynamicProductionAndRevenuePlanning);
        linearProductionAndRevenuePlanningButtons = (LinearLayout) mView.findViewById(R.id.linearProductionAndRevenuePlanningButtons);
        linearOtherIncome = (LinearLayout) mView.findViewById(R.id.linearOtherIncome);

        //CHECK IF BUSINESS PLAN IS ALREADY SUBMITTED
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getIsBusinessPlanSubmited() == 1) {
                isBusinessPlanSubmitted = true;
                makeViewUnEditable();
            }
        }

        //SET STEP 2.0 DATA FROM LOCAL DATABSE
        setProductionAndRevenueview(false, false);

        //SET STEP 2.1 DATA FROM LOCAL DATABSE
        setOtherIncomeData();

        //SET SCREEN DATA
        //new SetScreenData().execute();


    }


    private void setOnClicks() {

        txtProductionAndRevenuePlanning.setOnClickListener(this);
        txtTitleOtherIncome.setOnClickListener(this);
        txtAddMoreProductionAndRevenuePlanning.setOnClickListener(this);
        txtSaveProductionAndRevenuePlanning.setOnClickListener(this);
        txtSaveOtherIncome.setOnClickListener(this);

    }

    private void makeViewUnEditable() {

        txtAddMoreProductionAndRevenuePlanning.setVisibility(View.GONE);
        txtSaveProductionAndRevenuePlanning.setVisibility(View.GONE);
        txtSaveOtherIncome.setVisibility(View.GONE);
        edtOtherIncomeDescription.setFocusableInTouchMode(false);
        edtOtherAmount.setFocusableInTouchMode(false);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtProductionAndRevenuePlanning:

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    //HIDE SHOW LAYOUT AS PER OPEN CLOSE VIEW
                    if (linearProductionAndRevenuePlanning.getVisibility() == View.VISIBLE) {
                        linearProductionAndRevenuePlanning.setVisibility(View.GONE);
                    } else {
                        linearProductionAndRevenuePlanning.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(mContext, mContext.getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }

                break;
            case R.id.txtTitleOtherIncome:

                if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
                    //HIDE SHOW LAYOUT AS PER OPEN CLOSE VIEW
                    if (linearOtherIncome.getVisibility() == View.VISIBLE) {
                        linearOtherIncome.setVisibility(View.GONE);
                    } else {
                        linearOtherIncome.setVisibility(View.VISIBLE);
                    }
                } else {

                    CommonMethods.displayToast(mContext, mContext.getResources().getString(R.string.strWarningPleaseCompleteSteps));
                }


                break;
            case R.id.txtAddMoreProductionAndRevenuePlanning:

                //sava data in to database and per condition is from ADD button OR SAVE button
                saveDataInToDatabase(true);


                break;
            case R.id.txtSaveProductionAndRevenuePlanning:

                //sava data in to database and per condition is from ADD button OR SAVE button
                saveDataInToDatabase(false);

                break;
            case R.id.txtSaveOtherIncome:

                saveOtherIncomeData();

                break;

        }

    }


    public void setProductionAndRevenueview(boolean isFromDelete, boolean isFromAddButton) {
        //Remove All Views from dynamic added layout
        linearDynamicProductionAndRevenuePlanning.removeAllViews();
        int arraySize = 0;
        //Get Saved Business Plan Data From Database
        productionDetailsModelsList = mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)));

        //Inflate view as per arraylist size for different scenarios
        if (productionDetailsModelsList.size() != 0 && !isFromAddButton) {
            arraySize = productionDetailsModelsList.size();
        } else if (productionDetailsModelsList.size() != 0 && isFromAddButton) {
            arraySize = (productionDetailsModelsList.size() + 1);
        } else {
            arraySize = 1;
        }


        for (int i = 0; i < arraySize; i++) {

            //------(Add dynamic views as per array list size)-------//
            addMoreViews = mActivity.getLayoutInflater().inflate(R.layout.custom_dynamic_production_revenue, linearDynamicProductionAndRevenuePlanning, false);

            //------(Find views)-------//
            txtNoOfProduction = (TextView) addMoreViews.findViewById(R.id.txtNoOfProduction);
            txtTitleProductItems = (TextView) addMoreViews.findViewById(R.id.txtTitleProductItems);
            txtTtleWorkingDuration = (TextView) addMoreViews.findViewById(R.id.txtTtleWorkingDuration);
            txtTitlePerDurationProductionOrSale = (TextView) addMoreViews.findViewById(R.id.txtTitlePerDurationProductionOrSale);
            txtTitleTotalProduction = (TextView) addMoreViews.findViewById(R.id.txtTitleTotalProduction);
            txtTitleUtilization = (TextView) addMoreViews.findViewById(R.id.txtTitleUtilization);
            txtTitleWorkingDays60Per = (TextView) addMoreViews.findViewById(R.id.txtTitleWorkingDays60Per);
            txtTitleTotalProduction60Per = (TextView) addMoreViews.findViewById(R.id.txtTitleTotalProduction60Per);
            txtTitleSalePriceRevenue = (TextView) addMoreViews.findViewById(R.id.txtTitleSalePriceRevenue);
            txtTitleAmountPriceRevenue = (TextView) addMoreViews.findViewById(R.id.txtTitleAmountPriceRevenue);
            txtTitleCostPrice = (TextView) addMoreViews.findViewById(R.id.txtTitleCostPrice);
            txtTitleTotalCostOfGoods = (TextView) addMoreViews.findViewById(R.id.txtTitleTotalCostOfGoods);

            edtProduction = (EditText) addMoreViews.findViewById(R.id.edtProduction);
            edtProduction.setFilters(new InputFilter[]{new InputFilterditTextName(edtProduction.getText().toString())});
            edtWorkingDays = (EditText) addMoreViews.findViewById(R.id.edtWorkingDays);
            edtTotalProduction = (EditText) addMoreViews.findViewById(R.id.edtTotalProduction);
            edtWorkingDays60Per = (EditText) addMoreViews.findViewById(R.id.edtWorkingDays60Per);
            edtTotalProduction60Per = (EditText) addMoreViews.findViewById(R.id.edtTotalProduction60Per);
            edtSalePriceRevenue = (EditText) addMoreViews.findViewById(R.id.edtSalePriceRevenue);
            edtAmaountPriceRevenue = (EditText) addMoreViews.findViewById(R.id.edtAmaountPriceRevenue);
            edtEnterWorkingDays = (EditText) addMoreViews.findViewById(R.id.edtEnterWorkingDays);
            edtSaleInPercentage = (EditText) addMoreViews.findViewById(R.id.edtSaleInPercentage);
            edtCostPrice = (EditText) addMoreViews.findViewById(R.id.edtCostPrice);
            edtTotalCostOfGoods = (EditText) addMoreViews.findViewById(R.id.edtTotalCostOfGoods);

            //SET MENDETORY TITLES
            txtTitleProductItems.setText(CommonMethods.spannableString(getResources().getString(R.string.strProductItem)));
            txtTtleWorkingDuration.setText(CommonMethods.spannableString(getResources().getString(R.string.strWorkingDurationPerYear)));
            txtTitlePerDurationProductionOrSale.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerDurationProductionSale)));
            txtTitleTotalProduction.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalProduction)));
            txtTitleUtilization.setText(CommonMethods.spannableString(getResources().getString(R.string.strUtilizationPercentage)));
            txtTitleWorkingDays60Per.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerDay60Per)));
            txtTitleTotalProduction60Per.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalProduction60Per)));
            txtTitleSalePriceRevenue.setText(CommonMethods.spannableString(getResources().getString(R.string.strSalePriceRevenue)));
            txtTitleAmountPriceRevenue.setText(CommonMethods.spannableString(getResources().getString(R.string.strAmountPriceRevenue)));
            txtTitleCostPrice.setText(CommonMethods.spannableString(getResources().getString(R.string.strTitle20CostPrice)));
            txtTitleTotalCostOfGoods.setText(CommonMethods.spannableString(getResources().getString(R.string.strTitle20TotalCostOfGoods)));

            //SET DEFAULT FILTER FOR DAYS
            edtEnterWorkingDays.setFilters(new InputFilter[]{new InputFilterMinMax("1", "365")});
            edtSaleInPercentage.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});

            rgHowWay = (RadioGroup) addMoreViews.findViewById(R.id.rgHowWay);
            rdbtnday300 = (RadioButton) addMoreViews.findViewById(R.id.rdbtnday300);
            rdbtnday52 = (RadioButton) addMoreViews.findViewById(R.id.rdbtnday52);
            rdbtnday12 = (RadioButton) addMoreViews.findViewById(R.id.rdbtnday12);

            imgEditView = (ImageView) addMoreViews.findViewById(R.id.imgEditView);


            //set seriel no. to the dynamic added box
            txtNoOfProduction.setText("" + (i + 1));

            //SetDefault working unit type
            workingUnitsType = Constants.COMMON_DAYS;

            //----(Set already existing data)-----//
            if (productionDetailsModelsList.size() != 0) {

                if (productionDetailsModelsList.size() > i) {

                    Double dblPerDayEightHours = productionDetailsModelsList.get(i).getPerDayEightHours();
                    Double dblTotalProduction = productionDetailsModelsList.get(i).getTotalProduction();
                    Double dblWorkingDay60Percent = productionDetailsModelsList.get(i).getPerDaySixtyPercent();
                    Double dblTotalUtilization = productionDetailsModelsList.get(i).getTotalUtilization();
                    Double dblSalePrice = productionDetailsModelsList.get(i).getSalePricePerUnit();
                    Double dblAmountPrice = productionDetailsModelsList.get(i).getAmount();
                    Double dblCostprice = productionDetailsModelsList.get(i).getCostPrice();
                    Double dblTotalCostOfGoods = productionDetailsModelsList.get(i).getTotalCostOfGoods();
                    int intSalePercentage = productionDetailsModelsList.get(i).getSalePercentage();

                    edtProduction.setText("" + productionDetailsModelsList.get(i).getProductName());
                    edtWorkingDays.setText("" + dblPerDayEightHours.intValue());
                    edtEnterWorkingDays.setText("" + productionDetailsModelsList.get(i).getWorkingUnites());
                    edtTotalProduction.setText("" + dblTotalProduction.intValue());
                    edtWorkingDays60Per.setText("" + dblWorkingDay60Percent.intValue());
                    edtTotalProduction60Per.setText("" + dblTotalUtilization.intValue());
                    edtSalePriceRevenue.setText("" + dblSalePrice.intValue());
                    edtAmaountPriceRevenue.setText("" + dblAmountPrice.intValue());
                    edtCostPrice.setText("" + dblCostprice.intValue());
                    edtTotalCostOfGoods.setText("" + dblTotalCostOfGoods.intValue());
                    if (intSalePercentage == 0) {
                        edtSaleInPercentage.setText("0");
                    } else {
                        edtSaleInPercentage.setText(String.valueOf(intSalePercentage));
                    }


                    if (productionDetailsModelsList.get(i).getWorkingUnitsType().equals(Constants.COMMON_DAYS)) {
                        rdbtnday300.setChecked(true);
                        rdbtnday52.setChecked(false);
                        rdbtnday12.setChecked(false);
                        workingUnitsType = productionDetailsModelsList.get(i).getWorkingUnitsType();
                        edtEnterWorkingDays.setFilters(new InputFilter[]{new InputFilterMinMax("1", "365")});

                    } else if (productionDetailsModelsList.get(i).getWorkingUnitsType().equals(Constants.COMMON_WEEKS)) {
                        rdbtnday300.setChecked(false);
                        rdbtnday52.setChecked(true);
                        rdbtnday12.setChecked(false);
                        workingUnitsType = productionDetailsModelsList.get(i).getWorkingUnitsType();
                        edtEnterWorkingDays.setFilters(new InputFilter[]{new InputFilterMinMax("1", "52")});
                    } else {
                        rdbtnday300.setChecked(false);
                        rdbtnday52.setChecked(false);
                        rdbtnday12.setChecked(true);
                        workingUnitsType = productionDetailsModelsList.get(i).getWorkingUnitsType();
                        edtEnterWorkingDays.setFilters(new InputFilter[]{new InputFilterMinMax("1", "12")});
                    }
                    if (productionDetailsModelsList.get(i).isEditble() != 1) {
                        edtProduction.setFocusableInTouchMode(false);
                        edtProduction.setClickable(false);
                        edtWorkingDays.setFocusableInTouchMode(false);
                        edtWorkingDays.setClickable(false);
                        rdbtnday300.setClickable(false);
                        rdbtnday52.setClickable(false);
                        rdbtnday12.setClickable(false);
                        edtWorkingDays60Per.setFocusableInTouchMode(false);
                        edtSalePriceRevenue.setFocusableInTouchMode(false);
                        edtEnterWorkingDays.setFocusableInTouchMode(false);
                        edtSaleInPercentage.setClickable(false);
                        edtSaleInPercentage.setFocusableInTouchMode(false);
                        edtCostPrice.setFocusableInTouchMode(false);
                        edtTotalCostOfGoods.setFocusableInTouchMode(false);

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
            linearDynamicProductionAndRevenuePlanning.addView(addMoreViews);
            int position = linearDynamicProductionAndRevenuePlanning.indexOfChild(addMoreViews);
            imgEditView.setTag(position);


            //----(use position for delete view)-----//
            imgEditView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    intPosition = (Integer) v.getTag();
                    //open edit view dialog
                    openListSellDialog(intPosition);


                }
            });

            rgHowWay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                    @Override
                                                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                        RadioButton radioButton = (RadioButton) mView.findViewById(checkedId);
                                                        switch (checkedId) {
                                                            case R.id.rdbtnday300:
                                                                // workingUnits = "Days";
                                                                workingUnitsType = Constants.COMMON_DAYS;
                                                                edtEnterWorkingDays.setFilters(new InputFilter[]{new InputFilterMinMax("1", "365")});
                                                                clearItems();

                                                                break;
                                                            case R.id.rdbtnday52:
                                                                //workingUnits = "Weeks";
                                                                workingUnitsType = Constants.COMMON_WEEKS;
                                                                edtEnterWorkingDays.setFilters(new InputFilter[]{new InputFilterMinMax("1", "52")});
                                                                clearItems();

                                                                break;
                                                            case R.id.rdbtnday12:
                                                                //  workingUnits = "Months";
                                                                workingUnitsType = Constants.COMMON_MONTHS;
                                                                edtEnterWorkingDays.setFilters(new InputFilter[]{new InputFilterMinMax("1", "12")});
                                                                clearItems();

                                                                break;

                                                        }

                                                    }

                                                    private void clearItems() {
                                                        //Clear all edit text if working units chnage
                                                        edtWorkingDays.setText("");
                                                        edtSaleInPercentage.setText("");
                                                        edtEnterWorkingDays.setText("");
                                                        edtTotalProduction.setText("");
                                                        edtWorkingDays60Per.setText("");
                                                        edtTotalProduction60Per.setText("");
                                                        edtSalePriceRevenue.setText("");
                                                        edtAmaountPriceRevenue.setText("");
                                                        edtCostPrice.setText("");
                                                        edtTotalCostOfGoods.setText("");

                                                    }
                                                }
            );

            edtEnterWorkingDays.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                    if (s.length() != 0) {
                        workingUnits = s.toString();
                    }
                    edtWorkingDays.setText("");
                    edtTotalProduction.setText("");
                    edtWorkingDays60Per.setText("");
                    edtTotalProduction60Per.setText("");
                    edtSalePriceRevenue.setText("");
                    edtAmaountPriceRevenue.setText("");
                    edtCostPrice.setText("");
                    edtTotalCostOfGoods.setText("");
                }
            });
            edtWorkingDays.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {

                    if (s.length() != 0) {


                        dblworkingDays = Double.valueOf(s.toString());
                        dblTotalProductionUnites = (Double.valueOf(workingUnits) * dblworkingDays);
                        edtTotalProduction.setText("" + dblTotalProductionUnites.intValue());


                    }
                    edtSaleInPercentage.setText("");
                    edtWorkingDays60Per.setText("");
                    edtTotalProduction60Per.setText("");
                    edtSalePriceRevenue.setText("");
                    edtAmaountPriceRevenue.setText("");
                    edtCostPrice.setText("");
                    edtTotalCostOfGoods.setText("");


                }
            });


            edtSaleInPercentage.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                    if (s.length() != 0) {

                        //Calculation formula as per yagnik sir and nirali desai suggested
                        //Remove static 60 percentage from lst and add entered field for the same which we will use for calculation
                        //Edited by ketan
                        //Suggestions from Delhi traing(Khushru Sir) 19/03/2018 16:42

                        // dblPerDatWeekUtilizationProduction = (dblTotalAmount * 60) / 100;
                        dblPerDatWeekUtilizationProduction = (dblworkingDays * Integer.parseInt(s.toString())) / 100;

                        dblTotalProduction = Double.valueOf(dblTotalProductionUnites);
                        // dblTotalUtilizationProduction = (dblTotalProduction * 60) / 100;
                        dblTotalUtilizationProduction = (dblTotalProduction * Integer.parseInt(s.toString())) / 100;

                        // edtTotalProduction.setText("" + dblTotalProductionUnites.intValue());
                        edtWorkingDays60Per.setText("" + dblPerDatWeekUtilizationProduction.intValue());
                        edtTotalProduction60Per.setText("" + dblTotalUtilizationProduction.intValue());

                    } else {
                        edtWorkingDays60Per.setText("");
                        edtTotalProduction60Per.setText("");

                    }
                    edtSalePriceRevenue.setText("");
                    edtAmaountPriceRevenue.setText("");
                    edtCostPrice.setText("");
                    edtTotalCostOfGoods.setText("");
                }
            });


            edtSalePriceRevenue.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                    if (s.length() != 0) {

                        //calculation as per yagnik sir and nirali desai suggested
                        if (dblTotalUtilizationProduction != null) {
                            dblSalePriceRevenue = Double.valueOf(s.toString());
                            dblAmonutPriceRevenue = (dblTotalUtilizationProduction.intValue() * dblSalePriceRevenue);
                            edtAmaountPriceRevenue.setText("" + dblAmonutPriceRevenue.intValue());
                        }


                    } else {
                        edtAmaountPriceRevenue.setText("");
                    }

                }
            });


            edtCostPrice.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                    if (s.length() != 0) {

                        //calculation as per yagnik sir and nirali desai suggested
                        if (dblTotalUtilizationProduction != null) {

                            dbltotalCostOfGoods = (dblTotalUtilizationProduction.intValue() * Double.valueOf(s.toString()));
                            edtTotalCostOfGoods.setText("" + dbltotalCostOfGoods.intValue());
                        }


                    } else {
                        edtTotalCostOfGoods.setText("");
                    }

                }
            });

        }

    }

    private boolean checkValidation() {

        if (edtProduction.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningProductItem));
            return false;
        } else if (workingUnits.isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningperDay));
            return false;
        } else if (edtEnterWorkingDays.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningEnterWorkingDays));
            return false;
        } else if (edtWorkingDays.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningperDay));
            return false;
        } else if (edtTotalProduction.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningTotalProduction));
            return false;
        } else if (edtSaleInPercentage.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningEnterSalePercentage));
            return false;
        } else if (edtWorkingDays60Per.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningperDay60Per));
            return false;
        } else if (edtTotalProduction60Per.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningTotalProduction60Per));
            return false;
        } else if (edtSalePriceRevenue.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningSalePriceRevenue));
            return false;
        } else if (!edtSalePriceRevenue.getText().toString().isEmpty() && Double.valueOf(edtSalePriceRevenue.getText().toString()) == 0.0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningSalePriceRevenueValid));
            return false;
        } else if (edtAmaountPriceRevenue.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningAmountPriceRevenue));
            return false;
        } else if (edtCostPrice.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorEnterCostPrice));
            return false;
        } else if (!edtCostPrice.getText().toString().isEmpty() && Double.valueOf(edtCostPrice.getText().toString()) == 0.0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorEnterCostPriceValid));
            return false;
        } else if (edtTotalCostOfGoods.getText().toString().isEmpty()) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorTotalCostOfPrice));
            return false;
        }
        return true;
    }


    private void openWarningDialogforDeleteView(final int intPosition) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_remove_view_dialog, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog mAlertDialog = dialogBuilder.create();

        TextView txtUsername = (TextView) dialogView.findViewById(R.id.txtUsername);
        TextView txtRemove = (TextView) dialogView.findViewById(R.id.txtRemove);
        txtUsername.setText(mActivity.getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        txtRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteNewBusinessPlan20ProductionAndRevenueData(productionDetailsModelsList.get(intPosition).getId());
                setProductionAndRevenueview(true, false);
                mAlertDialog.dismiss();
            }
        });


        mAlertDialog.show();

    }

    private void saveDataInToDatabase(boolean isFromAddBtn) {

        if (productionDetailsModelsList.size() != 0) {

            //check if data already saved in database
            if (edtProduction.getText().toString().equals(productionDetailsModelsList.get(productionDetailsModelsList.size() - 1).getProductName())) {
                setProductionAndRevenueview(false, isFromAddBtn);

                if (!isFromAddBtn) {
                    //Hide view and display success message
                    linearProductionAndRevenuePlanning.setVisibility(View.GONE);
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strMessageProductAndRevenue));

                }
            } else {

                if (checkValidation()) {
                    insertProductionRevenueDataIntoDatabase(isFromAddBtn);
                }
            }
        } else {

            if (checkValidation()) {
                insertProductionRevenueDataIntoDatabase(isFromAddBtn);
            }
        }


    }

    private void insertProductionRevenueDataIntoDatabase(boolean isFromAddBtn) {

        //Inset Production and Revenyue
        mDatabaseHelper.insertNewbusinessPlanStep2ProductionAndRevenueData(
                System.currentTimeMillis(),
                Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                edtProduction.getText().toString(),
                workingUnits,
                workingUnitsType,
                Double.valueOf(edtWorkingDays.getText().toString()),
                Double.valueOf(edtTotalProduction.getText().toString()),
                Double.valueOf(edtWorkingDays60Per.getText().toString()),
                Double.valueOf(edtTotalProduction60Per.getText().toString()),
                Double.valueOf(edtSalePriceRevenue.getText().toString()),
                Double.valueOf(edtAmaountPriceRevenue.getText().toString()),
                Integer.valueOf(edtSaleInPercentage.getText().toString()),
                0,
                Double.valueOf(edtCostPrice.getText().toString()),
                Double.valueOf(edtTotalCostOfGoods.getText().toString()));

        // reset dynamic view
        setProductionAndRevenueview(false, isFromAddBtn);
        if (!isFromAddBtn) {
            //Hide view and display success messege
            linearProductionAndRevenuePlanning.setVisibility(View.GONE);
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strMessageProductAndRevenue));

        }
    }


    private void openListSellDialog(final int intPosition) {

        final String[] workingUnitsEditView = {"300"};
        final String[] workingWorkingUnitsEditView = {Constants.COMMON_DAYS};


        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_edit_view_dialog_for_step_two, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog mAlertDialog = dialogBuilder.create();


        final TextView tvNoOfProductionEditView = (TextView) dialogView.findViewById(R.id.tvNoOfProductionEditView);

        final TextView txtTitleProductItemsEditView = (TextView) dialogView.findViewById(R.id.txtTitleProductItemsEditView);
        final TextView txtTtleWorkingDurationEditView = (TextView) dialogView.findViewById(R.id.txtTtleWorkingDurationEditView);
        final TextView txtTitlePerDurationProductionOrSaleEditView = (TextView) dialogView.findViewById(R.id.txtTitlePerDurationProductionOrSaleEditView);
        final TextView txtTitleTotalProductionEditView = (TextView) dialogView.findViewById(R.id.txtTitleTotalProductionEditView);
        final TextView txtTitleUtilizationEditView = (TextView) dialogView.findViewById(R.id.txtTitleUtilizationEditView);
        final TextView txtTitleWorkingDays60PerEditView = (TextView) dialogView.findViewById(R.id.txtTitleWorkingDays60PerEditView);
        final TextView txtTitleTotalProduction60PerEditView = (TextView) dialogView.findViewById(R.id.txtTitleTotalProduction60PerEditView);
        final TextView txtTitleSalePriceRevenueEditView = (TextView) dialogView.findViewById(R.id.txtTitleSalePriceRevenueEditView);
        final TextView txtTitleAmountPriceRevenueEditView = (TextView) dialogView.findViewById(R.id.txtTitleAmountPriceRevenueEditView);
        final TextView txtTitleCostPriceEditView = (TextView) dialogView.findViewById(R.id.txtTitleCostPriceEditView);
        final TextView txtTitleTotalCostOfGoodsEditView = (TextView) dialogView.findViewById(R.id.txtTitleTotalCostOfGoodsEditView);

        final EditText edtProductionEditView = (EditText) dialogView.findViewById(R.id.edtProductionEditView);
        edtProductionEditView.setFilters(new InputFilter[]{new InputFilterditTextName(edtProductionEditView.getText().toString())});
        final EditText edtWorkingDaysEditView = (EditText) dialogView.findViewById(R.id.edtWorkingDaysEditView);
        final EditText edtTotalProductionEditView = (EditText) dialogView.findViewById(R.id.edtTotalProductionEditView);
        final EditText edtWorkingDays60PerEditView = (EditText) dialogView.findViewById(R.id.edtWorkingDays60PerEditView);
        final EditText edtTotalProduction60PerEditView = (EditText) dialogView.findViewById(R.id.edtTotalProduction60PerEditView);
        final EditText edtSalePriceRevenueEditView = (EditText) dialogView.findViewById(R.id.edtSalePriceRevenueEditView);
        final EditText edtAmaountPriceRevenueEditView = (EditText) dialogView.findViewById(R.id.edtAmaountPriceRevenueEditView);
        final EditText edtEnterWorkingDaysEditView = (EditText) dialogView.findViewById(R.id.edtEnterWorkingDaysEditView);
        final EditText edtSaleInPercentageEditView = (EditText) dialogView.findViewById(R.id.edtSaleInPercentageEditView);
        final EditText edtCostPriceEditView = (EditText) dialogView.findViewById(R.id.edtCostPriceEditView);
        final EditText edtTotalCostOfGoodsEditView = (EditText) dialogView.findViewById(R.id.edtTotalCostOfGoodsEditView);

        final RadioGroup rgHowWayEditView = (RadioGroup) dialogView.findViewById(R.id.rgHowWayEditView);
        final RadioButton rdbtnday300EditView = (RadioButton) dialogView.findViewById(R.id.rdbtnday300EditView);
        final RadioButton rdbtnday52EditView = (RadioButton) dialogView.findViewById(R.id.rdbtnday52EditView);
        final RadioButton rdbtnday12EditView = (RadioButton) dialogView.findViewById(R.id.rdbtnday12EditView);

        final TextView txtCancelEditView = (TextView) dialogView.findViewById(R.id.txtCancelEditView);
        final TextView txtDeleteEditView = (TextView) dialogView.findViewById(R.id.txtDeleteEditView);
        final TextView txtUpdateEditView = (TextView) dialogView.findViewById(R.id.txtUpdateEditView);


        //set editable data in to dialog
        tvNoOfProductionEditView.setText("" + (intPosition + 1));

        Double dblPerDayEightHours = productionDetailsModelsList.get(intPosition).getPerDayEightHours();
        Double dblTotalProduction = productionDetailsModelsList.get(intPosition).getTotalProduction();
        Double dblWorkingDay60Percent = productionDetailsModelsList.get(intPosition).getPerDaySixtyPercent();
        Double dblTotalUtilization = productionDetailsModelsList.get(intPosition).getTotalUtilization();
        Double dblSalePrice = productionDetailsModelsList.get(intPosition).getSalePricePerUnit();
        Double dblAmountPrice = productionDetailsModelsList.get(intPosition).getAmount();
        Double dblCostPriceEditView = productionDetailsModelsList.get(intPosition).getCostPrice();
        Double dblTotalCostPrice = productionDetailsModelsList.get(intPosition).getTotalCostOfGoods();
        int intEnterPercentage = productionDetailsModelsList.get(intPosition).getSalePercentage();

        edtProductionEditView.setText("" + productionDetailsModelsList.get(intPosition).getProductName());
        edtWorkingDaysEditView.setText("" + dblPerDayEightHours.intValue());
        edtEnterWorkingDaysEditView.setText("" + productionDetailsModelsList.get(intPosition).getWorkingUnites());
        edtTotalProductionEditView.setText("" + dblTotalProduction.intValue());
        edtWorkingDays60PerEditView.setText("" + dblWorkingDay60Percent.intValue());
        edtTotalProduction60PerEditView.setText("" + dblTotalUtilization.intValue());
        edtSalePriceRevenueEditView.setText("" + dblSalePrice.intValue());
        edtAmaountPriceRevenueEditView.setText("" + dblAmountPrice.intValue());
        edtCostPriceEditView.setText("" + dblCostPriceEditView.intValue());
        edtTotalCostOfGoodsEditView.setText("" + dblTotalCostPrice.intValue());
        edtSaleInPercentageEditView.setText(String.valueOf(intEnterPercentage));

        //SET MENDETORY TITLES
        txtTitleProductItemsEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strProductItem)));
        txtTtleWorkingDurationEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strWorkingDurationPerYear)));
        txtTitlePerDurationProductionOrSaleEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerDurationProductionSale)));
        txtTitleTotalProductionEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalProduction)));
        txtTitleUtilizationEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strUtilizationPercentage)));
        txtTitleWorkingDays60PerEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strPerDay60Per)));
        txtTitleTotalProduction60PerEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalProduction60Per)));
        txtTitleSalePriceRevenueEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strSalePriceRevenue)));
        txtTitleAmountPriceRevenueEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strAmountPriceRevenue)));
        txtTitleCostPriceEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTitle20CostPrice)));
        txtTitleTotalCostOfGoodsEditView.setText(CommonMethods.spannableString(getResources().getString(R.string.strTitle20TotalCostOfGoods)));

        edtSaleInPercentageEditView.setFilters(new InputFilter[]{new InputFilterMinMax("1", "100")});


        if (productionDetailsModelsList.get(intPosition).getWorkingUnitsType().equals(Constants.COMMON_DAYS)) {
            rdbtnday300EditView.setChecked(true);
            rdbtnday52EditView.setChecked(false);
            rdbtnday12EditView.setChecked(false);
            workingUnitsEditView[0] = productionDetailsModelsList.get(intPosition).getWorkingUnites();
            edtEnterWorkingDaysEditView.setFilters(new InputFilter[]{new InputFilterMinMax("1", "365")});
            workingWorkingUnitsEditView[0] = Constants.COMMON_DAYS;
        } else if (productionDetailsModelsList.get(intPosition).getWorkingUnitsType().equals(Constants.COMMON_WEEKS)) {
            rdbtnday300EditView.setChecked(false);
            rdbtnday52EditView.setChecked(true);
            rdbtnday12EditView.setChecked(false);
            workingUnitsEditView[0] = productionDetailsModelsList.get(intPosition).getWorkingUnites();
            edtEnterWorkingDaysEditView.setFilters(new InputFilter[]{new InputFilterMinMax("1", "52")});
            workingWorkingUnitsEditView[0] = Constants.COMMON_WEEKS;
        } else {
            rdbtnday300EditView.setChecked(false);
            rdbtnday52EditView.setChecked(false);
            rdbtnday12EditView.setChecked(true);
            workingUnitsEditView[0] = productionDetailsModelsList.get(intPosition).getWorkingUnites();
            edtEnterWorkingDaysEditView.setFilters(new InputFilter[]{new InputFilterMinMax("1", "12")});
            workingWorkingUnitsEditView[0] = Constants.COMMON_MONTHS;
        }


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

                openWarningDialogforDeleteView(intPosition);
                mAlertDialog.dismiss();

            }
        });


        //----(Save Edited values in database as well as in current array list)-----//
        txtUpdateEditView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkValidationForEditView()) {

                    mDatabaseHelper.updateNewBusinessPlan20ProductionAndRevenueData(
                            productionDetailsModelsList.get(intPosition).getId(),
                            productionDetailsModelsList.get(intPosition).getBusinessPlanId(),
                            edtProductionEditView.getText().toString(),
                            workingUnitsEditView[0],
                            workingWorkingUnitsEditView[0],
                            Double.valueOf(edtWorkingDaysEditView.getText().toString()),
                            Double.valueOf(edtTotalProductionEditView.getText().toString()),
                            Double.valueOf(edtWorkingDays60PerEditView.getText().toString()),
                            Double.valueOf(edtTotalProduction60PerEditView.getText().toString()),
                            Double.valueOf(edtSalePriceRevenueEditView.getText().toString()),
                            Double.valueOf(edtAmaountPriceRevenueEditView.getText().toString()),
                            Integer.valueOf(edtSaleInPercentageEditView.getText().toString()), 0,
                            Double.valueOf(edtCostPriceEditView.getText().toString()),
                            Double.valueOf(edtTotalCostOfGoodsEditView.getText().toString()));

                    //remove all view before add another view
                    setProductionAndRevenueview(false, false);
                    mAlertDialog.dismiss();

                }


            }

            private boolean checkValidationForEditView() {

                if (edtProductionEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningProductItem));
                    return false;
                } else if (workingUnitsEditView[0].isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningperDay));
                    return false;
                } else if (edtEnterWorkingDaysEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningEnterWorkingDays));
                    return false;
                } else if (edtWorkingDaysEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningperDay));
                    return false;
                } else if (edtTotalProductionEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningTotalProduction));
                    return false;
                } else if (edtSaleInPercentageEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningEnterSalePercentage));
                    return false;
                } else if (edtWorkingDays60PerEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningperDay60Per));
                    return false;
                } else if (edtTotalProduction60Per.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningTotalProduction60Per));
                    return false;
                } else if (edtSalePriceRevenueEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningSalePriceRevenue));
                    return false;
                } else if (!edtSalePriceRevenueEditView.getText().toString().isEmpty() && Double.valueOf(edtSalePriceRevenue.getText().toString()) == 0.0) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningSalePriceRevenueValid));
                    return false;
                } else if (edtAmaountPriceRevenueEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strWarningAmountPriceRevenue));
                    return false;
                } else if (edtCostPriceEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorEnterCostPrice));
                    return false;
                } else if (!edtCostPriceEditView.getText().toString().isEmpty() && Double.valueOf(edtCostPrice.getText().toString()) == 0.0) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorEnterCostPriceValid));
                    return false;
                } else if (edtTotalCostOfGoodsEditView.getText().toString().isEmpty()) {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorTotalCostOfPrice));
                    return false;
                }
                return true;
            }

        });

        rgHowWayEditView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                        @Override
                                                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                            RadioButton radioButton = (RadioButton) dialogView.findViewById(checkedId);
                                                            switch (checkedId) {
                                                                case R.id.rdbtnday300EditView:
                                                                    workingWorkingUnitsEditView[0] = Constants.COMMON_DAYS;
                                                                    edtEnterWorkingDaysEditView.setFilters(new InputFilter[]{new InputFilterMinMax("1", "365")});
                                                                    clearItems();
                                                                    break;
                                                                case R.id.rdbtnday52EditView:
                                                                    workingWorkingUnitsEditView[0] = Constants.COMMON_WEEKS;
                                                                    edtEnterWorkingDaysEditView.setFilters(new InputFilter[]{new InputFilterMinMax("1", "52")});
                                                                    clearItems();
                                                                    break;
                                                                case R.id.rdbtnday12EditView:
                                                                    workingWorkingUnitsEditView[0] = Constants.COMMON_MONTHS;
                                                                    edtEnterWorkingDaysEditView.setFilters(new InputFilter[]{new InputFilterMinMax("1", "12")});
                                                                    clearItems();
                                                                    break;


                                                            }

                                                        }

                                                        private void clearItems() {
                                                            edtWorkingDaysEditView.setText("");
                                                            edtSaleInPercentageEditView.setText("");
                                                            edtEnterWorkingDaysEditView.setText("");
                                                            edtTotalProductionEditView.setText("");
                                                            edtWorkingDays60PerEditView.setText("");
                                                            edtTotalProduction60PerEditView.setText("");
                                                            edtSalePriceRevenueEditView.setText("");
                                                            edtAmaountPriceRevenueEditView.setText("");
                                                            edtCostPriceEditView.setText("");
                                                            edtTotalCostOfGoodsEditView.setText("");

                                                        }
                                                    }
        );

        edtEnterWorkingDaysEditView.addTextChangedListener(new TextWatcher() {


            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {

                    workingUnitsEditView[0] = s.toString();
                }
                edtSaleInPercentageEditView.setText("");
                edtWorkingDaysEditView.setText("");
                edtTotalProductionEditView.setText("");
                edtWorkingDays60PerEditView.setText("");
                edtTotalProduction60PerEditView.setText("");
                edtSalePriceRevenueEditView.setText("");
                edtAmaountPriceRevenueEditView.setText("");
            }
        });

        edtWorkingDaysEditView.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (s.length() != 0) {

                    Double dblworkingDaysEditView = Double.valueOf(s.toString());
                    Double dblTotalProductionEightHoursEditView = (Long.parseLong(workingUnitsEditView[0]) * dblworkingDaysEditView);

                    edtTotalProductionEditView.setText("" + dblTotalProductionEightHoursEditView.intValue());


                }
                edtSaleInPercentageEditView.setText("");
                edtWorkingDays60PerEditView.setText("");
                edtTotalProduction60PerEditView.setText("");
                edtSalePriceRevenueEditView.setText("");
                edtAmaountPriceRevenueEditView.setText("");


            }
        });


        edtSaleInPercentageEditView.addTextChangedListener(new TextWatcher() {


            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {


                    Double dblSaleInpercentage = Double.valueOf(s.toString());
                    Double dblTotalProductionEditView = Double.valueOf(edtTotalProductionEditView.getText().toString());

                    // Double dblPerDatWeekUtilizationProductionEditView = (dblTotalAmountEditView * 60) / 100;
                    Double dblPerDatWeekUtilizationProductionEditView = (Double.parseDouble(edtWorkingDaysEditView.getText().toString()) * Integer.parseInt(s.toString())) / 100;

                    //  Double dblTotalUtilizationProductionEditView = (dblTotalProductionEditView * 60) / 100;
                    Double dblTotalUtilizationProductionEditView = (dblTotalProductionEditView * Integer.parseInt(s.toString())) / 100;

                    edtWorkingDays60PerEditView.setText("" + dblPerDatWeekUtilizationProductionEditView.intValue());
                    edtTotalProduction60PerEditView.setText("" + dblTotalUtilizationProductionEditView.intValue());


                } else {
                    edtWorkingDays60PerEditView.setText("");
                    edtTotalProduction60PerEditView.setText("");


                }
                edtSalePriceRevenueEditView.setText("");
                edtAmaountPriceRevenueEditView.setText("");
                edtCostPriceEditView.setText("");
                edtTotalCostOfGoodsEditView.setText("");

            }
        });

        edtSalePriceRevenueEditView.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {


                    Double dblSalePriceRevenueEditView = Double.valueOf(s.toString());
                    Double dblAmonutPriceRevenueEditView = (Double.parseDouble(edtTotalProduction60PerEditView.getText().toString()) * dblSalePriceRevenueEditView);

                    edtAmaountPriceRevenueEditView.setText("" + dblAmonutPriceRevenueEditView.intValue());


                } else {
                    edtAmaountPriceRevenueEditView.setText("");
                }

            }
        });


        edtCostPriceEditView.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {


                    Double dblTotalCostOfGoods = (Double.valueOf(edtTotalProduction60PerEditView.getText().toString()) * Double.valueOf(s.toString()));

                    edtTotalCostOfGoodsEditView.setText("" + dblTotalCostOfGoods.intValue());


                } else {
                    edtTotalCostOfGoodsEditView.setText("");
                }

            }
        });

        mAlertDialog.show();

    }

    private void setOtherIncomeData() {

        businessPlanStep2_1_data = mDatabaseHelper.getBusinessPlanStep2_1_by_id(Long.parseLong(getArguments().getString(Constants.ENTERPRENEUR_ID)));

        if (businessPlanStep2_1_data.size() != 0) {

            //SET TEXT FOR INCOME DESCRIPTION
            edtOtherIncomeDescription.setText(businessPlanStep2_1_data.get(0).getParticulars());

            //SET AMOUNT FOR OTHE INCOME
            Double dblAmt = businessPlanStep2_1_data.get(0).getAmount();
            edtOtherAmount.setText("" + dblAmt.intValue());
        }
    }

    private void saveOtherIncomeData() {

        if (checkValidationForOtherIncome()) {

            //CHECK IF DATA IS ALREADY AVAILABLE IN DATABASE
            if (businessPlanStep2_1_data.size() == 0) {

                mDatabaseHelper.insertBusinessPlanStep2_1(
                        edtOtherIncomeDescription.getText().toString(),//1
                        Double.valueOf(edtOtherAmount.getText().toString()),//2
                        Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//3
                        Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
            } else {
                mDatabaseHelper.updateBusinessPlanStep2_1(
                        edtOtherIncomeDescription.getText().toString(),//1
                        Double.valueOf(edtOtherAmount.getText().toString()),//2
                        Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//3
                        Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));

            }


            //HIDE SHOW VIEW AS PER REQUIREMENTS
            if (linearOtherIncome.getVisibility() == View.VISIBLE) {
                linearOtherIncome.setVisibility(View.GONE);
            } else {
                linearOtherIncome.setVisibility(View.VISIBLE);
            }


            //DISPLAY SUCCESS MESSAGE
            CommonMethods.displayToast(getActivity(), getActivity().getResources().getString(R.string.strDataSavedSuccesfully));

        }
    }

    private boolean checkValidationForOtherIncome() {

        if (edtOtherIncomeDescription.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterOtherIncom));
            edtOtherIncomeDescription.requestFocus();
            return false;
        } else if (edtOtherAmount.getText().toString().isEmpty()) {
            CommonMethods.displayToast(getActivity(), getResources().getString(R.string.strEnterEnterAmount));
            edtOtherAmount.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    class SetScreenData extends AsyncTask<String, Integer, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            CommonMethods.showDialog(mContext, mContext.getResources().getString(R.string.strPleaseWait));

        }

        protected String doInBackground(String... arg0) {


            return "";
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            CommonMethods.closeDialog();

        }
    }


}

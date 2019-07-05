package com.triapp.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.triapp.Activities.MainActivity;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.Models.GetNewBusinessPlanDataModel;
import com.triapp.Models.LandBuildingModel;
import com.triapp.Models.ManPowerModel;
import com.triapp.Models.MeansOfFinanceModel;
import com.triapp.Models.SalesRealisationModel;
import com.triapp.Models.SaveEnterpriseModel;
import com.triapp.Models.SelectedParticularsModel;
import com.triapp.Models.SubmitLandBuildingData;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class ModelBusinessPlanListAdapter extends RecyclerView.Adapter<ModelBusinessPlanListAdapter.ViewHolder> {


    private final SessionManager mSessionManager;
    private final DatabaseHelper mDatabaseHelper;
    private View view;
    private Context mContext;
    private Activity mActivity;
    private List<SaveEnterpriseModel> enterpreneurList = new ArrayList<>();
    private ModelBusinessPlanListAdapter.ViewHolder viewHolder;
    private boolean isBusinessPlanCreated;
    private String strEnterprenuerID;
    private String typeOfEnterprise;


    public ModelBusinessPlanListAdapter(Context mContext, Activity mActivity, ArrayList<SaveEnterpriseModel> enterpreneurList, boolean isBusinessPlanCreated, String strEnterprenuerID, String typeOfEnterprise) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.enterpreneurList = enterpreneurList;
        this.isBusinessPlanCreated = isBusinessPlanCreated;
        this.strEnterprenuerID = strEnterprenuerID;
        this.typeOfEnterprise = typeOfEnterprise;

        mSessionManager = new SessionManager(mActivity);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

        //Simple reverse collection list
        //Collections.reverse(this.enterpreneurList);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtEnterpreneurName, txtEnterpriseName, txtEnrollDate, txtEnterpriseType, txtCopyBusinessPlan, txtProductDescription, txtViewBusinessPlan;

        public ViewHolder(View mView) {

            super(mView);
            txtEnterpreneurName = (TextView) mView.findViewById(R.id.txtEnterpreneurName);
            txtEnterpriseType = (TextView) mView.findViewById(R.id.txtEnterpriseType);
            txtEnrollDate = (TextView) mView.findViewById(R.id.txtEnrollDate);
            txtEnterpriseName = (TextView) mView.findViewById(R.id.txtEnterpriseName);
            txtViewBusinessPlan = (TextView) mView.findViewById(R.id.txtViewBusinessPlan);
            txtProductDescription = (TextView) mView.findViewById(R.id.txtProductDescription);
            txtCopyBusinessPlan = (TextView) mView.findViewById(R.id.txtCopyBusinessPlan);

        }
    }

    @Override
    public ModelBusinessPlanListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_model_business_plan_adapter, parent, false);

        view.setTag(viewHolder);
        viewHolder = new ModelBusinessPlanListAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ModelBusinessPlanListAdapter.ViewHolder holder, final int position) {

        holder.txtEnterpreneurName.setText("" + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getFirstName() + " " + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getMiddleName() + " " + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getLastName());
        holder.txtEnrollDate.setText("" + mActivity.getResources().getString(R.string.strBusinessPlanCreatedDate) + " : " + CommonMethods.getDateFromLong(enterpreneurList.get(position).getCreatedDate()));
        holder.txtEnterpriseName.setText("" + mActivity.getResources().getString(R.string.strEnterpriseName) + " : " + enterpreneurList.get(position).getNameOfUnit());
        holder.txtProductDescription.setText("" + mActivity.getResources().getString(R.string.strMoreDescripptionAboutEnterprise) + " : " + enterpreneurList.get(position).getSector());

        if (mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getEnterpriseType().equalsIgnoreCase("1")) {
            holder.txtEnterpriseType.setText("" + mActivity.getResources().getString(R.string.strEnterpriseType) + " : " + mActivity.getResources().getString(R.string.strExisting));
        } else {
            holder.txtEnterpriseType.setText("" + mActivity.getResources().getString(R.string.strEnterpriseType) + " : " + mActivity.getResources().getString(R.string.strNew));
        }

        holder.txtViewBusinessPlan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //SET ENTERPRENEUR NAME DYNAMIC
                MainActivity.setDynmaicEnterpreneurName("" + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getFirstName() + " " + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getMiddleName() + " " + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getLastName());

                //Call navigation controler
                //Add data in to bundle and send it to the details screen for displaying purpose only
                NavController navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ENTERPRENEUR_ID, "" + enterpreneurList.get(position).getEntrepreneurId());
                navController.navigate(R.id.createBusinessPlan, bundle);

            }
        });

        holder.txtCopyBusinessPlan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //SET ENTERPRENEUR NAME DYNAMIC
                MainActivity.setDynmaicEnterpreneurName("" + mDatabaseHelper.getEnterpreneurList(Long.valueOf(strEnterprenuerID)).get(0).getFirstName() + " " + mDatabaseHelper.getEnterpreneurList(Long.valueOf(strEnterprenuerID)).get(0).getMiddleName() + " " + mDatabaseHelper.getEnterpreneurList(Long.valueOf(strEnterprenuerID)).get(0).getLastName());

                new CopyBusinessPlanClass().execute("" + position);

            }
        });

    }

    @Override
    public int getItemCount() {

        return enterpreneurList.size();
    }

    class CopyBusinessPlanClass extends AsyncTask<String, Integer, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            CommonMethods.showDialog(mContext, mContext.getResources().getString(R.string.strCopyingBusinessPlanPleaseWait));

        }

        protected String doInBackground(String... arg0) {

            //GET POSITION FROM LIST
            int position = Integer.parseInt(arg0[0]);

            //MAKE OFF-LINE BUSINESS PLAN ID
            //IT SHOULD BE UNIQUE AND CREATE NEW FOR EVERY BUSINESS PLAN
            mSessionManager.updatePreferenceString(Constants.BUSINESS_PLAN_ID, "" + (String.valueOf(mSessionManager.getPreferenceInt(Constants.USER_ID)).length() - 1) + strEnterprenuerID);


            //INSERT BUSINESS PLAN 2.0 DATA IN TO DATABASE
            ArrayList<GetNewBusinessPlanDataModel.DataBean.ProductionAndRevenuesBean> mList20 = mDatabaseHelper.getNewbusinessPlanStep2ProductionAndRevenueData(Long.valueOf(enterpreneurList.get(position).getBusinessPlanId()));

            if (mList20.size() != 0) {
                for (int i = 0; i < mList20.size(); i++) {
                    //Inset Production and Revenyue
                    mDatabaseHelper.insertNewbusinessPlanStep2ProductionAndRevenueData(
                            System.currentTimeMillis(),
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                            mList20.get(i).getProductName(),
                            mList20.get(i).getWorkingUnites(),
                            mList20.get(i).getWorkingUnitsType(),
                            mList20.get(i).getPerDayEightHours(),
                            mList20.get(i).getTotalProduction(),
                            mList20.get(i).getPerDaySixtyPercent(),
                            mList20.get(i).getTotalUtilization(),
                            mList20.get(i).getSalePricePerUnit(),
                            mList20.get(i).getAmount(),
                            mList20.get(i).getSalePercentage(),
                            0,
                            mList20.get(i).getCostPrice(),
                            mList20.get(i).getTotalCostOfGoods());
                }
            }


            //INSERT BUSINESS PLAN 2.1 DATA IN TO DATABASE
            ArrayList<SalesRealisationModel> mList21 = mDatabaseHelper.getBusinessPlanStep2_1_by_id(enterpreneurList.get(position).getEntrepreneurId());
            if (mList21.size() != 0) {
                mDatabaseHelper.insertBusinessPlanStep2_1(
                        mList21.get(0).getParticulars(),//1
                        mList21.get(0).getAmount(),//2
                        Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//3
                        Long.valueOf(strEnterprenuerID));
            }

            //INSERT BUSINESS PLAN 3.0 DATA IN TO DATABASE
            ArrayList<SelectedParticularsModel> mList30 = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_0_lList(enterpreneurList.get(position).getEntrepreneurId());
            if (mList30.size() != 0) {
                //MAKE ARRAYLIST FOR STEP 3.0 LATER WE WILL USE IT FOE SAVE IN TO DATABASE
                ArrayList<SelectedParticularsModel> particularsEditedAnswerModelArrayList = new ArrayList<SelectedParticularsModel>();

                //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
                SelectedParticularsModel selectedParticularsModelMarketSurvey = new SelectedParticularsModel();
                selectedParticularsModelMarketSurvey.setAmount(Double.valueOf(mList30.get(0).getAmount().intValue()));
                selectedParticularsModelMarketSurvey.setId(1L);
                selectedParticularsModelMarketSurvey.setPreoperativeExpenditureParticularId(1L);
                selectedParticularsModelMarketSurvey.setName(mActivity.getResources().getString(R.string.strMarketSurveyExp));
                particularsEditedAnswerModelArrayList.add(selectedParticularsModelMarketSurvey);

                //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
                SelectedParticularsModel selectedParticularsModelStationary = new SelectedParticularsModel();
                selectedParticularsModelStationary.setAmount(Double.valueOf(mList30.get(1).getAmount().intValue()));
                selectedParticularsModelStationary.setId(2L);
                selectedParticularsModelStationary.setPreoperativeExpenditureParticularId(2L);
                selectedParticularsModelStationary.setName(mActivity.getResources().getString(R.string.strStationeryExp));
                particularsEditedAnswerModelArrayList.add(selectedParticularsModelStationary);

                //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
                SelectedParticularsModel selectedParticularsModelLegalExpence = new SelectedParticularsModel();
                selectedParticularsModelLegalExpence.setAmount(Double.valueOf(mList30.get(2).getAmount().intValue()));
                selectedParticularsModelLegalExpence.setId(3L);
                selectedParticularsModelLegalExpence.setPreoperativeExpenditureParticularId(3L);
                selectedParticularsModelLegalExpence.setName(mActivity.getResources().getString(R.string.strLegalExp));
                particularsEditedAnswerModelArrayList.add(selectedParticularsModelLegalExpence);

                //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
                SelectedParticularsModel selectedParticularsModelEstalblisExpence = new SelectedParticularsModel();
                selectedParticularsModelEstalblisExpence.setAmount(Double.valueOf(mList30.get(3).getAmount().intValue()));
                selectedParticularsModelEstalblisExpence.setId(4L);
                selectedParticularsModelEstalblisExpence.setPreoperativeExpenditureParticularId(4L);
                selectedParticularsModelEstalblisExpence.setName(mActivity.getResources().getString(R.string.strEstablishmentExp));
                particularsEditedAnswerModelArrayList.add(selectedParticularsModelEstalblisExpence);

                //MAKE MODEL CLASS FOR EACH ITEMS VALUES AND ADD TO IT IN ARRAYLIST
                SelectedParticularsModel selectedParticularsModelOtherExpence = new SelectedParticularsModel();
                selectedParticularsModelOtherExpence.setAmount(Double.valueOf(mList30.get(4).getAmount().intValue()));
                selectedParticularsModelOtherExpence.setId(5L);
                selectedParticularsModelOtherExpence.setPreoperativeExpenditureParticularId(5L);
                selectedParticularsModelOtherExpence.setName(mActivity.getResources().getString(R.string.strOtherExp));
                particularsEditedAnswerModelArrayList.add(selectedParticularsModelOtherExpence);

                mDatabaseHelper.insertEntrepreneurBP_3_0_step(
                        new Gson().toJson(particularsEditedAnswerModelArrayList),//1
                        Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                        Long.valueOf(strEnterprenuerID)//3
                );

            }

            //INSERT BUSINESS PLAN 3.1 DATA IN TO DATABASE
            ArrayList<GetNewBusinessPlanDataModel.DataBean> mList31 = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_1_lList(enterpreneurList.get(position).getEntrepreneurId());
            if (mList31.size() != 0) {

                ArrayList<LandBuildingModel> landBuildingModelArrayList = new ArrayList<>();

                //MAKE MODEL CLASS FOR SAVE DATA FOR EACH VIEW (LAND)
                LandBuildingModel landBuildingModelLand = new LandBuildingModel();
                landBuildingModelLand.setLandBuildingExpensesParticularId(1L);
                landBuildingModelLand.setArea(mList31.get(0).getLandBuildingExpenses().get(0).getArea());
                landBuildingModelLand.setPrice(mList31.get(0).getLandBuildingExpenses().get(0).getPrice());
                landBuildingModelLand.setAmount(mList31.get(0).getLandBuildingExpenses().get(0).getAmount());
                landBuildingModelLand.setOwnership(mList31.get(0).getLandBuildingExpenses().get(0).getOwnership());
                landBuildingModelLand.setPreOperativeMonths(mList31.get(0).getLandBuildingExpenses().get(0).getPreOperativeMonths());
                landBuildingModelArrayList.add(landBuildingModelLand);

                //MAKE MODEL CLASS FOR SAVE DATA FOR EACH VIEW (BUILDING)
                LandBuildingModel landBuildingModelBuilding = new LandBuildingModel();
                landBuildingModelBuilding.setLandBuildingExpensesParticularId(2L);
                landBuildingModelBuilding.setArea(mList31.get(0).getLandBuildingExpenses().get(1).getArea());
                landBuildingModelBuilding.setPrice(mList31.get(0).getLandBuildingExpenses().get(1).getPrice());
                landBuildingModelBuilding.setAmount(mList31.get(0).getLandBuildingExpenses().get(1).getAmount());
                landBuildingModelBuilding.setOwnership(mList31.get(0).getLandBuildingExpenses().get(1).getOwnership());
                landBuildingModelBuilding.setPreOperativeMonths(mList31.get(0).getLandBuildingExpenses().get(1).getPreOperativeMonths());
                landBuildingModelArrayList.add(landBuildingModelBuilding);

                mDatabaseHelper.insertEntrepreneurBP_3_1_step(
                        new Gson().toJson(landBuildingModelArrayList),//1
                        Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                        Long.valueOf(strEnterprenuerID)//3
                );

            }

            //INSERT BUSINESS PLAN 3.2 DATA IN TO DATABASE
            ArrayList<GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean> mList32 = mDatabaseHelper.getBusinessPlan3_2_MachineryAddMorNeweModelList(enterpreneurList.get(position).getBusinessPlanId());
            if (mList32.size() != 0) {
                for (int i = 0; i < mList32.size(); i++) {
                    mDatabaseHelper.insertBusinessPlan3_2_MachineryAddMorNeweModelList(
                            System.currentTimeMillis(),
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                            mList32.get(i).getPerticuler(),
                            mList32.get(i).getMachineryNo(),
                            mList32.get(i).getPrice(),
                            mList32.get(i).getAmount(),
                            mList32.get(i).getPurchaseDate(),
                            mList32.get(i).getExpectedLife(),
                            mList32.get(i).getScrapValue(),
                            mList32.get(i).getDepriciation(),
                            mList32.get(i).getBookValue(),
                            mList32.get(i).getSuppliersNameAndAddress(),
                            mList32.get(i).getTaxTransporatation(),
                            mList32.get(i).getElectrification(),
                            "",
                            0);
                }
            }

            //INSERT BUSNESS PLAN 3.3 IN TO DATABASE
            ArrayList<GetNewBusinessPlanDataModel.DataBean.FurnituresBean> mList33 = mDatabaseHelper.getBusinessPlan3_3_FurnitureAddMorNeweModelList(enterpreneurList.get(position).getBusinessPlanId());
            if (mList33.size() != 0) {
                for (int i = 0; i < mList33.size(); i++) {
                    mDatabaseHelper.insertBusinessPlan3_3_FurnitureAddMorNeweModelList(
                            System.currentTimeMillis(),
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                            mList33.get(i).getPerticuler(),
                            mList33.get(i).getMachineryNo(),
                            mList33.get(i).getPrice(),
                            mList33.get(i).getAmount(),
                            mList33.get(i).getPurchaseDate(),
                            mList33.get(i).getExpectedLife(),
                            mList33.get(i).getScrapValue(),
                            mList33.get(i).getDepriciation(),
                            mList33.get(i).getBookValue(),
                            mList33.get(i).getSuppliersNameAndAddress(),
                            "",
                            0);
                }
            }


            //INSERT BUSINESS PLAN 3.4 IN TO DATABASE
            ArrayList<GetNewBusinessPlanDataModel.DataBean.RawMaterialsBean> mList34 = mDatabaseHelper.getBusinessPlan3_4_RawMeterielAddMoreModelList(enterpreneurList.get(position).getBusinessPlanId());
            if (mList34.size() != 0) {
                for (int i = 0; i < mList34.size(); i++) {
                    mDatabaseHelper.insertBusinessPlan3_4_RawMeterielAddMoreModelList(
                            System.currentTimeMillis(),
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),
                            mList34.get(i).getItem(),
                            mList34.get(i).getForMonths(),
                            mList34.get(i).getQuantity(),
                            mList34.get(i).getRate(),
                            mList34.get(i).getTotalValue(),
                            0);
                }
            }

            //INSERT BUSINESS PLAN 3.5 IN TO DATABASE
            //GET STEP 3.5 DATA
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(enterpreneurList.get(position).getEntrepreneurId()).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> mList35 = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_5_lList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getUtilities();

                //MAKE ARRAYLIST FOR INSERT DATA
                ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> mUtilitiesModelArrayList = new ArrayList<>();
                mUtilitiesModelArrayList.clear();
                mUtilitiesModelArrayList = new ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean>();

                if (mList35.size() != 0) {
                    GetNewBusinessPlanDataModel.DataBean.UtilitiesBean mUtilitiesModelPower = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                    mUtilitiesModelPower.setUtilitiesParticularId(1L);
                    mUtilitiesModelPower.setAnnualExpenditure(mList35.get(0).getAnnualExpenditure());
                    mUtilitiesModelPower.setRemarks(mList35.get(0).getRemarks());
                    mUtilitiesModelArrayList.add(mUtilitiesModelPower);

                    GetNewBusinessPlanDataModel.DataBean.UtilitiesBean utilitiesModeWater = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                    utilitiesModeWater.setUtilitiesParticularId(2L);
                    utilitiesModeWater.setAnnualExpenditure(mList35.get(1).getAnnualExpenditure());
                    utilitiesModeWater.setRemarks(mList35.get(1).getRemarks());
                    mUtilitiesModelArrayList.add(utilitiesModeWater);

                    GetNewBusinessPlanDataModel.DataBean.UtilitiesBean utilitiesModeFuel = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                    utilitiesModeFuel.setUtilitiesParticularId(3L);
                    utilitiesModeFuel.setAnnualExpenditure(mList35.get(2).getAnnualExpenditure());
                    utilitiesModeFuel.setRemarks(mList35.get(2).getRemarks());
                    mUtilitiesModelArrayList.add(utilitiesModeFuel);

                    GetNewBusinessPlanDataModel.DataBean.UtilitiesBean utilitiesModeOther = new GetNewBusinessPlanDataModel.DataBean.UtilitiesBean();
                    utilitiesModeOther.setUtilitiesParticularId(4L);
                    utilitiesModeOther.setAnnualExpenditure(mList35.get(3).getAnnualExpenditure());
                    utilitiesModeOther.setRemarks(mList35.get(3).getRemarks());
                    mUtilitiesModelArrayList.add(utilitiesModeOther);

                    mDatabaseHelper.insertEntrepreneurBP_3_5_step(
                            new Gson().toJson(mUtilitiesModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(strEnterprenuerID)//3
                    );
                }
            }

            //INSERT BUSINESS PLAN 3.6 IN TO DATABASE
            //GET STEP 3.6 DATA FROM DATABASE
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(enterpreneurList.get(position).getEntrepreneurId()).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean> mList36 = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_6_lList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getManpowers();

                ArrayList<ManPowerModel> mManPowerModelSaveArrayList = new ArrayList<>();
                mManPowerModelSaveArrayList.clear();
                mManPowerModelSaveArrayList = new ArrayList<>();

                if (mList36.size() != 0) {

                    ManPowerModel manPowerModelSkilled = new ManPowerModel();
                    manPowerModelSkilled.setNumber(new Long(mList36.get(0).getNumber()));
                    manPowerModelSkilled.setWagesPerMonth(mList36.get(0).getWagesPerMonth());
                    manPowerModelSkilled.setAnnualExpenses(mList36.get(0).getAnnualExpenses());
                    manPowerModelSkilled.setManpowerParticularId(1L);
                    mManPowerModelSaveArrayList.add(manPowerModelSkilled);


                    ManPowerModel manPowerModeSemiSkilled = new ManPowerModel();
                    manPowerModeSemiSkilled.setNumber(new Long(mList36.get(1).getNumber()));
                    manPowerModeSemiSkilled.setWagesPerMonth(mList36.get(1).getWagesPerMonth());
                    manPowerModeSemiSkilled.setAnnualExpenses(mList36.get(1).getAnnualExpenses());
                    manPowerModeSemiSkilled.setManpowerParticularId(2L);
                    mManPowerModelSaveArrayList.add(manPowerModeSemiSkilled);

                    ManPowerModel manPowerModeUnSkilled = new ManPowerModel();
                    manPowerModeUnSkilled.setNumber(new Long(mList36.get(2).getNumber()));
                    manPowerModeUnSkilled.setWagesPerMonth(mList36.get(2).getWagesPerMonth());
                    manPowerModeUnSkilled.setAnnualExpenses(mList36.get(2).getAnnualExpenses());
                    manPowerModeUnSkilled.setManpowerParticularId(3L);
                    mManPowerModelSaveArrayList.add(manPowerModeUnSkilled);

                    ManPowerModel manPowerModeWidrawByOwners = new ManPowerModel();
                    manPowerModeWidrawByOwners.setNumber(new Long(mList36.get(3).getNumber()));
                    manPowerModeWidrawByOwners.setWagesPerMonth(mList36.get(3).getWagesPerMonth());
                    manPowerModeWidrawByOwners.setAnnualExpenses(mList36.get(3).getAnnualExpenses());
                    manPowerModeWidrawByOwners.setManpowerParticularId(4L);
                    mManPowerModelSaveArrayList.add(manPowerModeWidrawByOwners);


                    ManPowerModel manPowerModelAnyOther = new ManPowerModel();
                    manPowerModelAnyOther.setNumber(0L);
                    manPowerModelAnyOther.setWagesPerMonth(mList36.get(4).getWagesPerMonth());
                    manPowerModelAnyOther.setAnnualExpenses(mList36.get(4).getAnnualExpenses());
                    manPowerModelAnyOther.setManpowerParticularId(5L);
                    mManPowerModelSaveArrayList.add(manPowerModelAnyOther);

                    mDatabaseHelper.insertEntrepreneurBP_3_6_step(
                            new Gson().toJson(mManPowerModelSaveArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(strEnterprenuerID)//3
                    );
                }
            }

            //INSERT BUSINESS PLAN 3.7 IN TO DATABASE
            //GET STEP 3.7 DATA FROM DATABASE

            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(enterpreneurList.get(position).getEntrepreneurId()).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> mList37 = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_7_lList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getAdministrativeExpenses();

                ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> mAdministrativeDataList = new ArrayList<>();
                mAdministrativeDataList.clear();
                mAdministrativeDataList = new ArrayList<>();

                if (mList37.size() != 0) {

                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelStationary = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelStationary.setAdministrativeExpensesParticularId(1L);
                    mAdministrativeModelStationary.setAmount(mList37.get(0).getAmount());
                    mAdministrativeModelStationary.setRemarks(mList37.get(0).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelStationary);

                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelTraveling = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelTraveling.setAdministrativeExpensesParticularId(2L);
                    mAdministrativeModelTraveling.setAmount(mList37.get(1).getAmount());
                    mAdministrativeModelTraveling.setRemarks(mList37.get(1).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelTraveling);

                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelCommunication = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelCommunication.setAdministrativeExpensesParticularId(3L);
                    mAdministrativeModelCommunication.setAmount(mList37.get(2).getAmount());
                    mAdministrativeModelCommunication.setRemarks(mList37.get(2).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelCommunication);

                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelEntertainment = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelEntertainment.setAdministrativeExpensesParticularId(4L);
                    mAdministrativeModelEntertainment.setAmount(mList37.get(3).getAmount());
                    mAdministrativeModelEntertainment.setRemarks(mList37.get(3).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelEntertainment);

                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelInsurance = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelInsurance.setAdministrativeExpensesParticularId(5L);
                    mAdministrativeModelInsurance.setAmount(mList37.get(4).getAmount());
                    mAdministrativeModelInsurance.setRemarks(mList37.get(4).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelInsurance);

                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelRent = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelRent.setAdministrativeExpensesParticularId(6L);
                    mAdministrativeModelRent.setAmount(mList37.get(5).getAmount());
                    mAdministrativeModelRent.setRemarks(mList37.get(5).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelRent);


                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelMisc = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelMisc.setAdministrativeExpensesParticularId(7L);
                    mAdministrativeModelMisc.setAmount(mList37.get(6).getAmount());
                    mAdministrativeModelMisc.setRemarks(mList37.get(6).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelMisc);

                    GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean mAdministrativeModelRepair = new GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean();
                    mAdministrativeModelRepair.setAdministrativeExpensesParticularId(8L);
                    mAdministrativeModelRepair.setAmount(mList37.get(7).getAmount());
                    mAdministrativeModelRepair.setRemarks(mList37.get(7).getRemarks());
                    mAdministrativeDataList.add(mAdministrativeModelRepair);


                    mDatabaseHelper.insertEntrepreneurBP_3_7_step(
                            new Gson().toJson(mAdministrativeDataList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(strEnterprenuerID)//3
                    );
                }
            }

            //INSERT BUSINESS PLAN 3.8 IN TO DATABASE
            //GET STEP 3.8 DATA FROM DATABASE
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(enterpreneurList.get(position).getEntrepreneurId()).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> mList38 = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_8_lList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getSellingDistributionExpenses();

                ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> mSellingAndDistributionModelList = new ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean>();
                mSellingAndDistributionModelList.clear();
                mSellingAndDistributionModelList = new ArrayList<>();

                if (mList38.size() != 0) {

                    GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean mSellingDistributionExpensModelPublicity = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                    mSellingDistributionExpensModelPublicity.setSellingDistributionExpenseParticularId(1L);
                    mSellingDistributionExpensModelPublicity.setAmount(mList38.get(0).getAmount());
                    mSellingDistributionExpensModelPublicity.setRemarks(mList38.get(0).getRemarks());
                    mSellingAndDistributionModelList.add(mSellingDistributionExpensModelPublicity);

                    GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean mSellingDistributionExpensModelFreight = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                    mSellingDistributionExpensModelFreight.setSellingDistributionExpenseParticularId(3L);
                    mSellingDistributionExpensModelFreight.setAmount(mList38.get(1).getAmount());
                    mSellingDistributionExpensModelFreight.setRemarks(mList38.get(1).getRemarks());
                    mSellingAndDistributionModelList.add(mSellingDistributionExpensModelFreight);

                    GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean mSellingDistributionExpensModelCommission = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                    mSellingDistributionExpensModelCommission.setSellingDistributionExpenseParticularId(4L);
                    mSellingDistributionExpensModelCommission.setAmount(mList38.get(2).getAmount());
                    mSellingDistributionExpensModelCommission.setRemarks(mList38.get(2).getRemarks());
                    mSellingAndDistributionModelList.add(mSellingDistributionExpensModelCommission);


                    GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean sellingDistributionExpensModeMisc = new GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean();
                    sellingDistributionExpensModeMisc.setSellingDistributionExpenseParticularId(5L);
                    sellingDistributionExpensModeMisc.setAmount(mList38.get(3).getAmount());
                    sellingDistributionExpensModeMisc.setRemarks(mList38.get(3).getRemarks());
                    mSellingAndDistributionModelList.add(sellingDistributionExpensModeMisc);

                    mDatabaseHelper.insertEntrepreneurBP_3_8_step(
                            new Gson().toJson(mSellingAndDistributionModelList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(strEnterprenuerID)//3
                    );
                }
            }


            //INSERT BUSINESS PLAN 3.9 IN TO DATABASE
            //GET STEP 3.9 DATA FROM DATABASE
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_3_9_lList(enterpreneurList.get(position).getEntrepreneurId()).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean> mList39 = mDatabaseHelper.getEntrepreneurBusinessplan_step_3_9_lList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getWorkingCapitals();

                ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean> mWorkingCapitalModelsList = new ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean>();
                mWorkingCapitalModelsList.clear();
                mWorkingCapitalModelsList = new ArrayList<>();

                if (mList39.size() != 0) {
                    GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                    workingCapitalModel.setDuration(mList39.get(0).getDuration());
                    workingCapitalModel.setQuantity(mList39.get(0).getQuantity());
                    workingCapitalModel.setRate(mList39.get(0).getRate());
                    workingCapitalModel.setAmount(mList39.get(0).getAmount());
                    workingCapitalModel.setRateDescriprion(mList39.get(0).getRateDescriprion());
                    workingCapitalModel.setWorkingCapitalParticularId(1L);
                    mWorkingCapitalModelsList.add(workingCapitalModel);

                    GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel1 = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                    workingCapitalModel1.setDuration(mList39.get(1).getDuration());
                    workingCapitalModel1.setQuantity(mList39.get(1).getQuantity());
                    workingCapitalModel1.setRate(mList39.get(1).getRate());
                    workingCapitalModel1.setAmount(mList39.get(1).getAmount());
                    workingCapitalModel1.setRateDescriprion(mList39.get(1).getRateDescriprion());
                    workingCapitalModel1.setWorkingCapitalParticularId(2L);
                    mWorkingCapitalModelsList.add(workingCapitalModel1);

                    GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel2 = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                    workingCapitalModel2.setDuration(mList39.get(2).getDuration());
                    workingCapitalModel2.setQuantity(mList39.get(2).getQuantity());
                    workingCapitalModel2.setRate(mList39.get(2).getRate());
                    workingCapitalModel2.setAmount(mList39.get(2).getAmount());
                    workingCapitalModel2.setRateDescriprion(mList39.get(2).getRateDescriprion());
                    workingCapitalModel2.setWorkingCapitalParticularId(3L);
                    mWorkingCapitalModelsList.add(workingCapitalModel2);

                    GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean workingCapitalModel3 = new GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean();
                    workingCapitalModel3.setDuration(mList39.get(3).getDuration());
                    workingCapitalModel3.setQuantity(mList39.get(3).getQuantity());
                    workingCapitalModel3.setRate(mList39.get(3).getRate());
                    workingCapitalModel3.setRateDescriprion(mList39.get(3).getRateDescriprion());
                    workingCapitalModel3.setAmount(mList39.get(3).getAmount());
                    workingCapitalModel3.setWorkingCapitalParticularId(4L);
                    mWorkingCapitalModelsList.add(workingCapitalModel3);

                    mDatabaseHelper.insertEntrepreneurBP_3_9_step(
                            new Gson().toJson(mWorkingCapitalModelsList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(strEnterprenuerID)//3
                    );
                }
            }

            //INSERT BUSINESS PLAN 4.0 IN TO DATABASE
            //GET STEP 4.0 DATA FROM DATABASE
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_4_0_lList(enterpreneurList.get(position).getEntrepreneurId()).size() != 0) {
                ArrayList<GetNewBusinessPlanDataModel.DataBean.FinanceMeansBean> mList40 = mDatabaseHelper.getEntrepreneurBusinessplan_step_4_0_lList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getFinanceMeans();

                ArrayList<MeansOfFinanceModel> meansOfFinanceModelArrayList = new ArrayList<>();
                meansOfFinanceModelArrayList.clear();
                meansOfFinanceModelArrayList = new ArrayList<MeansOfFinanceModel>();

                if (mList40.size() != 0) {
                    MeansOfFinanceModel meansOfFinanceModel = new MeansOfFinanceModel();
                    meansOfFinanceModel.setFinanceMeansParticularId(1L);
                    meansOfFinanceModel.setAmount(mList40.get(0).getAmount());
                    meansOfFinanceModel.setRemarks(mList40.get(0).getRemarks());
                    meansOfFinanceModelArrayList.add(meansOfFinanceModel);

                    MeansOfFinanceModel meansOfFinanceModel1 = new MeansOfFinanceModel();
                    meansOfFinanceModel1.setFinanceMeansParticularId(2L);
                    meansOfFinanceModel1.setAmount(mList40.get(1).getAmount());
                    meansOfFinanceModel1.setRemarks(mList40.get(1).getRemarks());
                    meansOfFinanceModelArrayList.add(meansOfFinanceModel1);

                    MeansOfFinanceModel meansOfFinanceModel2 = new MeansOfFinanceModel();
                    meansOfFinanceModel2.setFinanceMeansParticularId(3L);
                    meansOfFinanceModel2.setAmount(mList40.get(2).getAmount());
                    meansOfFinanceModel2.setRemarks(mList40.get(2).getRemarks());
                    meansOfFinanceModelArrayList.add(meansOfFinanceModel2);


                    mDatabaseHelper.insertEntrepreneurBP_4_0_step(
                            new Gson().toJson(meansOfFinanceModelArrayList),//1
                            Long.valueOf(mSessionManager.getPreference(Constants.BUSINESS_PLAN_ID)),//2
                            Long.valueOf(strEnterprenuerID)//3
                    );
                }
            }

            return "";
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            CommonMethods.closeDialog();

            //ONCE ALL DATA INSERTED IN TO DATABASE USER WILL NAVIGATE TO CREATE BUSINESS PLAN SCREE
            //Call navigation controler
            //Add data in to bundle and send it to the details screen for displaying purpose only
            NavController navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
            Bundle bundle = new Bundle();
            bundle.putString(Constants.ENTERPRENEUR_ID, "" + strEnterprenuerID);
            bundle.putString(Constants.TYPE_OF_ENTERPRISE , ""+ typeOfEnterprise);
            navController.navigate(R.id.createBusinessPlan, bundle);

        }
    }

}


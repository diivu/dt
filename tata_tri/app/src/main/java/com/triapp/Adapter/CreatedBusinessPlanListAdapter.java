package com.triapp.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triapp.Activities.MainActivity;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.Models.SaveEnterpriseModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class CreatedBusinessPlanListAdapter extends RecyclerView.Adapter<CreatedBusinessPlanListAdapter.ViewHolder> {


    private final SessionManager mSessionManager;
    private final DatabaseHelper mDatabaseHelper;
    private View view;
    private Context mContext;
    private Activity mActivity;
    private List<SaveEnterpriseModel> enterpreneurList = new ArrayList<>();
    private CreatedBusinessPlanListAdapter.ViewHolder viewHolder;


    public CreatedBusinessPlanListAdapter(Context mContext, Activity mActivity, ArrayList<SaveEnterpriseModel> enterpreneurList) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.enterpreneurList = enterpreneurList;

        mSessionManager = new SessionManager(mActivity);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

        //Simple reverse collection list
       Collections.reverse(this.enterpreneurList);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtEnterpreneurName, txtEnterpriseName, txtEnrollDate, txtEnterpriseType, txtIsTemplateBusinessPlan, txtBusinessPlanStatus, txtBusinessPlanStatusPending,txtProductDescription, txtCreateBusinessPlan;

        public ViewHolder(View mView) {

            super(mView);
            txtEnterpreneurName = (TextView) mView.findViewById(R.id.txtEnterpreneurName);
            txtEnterpriseType = (TextView) mView.findViewById(R.id.txtEnterpriseType);
            txtEnrollDate = (TextView) mView.findViewById(R.id.txtEnrollDate);
            txtEnterpriseName = (TextView) mView.findViewById(R.id.txtEnterpriseName);
            txtCreateBusinessPlan = (TextView) mView.findViewById(R.id.txtCreateBusinessPlan);
            txtProductDescription = (TextView) mView.findViewById(R.id.txtProductDescription);
            txtBusinessPlanStatus = (TextView) mView.findViewById(R.id.txtBusinessPlanStatus);
            txtIsTemplateBusinessPlan = (TextView) mView.findViewById(R.id.txtIsTemplateBusinessPlan);
            txtBusinessPlanStatusPending = (TextView) mView.findViewById(R.id.txtBusinessPlanStatusPending);

        }
    }

    @Override
    public CreatedBusinessPlanListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_existing_model_business_plan_adapter, parent, false);

        view.setTag(viewHolder);
        viewHolder = new CreatedBusinessPlanListAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CreatedBusinessPlanListAdapter.ViewHolder holder, final int position) {

        holder.txtEnterpreneurName.setText("" + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getFirstName() + " " + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getMiddleName() + " " + mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getLastName());
        holder.txtEnrollDate.setText("" + mActivity.getResources().getString(R.string.strBusinessPlanCreatedDate) + " : " + CommonMethods.getDateFromLong(enterpreneurList.get(position).getCreatedDate()));
        holder.txtEnterpriseName.setText("" + mActivity.getResources().getString(R.string.strEnterpriseName) + " : " + enterpreneurList.get(position).getNameOfUnit());
        holder.txtProductDescription.setText("" + mActivity.getResources().getString(R.string.strMoreDescripptionAboutEnterprise) + " : " + enterpreneurList.get(position).getSector());


        //CHECK IF BUSINESS PLAN IS SUBIMMITED OR MODEL BUSINESS PLAN
        if (enterpreneurList.get(position).getIsBusinessPlanSubmited() != 0 || enterpreneurList.get(position).getIsModelBusinessPlan() != 0) {
            holder.txtBusinessPlanStatus.setVisibility(View.VISIBLE);
            holder.txtBusinessPlanStatusPending.setVisibility(View.GONE);
        } else {
            holder.txtBusinessPlanStatus.setVisibility(View.GONE);
            holder.txtBusinessPlanStatusPending.setVisibility(View.VISIBLE);
        }

        //IF MODEL BUSINESS PLAN THEN TEMPLET TAG VISIBLE
        if (enterpreneurList.get(position).getIsModelBusinessPlan() != 0) {
            holder.txtIsTemplateBusinessPlan.setVisibility(View.VISIBLE);
        } else {
            holder.txtIsTemplateBusinessPlan.setVisibility(View.GONE);
        }


        //ENTERPRSE TYPE BASED ON DATA
        if (mDatabaseHelper.getEnterpreneurList(enterpreneurList.get(position).getEntrepreneurId()).get(0).getEnterpriseType().equalsIgnoreCase("1")) {
            holder.txtEnterpriseType.setText("" + mActivity.getResources().getString(R.string.strEnterpriseType) + " : " + mActivity.getResources().getString(R.string.strExisting));
        } else {
            holder.txtEnterpriseType.setText("" + mActivity.getResources().getString(R.string.strEnterpriseType) + " : " + mActivity.getResources().getString(R.string.strNew));
        }


        holder.txtCreateBusinessPlan.setOnClickListener(new View.OnClickListener() {

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


    }

    private void openOptionsDialog(final int position) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.choose_businessplan_options_dialog, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog mAlertDialog = dialogBuilder.create();
        TextView txtCreateNewBusinessPlan = (TextView) dialogView.findViewById(R.id.txtCreateNewBusinessPlan);
        TextView txtChooseFromExisting = (TextView) dialogView.findViewById(R.id.txtChooseFromExisting);
        TextView txtUsername = (TextView) dialogView.findViewById(R.id.txtUsername);

        txtUsername.setText(mActivity.getResources().getString(R.string.strTitleHello) + " " + mSessionManager.getPreference(Constants.USER_NAME) + "!");

        txtCreateNewBusinessPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mAlertDialog.dismiss();

            }
        });
        txtChooseFromExisting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAlertDialog.dismiss();

            }
        });
        mAlertDialog.show();

    }


    @Override
    public int getItemCount() {

        return enterpreneurList.size();
    }

}
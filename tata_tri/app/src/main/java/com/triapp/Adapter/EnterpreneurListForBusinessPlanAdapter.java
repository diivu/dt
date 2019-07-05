package com.triapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triapp.Activities.MainActivity;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class EnterpreneurListForBusinessPlanAdapter extends RecyclerView.Adapter<EnterpreneurListForBusinessPlanAdapter.ViewHolder> {


    private final SessionManager mSessionManager;
    private View view;
    private Context mContext;
    private Activity mActivity;
    private List<CreateEnterpreneurModel.DataBean> enterpreneurList = new ArrayList<>();
    private EnterpreneurListForBusinessPlanAdapter.ViewHolder viewHolder;


    public EnterpreneurListForBusinessPlanAdapter(Context mContext, Activity mActivity, ArrayList<CreateEnterpreneurModel.DataBean> enterpreneurList) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.enterpreneurList = enterpreneurList;

        mSessionManager = new SessionManager(mActivity);
        mSessionManager.openSettings();

        //Simple reverse collection list
        Collections.reverse(this.enterpreneurList);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtEnterpreneurName, txtEnterpriseName, txtEnrollDate, txtEnterpriseType, txtCreateBusinessPlan;

        public ViewHolder(View mView) {

            super(mView);
            txtEnterpreneurName = (TextView) mView.findViewById(R.id.txtEnterpreneurName);
            txtEnterpriseType = (TextView) mView.findViewById(R.id.txtEnterpriseType);
            txtEnrollDate = (TextView) mView.findViewById(R.id.txtEnrollDate);
            txtEnterpriseName = (TextView) mView.findViewById(R.id.txtEnterpriseName);
            txtCreateBusinessPlan = (TextView) mView.findViewById(R.id.txtCreateBusinessPlan);
        }
    }

    @Override
    public EnterpreneurListForBusinessPlanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_enterpreneur_list_for_business_plan_adapter, parent, false);

        view.setTag(viewHolder);
        viewHolder = new EnterpreneurListForBusinessPlanAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final EnterpreneurListForBusinessPlanAdapter.ViewHolder holder, final int position) {

        holder.txtEnterpreneurName.setText("" + enterpreneurList.get(position).getFirstName() + " " + enterpreneurList.get(position).getMiddleName() + " " + enterpreneurList.get(position).getLastName());
        holder.txtEnrollDate.setText("" + mActivity.getResources().getString(R.string.strEnrollmentDate) + " : " + CommonMethods.getDateFromLong(enterpreneurList.get(position).getEnrollmentDate()));
        holder.txtEnterpriseName.setText("" + mActivity.getResources().getString(R.string.strEnterpriseName) + " : " + enterpreneurList.get(position).getNameOfEntereprise());

        if (enterpreneurList.get(position).getEnterpriseType().equalsIgnoreCase("1")) {
            holder.txtEnterpriseType.setText("" + mActivity.getResources().getString(R.string.strEnterpriseType) + " : " + mActivity.getResources().getString(R.string.strExisting));
            holder.txtEnterpriseName.setVisibility(View.VISIBLE);
        } else {
            holder.txtEnterpriseType.setText("" + mActivity.getResources().getString(R.string.strEnterpriseType) + " : " + mActivity.getResources().getString(R.string.strNew));
            holder.txtEnterpriseName.setVisibility(View.INVISIBLE);
        }

        holder.txtCreateBusinessPlan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //SET ENTERPRENEUR NAME DYNAMIC
                //UPDATE ENTERPRENEUR NAME WHICH WE USE FOR DISPLAY PURPOSE
                mSessionManager.updatePreferenceString(Constants.ENTERPRENEUR_NAME_AS_A_HINT , ""+enterpreneurList.get(position).getFirstName()+ " " +enterpreneurList.get(position).getMiddleName()+" "+ enterpreneurList.get(position).getLastName());
                MainActivity.setDynmaicEnterpreneurName(mSessionManager.getPreference(Constants.ENTERPRENEUR_NAME_AS_A_HINT));

                //Call navigation controler
                //Add data in to bundle and send it to the details screen for displaying purpose only
                NavController navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ENTERPRENEUR_ID, "" + enterpreneurList.get(position).getEnterpreneurID());
                bundle.putString(Constants.ENTERPRISE_TYPE , ""+ enterpreneurList.get(position).getEnterpriseType());
                bundle.putString(Constants.TYPE_OF_ENTERPRISE , ""+ enterpreneurList.get(position).getTypeOfEnterprise());
                navController.navigate(R.id.businessPlanCreationOptions, bundle);
            }
        });

    }

    @Override
    public int getItemCount() {

        return enterpreneurList.size();
    }

}
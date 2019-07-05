package com.triapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.Models.EnterpreneurTrainingDetailsModel;
import com.triapp.Models.EnterpriseRegistrationModel;
import com.triapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class RegisteredEnterprisListAdapter extends RecyclerView.Adapter<RegisteredEnterprisListAdapter.ViewHolder> {



    private View view;
    private Context mContext;
    private Activity mActivity;
    private ArrayList<EnterpriseRegistrationModel> mEnterpriseRegistrationModelList = new ArrayList<>();
    private RegisteredEnterprisListAdapter.ViewHolder viewHolder;
    private NavController navController;

    public RegisteredEnterprisListAdapter(Context mContext, Activity mActivity, ArrayList<EnterpriseRegistrationModel> mEnterpriseRegistrationModelList) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mEnterpriseRegistrationModelList=mEnterpriseRegistrationModelList;

        //Simple reverse collection list
        Collections.reverse(this.mEnterpriseRegistrationModelList);

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtEnterpriseName ,txtEnterpreneurName ,txtTrackEnterprise,txtStartingDate;

        public ViewHolder(View mView) {

            super(mView);
            txtEnterpriseName = (TextView) mView.findViewById(R.id.txtEnterpriseName);
            txtEnterpreneurName = (TextView) mView.findViewById(R.id.txtEnterpreneurName);
            txtStartingDate = (TextView) mView.findViewById(R.id.txtStartingDate);
            txtTrackEnterprise = (TextView) mView.findViewById(R.id.txtTrackEnterprise);

        }
    }

    @Override
    public RegisteredEnterprisListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_enterprise_registered_list_adapter, parent, false);

        view.setTag(viewHolder);
        viewHolder = new RegisteredEnterprisListAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RegisteredEnterprisListAdapter.ViewHolder holder, final int position) {

        //holder.txtfarmernameAndAddress.setText(tempArrayList.get(position).getFarmerName() + tempArrayList.get(position).getFarmerAddress());
        holder.txtEnterpriseName.setText(""+mEnterpriseRegistrationModelList.get(position).getEnterpriseName());
        holder.txtEnterpreneurName.setText(""+mEnterpriseRegistrationModelList.get(position).getEnterpreneurName());
        holder.txtStartingDate.setText(mContext.getResources().getString(R.string.strEnterpriseStaringDate)+" : "+CommonMethods.getDateFromLong(mEnterpriseRegistrationModelList.get(position).getEnterpriseStartingDate()));

        holder.txtTrackEnterprise.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ENTERPRENEUR_ID, ""+mEnterpriseRegistrationModelList.get(position).getEnterpreneurID());
                bundle.putString(Constants.ENTERPRISE_ID, ""+mEnterpriseRegistrationModelList.get(position).getEnterpriseID());
                bundle.putString(Constants.ENTERPRISE_NAME, ""+mEnterpriseRegistrationModelList.get(position).getEnterpriseName());
                bundle.putString(Constants.VILLAGE_ID, ""+mEnterpriseRegistrationModelList.get(position).getVillageID());
                bundle.putString(Constants.ENTERPRENEUR_NAME_AS_A_HINT, ""+mEnterpriseRegistrationModelList.get(position).getEnterpreneurName());
                navController.navigate(R.id.trackYourEnterprises, bundle);
            }
        });


    }


    @Override
    public int getItemCount() {

        return mEnterpriseRegistrationModelList.size();
    }

}
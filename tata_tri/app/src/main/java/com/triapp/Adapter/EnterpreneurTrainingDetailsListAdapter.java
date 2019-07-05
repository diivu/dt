package com.triapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.Models.EnterpreneurTrainingDetailsModel;
import com.triapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class EnterpreneurTrainingDetailsListAdapter extends RecyclerView.Adapter<EnterpreneurTrainingDetailsListAdapter.ViewHolder> {



    private View view;
    private Context mContext;
    private Activity mActivity;
    private List<EnterpreneurTrainingDetailsModel.DataBean> enterpreneurTrainingDetailList = new ArrayList<>();
    private EnterpreneurTrainingDetailsListAdapter.ViewHolder viewHolder;
    private NavController navController;

    public EnterpreneurTrainingDetailsListAdapter(Context mContext, Activity mActivity, ArrayList<EnterpreneurTrainingDetailsModel.DataBean> enterpreneurTrainingDetailList) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.enterpreneurTrainingDetailList=enterpreneurTrainingDetailList;

        //Simple reverse collection list
       //Collections.reverse(this.enterpreneurTrainingDetailList);

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtTrainingName ,txtStartDate ,txtEndDate;

        public ViewHolder(View mView) {

            super(mView);
            txtTrainingName = (TextView) mView.findViewById(R.id.txtTrainingName);
            txtStartDate = (TextView) mView.findViewById(R.id.txtStartDate);
            txtEndDate = (TextView) mView.findViewById(R.id.txtEndDate);

        }
    }

    @Override
    public EnterpreneurTrainingDetailsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_enterpreneur_training_details_list_adapter, parent, false);

        view.setTag(viewHolder);
        viewHolder = new EnterpreneurTrainingDetailsListAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final EnterpreneurTrainingDetailsListAdapter.ViewHolder holder, final int position) {

        //holder.txtfarmernameAndAddress.setText(tempArrayList.get(position).getFarmerName() + tempArrayList.get(position).getFarmerAddress());
        holder.txtTrainingName.setText(""+enterpreneurTrainingDetailList.get(position).getTrainingName());
        holder.txtStartDate.setText(mActivity.getResources().getString(R.string.strStartDate)+" : "+CommonMethods.getDateFromLong(enterpreneurTrainingDetailList.get(position).getTrainingStartDate()));
        holder.txtEndDate.setText(mActivity.getResources().getString(R.string.strEndtDate)+" : "+CommonMethods.getDateFromLong(enterpreneurTrainingDetailList.get(position).getTrainingEndDate()));

        holder.txtTrainingName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                //Call navigation controler
                //Add data in to bundle and send it to the details screen for EDIT purpose only
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putBoolean(Constants.IS_FOR_EDIT , true);
                bundle.putString(Constants.ENTERPRENEUR_ID, ""+enterpreneurTrainingDetailList.get(position).getEntrepreneurId());
                bundle.putSerializable(Constants.ARRAY_LIST_DATA , enterpreneurTrainingDetailList.get(position));
                navController.navigate(R.id.enterprenuerTrainingDetails, bundle);
            }
        });


    }


    @Override
    public int getItemCount() {

        return enterpreneurTrainingDetailList.size();
    }

}
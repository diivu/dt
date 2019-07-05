package com.triapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.triapp.Activities.MainActivity;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class RegisteredEnterpreneurListAdapter extends RecyclerView.Adapter<RegisteredEnterpreneurListAdapter.ViewHolder> {


    private final SessionManager mSessionManager;
    private final DatabaseHelper mDatabaseHelper;
    private View view;
    private Context mContext;
    private Activity mActivity;
    private List<CreateEnterpreneurModel.DataBean> enterpreneurList = new ArrayList<>();
    private RegisteredEnterpreneurListAdapter.ViewHolder viewHolder;
    private NavController navController;

    public RegisteredEnterpreneurListAdapter(Context mContext, Activity mActivity, ArrayList<CreateEnterpreneurModel.DataBean> enterpreneurList) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.enterpreneurList=enterpreneurList;

        mSessionManager =new SessionManager(mContext);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(this.mContext);
        mDatabaseHelper.open();


        //Simple reverse collection list
         Collections.reverse(this.enterpreneurList);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtVillageName,txtEnterpreneurName ,txtEnterpriseName,txtEnrollDate,txtEnterpriseType;
        private final RelativeLayout relativeItemClick;

        public ViewHolder(View mView) {

            super(mView);
            txtEnterpreneurName = (TextView) mView.findViewById(R.id.txtEnterpreneurName);
            txtEnterpriseType = (TextView) mView.findViewById(R.id.txtEnterpriseType);
            txtEnrollDate = (TextView) mView.findViewById(R.id.txtEnrollDate);
            txtEnterpriseName = (TextView) mView.findViewById(R.id.txtEnterpriseName);
            txtVillageName = (TextView) mView.findViewById(R.id.txtVillageName);

            relativeItemClick=(RelativeLayout)mView.findViewById(R.id.relativeItemClick);

        }
    }

    @Override
    public RegisteredEnterpreneurListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_registered_enterpreneur_list_adapter, parent, false);

        view.setTag(viewHolder);
        viewHolder = new RegisteredEnterpreneurListAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RegisteredEnterpreneurListAdapter.ViewHolder holder, final int position) {

        //holder.txtfarmernameAndAddress.setText(tempArrayList.get(position).getFarmerName() + tempArrayList.get(position).getFarmerAddress());
        holder.txtEnterpreneurName.setText(""+enterpreneurList.get(position).getFirstName()+" "+enterpreneurList.get(position).getMiddleName() +" "+enterpreneurList.get(position).getLastName());
        holder.txtEnrollDate.setText(""+mActivity.getResources().getString(R.string.strEnrollmentDate) +" : "+ CommonMethods.getDateFromLong(enterpreneurList.get(position).getEnrollmentDate()));
        holder.txtEnterpriseName.setText(""+mActivity.getResources().getString(R.string.strEnterpriseName)+" : "+enterpreneurList.get(position).getNameOfEntereprise());
        holder.txtVillageName.setText(""+mDatabaseHelper.getVillegeDataFromID(enterpreneurList.get(position).getVillegeID()).get(0).getVillegeName());

        if(enterpreneurList.get(position).getEnterpriseType().equalsIgnoreCase("1")){
            holder.txtEnterpriseType.setText(""+mActivity.getResources().getString(R.string.strEnterpriseType) +" : "+mActivity.getResources().getString(R.string.strExisting));
            holder.txtEnterpriseName.setVisibility(View.VISIBLE);
        }else {
            holder.txtEnterpriseType.setText(""+mActivity.getResources().getString(R.string.strEnterpriseType) +" : "+mActivity.getResources().getString(R.string.strNew));
            holder.txtEnterpriseName.setVisibility(View.GONE);
        }

        holder.relativeItemClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //SET ENTERPRENEUR NAME DYNAMIC
                MainActivity.setDynmaicEnterpreneurName(enterpreneurList.get(position).getFirstName()+ " " +enterpreneurList.get(position).getMiddleName()+" "+ enterpreneurList.get(position).getLastName());

                //Call navigation controler
                //Add data in to bundle and send it to the details screen for displaying purpose only
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ENTERPRENEUR_ID, ""+enterpreneurList.get(position).getEnterpreneurID());
                navController.navigate(R.id.enterprenuerDetails, bundle);
            }
        });


    }


    @Override
    public int getItemCount() {

        return enterpreneurList.size();
    }

}
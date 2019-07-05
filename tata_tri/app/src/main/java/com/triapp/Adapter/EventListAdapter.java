package com.triapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.triapp.Activities.MainActivity;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CampaignDataModel;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {


    private final SessionManager mSessionManager;
    private View view;
    private Context mContext;
    private Activity mActivity;
    private EventListAdapter.ViewHolder viewHolder;
    private ArrayList<CampaignDataModel> campaignData = new ArrayList<>();


    public EventListAdapter(Context mContext, Activity mActivity,  ArrayList<CampaignDataModel> campaignData) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.campaignData= campaignData;

        mSessionManager = new SessionManager(mActivity);
        mSessionManager.openSettings();

        //Simple reverse collection list
        Collections.reverse(this.campaignData);

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtEventName, txtEventDate, txtAddress, txtAddMember;

        public ViewHolder(View mView) {

            super(mView);
            txtEventName = (TextView) mView.findViewById(R.id.txtEventName);
            txtAddress = (TextView) mView.findViewById(R.id.txtAddress);
            txtEventDate = (TextView) mView.findViewById(R.id.txtEventDate);
            txtAddMember = (TextView) mView.findViewById(R.id.txtAddMember);
        }
    }

    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_event_list, parent, false);

        view.setTag(viewHolder);
        viewHolder = new EventListAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final EventListAdapter.ViewHolder holder, final int position) {

        holder.txtEventName.setText(""+campaignData.get(position).getCampaignName());
        holder.txtAddress.setText("" +mActivity.getResources().getString(R.string.strCampaignAddress) + " : " + campaignData.get(position).getCampaignAddress());
        holder.txtEventDate.setText("" + mActivity.getResources().getString(R.string.strCampaignDate) + " : " + CommonMethods.getDateFromLong(campaignData.get(position).getCampaignDate()));


        holder.txtAddMember.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    //Call navigation controler
                    //Add data in to bundle and send it to the details screen for displaying purpose only
                    NavController navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.EVENT_NAME, "" +campaignData.get(position).getCampaignName());
                    bundle.putString(Constants.EVENT_ID, "" + campaignData.get(position).getCampaignID());
                    navController.navigate(R.id.addEventMemberFragment, bundle);
            }
        });

    }

    @Override
    public int getItemCount() {

        return campaignData.size();
    }

}
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
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CampaignDataModel;
import com.triapp.Models.EventMemberModel;
import com.triapp.R;

import java.util.ArrayList;
import java.util.Collections;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class EventMemberListAdapter extends RecyclerView.Adapter<EventMemberListAdapter.ViewHolder> {


    private final SessionManager mSessionManager;
    private View view;
    private Context mContext;
    private Activity mActivity;
    private EventMemberListAdapter.ViewHolder viewHolder;
    private ArrayList<EventMemberModel> eventDataList = new ArrayList<>();


    public EventMemberListAdapter(Context mContext, Activity mActivity, ArrayList<EventMemberModel> eventDataList) {

        this.mContext = mContext;
        this.mActivity = mActivity;
        this.eventDataList= eventDataList;

        mSessionManager = new SessionManager(mActivity);
        mSessionManager.openSettings();

        //Simple reverse collection list
        Collections.reverse(this.eventDataList);

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txtMemberName, txtBirthDate, txtMobileNumber;

        public ViewHolder(View mView) {

            super(mView);
            txtMemberName = (TextView) mView.findViewById(R.id.txtMemberName);
            txtMobileNumber = (TextView) mView.findViewById(R.id.txtMobileNumber);
            txtBirthDate = (TextView) mView.findViewById(R.id.txtBirthDate);

        }
    }

    @Override
    public EventMemberListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = LayoutInflater.from(mActivity).inflate(R.layout.raw_event_member_list, parent, false);

        view.setTag(viewHolder);
        viewHolder = new EventMemberListAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final EventMemberListAdapter.ViewHolder holder, final int position) {

        holder.txtMemberName.setText(""+eventDataList.get(position).getMemberName());
        holder.txtMobileNumber.setText("" +mActivity.getResources().getString(R.string.strMemberMobileNumber) + " : " + eventDataList.get(position).getMemberPhoneNumber());
        holder.txtBirthDate.setText("" + mActivity.getResources().getString(R.string.strMemberBirthDate) + " : " + CommonMethods.getDateFromLong(eventDataList.get(position).getMemberBirthdate()));

    }

    @Override
    public int getItemCount() {

        return eventDataList.size();
    }

}
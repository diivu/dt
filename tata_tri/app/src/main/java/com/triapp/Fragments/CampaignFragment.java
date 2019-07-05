package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
import com.triapp.Adapter.EnterpreneurListForBusinessPlanAdapter;
import com.triapp.Adapter.EventListAdapter;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CampaignFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "CampaignFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private RecyclerView recycleCampaignList;
    private TextView txtHintMsg;
    private FloatingActionButton fabCreatCampaign;
    private LinearLayoutManager recylerViewLayoutManager;
    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strCreatedCampaign));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.campaign_fragment, container, false);

        setIds();
        setOnClicks();


        return mView;


    }


    @Override
    public void onResume() {

        //Create Adapter list for display event list
        EventListAdapter mEventListAdapter = new EventListAdapter(mContext, mActivity,mDatabaseHelper.getCampaignData());
        recycleCampaignList.setAdapter(mEventListAdapter);

        //DISPLAY NO ENTERPRENUER EVENT MSG
        if(mDatabaseHelper.getCampaignData().size() == 0){
            recycleCampaignList.setVisibility(View.GONE);
            txtHintMsg.setVisibility(View.VISIBLE);

        }else {
            recycleCampaignList.setVisibility(View.VISIBLE);
            txtHintMsg.setVisibility(View.GONE);
        }

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName("");


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

        recycleCampaignList = (RecyclerView) mView.findViewById(R.id.recycleCampaignList);

        txtHintMsg = (TextView) mView.findViewById(R.id.txtHintMsg);

        fabCreatCampaign = (FloatingActionButton) mView.findViewById(R.id.fabCreatCampaign);

        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycleCampaignList.setLayoutManager(recylerViewLayoutManager);

    }
    private void setOnClicks() {

        fabCreatCampaign.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.fabCreatCampaign:

                //Open new enterprenuer creat fragment
                navController.navigate(R.id.createCampaignFragment);

                break;
        }

    }
}

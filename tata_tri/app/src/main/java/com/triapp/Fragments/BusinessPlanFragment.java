package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
import com.triapp.Adapter.CreatedBusinessPlanListAdapter;
import com.triapp.Adapter.EnterpreneurTrainingDetailsListAdapter;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.Models.SaveEnterpriseModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BusinessPlanFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "BusinessPlanFragment";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private SessionManager mSessionManager;
    private LinearLayoutManager recylerViewLayoutManager;
    private RecyclerView recycleCreatedBusinessPlanList;
    private FloatingActionButton fabCreateBusinessPlanNew;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<SaveEnterpriseModel> mFilteredEnterpreneurList = new ArrayList<>();
    private TextView txtHintMsg;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).setTitle(getResources().getString(R.string.strBusinessPlan));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);

        mView = inflater.inflate(R.layout.business_plan_fragment, container, false);

        setIds();
        setOnClicks();


        return mView;

    }


    @Override
    public void onResume() {

        //CLEAR OLD DATA
        mFilteredEnterpreneurList.clear();

        //FILATER ENTERPRENEUR LIST BY FLAG
        //FLAG 1 = BUSINESS PLAN ALREADY CREATED
        for (int i = 0 ; i < mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().size() ; i ++ ){
            if(mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i).getFlag() == 1){
                mFilteredEnterpreneurList.add(mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i));
            }
        }

        //Create Adapter list for display registered enterpreneur
        CreatedBusinessPlanListAdapter mEnterpreneurListForBusinessPlanAdapter = new CreatedBusinessPlanListAdapter(mContext, mActivity,mFilteredEnterpreneurList);
        recycleCreatedBusinessPlanList.setAdapter(mEnterpreneurListForBusinessPlanAdapter);


        //DISPLAY NO ENTERPRENUER REGISTERD MSG
        if(mFilteredEnterpreneurList.size() == 0){
            recycleCreatedBusinessPlanList.setVisibility(View.GONE);
            txtHintMsg.setVisibility(View.VISIBLE);
        }else {
            recycleCreatedBusinessPlanList.setVisibility(View.VISIBLE);
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

        txtHintMsg = (TextView)mView.findViewById(R.id.txtHintMsg);

        fabCreateBusinessPlanNew = (FloatingActionButton) mView.findViewById(R.id.fabCreateBusinessPlanNew);

        recycleCreatedBusinessPlanList = (RecyclerView) mView.findViewById(R.id.recycleCreatedBusinessPlanList);
        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycleCreatedBusinessPlanList.setLayoutManager(recylerViewLayoutManager);

        //Initialize navigation controll
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


    }


    private void setOnClicks() {

        fabCreateBusinessPlanNew.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.fabCreateBusinessPlanNew:

                //OPEN LIST OF ENTERPRENEUR WHO WANTS TO CREATE THAIR BUSINESS PLAN
                navController.navigate(R.id.enterpreneurListForBusinessPlan);

                break;
        }

    }
}

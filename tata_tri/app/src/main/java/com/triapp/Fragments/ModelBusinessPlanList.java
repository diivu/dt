package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
import com.triapp.Adapter.ModelBusinessPlanListAdapter;
import com.triapp.Adapter.EnterpreneurListForBusinessPlanAdapter;
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

public class ModelBusinessPlanList extends Fragment {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "ModelBusinessPlanList";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;

    private LinearLayoutManager recylerViewLayoutManager;
    private RecyclerView recycleRegisteredEnterneurList;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<SaveEnterpriseModel> mFilteredEnterpreneurList = new ArrayList<>();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).setTitle(getResources().getString(R.string.strModelBusinessPlanFor));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.model_business_plan_list, container, false);

        setIds();


        return mView;


    }

    @Override
    public void onResume() {

        //CLEAR OLD DATA
        mFilteredEnterpreneurList.clear();


        //FILATER ENTERPRENEUR LIST BY FLAG
        //FLAG 1 = BUSINESS PLAN ALREADY CREATED
        for (int i = 0 ; i < mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().size() ; i ++ ){
            if(mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i).getIsBusinessPlanSubmited() == 1 && mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i).getIsModelBusinessPlan() == 1 && mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i).getType().equalsIgnoreCase(getArguments().getString(Constants.TYPE_OF_ENTERPRISE))){
                mFilteredEnterpreneurList.add(mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i));
            }
        }

        //Create Adapter list for display registered enterpreneur
        ModelBusinessPlanListAdapter mModelBusinessPlanListAdapter = new ModelBusinessPlanListAdapter(mContext, mActivity,mFilteredEnterpreneurList ,true ,getArguments().getString(Constants.ENTERPRENEUR_ID) , getArguments().getString(Constants.TYPE_OF_ENTERPRISE));
        recycleRegisteredEnterneurList.setAdapter(mModelBusinessPlanListAdapter);

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName(mSessionManager.getPreference(Constants.ENTERPRENEUR_NAME_AS_A_HINT));



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

        recycleRegisteredEnterneurList = (RecyclerView) mView.findViewById(R.id.recycleRegisteredEnterneurList);
        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycleRegisteredEnterneurList.setLayoutManager(recylerViewLayoutManager);


    }


}

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
import com.triapp.Adapter.RegisteredEnterpreneurListAdapter;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
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

public class EnterprenuerListForBusinessPlanFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "EnterprenuerListForBusinessPlanFragment";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private SessionManager mSessionManager;
    private LinearLayoutManager recylerViewLayoutManager;
    private RecyclerView recycleRegisteredEnterneurList;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<CreateEnterpreneurModel.DataBean> mFilteredEnterpreneurList = new ArrayList<>();
    private TextView txtHintMsg;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).setTitle(getResources().getString(R.string.strEnterpreneurList));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);

        mView = inflater.inflate(R.layout.enterprenuer_list, container, false);

        setIds();

        return mView;

    }

    @Override
    public void onResume() {

        //CLEAR OLD DATA
        mFilteredEnterpreneurList.clear();

        //FILATER ENTERPRENEUR LIST BY FLAG
        //IS BUSINESS PLAN CREATED THEN REMOVE
        for (int i = 0 ; i < mDatabaseHelper.getEnterpreneurList(0L).size() ; i ++ ){
            if(mDatabaseHelper.getEnterpreneurList(0L).get(i).getIsBusinessPlanCreated() == 0){
                mFilteredEnterpreneurList.add(mDatabaseHelper.getEnterpreneurList(0L).get(i));
            }
        }

        //Create Adapter list for display registered enterpreneur
        EnterpreneurListForBusinessPlanAdapter mEnterpreneurListForBusinessPlanAdapter = new EnterpreneurListForBusinessPlanAdapter(mContext, mActivity,mFilteredEnterpreneurList);
        recycleRegisteredEnterneurList.setAdapter(mEnterpreneurListForBusinessPlanAdapter);

        //DISPLAY NO ENTERPRENUER REGISTERD MSG
        if(mFilteredEnterpreneurList.size() == 0){
            recycleRegisteredEnterneurList.setVisibility(View.GONE);
            txtHintMsg.setVisibility(View.VISIBLE);

        }else {
            recycleRegisteredEnterneurList.setVisibility(View.VISIBLE);
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

        recycleRegisteredEnterneurList = (RecyclerView) mView.findViewById(R.id.recycleRegisteredEnterneurList);
        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycleRegisteredEnterneurList.setLayoutManager(recylerViewLayoutManager);

        //Initialize navigation controll
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


    }

}

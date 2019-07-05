package com.triapp.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.triapp.Adapter.EnterpreneurTrainingDetailsListAdapter;
import com.triapp.Adapter.RegisteredEnterpreneurListAdapter;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EnterprenuerTrainingListFragment extends Fragment implements View.OnClickListener{

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "EnterprenuerTrainingListFragment";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private SessionManager mSessionManager;
    private LinearLayoutManager recylerViewLayoutManager;
    private RecyclerView recycledEnterneurTrainingList;
    private FloatingActionButton fabCreatTraining;
    private DatabaseHelper mDatabaseHelper;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).setTitle(getResources().getString(R.string.strTrainingDetails));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.enterprenuer_training_list, container, false);

        setIds();
        setOnClicks();


        return mView;

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void setIds() {

       //getArguments().getString(Constants.ENTERPRENEUR_ID)

        mActivity = getActivity();
        mContext = getActivity();

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

        fabCreatTraining = (FloatingActionButton) mView.findViewById(R.id.fabCreatTraining);

        recycledEnterneurTrainingList = (RecyclerView) mView.findViewById(R.id.recycledEnterneurTrainingList);
        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycledEnterneurTrainingList.setLayoutManager(recylerViewLayoutManager);

        //Initialize navigation controll
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


        //Create Adapter list for display registered enterpreneur
        EnterpreneurTrainingDetailsListAdapter mEnterpreneurTrainingDetailsListAdapter = new EnterpreneurTrainingDetailsListAdapter(mContext, mActivity, mDatabaseHelper.getTrainingDetailsByEntreprenuerId(getArguments().getString(Constants.ENTERPRENEUR_ID)));
        recycledEnterneurTrainingList.setAdapter(mEnterpreneurTrainingDetailsListAdapter);

    }


    private void setOnClicks() {

        fabCreatTraining.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.fabCreatTraining:

                //pen new enterprenuer Training details fragment
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundleTrainingDetails = new Bundle();
                bundleTrainingDetails.putString(Constants.ENTERPRENEUR_ID, ""+getArguments().getString(Constants.ENTERPRENEUR_ID));
                navController.navigate(R.id.enterprenuerTrainingDetails, bundleTrainingDetails);

                break;
        }

    }


}

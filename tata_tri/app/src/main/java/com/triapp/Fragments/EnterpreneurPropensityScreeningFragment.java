package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;
import com.triapp.SqliteDatabase.DatabaseManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EnterpreneurPropensityScreeningFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "HomeFragment";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private RecyclerView recycleActiveAI;
    private LinearLayoutManager recylerViewLayoutManager;
    private SessionManager mSessionManager;
    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).setTitle("");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(getResources().getDrawable(R.drawable.live_logo));
        mView = inflater.inflate(R.layout.enterpreneur_propensity_screening_fragment, container, false);

        setIds();


        return mView;


    }

    @Override
    public void onResume() {
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

    }


}

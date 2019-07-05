package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.triapp.Adapter.RegisteredEnterpreneurListAdapter;
import com.triapp.CommonClasse.CommonMethods;
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

public class EnterprenuersMoreDetailsFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "EnterprenuersMoreDetailsFragment";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private SessionManager mSessionManager;
    private DatabaseHelper mDatabaseHelper;
    private LinearLayout linearEditProfile, linearEnterpeneurTrainingDetails, linearEnterpreneurPropensity, linearExistingEnterpriseDetails, linearExpenditureDetails, linearCreditProfile, linearIncomeProfile, linearFamilyProfile, linearEducationAndWorkProfile;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strEnterpreneurProfile));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.enterpreneur_more_details, container, false);

        setIds();
        setOnClicks();

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

        //Initialize navigation controll
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        CommonMethods.printLog("ENTERPRENEUR_ID", getArguments().getString(Constants.ENTERPRENEUR_ID));

        linearEducationAndWorkProfile = (LinearLayout) mView.findViewById(R.id.linearEducationAndWorkProfile);
        linearIncomeProfile = (LinearLayout) mView.findViewById(R.id.linearIncomeProfile);
        linearExpenditureDetails = (LinearLayout) mView.findViewById(R.id.linearExpenditureDetails);
        linearExistingEnterpriseDetails = (LinearLayout) mView.findViewById(R.id.linearExistingEnterpriseDetails);
        linearEnterpreneurPropensity = (LinearLayout) mView.findViewById(R.id.linearEnterpreneurPropensity);
        linearEnterpeneurTrainingDetails = (LinearLayout) mView.findViewById(R.id.linearEnterpeneurTrainingDetails);
        linearEditProfile = (LinearLayout) mView.findViewById(R.id.linearEditProfile);


    }


    private void setOnClicks() {

        linearEducationAndWorkProfile.setOnClickListener(this);
        linearIncomeProfile.setOnClickListener(this);
        linearExpenditureDetails.setOnClickListener(this);
        linearExistingEnterpriseDetails.setOnClickListener(this);
        linearEnterpreneurPropensity.setOnClickListener(this);
        linearEnterpeneurTrainingDetails.setOnClickListener(this);
        linearEditProfile.setOnClickListener(this);
    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.linearEducationAndWorkProfile:

                //Call navigation controler
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ENTERPRENEUR_ID, ""+getArguments().getString(Constants.ENTERPRENEUR_ID));
                navController.navigate(R.id.enterprenuerEducationAndWorkProfile, bundle);

                break;

            case R.id.linearEnterpeneurTrainingDetails:

                //Call navigation controler
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundleTrainingDetails = new Bundle();
                bundleTrainingDetails.putString(Constants.ENTERPRENEUR_ID, ""+getArguments().getString(Constants.ENTERPRENEUR_ID));
                navController.navigate(R.id.enterprenuerTrainingDetailsList, bundleTrainingDetails);

                break;

            case R.id.linearEditProfile:

                //Call navigation controler
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundleEditProfile = new Bundle();
                bundleEditProfile.putBoolean(Constants.IS_FOR_EDIT , true);
                bundleEditProfile.putString(Constants.ENTERPRENEUR_ID, ""+getArguments().getString(Constants.ENTERPRENEUR_ID));
                navController.navigate(R.id.creatEnterpreneur, bundleEditProfile);

                break;

            case R.id.linearExistingEnterpriseDetails:

                //Call navigation controler
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundleExistingEnterprise = new Bundle();
                bundleExistingEnterprise.putString(Constants.ENTERPRENEUR_ID, ""+getArguments().getString(Constants.ENTERPRENEUR_ID));
                navController.navigate(R.id.existingEnterpriseDetails, bundleExistingEnterprise);

                break;

            case R.id.linearExpenditureDetails:

                //CHECK IF ENTERPRENEUR DATA AVAILABLE IN DATABASE
                boolean isDataAvailable = false;
                if(mDatabaseHelper.getAllFamilyExpendituresList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0){
                    isDataAvailable = true;
                }else {
                    isDataAvailable = false;
                }

                //Call navigation controler
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundleExpenditure = new Bundle();
                bundleExpenditure.putString(Constants.ENTERPRENEUR_ID, ""+getArguments().getString(Constants.ENTERPRENEUR_ID));
                bundleExpenditure.putBoolean(Constants.IS_FOR_EDIT , isDataAvailable);
                navController.navigate(R.id.familyExpenditureDetails, bundleExpenditure);

                break;

            case R.id.linearIncomeProfile:

                //CHECK IF ENTERPRENEUR INCOME DATA AVAILABLE IN DATABASE
                boolean isDataAvailableForIncome = false;
                if(mDatabaseHelper.getAllEnterpreneurIncomeProfile(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0){
                    isDataAvailableForIncome = true;
                }else {
                    isDataAvailableForIncome = false;
                }

                //Call navigation controler
                navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                Bundle bundleIncomeProfile = new Bundle();
                bundleIncomeProfile.putString(Constants.ENTERPRENEUR_ID, ""+getArguments().getString(Constants.ENTERPRENEUR_ID));
                bundleIncomeProfile.putBoolean(Constants.IS_FOR_EDIT , isDataAvailableForIncome);
                navController.navigate(R.id.enterpreneurIncomeProfile, bundleIncomeProfile);

                break;

            case R.id.linearEnterpreneurPropensity:

                CommonMethods.displayToast(mContext ,getResources().getString(R.string.strPending));

                break;

        }

    }
}

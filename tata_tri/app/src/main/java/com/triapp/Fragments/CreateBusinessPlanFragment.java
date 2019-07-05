package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.layer_net.stepindicator.StepIndicator;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

public class CreateBusinessPlanFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "CreateBusinessPlanFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private ViewPager mViewPager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strCreateBusinessPlan));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.creat_business_plan_fragment, container, false);

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


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        //Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) mView.findViewById(R.id.viewPager);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);

        StepIndicator stepIndicator = (StepIndicator) mView.findViewById(R.id.stepIndicator);
        stepIndicator.setupWithViewPager(mViewPager);

        // Enable | Disable click on step number
        stepIndicator.setClickable(true);


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return BusinessPlanStepOneFragment.newInstance(position + 1, getArguments().getString(Constants.ENTERPRENEUR_ID) ,getArguments().getString(Constants.TYPE_OF_ENTERPRISE));
            } else if (position == 1) {
                return BusinessPlanStepTwoFragment.newInstance(position + 1, getArguments().getString(Constants.ENTERPRENEUR_ID));
            } else if (position == 2) {
                return BusinessPlanStepThreeFragment.newInstance(position + 1, getArguments().getString(Constants.ENTERPRENEUR_ID));
            } else if (position == 3) {
                return BusinessPlanStepFourFragment.newInstance(position + 1, getArguments().getString(Constants.ENTERPRENEUR_ID));
            } else {
                return BusinessPlanStepOneFragment.newInstance(position + 1, getArguments().getString(Constants.ENTERPRENEUR_ID) ,getArguments().getString(Constants.TYPE_OF_ENTERPRISE));
            }


        }

        @Override
        public int getCount() {
            return 4;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "SECTION " + (position + 1);
        }
    }

}



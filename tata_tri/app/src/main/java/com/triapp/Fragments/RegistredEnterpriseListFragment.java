package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
import com.triapp.Adapter.RegisteredEnterprisListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
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

public class RegistredEnterpriseListFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "RegistredEnterpriseListFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private RecyclerView recycleRegisteredEnterprises;
    private TextView txtHintMsg;
    private FloatingActionButton fabRegisteredEnterprise;
    private LinearLayoutManager recylerViewLayoutManager;
    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).setTitle(getResources().getString(R.string.strRegistredEnterprises));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.registered_enterprises_fragment, container, false);

        setIds();
        setOnclicks();


        return mView;


    }


    @Override
    public void onResume() {

        //Create Adapter list for display registered enterpreneur
        RegisteredEnterprisListAdapter mRegisteredEnterprisListAdapter = new RegisteredEnterprisListAdapter(mContext, mActivity, mDatabaseHelper.getEnterpriseRegistrationDataByVillageID(Long.valueOf(getArguments().getString(Constants.VILLAGE_ID))));
        recycleRegisteredEnterprises.setAdapter(mRegisteredEnterprisListAdapter);

        //DISPLAY NO ENTERPRENUER REGISTERD MSG
        if(mDatabaseHelper.getEnterpriseRegistrationDataByVillageID(Long.valueOf(getArguments().getString(Constants.VILLAGE_ID))).size() == 0){
            recycleRegisteredEnterprises.setVisibility(View.GONE);
            txtHintMsg.setVisibility(View.VISIBLE);
        }else{
            recycleRegisteredEnterprises.setVisibility(View.VISIBLE);
            txtHintMsg.setVisibility(View.GONE);
        }

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

        recycleRegisteredEnterprises = (RecyclerView)mView.findViewById(R.id.recycleRegisteredEnterprises);
        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycleRegisteredEnterprises.setLayoutManager(recylerViewLayoutManager);

        txtHintMsg =(TextView)mView.findViewById(R.id.txtHintMsg);

        fabRegisteredEnterprise =(FloatingActionButton)mView.findViewById(R.id.fabRegisteredEnterprise);

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName(getArguments().getString(Constants.VILLAGE_NAME));

    }

    private void setOnclicks() {

        fabRegisteredEnterprise.setOnClickListener(this);
    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.fabRegisteredEnterprise:

                //CHCEK IF ANY ENTERPRISE LEFT FOR REGISTRATION
                ArrayList<CreateEnterpreneurModel.DataBean> mArrayList = mDatabaseHelper.getEnterpreneurListByVillageID(Long.valueOf(getArguments().getString(Constants.VILLAGE_ID)));
                ArrayList<CreateEnterpreneurModel.DataBean> mFilteredArrayList = new ArrayList<>();

                if(mArrayList.size() != 0){

                    for(int i = 0 ; i< mArrayList.size() ; i++){

                        if(mArrayList.get(i).getIsBusinessPlanSubmitted() == 1 || mArrayList.get(i).getIsModelBusinessPlan() == 1){
                            if( mArrayList.get(i).getIsEnterpriseRegistred() == 0){
                                mFilteredArrayList.add(mArrayList.get(i));
                            }
                        }
                    }
                }

                if(mFilteredArrayList.size() != 0){
                    NavController navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.VILLAGE_NAME, "" + getArguments().getString(Constants.VILLAGE_NAME));
                    bundle.putString(Constants.VILLAGE_ID, "" + getArguments().getString(Constants.VILLAGE_ID));
                    navController.navigate(R.id.registereYourEnterprises, bundle);
                }else {
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strNoEnterpriseForThisVillage));
                }



                break;
        }

    }
}

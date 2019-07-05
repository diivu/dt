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
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
import com.triapp.Adapter.RegisteredEnterpreneurListAdapter;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RegisteredEnterprenuerFragment extends Fragment implements View.OnClickListener{

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "HomeFragment";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private SessionManager mSessionManager;
    private LinearLayoutManager recylerViewLayoutManager;
    private RecyclerView recycleRegisteredEnterneurList;
    private FloatingActionButton fabCreatEnterprenuer;
    private DatabaseHelper mDatabaseHelper;
    private TextView txtHintMsg;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).setTitle(getResources().getString(R.string.strRegistredEnterprnuer));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);

        mView = inflater.inflate(R.layout.registered_enterprenuer_list, container, false);

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

        txtHintMsg = (TextView)mView.findViewById(R.id.txtHintMsg);

        fabCreatEnterprenuer = (FloatingActionButton) mView.findViewById(R.id.fabCreatEnterprenuer);

        recycleRegisteredEnterneurList = (RecyclerView) mView.findViewById(R.id.recycleRegisteredEnterneurList);
        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycleRegisteredEnterneurList.setLayoutManager(recylerViewLayoutManager);

        //Initialize navigation controll
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


        //Create Adapter list for display registered enterpreneur
        RegisteredEnterpreneurListAdapter mRegisteredEnterpreneurListAdapter = new RegisteredEnterpreneurListAdapter(mContext, mActivity, mDatabaseHelper.getEnterpreneurList(0L));
        recycleRegisteredEnterneurList.setAdapter(mRegisteredEnterpreneurListAdapter);

        //DISPLAY NO ENTERPRENUER REGISTERD MSG
        if(mDatabaseHelper.getEnterpreneurList(0L).size() == 0){
            recycleRegisteredEnterneurList.setVisibility(View.GONE);
            txtHintMsg.setVisibility(View.VISIBLE);
        }else{
            recycleRegisteredEnterneurList.setVisibility(View.VISIBLE);
            txtHintMsg.setVisibility(View.GONE);
        }

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName("");


    }


    private void setOnClicks() {

        fabCreatEnterprenuer.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.fabCreatEnterprenuer:

                //Open new enterprenuer creat fragment
                navController.navigate(R.id.creatEnterpreneur);


                break;
        }

    }


}

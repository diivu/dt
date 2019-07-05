package com.triapp.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
import com.triapp.Adapter.VillageListAdapter;
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

public class EnterpriseTrackingFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "EnterpriseTrackingFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtNext,txtTitleSelectVillage;
    private EditText edtSelectVillage;
    private Dialog dialogVillege;
    private ListView listVillege;
    private VillageListAdapter mVillageListAdapter;
    private DatabaseHelper mDatabaseHelper;
    private Long lngVillegeID;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strEnterpriseTrackingTitle));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.enterprise_tracking_fragment, container, false);

        setIds();
        setOnclicks();


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

        txtTitleSelectVillage = (TextView) mView.findViewById(R.id.txtTitleSelectVillage);
        txtNext = (TextView) mView.findViewById(R.id.txtNext);

        edtSelectVillage = (EditText) mView.findViewById(R.id.edtSelectVillage);


        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName("");


    }

    private void setOnclicks() {

        edtSelectVillage.setOnClickListener(this);
        txtNext.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {


        switch (mView.getId()){

            case R.id.edtSelectVillage:

                openVillageListDialog();

                break;
            case R.id.txtNext:


                if(edtSelectVillage.getText().toString().length() != 0) {
                    NavController navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.VILLAGE_NAME, "" + edtSelectVillage.getText().toString());
                    bundle.putString(Constants.VILLAGE_ID, "" + String.valueOf(lngVillegeID));
                    navController.navigate(R.id.registeredEnterprises, bundle);
                }else {

                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidationVillege));
                }

                break;
        }
    }

    private void openVillageListDialog() {

        dialogVillege = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogVillege.setContentView(R.layout.general_list_search_dialog);

        dialogVillege.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogVillege.findViewById(R.id.imgBack);
        SearchView edtSearchView = (SearchView) dialogVillege.findViewById(R.id.edtSearchItem);

        int id = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) edtSearchView.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterVillegeName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setTextSize(14);

        int id1 = edtSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View v1 = edtSearchView.findViewById(id1);
        v1.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) edtSearchView.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listVillege = (ListView) dialogVillege.findViewById(R.id.listItems);
        mVillageListAdapter = new VillageListAdapter(mContext, mDatabaseHelper.getVillegeList());
        listVillege.setAdapter(mVillageListAdapter);

        edtSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mVillageListAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listVillege.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogVillege.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();
                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                edtSelectVillage.setText(strCasteFromSelection);
                lngVillegeID = Long.valueOf(tvStateId.getText().toString());

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogVillege.dismiss();
            }
        });

        dialogVillege.setCanceledOnTouchOutside(false);
        dialogVillege.setCancelable(true);
        dialogVillege.show();
    }
}

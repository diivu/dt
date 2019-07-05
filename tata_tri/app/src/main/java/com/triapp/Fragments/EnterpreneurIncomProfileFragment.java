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
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.triapp.Adapter.CurrentIncomeListAdapter;
import com.triapp.Adapter.IncomeListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.EnterpreneurIncomeProfileModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class EnterpreneurIncomProfileFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "EnterpreneurIncomProfileFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtSubmitData, txtSelfAnnualIncome, txtFamilyAnnualIncome;
    private EditText edtSelfIncome, edtFamilyIncome;
    private Dialog dialogIncomList;
    private ListView listIncome;
    private IncomeListAdapter mIncomeListAdapter;
    private Long lngFamilyIncome = 0L, lngSelfIncome = 0L;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<EnterpreneurIncomeProfileModel> mIncomeProfileList = new ArrayList<>();
    private boolean isBisinessPlanSubmitted;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getArguments().getBoolean(Constants.IS_FOR_EDIT)) {
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strUpdateIncomeProfile));
        } else {
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strIncomeProfile));
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.enterpreneur_income_profile, container, false);

        setIds();
        setOncliks();


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

        txtFamilyAnnualIncome = (TextView) mView.findViewById(R.id.txtFamilyAnnualIncome);
        txtSelfAnnualIncome = (TextView) mView.findViewById(R.id.txtSelfAnnualIncome);
        txtSubmitData = (TextView) mView.findViewById(R.id.txtSubmitData);

        edtFamilyIncome = (EditText) mView.findViewById(R.id.edtFamilyIncome);
        edtSelfIncome = (EditText) mView.findViewById(R.id.edtSelfIncome);

        //SET TITLES
        txtFamilyAnnualIncome.setText(CommonMethods.spannableString(getResources().getString(R.string.strFamilyAnnualIncome)));
        txtSelfAnnualIncome.setText(CommonMethods.spannableString(getResources().getString(R.string.strSelfAnnualIncome)));


        //GET ENTERPRENEUR INCOME PROFILE DATA
        mIncomeProfileList =mDatabaseHelper.getAllEnterpreneurIncomeProfile(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
        //INSERT UPDATE AS PER DATA AVAILABILITY
        if(mIncomeProfileList.size() != 0){

            //SET DATA IF ALREADY AVAILABLE
            edtFamilyIncome.setText(mIncomeProfileList.get(0).getAnnualIncome());
            edtSelfIncome.setText(mIncomeProfileList.get(0).getSelfIncome());

            //SET ID'S FOR INSERT PURPOSE
            lngFamilyIncome = mIncomeProfileList.get(0).getAnnualIncomeID();
            lngSelfIncome = mIncomeProfileList.get(0).getSelfIncomeID();

            //CHANGE SUBMIT BUTTON TEXT
            txtSubmitData.setText(getResources().getString(R.string.strUpdate));
        }

        //CHECK IF BUSINESS PLAN IS ALREADY SUBMITTED
        if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).size() != 0) {
            if (mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID))).get(0).getIsBusinessPlanSubmited() == 1) {
                isBisinessPlanSubmitted = true;
                edtFamilyIncome.setFocusableInTouchMode(false);
                edtFamilyIncome.setFocusable(false);
                edtSelfIncome.setFocusableInTouchMode(false);
                edtSelfIncome.setFocusable(false);
                txtSubmitData.setVisibility(View.GONE);

            }
        }


    }

    private void setOncliks() {

        if(!isBisinessPlanSubmitted){
            txtSubmitData.setOnClickListener(this);
            edtFamilyIncome.setOnClickListener(this);
            edtSelfIncome.setOnClickListener(this);
        }


    }


    @Override
    public void onClick(View mView) {


        switch (mView.getId()) {

            case R.id.edtFamilyIncome:

                openIncomeListDialog(true);

                break;
            case R.id.edtSelfIncome:

                openIncomeListDialog(false);

                break;

            case R.id.txtSubmitData:

                if (checkValidation()) {

                    //INSERT UPDATE AS PER DATA AVAILABILITY
                    if(mIncomeProfileList.size() != 0){

                        mDatabaseHelper.updateIncomeProfleDetail(
                                mIncomeProfileList.get(0).getEnterpreneurID(),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),
                                edtFamilyIncome.getText().toString(),
                                lngFamilyIncome,
                                edtSelfIncome.getText().toString(),
                                lngSelfIncome,
                                new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)),
                                System.currentTimeMillis());

                    }else {

                        mDatabaseHelper.insertIncomeProfleDetail(
                                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),
                                edtFamilyIncome.getText().toString(),
                                lngFamilyIncome,
                                edtSelfIncome.getText().toString(),
                                lngSelfIncome,
                                new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)),
                                System.currentTimeMillis());


                    }

                    //DISPLY SUCCESS MESSEGE
                    CommonMethods.displayToast(mContext, getResources().getString(R.string.strDataSavedSuccesfully));

                    //Move to  enterpreneur training list page
                    navController.popBackStack(R.id.enterprenuerDetails, false);



                }

                break;
        }

    }

    private boolean checkValidation() {

        if (edtFamilyIncome.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorFamilyIncom));
            edtFamilyIncome.requestFocus();
            return false;
        } else if (edtSelfIncome.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorSelfIncom));
            edtSelfIncome.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    private void openIncomeListDialog(final boolean isFromFamily) {


        dialogIncomList = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogIncomList.setContentView(R.layout.general_list_dialog);

        dialogIncomList.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogIncomList.findViewById(R.id.imgBack);
        TextView txtTitle = (TextView) dialogIncomList.findViewById(R.id.txtTitle);
        txtTitle.setText(getResources().getString(R.string.strSelectIncome));


        listIncome = (ListView) dialogIncomList.findViewById(R.id.listItems);
        mIncomeListAdapter = new IncomeListAdapter(mContext, getResources().getStringArray(R.array.incomeList));
        listIncome.setAdapter(mIncomeListAdapter);

        listIncome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogIncomList.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strIncomeItem = textView.getText().toString();
                TextView strIncomeID = (TextView) view.findViewById(R.id.txtID);

                if (isFromFamily) {
                    edtFamilyIncome.setText(strIncomeItem);
                    lngFamilyIncome = Long.valueOf(strIncomeID.getText().toString());
                } else {
                    edtSelfIncome.setText(strIncomeItem);
                    lngSelfIncome = Long.valueOf(strIncomeID.getText().toString());
                }


            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogIncomList.dismiss();
            }
        });

        dialogIncomList.setCanceledOnTouchOutside(false);
        dialogIncomList.setCancelable(true);
        dialogIncomList.show();

    }
}

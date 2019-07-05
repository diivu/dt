package com.triapp.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
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

public class TrackEnterpriseFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "TrackEnterpriseFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtSubmitData, txtTitleProfitAsPercentage, txtTitleReturnOnInvestment, txtTitleCapitalDeployed, txtTitlePeopleEmployed, txtTitleProfit, txtTitleTurnOver, txtTitleStatus, txtTitleEnterpriseName;
    private EditText edtProfitAsPercentage, edtReturnOnInvestment, edtCapitalDeployed, edtPeopleEmployed, edtProfit, edtTurnOver, edtStatus, edtEnterpriseName;
    private String strEnterpriseStatus;
    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strEnterpriseTrackingTitle));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.track_enterprise_fragment, container, false);

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


        txtTitleEnterpriseName = (TextView) mView.findViewById(R.id.txtTitleEnterpriseName);
        txtTitleStatus = (TextView) mView.findViewById(R.id.txtTitleStatus);
        txtTitleTurnOver = (TextView) mView.findViewById(R.id.txtTitleTurnOver);
        txtTitleProfit = (TextView) mView.findViewById(R.id.txtTitleProfit);
        txtTitlePeopleEmployed = (TextView) mView.findViewById(R.id.txtTitlePeopleEmployed);
        txtTitleCapitalDeployed = (TextView) mView.findViewById(R.id.txtTitleCapitalDeployed);
        txtTitleReturnOnInvestment = (TextView) mView.findViewById(R.id.txtTitleReturnOnInvestment);
        txtTitleProfitAsPercentage = (TextView) mView.findViewById(R.id.txtTitleProfitAsPercentage);
        txtSubmitData = (TextView) mView.findViewById(R.id.txtSubmitData);

        edtEnterpriseName = (EditText) mView.findViewById(R.id.edtEnterpriseName);
        edtStatus = (EditText) mView.findViewById(R.id.edtStatus);
        edtTurnOver = (EditText) mView.findViewById(R.id.edtTurnOver);
        edtProfit = (EditText) mView.findViewById(R.id.edtProfit);
        edtPeopleEmployed = (EditText) mView.findViewById(R.id.edtPeopleEmployed);
        edtCapitalDeployed = (EditText) mView.findViewById(R.id.edtCapitalDeployed);
        edtReturnOnInvestment = (EditText) mView.findViewById(R.id.edtReturnOnInvestment);
        edtProfitAsPercentage = (EditText) mView.findViewById(R.id.edtProfitAsPercentage);

        //SET MENDETORY TITLES
        txtTitleEnterpriseName.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseName)));
        txtTitleStatus.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseStatus)));
        txtTitleTurnOver.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseTurnover)));
        txtTitleProfit.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseProfit)));
        txtTitlePeopleEmployed.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterprisePeopleEmploye)));
        txtTitleCapitalDeployed.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseCapitalDeployed)));
        txtTitleReturnOnInvestment.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseReturnOnInvestment)));
        txtTitleProfitAsPercentage.setText(CommonMethods.spannableString(getResources().getString(R.string.strEnterpriseProfitAsPercentage)));


        //GET VILLAGE NAME FORM VILLAGE ID
        String strVillageName = mDatabaseHelper.getVillegeDataFromID(Long.valueOf(getArguments().getString(Constants.VILLAGE_ID))).get(0).getVillegeName();

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName(getArguments().getString(Constants.ENTERPRISE_NAME) + " - " + strVillageName);

        //DISPLAY PRE-FILLED DATA
        edtEnterpriseName.setText(getArguments().getString(Constants.ENTERPRISE_NAME));


        //CALCULATE RATE OF INTEREST AND PROFITE AS PERCENTAGE AS PER BELOW FORMULA
        //1. ROI = profit/capital deployed * 100
        //2.Profit as % of capital deployed (Net operating profit) = profit/turnover*100

        edtProfit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(b){
                    if(edtTurnOver.getText().toString().length() == 0){
                        CommonMethods.buildDialog(mContext , R.style.DialogTheme,getResources().getString(R.string.strEnterEnterpriseTurnover));
                        edtTurnOver.requestFocus();
                    }else if(edtCapitalDeployed.getText().toString().length() == 0){
                        CommonMethods.buildDialog(mContext , R.style.DialogTheme,getResources().getString(R.string.strEnterEnterpriseCapitalDeployed));
                        edtCapitalDeployed.requestFocus();
                    }else {
                        edtProfit.addTextChangedListener(new TextWatcher() {

                            @Override
                            public void afterTextChanged(Editable s) {

                            }

                            @Override
                            public void beforeTextChanged(CharSequence s, int start,
                                                          int count, int after) {
                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start,
                                                      int before, int count) {
                                if (s.length() != 0) {

                                    Double returnOnInvestment = (Double.valueOf(s.toString()) / Double.valueOf(edtCapitalDeployed.getText().toString()) * 100);
                                    edtReturnOnInvestment.setText("" + returnOnInvestment);

                                    Double profitAsPercentage = ((Double.valueOf(s.toString()) / Double.valueOf(edtTurnOver.getText().toString())) * 100);
                                    edtProfitAsPercentage.setText("" + profitAsPercentage);


                                } else {
                                    edtProfitAsPercentage.setText("");
                                    edtReturnOnInvestment.setText("");
                                }


                            }
                        });

                    }

                }
            }
        });


        edtTurnOver.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {

                    edtProfit.setText("");
                }


            }
        });

        edtCapitalDeployed.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {

                    edtProfit.setText("");
                }


            }
        });


    }

    private void setOnclicks() {

        edtStatus.setOnClickListener(this);
        txtSubmitData.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.edtStatus:

                openEnterpriseStatusDialog();

                break;

            case R.id.txtSubmitData:

                if (checkValidation()) {

                    mDatabaseHelper.insertEnterpriseTrackingData(edtEnterpriseName.getText().toString(),
                            Long.valueOf(getArguments().getString(Constants.ENTERPRISE_ID)),
                            Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)),
                            Long.valueOf(mSessionManager.getPreferenceInt(Constants.USER_ID)),
                            edtStatus.getText().toString(),
                            Double.valueOf(edtTurnOver.getText().toString()),
                            Double.valueOf(edtProfit.getText().toString()),
                            Integer.parseInt(edtPeopleEmployed.getText().toString()),
                            Double.valueOf(edtCapitalDeployed.getText().toString()),
                            Double.valueOf(edtReturnOnInvestment.getText().toString()),
                            Double.valueOf(edtProfitAsPercentage.getText().toString()),
                            System.currentTimeMillis(),
                            Double.valueOf(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                            Double.valueOf(mSessionManager.getPreference(Constants.USER_LONGITUDE)));



                }

                break;
        }


    }


    private void openEnterpriseStatusDialog() {

        final Dialog dialogEnterpriseType = new Dialog(getActivity(), R.style.listDialog);
        dialogEnterpriseType.setContentView(R.layout.dialog_enterprise_status);

        RadioGroup rgEnterpriseStatus = (RadioGroup) dialogEnterpriseType.findViewById(R.id.rgEnterpriseStatus);
        RadioButton rbtnContinue = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnContinue);
        RadioButton rbtnDiversify = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnDiversify);
        RadioButton rbtnDrop = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnDrop);


        if (!(edtStatus.getText().toString().isEmpty())) {

            if (edtStatus.getText().toString().equals(getResources().getString(R.string.strContinue))) {
                rbtnContinue.setChecked(true);
                rbtnDiversify.setChecked(false);
                rbtnDrop.setChecked(false);

            } else if (edtStatus.getText().toString().equals(getResources().getString(R.string.strDiversify))) {
                rbtnDiversify.setChecked(true);
                rbtnContinue.setChecked(false);
                rbtnDrop.setChecked(false);

            } else if (edtStatus.getText().toString().equals(getResources().getString(R.string.strDrop))) {
                rbtnDrop.setChecked(true);
                rbtnContinue.setChecked(false);
                rbtnDiversify.setChecked(false);

            }
        } else {

            rbtnContinue.setChecked(false);
            rbtnDiversify.setChecked(false);
            rbtnDrop.setChecked(false);

        }


        rgEnterpriseStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                        strEnterpriseStatus = btn.getText().toString();
                        edtStatus.setText(strEnterpriseStatus);
                        dialogEnterpriseType.dismiss();
                    }
                }
            }
        });


        dialogEnterpriseType.setCancelable(true);
        dialogEnterpriseType.show();
    }

    private boolean checkValidation() {

        if (edtEnterpriseName.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterpriseName));
            return false;
        } else if (edtStatus.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterpriseStatus));
            return false;
        } else if (edtTurnOver.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterpriseTurnover));
            return false;
        } else if (edtPeopleEmployed.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterprisePeopleEmployed));
            return false;
        } else if (edtCapitalDeployed.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterpriseCapitalDeployed));
            return false;
        } else if (edtProfit.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterpriseProfit));
            return false;
        } else if (edtReturnOnInvestment.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterpriseReturnOnInvestment));
            return false;
        } else if (edtProfitAsPercentage.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterEnterpriseProfitAsPercentage));
            return false;
        } else {
            return true;
        }


    }
}

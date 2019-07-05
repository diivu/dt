package com.triapp.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
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

public class BusinessCreationsOptionFragments extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "BusinessCreationsOptionFragments";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtCreateNewBusinessPlan, txtOR, txtSelectFromExistingBusinessPlan, txtModelBusinessPlanDescription, txtTitleTypeOfEnterprise;
    private EditText edtTypeOfEnterprise;
    private String strEnterpriseType = "";
    private DatabaseHelper mDatabaseHelper;
    private boolean isModelBusinessPlanAvailable = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strSelectEnterpriseType));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.business_plan_creation_options, container, false);

        setIds();
        setOnclicks();


        return mView;


    }


    @Override
    public void onResume() {

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName(mSessionManager.getPreference(Constants.ENTERPRENEUR_NAME_AS_A_HINT));

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


        txtTitleTypeOfEnterprise = (TextView) mView.findViewById(R.id.txtTitleTypeOfEnterprise);
        txtModelBusinessPlanDescription = (TextView) mView.findViewById(R.id.txtModelBusinessPlanDescription);
        txtSelectFromExistingBusinessPlan = (TextView) mView.findViewById(R.id.txtSelectFromExistingBusinessPlan);
        txtOR = (TextView) mView.findViewById(R.id.txtOR);
        txtCreateNewBusinessPlan = (TextView) mView.findViewById(R.id.txtCreateNewBusinessPlan);

        edtTypeOfEnterprise = (EditText) mView.findViewById(R.id.edtTypeOfEnterprise);

        //Set mendetory field
        txtTitleTypeOfEnterprise.setText(CommonMethods.spannableString(getResources().getString(R.string.strTypeOfEnterprise)));


        //CHECK ENTERPRENEUR TYPE AND TYPE OF ENTERPRISE SUCH AS NEW OR EXISTING AND MANUFACTURING, TRADING OR SERVICE
        if(getArguments().getString(Constants.ENTERPRISE_TYPE).equalsIgnoreCase("1")){

            //SET ENTERPRISE TYPE
            edtTypeOfEnterprise.setText(getArguments().getString(Constants.TYPE_OF_ENTERPRISE));

            strEnterpriseType = getArguments().getString(Constants.TYPE_OF_ENTERPRISE);

            //CHECK IF TEMPLATE BUSINESS PLAN AVAILABLE OR NOT
            checkTemplateBusinessPlanAvailable();


        }


    }

    private void setOnclicks() {

        if(getArguments().getString(Constants.ENTERPRISE_TYPE).equalsIgnoreCase("0")){
            edtTypeOfEnterprise.setOnClickListener(this);
        }
        txtSelectFromExistingBusinessPlan.setOnClickListener(this);
        txtCreateNewBusinessPlan.setOnClickListener(this);


    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.edtTypeOfEnterprise:

                openEnterpriseTypeDialog();

                break;
            case R.id.txtCreateNewBusinessPlan:

                //Call navigation controler
                //Add data in to bundle and send it to the details screen for displaying purpose only
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ENTERPRENEUR_ID, "" + getArguments().getString(Constants.ENTERPRENEUR_ID));
                bundle.putString(Constants.TYPE_OF_ENTERPRISE, "" +strEnterpriseType);
                navController.navigate(R.id.createBusinessPlan, bundle);

                break;
            case R.id.txtSelectFromExistingBusinessPlan:

                //Call navigation controler
                //Add data in to bundle and send it to the details screen for displaying purpose only
                Bundle bundleNew = new Bundle();
                bundleNew.putString(Constants.ENTERPRENEUR_ID, "" + getArguments().getString(Constants.ENTERPRENEUR_ID));
                bundleNew.putString(Constants.TYPE_OF_ENTERPRISE, "" +strEnterpriseType);
                navController.navigate(R.id.modelBusinessPlanList, bundleNew);

                break;
        }

    }

    private void openEnterpriseTypeDialog() {

        final Dialog dialogEnterpriseType = new Dialog(getActivity(), R.style.listDialog);
        dialogEnterpriseType.setContentView(R.layout.dialog_enterprisetype);

        RadioGroup rgEnterpriseType = (RadioGroup) dialogEnterpriseType.findViewById(R.id.rgEnterpriseType);
        RadioButton rbtnManufacturing = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnManufacturing);
        RadioButton rbtnTrading = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnTrading);
        RadioButton rbtnOther = (RadioButton) dialogEnterpriseType.findViewById(R.id.rbtnOther);


        if (!(edtTypeOfEnterprise.getText().toString().isEmpty())) {

            if (edtTypeOfEnterprise.getText().toString().equals(getResources().getString(R.string.strMenufacturing))) {
                rbtnManufacturing.setChecked(true);
                rbtnTrading.setChecked(false);
                rbtnOther.setChecked(false);

            } else if (edtTypeOfEnterprise.getText().toString().equals(getResources().getString(R.string.strTrading))) {
                rbtnTrading.setChecked(true);
                rbtnManufacturing.setChecked(false);
                rbtnOther.setChecked(false);

            } else if (edtTypeOfEnterprise.getText().toString().equals(getResources().getString(R.string.strService))) {
                rbtnOther.setChecked(true);
                rbtnManufacturing.setChecked(false);
                rbtnTrading.setChecked(false);

            }
        } else {
            rbtnManufacturing.setChecked(false);
            rbtnTrading.setChecked(false);
            rbtnOther.setChecked(false);

        }


        rgEnterpriseType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {

                        strEnterpriseType = btn.getText().toString();
                        edtTypeOfEnterprise.setText(strEnterpriseType);

                        //CHECK IF TEMPLATE BUSINESS PLAN AVAILABLE OR NOT
                        checkTemplateBusinessPlanAvailable();

                        dialogEnterpriseType.dismiss();
                    }
                }
            }
        });


        dialogEnterpriseType.setCancelable(true);
        dialogEnterpriseType.show();

    }

    public  void checkTemplateBusinessPlanAvailable(){

        //RESET FLAG
        isModelBusinessPlanAvailable = false;

        //CHECK IF MODEL BUSINESS PLAN IS AVAILABLE FOR THIS TYPE OF ENTERPRIS
        for (int i = 0 ; i < mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().size() ; i ++ ){
            if(mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i).getIsBusinessPlanSubmited() == 1 && mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i).getIsModelBusinessPlan() == 1 && mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lListALL().get(i).getType().equalsIgnoreCase(edtTypeOfEnterprise.getText().toString())){
                isModelBusinessPlanAvailable = true;
            }
        }


        //VISIBLE OPTIONS AS PER CONDITIONS
        if (isModelBusinessPlanAvailable) {
            txtModelBusinessPlanDescription.setVisibility(View.VISIBLE);
            txtSelectFromExistingBusinessPlan.setVisibility(View.VISIBLE);
            txtOR.setVisibility(View.VISIBLE);
            txtCreateNewBusinessPlan.setVisibility(View.VISIBLE);
        } else {
            txtCreateNewBusinessPlan.setVisibility(View.VISIBLE);
            txtModelBusinessPlanDescription.setVisibility(View.GONE);
            txtSelectFromExistingBusinessPlan.setVisibility(View.GONE);
            txtOR.setVisibility(View.GONE);
        }

    }

}

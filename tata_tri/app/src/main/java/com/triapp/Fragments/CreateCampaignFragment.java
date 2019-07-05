package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.triapp.Activities.MainActivity;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class CreateCampaignFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "CreateCampaignFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtCreateCampaign, txtTitleMoreDetails, txtTitleAddressOfCampaign, txtTitleCampaignDate, txtTitleCampaignName;
    private EditText edtMoreDetails, edtAddressOfCampaign, edtCampaignDate, edtCampaignName;
    private DatabaseHelper mDatabaseHelper;
    private DatePickerDialog mDatePickerDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strCreateCampaign));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.create_campaign_fragment, container, false);

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

        txtTitleCampaignName = (TextView) mView.findViewById(R.id.txtTitleCampaignName);
        txtTitleCampaignDate = (TextView) mView.findViewById(R.id.txtTitleCampaignDate);
        txtTitleAddressOfCampaign = (TextView) mView.findViewById(R.id.txtTitleAddressOfCampaign);
        txtTitleMoreDetails = (TextView) mView.findViewById(R.id.txtTitleMoreDetails);
        txtCreateCampaign = (TextView) mView.findViewById(R.id.txtCreateCampaign);

        edtCampaignName = (EditText) mView.findViewById(R.id.edtCampaignName);
        edtCampaignDate = (EditText) mView.findViewById(R.id.edtCampaignDate);
        edtAddressOfCampaign = (EditText) mView.findViewById(R.id.edtAddressOfCampaign);
        edtMoreDetails = (EditText) mView.findViewById(R.id.edtMoreDetails);

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName("");

        //SET MENDETORY DATA
        txtTitleCampaignName.setText(CommonMethods.spannableString(getResources().getString(R.string.strCampaignName)));
        txtTitleCampaignDate.setText(CommonMethods.spannableString(getResources().getString(R.string.strCampaignDate)));
        txtTitleAddressOfCampaign.setText(CommonMethods.spannableString(getResources().getString(R.string.strCampaignAddress)));

    }

    private void setOnclicks() {
        txtCreateCampaign.setOnClickListener(this);
        edtCampaignDate.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtCreateCampaign:

                if (checkValidation()) {

                    mDatabaseHelper.insertCampaignData(System.currentTimeMillis(),
                            edtCampaignName.getText().toString(),
                            CommonMethods.getLongDateFromStringDate(edtCampaignDate.getText().toString()),
                            edtAddressOfCampaign.getText().toString(),
                            edtMoreDetails.getText().toString(),
                            new Long(mSessionManager.getPreferenceInt(Constants.USER_ID)),
                            Double.valueOf(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                            Double.valueOf(mSessionManager.getPreference(Constants.USER_LONGITUDE)));

                    //GO BACK TO CREATED EVENT SCREEN
                    navController.popBackStack(R.id.campaignFragment, false);
                }

                break;
            case R.id.edtCampaignDate:


                openDatePickerDialog();

                break;
        }

    }

    private void openDatePickerDialog() {

        Date fromDate = null;
        DateFormat format = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);

        Calendar calenderToDate = Calendar.getInstance();
        Calendar calenderFromDate = Calendar.getInstance();

        mDatePickerDialog = DatePickerDialog.newInstance(this,
                calenderToDate.get(Calendar.YEAR),
                calenderToDate.get(Calendar.MONTH),
                calenderToDate.get(Calendar.DAY_OF_MONTH)
        );
        mDatePickerDialog.setMaxDate(calenderToDate);
        mDatePickerDialog.setCancelColor(Color.BLACK);
        mDatePickerDialog.setOkColor(Color.BLACK);
        mDatePickerDialog.show(getActivity().getFragmentManager(), "Datepickerdialog");

    }

    private boolean checkValidation() {

        if (edtCampaignName.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterCampaignName));
            return false;
        } else if (edtCampaignDate.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterCampaignDate));
            return false;
        } else if (edtAddressOfCampaign.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterCampaigAddress));
            return false;
        } else {
            return true;
        }


    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        edtCampaignDate.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

    }
}

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
import com.triapp.Adapter.EventListAdapter;
import com.triapp.Adapter.EventMemberListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddEventMemberFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "AddEventMemberFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtAddMember, txtTitleMobileNumber, txtTitleMemberBirthDate, txtTitleMemberName;
    private EditText edtMemberBirthDate, edtMobileNumber, edtMemberName;
    private RecyclerView recycleEventMemberList;
    private LinearLayoutManager recylerViewLayoutManager;
    private DatePickerDialog mDatePickerDialog;
    private DatabaseHelper mDatabaseHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strAddMember));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.add_event_member_fragment, container, false);

        setIds();
        setOnClicks();


        return mView;


    }


    @Override
    public void onResume() {

        refreshList();

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

        txtTitleMemberName = (TextView) mView.findViewById(R.id.txtTitleMemberName);
        txtTitleMemberBirthDate = (TextView) mView.findViewById(R.id.txtTitleMemberBirthDate);
        txtTitleMobileNumber = (TextView) mView.findViewById(R.id.txtTitleMobileNumber);
        txtAddMember = (TextView) mView.findViewById(R.id.txtAddMember);

        edtMemberName = (EditText) mView.findViewById(R.id.edtMemberName);
        edtMemberBirthDate = (EditText) mView.findViewById(R.id.edtMemberBirthDate);
        edtMobileNumber = (EditText) mView.findViewById(R.id.edtMobileNumber);

        recycleEventMemberList = (RecyclerView) mView.findViewById(R.id.recycleEventMemberList);

        recylerViewLayoutManager = new LinearLayoutManager(mActivity);
        recycleEventMemberList.setLayoutManager(recylerViewLayoutManager);

        //SET MENDETORY DATA
        txtTitleMemberName.setText(CommonMethods.spannableString(getResources().getString(R.string.strMemberName)));
        txtTitleMemberBirthDate.setText(CommonMethods.spannableString(getResources().getString(R.string.strMemberBirthDate)));
        txtTitleMobileNumber.setText(CommonMethods.spannableString(getResources().getString(R.string.strMemberMobileNumber)));


        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName(getArguments().getString(Constants.EVENT_NAME));

    }

    private void setOnClicks() {

        txtAddMember.setOnClickListener(this);
        edtMemberBirthDate.setOnClickListener(this);
    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtAddMember:

                if (checkValidation()) {

                    if(mDatabaseHelper.getMemberDataByMobileNumber(edtMobileNumber.getText().toString()).size() == 0){

                        mDatabaseHelper.insertEventMemberData(
                                edtMemberName.getText().toString(),
                                CommonMethods.getLongDateFromStringDate(edtMemberBirthDate.getText().toString()),
                                edtMobileNumber.getText().toString(),
                                System.currentTimeMillis(),
                                new Long(mSessionManager.getPreferenceInt(Constants.USER_ID)),
                                Double.valueOf(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                                Double.valueOf(mSessionManager.getPreference(Constants.USER_LONGITUDE)),
                                System.currentTimeMillis(),
                                Long.valueOf(getArguments().getString(Constants.EVENT_ID)));

                        //CLEAR DATA
                        edtMemberName.setText("");
                        edtMemberBirthDate.setText("");
                        edtMobileNumber.setText("");
                        edtMemberName.requestFocus();

                        //REFRESH RECYCLE VIEW
                        refreshList();


                    }else {

                        CommonMethods.displayToast(mContext, getResources().getString(R.string.strMobileAlreadyRegister));
                    }


                }

                break;
            case R.id.edtMemberBirthDate:

                openBirthdateDialog();

                break;
        }

    }

    private void refreshList() {
        //Create Adapter list for display event list
        EventMemberListAdapter mEventMemberListAdapter = new EventMemberListAdapter(mContext, mActivity,mDatabaseHelper.getMemberDataByEventID(Long.valueOf(getArguments().getString(Constants.EVENT_ID))));
        recycleEventMemberList.setAdapter(mEventMemberListAdapter);

    }

    private void openBirthdateDialog() {

        Date fromDate = null;
        DateFormat format = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);

        Calendar calenderToDate = Calendar.getInstance();
        Calendar calenderFromDate = Calendar.getInstance();

        mDatePickerDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(this,
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

        if (edtMemberName.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterMemberName));
            return false;
        } else if (edtMemberBirthDate.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidationDateOfBirth));
            return false;
        } else if (edtMobileNumber.getText().toString().length() != 0 && edtMobileNumber.getText().toString().length() < 10) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidMobileNo));
            return false;
        } else if (edtMobileNumber.getText().toString().equalsIgnoreCase("0000000000")) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidMobileNo));
            return false;
        } else {
            return true;
        }


    }

    @Override
    public void onDateSet(DatePickerDialog view, int selectedYear, int selectedMonth, int selectedDay) {

        int year = selectedYear;
        int month = selectedMonth;
        int day = selectedDay;

        if (Integer.parseInt(getAge(year, month, day)) > 16 && Integer.parseInt(getAge(year, month, day)) < 70) {

            int intAge = Integer.parseInt(getAge(year, month, day));
            edtMemberBirthDate.setText(new StringBuilder().append(day).append("/").append(month + 1).append("/").append(year).append(" "));

            String strDate = String.valueOf(month + 1) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

            DateFormat inputFormat = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);

            Date date = null;
            try {
                date = inputFormat.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // lngBirthDate = date.getTime();
            // lngBirthDate = AlertUtils.getLongDateFromStringDate(strDate);

        } else {
            edtMemberBirthDate.setText("");
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strenterAgeValidation));
        }
    }

    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }
}

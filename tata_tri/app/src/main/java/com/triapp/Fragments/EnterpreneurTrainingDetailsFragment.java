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
import com.google.gson.Gson;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.EnterpreneurTrainingDetailsModel;
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


public class EnterpreneurTrainingDetailsFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "EnterpreneurTrainingDetailsFragment";

    private View mView;

    public NavController navController;

    public NavigationView navigationView;

    private RecyclerView recycleActiveAI;
    private LinearLayoutManager recylerViewLayoutManager;
    private SessionManager mSessionManager;
    private TextView txtSubmitTrainingData, txtTitleDescription, txtTitleEndDate, txtTitleStartDate, txtTitleNameOfTraining;
    private EditText edtDescriptionTraining, edtEndDateTraining, edtstartDateTraining, edtNameOfTraininig;
    public int dayStart, monthStart, YearStart, dayEnd, monthEnd, YearEnd;
    private DatabaseHelper mDatabaseHelper;
    private EnterpreneurTrainingDetailsModel.DataBean mTrainingDatabean;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(getArguments().getBoolean(Constants.IS_FOR_EDIT)){
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strUpdateTraining));
        }else {
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strAddTraining));
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.enterpreneur_training_details_fragment, container, false);

        setIds();
        setOnClicks();


        return mView;


    }


    @Override
    public void onResume() {
        super.onResume();

    }

    private void setIds() {

        //getArguments().getString(Constants.ENTERPRENEUR_ID)

        mActivity = getActivity();
        mContext = getActivity();

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

        //INITIALIS NAVIGATION CONTROLL
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtTitleNameOfTraining = (TextView) mView.findViewById(R.id.txtTitleNameOfTraining);
        txtTitleStartDate = (TextView) mView.findViewById(R.id.txtTitleStartDate);
        txtTitleEndDate = (TextView) mView.findViewById(R.id.txtTitleEndDate);
        txtTitleDescription = (TextView) mView.findViewById(R.id.txtTitleDescription);
        txtSubmitTrainingData = (TextView) mView.findViewById(R.id.txtSubmitTrainingData);

        edtNameOfTraininig = (EditText) mView.findViewById(R.id.edtNameOfTraininig);
        edtstartDateTraining = (EditText) mView.findViewById(R.id.edtstartDateTraining);
        edtEndDateTraining = (EditText) mView.findViewById(R.id.edtEndDateTraining);
        edtDescriptionTraining = (EditText) mView.findViewById(R.id.edtDescriptionTraining);

        //SET MENDETORY ITEMS
        txtTitleNameOfTraining.setText(CommonMethods.spannableString(getResources().getString(R.string.strNameOfTraining)));
        txtTitleStartDate.setText(CommonMethods.spannableString(getResources().getString(R.string.strTrainingStartDate)));
        txtTitleEndDate.setText(CommonMethods.spannableString(getResources().getString(R.string.strTrainingEndDate)));
        txtTitleDescription.setText(CommonMethods.spannableString(getResources().getString(R.string.strDescriptionTraining)));


        //CHECK IF USER COME FOR EDIT DATA
        if(getArguments().getBoolean(Constants.IS_FOR_EDIT)){

            //GET LIST CELL DATA
            mTrainingDatabean = (EnterpreneurTrainingDetailsModel.DataBean)getArguments().getSerializable(Constants.ARRAY_LIST_DATA);

            //SET DATA IF ITS FROM LIST
            edtNameOfTraininig.setText(""+mTrainingDatabean.getTrainingName());
            edtstartDateTraining.setText(""+CommonMethods.getDateFromLong(mTrainingDatabean.getTrainingStartDate()));
            edtEndDateTraining.setText(""+CommonMethods.getDateFromLong(mTrainingDatabean.getTrainingEndDate()));
            edtDescriptionTraining.setText(""+mTrainingDatabean.getTrainingDescription());

            //CHANGE SUBMIT BUTTON TO UPDATE
            txtSubmitTrainingData.setText(mActivity.getResources().getString(R.string.strUpdate));

        }

    }

    private void setOnClicks() {

        edtEndDateTraining.setOnClickListener(this);
        edtstartDateTraining.setOnClickListener(this);
        txtSubmitTrainingData.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.edtstartDateTraining:

                openStartDate();

                break;
            case R.id.edtEndDateTraining:

                openEndDate();

                break;
            case R.id.txtSubmitTrainingData:

                if (checkValidation()) {

                    //Get Unique training id for enterprenuer  from current millisecon's last four degit + user code
                    String strCurrentMilliSecond = String.valueOf(System.currentTimeMillis());
                    String strUniqueNumber =( strCurrentMilliSecond.substring(strCurrentMilliSecond.length() - 4) + String.valueOf(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)));

                    if(getArguments().getBoolean(Constants.IS_FOR_EDIT)){

                        mDatabaseHelper.updateTrainingDetails(mTrainingDatabean.getId() ,
                                mTrainingDatabean.getEntrepreneurId(),
                                System.currentTimeMillis(),
                                mTrainingDatabean.getCreatedBy(),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),
                                edtNameOfTraininig.getText().toString(),
                                CommonMethods.getLongDateFromStringDate(edtstartDateTraining.getText().toString()),
                                CommonMethods.getLongDateFromStringDate(edtEndDateTraining.getText().toString()),
                                edtDescriptionTraining.getText().toString()
                        );


                        //UPDATE ENTERPRENEUR TRAINING DATA
                        CommonMethods.printLog("UPDATE ENTERPRENEUR TRAINING DATA : ", new Gson().toJson(mDatabaseHelper.getAllTrainingDetails()));


                    }else {
                        mDatabaseHelper.insertTrainingDetails(Long.valueOf(strUniqueNumber) ,
                                Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)),
                                System.currentTimeMillis(),
                                new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                                Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),
                                edtNameOfTraininig.getText().toString(),
                                CommonMethods.getLongDateFromStringDate(edtstartDateTraining.getText().toString()),
                                CommonMethods.getLongDateFromStringDate(edtEndDateTraining.getText().toString()),
                                edtDescriptionTraining.getText().toString()
                        );


                        //GET ENTERPRENEUR TRAINING DATA
                       CommonMethods.printLog("INSERT ENTERPRENEUR TRAINING DATA : ", new Gson().toJson(mDatabaseHelper.getAllTrainingDetails()));

                    }


                    //Move to  enterpreneur training list page
                    navController.popBackStack(R.id.enterprenuerTrainingDetailsList, false);


                }

                break;
        }

    }

    private boolean checkValidation() {

        if (edtNameOfTraininig.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidEnternameOFTraining));
            edtNameOfTraininig.requestFocus();
            return false;
        } else if (edtstartDateTraining.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidEnterStartDAteOFTraining));
            edtstartDateTraining.requestFocus();
            return false;
        } else if (edtEndDateTraining.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidEnterEndDAteOFTraining));
            edtEndDateTraining.requestFocus();
            return false;
        } else if (edtDescriptionTraining.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strValidEnterDEScriptionOFTraining));
            edtDescriptionTraining.requestFocus();
            return false;
        } else {
            return true;
        }
    }


    private void openStartDate() {

        Calendar mCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

                //CLEAR END DATE
                edtEndDateTraining.setText("");

                //SET START DATE
                edtstartDateTraining.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                dayStart = dayOfMonth;
                monthStart = monthOfYear + 1;
                YearStart = year;
            }
        };

        Date fromDate = null;
        DateFormat format = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
        Calendar minDate = Calendar.getInstance();
        try {
            fromDate = format.parse("1/1/2015");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        minDate.setTime(fromDate);
        DatePickerDialog mDatePickerDialog = DatePickerDialog.newInstance(callback,
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));
        mDatePickerDialog.setMaxDate(mCalendar);
        mDatePickerDialog.setMinDate(minDate);
        mDatePickerDialog.setCancelColor(Color.BLACK);
        mDatePickerDialog.setOkColor(Color.BLACK);
        mDatePickerDialog.show(getActivity().getFragmentManager(), "date");
    }

    private void openEndDate() {

        if (edtstartDateTraining.getText().toString().equals("")) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strEnterStartDateFirst));
        } else {
            Calendar mCalendar = Calendar.getInstance();
            DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

                    //SET END DATE

                    edtEndDateTraining.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    dayEnd = dayOfMonth;
                    monthEnd = monthOfYear + 1;
                    YearEnd = year;
                }
            };

            Date fromDate = null;
            DateFormat format = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
            Calendar minDate = Calendar.getInstance();
            try {
                fromDate = format.parse(edtstartDateTraining.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            minDate.setTime(fromDate);
            DatePickerDialog mDatePickerDialog = DatePickerDialog.newInstance(callback,
                    mCalendar.get(Calendar.YEAR),
                    mCalendar.get(Calendar.MONTH),
                    mCalendar.get(Calendar.DAY_OF_MONTH));
            mDatePickerDialog.setMaxDate(mCalendar);
            mDatePickerDialog.setMinDate(minDate);
            mDatePickerDialog.setCancelColor(Color.BLACK);
            mDatePickerDialog.setOkColor(Color.BLACK);
            mDatePickerDialog.show(getActivity().getFragmentManager(), "date");
        }

    }

}

package com.triapp.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import com.triapp.Adapter.EnterpreneurListForEnterpriseAdapter;
import com.triapp.Adapter.StateListAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CheckedOutputStream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class RegisterEnterpriseFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "RegisterEnterpriseFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtSubmitData,txtTitleUploadEnterpriseImage,txtTitleDateOfStartingEnterprise,txtTitleNameOfEnterpreneur;
    private EditText edtUploadEnterpriseImage,edtDateOfStartingEnterprise,edtGender,edtDateOfBirth,edtVillageName,edtBlockName,edtEnterpriseName,edtNameOFEnterpreneur;
    private DatabaseHelper mDatabaseHelper;
    private Dialog dialogEnterpreneurList;
    private ListView listEnterpreneur;
    private EnterpreneurListForEnterpriseAdapter mEnterpreneurListForEnterpriseAdapter;
    private Long lngEnterpreneurID = 0L ,lngBlockID = 0L , lngVillageID =0L;
    private DatePickerDialog mDatePickerDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strRegisterEnterprise));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.register_enterprise_fragment, container, false);

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


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtTitleNameOfEnterpreneur = (TextView) mView.findViewById(R.id.txtTitleNameOfEnterpreneur);
        txtTitleDateOfStartingEnterprise = (TextView) mView.findViewById(R.id.txtTitleDateOfStartingEnterprise);
        txtTitleUploadEnterpriseImage = (TextView) mView.findViewById(R.id.txtTitleUploadEnterpriseImage);
        txtSubmitData = (TextView) mView.findViewById(R.id.txtSubmitData);

        edtNameOFEnterpreneur = (EditText) mView.findViewById(R.id.edtNameOFEnterpreneur);
        edtEnterpriseName = (EditText) mView.findViewById(R.id.edtEnterpriseName);
        edtBlockName = (EditText) mView.findViewById(R.id.edtBlockName);
        edtVillageName = (EditText) mView.findViewById(R.id.edtVillageName);
        edtDateOfBirth = (EditText) mView.findViewById(R.id.edtDateOfBirth);
        edtGender = (EditText) mView.findViewById(R.id.edtGender);
        edtDateOfStartingEnterprise = (EditText) mView.findViewById(R.id.edtDateOfStartingEnterprise);
        edtUploadEnterpriseImage = (EditText) mView.findViewById(R.id.edtUploadEnterpriseImage);

        //SET ENTERPRENEUR NAME DYNAMIC
        MainActivity.setDynmaicEnterpreneurName(getArguments().getString(Constants.VILLAGE_NAME));

        //SET MENDATORY FIELS
        txtTitleNameOfEnterpreneur.setText(CommonMethods.spannableString(getResources().getString(R.string.strSelectEnterpreneur)));
        txtTitleDateOfStartingEnterprise.setText(CommonMethods.spannableString(getResources().getString(R.string.strDateOfStartingEnterprise)));
        txtTitleUploadEnterpriseImage.setText(CommonMethods.spannableString(getResources().getString(R.string.strUploadEnterpriseImage)));

    }
    private void setOnClicks() {

        txtSubmitData.setOnClickListener(this);
        edtNameOFEnterpreneur.setOnClickListener(this);
        edtDateOfStartingEnterprise.setOnClickListener(this);
        edtUploadEnterpriseImage.setOnClickListener(this);

    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.txtSubmitData:

                if(validation()){

                    //ENTERPRISE ID  = CURRENT DATE TIME + MOBILE USER ID
                    String strEnterpriseID = String.valueOf(System.currentTimeMillis())+String.valueOf(mSessionManager.getPreferenceInt(Constants.USER_ID));

                    Log.e("ENTERPRISE ID : " , strEnterpriseID);

                    mDatabaseHelper.insertEnterpriseRegistrationData(edtNameOFEnterpreneur.getText().toString() ,
                            edtEnterpriseName.getText().toString(),
                            lngEnterpreneurID,
                            Long.valueOf(strEnterpriseID),
                            lngBlockID,
                            lngVillageID,
                            CommonMethods.getLongDateFromStringDate(edtDateOfStartingEnterprise.getText().toString()),
                            edtUploadEnterpriseImage.getText().toString(),
                            System.currentTimeMillis(),
                            Double.valueOf(mSessionManager.getPreference(Constants.USER_LATITUDE)),
                            Double.valueOf(mSessionManager.getPreference(Constants.USER_LONGITUDE))
                            );

                    //CHANGE ENTEPRISE REGISTRATION FLAG
                    mDatabaseHelper.updateEnterpreneureEnterpriseRegistrationStatus(lngEnterpreneurID , 1);


                    //GO BACK TO REGISTERED ENTERPRISES LIST SCREEN
                    navController.popBackStack(R.id.registeredEnterprises, false);
                }

                break;
            case R.id.edtNameOFEnterpreneur:

                openEnterpreneurListDialog();

                break;
            case R.id.edtDateOfStartingEnterprise:

                openDatePickerDialog();
                
                break;
            case R.id.edtUploadEnterpriseImage:


                break;


        }
    }

    private boolean validation() {

        if(edtNameOFEnterpreneur.getText().toString().length() == 0){
            CommonMethods.displayToast(mContext , getResources().getString(R.string.strSelectEnterpreneurName));
            return false;
        }else if(edtDateOfStartingEnterprise.getText().toString().length() == 0){
            CommonMethods.displayToast(mContext , getResources().getString(R.string.strSelectEnterpriseStartingDate));
            return false;
        }/*else if(edtUploadEnterpriseImage.getText().toString().length() == 0){
            CommonMethods.displayToast(mContext , getResources().getString(R.string.strUploasdImage));
            return false;
        }*/else {
            return true;
        }

    }

    private void openDatePickerDialog() {

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

    private void openEnterpreneurListDialog() {

        //ADD THOSE ENTERPRENEUERS WHO SUBMITTED THAIR BUISNESS PLAN
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

        dialogEnterpreneurList = new Dialog(getActivity(), R.style.MY_DIALOG);
        dialogEnterpreneurList.setContentView(R.layout.general_list_search_dialog);

        dialogEnterpreneurList.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogEnterpreneurList.findViewById(R.id.imgBack);
        SearchView etSearchAirline = (SearchView) dialogEnterpreneurList.findViewById(R.id.edtSearchItem);

        int id = etSearchAirline.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);

        EditText searchEditText = (EditText) etSearchAirline.findViewById(id);
        searchEditText.setHint(getResources().getString(R.string.strEnterEnterpreneurName));
        searchEditText.setTextColor(getResources().getColor(R.color.colorWhite));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorWhite));


        searchEditText.setTextSize(14);

        int id1 = etSearchAirline.getContext()
                .getResources()
                .getIdentifier("android:id/search_plate", null, null);

        View v1 = etSearchAirline.findViewById(id1);
        v1.setBackgroundColor(getResources().getColor(R.color.colorAppTheme));

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) etSearchAirline.findViewById(magId);
        magImage.setImageResource(R.drawable.icon_search);

        listEnterpreneur = (ListView) dialogEnterpreneurList.findViewById(R.id.listItems);
        mEnterpreneurListForEnterpriseAdapter = new EnterpreneurListForEnterpriseAdapter(mContext, mFilteredArrayList);
        listEnterpreneur.setAdapter(mEnterpreneurListForEnterpriseAdapter);

        etSearchAirline.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mEnterpreneurListForEnterpriseAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listEnterpreneur.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialogEnterpreneurList.dismiss();

                TextView textView = (TextView) view.findViewById(R.id.txtItemname);
                String strCasteFromSelection = textView.getText().toString();

                TextView tvStateId = (TextView) view.findViewById(R.id.txtID);

                edtNameOFEnterpreneur.setText(strCasteFromSelection);
                lngEnterpreneurID = Long.valueOf(tvStateId.getText().toString());

                //RESET ALL DATA
                edtDateOfStartingEnterprise.setText("");
                edtUploadEnterpriseImage.setText("");

                //GET ALL BASIC DETAILS FROM ENTERPRENEUR ID
                getBasicDetails();
                
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEnterpreneurList.dismiss();
            }
        });

        dialogEnterpreneurList.setCanceledOnTouchOutside(false);
        dialogEnterpreneurList.setCancelable(true);
        dialogEnterpreneurList.show();

    }

    private void getBasicDetails() {

        if(mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(lngEnterpreneurID).size() != 0){

            ArrayList<CreateEnterpreneurModel.DataBean> mEnterpreneurBeanList =  mDatabaseHelper.getEnterpreneurList(lngEnterpreneurID);

             lngBlockID =  mEnterpreneurBeanList.get(0).getBlockID();
             lngVillageID =  mEnterpreneurBeanList.get(0).getVillegeID();

            edtEnterpriseName.setText(""+mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(lngEnterpreneurID).get(0).getNameOfUnit());
            edtBlockName.setText("" + mDatabaseHelper.getBlockDataFromID(lngBlockID).get(0).getBlockName());
            edtVillageName.setText("" + mDatabaseHelper.getVillegeDataFromID(mDatabaseHelper.getEntrepreneurBusinessplan_step_1_0_lList(lngEnterpreneurID).get(0).getVillageId()).get(0).getVillegeName());
            edtDateOfBirth.setText(""+ CommonMethods.getDateFromLong(mEnterpreneurBeanList.get(0).getDateOfBirth()));
            edtGender.setText(""+ mEnterpreneurBeanList.get(0).getGender());

        }

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        edtDateOfStartingEnterprise.setText(new StringBuilder().append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));

    }
}

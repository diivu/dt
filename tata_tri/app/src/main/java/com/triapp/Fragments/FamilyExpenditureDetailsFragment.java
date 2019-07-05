package com.triapp.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.triapp.Models.EntrepreneurListModel;
import com.triapp.Models.ExpanditureModel;
import com.triapp.R;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class FamilyExpenditureDetailsFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "FamilyExpenditureDetailsFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtTitleTransportation, txtSubmitData, txtTitleOther, txtTotalExpense, txtTitleElectricity, txtTitleFestivals, txtTitleCloths, txtTitleHealth, txtTitleEducation, txtTitleFood;
    private EditText edtMonthlyTransportation, edtMonthlyOther, edtAnnualOther, edtMonthlyElectricity, edtAnnualElectricity, edtAnnualTransportation, edtMonthlyFestivals, edtAnnualFestivals, edtMonthlyCloths, edtAnnualCloths, edtMonthlyHealth, edtAnnualHealth, edtMonthlyEducation, edtAnnualEducation, edtMonthlyFood, edtAnnualFood;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<EntrepreneurListModel.DataBean.FamilyExpendituresBean> mList = new ArrayList<>();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getArguments().getBoolean(Constants.IS_FOR_EDIT)) {
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strUpdateExpenditureDetails));
        } else {
            ((AppCompatActivity) getActivity()).setTitle(getResources().getString(R.string.strExpenditureDetails));
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.family_expenditure_details, container, false);

        setIds();
        setOnclicks();


        return mView;


    }

    private void setOnclicks() {

        txtSubmitData.setOnClickListener(this);
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

        txtTitleFood = (TextView) mView.findViewById(R.id.txtTitleFood);
        txtTitleEducation = (TextView) mView.findViewById(R.id.txtTitleEducation);
        txtTitleHealth = (TextView) mView.findViewById(R.id.txtTitleHealth);
        txtTitleCloths = (TextView) mView.findViewById(R.id.txtTitleCloths);
        txtTitleFestivals = (TextView) mView.findViewById(R.id.txtTitleFestivals);
        txtTitleTransportation = (TextView) mView.findViewById(R.id.txtTitleTransportation);
        txtTitleElectricity = (TextView) mView.findViewById(R.id.txtTitleElectricity);
        txtTitleOther = (TextView) mView.findViewById(R.id.txtTitleOther);
        txtTotalExpense = (TextView) mView.findViewById(R.id.txtTotalExpense);
        txtSubmitData = (TextView) mView.findViewById(R.id.txtSubmitData);


        edtAnnualFood = (EditText) mView.findViewById(R.id.edtAnnualFood);
        edtMonthlyFood = (EditText) mView.findViewById(R.id.edtMonthlyFood);
        edtAnnualEducation = (EditText) mView.findViewById(R.id.edtAnnualEducation);
        edtMonthlyEducation = (EditText) mView.findViewById(R.id.edtMonthlyEducation);
        edtAnnualHealth = (EditText) mView.findViewById(R.id.edtAnnualHealth);
        edtMonthlyHealth = (EditText) mView.findViewById(R.id.edtMonthlyHealth);
        edtAnnualCloths = (EditText) mView.findViewById(R.id.edtAnnualCloths);
        edtMonthlyCloths = (EditText) mView.findViewById(R.id.edtMonthlyCloths);
        edtAnnualFestivals = (EditText) mView.findViewById(R.id.edtAnnualFestivals);
        edtMonthlyFestivals = (EditText) mView.findViewById(R.id.edtMonthlyFestivals);
        edtAnnualTransportation = (EditText) mView.findViewById(R.id.edtAnnualTransportation);
        edtMonthlyTransportation = (EditText) mView.findViewById(R.id.edtMonthlyTransportation);
        edtAnnualElectricity = (EditText) mView.findViewById(R.id.edtAnnualElectricity);
        edtMonthlyElectricity = (EditText) mView.findViewById(R.id.edtMonthlyElectricity);
        edtAnnualOther = (EditText) mView.findViewById(R.id.edtAnnualOther);
        edtMonthlyOther = (EditText) mView.findViewById(R.id.edtMonthlyOther);

        //SET COMPULSERY TITLES
        txtTitleFood.setText(CommonMethods.spannableString(getResources().getString(R.string.strFood)));
        txtTitleEducation.setText(CommonMethods.spannableString(getResources().getString(R.string.strEducation)));
        txtTitleHealth.setText(CommonMethods.spannableString(getResources().getString(R.string.strHealth)));
        txtTitleCloths.setText(CommonMethods.spannableString(getResources().getString(R.string.strClothes)));
        txtTitleFestivals.setText(CommonMethods.spannableString(getResources().getString(R.string.strFestivals)));
        txtTitleTransportation.setText(CommonMethods.spannableString(getResources().getString(R.string.strTransportation)));
        txtTitleElectricity.setText(CommonMethods.spannableString(getResources().getString(R.string.strElecricity)));
        txtTitleOther.setText(CommonMethods.spannableString(getResources().getString(R.string.strOther)));


        //GET DATA FROM DATABASE
        mList = mDatabaseHelper.getAllFamilyExpendituresList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));

        //CHECK IF DATA IS AVAILABLE
        if (mList.size() != 0) {

            Double dblTotalAnnualExpense = 0.0;

            CommonMethods.printLog("AVAILABLE ENTERPRENEUR EXPENDITURE DATA : ", new Gson().toJson(mDatabaseHelper.getAllFamilyExpendituresList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)))));

            edtAnnualFood.setText(String.valueOf(mList.get(0).getAnnualExpence()));
            edtAnnualEducation = (EditText) mView.findViewById(R.id.edtAnnualEducation);
            edtAnnualHealth = (EditText) mView.findViewById(R.id.edtAnnualHealth);
            edtAnnualCloths = (EditText) mView.findViewById(R.id.edtAnnualCloths);
            edtAnnualFestivals = (EditText) mView.findViewById(R.id.edtAnnualFestivals);
            edtAnnualTransportation = (EditText) mView.findViewById(R.id.edtAnnualTransportation);
            edtAnnualElectricity = (EditText) mView.findViewById(R.id.edtAnnualElectricity);
            edtAnnualOther = (EditText) mView.findViewById(R.id.edtAnnualOther);

            for (int j = 0; j < mList.size(); j++) {

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strFood))) {
                    edtAnnualFood.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyFood.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strEducation))) {
                    edtAnnualEducation.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyEducation.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strHealth))) {
                    edtAnnualHealth.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyHealth.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strClothes))) {
                    edtAnnualCloths.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyCloths.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strFestivals))) {
                    edtAnnualFestivals.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyFestivals.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strTransport))) {
                    edtAnnualTransportation.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyTransportation.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strElecricity))) {
                    edtAnnualElectricity.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyElectricity.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                if (mList.get(j).getItemType().equalsIgnoreCase(getResources().getString(R.string.strOther))) {
                    edtAnnualOther.setText(String.valueOf(mList.get(j).getAnnualExpence()));
                    edtMonthlyOther.setText(String.valueOf(mList.get(j).getMonthlyExpence()));
                }

                dblTotalAnnualExpense = (dblTotalAnnualExpense + mList.get(j).getAnnualExpence());
            }

            //SET TOTAL AMOUNT
            txtTotalExpense.setVisibility(View.VISIBLE);
            txtTotalExpense.setText(getResources().getString(R.string.strTotalExpanditure) + dblTotalAnnualExpense.intValue() + getResources().getString(R.string.strRupeeSymbol));

            //CHNAGE SUBMIT TEXT TO UPDATE
            txtSubmitData.setText(getResources().getString(R.string.strUpdate));


        }


        //MAKE CALCULATIONS FOR ANNUAL TO MONTHLY

        edtAnnualFood.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {

                    Double dblAnnual = Double.valueOf(edtAnnualFood.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyFood.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyFood.setText("");
                }

            }
        });

        edtAnnualEducation.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    Double dblAnnual = Double.valueOf(edtAnnualEducation.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyEducation.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyEducation.setText("");
                }

            }
        });

        edtAnnualHealth.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    Double dblAnnual = Double.valueOf(edtAnnualHealth.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyHealth.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyHealth.setText("");
                }

            }
        });

        edtAnnualCloths.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    Double dblAnnual = Double.valueOf(edtAnnualCloths.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyCloths.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyCloths.setText("");
                }

            }
        });

        edtAnnualFestivals.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    Double dblAnnual = Double.valueOf(edtAnnualFestivals.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyFestivals.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyFestivals.setText("");
                }

            }
        });
        edtAnnualTransportation.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    Double dblAnnual = Double.valueOf(edtAnnualTransportation.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyTransportation.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyTransportation.setText("");
                }

            }
        });

        edtAnnualElectricity.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    Double dblAnnual = Double.valueOf(edtAnnualElectricity.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyElectricity.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyElectricity.setText("");
                }

            }
        });

        edtAnnualOther.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    Double dblAnnual = Double.valueOf(edtAnnualOther.getText().toString());
                    Double dblMonthly = dblAnnual / 12;

                    edtMonthlyOther.setText(String.valueOf(dblMonthly.intValue()));
                } catch (NumberFormatException e) {
                    edtMonthlyOther.setText("");
                }

            }
        });


    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtSubmitData:

                if (checkValidation()) {

                    ExpanditureModel expanditureModel1 = new ExpanditureModel();
                    try {
                        expanditureModel1.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel1.setItemType(getResources().getString(R.string.strFood));
                        expanditureModel1.setId(System.currentTimeMillis() + 1);
                        expanditureModel1.setMonthlyExpence(Double.parseDouble(edtMonthlyFood.getText().toString()));
                        expanditureModel1.setAnnualExpence(Double.parseDouble(edtAnnualFood.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel1.setMonthlyExpence(0.0);
                        expanditureModel1.setAnnualExpence(0.0);
                    }

                    ExpanditureModel expanditureModel2 = new ExpanditureModel();
                    try {
                        expanditureModel2.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel2.setItemType(getResources().getString(R.string.strEducation));
                        expanditureModel2.setId(System.currentTimeMillis() + 2);
                        expanditureModel2.setMonthlyExpence(Double.parseDouble(edtMonthlyEducation.getText().toString()));
                        expanditureModel2.setAnnualExpence(Double.parseDouble(edtAnnualEducation.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel2.setMonthlyExpence(0.0);
                        expanditureModel2.setAnnualExpence(0.0);
                    }


                    ExpanditureModel expanditureModel3 = new ExpanditureModel();
                    try {
                        expanditureModel3.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel3.setItemType(getResources().getString(R.string.strHealth));
                        expanditureModel3.setId(System.currentTimeMillis() + 3);
                        expanditureModel3.setMonthlyExpence(Double.parseDouble(edtMonthlyHealth.getText().toString()));
                        expanditureModel3.setAnnualExpence(Double.parseDouble(edtAnnualHealth.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel3.setMonthlyExpence(0.0);
                        expanditureModel3.setAnnualExpence(0.0);
                    }


                    ExpanditureModel expanditureModel4 = new ExpanditureModel();
                    try {
                        expanditureModel4.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel4.setItemType(getResources().getString(R.string.strClothes));
                        expanditureModel4.setId(System.currentTimeMillis() + 4);
                        expanditureModel4.setMonthlyExpence(Double.parseDouble(edtMonthlyCloths.getText().toString()));
                        expanditureModel4.setAnnualExpence(Double.parseDouble(edtAnnualCloths.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel4.setMonthlyExpence(0.0);
                        expanditureModel4.setAnnualExpence(0.0);
                    }

                    ExpanditureModel expanditureModel5 = new ExpanditureModel();
                    try {
                        expanditureModel5.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel5.setItemType(getResources().getString(R.string.strFestivals));
                        expanditureModel5.setId(System.currentTimeMillis() + 5);
                        expanditureModel5.setMonthlyExpence(Double.parseDouble(edtMonthlyFestivals.getText().toString()));
                        expanditureModel5.setAnnualExpence(Double.parseDouble(edtAnnualFestivals.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel5.setMonthlyExpence(0.0);
                        expanditureModel5.setAnnualExpence(0.0);
                    }

                    ExpanditureModel expanditureModel6 = new ExpanditureModel();
                    try {
                        expanditureModel6.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel6.setItemType(getResources().getString(R.string.strTransport));
                        expanditureModel6.setId(System.currentTimeMillis() + 6);
                        expanditureModel6.setMonthlyExpence(Double.parseDouble(edtMonthlyTransportation.getText().toString()));
                        expanditureModel6.setAnnualExpence(Double.parseDouble(edtAnnualTransportation.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel6.setMonthlyExpence(0.0);
                        expanditureModel6.setAnnualExpence(0.0);
                    }

                    ExpanditureModel expanditureModel7 = new ExpanditureModel();
                    try {
                        expanditureModel7.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel7.setItemType(getResources().getString(R.string.strElecricity));
                        expanditureModel7.setId(System.currentTimeMillis() + 7);
                        expanditureModel7.setMonthlyExpence(Double.parseDouble(edtMonthlyElectricity.getText().toString()));
                        expanditureModel7.setAnnualExpence(Double.parseDouble(edtAnnualElectricity.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel7.setMonthlyExpence(0.0);
                        expanditureModel7.setAnnualExpence(0.0);
                    }

                    ExpanditureModel expanditureModel8 = new ExpanditureModel();
                    try {
                        expanditureModel8.setEntrepreneurId(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)));
                        expanditureModel8.setItemType(getResources().getString(R.string.strOther));
                        expanditureModel8.setId(System.currentTimeMillis() + 8);
                        expanditureModel8.setMonthlyExpence(Double.parseDouble(edtMonthlyOther.getText().toString()));
                        expanditureModel8.setAnnualExpence(Double.parseDouble(edtAnnualOther.getText().toString()));
                    } catch (NumberFormatException e) {
                        expanditureModel8.setMonthlyExpence(0.0);
                        expanditureModel8.setAnnualExpence(0.0);
                    }

                    //
                    ArrayList<ExpanditureModel> expanditureModelArrayList = new ArrayList<ExpanditureModel>();
                    expanditureModelArrayList.add(expanditureModel1);
                    expanditureModelArrayList.add(expanditureModel2);
                    expanditureModelArrayList.add(expanditureModel3);
                    expanditureModelArrayList.add(expanditureModel4);
                    expanditureModelArrayList.add(expanditureModel5);
                    expanditureModelArrayList.add(expanditureModel6);
                    expanditureModelArrayList.add(expanditureModel7);
                    expanditureModelArrayList.add(expanditureModel8);

/*

                    //INSERT EXPENDITURE DETAILS FOR
                    mDatabaseHelper.clearEntrepreneurExpenditureRegistrationTable();

                    mDatabaseHelper.insertEntrepreneurExpenditureRegistration(
                            new Gson().toJson(expanditureModelArrayList)//1
                    );
*/


                    //INSERT EXPENDITURE DETAILS
                    for (int i = 0; i < expanditureModelArrayList.size(); i++) {

                        if (mList.size() != 0) {
                            mDatabaseHelper.updateFamilyExpenditureList(
                                    new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)), //1
                                    new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)), //2
                                    System.currentTimeMillis(), //3
                                    mList.get(i).getId(), //4
                                    expanditureModelArrayList.get(i).getItemType(), //5
                                    expanditureModelArrayList.get(i).getMonthlyExpence(), //6
                                    expanditureModelArrayList.get(i).getAnnualExpence(), //7
                                    mList.get(i).getEntrepreneurId(),//8
                                    0L, //9
                                    Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),//10
                                    Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),//11
                                    0//12
                            );
                        } else {
                            mDatabaseHelper.insertFamilyExpenditureList(
                                    new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)), //1
                                    new Long(mSessionManager.getPreferenceInt(Constants.USER_WORKER_ID)), //2
                                    System.currentTimeMillis(), //3
                                    expanditureModelArrayList.get(i).getId(), //4
                                    expanditureModelArrayList.get(i).getItemType(), //5
                                    expanditureModelArrayList.get(i).getMonthlyExpence(), //6
                                    expanditureModelArrayList.get(i).getAnnualExpence(), //7
                                    Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)),//8
                                    0L, //9
                                    Double.parseDouble(mSessionManager.getPreference(Constants.USER_LATITUDE)),//10
                                    Double.parseDouble(mSessionManager.getPreference(Constants.USER_LONGITUDE)),//11
                                    0//12
                            );
                        }

                    }


                    //MOVE BACK
                    //GET ENTERPRENEUR EXPENDITURE DATA
                    CommonMethods.printLog("INSERT ENTERPRENEUR EXPENDITURE DATA : ", new Gson().toJson(mDatabaseHelper.getAllFamilyExpendituresList(Long.valueOf(getArguments().getString(Constants.ENTERPRENEUR_ID)))));


                    //Move to  enterpreneur details page
                    navController.popBackStack(R.id.enterprenuerDetails, false);

                }

                break;
        }

    }

    private boolean checkValidation() {

        if (edtAnnualFood.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorFoodExpens));
            return false;
        } else if (edtAnnualEducation.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorEducationExpens));
            return false;
        } else if (edtAnnualHealth.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorHealthExpens));
            return false;
        } else if (edtAnnualCloths.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorClothsExpens));
            return false;
        } else if (edtAnnualFestivals.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorFestivalsExpens));
            return false;
        } else if (edtAnnualTransportation.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorTransportExpens));
            return false;
        } else if (edtAnnualElectricity.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorElectricityExpens));
            return false;
        } else if (edtAnnualOther.getText().toString().length() == 0) {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strErrorOtherExpens));
            return false;
        } else {
            return true;
        }


    }
}

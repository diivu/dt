package com.triapp.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.triapp.Adapter.ExistingGrowthPlanGrowthPurposeAdapter;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.SessionManager;
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

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class ExistingEnterpriseDetailsFragment extends Fragment implements View.OnClickListener, TextWatcher {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "ExistingEnterpriseDetailsFragment";

    private View mView;
    public NavController navController;
    public NavigationView navigationView;
    private SessionManager mSessionManager;
    private TextView txtDone,txtSubmitData, txtInvestmentRequirments, txtNewProposal, txtGrowthPurpose, txtUploadEnterpriseImage, txtNetprofitPerMonth, txtTotalExpense, txtOtherExpense, txtTaxes, txtDepriciation, txtWastage, txtInterest, txtTransport, txtElectricity, txtWages, txtRent, txtWorkingCapitals, txtAverageValueOfPayble, txtAverageValueOfRecivables, txtAverageValueOFinventory, txtOwnInvestment, txtTotalFixedAssest, txtGrossProfit, txtCostOfGoods, txtPresentCapacity, txtPresentRevenue;
    private EditText edtInvestmentRequirments, edtNewProposal, edtGrowthPurpose, edtUploadEnterpriseImage, edtNetprofitPerMonth, edtTotalExpenses, edtOtherExpense, edtTaxes, edtDepriciation, edtWastage, edtInterest, edtTransport, edtElectricity, edtWages, edtRent, edtWorkingCapitals, edtOwnInvestment, edtAverageValueOfRecivables, edtAverageValueOfPayble, edtTotalFixedAssest, edtAverageValueOFinventory, edtGrossProfit, edtPresentRevenue, edtCostOfGoods, edtPresentCapacity;
    private Double dblWorkingCapital = 0.0, dblCostOfGoods = 0.0, dblTotalExpense = 0.0, dblNetProfit = 0.0, dblGrossProfit = 0.0, dblPresentRevenue = 0.0;
    private Dialog dialogPurposeList;
    private ListView listItems;
    private DatabaseHelper mDatabaseHelper;
    private ArrayList<Long> selcectedGrowthPurposeIds;
    private ArrayList<String> selcectedGrowthPurposeItems;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).setTitle(getActivity().getResources().getString(R.string.strExistingEnterpriseDetails));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(null);
        mView = inflater.inflate(R.layout.existing_enterprise_details_fragment, container, false);

        setIds();
        setOnClicks();


        return mView;


    }

    private void setOnClicks() {

        edtGrowthPurpose.setOnClickListener(this);
        edtUploadEnterpriseImage.setOnClickListener(this);

        edtRent.addTextChangedListener(this);
        edtWages.addTextChangedListener(this);
        edtElectricity.addTextChangedListener(this);
        edtTransport.addTextChangedListener(this);
        edtInterest.addTextChangedListener(this);
        edtDepriciation.addTextChangedListener(this);
        edtTaxes.addTextChangedListener(this);
        edtWastage.addTextChangedListener(this);

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

        selcectedGrowthPurposeIds = new ArrayList<>();
        selcectedGrowthPurposeItems = new ArrayList<>();

        selcectedGrowthPurposeIds.clear();
        selcectedGrowthPurposeItems.clear();


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        txtPresentRevenue = (TextView) mView.findViewById(R.id.txtPresentRevenue);
        txtPresentCapacity = (TextView) mView.findViewById(R.id.txtPresentCapacity);
        txtCostOfGoods = (TextView) mView.findViewById(R.id.txtCostOfGoods);
        txtGrossProfit = (TextView) mView.findViewById(R.id.txtGrossProfit);
        txtTotalFixedAssest = (TextView) mView.findViewById(R.id.txtTotalFixedAssest);
        txtOwnInvestment = (TextView) mView.findViewById(R.id.txtOwnInvestment);
        txtAverageValueOFinventory = (TextView) mView.findViewById(R.id.txtAverageValueOFinventory);
        txtAverageValueOfRecivables = (TextView) mView.findViewById(R.id.txtAverageValueOfRecivables);
        txtAverageValueOfPayble = (TextView) mView.findViewById(R.id.txtAverageValueOfPayble);
        txtWorkingCapitals = (TextView) mView.findViewById(R.id.txtWorkingCapitals);
        txtRent = (TextView) mView.findViewById(R.id.txtRent);
        txtWages = (TextView) mView.findViewById(R.id.txtWages);
        txtElectricity = (TextView) mView.findViewById(R.id.txtElectricity);
        txtTransport = (TextView) mView.findViewById(R.id.txtTransport);
        txtInterest = (TextView) mView.findViewById(R.id.txtInterest);
        txtWastage = (TextView) mView.findViewById(R.id.txtWastage);
        txtDepriciation = (TextView) mView.findViewById(R.id.txtDepriciation);
        txtTaxes = (TextView) mView.findViewById(R.id.txtTaxes);
        txtOtherExpense = (TextView) mView.findViewById(R.id.txtOtherExpense);
        txtTotalExpense = (TextView) mView.findViewById(R.id.txtTotalExpense);
        txtNetprofitPerMonth = (TextView) mView.findViewById(R.id.txtNetprofitPerMonth);
        txtUploadEnterpriseImage = (TextView) mView.findViewById(R.id.txtUploadEnterpriseImage);
        txtGrowthPurpose = (TextView) mView.findViewById(R.id.txtGrowthPurpose);
        txtNewProposal = (TextView) mView.findViewById(R.id.txtNewProposal);
        txtInvestmentRequirments = (TextView) mView.findViewById(R.id.txtInvestmentRequirments);
        txtSubmitData = (TextView) mView.findViewById(R.id.txtSubmitData);

        edtPresentCapacity = (EditText) mView.findViewById(R.id.edtPresentCapacity);
        edtPresentRevenue = (EditText) mView.findViewById(R.id.edtPresentRevenue);
        edtCostOfGoods = (EditText) mView.findViewById(R.id.edtCostOfGoods);
        edtGrossProfit = (EditText) mView.findViewById(R.id.edtGrossProfit);
        edtAverageValueOFinventory = (EditText) mView.findViewById(R.id.edtAverageValueOFinventory);
        edtTotalFixedAssest = (EditText) mView.findViewById(R.id.edtTotalFixedAssest);
        edtAverageValueOfPayble = (EditText) mView.findViewById(R.id.edtAverageValueOfPayble);
        edtAverageValueOfRecivables = (EditText) mView.findViewById(R.id.edtAverageValueOfRecivables);
        edtOwnInvestment = (EditText) mView.findViewById(R.id.edtOwnInvestment);
        edtWorkingCapitals = (EditText) mView.findViewById(R.id.edtWorkingCapitals);
        edtRent = (EditText) mView.findViewById(R.id.edtRent);
        edtWages = (EditText) mView.findViewById(R.id.edtWages);
        edtElectricity = (EditText) mView.findViewById(R.id.edtElectricity);
        edtTransport = (EditText) mView.findViewById(R.id.edtTransport);
        edtInterest = (EditText) mView.findViewById(R.id.edtInterest);
        edtWastage = (EditText) mView.findViewById(R.id.edtWastage);
        edtDepriciation = (EditText) mView.findViewById(R.id.edtDepriciation);
        edtTaxes = (EditText) mView.findViewById(R.id.edtTaxes);
        edtOtherExpense = (EditText) mView.findViewById(R.id.edtOtherExpense);
        edtTotalExpenses = (EditText) mView.findViewById(R.id.edtTotalExpenses);
        edtNetprofitPerMonth = (EditText) mView.findViewById(R.id.edtNetprofitPerMonth);
        edtUploadEnterpriseImage = (EditText) mView.findViewById(R.id.edtUploadEnterpriseImage);
        edtGrowthPurpose = (EditText) mView.findViewById(R.id.edtGrowthPurpose);
        edtNewProposal = (EditText) mView.findViewById(R.id.edtNewProposal);
        edtInvestmentRequirments = (EditText) mView.findViewById(R.id.edtInvestmentRequirments);

        //Set title compulsory
        txtPresentRevenue.setText(CommonMethods.spannableString(getResources().getString(R.string.strPresentRevenue)));
        txtPresentCapacity.setText(CommonMethods.spannableString(getResources().getString(R.string.strPresentCapacity)));
        txtCostOfGoods.setText(CommonMethods.spannableString(getResources().getString(R.string.strCostOfGoodsSold)));
        txtGrossProfit.setText(CommonMethods.spannableString(getResources().getString(R.string.strGrossProfit)));
        txtTotalFixedAssest.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalFixedAsset)));
        txtOwnInvestment.setText(CommonMethods.spannableString(getResources().getString(R.string.strOwnInvestment)));
        txtAverageValueOFinventory.setText(CommonMethods.spannableString(getResources().getString(R.string.strAverageValueOfInventory)));
        txtAverageValueOfRecivables.setText(CommonMethods.spannableString(getResources().getString(R.string.strAverageValueOfReceivable)));
        txtAverageValueOfPayble.setText(CommonMethods.spannableString(getResources().getString(R.string.strAverageValueOfPayables)));
        txtWorkingCapitals.setText(CommonMethods.spannableString(getResources().getString(R.string.strWorkingCapital)));
        txtRent.setText(CommonMethods.spannableString(getResources().getString(R.string.strRent)));
        txtWages.setText(CommonMethods.spannableString(getResources().getString(R.string.strWages)));
        txtElectricity.setText(CommonMethods.spannableString(getResources().getString(R.string.strElectricity)));
        txtTransport.setText(CommonMethods.spannableString(getResources().getString(R.string.strTransport)));
        txtInterest.setText(CommonMethods.spannableString(getResources().getString(R.string.strInterest)));
        txtWastage.setText(CommonMethods.spannableString(getResources().getString(R.string.strWastage)));
        txtDepriciation.setText(CommonMethods.spannableString(getResources().getString(R.string.strDepriciation)));
        txtTaxes.setText(CommonMethods.spannableString(getResources().getString(R.string.strTaxes)));
        txtOtherExpense.setText(CommonMethods.spannableString(getResources().getString(R.string.strOtherExpenses)));
        txtTotalExpense.setText(CommonMethods.spannableString(getResources().getString(R.string.strTotalExpenses)));
        txtNetprofitPerMonth.setText(CommonMethods.spannableString(getResources().getString(R.string.strNetProfit)));
        txtUploadEnterpriseImage.setText(CommonMethods.spannableString(getResources().getString(R.string.strUploadExistingEnterpriseImage)));
        txtGrowthPurpose.setText(CommonMethods.spannableString(getResources().getString(R.string.strGrowthPlanGrowthPurpose)));
        txtNewProposal.setText(CommonMethods.spannableString(getResources().getString(R.string.strGrowthPlanNewProposal)));
        txtInvestmentRequirments.setText(CommonMethods.spannableString(getResources().getString(R.string.strGrowthPlanInvestMentRequired)));


        //CALCULATION FOR GROSS PFOFIT (PRESENT REVENUE - COST OF GOODS)

        edtPresentRevenue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                edtPresentCapacity.setText(edtPresentRevenue.getText().toString());

                try {
                    dblPresentRevenue = Double.valueOf(edtPresentCapacity.getText().toString());
                    dblCostOfGoods = Double.valueOf(edtCostOfGoods.getText().toString());

                    //CALACULATION FOR GROSS PROFIT
                    dblGrossProfit = dblPresentRevenue - dblCostOfGoods;
                    edtGrossProfit.setText("" + dblGrossProfit.intValue());

                    //CALACULATION FOR NET PROFIT
                    dblNetProfit = dblGrossProfit - dblTotalExpense;
                    edtNetprofitPerMonth.setText("" + dblNetProfit.intValue());


                } catch (NumberFormatException n) {
                    edtGrossProfit.setText("");
                    edtNetprofitPerMonth.setText("");
                }
            }
        });

        edtCostOfGoods.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable mString) {

                try {
                    dblPresentRevenue = Double.valueOf(edtPresentRevenue.getText().toString());
                    dblCostOfGoods = Double.valueOf(edtCostOfGoods.getText().toString());

                    if (dblCostOfGoods > dblPresentRevenue) {
                        edtCostOfGoods.setText("");
                        edtCostOfGoods.setError(mContext.getResources().getString(R.string.strErrorCostOfGoods));
                    } else {
                        edtCostOfGoods.setError(null);
                        //CALACULATION FOR GROSS PROFIT
                        dblGrossProfit = dblPresentRevenue - dblCostOfGoods;
                        edtGrossProfit.setText("" + dblGrossProfit.intValue());

                        //CALACULATION FOR NET PROFIT
                        dblNetProfit = dblGrossProfit - dblTotalExpense;
                        edtNetprofitPerMonth.setText("" + dblNetProfit.intValue());
                    }


                } catch (NumberFormatException n) {
                    edtGrossProfit.setText("");
                    edtNetprofitPerMonth.setText("");
                }


            }
        });

        edtAverageValueOfPayble.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                if (edtAverageValueOFinventory.getText().toString().length() != 0 && edtAverageValueOfRecivables.getText().toString().length() != 0 && edtAverageValueOfPayble.getText().toString().length() != 0) {
                    try {
                        Double dblAddReceivables = Double.valueOf(edtAverageValueOFinventory.getText().toString()) + Double.valueOf(edtAverageValueOfRecivables.getText().toString());
                        dblWorkingCapital = dblAddReceivables - Double.valueOf(edtAverageValueOfPayble.getText().toString());
                        edtWorkingCapitals.setText("" + dblWorkingCapital.intValue());
                    } catch (NumberFormatException n) {
                        edtWorkingCapitals.setText("");
                    }
                } else {
                    edtWorkingCapitals.setText("");
                }


            }
        });

        edtAverageValueOFinventory.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (edtAverageValueOFinventory.getText().toString().length() != 0 && edtAverageValueOfRecivables.getText().toString().length() != 0 && edtAverageValueOfPayble.getText().toString().length() != 0) {
                    try {
                        Double dblAddReceivables = Double.valueOf(edtAverageValueOFinventory.getText().toString()) + Double.valueOf(edtAverageValueOfRecivables.getText().toString());
                        dblWorkingCapital = dblAddReceivables - Double.valueOf(edtAverageValueOfPayble.getText().toString());
                        edtWorkingCapitals.setText("" + dblWorkingCapital.intValue());

                    } catch (NumberFormatException n) {
                        edtWorkingCapitals.setText("");
                    }
                } else {
                    edtWorkingCapitals.setText("");
                }


            }
        });

        edtAverageValueOfRecivables.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtAverageValueOFinventory.getText().toString().length() != 0 && edtAverageValueOfRecivables.getText().toString().length() != 0 && edtAverageValueOfPayble.getText().toString().length() != 0) {
                    try {
                        Double dblAddReceivables = Double.valueOf(edtAverageValueOFinventory.getText().toString()) + Double.valueOf(edtAverageValueOfRecivables.getText().toString());
                        dblWorkingCapital = dblAddReceivables - Double.valueOf(edtAverageValueOfPayble.getText().toString());
                        edtWorkingCapitals.setText("" + dblWorkingCapital.intValue());

                    } catch (NumberFormatException n) {
                        edtWorkingCapitals.setText("");
                    }
                } else {
                    edtWorkingCapitals.setText("");
                }

            }
        });

        edtOtherExpense.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                try {

                    dblTotalExpense = Double.valueOf(edtRent.getText().toString()) +
                            Double.valueOf(edtWastage.getText().toString()) +
                            Double.valueOf(edtElectricity.getText().toString()) +
                            Double.valueOf(edtTransport.getText().toString()) +
                            Double.valueOf(edtInterest.getText().toString()) +
                            Double.valueOf(edtWastage.getText().toString()) +
                            Double.valueOf(edtDepriciation.getText().toString()) +
                            Double.valueOf(edtTaxes.getText().toString()) +
                            Double.valueOf(edtOtherExpense.getText().toString());

                    edtTotalExpenses.setText("" + dblTotalExpense.intValue());
                    dblNetProfit = dblGrossProfit - dblTotalExpense;
                    edtNetprofitPerMonth.setText("" + dblNetProfit.intValue());

                } catch (NumberFormatException n) {
                    edtTotalExpenses.setText("");
                }
            }
        });


    }


    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

           case  R.id.edtGrowthPurpose:

               openPurposeListDialog();
               break;

            case R.id.edtUploadEnterpriseImage:


                break;

        }

    }

    private void openPurposeListDialog() {

        dialogPurposeList = new Dialog(mContext, R.style.MY_DIALOG);
        dialogPurposeList.setContentView(R.layout.general_list_dialog_with_done);

        dialogPurposeList.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ImageView imgBack = (ImageView) dialogPurposeList.findViewById(R.id.imgBack);
        TextView txtTitle = (TextView) dialogPurposeList.findViewById(R.id.txtTitle);
        txtTitle.setText(getResources().getString(R.string.strSelectItems));

        listItems = (ListView) dialogPurposeList.findViewById(R.id.listItems);
        txtDone = (TextView) dialogPurposeList.findViewById(R.id.txtDone);

        ExistingGrowthPlanGrowthPurposeAdapter mExistingGrowthPlanGrowthPurposeAdapter = new ExistingGrowthPlanGrowthPurposeAdapter(mContext, mDatabaseHelper.getNewGrowthPlanPurposeList(), selcectedGrowthPurposeIds, selcectedGrowthPurposeItems);
        listItems.setAdapter(mExistingGrowthPlanGrowthPurposeAdapter);


        txtDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selcectedGrowthPurposeIds = ExistingGrowthPlanGrowthPurposeAdapter.clickedItem;
                selcectedGrowthPurposeItems = ExistingGrowthPlanGrowthPurposeAdapter.clickedValues;

                if (selcectedGrowthPurposeItems.size() != 0) {
                    edtGrowthPurpose.setText(selcectedGrowthPurposeItems.toString().replace("[", "").replace("]", ""));
                } else {
                    edtGrowthPurpose.setText("");
                }

                dialogPurposeList.dismiss();

            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPurposeList.dismiss();
            }
        });

        dialogPurposeList.setCanceledOnTouchOutside(false);
        dialogPurposeList.setCancelable(true);
        dialogPurposeList.show();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void afterTextChanged(Editable editable) {

        try {

            dblTotalExpense = Double.valueOf(edtRent.getText().toString()) +
                    Double.valueOf(edtWages.getText().toString()) +
                    Double.valueOf(edtElectricity.getText().toString()) +
                    Double.valueOf(edtTransport.getText().toString()) +
                    Double.valueOf(edtInterest.getText().toString()) +
                    Double.valueOf(edtWastage.getText().toString()) +
                    Double.valueOf(edtDepriciation.getText().toString()) +
                    Double.valueOf(edtTaxes.getText().toString()) +
                    Double.valueOf(edtOtherExpense.getText().toString());

            edtTotalExpenses.setText("" + dblTotalExpense.intValue());
            dblNetProfit = dblGrossProfit - dblTotalExpense;
            edtNetprofitPerMonth.setText("" + dblNetProfit.intValue());

        } catch (NumberFormatException n) {
            edtTotalExpenses.setText("");
        }
    }
}

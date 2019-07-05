package com.triapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.droidnet.DroidListener;
import com.droidnet.DroidNet;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.GrowthPlanGrowthPurposeListModel;
import com.triapp.Models.UserBasicDetailsModel;
import com.triapp.R;
import com.triapp.RetrofitClass.UpdateAllAPI;
import com.triapp.SqliteDatabase.DatabaseHelper;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DroidListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "MainActivity";

    public Toolbar toolbar;

    public DrawerLayout drawerLayout;

    public NavController navController;

    public NavigationView navigationView;

    private TextView txtMobileUserName, txtMobileNumber,  txtinternetNotWorking;
    public static TextView txtUsername;
    private DroidNet mDroidNet;

    private Resources mResources;
    private Locale mLocal;
    private LinearLayout linearInternetNotWorking;
    private View headerView;
    private SessionManager mSessionManager;
    boolean doubleBackToExitPressedOnce = false;
    private DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
        getAllBasicDetails();

    }

    private void getAllBasicDetails() {

        if (CommonMethods.isInternetAvailable(mContext)) {
            callBasicWebservice();
            callGetNewGrowthPlanPurposeList();
        } else {
            CommonMethods.displayToast(mContext, getResources().getString(R.string.strNoInternetAvailable));
        }
    }


    //Setting Up One Time Navigation
    private void setupNavigation() {

        mActivity = MainActivity.this;
        mContext = MainActivity.this;

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

        //Hide softkeybord
        CommonMethods.hideKeybord(mActivity);

        txtinternetNotWorking = (TextView) findViewById(R.id.txtinternetNotWorking);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtMobileNumber = (TextView) findViewById(R.id.txtMobileNumber);
        linearInternetNotWorking = (LinearLayout) findViewById(R.id.linearInternetNotWorking);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.setItemIconTintList(null);

        //Headet view text
        headerView = navigationView.getHeaderView(0);

        txtMobileUserName = (TextView) headerView.findViewById(R.id.txtMobileUserName);

        //Set user name in to side bar menu
        txtMobileUserName.setText(mSessionManager.getPreference(Constants.USER_NAME));

        //SET ENTERPRENEUR NAME DYNAMIC
        setDynmaicEnterpreneurName("");

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(drawerLayout, Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        menuItem.setChecked(true);

        drawerLayout.closeDrawers();

        int id = menuItem.getItemId();

        switch (id) {

            case R.id.homeFragment:
                navController.navigate(R.id.homeFragment);
                break;
            case R.id.registeredEnterpreneur:
                navController.navigate(R.id.registeredEnterpreneur);
                break;
            case R.id.logout:
                CommonMethods.logoutDialog(mActivity, R.style.DialogTheme, getResources().getString(R.string.strLogoutText));
                break;
            case R.id.businessIdeation:
                CommonMethods.displayToast(mContext, getResources().getString(R.string.strWorking));
                break;
            case R.id.businessPlan:
                navController.navigate(R.id.businessPlan);
                break;
            case R.id.enterpriseTracking:
                navController.navigate(R.id.enterpriseTracking);
                break;
            case R.id.campaign:
                navController.navigate(R.id.campaignFragment);
                break;

        }
        return true;

    }
    public  static void setDynmaicEnterpreneurName(String msgToBeDisplay){

        //Set user name in to side bar menu
        txtUsername.setText(""+msgToBeDisplay);
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {

        if (isConnected) {
            txtinternetNotWorking.setText(getResources().getString(R.string.strInternetAvailable));
            linearInternetNotWorking.setBackgroundColor(getResources().getColor(R.color.colorGreenDark));
        } else {
            txtinternetNotWorking.setText(getResources().getString(R.string.strNoInternetAvailable));
            linearInternetNotWorking.setBackgroundColor(getResources().getColor(R.color.colorRedDark));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Internet connection code
        mDroidNet = DroidNet.getInstance();
        mDroidNet.addInternetConnectivityListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Remove Internet listner
        mDroidNet.removeInternetConnectivityChangeListener(this);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }


        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;

        CommonMethods.displayToast(mContext, getResources().getString(R.string.strClickBackAgainToExit));

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 20000);
    }

    private void callBasicWebservice() {

        //Open dialog
        CommonMethods.showDialog(mContext , getResources().getString(R.string.strPleaseWait));

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Request original = chain.request();

                okhttp3.Request request = original.newBuilder()
                        .header("Content-Type", "application/json; charset=utf-8")
                        .header("Authorization", mSessionManager.getPreference(Constants.USER_ACCESS_TOKEN))
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        final OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_END_POINTS)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(client)
                .client(client.newBuilder().connectTimeout(30000, TimeUnit.SECONDS).readTimeout(30000, TimeUnit.SECONDS).writeTimeout(30000, TimeUnit.SECONDS).build())
                .build();

        UpdateAllAPI patchService1 = retrofit.create(UpdateAllAPI.class);

        Call<UserBasicDetailsModel> call = patchService1.getRawData(Constants.API_BASIC_DETAILS + mSessionManager.getPreferenceInt(Constants.USER_ID));
        call.enqueue(new Callback<UserBasicDetailsModel>() {
            @Override
            public void onResponse(Call<UserBasicDetailsModel> call, Response<UserBasicDetailsModel> response) {

                CommonMethods.displayLog(TAG, "Response @ BasicAPI: " + response.isSuccessful());
                CommonMethods.displayLog(TAG, "Response @ BasicAPI: " + response.code());

                Gson gson = new Gson();
                CommonMethods.displayLog(TAG, "Response @ BasicAPI: " + gson.toJson(response));


                if (response.isSuccessful()) {
                    int intCode = response.body().getCode();
                    switch (intCode) {
                        case 1:
                            try {

                                storeBasicDataIntoDatabase(response);

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }

                            break;

                        case 2:

                            break;
                    }

                    //Close progress dialog
                    CommonMethods.closeDialog();

                }
            }

            @Override
            public void onFailure(Call<UserBasicDetailsModel> call, Throwable t) {
                CommonMethods.displayLog(TAG, "Error @ BasicAPI: " + t.getMessage());
                //Close progress dialog
                CommonMethods.closeDialog();
            }
        });

    }

    private void callGetNewGrowthPlanPurposeList() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Request original = chain.request();

                okhttp3.Request request = original.newBuilder()
                        .header("Content-Type", "application/json; charset=utf-8")
                        .header("Authorization", mSessionManager.getPreference(Constants.USER_ACCESS_TOKEN))
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        final OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_END_POINTS)
                .addConverterFactory(GsonConverterFactory.create())
                // .client(client)
                .client(client.newBuilder().connectTimeout(30000, TimeUnit.SECONDS).readTimeout(30000, TimeUnit.SECONDS).writeTimeout(30000, TimeUnit.SECONDS).build())
                .build();

        UpdateAllAPI patchService1 = retrofit.create(UpdateAllAPI.class);

        Call<GrowthPlanGrowthPurposeListModel> webCall = patchService1.getNewGrowthPlanPurposeList();
        webCall.enqueue(new Callback<GrowthPlanGrowthPurposeListModel>() {
            @Override
            public void onResponse(Call<GrowthPlanGrowthPurposeListModel> call, Response<GrowthPlanGrowthPurposeListModel> response) {

                CommonMethods.displayLog(TAG, "Response @ callGetNewGrowthPlanPurposeList: " + response.code());
                CommonMethods.displayLog(TAG, "Response @ callGetNewGrowthPlanPurposeList: " + response.isSuccessful());

                if (response.isSuccessful()) {
                    int intCode = response.body().getCode();

                    Gson gson = new Gson();
                    String strExam = gson.toJson(response);

                    CommonMethods.displayLog(TAG, "Response @ callGetNewGrowthPlanPurposeList: " + strExam);

                    switch (intCode) {
                        case 1:
                            saveNewGrowthPlanPurposeList(response);
                            break;
                        case 2:
                            CommonMethods.displayLog(TAG, "Error @ callGetNewGrowthPlanPurposeList: ");
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<GrowthPlanGrowthPurposeListModel> call, Throwable t) {
                CommonMethods.displayLog(TAG, "Error @ callGetNewGrowthPlanPurposeList: " + t.getMessage());
                call.cancel();
            }
        });
    }

    private void saveNewGrowthPlanPurposeList(Response<GrowthPlanGrowthPurposeListModel> response) {

        //CLEAR OLD DATA
        mDatabaseHelper.clearNewGrowthPlanPurposeListData();

        for (int i = 0; i < response.body().getData().getListGPPurpose().size(); i++) {
            mDatabaseHelper.insertNewGrowthPlanPurposeList(
                    response.body().getData().getListGPPurpose().get(i).getId(),
                    response.body().getData().getListGPPurpose().get(i).getValue());
        }
    }

    private void storeBasicDataIntoDatabase(Response<UserBasicDetailsModel> response) {


        //Clear all basic details tables together
        mDatabaseHelper.clearAllSQLiteData();


        //INSERT STATE DATA
        for (int i = 0; i < response.body().getData().getListState().size(); i++) {
            mDatabaseHelper.insertState(
                    response.body().getData().getListState().get(i).getStateName(),
                    response.body().getData().getListState().get(i).getStateId(),
                    response.body().getData().getListState().get(i).getStateCode());
        }


        //INSERT DISTRICT DATA
        for (int i = 0; i < response.body().getData().getListDistrict().size(); i++) {

            mDatabaseHelper.insertDistrinct(
                    response.body().getData().getListDistrict().get(i).getDistrictId(),
                    response.body().getData().getListDistrict().get(i).getDistrictName(),
                    Integer.valueOf(response.body().getData().getListDistrict().get(i).getStateCode()));

        }

        //INSERT BLOCK DATA
        for (int i = 0; i < response.body().getData().getListBlock().size(); i++) {

            mDatabaseHelper.insertBlockList(
                    response.body().getData().getListBlock().get(i).getBlockId(),
                    response.body().getData().getListBlock().get(i).getBlockName(),
                    Integer.valueOf(response.body().getData().getListBlock().get(i).getDistrictCode()));

        }

        //INSERT VILLEGE DATA
        for (int i = 0; i < response.body().getData().getListVillage().size(); i++) {

            mDatabaseHelper.insertVillegeList(
                    response.body().getData().getListVillage().get(i).getVillageId(),
                    response.body().getData().getListVillage().get(i).getVillageName(),
                    Integer.valueOf(response.body().getData().getListVillage().get(i).getBlockCode()));

        }

        //INSERT GRAM PANCHAYAT
        for (int i = 0; i < response.body().getData().getListGramPanchayat().size(); i++) {

            mDatabaseHelper.insertGrampanchayatList(
                    response.body().getData().getListGramPanchayat().get(i).getGrampanchayatId(),
                    response.body().getData().getListGramPanchayat().get(i).getGrampanchayatName(),
                    response.body().getData().getListGramPanchayat().get(i).getGrampanchayatCode());

        }

        //INSERT LIST RELIGION
        for (int i = 0; i < response.body().getData().getListReligion().size(); i++) {

            mDatabaseHelper.insertReligionList(
                    response.body().getData().getListReligion().get(i).getId(),
                    response.body().getData().getListReligion().get(i).getName());

        }

        //INSERT CAST LIST
        for (int i = 0; i < response.body().getData().getListCaste().size(); i++) {

            mDatabaseHelper.insertCastList(
                    response.body().getData().getListCaste().get(i).getId(),
                    response.body().getData().getListCaste().get(i).getName());

        }


    }

}

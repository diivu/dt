package com.triapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.google.gson.Gson;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.EncryptionUtilityUsrNamePassword;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.UserAuthentication;
import com.triapp.Models.UserAuthenticationParams;
import com.triapp.R;
import com.triapp.RetrofitClass.UpdateAllAPI;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "LoginActivity";
    private EditText edtPassword, edtMobileNumber;
    private TextView txtTitleMoblienumber,txtTitlePassword,txtCreateAccount, txtForgotPassword, txtSignIn;
    private SessionManager mSessionManager;

    //ketan test
    //test test
    //New testfsgdfgs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setIds();
        setOncliks();


    }


    private void setIds() {

        mActivity = LoginActivity.this;
        mContext = LoginActivity.this;

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        //Hide softkeybord
        CommonMethods.hideKeybord(mActivity);

        edtMobileNumber = (EditText) findViewById(R.id.edtMobileNumber);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        txtSignIn = (TextView) findViewById(R.id.txtSignIn);
        txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);
        txtCreateAccount = (TextView) findViewById(R.id.txtCreateAccount);
        txtTitleMoblienumber = (TextView) findViewById(R.id.txtTitleMoblienumber);
        txtTitlePassword = (TextView) findViewById(R.id.txtTitlePassword);

        //Set mendetory field
        txtTitleMoblienumber.setText(CommonMethods.spannableString(getResources().getString(R.string.strMobileNumber)));
        txtTitlePassword.setText(CommonMethods.spannableString(getResources().getString(R.string.strPassword)));

        //check if user is already login
        if (mSessionManager.getPreferenceBoolean(Constants.IS_USER_LOGIN)) {

            Intent mIntent = new Intent(mActivity, MainActivity.class);
            startActivity(mIntent);
            finish();
        }

    }


    private void setOncliks() {

        txtSignIn.setOnClickListener(this);
        txtForgotPassword.setOnClickListener(this);
        txtCreateAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View mView) {

        switch (mView.getId()) {

            case R.id.txtSignIn:


                if (checkValidation()) {

                    if (CommonMethods.isInternetAvailable(mActivity)) {
                        callAuthentication();
                    } else {
                        CommonMethods.displayToast(mContext, getResources().getString(R.string.strNoInternetAvailable));
                    }

                }

                break;

            case R.id.txtForgotPassword:

                Intent mForgotPasswordActivity = new Intent(mActivity, ForgotPasswordActivity.class);
                startActivity(mForgotPasswordActivity);

                break;

            case R.id.txtCreateAccount:

                Intent mSignUpActivity = new Intent(mActivity, SignUpActivity.class);
                startActivity(mSignUpActivity);

                break;
        }

    }

    private void callAuthentication() {

        CommonMethods.showDialog(mContext ,getResources().getString(R.string.strPleaseWait));

        UserAuthenticationParams mUserAuthenticationParams = new UserAuthenticationParams();
        mUserAuthenticationParams.setUsername(EncryptionUtilityUsrNamePassword.encrypt(edtMobileNumber.getText().toString()));
        mUserAuthenticationParams.setPassword( EncryptionUtilityUsrNamePassword.encrypt(edtPassword.getText().toString()));
        mUserAuthenticationParams.setDeviceId(""+CommonMethods.getDeviceID(mContext));

        CommonMethods.printLog("callAuthentication", new Gson().toJson(mUserAuthenticationParams));

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        final OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_END_POINTS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .client(client.newBuilder().connectTimeout(30000, TimeUnit.SECONDS).readTimeout(30000, TimeUnit.SECONDS).writeTimeout(30000, TimeUnit.SECONDS).build())
                .build();

        UpdateAllAPI patchService1 = retrofit.create(UpdateAllAPI.class);
        Call<UserAuthentication> call = patchService1.callUserAuthentication(mUserAuthenticationParams);
        call.enqueue(new Callback<UserAuthentication>() {
            @Override
            public void onResponse(Call<UserAuthentication> call, Response<UserAuthentication> response) {

                int intResponceCode = response.body().getCode();

                switch (intResponceCode){

                    case 1:
                        CommonMethods.printLog("Response @ callAuthentication: ", "" + response.isSuccessful());
                        CommonMethods.printLog("Response @ callAuthentication: ", "" + response.code());
                        CommonMethods.printLog("Response @ callAuthentication: ", new Gson().toJson(response));

                        //Update if language already selected
                        mSessionManager.updatePreferenceBoolean(Constants.IS_USER_LOGIN, true);
                        mSessionManager.updatePreferenceString(Constants.USER_NAME , response.body().getData().getUsername());
                        mSessionManager.updatePreferenceString(Constants.USER_ACCESS_TOKEN , response.body().getData().getToken());
                        mSessionManager.updatePreferenceInteger(Constants.USER_ID , response.body().getData().getUserId());
                        mSessionManager.updatePreferenceInteger(Constants.USER_WORKER_ID , response.body().getData().getCrpEpId());


                        //OPTIONAL FLAG IF MOBILE USER ABLE TO CREATE MODEL BUSINESS PLAN
                        mSessionManager.updatePreferenceBoolean(Constants.IS_USER_ABLE_TO_MAKE_MODEL_BUSINESS_PLAN , true);


                        //ENTER LATITUDE LONGITUDE
                        mSessionManager.updatePreferenceString(Constants.USER_LATITUDE , "0.0");
                        mSessionManager.updatePreferenceString(Constants.USER_LONGITUDE , "0.0");

                        Intent mIntent = new Intent(mActivity, MainActivity.class);
                        startActivity(mIntent);
                        finish();

                        break;

                    case 2:
                        CommonMethods.buildDialog(mContext, R.style.DialogTheme,response.body().getDescription());
                        break;
                }



                //Close progress dialog
                CommonMethods.closeDialog();


            }

            @Override
            public void onFailure(Call<UserAuthentication> call, Throwable t) {
                CommonMethods.printLog("Error @ callAuthentication: ", "" + t.getMessage());
                CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strUnknowError));
                //Close progress dialog
                CommonMethods.closeDialog();

            }
        });

    }

    private boolean checkValidation() {

        if (edtMobileNumber.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strErrorEnterAIcode));
            return false;

        }else if (edtPassword.getText().toString().length() == 0) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strErrorEnterPassword));
            return false;
        }
        return true;
    }
}

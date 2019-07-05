package com.triapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.gson.Gson;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.CommonClasse.Constants;
import com.triapp.CommonClasse.SessionManager;
import com.triapp.Models.UserAuthentication;
import com.triapp.Models.UserForgotPassword;
import com.triapp.R;
import com.triapp.RetrofitClass.UpdateAllAPI;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "ForgotPasswordActivity";
    private SessionManager mSessionManager;
    private EditText edtMobileNumber;
    private TextView txtTitlemobileNumber,txtResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        setIds();
        setOncliks();
    }

    private void setIds() {

        mActivity = ForgotPasswordActivity.this;
        mContext = ForgotPasswordActivity.this;

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        //Hide softkeybord
        CommonMethods.hideKeybord(mActivity);

        edtMobileNumber = (EditText) findViewById(R.id.edtMobileNumber);

        txtResetPassword = (TextView) findViewById(R.id.txtResetPassword);
        txtTitlemobileNumber = (TextView) findViewById(R.id.txtTitlemobileNumber);

        //Set mendetory field
        txtTitlemobileNumber.setText(CommonMethods.spannableString(getResources().getString(R.string.strMobileNumber)));

    }

    private void setOncliks() {

        txtResetPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.txtResetPassword:

                    if(chcekValidation()){
                        if (CommonMethods.isInternetAvailable(mActivity)) {
                            callForgotPassword();
                        } else {
                            CommonMethods.displayToast(mContext, getResources().getString(R.string.strNoInternetAvailable));
                        }
                    }

                break;
        }
    }

    private void callForgotPassword() {

        CommonMethods.showDialog(mContext , getResources().getString(R.string.strPleaseWait));


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        final OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_END_POINTS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .client(client.newBuilder().connectTimeout(30000, TimeUnit.SECONDS).readTimeout(30000, TimeUnit.SECONDS).writeTimeout(30000, TimeUnit.SECONDS).build())
                .build();

        UpdateAllAPI patchService1 = retrofit.create(UpdateAllAPI.class);
        Call<UserForgotPassword> call = patchService1.callUserForgotPassword(edtMobileNumber.getText().toString());
        call.enqueue(new Callback<UserForgotPassword>() {
            @Override
            public void onResponse(Call<UserForgotPassword> call, Response<UserForgotPassword> response) {

                if (response.isSuccessful() && response.body() != null) {


                    Log.e("Response @ callForgotPassword: ", "" + response.isSuccessful());
                    Log.e("Response @ callForgotPassword: ", "" + response.code());
                    Log.e("Response @ callForgotPassword: ", new Gson().toJson(response));

                    CommonMethods.displayToast(mContext,getResources().getString(R.string.strPleasecheckEmail));

                    Intent mIntent = new Intent(mActivity, LoginActivity.class);
                    startActivity(mIntent);
                    finish();

                }else {
                    CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strUnknowError));
                }

                //Close progress dialog
                CommonMethods.closeDialog();


            }

            @Override
            public void onFailure(Call<UserForgotPassword> call, Throwable t) {
                Log.e("Error @ callForgotPassword: ", "" + t.getMessage());
                CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strUnknowError));
                //Close progress dialog
                CommonMethods.closeDialog();

            }
        });
    }

    private boolean chcekValidation() {

        if(edtMobileNumber.getText().toString().length() == 0){
            CommonMethods.buildDialog(mContext , R.style.DialogTheme , getResources().getString(R.string.strWarningEnterMobileNumber));
            return false;
        }else if (edtMobileNumber.getText().toString().length() < 10) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidMobilenumber));
            return false;
        }
        return true;
    }
}

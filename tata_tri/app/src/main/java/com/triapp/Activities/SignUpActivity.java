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
import com.triapp.Models.UserRegistration;
import com.triapp.R;
import com.triapp.RetrofitClass.UpdateAllAPI;

import java.util.concurrent.TimeUnit;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Activity mActivity;
    private Context mContext;
    private static final String TAG = "SignUpActivity";
    private SessionManager mSessionManager;
    private EditText edtReferenceMobileNumber,edtPassword,edtMobileNumber,edtEmail,edtLastName,edtFirstName;
    private TextView txtTitleFirstName,txtTitlePassword,txtTitlemobileNumber,txtTitleEmail,txtTitleLastName,txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setIds();
        setOncliks();
    }

    private void setIds() {

        mActivity = SignUpActivity.this;
        mContext = SignUpActivity.this;

        mSessionManager = new SessionManager(mContext);
        mSessionManager.openSettings();

        //Hide softkeybord
        CommonMethods.hideKeybord(mActivity);

        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtMobileNumber = (EditText) findViewById(R.id.edtMobileNumber);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtReferenceMobileNumber = (EditText) findViewById(R.id.edtReferenceMobileNumber);

        txtSignUp = (TextView) findViewById(R.id.txtSignUp);
        txtTitleFirstName = (TextView) findViewById(R.id.txtTitleFirstName);
        txtTitleLastName = (TextView) findViewById(R.id.txtTitleLastName);
        txtTitleEmail = (TextView) findViewById(R.id.txtTitleEmail);
        txtTitlemobileNumber = (TextView) findViewById(R.id.txtTitlemobileNumber);
        txtTitlePassword = (TextView) findViewById(R.id.txtTitlePassword);


        //Set mendetory field
        txtTitleFirstName.setText(CommonMethods.spannableString(getResources().getString(R.string.strFirstName)));
        txtTitleLastName.setText(CommonMethods.spannableString(getResources().getString(R.string.strLastName)));
        txtTitleEmail.setText(CommonMethods.spannableString(getResources().getString(R.string.strEmail)));
        txtTitlemobileNumber.setText(CommonMethods.spannableString(getResources().getString(R.string.strMobileNumberSignUp)));
        txtTitlePassword.setText(CommonMethods.spannableString(getResources().getString(R.string.strPassword)));


    }

    private void setOncliks() {

        txtSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View mView) {

        switch (mView.getId()){

            case R.id.txtSignUp:

                if(checkValidation()){

                    if (CommonMethods.isInternetAvailable(mActivity)) {
                        callRegistration();
                    } else {
                        CommonMethods.displayToast(mContext, getResources().getString(R.string.strNoInternetAvailable));
                    }


                }

                break;

        }
    }

    private void callRegistration() {

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
        Call<UserRegistration> call = patchService1.callUserRegistration(edtFirstName.getText().toString(),edtLastName.getText().toString(),edtEmail.getText().toString(),edtMobileNumber.getText().toString(),edtPassword.getText().toString(), edtReferenceMobileNumber.getText().toString());
        call.enqueue(new Callback<UserRegistration>() {
            @Override
            public void onResponse(Call<UserRegistration> call, Response<UserRegistration> response) {

                if (response.isSuccessful()) {

                    Log.e("Response @ callRegistration: ", "" + response.isSuccessful());
                    Log.e("Response @ callRegistration: ", "" + response.code());
                    Log.e("Response @ callRegistration: ", new Gson().toJson(response));

                    Intent mIntent = new Intent(mActivity, LoginActivity.class);
                    startActivity(mIntent);
                    finish();

                }else {

                    CommonMethods.buildDialog(mContext, R.style.DialogTheme,response.body().getLoginUSer().getReturnMessage());
                }

                //Close progress dialog
                CommonMethods.closeDialog();


            }

            @Override
            public void onFailure(Call<UserRegistration> call, Throwable t) {
                Log.e("Error @ callRegistration: ", "" + t.getMessage());
                CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strUnknowError));
                //Close progress dialog
                CommonMethods.closeDialog();

            }
        });
    }

    private boolean checkValidation() {

        if(edtFirstName.getText().toString().length() == 0){
            CommonMethods.buildDialog(mContext , R.style.DialogTheme , getResources().getString(R.string.strWarningEnterFirstName));
            return false;
        }else if(edtLastName.getText().toString().length() == 0){
            CommonMethods.buildDialog(mContext , R.style.DialogTheme , getResources().getString(R.string.strWarningEnterLastName));
            return false;
        }else if(edtEmail.getText().toString().length() == 0){
            CommonMethods.buildDialog(mContext , R.style.DialogTheme , getResources().getString(R.string.strWarningEnterEmail));
            return false;
        }else if(!CommonMethods.isEmailValid(edtEmail.getText().toString())){
            CommonMethods.buildDialog(mContext , R.style.DialogTheme , getResources().getString(R.string.strWarningEnterInvalidEmail));
            return false;
        }else if(edtMobileNumber.getText().toString().length() == 0){
            CommonMethods.buildDialog(mContext , R.style.DialogTheme , getResources().getString(R.string.strWarningEnterMobileNumber));
            return false;
        }else if (edtMobileNumber.getText().toString().length() < 10) {
            CommonMethods.buildDialog(mContext, R.style.DialogTheme, getResources().getString(R.string.strValidMobilenumber));
            return false;
        } else if(edtPassword.getText().toString().length() == 0){
            CommonMethods.buildDialog(mContext , R.style.DialogTheme , getResources().getString(R.string.strWarningEnterPassword));
            return false;
        }

        return true;
    }
}

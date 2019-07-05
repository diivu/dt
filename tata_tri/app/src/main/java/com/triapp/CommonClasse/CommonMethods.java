package com.triapp.CommonClasse;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.triapp.Activities.LoginActivity;
import com.triapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMethods {

    private static AlertDialog dialog;
    private static ProgressDialog pDialog;
    private static final String VALID_EMAIL = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private static final String VALID_PAN = "(([A-Za-z]{5})([0-9]{4})([a-zA-Z]))";

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    public static void buildDialog(Context mContext, int animationSource, String strMessege) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getResources().getString(R.string.strWarningDialogTitle));
        builder.setMessage(strMessege);
        builder.setNegativeButton(mContext.getResources().getString(R.string.strOk), null);
        AlertDialog dialog = builder.create();
        //dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }

    //Open logout dialog
    public static void logoutDialog(final Activity mActivity, int animationSource, String strMessege) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle(mActivity.getResources().getString(R.string.strWarningDialogTitle));
        builder.setMessage(strMessege);
        builder.setNegativeButton(mActivity.getResources().getString(R.string.strCancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialog.dismiss();
            }
        });
        builder.setPositiveButton(mActivity.getResources().getString(R.string.strYes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SessionManager mSessionManager = new SessionManager(mActivity);
                mSessionManager.openSettings();


                //Logout from session manager
                mSessionManager.updatePreferenceBoolean(Constants.IS_USER_LOGIN, false);

                Intent mIntent = new Intent(mActivity, LoginActivity.class);
                mActivity.startActivity(mIntent);
                mActivity.finish();
            }
        });
        dialog = builder.create();
        //dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }

    public static void displayToast(Context mContext, String strMessege) {

        Toast.makeText(mContext, strMessege, Toast.LENGTH_SHORT).show();
    }

    public static void displayLog( String strTag, String strMessege) {

        Log.e(strTag, strMessege);
    }

    public static void printLog(String strTAG, String strMessage) {

        Log.e(strTAG, strMessage);
    }

    public static void showDialog(Context mContext , String messageToBeDisplay) {
        pDialog = new ProgressDialog(mContext);
        pDialog.setMessage(messageToBeDisplay);
        pDialog.setCancelable(false);
        pDialog.show();
    }


    public static void closeDialog() {
        pDialog.dismiss();
    }

    public static String getDeviceToken(Activity mActivity) {
        return Settings.Secure.getString(mActivity.getContentResolver(),
                Settings.Secure.ANDROID_ID);


    }

    public static String getDateFromLong(Long lngDate) {

        long millisecond = Long.parseLong(String.valueOf(lngDate));
        // or you already have long value of date, use this instead of milliseconds variable.
        String dateString = DateFormat.format("dd/MM/yyyy", new Date(millisecond)).toString();

        return dateString;
    }

    public static boolean isEmailValid(String isEmailValid) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = isEmailValid;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static SpannableStringBuilder spannableString(String strText){
        String colored = "*";
        SpannableStringBuilder builder = new SpannableStringBuilder();

        builder.append(strText);
        int start = builder.length();
        builder.append(colored);
        int end = builder.length();

        builder.setSpan(new ForegroundColorSpan(Color.RED), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        return builder;
    }

    public static void hideKeybord(Activity mContext) {

        mContext.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = mContext.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mContext.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mContext.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    public static String getDeviceID(Context context) {
        try {
            String AndroidId = Settings.Secure.getString(context.getContentResolver() , Settings.Secure.ANDROID_ID);
            try{
                return AndroidId;
            } catch (Exception e){
                e.printStackTrace();
                return AndroidId;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Long getLongDateFromStringDate(String date){
        long startDate = 0;
        try {
            String dateString = date;
            SimpleDateFormat sdf = new SimpleDateFormat(Constants.COMMON_DATE_FORMAT);
            Date mDate1 = sdf.parse(dateString);
            startDate = mDate1.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return startDate;
    }

    public static boolean checkEmailIsCorrect(String strEmail) {
        try {
            Pattern pattern = Pattern.compile(VALID_EMAIL);
            Matcher matcher = pattern.matcher(strEmail);
            if (matcher.matches()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkPanIsCorrect(String strPanNo) {
        try {
            Pattern pattern = Pattern.compile(VALID_PAN);
            Matcher matcher = pattern.matcher(strPanNo);
            if (matcher.matches()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}

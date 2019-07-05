package com.triapp.RetrofitClass;


import com.triapp.CommonClasse.Constants;
import com.triapp.Models.GrowthPlanGrowthPurposeListModel;
import com.triapp.Models.UserAuthentication;
import com.triapp.Models.UserAuthenticationParams;
import com.triapp.Models.UserBasicDetailsModel;
import com.triapp.Models.UserForgotPassword;
import com.triapp.Models.UserRegistration;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * Created by baps on 29-03-2017.
 */

public interface UpdateAllAPI {

    /*@GET(Constants.API_AUTHENTICATION)
    Call<UserAuthentication> callUserAuthentication(@Query("userName") String strUserName,
                                                    @Query("password") String strPassword,
                                                    @Query("IP") String strIP);*/


    //Call user authentication
    @POST(Constants.API_AUTHENTICATION)
    Call<UserAuthentication> callUserAuthentication(@Body UserAuthenticationParams UserAuthenticationParams);

    //Call Basic data
    @GET()
    Call<UserBasicDetailsModel> getRawData(@Url String url);



    @GET(Constants.API_REGISTRATION)
    Call<UserRegistration> callUserRegistration(@Query("FirstName") String strFirstName,
                                                @Query("LastName") String strLastName,
                                                @Query("email") String stremail,
                                                @Query("MobileNumber") String strMobileNumber,
                                                @Query("Password") String strPassword,
                                                @Query("refMobile") String strrefMobile);

    @GET(Constants.API_FORGOTPASSWORD)
    Call<UserForgotPassword> callUserForgotPassword(@Query("mobilenumber") String strmobilenumber);


    @GET(Constants.URL_GET_GROWTH_PLAN_PURPOSE_LIST)
    Call<GrowthPlanGrowthPurposeListModel> getNewGrowthPlanPurposeList();


}

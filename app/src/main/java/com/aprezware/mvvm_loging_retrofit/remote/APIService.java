package com.aprezware.mvvm_loging_retrofit.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by PereZ on 07/01/2019.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("/login/logintab.php")
    Call<String> userLoginCall (@Field("username") String username, @Field("userpass") String userpass);
}

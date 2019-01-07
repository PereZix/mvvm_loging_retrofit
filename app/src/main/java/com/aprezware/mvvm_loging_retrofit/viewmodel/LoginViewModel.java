package com.aprezware.mvvm_loging_retrofit.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import com.aprezware.mvvm_loging_retrofit.remote.APIService;
import com.aprezware.mvvm_loging_retrofit.remote.RetroClass;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PereZ on 07/01/2019.
 */

public class LoginViewModel extends Observable {

    private Context context;
    public ObservableInt progressBar;
    public final ObservableField<String> username = new ObservableField<>("");
    public final ObservableField<String> userpass = new ObservableField<>("");

    public LoginViewModel(Context cont){
        this.context = cont;
        progressBar = new ObservableInt(View.GONE);
    }

    public void sendLoginRequest(String name, String pass){
        //showToast("Dentro de loginViewModel");

        progressBar.set(View.VISIBLE);


        APIService apiService = RetroClass.getAPIService();
        Call<String> loginResponse = apiService.userLoginCall(name,pass);
        loginResponse.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressBar.set(View.GONE);
                showToast(""+response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                showToast(""+ t.getMessage());
            }
        });
    }

    void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}

package com.aprezware.mvvm_loging_retrofit;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aprezware.mvvm_loging_retrofit.databinding.ActivityMainBinding;
import com.aprezware.mvvm_loging_retrofit.presenter.Presenter;
import com.aprezware.mvvm_loging_retrofit.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loginViewModel = new LoginViewModel(this);

        activityMainBinding.setLoginview(loginViewModel);
        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void loginData() {
                //showToast("LOGIN ACTIVITY");

                final String name = activityMainBinding.edtUser.getText().toString();
                final String pass = activityMainBinding.edtPass.getText().toString();

                loginViewModel.sendLoginRequest(name, pass);
            }
        });
    }

    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

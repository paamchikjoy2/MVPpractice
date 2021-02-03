package com.example.mvppractice.Presenter;

import com.example.mvppractice.Model.User;
import com.example.mvppractice.View.ILoginView;

public class LoginPresenter implements ILoginPresenter{
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user= new User(email, password);
        boolean isLoginSuccess= user.isValidData();

        if(isLoginSuccess)
            loginView.onLoginResult("Login Successful");
        else
            loginView.onLoginResult("Login Failed");
    }
}

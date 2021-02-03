package com.example.mvppractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvppractice.Presenter.ILoginPresenter;
import com.example.mvppractice.Presenter.LoginPresenter;
import com.example.mvppractice.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText emailET,passwordET;
    Button loginBtn;
    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view
        emailET=findViewById(R.id.email_input);
        passwordET=findViewById(R.id.password_input);
        loginBtn=findViewById(R.id.login_btn);
        //init
        loginPresenter = new LoginPresenter(this);

        //event
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(emailET.getText().toString(),passwordET.getText().toString());

            }
        });


    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
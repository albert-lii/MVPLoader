package com.liyi.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.liyi.mvploader.view.BaseActivity;


public class MainActivity extends BaseActivity<MainPresnter> implements MainContacts.IMain {
    private EditText editT_username, editT_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        addListeners();
    }

    @Override
    protected MainPresnter bindPresenter() {
        return new MainPresnter(this);
    }

    private void initUI() {
        editT_username = (EditText) findViewById(R.id.editT_username);
        editT_password = (EditText) findViewById(R.id.editT_password);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    private void addListeners() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MvpPre.login(editT_username.getText().toString(), editT_password.getText().toString());
            }
        });
    }

    @Override
    public void showTips(boolean isSucceess) {
        if (isSucceess) {
            Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败！", Toast.LENGTH_SHORT).show();
        }
    }
}

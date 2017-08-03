package com.liyi.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liyi.mvploader.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

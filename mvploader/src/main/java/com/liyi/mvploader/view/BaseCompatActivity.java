package com.liyi.mvploader.view;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.liyi.mvploader.presenter.IPresenter;

public abstract class BaseCompatActivity<P extends IPresenter> extends AppCompatActivity implements IView {
    protected P MvpPre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MvpPre = bindPresenter();
    }

    protected abstract P bindPresenter();

    public <T> T $(int resId) {
        return (T) findViewById(resId);
    }

    public <T> T $(int resId, View parent) {
        return (T) parent.findViewById(resId);
    }

    @Override
    public Activity getSelfAty() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (MvpPre != null) {
            MvpPre.detachView();
        }
    }
}

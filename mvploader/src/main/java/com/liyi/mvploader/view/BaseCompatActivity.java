package com.liyi.mvploader.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liyi.mvploader.presenter.IPresenter;

public abstract class BaseCompatActivity<P extends IPresenter> extends AppCompatActivity implements IView<AppCompatActivity> {
    protected P MvpPre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MvpPre = bindPresenter();
    }

    protected abstract P bindPresenter();

    @Override
    public AppCompatActivity getSelfActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 在生命周期结束时，将presenter与view之间的联系断开，防止出现内存泄露
         */
        if (MvpPre != null) {
            MvpPre.detachView();
        }
    }
}

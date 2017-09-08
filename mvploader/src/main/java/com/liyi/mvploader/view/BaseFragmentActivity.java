package com.liyi.mvploader.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.liyi.mvploader.presenter.IPresenter;


public abstract class BaseFragmentActivity<P extends IPresenter> extends FragmentActivity implements IView {
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
    public Activity getSelfActivity() {
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

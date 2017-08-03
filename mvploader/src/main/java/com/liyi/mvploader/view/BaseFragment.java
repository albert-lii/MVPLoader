package com.liyi.mvploader.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.liyi.mvploader.presenter.IPresenter;

public abstract class BaseFragment<P extends IPresenter> extends Fragment {
    protected P MvpPre;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MvpPre = bindPresenter();
    }

    protected abstract P bindPresenter();

    public <T> T $(int resId, View parent) {
        return (T) parent.findViewById(resId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (MvpPre != null) {
            MvpPre.detachView();
        }
    }
}

package com.liyi.example;

import com.liyi.mvploader.presenter.BasePresenter;

/**
 * Created by albertlii on 2017/9/8.
 */

public class MainPresnter extends BasePresenter<MainContacts.IMain> implements MainContacts.IMainPre {
    private MainLogic mMainLogic;

    public MainPresnter(MainContacts.IMain view) {
        super(view);
        this.mMainLogic = new MainLogic();
    }

    @Override
    public void login(String username, String password) {
        // 判断activity的生命周期是否结束，不判断的话在极端情况下可能会出现内存泄露
        if (isViewAttach()) {
            MvpRef.get().showTips(mMainLogic.login(username, password));
        }
    }
}

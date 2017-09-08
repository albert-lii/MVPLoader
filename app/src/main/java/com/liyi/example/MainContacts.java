package com.liyi.example;


import com.liyi.mvploader.presenter.IPresenter;
import com.liyi.mvploader.view.IView;

/**
 * 创建一个类作为纽带，将view、presenter、model的接口方法都串联在一起，更加便于管理
 */
public final class MainContacts {
    public interface IMain extends IView {
        void showTips(boolean isSucceess);
    }

    public interface IMainPre extends IPresenter {
        void login(String username, String password);
    }

    public interface IMainLgc {
        boolean login(String username, String password);
    }
}

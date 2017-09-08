package com.liyi.mvploader.presenter;


import com.liyi.mvploader.view.IView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView> implements IPresenter {
    protected Reference<V> MvpRef;

    public BasePresenter(V view) {
        attachView(view);
    }

    private void attachView(V view) {
        MvpRef = new WeakReference<V>(view);
    }

    protected V getView() {
        if (MvpRef != null) {
            return MvpRef.get();
        }
        return null;
    }

    /**
     * 主要用于判断IView的生命周期是否结束，防止出现内存泄露状况
     *
     * @return
     */
    protected boolean isViewAttach() {
        return MvpRef != null && MvpRef.get() != null;
    }

    @Override
    public void detachView() {
        if (MvpRef != null) {
            MvpRef.clear();
            MvpRef = null;
        }
    }
}

package com.liyi.mvploader.presenter;


import com.liyi.mvploader.view.IView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView> implements IPresenter {
    private Reference<V> MvpRef;

    public BasePresenter(V view) {
        attachView(view);
    }

    private void attachView(V view) {
        MvpRef = new WeakReference<V>(view);
    }

    private V getView() {
        if (MvpRef != null) {
            return MvpRef.get();
        }
        return null;
    }

    private boolean isViewAttach() {
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

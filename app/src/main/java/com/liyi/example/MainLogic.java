package com.liyi.example;

import android.text.TextUtils;

/**
 * Created by albertlii on 2017/9/8.
 */
public class MainLogic implements MainContacts.IMainLgc {

    public boolean login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }
}

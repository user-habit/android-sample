package com.userhabit.todo.todoapp.util;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class Extentions {

    public static ViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory provider, Class cls) {
        return ViewModelProviders.of(fragment, provider).get(cls);
    }

    public static ViewModel provideViewModel(FragmentActivity activity, ViewModelProvider.Factory provider, Class cls) {
        return ViewModelProviders.of(activity, provider).get(cls);
    }

    public static void fragmentAdd(FragmentActivity activity, @IdRes int id, Fragment fragment, String tag) {
        activity.getSupportFragmentManager().beginTransaction().add(id, fragment, tag).commit();
    }

    public static void fragmentReplace(FragmentActivity activity, @IdRes int id, Fragment fragment, String tag) {
        activity.getSupportFragmentManager().beginTransaction().replace(id, fragment, tag).commit();
    }
}

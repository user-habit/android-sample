package com.userhabit.todo.todoapp.ui.navigator;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.userhabit.todo.todoapp.R;
import com.userhabit.todo.todoapp.ui.photodetail.PhotoDetailFragment;

public class FragmentNavigator implements Navigator {

    Fragment fragment;

    public FragmentNavigator(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void navigationToEventView(Bundle bundle) {
        fragment.getFragmentManager()
                .beginTransaction()
                .add(R.id.container, PhotoDetailFragment.newInstance(bundle))
                .addToBackStack(null)
                .commit();

        /*fragment.requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, PhotoDetailFragment.newInstance(bundle))
                .addToBackStack(null)
                .commit();*/
    }
}

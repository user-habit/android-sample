package com.userhabit.todo.todoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.userhabit.todo.todoapp.ui.MoreFragment;
import com.userhabit.todo.todoapp.ui.WebviewFragment;
import com.userhabit.todo.todoapp.ui.picture.PictureListFragment;

import io.userhabit.service.Userhabit;

public class MainActivity extends AppCompatActivity {

    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = findViewById(R.id.viewPager);
        viewpager.setAdapter(new ViewPagerAdapater(getSupportFragmentManager()));

        /**
         * 유저해빗 ViewPager 화면 분석
         */
        Userhabit.setViewPager(viewpager);
    }
}


class ViewPagerAdapater extends FragmentStatePagerAdapter {

    public ViewPagerAdapater(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;

        switch (i) {
            case 0:
                fragment = PictureListFragment.newInstance();
                break;
            case 1:
                fragment = WebviewFragment.newInstance();
                break;
            case 2:
                fragment = MoreFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

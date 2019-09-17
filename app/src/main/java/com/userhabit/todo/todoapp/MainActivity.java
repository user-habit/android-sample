package com.userhabit.todo.todoapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.userhabit.todo.todoapp.ui.MoreFragment;
import com.userhabit.todo.todoapp.ui.imageviewer.ImageViewerFragment;
import com.userhabit.todo.todoapp.ui.WebviewFragment;

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


    /**
     * API 9 이상
     * 수동으로 한 화면씩 수집하고 싶으시다면
     * 아래 API 호출 권고
     **/
   /* @Override
    protected void onStart() {
        super.onStart();
        Userhabit.activityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Userhabit.activityStop(this);
    }*/
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
                fragment = ImageViewerFragment.newInstance();
                break;
            case 1:
                fragment = WebviewFragment.newInstance();
                break;
            case 2:
                /**
                 * todoSomeThing..
                 **/
                fragment = MoreFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

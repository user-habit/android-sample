package com.userhabit.todo.todoapp.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.userhabit.todo.todoapp.R;
import com.userhabit.todo.todoapp.util.Extentions;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        String pictureId = getIntent().getStringExtra("id");
        Fragment pictureDetailFragment = PictureDetailFragment.newInstance();
        pictureDetailFragment.setArguments(Extentions.<String>provideBundle("id", pictureId));
        Extentions.fragmentReplace(this, R.id.fragmentContainer, pictureDetailFragment, null);
    }
}

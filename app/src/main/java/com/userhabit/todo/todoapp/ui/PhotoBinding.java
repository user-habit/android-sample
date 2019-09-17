package com.userhabit.todo.todoapp.ui;

import androidx.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PhotoBinding {

    @BindingAdapter("photo")
    public static void setPhoto(View view, String url) {
        Glide.with(view)
                .load(url)
                .into((ImageView) view);
    }
}

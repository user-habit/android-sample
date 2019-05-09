package com.userhabit.todo.todoapp.ui.picture;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.userhabit.todo.todoapp.data.photo.Photo;

public class PhotoDiffCallback extends DiffUtil.ItemCallback<Photo> {

    @Override
    public boolean areItemsTheSame(@NonNull Photo photo, @NonNull Photo t1) {
        return photo.getId() == t1.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Photo photo, @NonNull Photo t1) {
        return photo == t1;
    }
}

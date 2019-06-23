package com.userhabit.todo.todoapp.data;

import android.arch.lifecycle.LiveData;

import com.userhabit.todo.todoapp.data.photo.PhotoDetail;
import com.userhabit.todo.todoapp.data.photo.Photos;

public interface PictureDataSource {
    void getPhotos(
            String keyword,
            int safe,
            int page,
            int perPage
    );

    void getPictureDetail(
            String photoId
    );

    LiveData<Photos> getPhotosObserve();

    LiveData<PhotoDetail> getPictureDetailObserve();
}

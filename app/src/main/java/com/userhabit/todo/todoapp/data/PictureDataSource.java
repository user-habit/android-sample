package com.userhabit.todo.todoapp.data;

import android.arch.lifecycle.LiveData;

import com.userhabit.todo.todoapp.data.photo.Photos;

import retrofit2.Call;

public interface PictureDataSource {
    void getPhotos(
            String keyword,
            int safe,
            int page,
            int perPage
    );

    Call<PhotoDetailResponse> getPhoto(
            String photoId
    );

    LiveData<Photos> getPhotosObserve();
}

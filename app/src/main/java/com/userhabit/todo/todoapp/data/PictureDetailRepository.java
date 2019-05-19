package com.userhabit.todo.todoapp.data;

import android.arch.lifecycle.LiveData;

import com.userhabit.todo.todoapp.data.photo.PhotoDetail;

public class PictureDetailRepository {

    private PictureDataSource pictureDataSource;

    private LiveData<PhotoDetail> pictureDetailLiveData;

    public PictureDetailRepository(PictureDataSource pictureDataSource) {
        this.pictureDataSource = pictureDataSource;
        this.pictureDetailLiveData = pictureDataSource.getPictureDetailObserve();
    }

    public void getPictureDetail(String pictureId) {
        pictureDataSource.getPictureDetail(pictureId);
    }

    public LiveData<PhotoDetail> pictureDetailObserve() {
        return pictureDetailLiveData;
    }
}

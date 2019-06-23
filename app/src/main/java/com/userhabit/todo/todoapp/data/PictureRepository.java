package com.userhabit.todo.todoapp.data;

import android.arch.lifecycle.LiveData;

import com.userhabit.todo.todoapp.data.photo.Photos;
import com.userhabit.todo.todoapp.domain.GetPicturesUseCaseParameters;

public class PictureRepository {

    private final PictureDataSource pictureDataSource;
    private LiveData<Photos> photosObservable;

    public PictureRepository(PictureDataSource pictureDataSource) {
        this.pictureDataSource = pictureDataSource;
        this.photosObservable = pictureDataSource.getPhotosObserve();
    }

    public void getPictures(GetPicturesUseCaseParameters parameters) {
        pictureDataSource.getPhotos(
                parameters.getKeyword(),
                parameters.getSafe(),
                parameters.getPage(),
                parameters.getPerPage()
        );
    }

    public LiveData<Photos> getPhotosObservable() {
        return photosObservable;
    }
}

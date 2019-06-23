package com.userhabit.todo.todoapp.domain;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;

import com.userhabit.todo.todoapp.data.PictureRepository;
import com.userhabit.todo.todoapp.data.photo.Photos;

public class GetPictureUseCase extends MediatorUseCase<GetPicturesUseCaseParameters, Photos> {

    private final PictureRepository pictureRepository;

    public GetPictureUseCase(PictureRepository pictureRepository) {
        Log.d("cylee", "getPictureUseCase trigger");
        this.pictureRepository = pictureRepository;
        result.addSource(pictureRepository.getPhotosObservable(), new Observer<Photos>() {
            @Override
            public void onChanged(@Nullable Photos photos) {
                //by pass
                result.postValue(photos);
            }
        });
    }

    @Override
    public void execute(GetPicturesUseCaseParameters parameter) {
        Log.d("cylee", "getPictureUseCase excute");
        pictureRepository.getPictures(parameter);
    }
}

package com.userhabit.todo.todoapp.domain;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.userhabit.todo.todoapp.data.PictureDetailRepository;
import com.userhabit.todo.todoapp.data.photo.PhotoDetail;

public class GetPictureDetailUseCase extends MediatorUseCase<String, PhotoDetail> {

    private PictureDetailRepository pictureDetailRepository;

    public GetPictureDetailUseCase(PictureDetailRepository pictureDetailRepository) {
        this.pictureDetailRepository = pictureDetailRepository;
        result.addSource(pictureDetailRepository.pictureDetailObserve(), new Observer<PhotoDetail>() {
            @Override
            public void onChanged(@Nullable PhotoDetail photoDetail) {
                result.postValue(photoDetail);
            }
        });
    }

    @Override
    public void execute(String parameter) {
        this.pictureDetailRepository.getPictureDetail(parameter);
    }
}

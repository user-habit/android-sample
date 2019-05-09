/*
package com.userhabit.todo.todoapp.domain;

import android.util.Log;

import com.userhabit.todo.todoapp.data.PictureRepository;
import com.userhabit.todo.todoapp.data.photo.Photos;

public class GetPicturesUseCase extends UseCase<GetPicturesUseCaseParameters, Photos> {

    private final PictureRepository pictureRepository;

    public GetPicturesUseCase(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    protected Photos execute(GetPicturesUseCaseParameters parameter) {
        Log.d("cylee", "GetPicturesUseCase execute parameter : " + parameter);
        return pictureRepository.getPictures(parameter);
    }
}
*/

package com.userhabit.todo.todoapp.ui.picture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.userhabit.todo.todoapp.data.photo.Photos;
import com.userhabit.todo.todoapp.domain.GetPictureUseCase;
import com.userhabit.todo.todoapp.util.InjectionUtils;

public class PictureViewModel extends ViewModel {

    private GetPictureUseCase getPictureUseCase;
    public LiveData<Photos> photos;

    //init
    public PictureViewModel(GetPictureUseCase getPictureUseCase) {
        this.getPictureUseCase = getPictureUseCase;
        photos = this.getPictureUseCase.obseve();

        this.getPictureUseCase.execute(InjectionUtils.providePictureUseCaseParameter());
        Log.d("cylee", "PictureViewModel init");
        Log.d("cylee", "getPicturesUseCase : " + getPictureUseCase);
    }
}

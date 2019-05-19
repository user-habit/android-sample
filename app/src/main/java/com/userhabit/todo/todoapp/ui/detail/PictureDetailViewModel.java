package com.userhabit.todo.todoapp.ui.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.userhabit.todo.todoapp.data.photo.PhotoDetail;
import com.userhabit.todo.todoapp.domain.GetPictureDetailUseCase;

public class PictureDetailViewModel extends ViewModel {

    private String pictureId;
    private GetPictureDetailUseCase pictureDetailUseCase;
    public LiveData<PhotoDetail> pictureDetailLiveData;

    public PictureDetailViewModel(GetPictureDetailUseCase pictureDetailUseCase) {
        this.pictureDetailUseCase = pictureDetailUseCase;
        this.pictureDetailLiveData = this.pictureDetailUseCase.obseve();
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public void execute() {
        pictureDetailUseCase.execute(pictureId);
    }
}

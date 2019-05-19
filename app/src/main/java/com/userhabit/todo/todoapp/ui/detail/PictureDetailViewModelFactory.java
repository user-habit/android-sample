package com.userhabit.todo.todoapp.ui.detail;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.userhabit.todo.todoapp.domain.GetPictureDetailUseCase;

public class PictureDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GetPictureDetailUseCase pictureDetailUseCase;

    public PictureDetailViewModelFactory(GetPictureDetailUseCase pictureDetailUseCase) {
        this.pictureDetailUseCase = pictureDetailUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PictureDetailViewModel(pictureDetailUseCase);
    }
}

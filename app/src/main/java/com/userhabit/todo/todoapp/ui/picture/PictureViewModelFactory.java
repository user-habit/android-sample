package com.userhabit.todo.todoapp.ui.picture;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.userhabit.todo.todoapp.domain.GetPictureUseCase;

public class PictureViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GetPictureUseCase getPictureUseCase;

    public PictureViewModelFactory(GetPictureUseCase getPictureUseCase) {
        this.getPictureUseCase = getPictureUseCase;
    }

    //ex) sunflower
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return ((T) new PictureViewModel(getPictureUseCase));
    }
}

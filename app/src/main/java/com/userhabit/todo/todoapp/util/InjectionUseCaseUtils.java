package com.userhabit.todo.todoapp.util;

import com.userhabit.todo.todoapp.domain.GetPictureDetailUseCase;
import com.userhabit.todo.todoapp.domain.GetPictureUseCase;

public class InjectionUseCaseUtils {

    public static GetPictureUseCase provideGetPictureUseCase() {
        return new GetPictureUseCase(InjectionRepositoryUtils.providePictureRepository());
    }

    public static GetPictureDetailUseCase providePictureDetailUseCase() {
        return new GetPictureDetailUseCase(InjectionRepositoryUtils.providePictureDetailRepository());
    }
}

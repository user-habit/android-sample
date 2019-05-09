package com.userhabit.todo.todoapp.util;

import com.userhabit.todo.todoapp.domain.GetPictureUseCase;

public class InjectionUseCaseUtils {

    public static GetPictureUseCase provideGetPictureUseCase() {
        return new GetPictureUseCase(InjectionRepositoryUtils.providePictureRepository());
    }
}

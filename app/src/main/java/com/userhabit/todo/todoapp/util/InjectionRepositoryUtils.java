package com.userhabit.todo.todoapp.util;

import com.userhabit.todo.todoapp.data.NetworkPictureDataSource;
import com.userhabit.todo.todoapp.data.PictureDataSource;
import com.userhabit.todo.todoapp.data.PictureDetailRepository;
import com.userhabit.todo.todoapp.data.PictureRepository;

public class InjectionRepositoryUtils {

    public static PictureRepository providePictureRepository() {
        return new PictureRepository(InjectionRepositoryUtils.providePictureDataSource());
    }

    public static PictureDetailRepository providePictureDetailRepository() {
        return new PictureDetailRepository(InjectionRepositoryUtils.providePictureDataSource());
    }

    public static PictureDataSource providePictureDataSource() {
        return new NetworkPictureDataSource();
    }

}

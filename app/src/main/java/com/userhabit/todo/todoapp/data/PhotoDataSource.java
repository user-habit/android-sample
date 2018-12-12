package com.userhabit.todo.todoapp.data;

import retrofit2.Call;

public interface PhotoDataSource {

    Call<PhotoResponse> getPhotos(
            String keyword,
            int safe,
            int page,
            int perPage
    );

    Call<PhotoDetailResponse> getPhoto(
            String photoId
    );
}

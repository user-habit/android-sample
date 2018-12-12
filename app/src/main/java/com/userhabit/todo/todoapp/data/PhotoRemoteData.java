package com.userhabit.todo.todoapp.data;

import com.userhabit.todo.todoapp.network.FlickerApi;
import com.userhabit.todo.todoapp.network.RetrofitUtils;

import retrofit2.Call;

public class PhotoRemoteData implements PhotoDataSource {
    @Override
    public Call<PhotoResponse> getPhotos(String keyword, int safe, int page, int perPage) {
        return RetrofitUtils.createRetrofit(
                FlickerApi.class,
                "https://api.flickr.com/services/rest/"
        ).getPhotos(
                keyword,
                safe,
                page,
                perPage
        );
    }

    @Override
    public Call<PhotoDetailResponse> getPhoto(String photoId) {
        return RetrofitUtils.createRetrofit(
                FlickerApi.class,
                "https://api.flickr.com/services/rest/"
        ).getPhoto(
                photoId
        );
    }
}

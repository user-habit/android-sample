package com.userhabit.todo.todoapp.data;

import retrofit2.Call;

public class PhotoRepository implements PhotoDataSource {

    PhotoDataSource remoteData;

    public PhotoRepository() {
        remoteData = new PhotoRemoteData();
    }

    @Override
    public Call<PhotoResponse> getPhotos(String keyword, int safe, int page, int perPage) {
        return remoteData.getPhotos(keyword, safe, page, perPage);
    }

    @Override
    public Call<PhotoDetailResponse> getPhoto(String photoId) {
        return remoteData.getPhoto(photoId);
    }
}

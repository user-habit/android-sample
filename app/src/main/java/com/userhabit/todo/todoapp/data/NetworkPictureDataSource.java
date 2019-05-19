package com.userhabit.todo.todoapp.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.userhabit.todo.todoapp.data.photo.PhotoDetail;
import com.userhabit.todo.todoapp.data.photo.Photos;
import com.userhabit.todo.todoapp.network.FlickerApi;
import com.userhabit.todo.todoapp.network.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkPictureDataSource implements PictureDataSource {

    //picture
    private MutableLiveData<Photos> photosObservable = new MutableLiveData<>();
    //picture detail
    private MutableLiveData<PhotoDetail> pictureDetailObservable = new MutableLiveData<>();

    @Override
    public void getPhotos(String keyword, int safe, int page, int perPage) {
        final Photos phototot = null;
        RetrofitUtils.createRetrofit(
                FlickerApi.class,
                "https://api.flickr.com/services/rest/"
        ).getPhotos(
                keyword,
                safe,
                page,
                perPage
        ).enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStat().equalsIgnoreCase("ok")) {
                        photosObservable.postValue(response.body().getPhotos());
                    } else {
                        photosObservable.postValue(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                photosObservable.postValue(null);
            }
        });
    }

    @Override
    public void getPictureDetail(String photoId) {
        RetrofitUtils.createRetrofit(
                FlickerApi.class,
                "https://api.flickr.com/services/rest/"
        ).getPhoto(
                photoId
        ).enqueue(new Callback<PhotoDetailResponse>() {
            @Override
            public void onResponse(Call<PhotoDetailResponse> call, Response<PhotoDetailResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStat().equalsIgnoreCase("ok")) {
                        pictureDetailObservable.postValue(response.body().getPhoto());
                    } else {
                        pictureDetailObservable.postValue(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<PhotoDetailResponse> call, Throwable t) {
                pictureDetailObservable.postValue(null);
            }
        });
    }

    @Override
    public LiveData<Photos> getPhotosObserve() {
        return photosObservable;
    }

    @Override
    public LiveData<PhotoDetail> getPictureDetailObserve() {
        return pictureDetailObservable;
    }
}

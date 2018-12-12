package com.userhabit.todo.todoapp.ui.imageviewer;

import android.os.Bundle;
import android.util.Log;

import com.userhabit.todo.todoapp.data.PhotoRepository;
import com.userhabit.todo.todoapp.data.PhotoResponse;
import com.userhabit.todo.todoapp.ui.navigator.Navigator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageViewerViewModel {

    PhotoRepository repository;
    Navigator navigator;
    ImageRecyclerModel recyclerModel;

    int page = 0;
    int perPage = 50;

    public ImageViewerViewModel(
            PhotoRepository repository,
            Navigator navigator
    ) {
        this.repository = repository;
        this.navigator = navigator;
    }

    public void loadPhotos() {
        repository.getPhotos(
                "seoul",
                1,
                page,
                perPage
        ).enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStat().equalsIgnoreCase("ok")) {
                        page = response.body().getPhotos().getPage();
                        for (int i = 0; i < response.body().getPhotos().getPhoto().size(); i++) {
                            recyclerModel.add(response.body().getPhotos().getPhoto().get(i));
                        }
                        recyclerModel.notifyDataSetChange();
                    }
                }
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Log.d("userhabit", "onFailure");
            }
        });
    }

    public void photoClicked(String photoId){
        Log.d("cylee","photoClicked !");
        Log.d("cylee","photoid : " + photoId);
        Bundle bundle = new Bundle();
        bundle.putString("photoId", photoId);
        navigator.navigationToEventView(bundle);
    }

    public ImageRecyclerModel getRecyclerModel() {
        return recyclerModel;
    }

    public void setRecyclerModel(ImageRecyclerModel recyclerModel) {
        this.recyclerModel = recyclerModel;
    }

}

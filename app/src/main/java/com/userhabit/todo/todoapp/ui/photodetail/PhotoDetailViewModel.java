package com.userhabit.todo.todoapp.ui.photodetail;

import android.databinding.ObservableField;

import com.userhabit.todo.todoapp.data.PhotoDetailResponse;
import com.userhabit.todo.todoapp.data.PhotoRepository;
import com.userhabit.todo.todoapp.databinding.FragmentPhotodetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDetailViewModel {

    PhotoRepository repository;
    FragmentPhotodetailBinding binding;
    public ObservableField<String> photoUrl = new ObservableField<>();

    public PhotoDetailViewModel(
            PhotoRepository repository,
            FragmentPhotodetailBinding binding
    ) {
        this.repository = repository;
        this.binding = binding;
    }

    public void loadPhoto(String photoid) {
        repository.getPhoto(photoid)
                .enqueue(new Callback<PhotoDetailResponse>() {
                    @Override
                    public void onResponse(Call<PhotoDetailResponse> call, Response<PhotoDetailResponse> response) {
                        binding.setPhoto(response.body().getPhoto());
                    }

                    @Override
                    public void onFailure(Call<PhotoDetailResponse> call, Throwable t) {

                    }
                });
    }
}

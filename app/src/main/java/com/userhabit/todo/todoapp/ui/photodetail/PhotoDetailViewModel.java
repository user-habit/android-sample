package com.userhabit.todo.todoapp.ui.photodetail;

import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

import com.userhabit.todo.todoapp.BR;
import com.userhabit.todo.todoapp.data.PhotoDetailResponse;
import com.userhabit.todo.todoapp.data.PhotoRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDetailViewModel {

    PhotoRepository repository;
    ViewDataBinding binding;
    public ObservableField<String> photoUrl = new ObservableField<>();

    public PhotoDetailViewModel(
            PhotoRepository repository,
            ViewDataBinding binding
    ) {
        this.repository = repository;
        this.binding = binding;
    }

    public void loadPhoto(String photoid) {
        repository.getPhoto(photoid)
                .enqueue(new Callback<PhotoDetailResponse>() {
                    @Override
                    public void onResponse(Call<PhotoDetailResponse> call, Response<PhotoDetailResponse> response) {
                        binding.setVariable(BR.photo, response.body().getPhoto());
                    }

                    @Override
                    public void onFailure(Call<PhotoDetailResponse> call, Throwable t) {

                    }
                });
    }
}

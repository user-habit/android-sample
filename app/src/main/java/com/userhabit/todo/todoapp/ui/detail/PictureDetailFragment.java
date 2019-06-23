package com.userhabit.todo.todoapp.ui.detail;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userhabit.todo.todoapp.data.photo.PhotoDetail;
import com.userhabit.todo.todoapp.databinding.FragmentPictureDetailBinding;
import com.userhabit.todo.todoapp.domain.GetPictureDetailUseCase;
import com.userhabit.todo.todoapp.util.Extentions;
import com.userhabit.todo.todoapp.util.InjectionUseCaseUtils;
import com.userhabit.todo.todoapp.util.InjectionUtils;

public class PictureDetailFragment extends Fragment {

    PictureDetailViewModel pictureDetailViewModel = null;

    public static Fragment newInstance() {
        return new PictureDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        pictureDetailViewModel = provideViewModel(InjectionUseCaseUtils.providePictureDetailUseCase());
        pictureDetailViewModel.setPictureId(getArguments().getString("id"));
        pictureDetailViewModel.execute();
        final FragmentPictureDetailBinding binding = FragmentPictureDetailBinding.inflate(LayoutInflater.from(container.getContext()), container, false);
        pictureDetailViewModel.pictureDetailLiveData.observe(this, new Observer<PhotoDetail>() {
            @Override
            public void onChanged(@Nullable PhotoDetail photoDetail) {
                if (photoDetail != null)
                    binding.setPhoto(photoDetail);
            }
        });
        return binding.getRoot();
    }

    private PictureDetailViewModel provideViewModel(GetPictureDetailUseCase pictureDetailUseCase) {
        return (PictureDetailViewModel) Extentions.provideViewModel(this, InjectionUtils.providePictureDetailViewModelFactory(pictureDetailUseCase), PictureDetailViewModel.class);
    }
}

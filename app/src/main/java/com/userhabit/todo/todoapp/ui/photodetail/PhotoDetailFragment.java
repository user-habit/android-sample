package com.userhabit.todo.todoapp.ui.photodetail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.userhabit.todo.todoapp.BR;
import com.userhabit.todo.todoapp.R;
import com.userhabit.todo.todoapp.data.PhotoRepository;
import com.userhabit.todo.todoapp.databinding.FragmentPhotodetailBinding;
import com.userhabit.todo.todoapp.databinding.FragmentPhotodetailBindingImpl;

import io.userhabit.service.Userhabit;

public class PhotoDetailFragment extends Fragment {

    private static Fragment photoDetailFragment;
    private PhotoDetailViewModel photoDetailViewModel;

    public static Fragment newInstance(Bundle bundle) {
        photoDetailFragment = new PhotoDetailFragment();
        photoDetailFragment.setArguments(bundle);
        return photoDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photodetail, container, false);
        photoDetailViewModel = new PhotoDetailViewModel(
                new PhotoRepository(),
                binding
        );
        binding.setVariable(BR.viewmodel, photoDetailViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("cylee", "bundle id : " + getArguments().getString("photoId"));
        String photoId = getArguments().getString("photoId");
        photoDetailViewModel.loadPhoto(photoId);
    }

    @Override
    public void onResume() {
        super.onResume();

        /**
         * 추가 화면 정의
         * 자동 수집을 하지 못하는 화면 / 사용자 정의 화면이 필요할 경우
         * 아래의 Api 호출
         **/
        Userhabit.setScreen(getActivity(), "이미지 상세화면");
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}

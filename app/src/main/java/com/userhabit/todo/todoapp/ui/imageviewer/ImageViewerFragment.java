package com.userhabit.todo.todoapp.ui.imageviewer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userhabit.todo.todoapp.R;
import com.userhabit.todo.todoapp.data.photo.Photo;
import com.userhabit.todo.todoapp.data.PhotoRepository;
import com.userhabit.todo.todoapp.databinding.ItemImageBinding;
import com.userhabit.todo.todoapp.ui.navigator.FragmentNavigator;
import com.userhabit.todo.todoapp.ui.navigator.Navigator;

import java.util.ArrayList;

import io.userhabit.service.Userhabit;

public class ImageViewerFragment extends Fragment {

    private static Fragment imageViewerFragment;
    ImageViewerViewModel imageViewModel;
    Navigator fragmentNavigator;
    RecyclerView recyclerView;
    ImageRecyclerAdapater recyclerAdapater;

    public static Fragment newInstance() {
        imageViewerFragment = new ImageViewerFragment();
        return imageViewerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imageviewer, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentNavigator = new FragmentNavigator(imageViewerFragment);
        imageViewModel = new ImageViewerViewModel(
                new PhotoRepository(),
                fragmentNavigator
        );
        recyclerAdapater = new ImageRecyclerAdapater(imageViewModel);
        imageViewModel.setRecyclerModel(recyclerAdapater);
        recyclerView.setAdapter(recyclerAdapater);
        recyclerView.setLayoutManager(
                new GridLayoutManager(
                        requireActivity(),
                        3
                )
        );

        /**
         * Userhabit Scroll 데이터 분석
         **/
        Userhabit.addScrollView(recyclerView);
        imageViewModel.loadPhotos();
    }

    @Override
    public void onResume() {
        super.onResume();

        /**
         * 추가 화면 정의
         * 자동 수집을 하지 못하는 화면 / 사용자 정의 화면이 필요할 경우
         * 아래의 Api 호출
         **/
        Userhabit.setScreen(getActivity(), "이미지 화면");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("cylee", "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("cylee", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("cylee", "onDestroyView");
    }
}

class ImageViewHolder extends RecyclerView.ViewHolder {

    ItemImageBinding binding;

    public ImageViewHolder(@NonNull Object binding) {
        super(((ItemImageBinding) binding).getRoot());
        this.binding = (ItemImageBinding) binding;
    }

    public void onBind(Photo photo) {
        binding.setPhoto(photo);
        binding.executePendingBindings();
    }
}

class ImageRecyclerAdapater extends RecyclerView.Adapter<ImageViewHolder> implements ImageRecyclerModel {

    ArrayList<Photo> photos = new ArrayList<>();
    ImageViewerViewModel imageViewerViewModel;

    public ImageRecyclerAdapater(ImageViewerViewModel imageViewerViewModel) {
        this.imageViewerViewModel = imageViewerViewModel;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemImageBinding binding = ItemImageBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        binding.setViewmodel(imageViewerViewModel);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.onBind(photos.get(i));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    @Override
    public void add(Photo photo) {
        photos.add(photo);
    }

    @Override
    public Photo getItem(int position) {
        return photos.get(position);
    }

    @Override
    public void notifyDataSetChange() {
        notifyDataSetChanged();
    }
}

interface ImageRecyclerModel {

    void add(Photo photo);

    Photo getItem(int position);

    void notifyDataSetChange();
}


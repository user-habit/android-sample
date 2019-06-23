package com.userhabit.todo.todoapp.ui.picture;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userhabit.todo.todoapp.R;
import com.userhabit.todo.todoapp.data.photo.Photos;
import com.userhabit.todo.todoapp.util.Extentions;
import com.userhabit.todo.todoapp.util.InjectionUtils;

public class PictureListFragment extends Fragment {

    private static PictureListFragment pictureListFragment;

    private PictureViewModel pictureViewModel;

    RecyclerView recyclerView;
    PictureRecyclerAdapter pictureRecyclerAdapter;

    public static Fragment newInstance() {
        pictureListFragment = new PictureListFragment();
        return pictureListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        this.recyclerView = view.findViewById(R.id.recyclerView);
        pictureViewModel = provideViewModel();
        pictureRecyclerAdapter = InjectionUtils.providePictureRecyclerAdapter();
        recyclerView.setAdapter(pictureRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(
                requireActivity(),
                3
        ));
        pictureViewModel.photos.observe(this, new Observer<Photos>() {
            @Override
            public void onChanged(@Nullable Photos photos) {
                pictureRecyclerAdapter.submitList(photos.getPhoto());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public PictureViewModel provideViewModel() {
        return (PictureViewModel) Extentions.provideViewModel(this, InjectionUtils.pictureViewModelFactory(), PictureViewModel.class);
    }
}

package com.userhabit.todo.todoapp.ui.picture;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userhabit.todo.todoapp.data.photo.Photo;
import com.userhabit.todo.todoapp.databinding.ItemPictureBinding;

public class PictureRecyclerAdapter extends ListAdapter<Photo, PictureRecyclerAdapter.PictureViewHolder> {

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("cylee", "picture item click");
        }
    };

    public PictureRecyclerAdapter(@NonNull DiffUtil.ItemCallback<Photo> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemPictureBinding binding = ItemPictureBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new PictureViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder pictureViewholder, int i) {
        Photo photo = getItem(i);
        pictureViewholder.bind(photo, clickListener);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    class PictureViewHolder extends RecyclerView.ViewHolder {

        ItemPictureBinding binding;

        public PictureViewHolder(ItemPictureBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Photo photo, View.OnClickListener clickListener) {
            binding.setPhoto(photo);
            binding.setClickListener(clickListener);
            binding.executePendingBindings();
        }
    }
}

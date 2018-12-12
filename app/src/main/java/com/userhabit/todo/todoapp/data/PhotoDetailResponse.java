package com.userhabit.todo.todoapp.data;

import com.google.gson.annotations.SerializedName;
import com.userhabit.todo.todoapp.data.photo.PhotoDetail;

public class PhotoDetailResponse {

    String stat;
    @SerializedName("photo")
    PhotoDetail photo;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public PhotoDetail getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDetail photo) {
        this.photo = photo;
    }
}

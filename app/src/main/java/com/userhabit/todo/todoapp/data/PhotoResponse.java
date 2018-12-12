package com.userhabit.todo.todoapp.data;

import com.userhabit.todo.todoapp.data.photo.Photos;

public class PhotoResponse {

    String stat;
    Photos photos;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}

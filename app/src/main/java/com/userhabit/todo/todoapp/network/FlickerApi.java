package com.userhabit.todo.todoapp.network;

import com.userhabit.todo.todoapp.data.PhotoDetailResponse;
import com.userhabit.todo.todoapp.data.PhotoResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FlickerApi {

    String apikey = "24b7ba68c50b898d2d3c319778af5b7d";

    @POST("?method=flickr.photos.search&api_key=" + apikey + "&format=json&nojsoncallback=1")
    Call<PhotoResponse> getPhotos(
            @Query("text") String keyword,
            @Query("safe_search") int safeSearch,
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    @POST("?method=flickr.photos.getInfo&api_key=" + apikey + "&format=json&nojsoncallback=1")
    Call<PhotoDetailResponse> getPhoto(
            @Query("photo_id") String photoId
    );
}

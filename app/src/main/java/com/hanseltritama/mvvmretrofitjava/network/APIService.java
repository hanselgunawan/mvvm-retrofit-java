package com.hanseltritama.mvvmretrofitjava.network;

import com.hanseltritama.mvvmretrofitjava.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("Film.JSON")
    Call<List<MovieModel>> getMovieList();

}

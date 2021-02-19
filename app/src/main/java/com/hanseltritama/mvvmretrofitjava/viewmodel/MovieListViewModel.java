package com.hanseltritama.mvvmretrofitjava.viewmodel;

import com.hanseltritama.mvvmretrofitjava.model.MovieModel;
import com.hanseltritama.mvvmretrofitjava.network.APIService;
import com.hanseltritama.mvvmretrofitjava.network.RetroInstance;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> movieLiveData;

    public MovieListViewModel() {
        movieLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMovieListObserver() {
        return movieLiveData;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                movieLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movieLiveData.postValue(null);
            }
        });
    }
}

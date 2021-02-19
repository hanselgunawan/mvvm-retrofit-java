package com.hanseltritama.mvvmretrofitjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hanseltritama.mvvmretrofitjava.adapter.MovieListAdapter;
import com.hanseltritama.mvvmretrofitjava.model.MovieModel;
import com.hanseltritama.mvvmretrofitjava.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.ItemClickListener {

    private List<MovieModel> movieList;
    private MovieListAdapter adapter;
    private MovieListViewModel movieListViewModel;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorMessage = findViewById(R.id.noResultTv);
        RecyclerView recyclerView = findViewById(R.id.movie_recycler_view);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MovieListAdapter(this, movieList, this);
        recyclerView.setAdapter(adapter);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        setupObservers();
        movieListViewModel.makeApiCall();
    }

    private void setupObservers() {
        movieListViewModel.getMovieListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if (movieModels != null) {
                    movieList = movieModels;
                    adapter.setMovielist(movieModels);
                    errorMessage.setVisibility(View.GONE);
                } else {
                    errorMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onMovieClick(MovieModel movie) {
        Toast.makeText(this, "Movie Name: " + movie.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
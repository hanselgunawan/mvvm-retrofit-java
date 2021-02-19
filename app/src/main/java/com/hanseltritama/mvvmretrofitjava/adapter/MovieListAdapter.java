package com.hanseltritama.mvvmretrofitjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hanseltritama.mvvmretrofitjava.R;
import com.hanseltritama.mvvmretrofitjava.model.MovieModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context context;
    private List<MovieModel> movielist;
    private ItemClickListener clickListener;

    // grab data from Activity
    public MovieListAdapter(Context context, List<MovieModel> movielist, ItemClickListener clickListener) {
        this.context = context;
        this.movielist = movielist;
        this.clickListener = clickListener;
    }

    public void setMovielist(List<MovieModel> movielist) {
        this.movielist = movielist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        holder.movieTitle.setText(this.movielist.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onMovieClick(movielist.get(position));
            }
        });
        Glide.with(context)
                .load(this.movielist.get(position).getImage().get(0))
                .apply(RequestOptions.centerCropTransform())
                .into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        if (this.movielist != null) {
            return this.movielist.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle;
        ImageView movieImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.titleView);
            movieImage = itemView.findViewById(R.id.imageView);
        }
    }

    public interface ItemClickListener {
        public void onMovieClick(MovieModel movie);
    }
}

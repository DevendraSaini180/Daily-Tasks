package com.devendrasaini.sharedpreferencesapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class PhotosListAdapter extends RecyclerView.Adapter<PhotosListAdapter.PhotosViewHolder> {

    Context context;
    List<PhotosModel> photos;

    public PhotosListAdapter(List<PhotosModel> photos) {
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_photos_layout, parent, false);
        PhotosListAdapter.PhotosViewHolder photosViewHolder = new PhotosListAdapter.PhotosViewHolder(view);
        return photosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {
        holder.mId.setText(photos.get(position).getId());
        holder.mAuthor.setText(photos.get(position).getAuthor());
        Picasso.with(context).load(photos.get(position).getUrl()).into((Target) holder.mImage);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class PhotosViewHolder extends RecyclerView.ViewHolder {
        TextView mId, mAuthor, mImage;
        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.textViewId);
            mAuthor = itemView.findViewById(R.id.textViewAuthor);
            mImage = itemView.findViewById(R.id.imageView);
        }
    }
}

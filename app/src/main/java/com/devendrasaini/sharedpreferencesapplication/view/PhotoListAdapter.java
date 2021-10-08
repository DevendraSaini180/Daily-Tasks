package com.devendrasaini.sharedpreferencesapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devendrasaini.sharedpreferencesapplication.R;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.PhotosViewHolder> {

    Context context;
    List<PhotosModel> photos;

    public PhotoListAdapter(Context context, List<PhotosModel> photos) {
        this.context = context;
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_photo_list,parent,false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {
        holder.textId.setText("Image Id: "+photos.get(position).getId());
        holder.author.setText("Author: "+photos.get(position).getAuthor());
        holder.height.setText("Image Height: "+(int) photos.get(position).getHeight());
        holder.width.setText("Image Width: "+(int) photos.get(position).getWidth());
        holder.Url.setText("Url: "+photos.get(position).getUrl());
        holder.downloadUrl.setText("Download: "+photos.get(position).getDownload_url());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class PhotosViewHolder extends RecyclerView.ViewHolder {
        TextView textId,author, height, width, downloadUrl, Url;

        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            textId = itemView.findViewById(R.id.textViewId);
            author = itemView.findViewById(R.id.textViewAuthor);
            height = itemView.findViewById(R.id.textViewHeight);
            width = itemView.findViewById(R.id.textViewWidth);
            Url = itemView.findViewById(R.id.textViewUrl);
            downloadUrl = itemView.findViewById(R.id.textViewDownloadUrl);
        }
    }

}

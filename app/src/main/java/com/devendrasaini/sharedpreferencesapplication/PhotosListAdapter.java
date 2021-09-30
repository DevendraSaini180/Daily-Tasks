package com.devendrasaini.sharedpreferencesapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosListAdapter extends RecyclerView.Adapter<PhotosListAdapter.PhotosViewHolder> {

    Context context;
    List<PhotosModel> photos ;

    public PhotosListAdapter(Context context, List<PhotosModel> photos) {
        this.context = context;
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_photos_layout, parent, false);

        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {
        Picasso.get().load(photos.get(position).getDownload_url()).into(holder.mImage);
        holder.mId.setText(photos.get(position).getId());
        holder.mAuthor.setText(photos.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public static class PhotosViewHolder extends RecyclerView.ViewHolder {
        TextView mId, mAuthor;
        ImageView mImage;
        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.textViewId);
            mAuthor = itemView.findViewById(R.id.textViewAuthor);
            mImage = itemView.findViewById(R.id.imageView);
        }
    }
}

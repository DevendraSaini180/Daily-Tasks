package com.devendrasaini.sharedpreferencesapplication;

import com.google.gson.annotations.SerializedName;

public class PhotosModel {

    @SerializedName("id")
    private String id;
    @SerializedName("author")
    private String author;
    @SerializedName("width")
    private float width;
    @SerializedName("height")
    private float height;
    @SerializedName("url")
    private String url;
    @SerializedName("download_url")
    private String download_url;


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public String getDownload_url() {
        return download_url;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }
}

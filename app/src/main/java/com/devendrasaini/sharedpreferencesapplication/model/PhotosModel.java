package com.devendrasaini.sharedpreferencesapplication.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class PhotosModel {

    //@Generated("jsonschema2pojo")

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("width")
    @Expose
    private float width;
    @SerializedName("height")
    @Expose
    private float height;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("download_url")
    @Expose
    private String download_url;

    @Inject
    public PhotosModel(String id, String author, float width, float height, String url, String download_url) {
        this.id = id;
        this.author = author;
        this.width = width;
        this.height = height;
        this.url = url;
        this.download_url = download_url;
    }


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

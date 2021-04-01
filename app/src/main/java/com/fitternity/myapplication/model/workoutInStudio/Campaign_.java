package com.fitternity.myapplication.model.workoutInStudio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Campaign_
{
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("bg_color")
    @Expose
    private String bgColor;
    @SerializedName("text_color")
    @Expose
    private String textColor;
    @SerializedName("url")
    @Expose
    private String url;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

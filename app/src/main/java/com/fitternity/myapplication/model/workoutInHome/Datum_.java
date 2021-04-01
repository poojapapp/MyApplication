package com.fitternity.myapplication.model.workoutInHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum_
{
    @SerializedName("challenge_id")
    @Expose
    private Integer challengeId;
    @SerializedName("challenge_slug")
    @Expose
    private String challengeSlug;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("web_image")
    @Expose
    private String webImage;
    @SerializedName("wap_image")
    @Expose
    private String wapImage;
    @SerializedName("app_image")
    @Expose
    private String appImage;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public String getChallengeSlug() {
        return challengeSlug;
    }

    public void setChallengeSlug(String challengeSlug) {
        this.challengeSlug = challengeSlug;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getWebImage() {
        return webImage;
    }

    public void setWebImage(String webImage) {
        this.webImage = webImage;
    }

    public String getWapImage() {
        return wapImage;
    }

    public void setWapImage(String wapImage) {
        this.wapImage = wapImage;
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

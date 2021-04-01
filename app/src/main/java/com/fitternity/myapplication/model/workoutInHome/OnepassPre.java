package com.fitternity.myapplication.model.workoutInHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OnepassPre
{
    @SerializedName("header_img")
    @Expose
    private String headerImg;
    @SerializedName("button_text")
    @Expose
    private String buttonText;
    @SerializedName("passes")
    @Expose
    private Passes passes;
    @SerializedName("campaign")
    @Expose
    private Campaign_ campaign;

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public Passes getPasses() {
        return passes;
    }

    public void setPasses(Passes passes) {
        this.passes = passes;
    }

    public Campaign_ getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign_ campaign) {
        this.campaign = campaign;
    }
}

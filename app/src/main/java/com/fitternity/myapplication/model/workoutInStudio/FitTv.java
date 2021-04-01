package com.fitternity.myapplication.model.workoutInStudio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FitTv
{
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("button_text")
    @Expose
    private String buttonText;
    @SerializedName("data")
    @Expose
    private List<Datum__> data = null;
    @SerializedName("campaign")
    @Expose
    private Campaign_____ campaign;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public List<Datum__> getData() {
        return data;
    }

    public void setData(List<Datum__> data) {
        this.data = data;
    }

    public Campaign_____ getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign_____ campaign) {
        this.campaign = campaign;
    }
}

package com.fitternity.myapplication.model.workoutInStudio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Challenge
{
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("data")
    @Expose
    private List<Datum_> data = null;
    @SerializedName("campaign")
    @Expose
    private Campaign____ campaign;

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

    public List<Datum_> getData() {
        return data;
    }

    public void setData(List<Datum_> data) {
        this.data = data;
    }

    public Campaign____ getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign____ campaign) {
        this.campaign = campaign;
    }
}

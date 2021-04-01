package com.fitternity.myapplication.model.workoutInHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeScreenAtHomeResponse
{
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("instudio")
    @Expose
    private String instudio;
    @SerializedName("product_tags")
    @Expose
    private List<ProductTag> productTags = null;
    @SerializedName("campaigns")
    @Expose
    private List<Campaign> campaigns = null;
    @SerializedName("onepass_pre")
    @Expose
    private OnepassPre onepassPre;
    @SerializedName("personal_training")
    @Expose
    private PersonalTraining personalTraining;
    @SerializedName("upcoming_classes")
    @Expose
    private UpcomingClasses upcomingClasses;
    @SerializedName("challenge")
    @Expose
    private Challenge challenge;
    @SerializedName("fit_tv")
    @Expose
    private FitTv fitTv;
    @SerializedName("section_orders")
    @Expose
    private List<String> sectionOrders = null;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getInstudio() {
        return instudio;
    }

    public void setInstudio(String instudio) {
        this.instudio = instudio;
    }

    public List<ProductTag> getProductTags() {
        return productTags;
    }

    public void setProductTags(List<ProductTag> productTags) {
        this.productTags = productTags;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public OnepassPre getOnepassPre() {
        return onepassPre;
    }

    public void setOnepassPre(OnepassPre onepassPre) {
        this.onepassPre = onepassPre;
    }

    public PersonalTraining getPersonalTraining() {
        return personalTraining;
    }

    public void setPersonalTraining(PersonalTraining personalTraining) {
        this.personalTraining = personalTraining;
    }

    public UpcomingClasses getUpcomingClasses() {
        return upcomingClasses;
    }

    public void setUpcomingClasses(UpcomingClasses upcomingClasses) {
        this.upcomingClasses = upcomingClasses;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public FitTv getFitTv() {
        return fitTv;
    }

    public void setFitTv(FitTv fitTv) {
        this.fitTv = fitTv;
    }

    public List<String> getSectionOrders() {
        return sectionOrders;
    }

    public void setSectionOrders(List<String> sectionOrders) {
        this.sectionOrders = sectionOrders;
    }
}

package com.fitternity.myapplication.model.workoutInHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum__
{
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("difficulty_level")
    @Expose
    private Integer difficultyLevel;
    @SerializedName("difficulty_level_str")
    @Expose
    private String difficultyLevelStr;
    @SerializedName("trainer")
    @Expose
    private String trainer;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("slug")
    @Expose
    private String slug;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevelStr() {
        return difficultyLevelStr;
    }

    public void setDifficultyLevelStr(String difficultyLevelStr) {
        this.difficultyLevelStr = difficultyLevelStr;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}

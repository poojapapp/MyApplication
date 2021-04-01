package com.fitternity.myapplication.model.workoutInHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Passes
{
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("header1")
    @Expose
    private String header1;
    @SerializedName("header1_color")
    @Expose
    private String header1Color;
    @SerializedName("header2")
    @Expose
    private String header2;
    @SerializedName("header2_color")
    @Expose
    private String header2Color;
    @SerializedName("subheader")
    @Expose
    private String subheader;
    @SerializedName("desc_header")
    @Expose
    private String descHeader;
    @SerializedName("onepass_type")
    @Expose
    private String onepassType;
    @SerializedName("description")
    @Expose
    private String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeader1() {
        return header1;
    }

    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public String getHeader1Color() {
        return header1Color;
    }

    public void setHeader1Color(String header1Color) {
        this.header1Color = header1Color;
    }

    public String getHeader2() {
        return header2;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public String getHeader2Color() {
        return header2Color;
    }

    public void setHeader2Color(String header2Color) {
        this.header2Color = header2Color;
    }

    public String getSubheader() {
        return subheader;
    }

    public void setSubheader(String subheader) {
        this.subheader = subheader;
    }

    public String getDescHeader() {
        return descHeader;
    }

    public void setDescHeader(String descHeader) {
        this.descHeader = descHeader;
    }

    public String getOnepassType() {
        return onepassType;
    }

    public void setOnepassType(String onepassType) {
        this.onepassType = onepassType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

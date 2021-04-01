package com.fitternity.myapplication.model.workoutInHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flags
{
    @SerializedName("onepass_max_booking_count")
    @Expose
    private Integer onepassMaxBookingCount;

    public Integer getOnepassMaxBookingCount() {
        return onepassMaxBookingCount;
    }

    public void setOnepassMaxBookingCount(Integer onepassMaxBookingCount) {
        this.onepassMaxBookingCount = onepassMaxBookingCount;
    }
}

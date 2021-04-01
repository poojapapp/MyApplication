package com.fitternity.myapplication.model.workoutInHome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum
{
    @SerializedName("average_rating")
    @Expose
    private Double averageRating;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("vendor_slug")
    @Expose
    private String vendorSlug;
    @SerializedName("vendor_name")
    @Expose
    private String vendorName;
    @SerializedName("coverimage")
    @Expose
    private String coverimage;
    @SerializedName("overlayimage")
    @Expose
    private String overlayimage;
    @SerializedName("next_slot")
    @Expose
    private String nextSlot;
    @SerializedName("total_rating_count")
    @Expose
    private Integer totalRatingCount;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("commercial")
    @Expose
    private String commercial;
    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("booking_points")
    @Expose
    private Integer bookingPoints;
    @SerializedName("session_time")
    @Expose
    private Integer sessionTime;
    @SerializedName("overlayimage_v2")
    @Expose
    private OverlayimageV2 overlayimageV2;
    @SerializedName("pps_oneliner")
    @Expose
    private String ppsOneliner;
    /* @SerializedName("flags")
     @Expose
     private Flags flags;*/
    @SerializedName("overlay_details")
    @Expose
    private List<OverlayDetail> overlayDetails = null;
    @SerializedName("live_location")
    @Expose
    private String liveLocation;
    @SerializedName("live_location_icon")
    @Expose
    private String liveLocationIcon;
    @SerializedName("special_price")
    @Expose
    private Integer specialPrice;
    @SerializedName("best_seller")
    @Expose
    private Boolean bestSeller;

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getVendorSlug() {
        return vendorSlug;
    }

    public void setVendorSlug(String vendorSlug) {
        this.vendorSlug = vendorSlug;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    public String getOverlayimage() {
        return overlayimage;
    }

    public void setOverlayimage(String overlayimage) {
        this.overlayimage = overlayimage;
    }

    public String getNextSlot() {
        return nextSlot;
    }

    public void setNextSlot(String nextSlot) {
        this.nextSlot = nextSlot;
    }

    public Integer getTotalRatingCount() {
        return totalRatingCount;
    }

    public void setTotalRatingCount(Integer totalRatingCount) {
        this.totalRatingCount = totalRatingCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getBookingPoints() {
        return bookingPoints;
    }

    public void setBookingPoints(Integer bookingPoints) {
        this.bookingPoints = bookingPoints;
    }

    public Integer getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Integer sessionTime) {
        this.sessionTime = sessionTime;
    }

    public OverlayimageV2 getOverlayimageV2() {
        return overlayimageV2;
    }

    public void setOverlayimageV2(OverlayimageV2 overlayimageV2) {
        this.overlayimageV2 = overlayimageV2;
    }

    public String getPpsOneliner() {
        return ppsOneliner;
    }

    public void setPpsOneliner(String ppsOneliner) {
        this.ppsOneliner = ppsOneliner;
    }

    /* public Flags getFlags() {
         return flags;
     }

     public void setFlags(Flags flags) {
         this.flags = flags;
     }
 */
    public List<OverlayDetail> getOverlayDetails() {
        return overlayDetails;
    }

    public void setOverlayDetails(List<OverlayDetail> overlayDetails) {
        this.overlayDetails = overlayDetails;
    }

    public String getLiveLocation() {
        return liveLocation;
    }

    public void setLiveLocation(String liveLocation) {
        this.liveLocation = liveLocation;
    }

    public String getLiveLocationIcon() {
        return liveLocationIcon;
    }

    public void setLiveLocationIcon(String liveLocationIcon) {
        this.liveLocationIcon = liveLocationIcon;
    }

    public Integer getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Integer specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Boolean getBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(Boolean bestSeller) {
        this.bestSeller = bestSeller;
    }
}

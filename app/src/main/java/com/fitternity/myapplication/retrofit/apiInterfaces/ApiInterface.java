package com.fitternity.myapplication.retrofit.apiInterfaces;

import com.fitternity.myapplication.model.workoutInHome.HomeScreenAtHomeResponse;
import com.fitternity.myapplication.model.workoutInStudio.HomeScreenAtStudioResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
  @GET("HomeScreenAtHome.json")
  public Call<HomeScreenAtStudioResponse> getStudioData();

  @GET("HomeScreenAtHome.json")
  public Call<HomeScreenAtHomeResponse> getHomeData();
}

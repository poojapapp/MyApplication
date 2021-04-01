package com.fitternity.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fitternity.myapplication.R;
import com.fitternity.myapplication.adapter.FitTvHomeAdapter;
import com.fitternity.myapplication.adapter.UpcomingCassAdapter;
import com.fitternity.myapplication.adapter.UpcomingClassHomeAdapter;
import com.fitternity.myapplication.adapter.WorkInHomeAdapter;
import com.fitternity.myapplication.adapter.WorkInStudioAdapter;
import com.fitternity.myapplication.model.workoutInHome.Campaign;
import com.fitternity.myapplication.model.workoutInHome.Datum;
import com.fitternity.myapplication.model.workoutInHome.Datum__;
import com.fitternity.myapplication.model.workoutInHome.FitTv;
import com.fitternity.myapplication.model.workoutInHome.HomeScreenAtHomeResponse;

import com.fitternity.myapplication.model.workoutInHome.OverlayDetail;
import com.fitternity.myapplication.model.workoutInHome.UpcomingClasses;
import com.fitternity.myapplication.model.workoutInStudio.HomeScreenAtStudioResponse;
import com.fitternity.myapplication.retrofit.RetroClientInstance;
import com.fitternity.myapplication.retrofit.RetrofitCallback;
import com.fitternity.myapplication.retrofit.apiInterfaces.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class WorkOutHomeFragement extends BaseFragment {
    RecyclerView rec_productList,rec_presonalTraining,recyclerview_fitTv;
    private WorkInHomeAdapter workInHomeAdapter;
    UpcomingClassHomeAdapter upcomingClassHomeAdapter;
    List<UpcomingClasses> upcomingClasses;
    List<Datum> data;
    List<Datum__> datum__;
    List<FitTv> fitTvs;
    List<OverlayDetail> overlayDetails;
    FitTvHomeAdapter fitTvHomeAdapter;
    ImageView img_pass;
    TextView text_challengesTitle,text_challenges_desc,text_fitTvTitle,text_fitTvDesc,text_onlineTitle,text_pass_desc,text_TainingTitle,text_tainingDesc;
    List<Campaign> compaign;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_work_out_home_fragement, container, false );
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setUpRecyclerviewProductList(view);
        setUpRecyclerviewTrainingList( view );
        setUpRecyclerviewFitTvList( view );
        getHomeData();
    }
    public void init(View view){
        text_challengesTitle= view.findViewById(R.id.text_challengesTitle);
        text_challenges_desc = view.findViewById( R.id.text_challenges_desc );
        text_fitTvTitle  = view.findViewById( R.id.text_fitTvTitle );
        text_fitTvDesc = view.findViewById( R.id.text_fitTvDesc );
        text_onlineTitle = view.findViewById( R.id.text_onlineTitle );
        img_pass = view.findViewById( R.id.img_pass );
        text_pass_desc = view.findViewById( R.id.text_pass_desc );
        text_TainingTitle = view.findViewById( R.id.text_TainingTitle );
        text_tainingDesc = view.findViewById( R.id.text_tainingDesc );
    }
    private void setUpRecyclerviewProductList(View view) {
        rec_productList = view.findViewById( R.id.rec_productList );
        compaign = new ArrayList<>();
        workInHomeAdapter= new WorkInHomeAdapter(compaign,mContext);
        rec_productList.setAdapter(workInHomeAdapter);
        rec_productList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        rec_productList.setLayoutManager(layoutManager);
    }
    private void setUpRecyclerviewTrainingList(View view) {
        rec_presonalTraining = view.findViewById( R.id.rec_presonalTraining );
        upcomingClasses = new ArrayList<>();
        data = new ArrayList<>();
        overlayDetails  =new ArrayList<>();
        upcomingClassHomeAdapter = new UpcomingClassHomeAdapter(upcomingClasses,data,overlayDetails,mContext);
        rec_presonalTraining.setAdapter(upcomingClassHomeAdapter);
        rec_presonalTraining.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        rec_presonalTraining.setLayoutManager(layoutManager);
    }
    private void setUpRecyclerviewFitTvList(View view) {
        recyclerview_fitTv  = view.findViewById( R.id.recyclerview_fitTv );
        datum__ = new ArrayList<>(  );
        fitTvs = new ArrayList<>(  );
        fitTvHomeAdapter = new FitTvHomeAdapter(datum__,mContext);
        recyclerview_fitTv.setAdapter(fitTvHomeAdapter);
        recyclerview_fitTv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerview_fitTv.setLayoutManager(layoutManager);
    }
    private void getHomeData() {
        ApiInterface apiInterface = RetroClientInstance.getRetrofitInstance(mContext).create(ApiInterface.class);
        Call<HomeScreenAtHomeResponse> getUserInformationResponseCall = apiInterface.getHomeData();
        getUserInformationResponseCall.enqueue( new RetrofitCallback<HomeScreenAtHomeResponse>(mActivity,true) {
            @Override
            public void onSuccess(HomeScreenAtHomeResponse response) {
                Log.i("Location",response.getCityName());
                compaign.addAll(0,response.getCampaigns());
                workInHomeAdapter.notifyDataSetChanged();
                workInHomeAdapter.notifyItemRangeInserted( 0, compaign.size() );
                rec_productList.scrollToPosition( 0 );
                text_challengesTitle.setText( response.getChallenge().getTitle());
                text_challenges_desc.setText( response.getChallenge().getDescription());
                text_fitTvTitle.setText( response.getFitTv().getTitle() );
                text_fitTvDesc.setText( response.getFitTv().getDescription() );
                text_onlineTitle.setText( response.getPersonalTraining().getTitle());
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.isMemoryCacheable();
                Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                        .load(response.getPersonalTraining().getImage())
                        .into(img_pass);
                text_pass_desc.setText( response.getPersonalTraining().getDescription());
                text_TainingTitle.setText( response.getPersonalTraining().getTitle());
                text_tainingDesc.setText( response.getPersonalTraining().getDescription());

                data.addAll(response.getUpcomingClasses().getData());
                upcomingClassHomeAdapter.notifyDataSetChanged();
                upcomingClassHomeAdapter.notifyItemRangeInserted( 0, data.size() );
                rec_presonalTraining.scrollToPosition( 0 );

                datum__.addAll(response.getFitTv().getData());
                fitTvHomeAdapter.notifyDataSetChanged();
                fitTvHomeAdapter.notifyItemRangeInserted( 0, datum__.size() );
                recyclerview_fitTv.scrollToPosition( 0 );
            }
        });
    }
}
package com.fitternity.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.fitternity.myapplication.adapter.FitTvAdapter;
import com.fitternity.myapplication.adapter.UpcomingCassAdapter;
import com.fitternity.myapplication.adapter.WorkInStudioAdapter;
import com.fitternity.myapplication.model.workoutInStudio.Campaign;
import com.fitternity.myapplication.model.workoutInStudio.Datum;
import com.fitternity.myapplication.model.workoutInStudio.Datum__;
import com.fitternity.myapplication.model.workoutInStudio.FitTv;
import com.fitternity.myapplication.model.workoutInStudio.HomeScreenAtStudioResponse;
import com.fitternity.myapplication.model.workoutInStudio.OverlayDetail;
import com.fitternity.myapplication.model.workoutInStudio.UpcomingClasses;
import com.fitternity.myapplication.retrofit.RetroClientInstance;
import com.fitternity.myapplication.retrofit.RetrofitCallback;
import com.fitternity.myapplication.retrofit.apiInterfaces.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class WorkInStudioFragment extends BaseFragment{
    List<Campaign> compaign;
    List<UpcomingClasses> upcomingClasses;
    List<FitTv> fitTvs;
    List<Datum__> datum__;
    List<Datum> data;
    List<OverlayDetail> overlayDetails;
    RecyclerView recyclerview_workinstudio,recyclerview_upcomingClasses,recyclerview_fitTv;
    private List<HomeScreenAtStudioResponse> studioResponses;
    private WorkInStudioAdapter workInStudioAdapter;
    private UpcomingCassAdapter upcomingCassAdapter;
    private FitTvAdapter fitTvAdapter;
    ImageView img_discount,img_onePass,img_pass;
    TextView text_alert,text_pass_desc,text_upcomingTitle;
    TextView text_flexi_membership,text_upcomingDesc,text_fittvTitle,text_fitTvDesc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate( R.layout.fragment_work_in_studio, container, false );
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setUpRecyclerviewCompaignList(view);
        setUpRecyclerviewUpcomingList(view);
        setUpRecyclerviewFitTvList( view );
        getStudioData();
    }



    private void init(View view) {
        img_discount = view.findViewById( R.id.img_discount );
        img_onePass = view.findViewById( R.id.img_onePass );
        text_alert = view.findViewById( R.id.text_alert );
        text_flexi_membership = view.findViewById( R.id.text_flexi_membership );
        img_pass = view.findViewById( R.id.img_pass );
        text_pass_desc = view.findViewById( R.id.text_pass_desc );
        text_upcomingTitle = view.findViewById( R.id.text_upcomingTitle );
        text_upcomingDesc = view.findViewById( R.id.text_upcomingDesc );
        text_fittvTitle = view.findViewById( R.id.text_fittvTitle );
        text_fitTvDesc = view.findViewById( R.id.text_fitTvDesc );
    }

    private void setUpRecyclerviewCompaignList(View view) {
        recyclerview_workinstudio = view.findViewById( R.id.recyclerview_workinstudio );
        compaign = new ArrayList<>();
        workInStudioAdapter= new WorkInStudioAdapter(compaign,mContext);
        recyclerview_workinstudio.setAdapter(workInStudioAdapter);
        recyclerview_workinstudio.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerview_workinstudio.setLayoutManager(layoutManager);
    }

    private void setUpRecyclerviewUpcomingList(View view) {
        recyclerview_upcomingClasses = view.findViewById( R.id.recyclerview_upcomingClasses );
        upcomingClasses = new ArrayList<>();
        data = new ArrayList<>();
        overlayDetails  =new ArrayList<>();
        upcomingCassAdapter = new UpcomingCassAdapter(upcomingClasses,data,overlayDetails,mContext);
        recyclerview_upcomingClasses.setAdapter(upcomingCassAdapter);
        recyclerview_upcomingClasses.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerview_upcomingClasses.setLayoutManager(layoutManager);
    }
    private void setUpRecyclerviewFitTvList(View view) {
        recyclerview_fitTv = view.findViewById( R.id.recyclerview_fitTv );
        datum__ = new ArrayList<>();
        fitTvAdapter = new FitTvAdapter(fitTvs,datum__,mContext);
        recyclerview_fitTv.setAdapter(fitTvAdapter);
        recyclerview_fitTv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerview_fitTv.setLayoutManager(layoutManager);
    }

    private void getStudioData() {
        ApiInterface apiInterface = RetroClientInstance.getRetrofitInstance(mContext).create(ApiInterface.class);
        Call<HomeScreenAtStudioResponse> getUserInformationResponseCall = apiInterface.getStudioData();
        getUserInformationResponseCall.enqueue( new RetrofitCallback<HomeScreenAtStudioResponse>(mActivity,true) {
            @Override
            public void onSuccess(HomeScreenAtStudioResponse response) {
                Log.i("Location",response.getCityName());
                compaign.addAll(0,response.getCampaigns());
                workInStudioAdapter.notifyDataSetChanged();
                workInStudioAdapter.notifyItemRangeInserted( 0, compaign.size() );
                recyclerview_workinstudio.scrollToPosition( 0 );

                RequestOptions requestOptions = new RequestOptions();
                requestOptions.isMemoryCacheable();
                Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                        .load(response.getOnepassPre().getHeaderImg())
                        .into(img_onePass);
                text_flexi_membership.setText( response.getOnepassPre().getButtonText());
                Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                        .load(response.getOnepassPre().getPasses().getImage())
                        .into(img_pass);
                text_pass_desc.setText( response.getOnepassPre().getPasses().getDescription() );
                text_upcomingTitle.setText( response.getUpcomingClasses().getTitle());
                text_upcomingDesc.setText( response.getUpcomingClasses().getDescription());

                data.addAll(response.getUpcomingClasses().getData());
                upcomingCassAdapter.notifyDataSetChanged();
                upcomingCassAdapter.notifyItemRangeInserted( 0, data.size() );
                recyclerview_upcomingClasses.scrollToPosition( 0 );

                text_fittvTitle.setText( response.getFitTv().getTitle());
                text_fitTvDesc.setText( response.getFitTv().getDescription());

                datum__.addAll(response.getFitTv().getData());
                fitTvAdapter.notifyDataSetChanged();
                fitTvAdapter.notifyItemRangeInserted( 0, datum__.size() );
                recyclerview_fitTv.scrollToPosition( 0 );
            }
        });
    }
}
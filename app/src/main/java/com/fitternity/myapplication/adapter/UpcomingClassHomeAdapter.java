package com.fitternity.myapplication.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fitternity.myapplication.R;
import com.fitternity.myapplication.model.workoutInHome.Datum;
import com.fitternity.myapplication.model.workoutInHome.OverlayDetail;
import com.fitternity.myapplication.model.workoutInHome.UpcomingClasses;


import com.fitternity.myapplication.sharedpreferences.SharedPreferencesManager;

import java.util.List;

public class UpcomingClassHomeAdapter extends RecyclerView.Adapter<UpcomingClassHomeAdapter.ViewHolder>{

    List<UpcomingClasses> upcomingClasses;
    List<Datum> data;
    private Context mContext;
    private SharedPreferencesManager sharedPreferencesManager;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    Datum getData;
    List<OverlayDetail> overlayDetails;
    UpcomingClasses getUpcomingClasses;
    OverlayDetail getOverlayDetails;
    public UpcomingClassHomeAdapter(List<UpcomingClasses> upcomingClasses, List<Datum> data, List<OverlayDetail> overlayDetails, Context mContext) {
        this.upcomingClasses = upcomingClasses;
        this.data = data;
        this.overlayDetails = overlayDetails;
        this.mContext = mContext;
        sharedPreferencesManager= new SharedPreferencesManager();
    }
    @NonNull
    @Override
    public UpcomingClassHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate( R.layout.row_upcomingclass_home, parent, false);
        UpcomingClassHomeAdapter.ViewHolder viewHolder = new UpcomingClassHomeAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingClassHomeAdapter.ViewHolder holder, int position) {
        getData = data.get( position );
//        getOverlayDetails = overlayDetails.get( position );
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                .load(getData.getCoverimage())
                .into(holder.img_upcomingClass);
        holder.text_gymsTitle.setText(getData.getName());
        holder.text_locationAddr.setText( getData.getCity());
        holder.text_time.setText( getData.getNextSlot());
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                .load("https://b.fitn.in/service_page/Calories.png")
                .into(holder.img_calories);
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                .load("https://b.fitn.in/service_page/Price.png")
                .into(holder.img_duration);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_upcomingClass,img_calories,img_duration,img_price;
        TextView text_calories,text_duration,text_price,text_gymsTitle,text_locationAddr,text_time,text_fittvTitle;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            img_upcomingClass = itemView.findViewById( R.id.img_upcomingClass );
            img_calories = itemView.findViewById( R.id.img_calories );
            text_calories = itemView.findViewById( R.id.text_calories );
            img_duration = itemView.findViewById( R.id.img_duration );
            text_duration = itemView.findViewById( R.id.text_duration );
            img_price = itemView.findViewById( R.id.img_price );
            text_price = itemView.findViewById( R.id.text_price );
            text_gymsTitle = itemView.findViewById( R.id.text_gymsTitle );
            text_locationAddr = itemView.findViewById( R.id.text_locationAddr );
            text_time = itemView.findViewById( R.id.text_time );
            text_fittvTitle = itemView.findViewById( R.id.text_fittvTitle );
        }
    }
}

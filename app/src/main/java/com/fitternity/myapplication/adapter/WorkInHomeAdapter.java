package com.fitternity.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fitternity.myapplication.R;

import com.fitternity.myapplication.model.workoutInHome.Campaign;
import com.fitternity.myapplication.model.workoutInStudio.HomeScreenAtStudioResponse;
import com.fitternity.myapplication.sharedpreferences.SharedPreferencesManager;

import java.util.List;

public class WorkInHomeAdapter extends RecyclerView.Adapter<WorkInHomeAdapter.ViewHolder>
{
    List<Campaign> compaign;
    private List<HomeScreenAtStudioResponse> studioResponses;
    private SharedPreferencesManager sharedPreferencesManager;
    private Context mContext;
    Campaign getCampaign;
    public WorkInHomeAdapter(List<Campaign> compaign, Context mContext) {
        this.compaign=compaign;
        this.mContext=mContext;
        sharedPreferencesManager = new SharedPreferencesManager();
    }
    @NonNull
    @Override
    public WorkInHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate( R.layout.row_work_in_studio, parent, false);
        // Return a new holder instance
        WorkInHomeAdapter.ViewHolder viewHolder = new WorkInHomeAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkInHomeAdapter.ViewHolder holder, int position) {
        getCampaign =compaign.get(position);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                .load(getCampaign.getImage())
                .into(holder.img_studio);
    }

    @Override
    public int getItemCount() {
        return compaign.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_studio;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            img_studio = itemView.findViewById( R.id.img_studio );
        }
    }
}

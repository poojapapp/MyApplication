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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.fitternity.myapplication.R;
import com.fitternity.myapplication.model.workoutInHome.Datum;
import com.fitternity.myapplication.model.workoutInHome.Datum__;
import com.fitternity.myapplication.model.workoutInHome.FitTv;
import com.fitternity.myapplication.model.workoutInStudio.ProductTag;
import com.fitternity.myapplication.sharedpreferences.SharedPreferencesManager;

import java.util.List;

public class FitTvHomeAdapter extends RecyclerView.Adapter<FitTvHomeAdapter.ViewHolder>
{
    List<FitTv> fitTvs;
    List<Datum__> datum__;
    private Context mContext;
    private SharedPreferencesManager sharedPreferencesManager;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    FitTv getFitTv;
    Datum__ gatDatum__;
    public FitTvHomeAdapter(List<Datum__> datum__, Context mContext) {
        this.datum__ = datum__;
        this.mContext = mContext;
        sharedPreferencesManager= new SharedPreferencesManager();
    }
    @NonNull
    @Override
    public FitTvHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate( R.layout.fittv_list_home, parent, false);
        FitTvHomeAdapter.ViewHolder viewHolder = new FitTvHomeAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FitTvHomeAdapter.ViewHolder holder, int position) {
        gatDatum__ = datum__.get( position );
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                .load(gatDatum__.getImage())
                .into(holder.img_fitTv);
        holder.text_fitTvtitle.setText(gatDatum__.getTitle());
        holder.text_category.setText( gatDatum__.getCategory() );
        holder.text_trainer.setText( gatDatum__.getTrainer() );
        holder.text_titleBig.setText( gatDatum__.getDifficultyLevelStr() );
        holder.text_FitTveTime.setText( gatDatum__.getDuration()+"min" );
    }

    @Override
    public int getItemCount() {
        return datum__.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_fitTv;
        TextView text_fitTvtitle,text_category,text_trainer,text_titleBig,text_FitTveTime;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            img_fitTv = itemView.findViewById( R.id.img_fitTv );
            text_fitTvtitle = itemView.findViewById( R.id.text_fitTvtitle );
            text_category = itemView.findViewById( R.id.text_category );
            text_trainer = itemView.findViewById( R.id.text_trainer );
            text_titleBig = itemView.findViewById( R.id.text_titleBig );
            text_FitTveTime = itemView.findViewById( R.id.text_FitTveTime );
        }
    }
}

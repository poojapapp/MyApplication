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
import com.fitternity.myapplication.model.workoutInStudio.Datum__;
import com.fitternity.myapplication.model.workoutInStudio.FitTv;
import com.fitternity.myapplication.model.workoutInStudio.ProductTag;
import com.fitternity.myapplication.sharedpreferences.SharedPreferencesManager;

import java.util.List;

public class FitTvAdapter extends RecyclerView.Adapter<FitTvAdapter.ViewHolder>
{
    List<FitTv> fitTvs;
    private Context mContext;
    private SharedPreferencesManager sharedPreferencesManager;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    List<Datum__> datum_;
    Datum__ getFitTv;
    public FitTvAdapter(List<FitTv> fitTvs, List<Datum__> datum_, Context mContext) {
        this.fitTvs = fitTvs;
        this.datum_ = datum_;
        this.mContext = mContext;
        sharedPreferencesManager= new SharedPreferencesManager();
    }
    @NonNull
    @Override
    public FitTvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate( R.layout.fittv_list_studio, parent, false);
        FitTvAdapter.ViewHolder viewHolder = new FitTvAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FitTvAdapter.ViewHolder holder, int position) {
        getFitTv =datum_.get(position);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                .load(getFitTv.getImage())
                .into(holder.img_fitTv);
        holder.text_fitTvtitle.setText(getFitTv.getTitle());
        holder.text_titleBig.setText( getFitTv.getDifficultyLevelStr() );
        holder.text_FitTveTime.setText( getFitTv.getDuration()+"min" );
        holder.text_category.setText( getFitTv.getCategory() );
        holder.text_trainer.setText( getFitTv.getTrainer() );
    }

    @Override
    public int getItemCount() {
        return datum_.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_fitTv;
        TextView text_fitTvtitle,text_titleBig,text_FitTveTime,text_category,text_trainer;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            img_fitTv = itemView.findViewById( R.id.img_fitTv );
            text_titleBig = itemView.findViewById( R.id.text_titleBig );
            text_FitTveTime = itemView.findViewById( R.id.text_FitTveTime );
            text_trainer = itemView.findViewById( R.id.text_trainer );
            text_fitTvtitle = itemView.findViewById( R.id.text_fitTvtitle );
            text_category = itemView.findViewById( R.id.text_category );

        }
    }
}

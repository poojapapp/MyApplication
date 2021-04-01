package com.fitternity.myapplication.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.fitternity.myapplication.R;
import com.fitternity.myapplication.model.workoutInStudio.ProductTag;
import com.fitternity.myapplication.sharedpreferences.SharedPreferencesManager;

import java.text.DecimalFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>
{
    List<ProductTag> productTags;
    private Context mContext;
    private SharedPreferencesManager sharedPreferencesManager;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ProductTag getProductTag;
    public ProductListAdapter(List<ProductTag> productTags, Context mContext) {
        this.productTags = productTags;
        this.mContext = mContext;
        sharedPreferencesManager= new SharedPreferencesManager();
    }
    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate( R.layout.product_list_studio, parent, false);
        ProductListAdapter.ViewHolder viewHolder = new ProductListAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
        getProductTag =productTags.get(position);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        Glide.with(mContext).setDefaultRequestOptions(requestOptions)
                .load(getProductTag.getImage())
                .thumbnail(0.5f)
                .skipMemoryCache( false )
                .centerCrop()
                .diskCacheStrategy( DiskCacheStrategy.ALL)
                .apply(new RequestOptions().override(50,50))
                .into(holder.circular_onepass);
        if(getProductTag.getTitle()==null && getProductTag.getText()==null){
            holder.text_title.setText( "" );
            holder.text_description.setText( "" );
        }else{
            holder.text_title.setText(""+getProductTag.getTitle());
            holder.text_description.setText(""+getProductTag.getText());
        }
    }

    @Override
    public int getItemCount() {
        return productTags.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView  circular_onepass;
        TextView text_title,text_description;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            circular_onepass = itemView.findViewById( R.id.circular_onepass );
            text_title = itemView.findViewById( R.id.text_title );
            text_description = itemView.findViewById( R.id.text_description );
        }
    }
}

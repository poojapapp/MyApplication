package com.fitternity.myapplication.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fitternity.myapplication.R;
import com.fitternity.myapplication.adapter.ProductListAdapter;
import com.fitternity.myapplication.adapter.ViewPagerAdapter;
import com.fitternity.myapplication.fragment.WorkInStudioFragment;
import com.fitternity.myapplication.fragment.WorkOutHomeFragement;
import com.fitternity.myapplication.interfaces.InterfaceConstants;
import com.fitternity.myapplication.model.workoutInStudio.HomeScreenAtStudioResponse;
import com.fitternity.myapplication.model.workoutInStudio.ProductTag;
import com.fitternity.myapplication.retrofit.RetroClientInstance;
import com.fitternity.myapplication.retrofit.RetrofitCallback;
import com.fitternity.myapplication.retrofit.apiInterfaces.ApiInterface;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeNavigationActivity extends BaseActivity {
   Spinner spinner_location;
   RecyclerView recyclerview_productlist;
   private ProductListAdapter productListAdapter;
   ImageView img_search,img_discount,img_qrcode;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.qrcode,
            R.drawable.qrcode
    };
    List<ProductTag> productTags;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home_navigation );
        setUpREcyclerviewProductList();
        init();
    }

    private void setUpREcyclerviewProductList() {
        recyclerview_productlist = (RecyclerView) findViewById( R.id.recyclerview_productlist );
        productTags = new ArrayList<>();
        productListAdapter= new ProductListAdapter(productTags,mContext);
        recyclerview_productlist.setAdapter(productListAdapter);
        recyclerview_productlist.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recyclerview_productlist.setLayoutManager(layoutManager);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void init(){
        spinner_location = (Spinner) findViewById( R.id.spinner_location );
        img_search = (ImageView) findViewById( R.id.img_search );
        img_discount = (ImageView) findViewById( R.id.img_discount );
        img_qrcode = (ImageView) findViewById( R.id.img_qrcode );
        tabLayout = (TabLayout) findViewById( R.id.tablayout );
        tabLayout.setupWithViewPager(viewPager);
       // setupTabIcons();
        viewPager = (ViewPager) findViewById( R.id.viewpager);
        createViewPager(viewPager);
        getStudioData();
    }
    @SuppressLint("NewApi")
    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new WorkInStudioFragment(), "Workout In-Studio");
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorYellow, null));
        adapter.addFrag(new WorkOutHomeFragement(), "Workout At Home");
        viewPager.setAdapter(adapter);
    }
   @SuppressLint("LongLogTag")
   public void getStudioData() {
       ApiInterface apiInterface = RetroClientInstance.getRetrofitInstance(mContext).create(ApiInterface.class);
       Call<HomeScreenAtStudioResponse> getUserInformationResponseCall = apiInterface.getStudioData();
       getUserInformationResponseCall.enqueue( new RetrofitCallback<HomeScreenAtStudioResponse>(mActivity,true) {
           @Override
           public void onSuccess(HomeScreenAtStudioResponse response) {
               Log.i("Location",response.getCityName());
               ArrayAdapter<String> adapter;
               adapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_list_item_1, Collections.singletonList( response.getCityName() ) );
               spinner_location.setAdapter(adapter);
               productTags.addAll(0,response.getProductTags());
               productListAdapter.notifyDataSetChanged();
               productListAdapter.notifyItemRangeInserted( 0, productTags.size() );
               recyclerview_productlist.scrollToPosition( 0 );
           }
       });
    }

}
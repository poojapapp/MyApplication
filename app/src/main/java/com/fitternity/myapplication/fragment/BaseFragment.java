package com.fitternity.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fitternity.myapplication.sharedpreferences.SharedPreferencesManager;


public  class BaseFragment extends Fragment {
    protected Activity mActivity;
    protected Context mContext;
    protected SharedPreferencesManager sharedPreferencesManager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
        mContext=getContext();
        sharedPreferencesManager=new SharedPreferencesManager();

    }

    /**
     * Method to Show Toast massage
     * @author  Gaurav Sapar
     * @param context Pass current context
     * @param message Pass toast massage
     * @since
     */
    protected void showToast(Context context, String message) {
        Toast.makeText(context, message,
                Toast.LENGTH_LONG).show();
    }

}

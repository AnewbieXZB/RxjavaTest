package com.retrofit2test.rxjavates.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.retrofit2test.rxjavates.R;

/**
 * Created by Administrator on 2017/2/20.
 */
public class FindFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.findfragment_layout, null, false);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FindFragment","pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("FindFragment","onstop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("FindFragment","onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FindFragment","onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FindFragment","onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FindFragment","onDestroyView");
    }
}

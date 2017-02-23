package com.retrofit2test.rxjavates.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.retrofit2test.rxjavates.Fragments.Rxbus.Rxbus;
import com.retrofit2test.rxjavates.R;

/**
 * Created by Administrator on 2017/2/20.
 */
public class MeFragment extends Fragment{
    public MeFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mefragment_layout, null, false);
        TextView textView = (TextView) view.findViewById(R.id.stringtest);

        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("MeFragment","pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MeFragment","onstop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("MeFragment","onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MeFragment","onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MeFragment","onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MeFragment","onDestroyView");
    }
}

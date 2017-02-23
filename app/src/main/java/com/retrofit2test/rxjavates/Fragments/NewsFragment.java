package com.retrofit2test.rxjavates.Fragments;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.retrofit2test.rxjavates.Fragments.Rxbus.Events;
import com.retrofit2test.rxjavates.Fragments.Rxbus.Rxbus;
import com.retrofit2test.rxjavates.R;

/**
 * Created by Administrator on 2017/2/20.
 */
public class NewsFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newsfragment_layout, null, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {


                            while(true){
                                SystemClock.sleep(1000);
                                Rxbus.getInstance().send(Events.TAP,"傻逼");
                            }

                    }
                }.start();

            }
        });
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("NewsFragment","pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("NewsFragment","onstop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("NewsFragment","onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("NewsFragment","onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("NewsFragment","onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("NewsFragment","onDestroyView");
    }
    public void test(){

    }
}

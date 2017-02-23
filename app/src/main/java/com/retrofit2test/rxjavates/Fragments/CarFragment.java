package com.retrofit2test.rxjavates.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.retrofit2test.rxjavates.Fragments.Rxbus.Events;
import com.retrofit2test.rxjavates.Fragments.Rxbus.Rxbus;
import com.retrofit2test.rxjavates.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import rx.functions.Action1;


/**
 * Created by Administrator on 2017/2/20.
 */
public class CarFragment extends RxFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CarFragment","onCreate");
    }
    //缓存Fragment View
    private View rootView;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("CarFragment","onCreateView");

        if (rootView == null)
        {
            rootView = inflater.inflate(R.layout.carfragment_layout, null);
            ListView listview = (ListView) rootView.findViewById(R.id.listview);
            textView = (TextView) rootView.findViewById(R.id.text);
            listview.setAdapter(new MyListViewAdapter());
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null)
        {
            parent.removeView(rootView);
        }
        iniRxBus();
        return rootView;

    }
    int i = 0;
    private void iniRxBus() {
        Rxbus.with(this).setEvent(Events.TAP)
                .onNext(new Action1<Events<?>>() {
                    @Override
                    public void call(Events<?> events) {
                        Log.d("Busssss","走这里了");
                        String content = events.getContent();
                        textView.setText(content+(i++));
                    }
                }).create();
    }

    class MyListViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(CarFragment.this.getActivity());

            textView.setText("我是测试i"+i);
            return textView;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("CarFragment","pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("CarFragment","onstop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("CarFragment","onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CarFragment","onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("CarFragment","onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("CarFragment","onDestroyView");
    }
}

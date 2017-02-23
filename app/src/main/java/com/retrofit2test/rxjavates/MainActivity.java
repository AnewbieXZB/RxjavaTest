package com.retrofit2test.rxjavates;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.retrofit2test.rxjavates.Fragments.CarFragment;
import com.retrofit2test.rxjavates.Fragments.FindFragment;
import com.retrofit2test.rxjavates.Fragments.MeFragment;
import com.retrofit2test.rxjavates.Fragments.NewsFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    LinearLayout news_lin;
    LinearLayout me_lin;
    LinearLayout car_lin;
    LinearLayout find_lin;

    private FragmentTabHost mTabHost;
    private RadioGroup mTabRg;
    private final Class[] fragments = {NewsFragment.class, FindFragment.class,CarFragment.class,  MeFragment.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmenttabhost_test);
        iniView();
//        getViewInstance();

    }
    //fragmentTabhostTest
    private void iniView(){
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        //得到Fragment的个数
        int count = fragments.length;
        for (int i = 0;i<count;i++){
            //为每一个Tab按钮设置图标，文字，内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(i+"").setIndicator(i+"");
            mTabHost.addTab(tabSpec,fragments[i],null);
        }
        mTabRg = (RadioGroup) findViewById(R.id.tab_rg_menu);
        mTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                        case R.id.tab_rb_1:
                            mTabHost.setCurrentTab(0);
                        break;
                    case R.id.tab_rb_2:
                        mTabHost.setCurrentTab(1);
                    break;
                    case R.id.tab_rb_3:
                        mTabHost.setCurrentTab(2);
                    break;
                    case R.id.tab_rb_4:
                        mTabHost.setCurrentTab(3);
                    break;
                }
            }
        });
        mTabHost.setCurrentTab(0);
    }
    //获取控件实例
    public void getViewInstance(){
        news_lin = (LinearLayout) findViewById(R.id.news);
        me_lin = (LinearLayout) findViewById(R.id.me);
        car_lin = (LinearLayout) findViewById(R.id.car);
        find_lin = (LinearLayout) findViewById(R.id.faxian);
    }
    //底部按钮点击事件
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.news:
                news_lin.setSelected(true);
            break;
            case R.id.faxian:
                find_lin.setSelected(true);
                break;
            case R.id.car:
                car_lin.setSelected(true);
                break;
            case R.id.me:
                me_lin.setSelected(true);
                break;

        }


    }
}

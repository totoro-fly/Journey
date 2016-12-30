package com.totoro_fly.journey;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BeijingFragment.OnFragmentInteractionListener,ChongqingFragment.OnFragmentInteractionListener,ShanghaiFragment.OnFragmentInteractionListener,TianjinFragment.OnFragmentInteractionListener{

    @Bind(R.id.title_tablayout)
    TabLayout titleTablayout;
    @Bind(R.id.content_viewpager)
    ViewPager contentViewpager;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CityFragmentAdapter cityFragmentAdapter = new CityFragmentAdapter(getSupportFragmentManager(), this);
        contentViewpager.setAdapter(cityFragmentAdapter);
        titleTablayout.setupWithViewPager(contentViewpager);
        titleTablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}

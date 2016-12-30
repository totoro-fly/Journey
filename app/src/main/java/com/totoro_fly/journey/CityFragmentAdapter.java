package com.totoro_fly.journey;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by totoro-fly on 2016/12/29.
 */

public class CityFragmentAdapter extends FragmentPagerAdapter {
    Context mContext;

    public CityFragmentAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.beijing);
            case 1:
                return mContext.getString(R.string.tianjin);
            case 2:
                return mContext.getString(R.string.shanghai);
            case 3:
                return mContext.getString(R.string.chongqing);
        }
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BeijingFragment();
            case 1:
                return new TianjinFragment();
            case 2:
                return new ShanghaiFragment();
            case 3:
                return new ChongqingFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

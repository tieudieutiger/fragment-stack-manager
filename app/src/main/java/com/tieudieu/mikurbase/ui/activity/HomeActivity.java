package com.tieudieu.mikurbase.ui.activity;

import android.support.v4.app.Fragment;

import com.tieudieu.mikurbase.ui.fragment.HomeFragment;
import com.tieudieu.util.DebugLog;

public class HomeActivity extends BaseToolbarNavigationActivity {

    @Override
    protected Class<?> getHomeClass() {
        return null;
    }

    @Override
    public void onMainScreenRequested() {
        getFragmentStackManager().clearStackAll();
        getFragmentStackManager().swapFragment(HomeFragment.newInstance("Home"));
    }

    @Override
    public void onFragmentEntered(Fragment fragment) {
        DebugLog.e("xxx-onFragmentEntered-" + fragment.getClass().getSimpleName());
    }

    @Override
    public void onNewScreenRequested(int indexTag, int typeContent, Object object) {
        // swap fragment
        getFragmentStackManager().clearStackAll();
        getFragmentStackManager().swapFragment(HomeFragment.newInstance("abddf"));
    }

    @Override
    public void onNewScreenRequested(int indexTag, String typeContent, Object object) {
    }

}

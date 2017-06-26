package com.tieudieu.fragmentstackmanagerthreadqueue;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by chienchieu on 28/01/2016.
 */
public abstract class BaseActivityFragmentStack extends BaseActivity implements ScreenManager {

    private FragmentStackManager mFragmentStackManager;
    @Override
    protected void initVariables() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        initializeFragmentSwapper(savedInstanceState);
    }

    protected abstract int getContentFrameId();
    protected abstract Class<?> getHomeClass();

    private void initializeFragmentSwapper(Bundle savedInstanceState) {
        InitializationParams.Builder builder = new InitializationParams.Builder();
        builder.screenManager(this);
        builder.contentFrame(getContentFrameId());
        builder.fragmentManager(getSupportFragmentManager());
        builder.enableAnimation(true);
        builder.setHomeClass(getHomeClass());

        mFragmentStackManager = new FragmentStackManager();
        mFragmentStackManager.initialize(builder.build());
        mFragmentStackManager.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        mFragmentStackManager.popFragment();
    }

    @Override
    protected void onDestroy() {
        mFragmentStackManager.destroy();
        super.onDestroy();
    }

    @Override
    public void onSwapFragmentRequested(Fragment fragment) {
        mFragmentStackManager.swapFragment(fragment);
    }

    @Override
    public void onBackFragmentRequested() {
        mFragmentStackManager.popFragment();
    }

    @Override
    public void onCloseRequested() {
        finish();
    }

    protected FragmentStackManager getFragmentStackManager(){
        if (mFragmentStackManager == null) {
            throw new IllegalArgumentException();
        }
        return mFragmentStackManager;
    }

    protected Fragment getCurrentFragment(){
        return mFragmentStackManager.getCurrentFragment();
    }
}

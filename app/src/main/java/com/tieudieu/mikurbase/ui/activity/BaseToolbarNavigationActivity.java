package com.tieudieu.mikurbase.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tieudieu.fragmentstackmanagerthreadqueue.BaseActivityFragmentStack;
import com.tieudieu.mikurbase.R;

/**
 * Created by vuvan on 20/07/2016.
 */
public abstract class BaseToolbarNavigationActivity extends BaseActivityFragmentStack implements NavigationView.OnNavigationItemSelectedListener {

    protected Toolbar mToolbar;
    protected FloatingActionButton mFab;
    protected DrawerLayout mDrawer;
    protected NavigationView mNavigationView;
    protected ActionBarDrawerToggle mToggle;

    @Override
    protected void initVariables() {
        super.initVariables();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        super.initViews(savedInstanceState);
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected int getContentFrameId() {
        return R.id.container;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            onNewScreenRequested(1, 1, null);
        } else if (id == R.id.nav_gallery) {
            onNewScreenRequested(1, 1, null);
        } else if (id == R.id.nav_slideshow) {
            onNewScreenRequested(1, 1, null);

        } else if (id == R.id.nav_manage) {
            onNewScreenRequested(1, 1, null);

        } else if (id == R.id.nav_share) {
            onNewScreenRequested(1, 1, null);

        } else if (id == R.id.nav_send) {
            onNewScreenRequested(1, 1, null);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

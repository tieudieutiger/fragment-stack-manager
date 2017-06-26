package com.tieudieu.mikurbase.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tieudieu.fragmentstackmanagerthreadqueue.BaseFragmentStack;
import com.tieudieu.mikurbase.MApplication;
import com.tieudieu.mikurbase.R;

/**
 * Created by vuvan on 20/07/2016.
 */
public class HomeFragment extends BaseFragmentStack {

    String title;
    public static HomeFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("EXTRA_TITLE", title);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MApplication.getInstance().getRetrofitService().getInitialData();

        title = getArguments().getString("EXTRA_TITLE");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        return mRootView;
    }

    public void initView() {
    }

}

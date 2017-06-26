package com.tieudieu.mikurbase;

import android.app.Application;

import com.tieudieu.mikurbase.di.components.DaggerGitHubComponent;
import com.tieudieu.mikurbase.di.components.DaggerNetComponent;
import com.tieudieu.mikurbase.di.components.GitHubComponent;
import com.tieudieu.mikurbase.di.components.NetComponent;
import com.tieudieu.mikurbase.di.modules.AppModule;
import com.tieudieu.mikurbase.di.modules.GitHubModule;
import com.tieudieu.mikurbase.di.modules.NetModule;
import com.tieudieu.mikurbase.data.network.ApiSetting;
import com.tieudieu.mikurbase.data.network.NetConstants;
import com.tieudieu.mikurbase.data.network.service.RetrofitService;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MApplication extends Application {

    private static final String TAG = MApplication.class.getSimpleName();

    private static MApplication mInstance;

    public static synchronized MApplication getInstance() {
        return mInstance;
    }

    private NetComponent mNetComponent;
    private GitHubComponent mGitHubComponent;

    @Inject
    ApiSetting mApiSetting;

    @Inject
    Retrofit mRetrofit;

    @Inject
    RetrofitService mRetrofitService;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initialize();
    }

    public void initialize() {
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(NetConstants.BASE_URL))
                .build();
        mGitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(mNetComponent)
                .gitHubModule(new GitHubModule())
                .build();
        getGitHubComponent().inject(this);
    }

    /**
     * for initialize
     */
    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public GitHubComponent getGitHubComponent() {
        return mGitHubComponent;
    }

    public RetrofitService getRetrofitService() {
        return mRetrofitService;
    }

}

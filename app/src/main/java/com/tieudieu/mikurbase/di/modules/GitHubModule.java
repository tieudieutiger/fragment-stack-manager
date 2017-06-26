package com.tieudieu.mikurbase.di.modules;

import com.tieudieu.mikurbase.di.scopes.UserScope;
import com.tieudieu.mikurbase.data.network.ApiSetting;
import com.tieudieu.mikurbase.data.network.service.ApiService;
import com.tieudieu.mikurbase.data.network.service.RetrofitService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class GitHubModule {

    @Provides
    @UserScope
    public ApiService providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @UserScope
    public RetrofitService providesRetrofitService(ApiService apiService, ApiSetting apiSetting){
        return new RetrofitService(apiService, apiSetting);
    }
}

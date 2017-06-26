package com.tieudieu.mikurbase.di.components;

import android.content.SharedPreferences;

import com.tieudieu.mikurbase.di.modules.AppModule;
import com.tieudieu.mikurbase.di.modules.NetModule;
import com.tieudieu.mikurbase.data.network.ApiSetting;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
    ApiSetting apiSetting();
}
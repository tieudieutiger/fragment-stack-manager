package com.tieudieu.mikurbase.di.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tieudieu.mikurbase.data.network.ApiSetting;
import com.tieudieu.util.DebugLog;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    String mBaseUrl;

    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    ApiSetting providesApiSetting(Application application) {
        return new ApiSetting();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides  // Dagger will only look for methods annotated with @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();

//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
//        return gson;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache, final Application application, ApiSetting apiSetting) {
//        OkHttpClient okHttpClient = new OkHttpClient();
////        okHttpClient.setCache(cache);
//        return okHttpClient;
        DebugLog.d("xxx-provideOkHttpClient-apiSetting-" + apiSetting.getSEC_PARAM());

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("Accept", "application/vnd.api.crazily.net.v1.full+json")
                                .header("User-Agent", "Mikur")
                                .header("Authorization", "")
                                .method(original.method(), original.body())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        return httpClient;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}

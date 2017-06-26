package com.tieudieu.mikurbase.data.network.service;

import com.tieudieu.mikurbase.data.network.ApiSetting;
import com.tieudieu.util.DebugLog;

import javax.inject.Inject;

public class RetrofitService {

    public ApiService mApiService;
    public ApiSetting mApiSetting;

    @Inject
    public RetrofitService(ApiService apiService, ApiSetting apiSetting) {
        mApiService = apiService;
        mApiSetting = apiSetting;
    }

    public void getInitialData() {
        DebugLog.d("xxx-getInitialData-SEC_PARAM=" + mApiSetting.getSEC_PARAM());
    }


}

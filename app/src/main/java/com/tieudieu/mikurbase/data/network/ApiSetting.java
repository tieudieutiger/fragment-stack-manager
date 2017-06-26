package com.tieudieu.mikurbase.data.network;

import javax.inject.Inject;

/**
 * Created by chienchieu on 20/03/2016.
 */
public class ApiSetting {

    private String SEC_PARAM;

    @Inject
    public ApiSetting() {
        SEC_PARAM = "abc_xyz";
    }

    public String getSEC_PARAM() {
        return SEC_PARAM;
    }

    public void setSEC_PARAM(String SEC_PARAM) {
        this.SEC_PARAM = SEC_PARAM;
    }
}

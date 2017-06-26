package com.tieudieu.mikurbase.data.network;

public interface OnResponseSuccess<R, E> {

    void onResponseSuccess(String tag, R response, E extraData);
    void onResponseError(String tag, String message);

}
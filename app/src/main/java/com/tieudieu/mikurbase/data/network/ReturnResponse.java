package com.tieudieu.mikurbase.data.network;

import retrofit2.Response;

/**
 * Created by chienchieu on 19/03/2016.
 */
public class ReturnResponse<R, E> {

    public void returnResponse(OnResponseSuccess<R, E> onResponseSuccess, String tag, Response<R> response, E extraData){
        if (onResponseSuccess != null){
            if (response.body() != null){
                onResponseSuccess.onResponseSuccess(tag, response.body(), extraData);
            } else {
                onResponseSuccess.onResponseError(tag, NetConstants.RESPONSE_NULL);
            }
        }
    }

}

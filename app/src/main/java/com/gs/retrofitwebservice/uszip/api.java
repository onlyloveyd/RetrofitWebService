package com.gs.retrofitwebservice.uszip;

import com.gs.retrofitwebservice.uszip.request.UsCityRequestEnvelope;
import com.gs.retrofitwebservice.uszip.response.UsCityResponseEnvelope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 文 件 名: api
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:24
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
public interface api {
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("uszip.asmx")
    Call<UsCityResponseEnvelope> getInfoByCity(@Body UsCityRequestEnvelope requestEnvelope);
}

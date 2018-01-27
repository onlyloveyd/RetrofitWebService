package com.gs.retrofitwebservice.mobielcode;

import com.gs.retrofitwebservice.mobielcode.request.MobileCodeRequestEnvelope;
import com.gs.retrofitwebservice.mobielcode.response.MobileCodeResponseEnvelope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 文 件 名: mobileCodeApi
 * 创 建 人: 易冬
 * 创建日期: 2018/1/24 10:01
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
public interface mobileCodeApi {
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("MobileCodeWS.asmx")
    Call<MobileCodeResponseEnvelope> getMobileCodeInfo(
            @Body MobileCodeRequestEnvelope requestEnvelope);
}

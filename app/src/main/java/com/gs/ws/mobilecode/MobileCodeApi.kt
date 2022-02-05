package com.gs.ws.mobilecode

import com.gs.ws.mobilecode.request.MobileCodeRequestEnvelope
import com.gs.ws.mobilecode.response.MobileCodeResponseEnvelope
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface MobileCodeApi {

    @Headers("Content-Type: text/xml; charset=utf-8")
    @GET("MobileCodeWS.asmx/getMobileCodeInfo")
    suspend fun mobileCodeInfoByHttpGet(
        @Query("mobileCode") mobileCode: String,
        @Query("userID") userId: String = ""
    ): ResponseBody

    @POST("MobileCodeWS.asmx/getMobileCodeInfo")
    @FormUrlEncoded
    suspend fun mobileCodeInfoByHttpPost(
        @Field("mobileCode") mobileCode: String,
        @Field("userID") userId: String = ""
    ): ResponseBody


    @Headers(
        "Content-Type: text/xml;charset=utf-8"
    )
    @POST("MobileCodeWS.asmx")
    suspend fun mobileCodeInfoBySoap11(
        @Body requestEnvelope: MobileCodeRequestEnvelope?
    ): MobileCodeResponseEnvelope

    @Headers("Content-Type: application/soap+xml;charset=utf-8")
    @POST("MobileCodeWS.asmx")
    suspend fun mobileCodeInfoBySoap12(
        @Body requestEnvelope: RequestBody
    ): ResponseBody
}
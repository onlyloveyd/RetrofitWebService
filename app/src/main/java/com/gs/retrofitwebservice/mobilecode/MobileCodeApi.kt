package com.gs.retrofitwebservice.mobilecode

import com.gs.retrofitwebservice.mobilecode.request.MobileCodeRequestEnvelope
import com.gs.retrofitwebservice.mobilecode.response.MobileCodeResponseEnvelope
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MobileCodeApi {
    @POST("MobileCodeWS.asmx")
    fun getMobileCodeInfo(
        @Body requestEnvelope: MobileCodeRequestEnvelope?
    ): Call<MobileCodeResponseEnvelope>
}
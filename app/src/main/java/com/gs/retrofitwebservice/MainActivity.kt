package com.gs.retrofitwebservice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gs.retrofitwebservice.databinding.ActivityMainBinding
import com.gs.retrofitwebservice.mobilecode.request.MobileCodeRequestBody
import com.gs.retrofitwebservice.mobilecode.request.MobileCodeRequestData
import com.gs.retrofitwebservice.mobilecode.request.MobileCodeRequestEnvelope
import com.gs.retrofitwebservice.mobilecode.response.MobileCodeResponseEnvelope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun sendRequest(view: View?) {
        val apiService = Retrofitance.mobileCodeApi
        val requestEnvelope = MobileCodeRequestEnvelope()
        val requestBody = MobileCodeRequestBody()
        val requestData = MobileCodeRequestData()
        requestData.mobileCode = "18507152743"
        requestBody.mobileCodeRequestData = requestData
        requestEnvelope.body = requestBody
        val call = apiService.getMobileCodeInfo(requestEnvelope)
        call.enqueue(object : Callback<MobileCodeResponseEnvelope?> {
            override fun onResponse(
                call: Call<MobileCodeResponseEnvelope?>,
                response: Response<MobileCodeResponseEnvelope?>
            ) {
                val mobileCodeResponseEnvelope = response.body()
                if (mobileCodeResponseEnvelope != null) {
                    Toast.makeText(this@MainActivity, "请求成功", Toast.LENGTH_SHORT).show()
                    val result = mobileCodeResponseEnvelope.mobildCodeResponseBody
                        ?.mobileCodeResponseInfo?.mobileCodeResult
                    mBinding!!.tvMobileResult.text = result
                }
            }

            override fun onFailure(call: Call<MobileCodeResponseEnvelope?>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@MainActivity, "请求失败", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
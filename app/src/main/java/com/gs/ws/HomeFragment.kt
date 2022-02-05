package com.gs.ws

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gs.ws.databinding.FragmentHomeBinding
import com.gs.ws.mobilecode.request.MobileCodeRequestBody
import com.gs.ws.mobilecode.request.MobileCodeRequestData
import com.gs.ws.mobilecode.request.MobileCodeRequestEnvelope
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody


/**
 * Description
 * author: yidong
 * 2022-02-04
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.handler = this
    }

    fun doHttpGet() {
        lifecycleScope.launchWhenCreated {
            val response =
                Retrofitance.mobileCodeApi.mobileCodeInfoByHttpGet(binding.etMobile.text.toString())
            Toast.makeText(context, "请求成功", Toast.LENGTH_SHORT).show()
            val result = response.string()
            binding.tvMobileResult.text = result
        }
    }

    fun doHttpPost() {
        lifecycleScope.launchWhenCreated {
            val response =
                Retrofitance.mobileCodeApi.mobileCodeInfoByHttpPost(binding.etMobile.text.toString())
            Toast.makeText(context, "请求成功", Toast.LENGTH_SHORT).show()
            val result = response.string()
            binding.tvMobileResult.text = result
        }
    }

    fun doSoap11() {
        val apiService = Retrofitance.mobileCodeApi
        val requestEnvelope = MobileCodeRequestEnvelope()
        val requestBody = MobileCodeRequestBody()
        val requestData = MobileCodeRequestData()
        requestData.mobileCode = binding.etMobile.text.toString()
        requestBody.mobileCodeRequestData = requestData
        requestEnvelope.body = requestBody
        lifecycleScope.launchWhenCreated {
            val mobileCodeResponseEnvelope = apiService.mobileCodeInfoBySoap11(requestEnvelope)
            Toast.makeText(context, "请求成功", Toast.LENGTH_SHORT).show()
            val result = mobileCodeResponseEnvelope.body?.response?.mobileCodeInfoResult
            binding.tvMobileResult.text = result
        }
    }

    fun doSoap12() {
        val xml = """
            <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://WebXml.com.cn/">
               <soap:Header/>
               <soap:Body>
                  <web:getMobileCodeInfo>
                     <web:mobileCode>${binding.etMobile.text}</web:mobileCode>
                     <web:userID></web:userID>
                  </web:getMobileCodeInfo>
               </soap:Body>
            </soap:Envelope>
        """.trimIndent()
        lifecycleScope.launchWhenCreated {
            val result =
                Retrofitance.mobileCodeApi.mobileCodeInfoBySoap12(xml.toRequestBody("text/xml".toMediaTypeOrNull()))
            Toast.makeText(context, "请求成功", Toast.LENGTH_SHORT).show()
            binding.tvMobileResult.text = result.string()
        }
    }
}


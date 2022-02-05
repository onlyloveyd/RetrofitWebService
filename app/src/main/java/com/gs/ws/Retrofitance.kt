package com.gs.ws

import com.gs.ws.mobilecode.MobileCodeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.strategy.Strategy
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


object Retrofitance {
    private const val BASE_URL = "http://ws.webxml.com.cn/WebServices/"
    private val strategy: Strategy = AnnotationStrategy()
    private val serializer: Serializer = Persister(strategy)

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofitance = Retrofit.Builder()
        .client(client)
        .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
        .baseUrl(BASE_URL)
        .build()

    val mobileCodeApi: MobileCodeApi = retrofitance.create(MobileCodeApi::class.java)
}
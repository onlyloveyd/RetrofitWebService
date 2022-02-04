package com.gs.retrofitwebservice

import com.gs.retrofitwebservice.mobilecode.MobileCodeApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
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
        .addInterceptor(HttpLoggingInterceptor())
        .addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .header("Content-Type", "text/xml;charset=UTF-8")
                .header("Accept-Charset", "utf-8")
                .method(original.method, original.body)
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        })
        .build()


    private val retrofitance = Retrofit.Builder()
        .client(client)
        .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
        .baseUrl(BASE_URL)
        .build()

    val mobileCodeApi = retrofitance.create(MobileCodeApi::class.java)
}
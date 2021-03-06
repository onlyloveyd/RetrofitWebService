package com.gs.retrofitwebservice;


import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * 文 件 名: Retrofitance
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:20
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 * @author Mraz
 */
public class Retrofitance {
    private static Strategy strategy = new AnnotationStrategy();
    private static Serializer serializer = new Persister(strategy);

    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
            .baseUrl(Constant.BASE_URL);


    public static <T> T createMobileCodeService(Class<T> serviceClass) {
        okHttpClient.interceptors().add(chain -> {
            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder()
                    .header("Content-Type", "text/xml;charset=UTF-8")
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        OkHttpClient client = okHttpClient.connectTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(new HttpLoggingInterceptor())
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build();
        Retrofit retrofit = retrofitBuilder.client(client).build();
        return retrofit.create(serviceClass);
    }
}
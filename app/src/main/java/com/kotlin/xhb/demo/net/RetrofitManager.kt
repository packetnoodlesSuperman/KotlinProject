package com.kotlin.xhb.demo.net

import com.kotlin.xhb.demo.utils.AppUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit

class RetrofitManager {

    val service: ApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        getRetrofit().create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
                .build()
    }

//    /**
//     * 请求头 添加公共参数 添加在Url的键值对上
//     */
//    private fun addBasicParameterInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            val originalRequest = chain.request()
//            val request: Request
//            val modifiedUrl = originalRequest.url().newBuilder()
//                    .addQueryParameter("udid", "d2807c895f0348a180148c9dfa6f2feeac0781b5")
//                    .addQueryParameter("deviceModel", AppUtils.getDeviceModel())
//                    .build()
//            request = originalRequest.newBuilder().url(modifiedUrl).build()
//            chain.proceed(request)
//
//        }
//    }
//
//    private fun addTokenInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            val originalRequest = chain.request()
//            val requestBuilder = originalRequest.newBuilder()
//                    .header("token", "")
//                    .method(originalRequest.method(), originalRequest.body())
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }
//    }
}
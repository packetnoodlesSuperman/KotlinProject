package com.kotlin.xhb.http

import retrofit2.http.GET
import retrofit2.http.Headers
import rx.Observable

interface APIService {

    @Headers("Cache-Control: public, max-age=60 * 60 * 24 * 7")
    @GET("/course_api/banner/query?type=1")
    fun getHot(): Observable<List<String>>

}
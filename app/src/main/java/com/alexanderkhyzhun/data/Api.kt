package com.alexanderkhyzhun.data

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * @author SashaKhyzhun
 * Created on 4/26/19.
 */
interface Api {

    @GET("/test")
    fun test(): Observable<ResponseBody>

    @GET("/test")
    fun signUp(): Single<ResponseBody>

}
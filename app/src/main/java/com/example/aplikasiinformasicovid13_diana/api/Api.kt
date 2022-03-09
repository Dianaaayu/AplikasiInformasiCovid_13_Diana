package com.example.aplikasiinformasicovid13_diana.api

import com.example.aplikasiinformasicovid13_diana.model.indonesiaResponse
import com.example.aplikasiinformasicovid13_diana.model.provinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<indonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvince(): Call<ArrayList<provinceResponse>>
}
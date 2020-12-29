package com.thirkazh.portalberitakotlin.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.create

object ConfigRetrofit {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://192.168.60.211/portal_berita/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create<ConfigApi>(ConfigApi::class.java)
}
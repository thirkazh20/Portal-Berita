package com.thirkazh.portalberitakotlin.network

import android.telecom.Call
import com.thirkazh.portalberitakotlin.model.ResponseBerita
import retrofit2.http.GET
import retrofit2.http.Query

interface ConfigApi {

    @GET("lihat berita.php")
    fun getDataBerita(@Query("table") namaTable : String) : retrofit2.Call<ResponseBerita>

}
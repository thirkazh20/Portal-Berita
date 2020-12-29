package com.thirkazh.portalberitakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.thirkazh.portalberitakotlin.model.DataBeritaItem
import com.thirkazh.portalberitakotlin.model.ResponseBerita
import com.thirkazh.portalberitakotlin.network.ConfigRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConfigRetrofit.service.getDataBerita("tb_berita").enqueue(object : Callback<ResponseBerita> {
            override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
//                Log.d(MainActivity::class.java.simpleName, t.localizedMessage)

            }

            override fun onResponse(call: Call<ResponseBerita>, response: Response<ResponseBerita>) {
                if (response.isSuccessful){

                    val json = response.body()
                    val status = json?.status
//                    Log.d(MainActivity::class.java.simpleName, status.toString())
                    val dataBerita = json?.dataBerita

                    val beritaAdapter = BeritaAdapter(dataBerita,this@MainActivity)

                    rv_berita.apply {

                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = beritaAdapter
                    }
                }
            }
        })
    }
}

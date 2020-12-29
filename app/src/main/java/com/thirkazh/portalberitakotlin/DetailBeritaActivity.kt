package com.thirkazh.portalberitakotlin

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.thirkazh.portalberitakotlin.model.DataBeritaItem
import kotlinx.android.synthetic.main.activity_detail_berita.*
import kotlinx.android.synthetic.main.content_detail_berita.*

class DetailBeritaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val dataBerita = intent.getParcelableExtra<DataBeritaItem>("Berita")

        tv_isi_berita.text = dataBerita?.isiBerita
        tv_penulis_berita.text = dataBerita?.penulisBerita
        supportActionBar?.title = dataBerita?.judulBerita

        val urlImage = "http://192.168.60.211/portal_berita/image"
        val jsonImage = dataBerita?.imageBerita
        Glide.with(this)
            .load(urlImage+jsonImage)
            .error(R.drawable.ic_launcher_background)
            .into(img_detail_berita)

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

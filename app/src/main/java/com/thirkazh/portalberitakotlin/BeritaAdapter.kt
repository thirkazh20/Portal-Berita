package com.thirkazh.portalberitakotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thirkazh.portalberitakotlin.model.DataBeritaItem
import kotlinx.android.synthetic.main.item_row_berita.view.*

class BeritaAdapter(val dataBerita : List<DataBeritaItem?>?, val context: Context) : RecyclerView.Adapter<BeritaAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.item_image
        val judul = view.item_tv_judul
        val penulis = view.item_tv_penulis

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.MyViewHolder {
        val view = LayoutInflater.from(context). inflate(R.layout.item_row_berita, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataBerita != null){
            return dataBerita.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: BeritaAdapter.MyViewHolder, position: Int) {
        holder.judul.text = dataBerita?.get(position)?.judulBerita
        holder.penulis.text = dataBerita?.get(position)?.penulisBerita

        val urlImage = "http://192.168.60.211/portal_berita/image"
        val jsonImage = dataBerita?.get(position)?.imageBerita

        Glide.with(context)
            .load(urlImage+jsonImage)
            .error(R.drawable.ic_launcher_background)
            .into(holder.image)

        holder.itemView.setOnClickListener {

            val intent = Intent(context, DetailBeritaActivity::class.java)
            intent.putExtra("Berita", dataBerita?.get(position))
            context.startActivity(intent)

        }
    }
}
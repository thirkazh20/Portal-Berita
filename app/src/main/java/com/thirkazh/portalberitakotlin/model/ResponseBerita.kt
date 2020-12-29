package com.thirkazh.portalberitakotlin.model

import com.google.gson.annotations.SerializedName

data class ResponseBerita(

	@field:SerializedName("data_berita")
	val dataBerita: List<DataBeritaItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)
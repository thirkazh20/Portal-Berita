package com.thirkazh.portalberitakotlin.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DataBeritaItem(

	@field:SerializedName("penulis_berita")
	val penulisBerita: String? = null,

	@field:SerializedName("image_berita")
	val imageBerita: String? = null,

	@field:SerializedName("id_berita")
	val idBerita: String? = null,

	@field:SerializedName("judul_berita")
	val judulBerita: String? = null,

	@field:SerializedName("isi_berita")
	val isiBerita: String? = null
) : Parcelable {
	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<DataBeritaItem> =
			object : Parcelable.Creator<DataBeritaItem> {
				override fun createFromParcel(source: Parcel): DataBeritaItem =
					DataBeritaItem(source)

				override fun newArray(size: Int): Array<DataBeritaItem?> = arrayOfNulls(size)
			}
	}

	constructor(source: Parcel): this(
	source.readString(),
	source.readString(),
	source.readString(),
	source.readString(),
	source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(penulisBerita)
		writeString(imageBerita)
		writeString(idBerita)
		writeString(judulBerita)
		writeString(isiBerita)
	}
}
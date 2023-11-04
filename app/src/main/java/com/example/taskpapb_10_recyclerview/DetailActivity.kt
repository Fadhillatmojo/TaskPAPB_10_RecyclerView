package com.example.taskpapb_10_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.taskpapb_10_recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // mengambil data intent
        val dataIntent = intent
        val titleData = dataIntent.getStringExtra("DISASTER_NAME")
        val descData = dataIntent.getStringExtra("DISASTER_TYPE")
        val imgUrl = dataIntent.getStringExtra("DISASTER_IMAGE")
        val yearData = dataIntent.getStringExtra("DISASTER_YEAR")

        with(binding){
            Glide.with(this@DetailActivity).load(imgUrl).into(imageBahasa)
            var detaiTitle = "Detail Bahasa " + titleData
            textView.text = detaiTitle
            var titleShown = "Nama Bahasa: " + titleData
            tvJudul.text = titleShown
            var descshown = "Deskripsi singkat: " + descData
            tvDesc.text = descshown
            var yearshown = "Tahun tercipta: " + yearData
            tvTahun.text = yearshown
        }
    }
}
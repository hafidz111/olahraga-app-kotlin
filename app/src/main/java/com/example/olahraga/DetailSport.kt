@file:Suppress("DEPRECATION")

package com.example.olahraga

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Build.*
import android.os.Build.VERSION.*
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity

class DetailSport : AppCompatActivity() {

    companion object {
        const val EXTRA_SPORT = "extra_sport"
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_sport)

        supportActionBar!!.title = "Detail Olahraga"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvSportName: TextView = findViewById(R.id.tv_sport_name)
        val imgSport = findViewById<ImageView>(R.id.img_sport_photo)
        val tvSportDescription = findViewById<TextView>(R.id.tv_sport_description)
        val tvItemHistory = findViewById<TextView>(R.id.tv_item_history)
        val btnShare: Button = findViewById(R.id.btn_share)

        val dataSport = if (SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_SPORT, Sport::class.java)
        } else intent.getParcelableExtra(EXTRA_SPORT)

        if (dataSport != null) {
            dataSport.name.also { tvSportName.text = it }
            with(imgSport) { this.setImageResource(dataSport.photo) }
            dataSport.description.also { tvSportDescription.text = it }
            dataSport.history.also { tvItemHistory.text = it }

            btnShare.setOnClickListener{
                makeText(this, "Kamu membagikan " + dataSport.name, LENGTH_SHORT).show()
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                startActivity(intent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        @Suppress("DEPRECATION")
        onBackPressed()
        return true
    }
}

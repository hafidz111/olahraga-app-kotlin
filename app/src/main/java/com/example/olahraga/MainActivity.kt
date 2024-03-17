package com.example.olahraga

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.olahraga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvSports: RecyclerView
    private val list = ArrayList<Sport>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvSports = findViewById(R.id.rv_sports)
        rvSports.setHasFixedSize(true)

        list.addAll(getListSports())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                val moveIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListSports(): ArrayList<Sport> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataRule = resources.getStringArray(R.array.data_history)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSport = ArrayList<Sport>()
        for (i in dataName.indices) {
            val sport = Sport(dataName[i], dataDescription[i], dataRule[i], dataPhoto.getResourceId(i, -1))
            listSport.add(sport)
        }
        return listSport
    }

    private fun showRecyclerList() {
        rvSports.layoutManager = LinearLayoutManager(this)
        val listSportAdapter = ListSportAdapter(list)
        rvSports.adapter = listSportAdapter
    }
}
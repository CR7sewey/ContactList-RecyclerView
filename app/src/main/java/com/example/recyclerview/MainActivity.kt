package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.floor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerV = findViewById<RecyclerView>(R.id.listContacts)
        val adapter = ContactListAdapter()
        recyclerV.adapter = adapter
        recyclerV.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL // vertical is default
        }
        adapter.submitList(contacts)


        val btnG = findViewById<ImageView>(R.id.grid)
        val btnL = findViewById<ImageView>(R.id.list)
        btnG.setOnClickListener {
            recyclerV.layoutManager = GridLayoutManager(this, 2)  }
        btnL.setOnClickListener {
            recyclerV.layoutManager = LinearLayoutManager(this).apply {
                orientation = LinearLayoutManager.VERTICAL // vertical is default

            }      }

        adapter.setOnClickListener { contact ->
            val explicitIntent = Intent(this, ContactDetailsActivity::class.java)
            explicitIntent.putExtra("contact", contact.toString())
            startActivity(explicitIntent)
        }
    }


}

private fun generateNumber(): String {
    var num: String = ""
    for (i in 1..9) {
        val randNum = floor(Math.random()*(9.9-0.0) + 0.0).toString()[0]
        num += randNum
    }
    return num
}

private val contacts = listOf(
    Contact("Maria", generateNumber() , R.drawable.sample1),
    Contact("Julia", generateNumber(), R.drawable.sample2),
    Contact("Miguel", generateNumber(), R.drawable.sample3),
    Contact("Maria", generateNumber(), R.drawable.sample4),
    Contact("Marta", generateNumber(), R.drawable.sample5),
    Contact("Andreia", generateNumber(), R.drawable.sample6),
    Contact("Carlos", generateNumber(), R.drawable.sample7),
    Contact("Maria", generateNumber(), R.drawable.sample8),
    Contact("Ricardo", generateNumber(), R.drawable.sample9),
    Contact("Ricardo", generateNumber(), R.drawable.sample9),
    Contact("Andre", generateNumber(), R.drawable.sample10),
    Contact("Mario", "999 999 999", R.drawable.sample11),
    Contact("Catarina", "999 999 999", R.drawable.sample12),
    Contact("Leo", "999 999 999", R.drawable.sample13),
    Contact("Ze", "999 999 999", R.drawable.sample14),
    Contact("Diogo", "999 999 999", R.drawable.sample15),
    Contact("Beatriz", "999 999 999", R.drawable.sample16),
    )
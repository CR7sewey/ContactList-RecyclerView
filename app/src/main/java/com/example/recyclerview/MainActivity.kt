package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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



    }
}

private val contacts = listOf(
    Contact("Maria", "999 999 999", R.drawable.sample1),
    Contact("Julia", "999 999 999", R.drawable.sample2),
    Contact("Miguel", "999 999 999", R.drawable.sample3),
    Contact("Maria", "999 999 999", R.drawable.sample4),
    Contact("Marta", "999 999 999", R.drawable.sample5),
    Contact("Andreia", "999 999 999", R.drawable.sample6),
    Contact("Carlos", "999 999 999", R.drawable.sample7),
    Contact("Maria", "999 999 999", R.drawable.sample8),
    Contact("Ricardo", "999 999 999", R.drawable.sample9),
    Contact("Ricardo", "999 999 999", R.drawable.sample9),
    Contact("Andre", "999 999 999", R.drawable.sample10),
    Contact("Mario", "999 999 999", R.drawable.sample11),
    Contact("Catarina", "999 999 999", R.drawable.sample12),
    Contact("Leo", "999 999 999", R.drawable.sample13),
    Contact("Ze", "999 999 999", R.drawable.sample14),
    Contact("Diogo", "999 999 999", R.drawable.sample15),
    Contact("Beatriz", "999 999 999", R.drawable.sample16),
    )
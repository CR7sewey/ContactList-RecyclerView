package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerview.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name: String? = intent.getStringExtra("name")
        val contact: String? = intent.getStringExtra("contact")
        val icon: Int = intent.getIntExtra("icon",R.drawable.sample1)

        binding.nameContact.text = name
        binding.imageContact.setImageResource(icon)
        binding.numberContact.text = contact

        binding.share.setOnClickListener {
            val intentImplicita: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name $contact")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(intentImplicita, null)
            startActivity(shareIntent)
        }




    }
}
package com.example.taskpapb_10_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.taskpapb_10_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adaptorDisaster = DisasterAdaptor(generateDummy()){ disaster ->
            val intenttoDetailActivity = Intent(this@MainActivity, DetailActivity::class.java)
            intenttoDetailActivity.putExtra("DISASTER_NAME", disaster.nameDisaster)
            intenttoDetailActivity.putExtra("DISASTER_TYPE", disaster.typeDisaster)
            intenttoDetailActivity.putExtra("DISASTER_IMAGE", disaster.imageUrl)
            intenttoDetailActivity.putExtra("DISASTER_YEAR", disaster.yearDisaster)
            startActivity(intenttoDetailActivity)
        }
        with(binding){
            rvDisaster.apply {
                adapter = adaptorDisaster
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Python", typeDisaster = "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected", imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/800px-Python-logo-notext.svg.png", "1991"),
            Disaster(nameDisaster = "JavaScript", typeDisaster = "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS", imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/1200px-Unofficial_JavaScript_logo_2.svg.png", "1995"),
            Disaster(nameDisaster = "Java", typeDisaster = "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible", imageUrl = "https://qph.cf2.quoracdn.net/main-qimg-00b71d49ba404e5d40898613a53eca54", "1995"),
            Disaster(nameDisaster = "Ruby", typeDisaster = "Ruby is an interpreted, high-level, general-purpose programming language which supports multiple programming paradigms. ", imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Ruby_logo.svg/800px-Ruby_logo.svg.png", "1995"),
            Disaster(nameDisaster = "Golang", typeDisaster = "Go is a statically typed, compiled high-level programming language designed at Google by Robert Griesemer, Rob Pike, and Ken Thompson", imageUrl = "https://miro.medium.com/v2/resize:fit:500/1*vmFSpk9xtpxAHkH7cmt-3Q.png", "2009"),
            Disaster(nameDisaster = "PHP", typeDisaster = "PHP is a general-purpose scripting language geared towards web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1993 and released in 1995. ", imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/1200px-PHP-logo.svg.png", "1955"),
        )
    }
}
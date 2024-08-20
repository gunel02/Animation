package com.example.animationbetweenfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.animationbetweenfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()


//
//        val homeFragment = FirstFragment()
//        val searchFragment = SecondFragment()
//
//        makeCurrentFragment(homeFragment)
//
//        binding.bottomNavigation.setOnItemSelectedListener() {
//            when (it.itemId) {
//                R.id.home -> makeCurrentFragment(homeFragment)
//                R.id.search -> makeCurrentFragment(searchFragment)
//            }
//            true
//        }
//    }
//
//
//    private fun makeCurrentFragment(fragment: Fragment) =
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_container, fragment)
//            commit()
//        }
    }
    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun init() {
        val fragment = FirstFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()


    }
}
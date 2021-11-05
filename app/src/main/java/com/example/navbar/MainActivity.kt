package com.example.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val infoFragment = InfoFragment()
    private val settingFragment = SettingFragment()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Hola a todos")
        replaceFragment(dashboardFragment)

        var bottonNavigation=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottonNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.ic_dashboard->replaceFragment(dashboardFragment)
                R.id.ic_settings->replaceFragment(settingFragment)
                R.id.ic_info->replaceFragment(infoFragment)

            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()

        }
    }

}
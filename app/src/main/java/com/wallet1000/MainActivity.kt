package com.wallet1000

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.wallet1000.Fragments.MainFragment
import com.wallet1000.Fragments.ProfileFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var mainFragment: MainFragment
    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigation = findViewById<ChipNavigationBar>(R.id.menu_bar)

        mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, mainFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        bottomNavigation.setOnItemSelectedListener { id ->
            val option = when(id) {
                R.id.home -> {
                    mainFragment = MainFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, mainFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

                }
                R.id.my_profile ->{
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()


                }
                else -> { }
            }
        }
    }



}

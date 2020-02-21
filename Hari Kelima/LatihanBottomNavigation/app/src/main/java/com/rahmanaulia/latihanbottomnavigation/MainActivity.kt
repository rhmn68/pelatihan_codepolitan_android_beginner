package com.rahmanaulia.latihanbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rahmanaulia.latihanbottomnavigation.fragment.CallsFragment
import com.rahmanaulia.latihanbottomnavigation.fragment.ChatsFragment
import com.rahmanaulia.latihanbottomnavigation.fragment.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_chats -> {
                    replaceFragment(ChatsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_status -> {
                    replaceFragment(StatusFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_calls -> {
                    replaceFragment(CallsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }

        bottomNavigation.selectedItemId = R.id.action_chats
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}

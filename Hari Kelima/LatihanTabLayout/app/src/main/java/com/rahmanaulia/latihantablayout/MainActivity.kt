package com.rahmanaulia.latihantablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahmanaulia.latihantablayout.adapter.TabAdapter
import com.rahmanaulia.latihantablayout.fragment.CallsFragment
import com.rahmanaulia.latihantablayout.fragment.ChatsFragment
import com.rahmanaulia.latihantablayout.fragment.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = TabAdapter(supportFragmentManager)
        adapter.setData(ChatsFragment(), "Chats")
        adapter.setData(StatusFragment(), "Status")
        adapter.setData(CallsFragment(), "Calls")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}

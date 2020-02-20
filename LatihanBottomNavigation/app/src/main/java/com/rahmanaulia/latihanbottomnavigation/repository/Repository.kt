package com.rahmanaulia.latihanbottomnavigation.repository

import com.rahmanaulia.latihanbottomnavigation.R
import com.rahmanaulia.latihanbottomnavigation.model.Contact

object Repository {
    // Data set name
    private val names = arrayOf(
        "Aulia Rahman",
        "Ahmad Hakim",
        "Dinda",
        "Hani",
        "Bagus",
        "Lutpi",
        "Yudha",
        "Lutpi",
        "Oriza",
        "Tony",
        "Singgih",
        "Kresna",
        "Alfian",
        "Mei"
    )
    // Data set Avatar
    private val avatars = arrayOf(
        R.drawable.person1,
        R.drawable.person2,
        R.drawable.person3,
        R.drawable.person4,
        R.drawable.person5,
        R.drawable.person1,
        R.drawable.person2,
        R.drawable.person3,
        R.drawable.person4,
        R.drawable.person5,
        R.drawable.person1,
        R.drawable.person2,
        R.drawable.person3,
        R.drawable.person4
    )

    private val chats = arrayOf(
        "Okay",
        "Otw",
        "Bisa nego kak ?",
        "Besok beres yah... :)",
        "Yihaaa...",
        "Okay",
        "Otw",
        "Bisa nego kak ?",
        "Besok beres yah... :)",
        "Yihaaa...",
        "Okay",
        "Otw",
        "Bisa nego kak ?",
        "Besok beres yah... :)"
    )

    private val statuses = arrayOf(
        "15 Minutes ago",
        "Today 7:55PM",
        "Today 1:21PM",
        "30 Minutes ago",
        "15 Minutes ago",
        "Today 7:55PM",
        "Today 1:21PM",
        "30 Minutes ago",
        "15 Minutes ago",
        "Today 7:55PM",
        "Today 1:21PM",
        "30 Minutes ago",
        "15 Minutes ago",
        "Today 7:55PM"
    )

    private val calls = arrayOf(
        "15 Minutes ago",
        "Today 7:55PM",
        "Today 1:21PM",
        "30 Minutes ago",
        "15 Minutes ago",
        "Today 7:55PM",
        "Today 1:21PM",
        "30 Minutes ago",
        "15 Minutes ago",
        "Today 7:55PM",
        "Today 1:21PM",
        "30 Minutes ago",
        "15 Minutes ago",
        "Today 7:55PM"
    )

    fun getDataChats(): ArrayList<Contact>{
        val listChats = arrayListOf<Contact>()
        for (position in names.indices){
            listChats.add(Contact(
                names[position],
                chats[position],
                avatars[position]
            ))
        }
        return listChats
    }

    fun getDataStatuses(): ArrayList<Contact>{
        val listChats = arrayListOf<Contact>()
        for (position in names.indices){
            listChats.add(Contact(
                names[position],
                statuses[position],
                avatars[position]
            ))
        }
        return listChats
    }

    fun getDataCalls(): ArrayList<Contact>{
        val listChats = arrayListOf<Contact>()
        for (position in names.indices){
            listChats.add(Contact(
                names[position],
                calls[position],
                avatars[position]
            ))
        }
        return listChats
    }
}
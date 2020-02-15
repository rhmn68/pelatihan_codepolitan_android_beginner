package com.rahmanaulia.latihanrecyclerview

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
    private val avatar = arrayOf(
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

    private val phone = arrayOf(
        "+62123456789011",
        "+62123456789012",
        "+62123456789013",
        "+62123456789014",
        "+62123456789015",
        "+62123456789016",
        "+62123456789017",
        "+62123456789018",
        "+62123456789019",
        "+62123456789020",
        "+62123456789021",
        "+62123456789022",
        "+62123456789023",
        "+62123456789024"
    )

    fun getDataContacts(): ArrayList<Contact> {
        val list = arrayListOf<Contact>()
        for (position in names.indices){
            list.add(Contact(names[position], avatar[position], phone[position]))
        }
        return list
    }
}
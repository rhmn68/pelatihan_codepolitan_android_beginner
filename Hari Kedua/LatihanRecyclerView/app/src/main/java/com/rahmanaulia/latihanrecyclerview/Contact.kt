package com.rahmanaulia.latihanrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var name: String? = null,
    var image: Int? = null,
    var phone: String? = null
): Parcelable
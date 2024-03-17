package com.example.olahraga

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sport(
    val name: String,
    val description: String,
    val history: String,
    val photo: Int
) : Parcelable

package com.example.clicker
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Cookie(
    val name: String,
    val imageId: Int,
    val backId: Int
) : Parcelable

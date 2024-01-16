package com.aashish.gardeningjournalapp

import android.graphics.drawable.Drawable

class Utils {

    companion object{
        fun mapIdToImageName(id: Int): Int{
            return when (id % 7){
                0 -> R.drawable.a
                1 -> R.drawable.b
                2 -> R.drawable.c
                3 -> R.drawable.d
                4 -> R.drawable.e
                5 -> R.drawable.f
                6 -> R.drawable.g
                else -> R.drawable.a
            }
        }
    }
}
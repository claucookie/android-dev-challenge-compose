package com.example.androiddevchallenge.data

import androidx.annotation.IdRes
import com.example.androiddevchallenge.R

class PuppiesDatasource {

    fun getPuppies() = listOf(
        Puppy(name = "Charly", R.drawable.charly),
        Puppy(name = "Nana", R.drawable.nana),
        Puppy(name = "Simba", R.drawable.simba),
        Puppy(name = "Rocky", R.drawable.rocky),
        Puppy(name = "Snoopy", R.drawable.snoopy),
    )
}


class Puppy(val name: String, @IdRes val resId: Int)
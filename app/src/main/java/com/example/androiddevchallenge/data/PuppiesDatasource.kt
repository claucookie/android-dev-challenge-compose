package com.example.androiddevchallenge.data

import android.os.Parcelable
import androidx.annotation.IdRes
import com.example.androiddevchallenge.R
import kotlinx.parcelize.Parcelize

class PuppiesDatasource {

    fun getPuppies() = listOf(
        Puppy(name = "Charly", R.drawable.charly),
        Puppy(name = "Nana", R.drawable.nana),
        Puppy(name = "Simba", R.drawable.simba),
        Puppy(name = "Rocky", R.drawable.rocky),
        Puppy(name = "Snoopy", R.drawable.snoopy),
    )
}

@Parcelize
class Puppy(val name: String, @IdRes val resId: Int) : Parcelable
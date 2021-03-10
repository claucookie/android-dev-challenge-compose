/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

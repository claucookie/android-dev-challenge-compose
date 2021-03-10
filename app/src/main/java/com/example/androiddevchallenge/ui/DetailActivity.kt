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
package com.example.androiddevchallenge.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppy = intent.getParcelableExtra<Puppy>("puppy") ?: throw IllegalArgumentException("Did you forget to pass the puppy?")
        setContent {
            MyTheme {
                Column {
                    AppBar(puppy = puppy) { this@DetailActivity.finish() }
                    PuppyCard(puppy = puppy)
                }
            }
        }
    }

    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreview() {
        MyTheme(darkTheme = true) {
            val puppy = Puppy("name", android.R.drawable.ic_menu_always_landscape_portrait)
            Column {
                AppBar(puppy = puppy) { this@DetailActivity.finish() }
                PuppyCard(puppy = puppy)
            }
        }
    }
}

@Composable
fun AppBar(puppy: Puppy, onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = puppy.name) },
        navigationIcon = {
            IconButton(
                onClick = { onBackClick() },
                content = {
                    Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = null)
                }
            )
        }
    )
}

@Composable
fun PuppyCard(puppy: Puppy) {
    Box(modifier = Modifier.padding(16.dp)) {
        Card {
            Column {
                Image(
                    painter = painterResource(id = puppy.resId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
                Text("This is ${puppy.name}!")
            }
        }
    }
}

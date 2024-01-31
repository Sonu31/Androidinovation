package com.example.androidinovation.jetpack.allActivity

import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidinovation.R
import com.example.androidinovation.jetpack.ui.theme.AndoridJerpackTheme
import com.example.androidinovation.jetpack.ui.theme.ButtonGreen
import com.example.androidinovation.jetpack.ui.theme.DarkerButtonGreen
import com.example.androidinovation.jetpack.ui.theme.DeepBlue
import com.example.androidinovation.jetpack.ui.theme.TextWhite

class ApnaCompleteUIActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview4() {
        AndoridJerpackTheme {
            HomeScreen()
        }
    }

    @Composable
    fun HomeScreen() {
        // this is the most outer box that will
        // contain all the views,buttons,chips,etc.
        Box(
            modifier = Modifier
                .background(DeepBlue)
                .fillMaxSize()
        ) {
            Column {
                // this is how we call
                // function adding whole UI
                GreetingSection()
                ChipSection(chips = listOf("Data structures", "Algorithms", "competitive programming", "python"))
//                suggestionSection()

            }
        }
    }

    @Composable
    fun GreetingSection(
        name: String = "Geeks"
    ) {
        // here we just arrange the views
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(verticalArrangement = Arrangement.Center)
            {
                // heading text view
                Text(
                    text = "Good morning, $name",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "We wish you have a good day!",
                    style = MaterialTheme.typography.labelSmall
                )
            }

                Icon(painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
        }
    }

    // This is how we can create chip seaction at the top of app

    @Composable
    fun ChipSection(
        // function with single argument
        chips: List<String>
    ) {
        // it will not update the string
        // but save and it will helpful for us

        var selectedChipIndex by remember { mutableStateOf(0) }

        LazyRow {
            items(chips.size) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clickable {
                            selectedChipIndex = it
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            // this is basic condition for selected chip index
                            if (selectedChipIndex == it) ButtonGreen
                            else DarkerButtonGreen
                        )
                        .padding(15.dp)
                ) {
                    Text(text = chips[it], color = TextWhite)
                }
            }
        }
    }

// This function is for suggestion secation



}
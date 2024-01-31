package com.example.androidinovation.jetpack.allActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidinovation.jetpack.ui.theme.AndoridJerpackTheme
import org.w3c.dom.Text

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndoridJerpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    activityTitle("SMALL VIEW EX")

                    EditTextOrTextFileld()
                }
            }
        }
    }
}






@Composable
fun activityTitle(name: String)
{
    Column(Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$name!",
        style = TextStyle(color = Color.Red, fontSize = 25.sp, FontWeight.Bold),

        )
        }
}

@Preview
@Composable
fun DefaultPreview(){
    AndoridJerpackTheme(){
//        EditTextOrTextFileld()
        Textviewfun()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextOrTextFileld(){
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = text, onValueChange = {
            text= it
        },     textStyle = TextStyle(color = Color.Blue),// Which color are you set in text.
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters,
                autoCorrect = true,                     //Check Work Right or Worng
                keyboardType = KeyboardType.Text),       //Which type num are you inter.
            placeholder = { Text(text = "Enter you name")}, // Work hint showing
            /*  singleLine = true,   */                       // Work only Single Link
            /*  maxLines = 4*/                                // how much line show santance.
        )
        // --------------------
        TextField(value = text, onValueChange = {
            text= it
        },     textStyle = TextStyle(color = Color.Blue),// Which color are you set in text.
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters,
                autoCorrect = true,                     //Check Work Right or Worng
                keyboardType = KeyboardType.Text),       //Which type num are you inter.
            placeholder = { Text(text = "Enter you Email")}, // Work hint showing
            /*  singleLine = true,   */                       // Work only Single Link
            /*  maxLines = 4*/                                // how much line show santance.
        )
    }


}



@Composable
fun Textviewfun(){
    AndoridJerpackTheme(){
//        Text("Hello World!", color = Color(0,100,100), fontSize = 60.sp, fontStyle = FontStyle.Italic, modifier = Modifier.background( Color.White).padding(all = 30.dp)
        Text("Hello World!", color = Color(0,100,100), fontSize = 60.sp, fontStyle = FontStyle.Italic, modifier = Modifier.width(300.dp)
        )
    }
}
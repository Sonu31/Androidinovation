
package com.example.androidinovation.jetpack

import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.androidinovation.jetpack.allActivity.BNavigationActivity
import com.example.androidinovation.jetpack.allActivity.ButtonActivity
import com.example.androidinovation.jetpack.allActivity.DialogActivity
import com.example.androidinovation.jetpack.allActivity.ScrollActivity
import com.example.androidinovation.jetpack.allActivity.TextActivity
import com.example.androidinovation.jetpack.allActivity.ToolbarActivity
import com.example.androidinovation.R
import com.example.androidinovation.jetpack.allActivity.AnimatioActivity
import com.example.androidinovation.jetpack.ui.theme.AndoridJerpackTheme

class JetpackHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndoridJerpackTheme {
                // A surface container using the 'background' color from the theme
               /* Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")

                }*/

                Column(Modifier.fillMaxWidth().fillMaxHeight()) {
                    MyTextView("Home Screen" )
                    val textviewScreen = Intent(this@JetpackHomeActivity, TextActivity::class.java)
                    ViewButton("TextField , Text ",textviewScreen)
                    val buttonScreen = Intent(this@JetpackHomeActivity, ButtonActivity::class.java)
                    ViewButton(" Button, ImageView ",buttonScreen)
                    val listScreen = Intent(this@JetpackHomeActivity, ListActivity::class.java)
                    ViewButton("List,RecyclerView, Viewpager  ",listScreen )
                    val dilogScreen = Intent(this@JetpackHomeActivity, DialogActivity::class.java)
                    ViewButton("Dilog  ",dilogScreen)
                    val buttomnavigaitonScreen = Intent(this@JetpackHomeActivity, BNavigationActivity::class.java)
                    ViewButton("Drawer , Bottom navigation  ",buttomnavigaitonScreen)
                    val animationScreen = Intent(this@JetpackHomeActivity, AnimatioActivity::class.java)
                    ViewButton("Animation  ",animationScreen)
                    val scrollScreen = Intent(this@JetpackHomeActivity, ScrollActivity::class.java)
                    ViewButton("ScrollView  ",scrollScreen)
                    val toolbar = Intent(this@JetpackHomeActivity, ToolbarActivity::class.java)
                    ViewButton("Toolbar , Appbar,Progressbar  ",scrollScreen)
                }
            }
        }
    }
}


@Composable
fun MyTextView(text: String) {
    val customFontFamily = FontFamily(Font(R.font.drawerfont))
    Column(Modifier.fillMaxWidth(),Arrangement.Top,Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = TextStyle(color = Color.Red,fontSize = 30.sp, fontFamily = customFontFamily),
        )
    }
}


@Composable
fun ViewButton(data:String, activityName:Intent){
    var context:Context= LocalContext. current

    Column(modifier = Modifier.fillMaxWidth(),
  verticalArrangement = Arrangement.Top,
  horizontalAlignment = Alignment.CenterHorizontally) {
      Button(onClick = {
       context.startActivity(activityName)

      }) {


          Text(text = "${data}", fontSize = 19.sp)

      }

  }
}



package com.example.androidinovation.jetpack.allActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.androidinovation.jetpack.ui.theme.AndoridJerpackTheme

class DialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndoridJerpackTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProcessScreeen()
                    AlertDilogScreen()
                }

                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogScreeen()
//                    Greeting3("Android")
                }*/
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AndoridJerpackTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            ProcessScreeen()
            AlertDilogScreen()
        }

//        Greeting3("Android")
    }
}

@Composable
fun ProcessScreeen() {
    var isDilog by remember {
        mutableStateOf(false)
    }
/*    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    */
        Button(onClick = {
            isDilog = true
        }) {
            Text(text = "Click here show progress bar")
        }
    if (isDilog)
        Dialog(onDismissRequest = {
            isDilog = false
        }) {
            CircularProgressIndicator()
        }
}

@Composable
fun AlertDilogScreen() {
    var isDilog by remember {
        mutableStateOf(false)
    }
    Button(onClick = {
        isDilog = true
    }) {
        Text(text = "Click here show alert Dilog")
    }
    if (isDilog){
        AlertDialog(onDismissRequest = {             isDilog = false
        },
            title ={
                Text(text = "Dialog Box")
            },
            text = {
                Text(text = "This is Dialog box contents")
            },
            modifier = Modifier.fillMaxWidth(),
            confirmButton = {

                Button(onClick = {isDilog=false }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Ok")

                }

            }

            )
    }
}
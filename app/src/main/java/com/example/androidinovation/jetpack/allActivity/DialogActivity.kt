package com.example.androidinovation.jetpack.allActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    ShowDialog()
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
            ShowDialog()
        }

//        Greeting3("Android")
    }
}

@Composable
fun ShowDialog() {
    var showDialog by remember { mutableStateOf(false) }

    // Trigger dialog to be shown
    LaunchedEffect(showDialog) {
        if (showDialog) {
            // You can perform any additional actions here when the dialog is about to be shown
        }
    }

    // Display a button to trigger the dialog
    /*    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {*/
    Button(onClick = { showDialog = true }
    ,
        colors = ButtonDefaults.buttonColors(  Color.Yellow)


    ) {
        Text("Show Dialog  3",
        style = TextStyle(color = Color.Blue,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End),
            modifier = Modifier.fillMaxWidth()
//            .padding(160.dp)
        )
    }
//}

    // Actual dialog composable
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text("Dialog Title")
            },
            text = {
                Text("This is a sample message.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        // Handle positive button click
                        showDialog = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        // Handle negative button click or leave it empty to close the dialog
                        showDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
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
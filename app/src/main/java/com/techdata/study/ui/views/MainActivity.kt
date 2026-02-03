package com.techdata.study.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techdata.study.data.model.ApiResult
import com.techdata.study.ui.Home
import com.techdata.study.ui.Profile
import com.techdata.study.ui.Routes
import com.techdata.study.ui.Settings
import com.techdata.study.ui.theme.StudyTheme
import com.techdata.study.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyTextView()
                    //MyTextView()
                    ShowButton()
                }
            }
        }
    }
}

@Composable
fun UsersList(viewModel: MainViewModel= viewModel()) {
    val data by viewModel.users.collectAsStateWithLifecycle()
    LazyColumn() {
        when(data) {
            is ApiResult.Loading -> {
               /* Box() {
                    CircularProgressIndicator()
                }*/
            }
            is ApiResult.Success -> {}
            is ApiResult.Error -> {}
        }
    }
}

@Composable
fun MyTextView() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){

        composable(Routes.Home.routes) {
            Home(navController)
        }

        composable(Routes.Setting.routes) {
            Settings(navController)
        }

        composable(Routes.Profile.routes) {
            Profile(navController)
        }
    }
    //Column{
        //ShowText()
        //ShowButton()
        //MyTextField()
       // SwitchButton()
        //ListData()
    //}
}

@Composable
fun ShowText() {
    Text(
        text = "Ajsjjgjgsjdkfgsjdfgsjdfgsjdfgksdfsgdfgdfkjsgdf",
        color = Color.White,
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 2.5.sp,
            textDecoration = TextDecoration.LineThrough,
            shadow = Shadow(
                color = Color.Blue,
                offset = Offset(20f, 20f),
                blurRadius = 4f
            )
        ),
        minLines = 1,
        modifier = Modifier.padding(top = 50.dp).padding(horizontal = 40.dp)
            .clickable(true, onClick = {

            })
    )
}

@Composable
fun ShowButton() {
    val context = LocalContext.current
    Button(modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
        onClick = {
            Toast.makeText(context, "Clicked button", Toast.LENGTH_LONG).show()
        },
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        )
    ) {
            Text(text = "Click here")
    }
}

@Composable
fun MyTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.padding(horizontal = 30.dp),
        value = text,
        onValueChange = {text = it},
        label = {Text(text = "Enter your name")},
    )
    Text(text = text, modifier = Modifier.padding(horizontal = 30.dp, vertical = 30.dp))
}

@Composable
fun SwitchButton() {
    var isMarried by remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(horizontal = 30.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Marital status: ")
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isMarried,
            onCheckedChange = {isMarried = it},
        )
    }
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    StudyTheme {
        MyTextView()
    }
}
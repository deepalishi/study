package com.techdata.study.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.techdata.study.viewmodel.MainViewModel

@Composable
fun Home(navController: NavHostController, viewModel: MainViewModel= viewModel()) {
    //val list = listOf("Deepali", "Renuka", "Vishl", "Ashu","Deepali", "Renuka", "Deepali", "Renuka", "Vishl", "Ashu","Vishl", "Ashu","Deepali", "Renuka", "Vishl", "Ashu")

    val list = viewModel.users

    Column(Modifier.padding(top = 50.dp)) {
        Button(onClick = {
            navController.navigate("Settings")
        }, modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()) {
            Text(text = "AddUser", style = TextStyle(color = Color.White))
        }

       /* val users by viewModel.users.collectAsStateWithLifecycle("")
        Text(text = users, style = TextStyle(fontSize = 30.sp))

        LazyColumn(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
            itemsIndexed(list) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp), onClick = {
                            navController.navigate("Profile")
                    }) {
                    Text(text = item, modifier = Modifier.padding(10.dp))
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }*/
    }
}
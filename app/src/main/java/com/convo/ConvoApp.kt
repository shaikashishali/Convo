package com.convo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ConvoApp() {
    MaterialTheme(colorScheme = androidx.compose.material3.lightColorScheme()) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable("chat") { ChatScreen(navController) }
            composable("settings") { SettingsScreen(navController) }
            composable("favorites") { FavoritesScreen(navController) }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(topBar = { SmallTopAppBar(title = { Text("Convo") }) }) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)) {
            Text("Choose a voice:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            // simple carousel stub
            val voices = listOf("Friendly", "Cheerful", "Supportive", "Street-Slang")
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(voices) { v ->
                    Surface(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { /* select voice */ },
                        tonalElevation = 2.dp
                    ) {
                        Text(v, modifier = Modifier.padding(12.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("chat") }) { Text("Open Chat") }
        }
    }
}

@Composable
fun ChatScreen(navController: NavHostController) {
    Scaffold(topBar = { SmallTopAppBar(title = { Text("Chat") }) }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text("This is a working chat screen stub.") 
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* simulate send */ }) { Text("Send test message & get AI reply") }
        }
    }
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    Scaffold(topBar = { SmallTopAppBar(title = { Text("Settings") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(12.dp)) {
            Text("Settings stub") 
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("favorites") }) { Text("Open Favorites") }
        }
    }
}

@Composable
fun FavoritesScreen(navController: NavHostController) {
    Scaffold(topBar = { SmallTopAppBar(title = { Text("Favorites") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(12.dp)) {
            Text("Favorites stub")
        }
    }
}

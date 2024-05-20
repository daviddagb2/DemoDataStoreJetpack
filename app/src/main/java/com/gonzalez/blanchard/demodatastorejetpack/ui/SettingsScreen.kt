package com.gonzalez.blanchard.demodatastorejetpack.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gonzalez.blanchard.demodatastorejetpack.repository.UserRepository
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(userRepository: UserRepository){

    val scope = rememberCoroutineScope()
    val username by userRepository.usernameFlow.collectAsState(initial = "")
    var newUsername by remember {
        mutableStateOf(username)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        TextField(value = newUsername,
            onValueChange = { newUsername = it },
            label = {
                Text(text = "Usuario")
            }
        )

        Button(onClick = {
            scope.launch {
                userRepository.saveUsername(newUsername)
            }
        }) {
            Text(text = "Guardar")
        }
        
        Text(text = "El usuario actual es: $username")

    }

}
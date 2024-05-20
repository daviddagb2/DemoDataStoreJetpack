package com.gonzalez.blanchard.demodatastorejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gonzalez.blanchard.demodatastorejetpack.repository.UserRepository
import com.gonzalez.blanchard.demodatastorejetpack.ui.SettingsScreen
import com.gonzalez.blanchard.demodatastorejetpack.ui.theme.DemoDataStoreJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRepository = UserRepository(applicationContext)

        setContent {
            DemoDataStoreJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   SettingsScreen(userRepository = userRepository)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoDataStoreJetpackTheme {

    }
}
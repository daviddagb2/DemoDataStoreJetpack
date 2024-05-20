package com.gonzalez.blanchard.demodatastorejetpack.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.gonzalez.blanchard.demodatastorejetpack.data.USERNAME_KEY
import com.gonzalez.blanchard.demodatastorejetpack.data.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserRepository(context: Context) {
    private val dataStore = context.dataStore

    suspend fun saveUsername(username: String){
        dataStore.edit { settings ->
            settings[USERNAME_KEY] = username
        }
    }

    val usernameFlow: Flow<String> = dataStore.data.map { preferences ->
        preferences[USERNAME_KEY] ?: ""

    }

}
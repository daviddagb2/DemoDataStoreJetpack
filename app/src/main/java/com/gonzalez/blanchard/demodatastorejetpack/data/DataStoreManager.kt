package com.gonzalez.blanchard.demodatastorejetpack.data

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "settings")
val USERNAME_KEY = stringPreferencesKey("username")
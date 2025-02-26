package com.hussein.baseapp.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.dataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hussein.baseapp.data.local.datastore.encrypted.Crypto.SECRET_TOKEN
import com.hussein.baseapp.data.local.datastore.encrypted.UserPreferences
import com.hussein.baseapp.data.local.datastore.encrypted.UserPreferencesSerializer
import com.hussein.baseapp.data.local.datastore.encrypted.dataStore
import com.hussein.baseapp.data.local.datastore.local.DataStoreViewModel
import com.hussein.baseapp.data.local.datastore.local.PreferencesManager
import com.hussein.baseapp.ui.theme.BaseAppTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseAppTheme {
                val scope = rememberCoroutineScope()
                var text by remember {
                    mutableStateOf("")
                }
                val viewModel = koinViewModel<DataStoreViewModel>()
                LaunchedEffect(text) {
                    lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.getData(PreferencesManager.DATASTORE_KEY).collect { data ->
                                Log.d("DATASTORE", "Received data: $data")
                                text = data
                            }
                        }
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {

                        Button(
                            onClick = {
                                /*scope.launch {
                                    applicationContext.dataStore.updateData {
                                        UserPreferences(
                                            token = SECRET_TOKEN
                                        )
                                    }
                                }*/
                                scope.launch {
                                    viewModel.saveData(PreferencesManager.DATASTORE_KEY,"Asser Hussein")
                                    //text = dataStore.data.first().token ?: ""
                                }
                            }
                        ) {
                            Text("Save")
                        }
                       /* Button(
                            onClick = {
                                scope.launch {
                                    viewModel.saveData("Hussein")
                                    //text = dataStore.data.first().token ?: ""
                                }
                            }
                        ) {
                            Text("Decrypt")
                        }*/
                        Text(
                            text = text
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaseAppTheme {
    }
}
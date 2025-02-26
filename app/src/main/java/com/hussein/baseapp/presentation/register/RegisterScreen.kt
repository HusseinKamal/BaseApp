package com.hussein.baseapp.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen() {
    val viewModel =  koinViewModel<RegistrationViewModel>()
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = state.username,
            onValueChange = { viewModel.sendIntent(RegistrationIntent.UpdateUsername(it)) },
            label = { Text("Username") },
            isError = state.usernameError != null
        )
        state.usernameError?.let {
            Text(it, color = Color.Red, style = MaterialTheme.typography.labelSmall)
        }

        TextField(
            value = state.email,
            onValueChange = { viewModel.sendIntent(RegistrationIntent.UpdateEmail(it)) },
            label = { Text("Email") },
            isError = state.emailError != null
        )
        state.emailError?.let {
            Text(it, color = Color.Red, style = MaterialTheme.typography.labelSmall)
        }

        TextField(
            value = state.password,
            onValueChange = { viewModel.sendIntent(RegistrationIntent.UpdatePassword(it)) },
            label = { Text("Password") },
            isError = state.passwordError != null,
            visualTransformation = PasswordVisualTransformation()
        )
        state.passwordError?.let {
            Text(it, color = Color.Red, style = MaterialTheme.typography.labelSmall)
        }
    }
}


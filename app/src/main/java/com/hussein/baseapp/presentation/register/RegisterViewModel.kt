package com.hussein.baseapp.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {
    private val _state = MutableStateFlow(RegistrationState())
    val state: StateFlow<RegistrationState> = _state.asStateFlow()

    fun sendIntent(intent: RegistrationIntent) {
        when (intent) {
            is RegistrationIntent.UpdateUsername -> {
                _state.value = _state.value.copy(
                    username = intent.username,
                    usernameError = validateUsername(intent.username)
                )
            }
            is RegistrationIntent.UpdateEmail -> {
                _state.value = _state.value.copy(
                    email = intent.email,
                    emailError = validateEmail(intent.email)
                )
            }
            is RegistrationIntent.UpdatePassword -> {
                _state.value = _state.value.copy(
                    password = intent.password,
                    passwordError = validatePassword(intent.password)
                )
            }
            RegistrationIntent.Submit -> {
                if (isFormValid()) {
                    // Handle successful registration
                    //registerUser ()
                }
            }
        }
    }

    private fun validateUsername(username: String): String? {
        return if (username.isEmpty()) "Username cannot be empty" else null
    }

    private fun validateEmail(email: String): String? {
        return if (email.isEmpty()) "Email cannot be empty" else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Invalid email format" else null
    }

    private fun validatePassword(password: String): String? {
        return if (password.length < 6) "Password must be at least 6 characters" else null
    }

    private fun isFormValid(): Boolean {
        return _state.value.usernameError == null &&
                _state.value.emailError == null &&
                _state.value.passwordError == null
    }
    /*private fun registerUser () {
        // Simulate a registration process
        viewModelScope.launch {
            try {
                // Call the repository to register the user
                userRepository.registerUser (
                    username = _state.value.username,
                    email = _state.value.email,
                    password = _state.value.password
                )
                // Optionally, you can update the state to indicate success
                // For example, you might want to navigate to a different screen
                // or show a success message
                _state.value = _state.value.copy(
                    username = "",
                    email = "",
                    password = "",
                    usernameError = null,
                    emailError = null,
                    passwordError = null
                )
                // Show success message or navigate
            } catch (e: Exception) {
                // Handle registration error (e.g., show a message)
                // You can update the state to show an error message
            }
        }
    }*/
}
package com.hussein.baseapp.presentation.register

sealed class RegistrationIntent {
    data class UpdateUsername(val username: String) : RegistrationIntent()
    data class UpdateEmail(val email: String) : RegistrationIntent()
    data class UpdatePassword(val password: String) : RegistrationIntent()
    object Submit : RegistrationIntent()
}
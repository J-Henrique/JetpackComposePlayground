package com.jhbb.cleanarcherrorhandling.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhbb.cleanarcherrorhandling.domain.SubmitEmailUseCase
import com.jhbb.cleanarcherrorhandling.util.Resource
import kotlinx.coroutines.launch

class MyViewModel(
    private val submitEmailUseCase: SubmitEmailUseCase = SubmitEmailUseCase()
): ViewModel() {

    var email by mutableStateOf("")
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun submitEmail() {
        viewModelScope.launch {
            val result = submitEmailUseCase.execute(email)
            when (result) {
                is Resource.Success -> {

                }
                is Resource.Error -> {
                    error = result.message
                }
            }
        }
    }
}
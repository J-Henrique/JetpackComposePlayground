package com.jhbb.cleanarcherrorhandling.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jhbb.cleanarcherrorhandling.presentation.MyViewModel
import com.jhbb.cleanarcherrorhandling.ui.theme.CleanArchErrorHandlingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchErrorHandlingTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    val viewModel = viewModel<MyViewModel>()
                    TextField(
                        value = viewModel.email,
                        onValueChange = viewModel::onEmailChanged,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = viewModel::submitEmail,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Submit")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (viewModel.error != null) {
                        Text(text = viewModel.error ?: "")
                    }
                }
            }
        }
    }
}
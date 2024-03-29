package com.rohitneel.androidcleanarchitecture.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.rohitneel.androidcleanarchitecture.presentation.viewmodel.ImageViewModel

@Composable
fun MainScreen(viewModel: ImageViewModel = hiltViewModel()) {
    val result = viewModel.imageList.value
    val query = remember { mutableStateOf("") }

    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if (result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            TextField(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                value = query.value, onValueChange = {
                    query.value = it
                    viewModel.updateQuery(query.value)
                }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }, placeholder = {
                    Text(text = "Search Here....")
                }
            )
            result.data?.let {
                LazyColumn() {
                    items(it) {
                        AsyncImage(
                            model = it.imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp)
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}
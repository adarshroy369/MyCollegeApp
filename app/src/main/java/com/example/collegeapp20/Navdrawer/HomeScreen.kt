package com.example.collegeapp20.Navdrawer


import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage


@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen() {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var selectedImageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())

    }

    val singlePhotopickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult ={
                uri ->  selectedImageUri=uri
        } )
    val  multiplePhotopickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult ={
                uris ->  selectedImageUris=uris
        } )



    LazyColumn(modifier= Modifier.fillMaxSize()){
        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
                Button(onClick = {
                    singlePhotopickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly),

                        )
                }) {
                    Text(text = "pick a notice")
                }
                Button(onClick = {
                    multiplePhotopickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }) {
                    Text(text = "pick multiple notice")
                }
            }
        }
        item {

            AsyncImage(model = selectedImageUri, contentDescription =null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
        }
        items(selectedImageUris){
                Uri ->
            AsyncImage(model = Uri, contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
        }
    }
}

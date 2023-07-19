package com.example.collegeapp.ui.theme.Gallery

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BasicGridView(){


    Scaffold() {


        LazyVerticalGrid(columns = GridCells.Fixed(2)){
             
            items(gridViewItems.size){
                
                Box(Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = gridViewItems[it].image ),
                        contentDescription =null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp))
                    
                    Row(Modifier.fillMaxWidth().height(30.dp).align(Alignment.BottomEnd)) {
                       Text(text = "${gridViewItems[it].name}",
                       style = TextStyle(
                           color = Color.White
                       ),
                           modifier = Modifier.weight(1f)
                       )

                        Text(text = "${gridViewItems[it].count}",
                        style = TextStyle(
                            color = Color.White
                        ))
                    }
                }
                

            }
        }
    }
}

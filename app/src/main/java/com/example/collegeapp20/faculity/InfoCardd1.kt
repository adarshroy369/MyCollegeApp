package com.example.collegeapp.ui.theme.faculity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun InfoCard(title:String,value:String){
    
    
    Box(modifier = Modifier
        .size(90.dp)
        .clip(RoundedCornerShape(12.dp))
        .background(color = colorResource(id = com.example.collegeapp20.R.color.teal_200))
        .padding(12.dp),
    contentAlignment = Alignment.Center){


        Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier.wrapContentWidth()) {


            Text(text = value,
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(id = com.example.collegeapp20.R.color.purple_200),
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(4.dp))


            Text(text = title,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            style = MaterialTheme.typography.overline,
            textAlign = TextAlign.Center)
        }
    }
    
}
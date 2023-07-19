package com.example.collegeapp.InfoCard

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter


@Composable
fun InfoCard(){
Column(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()) {
    LogoTitle()
    SocialMedia()
}
}



@Composable
fun LogoTitle(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .offset(y = 100.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        val image = painterResource(id =com.example.collegeapp20.R.drawable.beauty)
       Image(painter = image,contentDescription = null, modifier = Modifier.width(200.dp))
        Text(
            text = stringResource(com.example.collegeapp20.R.string.name),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(com.example.collegeapp20.R.string.title),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}



@Composable
fun SocialMedia(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .offset(y = 250.dp)) {
SocialInfo(
    text = stringResource(com.example.collegeapp20.R.string.facebook),
    id = com.example.collegeapp20.R.drawable.facebook,
    modifier = Modifier.weight(1f)
)
        SocialInfo(
    text = stringResource(com.example.collegeapp20.R.string.Instagram),
    id = com.example.collegeapp20.R.drawable.instagram,
    modifier = Modifier.weight(1f)
)
        SocialInfo(
    text = stringResource(com.example.collegeapp20.R.string.telephone_number),
    id = com.example.collegeapp20.R.drawable.instagram,
    modifier = Modifier.weight(1f)
)

    }

}

@Composable
fun SocialInfo(text:String,id:Int,modifier: Modifier) {

    val image = painterResource(id = id)

    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .height(50.dp)) {
        Text(text = text,
        color = Color.Blue,
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentHeight(Alignment.CenterVertically))
    }

}


@Preview
@Composable
fun InfoCardPreview(){
    InfoCard()
}
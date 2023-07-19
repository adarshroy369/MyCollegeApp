package com.example.collegeapp.ui.theme.faculity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemFaculityCard(faculity: Faculity){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        ,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.error

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {

            val image:Painter = painterResource(id = faculity.image)

            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = image,
alignment = Alignment.CenterStart,
                contentDescription = " ",
            contentScale = ContentScale.Crop)

            Spacer(modifier = Modifier.width(16.dp))


            Column(modifier = Modifier.align(Alignment.CenterVertically)) {

               Text(text = faculity.name,
               modifier = Modifier.padding(0.dp,0.dp,12.dp,0.dp),
               color = MaterialTheme.colors.surface,
               fontWeight = FontWeight.Bold,
               style = MaterialTheme.typography.subtitle1)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = buildString {
                    append(faculity.age)
                    append("yrs | ")
                    append(faculity.gender)
                },

                    modifier = Modifier.padding(0.dp,0.dp,12.dp,0.dp),
                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.caption
                )

               Row(modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.End) {
                   GenderTag(faculity.gender)
               }

            }

        }
    }

}


@Preview
@Composable
fun itemFaculityCardPreview(){

}
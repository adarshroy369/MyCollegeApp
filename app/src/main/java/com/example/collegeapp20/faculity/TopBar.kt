package com.example.collegeapp.ui.theme.faculity

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(onToggle : () -> Unit){

    Row(modifier= Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "facultiy details",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.surface)

            Spacer(modifier = Modifier.height(8.dp))


            Text(text = "my dear faculity details !",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.surface)
        }

        Row(modifier = Modifier.fillMaxWidth()
            .padding(0.dp,24.dp,36.dp,0.dp),
        horizontalArrangement = Arrangement.End) {

        }
    }

}
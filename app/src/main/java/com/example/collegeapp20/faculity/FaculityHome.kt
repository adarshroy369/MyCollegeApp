package com.example.collegeapp.ui.theme.faculity

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable

fun FaculityHome(faculityList: List<Faculity>){
    LazyColumn{
        item {
            TopBar {

            }

            Spacer(modifier = Modifier.height(8.dp))
            }

        items(faculityList){
            faculityList.forEach {
                ItemFaculityCard(
                    it
                )
            }
        }
    }
}

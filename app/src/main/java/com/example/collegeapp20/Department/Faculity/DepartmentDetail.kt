package com.example.collegeapp20.Department.Faculity

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.collegeapp20.R

import com.example.collegeapp20.ui.theme.CollegeApp20Theme


data class DepartmentDetails(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
)






@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DepartmentScreen(){
    CollegeApp20Theme() {

        Scaffold(
            content = {

           DepartmentDetailList(departmentdetaillist = DataSource().loadDepartmentDetails())

            }
        )
    }
}

@Composable
fun DepartmentDetailList(departmentdetaillist : List<DepartmentDetails>, modifier: Modifier=Modifier){
    LazyColumn{
        items(departmentdetaillist){ departmentdetail ->
            DepartmentDetailCard(departmentdetail)

        }
    }
}




@Composable
fun DepartmentDetailCard(departmentDetail : DepartmentDetails, modifier: Modifier=Modifier){
    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(color = Color.Gray)
        .padding(16.dp)){
        Surface(modifier = Modifier.size(50.dp),
        shape = CircleShape,
        color = Color.Gray) {
Image(painter = painterResource(departmentDetail.imageRes),
    contentDescription = null )
        }


        Column(modifier= Modifier
            .padding(10.dp)
            .align(Alignment.CenterVertically)) {
            
            Text(stringResource(departmentDetail.nameRes), fontWeight = FontWeight.Bold)
            
            CompositionLocalProvider(LocalContentAlpha provides  ContentAlpha.medium) {
                Text(stringResource(departmentDetail.descriptionRes),
                )
            }


    }
}}



@Preview
@Composable
fun DepartmentScreenPreview(){
   DepartmentScreen()
}




























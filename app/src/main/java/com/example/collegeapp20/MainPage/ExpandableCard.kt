

package com.example.collegeapp20.MainPage

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.core.graphics.rotationMatrix
//import com.example.practice1.ui.theme.Shapes
import java.lang.reflect.Modifier


@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    title:String,
    titleFontSize: TextUnit=MaterialTheme.typography.h2.fontSize,
    titleFontWeight:FontWeight=FontWeight.Bold,
    description:String,
    descriptionFontSize: TextUnit= MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight=FontWeight.Normal,
    descriptionMaxLines:Int=5,
//    shape: CornerBasedShape=Shapes.medium,
    padding: Dp = 8.dp



){
    var expandableState by remember{
        mutableStateOf(false)
    }

    Card(
        modifier = androidx.compose.ui.Modifier
            .height(60.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing,
                ),
            ),
//        shape = Shapes.medium,
        onClick = {
            expandableState = !expandableState
            
        }
        ) {
     Column(modifier = androidx.compose.ui.Modifier
         .fillMaxWidth()
         .padding(8.dp)
     ) {
       Row(verticalAlignment = Alignment.CenterVertically) {
           Text(
               modifier = androidx.compose.ui.Modifier
                   .weight(
                       10f
                   ),
               text ="my Rgukt",
             fontSize = 12.sp,
           fontWeight = titleFontWeight,
               maxLines = 1,
               overflow = TextOverflow.Ellipsis

               )
     
           IconButton(
               modifier = androidx.compose.ui.Modifier
                   .alpha(ContentAlpha.medium)
                   .weight(1f)
               ,



               onClick = { expandableState=!expandableState}) {


              Icon(imageVector = Icons.Default.ArrowDropDown,
                  contentDescription = "Drop-Down-Arrow"
              )
           }
           
           
           }


         if(expandableState){
             Text(
                 text ="afghjkjhghjkjhghj",
                 fontSize = descriptionFontSize,
                 fontWeight = descriptionFontWeight,
                 maxLines = descriptionMaxLines,
                 overflow = TextOverflow.Ellipsis
             )



         }

           }



       }
     }



@ExperimentalMaterialApi
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ExpandableCardPreview(){
    ExpandableCard(title ="my Title",
    description = " "

        )
}



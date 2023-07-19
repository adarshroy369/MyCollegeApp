package com.example.collegeapp.MainPage
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

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*

import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.fontResource

import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.graphics.rotationMatrix
//import com.example.practice1.ui.theme.Shapes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.collegeapp20.MainPage.ExpandableCard
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun MainPage() {

    val images = remember {
        mutableStateListOf(
            com.example.collegeapp20.R.drawable.college1,
            com.example.collegeapp20.R.drawable.college2,
            com.example.collegeapp20.R.drawable.college3,
        )
    }


    val pagerState = rememberPagerState()


    Box(modifier = Modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState, count = 3) { page ->
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp),
                        model = ImageRequest.Builder(LocalContext.current).data(images[page])
                            .build(),
                        contentDescription = "",
                    )
                }
            }
        }
 Spacer(modifier = Modifier.size(8.dp))

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(backgroundColor = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(580.dp),
                elevation = 0.dp) {
                Box (){
                    found()


                }
            }
        }
    }


}

@Composable
fun found() {
    Box() {
        Column() {
            Text(fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                text = " FOUNDING OF RGUKT")
            Text(text = "  The idea to create IIITs in Andhra Pradesh came in April 2007, at the request of the Chief Minister of Andhra Pradesh. He was dissatisfied with the opportunities available to the rural youth and wanted to set up at least three IIITs in the three regions of Andhra Pradesh which would ensure better opportunities for rural students.\n" +
                    "    A Task Force was created under the Chairmanship of Prof. K.C. Reddy. This Task Force produced a report to the government recommending the structure and functioning of the proposed institutions.\n" +
                    "    In March of 2008, the AP Government created RGUKT by an act of the Legislature as a full-fledged university which would initially admit roughly the top 1% of the rural students into the three residential campuses.\n" +
                    "    The first batch of about 6,500 tenth class graduates was admitted into a six year integrated program in August of 2008. The initial selection was based on the local best model where students receiving the top marks in every subject were selected.\n" +
                    "The primary objective of establishing RGUKT was to provide high quality educational opportunities for the aimed rural youth of Andhra Pradesh. The initial goal was that at least the top 1 % of the rural graduates would be given the opportunity to study at RGUKT.\n" +
                    "\n" +
                    "The top 1% of rural graduates is around 6,000 to 7,000 per year. Thus, the three campuses would need residential accommodation for about 36,000 students for the six year integrated program.\n" +
                    "\nAt present, most universities in India and in Andhra Pradesh follow the affiliated college structure model where the main role of the university is to set the curriculum and conduct examinations to ensure that the students have indeed learned the material prescribed in the curriculum")
        }

    }


//
}
@Preview
@Composable
fun MainPagepreview(){
    MainPage()

}
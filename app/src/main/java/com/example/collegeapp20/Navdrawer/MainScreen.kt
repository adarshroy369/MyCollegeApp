package com.example.collegeapp20.Navdrawer

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.collegeapp.Attendence.AttendenceReport
import com.example.collegeapp.InfoCard.InfoCard
import com.example.collegeapp.MainPage.MainPage
import com.example.collegeapp.VideoPlayer.VideoPlayer1
import com.example.collegeapp20.Department.Faculity.DepartmentScreen
import com.example.collegeapp20.InfoCard.InfoCard2
import com.example.collegeapp20.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController)
    }

}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState){

    TopAppBar(
        title = { Text(text = "Navigation Drawer", fontSize = 18.sp) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        backgroundColor = Color.Green,
        contentColor = Color.Black
    )

}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){

    val items = listOf(
        NavigationItem.MainPage,
        NavigationItem.Home,
        NavigationItem.Department,
        NavigationItem.Profile,
        NavigationItem.Settings,
        NavigationItem.Attendence,
        NavigationItem.VideoCard,
        NavigationItem.InfoCard2,
        NavigationItem.Share,
        NavigationItem.Contact,

    )

    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            Image(
                painter = painterResource(id = com.example.collegeapp20.R.drawable.ssnclg),
                contentDescription = "",
                modifier = Modifier
                    .height(175.dp)
                    .fillMaxWidth()
                    .padding(0.dp)
            )

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                navController.navigate(items.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route){
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "version 1.0.0",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}

@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit){
    val background = if(selected) androidx.compose.ui.R.color.vector_tint_theme_color else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(
                colorResource(id = background))
            .padding(start = 10.dp)
    ) {

        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}


@Composable
fun SettingsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Bottom
    )
    {
        Image( modifier= Modifier.padding(horizontal = 50.dp),painter = painterResource(id = R.drawable.ssnmaps), contentDescription =null )

        HyperLinkText(
            modifier = Modifier, fullText ="Rajiv Gandhi University of Knowledge Technologies, Ongole-Campus" ,
            linkText = listOf("Ongole-Campus","Rajiv Gandhi University ")
            , hyperlinks = listOf("http://www.rguktong.ac.in/","http://www.rgukt.in/" ),
            fontSize = MaterialTheme.typography.h5.fontSize)

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShareScreen(){


    val images = remember {
        mutableStateListOf(
            R.drawable.developer2,

        )
    }

    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(count =images.size ,
        state = pagerState) { index ->
            AsyncImage(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = ImageRequest.Builder(LocalContext.current).data(images[index])
                .build(),
                contentDescription = " Image" ,
            contentScale = ContentScale.Crop)
        }

        Text(
            text = "Share Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )


    }
}

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactScreen(){
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

          var rating by remember {
              mutableStateOf(5f)
          }


            val emoji by derivedStateOf {
                when(rating){
                    1f -> "\uD83D\uDE2D"
                    2f ->  "\uD83D\uDE22"
                    3f -> "\uD83D\uDE1F"
                    4f -> "\uD83D\uDE42"
                    else -> "\uD83D\uDE01"
                }
            }



            AnimatedContent(targetState = emoji) {
                Text(text = it, fontSize = 160.sp)
            }



            
            Spacer(modifier =Modifier.height(16.dp) )




        RatingBar(value =rating ,
            style = RatingBarStyle.Fill()
            , onValueChange ={
                             if(it in 1f..5f)
                                 rating = it
            } ,
            onRatingChanged =  { },

        )


        }
    }

}

@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController, startDestination = NavigationItem.Home.route){



        composable(NavigationItem.MainPage.route){
            MainPage()
        }

        composable(NavigationItem.Home.route){
            HomeScreen()
        }


        composable(NavigationItem.Department.route){
            DepartmentScreen()
        }

        composable(NavigationItem.Profile.route){
            ProfileScreen()
        }

        composable(NavigationItem.Settings.route){
            SettingsScreen()
        }

        composable(NavigationItem.Attendence.route){
          AttendenceReport()
        }

        composable(NavigationItem.VideoCard.route){
            VideoPlayer1()
        }


        composable(NavigationItem.InfoCard2.route){
            InfoCard2()
        }

        composable(NavigationItem.Share.route){
            ShareScreen()
        }

        composable(NavigationItem.Contact.route){
            ContactScreen()
        }




    }

}



@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}


@Preview
@Composable
fun SettingScreenPreview(){
    SettingsScreen()
}

//
//@Preview()
//@Composable
//fun ContactPreview(){
//    ContactScreen()
//}
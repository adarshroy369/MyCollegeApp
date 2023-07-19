package com.example.collegeapp20
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.collegeapp20.Drawer.AppBar
import com.example.collegeapp20.Drawer.DrawerBody
import com.example.collegeapp20.Drawer.DrawerHeader
import com.example.collegeapp20.Drawer.MenuItem
import com.example.collegeapp20.Navdrawer.MainScreen
import com.example.collegeapp20.ui.theme.CollegeApp20Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollegeApp20Theme {
                // A surface container using the 'background' color from the theme











                MainScreen()
//
//                val scaffoldState = rememberScaffoldState()
//                val scope = rememberCoroutineScope()
//                Scaffold(
//                    scaffoldState = scaffoldState,
//                    topBar = {
//                        AppBar(
//                            onNavigationIconClick = {
//                                scope.launch {
//                                    scaffoldState.drawerState.open()
//                                }
//                            }
//                        )
//                    },
//                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
//                    drawerContent = {
//                        DrawerHeader()
//                        DrawerBody(
//                            items = listOf(
//                                MenuItem(
//                                    id = "home",
//                                    title = "Home",
//                                    contentDescription = "Go to home screen",
//                                    icon = Icons.Default.Home
//                                ),
//                                MenuItem(
//                                    id = "settings",
//                                    title = "Settings",
//                                    contentDescription = "Go to settings screen",
//                                    icon = Icons.Default.Settings
//                                ),
//                                MenuItem(
//                                    id = "help",
//                                    title = "Help",
//                                    contentDescription = "Get help",
//                                    icon = Icons.Default.Info
//                                ),
//                            ),
//                            onItemClick = {
//                                println("Clicked on ${it.title}")
//                            }
//                        )
//                    }
//                ) {
//
//                }


            }
            }
        }
    }


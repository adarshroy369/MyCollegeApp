package com.example.collegeapp20.Navdrawer

import com.example.collegeapp20.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String)
{
    object MainPage:NavigationItem("mainpage",R.drawable.ic_baseline_home_24,"Mainpage")
    object Home : NavigationItem("home", R.drawable.ic_baseline_announcement_24, "Notice")
    object Department:NavigationItem("department",R.drawable.ic_baseline_people_24,"Department")
    object Profile : NavigationItem("profile", R.drawable.ic_baseline_library_books_24, "Gallery")
    object Attendence:NavigationItem("Attendence",R.drawable.ic_baseline_favorite_24,"Attendence")
    object Settings : NavigationItem("settings", R.drawable.ic_baseline_web_24, "Website")
    object VideoCard:NavigationItem("videocard",R.drawable.ic_baseline_ondemand_video_24,"VideoPlayer")
    object InfoCard2:NavigationItem("infocard2",R.drawable.ic_baseline_info_24,"About")
    object Share : NavigationItem("share", R.drawable.ic_baseline_code_24, "Developer")
    object Contact : NavigationItem("contact", R.drawable.ic_baseline_add_reaction_24, "Rate App")
//    object Login :NavigationItem("login", com.google.firebase.firestore.R.drawable.notify_panel_notification_icon_bg,"LoginPage")



}

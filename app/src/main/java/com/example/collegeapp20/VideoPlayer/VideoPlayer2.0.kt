package com.example.collegeapp.VideoPlayer

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSource

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VideoPlayer1(){


    val context = LocalContext.current
    val url="https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

    val player = remember{
ExoPlayer.Builder(context).build().apply {
    val datasource = DefaultDataSource.Factory(context)

    val source = ProgressiveMediaSource.Factory(datasource)
        .createMediaSource(MediaItem.fromUri(Uri.parse(url)))

addMediaSource(source)
    prepare()


}
    }



    Scaffold(topBar = {
        TopAppBar(title = {Text(text = "Videoplayer")},

    )},
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center) {

                AndroidView(factory = {
                    PlayerView(it).apply {
                        this.player = player
                        useController = true
                        setShowBuffering(PlayerView.SHOW_BUFFERING_ALWAYS)
                    }
                })


            }
        })

}



@Preview
@Composable
fun VideoPlayer1Preview(){
    VideoPlayer1()
}
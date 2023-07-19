package com.example.collegeapp20.Attendence

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.calculatePan
import androidx.compose.foundation.gestures.calculateZoom
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Zoomable(){



var scale by remember { mutableStateOf(1f) }
var offsetX by remember { mutableStateOf(0f) }
var offsetY by remember { mutableStateOf(0f) }

// In the example below, we make the Column composable zoomable
// by leveraging the Modifier.pointerInput modifier
Column(
verticalArrangement = Arrangement.Center,
horizontalAlignment = Alignment.CenterHorizontally,
modifier = Modifier
.pointerInput(Unit) {
    forEachGesture {
        awaitPointerEventScope {
            awaitFirstDown()
            do {
                val event = awaitPointerEvent()
                scale *= event.calculateZoom()
                val offset = event.calculatePan()
                offsetX += offset.x
                offsetY += offset.y
            } while (event.changes.any { it.pressed })
        }
    }
}
) {
    // painterResource method loads an image resource asynchronously
    val imagepainter = painterResource(id = com.example.collegeapp20.R.drawable.ssnmaps)
    // We use the graphicsLayer modifier to modify the scale & translation
    // of the image.
    // This is read from the state properties that we created above.
    Image(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                translationX = offsetX,
                translationY = offsetY
            ),
        painter = imagepainter,
        contentDescription = "androids launcher default launcher background image"
    )
}
}


@Preview
@Composable
fun ZoomablePreview(){
    Zoomable()
}
package com.example.android_aplicaciones.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


@Composable
fun PeruBandera(){
    val density = LocalDensity.current.density

    val w = remember { 100f * density }
    val h = remember { 33f * density }

    Canvas(modifier = Modifier.size(100.dp), onDraw = {
        drawRect(color = Color.Black, size = Size(w, h), topLeft = Offset.Zero)
        drawRect(color = Color.Red, size = Size(w, h), topLeft = Offset(0f, h))
        drawRect(color = Color.Yellow, size = Size(w, h), topLeft = Offset(0f, h * 2))
    })
}
package com.neecs.spotifyclonecompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlaylistCard(onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp) // Ajuste de altura para un estilo más compacto
            .clickable { onClick() }
            .padding(4.dp),
        color = Color(0xFF1C1C1C), // Fondo oscuro para la tarjeta de playlist
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)
        ) {
            // Imagen de playlist a la izquierda
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Gray) // Color gris como placeholder
            ) {
                Text(
                    text = "Image",
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Texto a la derecha de la imagen
            Text(
                text = "Everybody Lost Somebody", // Texto de ejemplo
                color = Color.White,
                fontSize = 14.sp,
                maxLines = 1 // Limita a una línea
            )
        }
    }
}

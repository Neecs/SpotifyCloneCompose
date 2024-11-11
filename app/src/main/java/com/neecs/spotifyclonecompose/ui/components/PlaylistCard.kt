package com.neecs.spotifyclonecompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neecs.spotifyclonecompose.R

@Composable
fun PlaylistCard(onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable { onClick() }
            .padding(4.dp),
        color = Color(0xFF1C1C1C),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)
        ) {
            // Imagen de playlist desde recursos locales
            Image(
                painter = painterResource(id = R.drawable.album),
                contentDescription = "Playlist Image",
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Texto a la derecha de la imagen
            Text(
                text = "The wall", // Texto de ejemplo
                color = Color.White,
                fontSize = 14.sp,
                maxLines = 1
            )
        }
    }
}

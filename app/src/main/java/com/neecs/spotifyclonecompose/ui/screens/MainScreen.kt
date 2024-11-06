package com.neecs.spotifyclonecompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.neecs.spotifyclonecompose.ui.components.FeaturedCard
import com.neecs.spotifyclonecompose.ui.components.PlaylistCard
import com.neecs.spotifyclonecompose.ui.components.SongItem

@Composable
fun MainScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        // LazyRow para categorías (e.g., All, Music, Podcasts)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(4) { index ->
                val category = when (index) {
                    0 -> "All"
                    1 -> "Music"
                    2 -> "Podcasts & Shows"
                    else -> "Audiobooks"
                }
                CategoryChip(category)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Grid de playlists en dos columnas
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().height(300.dp) // Altura aproximada para 6 playlists
        ) {
            items(6) { // Mostramos 6 playlists como ejemplo
                PlaylistCard {
                    navController.navigate("detail_screen")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta destacada para una nueva canción o recomendación
        FeaturedCard(
            title = "Yes I'm A Mess",
            artist = "AJR",
            navController = navController
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sección de canciones recientes o populares
        Text(
            text = "Your shows",
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(3) { // Ejemplo con 3 shows
                SongItem {
                    navController.navigate("detail_screen")
                }
            }
        }
    }
}

@Composable
fun CategoryChip(text: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(4.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

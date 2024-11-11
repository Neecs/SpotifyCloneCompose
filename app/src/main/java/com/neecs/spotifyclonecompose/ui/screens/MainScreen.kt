package com.neecs.spotifyclonecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.neecs.spotifyclonecompose.ui.components.FeaturedCard
import com.neecs.spotifyclonecompose.ui.components.PlaylistCard
import com.neecs.spotifyclonecompose.R

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
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

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().height(250.dp)
        ) {
            items(6) {
                PlaylistCard {
                    navController.navigate("detail_screen")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "NEW RELEASE FROM IRON MAIDEN",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
        )

        FeaturedCard(
            title = "The number of the beast",
            artist = "Iron Maiden",
            imageResId = R.drawable.featured, // Asegúrate de que este recurso exista y sea visible
            navController = navController
        )

    }
}




@Composable
fun CategoryChip(text: String) {
    Surface(
        color = Color(0xFF303030),
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


package com.neecs.spotifyclonecompose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.neecs.spotifyclonecompose.ui.components.SongItem

@Composable
fun DetailScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        val (title, list) = createRefs()
        Text(
            text = "Album Title",
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
            }
        )

        LazyColumn(
            modifier = Modifier.constrainAs(list) {
                top.linkTo(title.bottom, margin = 16.dp)
            }
        ) {
            items(10) { SongItem {} }
        }
    }
}

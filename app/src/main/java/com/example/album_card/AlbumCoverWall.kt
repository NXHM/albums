package com.example.album_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AlbumCoverWall(albumsInfo: List<AlbumInfo>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .background(
                brush = Brush
                    .verticalGradient(
                        colors = listOf(
                            Color(202, 202, 202, 255),
                            Color(214, 213, 213, 255)

                        )
                    )
            )
            .fillMaxSize(),
        content = {
            items(albumsInfo.size){
                    i->AlbumCard(albumInfo=albumsInfo[i])
            }
        }
    )

}

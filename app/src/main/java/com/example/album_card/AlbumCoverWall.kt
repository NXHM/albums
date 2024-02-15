package com.example.album_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.NonCancellable


@Composable
fun AlbumCoverWall(albumsInfo: List<AlbumInfo>){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start= 12.dp,
            top=16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = Modifier
            .background(
                brush = Brush
                    .verticalGradient(
                        colors = listOf(
                            Color.White,
                            Color.LightGray

                        )
                    )
            ),
        content = {
            items(albumsInfo.size){
                    i->AlbumCard(albumInfo=albumsInfo[i])
            }
        }
    )

}

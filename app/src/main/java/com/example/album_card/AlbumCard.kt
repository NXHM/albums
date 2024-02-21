package com.example.album_card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import com.example.album_card.ui.theme.descriptionAlbum
import com.example.album_card.ui.theme.titleAlbum

data class AlbumInfo(
    //val colorList: List<Color>,
    val description: String,
    val title: String,
    val cover: Int,
    val backCover: Int
)
@Composable
fun AlbumCard(albumInfo: AlbumInfo){
    var coverSide by remember {mutableStateOf(true)}
    var actualImage = if(coverSide) albumInfo.cover else albumInfo.backCover
    Card (
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp),
        modifier = Modifier
            .padding()
            .fillMaxWidth()
            .clickable {
                coverSide = !coverSide
            }
            ,


    ) {
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(10.dp)
        ){
            Image(painter = painterResource(
                id = actualImage),// hare que esto se cambie por una imagen
                contentDescription=albumInfo.description,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp)
            )
            Column(
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .padding(10.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                    ),
                verticalArrangement = Arrangement.spacedBy(2.dp)


            ){
                Text(text = albumInfo.title, // esto sera texto que den como input
                    style= titleAlbum,
                )
                Text(text= albumInfo.description,
                    style = descriptionAlbum,)
            }

        }

        Row(// Parte de texto
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){


        }


        /*Row(modifier = Modifier
            .padding(16.dp)

        ){
            
        }*/
            }
}
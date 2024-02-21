package com.example.album_card

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.album_card.ui.theme.album


private val messages: List<MyMessage> = listOf(
    MyMessage("Hola1", "negro..."),
    MyMessage("Hola2", "negro..."),
    MyMessage("Hola3", "negro..."),
    MyMessage("Hola4", "negro..."),
    MyMessage("Hola5", "negro..."),
    MyMessage("Hola6", "negro..."),
    MyMessage("Hola7", "negro..."),
    MyMessage("Hola8", "negro..."),)

private val albumsInfo: MutableList<AlbumInfo> = mutableListOf()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            album {
                //MyMessages(messages)
                PreviewAlbum()
            }
        }
    }
}
@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba",
        modifier= Modifier
            .clip(shape = CircleShape)//Primero el contenedor
            .border(
                10.dp,
                Color.Magenta,
                (CircleShape)
            )
            .size(70.dp)
            .background(
                Color(226, 79, 108)
            )
            //.background(Color.Red)
            //.clip(CircleShape)
    )
}
data class MyMessage(val title:String, val author:String)

@Composable
fun MyTexts(message: MyMessage){
    var expanded by remember {mutableStateOf(false)}
    Column (modifier= Modifier
        .padding(8.dp)
        .clickable { expanded = !expanded }
    ) {
                MyText(message.title,
                    MaterialTheme.colorScheme.tertiary,
                    MaterialTheme.typography.headlineLarge
                    )
                MyText(message.author,
                    MaterialTheme.colorScheme.secondary,
                    MaterialTheme.typography.headlineMedium
                )
    }
}




@Composable
fun MyText(text: String,  color: Color, style: androidx.compose.ui.text.TextStyle){
    Text(text, color=color, style=style)
}

//@Preview(showSystemUi=true)
//@Preview(showBackground = true)
//@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES)
@Preview
@Composable
fun PreviewAlbum() {
    album {
        //val resources = Resources.getSystem()
        //val bitmap = BitmapFactory.decodeResource(resources, R.drawable.Contraportada_mas_futuro_que_pasado_juanes)
        val cover = (R.drawable.portada_mas_futuro_que_pasado_juanes)
        val backCover = (R.drawable.contraportada_mas_futuro_que_pasado_juanes)
        //println(cover::class.java.typeName)
        val albumInfo = AlbumInfo(
            /*listOf(
                Color(21, 0, 140),
                Color(164, 51, 119)
            ),*/
            "Album de prueba descripcion",
            "Album prueba titulo",
            cover,
            backCover
        )
        val albumInfo2 = AlbumInfo(
            /*listOf(
                Color(21, 0, 140),
                Color(164, 51, 119)
            ),*/
            "Album de prueba descripcion",
            "Album prueba titulo2",
            cover,
            backCover
        )
        albumsInfo.add(albumInfo)
        albumsInfo.add(albumInfo2)
        //val imageBitmap = ImageDecoder.decodeBitmap().value
        Log.i("lista: ", albumsInfo.toString())
        AlbumCoverWall(albumsInfo = albumsInfo)
        //AlbumCard(albumInfo = albumInfo)
    }
}
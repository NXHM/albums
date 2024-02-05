package com.example.album_card

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.album_card.ui.theme.album
import com.example.album_card.R


private val messages: List<MyMessage> = listOf(
    MyMessage("Hola1", "negro..."),
    MyMessage("Hola2", "negro..."),
    MyMessage("Hola3", "negro..."),
    MyMessage("Hola4", "negro..."),
    MyMessage("Hola5", "negro..."),
    MyMessage("Hola6", "negro..."),
    MyMessage("Hola7", "negro..."),
    MyMessage("Hola8", "negro..."),)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            album {
                MyMessages(messages)
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
                brush = Brush
                .verticalGradient(
                    colors = listOf(
                        Color(21, 0, 140),
                        Color(164, 51, 119)
                    )
                )
            )
            //.background(Color.Red)
            //.clip(CircleShape)
    )
}
data class MyMessage(val title:String, val author:String)
@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn(){
        items(messages){message->
            MyComponent(message)
        }
    }
}
@Composable
fun MyTexts(message: MyMessage){
    Column (modifier=Modifier
        .padding(8.dp)) {
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
fun MyComponent(message: MyMessage){
    Row (modifier= Modifier
        .background(Color(226, 79, 108))
        .padding(10.dp)
    ){
        MyImage()
        MyTexts(message)
    }
}
@Composable
fun MyText(text: String,  color: Color, style: androidx.compose.ui.text.TextStyle){
    Text(text, color=color, style=style)
}
@Preview(showSystemUi=true)
@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTexts() {
    album {
        MyMessages(messages = messages)
    }
}
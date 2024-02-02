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
import androidx.compose.foundation.shape.CircleShape
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
import com.example.album_card.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            JetpackComposeTutorialTheme {
                MyComponent()
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
                0.dp,
                Color.Magenta,
                CircleShape
            )
            .size(64.dp)
            .background(MaterialTheme.colorScheme.primary)
            //.background(Color.Red)
            //.clip(CircleShape)
    )
}

@Composable
fun MyTexts(){
    Column (modifier=Modifier
        .padding(8.dp)) {
                MyText("hola",
                    MaterialTheme.colorScheme.tertiary,
                    MaterialTheme.typography.headlineLarge
                    )
                MyText("negro",
                    MaterialTheme.colorScheme.secondary,
                    MaterialTheme.typography.headlineMedium
                )
    }
}
@Composable
fun MyComponent(){
    Row (modifier= Modifier
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFF9E82F0),
                    Color(0xFF42A5F5)
                )
            )
        )
        .padding(10.dp)
        .clip(SquareShape)
    ){
        MyImage()
        MyTexts()
    }
}
@Composable
fun MyText(text: String,  color: Color, style: androidx.compose.ui.text.TextStyle){
    Text(text, color=color, style=style)
}
@Preview()
@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTexts() {
    JetpackComposeTutorialTheme {
        MyComponent()
    }

}
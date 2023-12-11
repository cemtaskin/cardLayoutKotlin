package com.ttmobilpos.messageappa

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ttmobilpos.messageappa.ui.theme.MessageAppATheme
import com.ttmobilpos.messageappa.ui.theme.lightGreen
import com.ttmobilpos.messageappa.ui.theme.shapeScheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageAppATheme() {
                MainScreen()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        Icon(Icons.Default.Home, contentDescription = "", modifier = Modifier.padding(12.dp))
                    },
                    title = {

                            Text(text = "Messaging Application Users") }
                )
            },

        ) {paddingValues ->
            Surface(modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues),
            ) {
                Column {
                    ProfileCard(userProfile = userProfiles[0])
                    ProfileCard(userProfile = userProfiles[1])
                }

            }
        }


}

@Composable
fun ProfileCard(userProfile: UserProfile){
    Card(
        modifier =
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,

    ),
    shape = MaterialTheme.shapeScheme.medium) {
        Row(
            modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(onlineStatus = userProfile.status, drawableId = userProfile.drawableId)
            ProfileContent(onlineStatus = userProfile.status, name = userProfile.name)
        }
    }
}

@Composable
fun ProfilePicture(onlineStatus : Boolean , drawableId : Int){
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = if (onlineStatus)  Color.lightGreen else Color.Red),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation  = 8.dp)
    ) {
        Image(painterResource(drawableId),
            contentDescription = "",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
            )

    }

}

@Composable
fun ProfileContent(name : String , onlineStatus: Boolean){
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(name,modifier = Modifier.fillMaxWidth(), style = MaterialTheme.typography.labelMedium)
        Text(
            if (onlineStatus) "Active Now" else "Offline", modifier = Modifier.alpha(0.4f),style = MaterialTheme.typography.bodySmall)
    }

}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
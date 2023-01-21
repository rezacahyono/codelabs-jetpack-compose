package com.rchyn.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rchyn.businesscardapp.ui.theme.BusinessCardAppTheme
import com.rchyn.businesscardapp.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF073042)) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column {
        Row(Modifier.weight(7f)) {
            NameCard(
                logoPainter = painterResource(id = R.drawable.android_logo),
                name = stringResource(id = R.string.full_name),
                title = stringResource(id = R.string.title)
            )
        }
        Row(Modifier.weight(3f)) {
            ContactInformation(
                noPhone = stringResource(id = R.string.no_phone),
                linkDev = stringResource(id = R.string.link_dev),
                email = stringResource(id = R.string.email)
            )
        }
    }
}


@Composable
fun NameCard(
    logoPainter: Painter, name: String, title: String, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logoPainter,
            contentDescription = null,
            modifier = modifier
                .height(120.dp)
                .width(120.dp)
        )
        Text(
            modifier = modifier.padding(bottom = 8.dp),
            text = name,
            color = Color.White,
            style = Typography.displaySmall,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color(0xFF3ddc84),
            style = Typography.labelLarge
        )

    }
}

@Composable
fun ContactInformation(
    noPhone: String, linkDev: String, email: String, modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        Divider(color = Color.LightGray)
        ContactText(icon = Icons.Default.Phone, text = noPhone)
        Divider(color = Color.LightGray)
        ContactText(icon = Icons.Default.Share, text = linkDev)
        Divider(color = Color.LightGray)
        ContactText(icon = Icons.Default.Email, text = email)
    }
}

@Composable
fun ContactText(
    icon: ImageVector, text: String, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(
            start = 32.dp,
            end = 32.dp,
            top = 8.dp,
            bottom = 8.dp
        )
    ) {
        Icon(
            imageVector = icon, contentDescription = null, tint = Color(0xFF3ddc84)
        )
        Text(
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            text = text,
            style = Typography.bodyLarge,
            color = Color.White
        )
    }

}


//@Preview
//@Composable
//fun PreviewNameCard() {
//    NameCard(
//        logoPainter = painterResource(id = R.drawable.android_logo),
//        name = stringResource(id = R.string.full_name),
//        title = stringResource(
//            id = R.string.title
//        )
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun PreviewContactInformation() {
//    ContactInformation(
//        noPhone = stringResource(id = R.string.no_phone),
//        linkDev = stringResource(id = R.string.link_dev),
//        email = stringResource(id = R.string.email)
//    )
//}

@Preview
@Composable
fun PreviewBusinessCardApp() {
    BusinessCardAppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF073042)) {
            BusinessCardApp()
        }
    }
}
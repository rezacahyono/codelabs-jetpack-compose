package com.rchyn.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rchyn.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedCard {
            Image(
                modifier = modifier
                    .padding(32.dp),
                painter = painterResource(id = R.drawable.photo_1),
                contentDescription = null,
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        ElevatedCard {
            Column(modifier = modifier.padding(16.dp)) {
                Text(text = stringResource(id = R.string.title_1))
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                            )
                        ) {
                            append(stringResource(id = R.string.author_1))
                        }
                        append(stringResource(id = R.string.since_1))
                    }
                )
            }
        }
        Spacer(modifier = modifier.height(16.dp))

        Row {
            ElevatedButton(
                modifier = modifier.weight(1f),
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(id = R.string.previous))
            }
            Spacer(modifier = modifier.width(16.dp))
            ElevatedButton(
                modifier = modifier.weight(1f),
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtSpaceScreen() {
    ArtSpaceAppTheme {
        ArtSpaceScreen()
    }
}
package com.rchyn.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rchyn.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun ArticleComposeApp() {
    ArticleCard(
        titleArticle = stringResource(id = R.string.title_article),
        firstText = stringResource(id = R.string.first_text_article),
        secondText = stringResource(id = R.string.second_text_article),
        image = painterResource(id = R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleCard(
    titleArticle: String,
    firstText: String,
    secondText: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)
        Text(text = titleArticle, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(
            text = firstText,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(text = secondText, textAlign = TextAlign.Justify, modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun PreviewArticleComposeApp() {
    ComposeArticleTheme {
        Surface {
            ArticleComposeApp()
        }
    }
}

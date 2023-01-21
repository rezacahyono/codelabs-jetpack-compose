package com.rchyn.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rchyn.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}


@Composable
fun ComposeQuadrantApp() {
    Column {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(id = R.string.title_one),
                description = stringResource(id = R.string.description_one),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(id = R.string.title_two),
                description = stringResource(id = R.string.description_two),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(id = R.string.title_three),
                description = stringResource(id = R.string.description_three),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(id = R.string.title_four),
                description = stringResource(id = R.string.description_four),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier,
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComposeQuadrantApp() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}

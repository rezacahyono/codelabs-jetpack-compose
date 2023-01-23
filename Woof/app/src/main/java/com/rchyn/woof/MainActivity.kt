package com.rchyn.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rchyn.woof.data.DataSources
import com.rchyn.woof.model.Dog
import com.rchyn.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                WoofApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofApp() {
    Scaffold(
        topBar = {
            WoofTopAppBar()
        },
        content = { innerPadding ->
            WoofList(dogs = DataSources.dogs, innerPadding)
        }
    )
}

@Composable
fun WoofList(
    dogs: List<Dog>,
    innerPaddingValues: PaddingValues
) {
    LazyColumn(contentPadding = innerPaddingValues) {
        items(dogs) {
            WoofCard(dog = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofCard(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(50)
    ) {
        Row(modifier = modifier.padding(8.dp)) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(50)),
                painter = painterResource(id = dog.imageResourceId),
                contentDescription = stringResource(id = dog.name),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = dog.name),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.years_old, dog.age),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun WoofTopAppBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(62.dp)
                .padding(16.dp),
            painter = painterResource(R.drawable.ic_woof_logo),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Preview
@Composable
fun PreviewWoofCard() {
    WoofTheme {
        WoofCard(dog = DataSources.dogs[0])
    }
}

@Preview
@Composable
fun PreviewWoofApp() {
    WoofTheme(useDarkTheme = false) {
        WoofApp()
    }
}

@Preview
@Composable
fun PreviewWoofAppDarkTheme() {
    WoofTheme(useDarkTheme = true) {
        WoofApp()
    }
}

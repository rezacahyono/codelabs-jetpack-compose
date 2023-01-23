package com.rchyn.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rchyn.buildagrid.data.DataSources
import com.rchyn.buildagrid.model.Topic
import com.rchyn.buildagrid.ui.theme.BuildAGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicApp()
        }
    }
}

@Composable
fun TopicApp() {
    BuildAGridTheme {
        TopicList(topics = DataSources.topics)
    }
}

@Composable
fun TopicList(topics: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(topics) {
            TopicCard(topic = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.padding(4.dp)
    ) {
        Row {
            Box {
                Image(
                    painter = painterResource(id = topic.image),
                    contentDescription = stringResource(id = topic.title),
                    modifier = Modifier
                        .width(68.dp)
                        .height(68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    text = stringResource(id = topic.title),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(12.dp),
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = topic.title),
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTopicCard() {
    BuildAGridTheme {
        TopicCard(topic = DataSources.topics[0])
    }
}
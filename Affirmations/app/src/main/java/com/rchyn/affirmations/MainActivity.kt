package com.rchyn.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rchyn.affirmations.data.DataSources
import com.rchyn.affirmations.model.Affirmation
import com.rchyn.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationApp()
        }
    }
}

@Composable
fun AffirmationApp() {
    AffirmationsTheme {
        AffirmationList(affirmations = DataSources().loadAffirmations())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.padding(8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = affirmation.image),
                contentDescription = stringResource(
                    id = affirmation.title
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = affirmation.title),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun AffirmationList(
    affirmations: List<Affirmation>
) {
    LazyColumn {
        items(affirmations) {affirmation ->
            AffirmationCard(affirmation = affirmation)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAffirmationCard() {
    AffirmationsTheme {
        AffirmationCard(affirmation = DataSources().loadAffirmations()[0])
    }
}
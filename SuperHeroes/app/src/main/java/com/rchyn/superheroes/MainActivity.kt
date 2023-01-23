package com.rchyn.superheroes

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rchyn.superheroes.data.DataSources
import com.rchyn.superheroes.model.Hero
import com.rchyn.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SuperHeroesApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroesApp() {
    SuperHeroesTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    }
                )
            },
            content = { innerPadding ->
                SuperHeroesList(heroes = DataSources.heroes, innerPadding)
            }
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SuperHeroesList(heroes: List<Hero>, paddingValues: PaddingValues) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
        ),
        exit = fadeOut()
    ) {
        LazyColumn(contentPadding = paddingValues) {
            itemsIndexed(heroes) { index, hero ->
                SuperHeroesItem(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = StiffnessVeryLow,
                                    dampingRatio = DampingRatioLowBouncy
                                ),
                                initialOffsetY = { it * (index + 1) }
                            )
                        ),
                    hero = hero
                )
            }
        }
    }
}

@Composable
fun SuperHeroesItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            SuperHeroesInformation(
                titleRes = hero.titleRes,
                descriptionRes = hero.descriptionRes,
                modifier = modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            SuperHeroesIcon(imageResourceId = hero.imageRes, titleRes = hero.titleRes)
        }
    }
}

@Composable
fun SuperHeroesIcon(
    @DrawableRes imageResourceId: Int,
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageResourceId),
        contentDescription = stringResource(id = titleRes),
        modifier = modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun SuperHeroesInformation(
    @StringRes titleRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = titleRes),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = descriptionRes),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun PreviewSuperHeroesLightTheme() {
    SuperHeroesTheme(darkTheme = false) {
        SuperHeroesApp()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewSuperHeroesDarkTheme() {
    SuperHeroesTheme(darkTheme = true) {
        SuperHeroesApp()
    }
}
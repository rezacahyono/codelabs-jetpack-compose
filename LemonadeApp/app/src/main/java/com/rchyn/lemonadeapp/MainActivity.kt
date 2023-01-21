package com.rchyn.lemonadeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rchyn.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {

            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var lemonSqueeze by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> LemonadeWithTextAndImage(
                textResource = R.string.task_1,
                imageResource = R.drawable.lemon_tree,
                onClickItem = {
                    lemonSqueeze = (2..4).random()
                    currentStep = 2
                }
            )
            2 -> LemonadeWithTextAndImage(
                textResource = R.string.task_2,
                imageResource = R.drawable.lemon_squeeze,
                onClickItem = {
                    lemonSqueeze -= 1
                    if (lemonSqueeze <= 0) {
                        currentStep = 3
                    } else {
                        Toast.makeText(context, "Lemon $lemonSqueeze", Toast.LENGTH_SHORT).show()
                    }
                }
            )
            3 -> LemonadeWithTextAndImage(
                textResource = R.string.task_3,
                imageResource = R.drawable.lemon_drink,
                onClickItem = { currentStep = 4 })
            4 -> LemonadeWithTextAndImage(
                textResource = R.string.task_4,
                imageResource = R.drawable.lemon_restart,
                onClickItem = { currentStep = 1 }
            )
        }
    }
}

@Composable
fun LemonadeWithTextAndImage(
    textResource: Int,
    imageResource: Int,
    onClickItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = textResource),
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(105, 205, 216),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable { onClickItem() }
        )
    }
}


@Preview
@Composable
fun PreviewLemonadeApp() {
    LemonadeApp()
}
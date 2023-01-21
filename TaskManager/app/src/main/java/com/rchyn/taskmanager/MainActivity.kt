package com.rchyn.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rchyn.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StatusTask(
                        icon = R.drawable.ic_task_completed,
                        titleStatus = stringResource(id = R.string.title_task_status_complete),
                        descriptionStatus = stringResource(
                            id = R.string.desc_task_status_complete
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun StatusTask(@DrawableRes icon: Int, titleStatus: String, descriptionStatus: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp),
            text = titleStatus,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = descriptionStatus,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun PreviewStatusTask() {
    TaskManagerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StatusTask(
                icon = R.drawable.ic_task_completed,
                titleStatus = stringResource(id = R.string.title_task_status_complete),
                descriptionStatus = stringResource(
                    id = R.string.desc_task_status_complete
                )
            )
        }
    }
}


package com.example.newjetpack.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.newjetpack.R


@Composable
fun DialogBox() {
    val isAlertDialogOpen = remember {
        mutableStateOf(false)
    }
    val isMinimalOpen = remember {
        mutableStateOf(false)
    }
    val isImageDialogOpen = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            isAlertDialogOpen.value = !isAlertDialogOpen.value
        }) {
            Text(text = "Alert Dialog")
        }
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Button(onClick = {
            isMinimalOpen.value = !isMinimalOpen.value
        }) {
            Text(text = "Minimal Dialog")
        }
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Button(onClick = {
            isImageDialogOpen.value = !isImageDialogOpen.value
        }) {
            Text(text = "Image Dialog")
        }
    }

    when {
        isAlertDialogOpen.value -> {
            AlertDialogBox(
                onDismissRequest = {
                    isAlertDialogOpen.value = false
                },
                onConfirmation = {
                    isAlertDialogOpen.value = false
                },
                dialogTitle = "Alert Dialog Box",
                dialogText = "This is an example of an Alert Dialog Box",
                icon = Icons.Filled.Info
            )
        }

        isMinimalOpen.value -> {
            MinimalDialogBox(
                onDismissRequest = {
                    isMinimalOpen.value = false
                },
                dialogText = "This is an example of an Minimal Dialog Box",
            )
        }

        isImageDialogOpen.value -> {
            ImageDialogBox(
                onDismissRequest = {
                    isImageDialogOpen.value = false
                },
                onConfirmation = {
                    isImageDialogOpen.value = false
                },
                dialogText = "This is a dialog with buttons and an image.",
                image = R.drawable.android_pic
            )
        }
    }
}

@Composable
fun ImageDialogBox(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogText: String,
    image: Int,
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                )
                Text(
                    text = dialogText,
                    modifier = Modifier.padding(16.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Dismiss")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}

@Composable
fun MinimalDialogBox(
    onDismissRequest: () -> Unit,
    dialogText: String,
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = dialogText,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun AlertDialogBox(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        icon = {
            Icon(imageVector = icon, contentDescription = "information")
        },
    )
}

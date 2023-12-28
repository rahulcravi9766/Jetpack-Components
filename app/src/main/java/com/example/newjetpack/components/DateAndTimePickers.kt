package com.example.newjetpack.components

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newjetpack.R
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import com.vanpra.composematerialdialogs.title
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatePickers(context: Context) {
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    var pickedTime by remember {
        mutableStateOf(LocalTime.now())
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("MMM dd yyyy")
                .format(pickedDate)
        }
    }
    val formattedTime by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("hh:mm")
                .format(pickedTime)
        }
    }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = formattedDate.toString(), fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = { dateDialogState.show() }
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Pick the date",
                modifier = Modifier.size(
                    ButtonDefaults.IconSize
                ),
                tint = Color.White
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Date")
        }

        Spacer(modifier = Modifier.padding(32.dp))
        Text(text = formattedTime.toString(), fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = { timeDialogState.show() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                contentDescription = "Pick the time",
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Time")
        }

        MaterialDialog(dialogState = dateDialogState, buttons = {
            positiveButton(text = "Okay") {
                Toast.makeText(context, "Clicked Okay", Toast.LENGTH_SHORT).show()
            }
            negativeButton(text = "Cancel")
        }) {
            datepicker(
                initialDate = LocalDate.now(),
                title = "Pick a date",
                allowedDateValidator = { date ->
                    date >= LocalDate.now()
                }
            ) {
                pickedDate = it
            }
        }

        MaterialDialog(dialogState = timeDialogState, buttons = {
            positiveButton(text = "Okay") {
                Toast.makeText(context, "Clicked Okay", Toast.LENGTH_SHORT).show()
            }
            negativeButton(text = "Cancel")
        }) {
            timepicker(
                initialTime = LocalTime.NOON,
                title = "Pick a time",
               // timeRange = LocalTime.MIDNIGHT..LocalTime.NOON
            ) {
                pickedTime = it
            }
        }
    }
}


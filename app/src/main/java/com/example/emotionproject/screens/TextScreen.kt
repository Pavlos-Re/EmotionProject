package com.example.emotionproject.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.emotionproject.R
import com.example.emotionproject.components.NewButton
import com.example.emotionproject.components.NewInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextScreen(
    modifier: Modifier,
    newViewModel: NewViewModel,
    onBackButtonClicked: () -> Unit,
) {

    var description by remember {
        mutableStateOf("")
    }

    var mainEmotion by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(
        modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Info, contentDescription = "Info Icon")
        })

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            NewInputText(modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = description,
                label = "Share us your thoughts!",
                onTextChange = {
                    if (it.all { char ->
                            char.isDefined()
                        }) description = it
                })

            NewButton(text = "Save",
                onClick = {
                    if (description.isNotEmpty()) {
                        newViewModel.description.value = description
                        description = ""
                        Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                        newViewModel.run()
                    }
                })

            Text(text = "You are feeling: $description", modifier = Modifier.padding(top = 10.dp))

            Text(text = "Your main emotion is: ${mainEmotion}").also {
                mainEmotion = newViewModel.mainEmotion.collectAsState().value
            }

        }
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Button(onClick = { onBackButtonClicked() }) {
                Text(text = "Back")
            }
        }
    }

}

package com.icosane.meconopsis


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Import for Color
import androidx.compose.ui.res.painterResource // Import for painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface // Import for Surface
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TabRow
import androidx.compose.material3.Tab
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.animation.animateContentSize
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.platform.LocalDensity

@Composable
@Preview
fun App() {
    MaterialTheme {
        // Set the background color to black
        Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {
            var currentScreen by remember { mutableStateOf(Screen.Selection) }
            var selectedItem by remember { mutableStateOf("") }

            when (currentScreen) {
                Screen.Selection -> SelectionScreen(
                    onSelect = { item ->
                        selectedItem = item
                        currentScreen = Screen.Instructions
                    }
                )
                Screen.Instructions -> InstructionsScreen(
                    selectedItem = selectedItem,
                    onContinue = {
                        // Run your code here
                        // After code execution, navigate to the main screen
                        currentScreen = Screen.Main
                    }
                )
                Screen.Main -> MainScreen(selectedItem)
            }
        }
    }
}

enum class Screen {
    Selection,
    Instructions,
    Main
}

@Composable
fun SelectionScreen(onSelect: (String) -> Unit) {
    val platform = getPlatform()

    if (platform.name == "Android") {
        // Use Column for Android
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Text is always on top
            Text("Select an option:", color = Color.White)

            // Options as buttons in a Column
            val options = listOf("Genshin", "Star Rail", "ZZZ", "Wuwa")
            options.forEach { option ->
                Button(
                    onClick = { onSelect(option) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
                ) {
                    Text(option)
                }
            }
        }
    } else if (platform.name == "Windows") {
        // Use Column for Windows
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Text is always on top
            Text("Select an option:", color = Color.White)

            // Options as buttons in a Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val options = listOf("Genshin", "Star Rail", "ZZZ", "Wuwa")
                options.forEach { option ->
                    Button(
                        onClick = { onSelect(option) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier.padding(4.dp) // Optional: Add some padding between buttons
                    ) {
                        Text(option)
                    }
                }
            }
        }
    }
}


@Composable
fun InstructionsScreen(selectedItem: String, onContinue: () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display different instructions based on the selected item
        val instructions = when (selectedItem) {
            "Genshin" -> "Open the wish history and wait for it to load \n \n When you are ready press [Continue]"
            "Star Rail" -> "Instructions for Star Rail: Make sure to do the following..."
            "ZZZ" -> "Instructions for ZZZ: Here are the guidelines..."
            "Wuwa" -> "Instructions for Wuwa: Follow these instructions..."
            else -> "No instructions available."
        }

        // Display the instructions text
        Text(instructions, color = Color.White)

        // Add padding between the text and the button
        Spacer(modifier = Modifier.height(16.dp)) // Add a Spacer for padding

        // Continue button
        Button(
            onClick = onContinue,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun MainScreen(selectedItem: String) {
    val options = listOf("Genshin", "Star Rail", "ZZZ", "Wuwa")
    var currentIndex by remember { mutableStateOf(options.indexOf(selectedItem)) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Animated Tabs
        TabRow(
            selectedTabIndex = currentIndex,
            containerColor = Color.Black, // Match the app background
            contentColor = Color.White // Tab text color
        ) {
            options.forEachIndexed { index, option ->
                Tab(
                    selected = currentIndex == index,
                    onClick = { currentIndex = index },
                    text = { Text(option) },
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp)) // Rounded corners
                        .background(if (currentIndex == index) Color.Gray else Color.Transparent) // Change background color when selected
                )
            }
        }

        // Display the content based on the current index
        Spacer(modifier = Modifier.height(16.dp)) // Add some space between tabs and content
        when (options[currentIndex]) {
            "Genshin" -> Text("Genshin Impact Content", color = Color.White)
            "Star Rail" -> Text("Star Rail Content", color = Color.White)
            "ZZZ" -> Text("ZZZ Content", color = Color.White)
            "Wuwa" -> Text("Wuwa Content", color = Color.White)
        }
    }
}








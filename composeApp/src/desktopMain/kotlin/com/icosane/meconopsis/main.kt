package com.icosane.meconopsis

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

import kotlinx.serialization.json.Json
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import java.io.File
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.nio.charset.Charset
import java.nio.file.Paths
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import java.util.regex.Pattern

import com.icosane.meconopsis.GachaWish

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })  // Using kotlinx.serialization
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "meconopsis",
    ) {
        App()
    }
    println("1. Open Genshin Impact on your PC")
}
package com.icosane.meconopsis

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


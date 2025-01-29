package com.icosane.meconopsis

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Windows"
}
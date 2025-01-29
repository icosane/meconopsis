package com.icosane.meconopsis

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}


actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Android"
}
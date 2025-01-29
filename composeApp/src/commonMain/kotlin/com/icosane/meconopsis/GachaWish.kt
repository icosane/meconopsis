package com.icosane.meconopsis
import kotlinx.serialization.Serializable

class GachaWish {
    @Serializable
    data class GachaWish(
        val gachaType: Int,
        val time: String,
        val name: String,
        val itemType: String,
        val rankType: String
    )

    val banners = mapOf(
        100 to "Beginners' Wish",
        200 to "Standard",
        301 to "Character Event",
        302 to "Weapon Event"
    )
}
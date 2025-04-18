package com.andiniaulia3119.dapurku.data.model

data class Recipe(
    val id: Long = System.currentTimeMillis(),
    val name: String,
    val type: String,
    val description: String
)

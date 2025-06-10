package com.andiniaulia3119.mobpro1.model

data class Resep(
    val recipeId: Int,
    val userEmail: String,
    val nama: String,
    val deskripsi: String,
    val kategori: String,
    val imageId: String,
    val deleteHash: String,
    val createdAt: String
)

data class ResepCreate(
    val userEmail: String,
    val nama: String,
    val deskripsi: String,
    val kategori: String = "",
    val imageId: String,
    val deleteHash: String
)

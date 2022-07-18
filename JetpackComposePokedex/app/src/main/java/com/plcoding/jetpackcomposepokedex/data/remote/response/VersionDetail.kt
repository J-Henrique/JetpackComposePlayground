package com.plcoding.jetpackcomposepokedex.data.remote.response


import com.google.gson.annotations.SerializedName

data class VersionDetail(
    val rarity: Int,
    val version: Version
)
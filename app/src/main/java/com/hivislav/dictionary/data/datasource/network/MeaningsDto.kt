package com.hivislav.dictionary.data.datasource.network

import com.google.gson.annotations.SerializedName

class MeaningsDto(
    @field:SerializedName("translation") val translation: TranslationDto?,
    @field:SerializedName("imageUrl") val imageUrl: String?
)
package com.hivislav.dictionary.data.datasource.network

import com.google.gson.annotations.SerializedName

class TranslationDto(
    @field:SerializedName("text") val translation: String?
    )

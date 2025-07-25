package com.example.factostan.feature.settings.domain


data class Settings(
    val language: Language = Language.ENGLISH,
)


enum class Language(val isoFormat: String) {
    POLISH("pl"),
    ENGLISH("en");

    override fun toString(): String {
        return when(this) {
            POLISH -> "pl"
            ENGLISH -> "en"
        }
    }

    fun getOriginName(): String {
        return when(this) {
            POLISH -> "Polski"
            ENGLISH -> "English"
        }
    }

    companion object {
        fun fromString(isoFormat: String): Language? {
            return when (isoFormat) {
                "pl" -> POLISH
                "en" -> ENGLISH
                else -> null
            }
        }
    }
}
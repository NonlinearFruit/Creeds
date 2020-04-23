package com.nonlinearfruit.creeds.main.models

data class MainMenuItem(
        val CreedTitle: String,
        val CreedYear: Int,
        val CreedOrigin: String,
        val IntentClass: Class<*>,
        val JsonFileId: Int
    ) { }

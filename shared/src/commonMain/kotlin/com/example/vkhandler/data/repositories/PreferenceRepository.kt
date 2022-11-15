package com.example.vkhandler.data.repositories

import com.russhwolf.settings.Settings

class PreferenceRepository(private val settings: Settings) {

    var token: String = TOKEN
        // get() = settings.getString(TOKEN_KEY, DEFAULT_STRING)
        // set(value) = settings.putString(TOKEN_KEY, value)

    var userId: String = USER_ID
        // get() = settings.getString(USER_ID_KEY, DEFAULT_STRING)
        // set(value) = settings.putString(USER_ID_KEY, value)

    fun clear() { settings.clear() }

    companion object {
        private const val DEFAULT_STRING = ""
        private const val TOKEN_KEY = "token_key"
        private const val USER_ID_KEY = "user_id_key"

        private const val USER_ID = "749802626"
        private const val TOKEN =
            "vk1.a.RgFFZlJtsPi1_sfiQb09f_q4t2Rd-HptYLbkxf1GD0Gi_NJiwYVtlEb6miiy_BSlORvOxSY9_WOqhJcTWbI2L9PgX4PiXUcmpFl8Aw_Uxj2lkHmEhaeUNbaupV1yH2W6Uz9bb6nGdhdK2evuibP5B2YE_5BpvcLaouVOOpVt9BE8jtNV-dWUqpcaLg0FnHh83ApdacPF-OG-c34pUyCRcw"

    }

}

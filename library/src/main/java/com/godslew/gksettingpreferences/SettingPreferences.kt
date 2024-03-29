package com.godslew.gksettingpreferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson

class SettingPreferences {
    private var dataStoreName = DataStoreName
    private val gson = Gson()
    private var sp : SharedPreferences

    constructor(ctx: Context) {
        sp = ctx.getSharedPreferences(dataStoreName, MODE_PRIVATE)
    }
    constructor(ctx: Context, optionalStoreName : String) {
        dataStoreName = optionalStoreName
        sp = ctx.getSharedPreferences(dataStoreName, MODE_PRIVATE)
    }

    companion object {
        private const val DataStoreName = "SettingStore"
    }

    fun save(saveStoreName : String, data : SettingDataType) {
        val json = gson.toJson(data)

        val e = sp.edit()
        e.putString(saveStoreName, json)
        e.apply()
    }

    fun <T : SettingDataType> load(loadStoreName: String, data : Class<T>) : T? {
        val json = sp.getString(loadStoreName, "") ?: ""
        if (json.isEmpty()) {
            return null
        }
        return gson.fromJson(json, data)
    }
}
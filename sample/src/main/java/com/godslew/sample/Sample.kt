package com.godslew.sample

import android.app.Application
import com.godslew.gksettingpreferences.SettingPreferences

class Sample : Application() {
    lateinit var sp : SettingPreferences
    override fun onCreate() {
        super.onCreate()
        sp = SettingPreferences(this)
    }
}
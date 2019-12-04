package com.godslew.sample

import com.godslew.gksettingpreferences.SettingDataType

data class SettingData(
    val isSoundOn : Boolean,
    val voiceVolume: Int,
    val bgmVolume : Int,
    val seVolume : Int
) : SettingDataType {
    companion object {
        fun initialize() : SettingData {
            return SettingData(
                isSoundOn = true,
                voiceVolume = 50,
                bgmVolume = 50,
                seVolume = 50
            )
        }
    }
}
package com.godslew.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.godslew.sample.databinding.ActivitySettingBinding

class SettingsActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySettingBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setup()
    }

    private fun setup() {
        val setting = (application as Sample).sp.load(SoundSettingStore, SettingData::class.java) ?: SettingData.initialize()
        with(binding) {
            soundSwitch.isChecked = setting.isSoundOn
            voiceSeekBar.progress = setting.voiceVolume
            bgmSeekBar.progress = setting.bgmVolume
            seSeekBar.progress = setting.seVolume

            button.setOnClickListener {
                val s = setting.copy(isSoundOn = soundSwitch.isChecked,
                    voiceVolume = voiceSeekBar.progress,
                    bgmVolume = bgmSeekBar.progress,
                    seVolume = seSeekBar.progress
                    )
                (application as Sample).sp.save(SoundSettingStore, s)
            }
        }
    }

    companion object {
        private const val SoundSettingStore = "sound_setting"
    }
}
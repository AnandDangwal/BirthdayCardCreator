package com.example.birthdaywishingapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.appcompat.widget.SwitchCompat
import com.example.birthdaywishingapp.databinding.ActivityBirthdayGreetingBinding

class BirthdayGreetingActivity : AppCompatActivity() {
    private lateinit var bindingSecond: ActivityBirthdayGreetingBinding
    private var player : MediaPlayer? = null

    //Creating static variable
    companion object {
        const val USER_NAME = "UserName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSecond = ActivityBirthdayGreetingBinding.inflate(layoutInflater)
        setContentView(bindingSecond.root)

        val name = intent.getStringExtra(USER_NAME)
        val switch = bindingSecond.scPlayOrStop

        //Creating a message.
        bindingSecond.tvGreetingMessage.text = "Happy Birthday $name"

        //Playing music.
        player = MediaPlayer.create(this , R.raw.song2)
        player?.isLooping = true
        player?.start()

        //Switching Music On or Off.
        switch.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                if(!player!!.isPlaying) {
                    player?.seekTo(0)
                    player?.start()
                }
            }
            else{
                if(player!!.isPlaying) {
                    player?.pause()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
        player = null
    }


}
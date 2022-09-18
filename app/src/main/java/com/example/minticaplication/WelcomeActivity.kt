package com.example.minticaplication

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.minticaplication.databinding.ActivityWelcomeBinding
import java.util.*

class WelcomeActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.welcomeAnimation.playAnimation()
        binding.welcomeAnimation.addAnimatorListener(object: Animator.AnimatorListener  {
            override fun onAnimationStart(p0: Animator?) {

            }
            override fun onAnimationEnd(animation: Animator?) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }

        } )
    }
}
package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // var Counter :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //var counter = (1000 .. 9999).random()

        var vm = ViewModelProvider(this).get(ViewModelClass::class.java)

        vm.getLiveCounter().observe(this) {
            randText.text = "" + it
        }
        // randText.setText("" + vm.getLiveCounter().value)
        PlusBtn.setOnClickListener() {
            //randText.text = "" + vm.increament()
            vm.increamentLive().observe(this,{randText.text = ""+it})
        }
        MnsBtn.setOnClickListener() {
           // randText.text = "" + vm.decreament()
            vm.decreamentLive().observe(this,{randText.text = ""+it})
        }

        vm.timer()
        vm.getTimer().observe(this) {
            timerfield.text = "" + it
        }
        vm.getFinished().observe(this) {
            if (it) {
                timerfield.text = "Boom"
            }
        }
    }
}



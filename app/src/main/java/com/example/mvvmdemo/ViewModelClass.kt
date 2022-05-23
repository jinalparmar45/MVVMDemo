package com.example.mvvmdemo

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ViewModelClass: ViewModel()  {

    //private var count = (1000 .. 9999).random();
    private var timer  = MutableLiveData<Int>()
    private var Finished = MutableLiveData<Boolean>()
    private var Started = true
    private val CountLive : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>((1000 .. 9999).random())
    }


    fun getLiveCounter() :LiveData<Int>{
        return CountLive;
    }
    fun increamentLive():LiveData<Int>{
        CountLive.value = 1 + CountLive.value!!;
        return  CountLive
    }
//    fun getCounter():Int{
//        return count
//    }

//    fun setCounter(count: Int){
//        this.count = count
//    }

    fun getTimer(): LiveData<Int> {
        return this.timer
    }

    fun getFinished(): LiveData<Boolean>{
        return this.Finished;
    }
//    fun increament():Int{
//        return  ++count
//    }

//    fun decreament(): Int {
//        return  --count
//    }
    fun timer(){
        if(this.Started){
            this.Started = false

            object  : CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timer.value = (millisUntilFinished/1000).toInt()
                    Finished.value = false
                }
                override fun onFinish() {
                    Finished.value = true
                //TODO("Not yet implemented")
                }
            }.start()
        }

       // return millisUntilFinished;
    }

    fun decreamentLive(): LiveData<Int> {
        CountLive.value =  CountLive.value!! - 1;
        return  CountLive
    }


}

package com.example.androidinovation.daggerHilt_manually.classStore

import android.util.Log

class Car(private val engine: Engine,private val wheel: Wheel) {

    fun getCar()
    {
        engine.getEngine()
        wheel.getWheel()
        Log.d("main","CAr is Running..")
    }
}

class Engine{
    fun  getEngine()
    {
        Log.d("main","Engin Started..")

    }
}


class Wheel{
    fun  getWheel()
    {
        Log.d("main","Engin Started..")

    }
}
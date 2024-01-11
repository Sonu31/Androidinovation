package com.example.androidinovation.daggerHilt_manually.baseClass

import android.app.Application
import com.example.androidinovation.daggerHilt_manually.classStore.Car
import com.example.androidinovation.daggerHilt_manually.classStore.Engine
import com.example.androidinovation.daggerHilt_manually.classStore.Wheel

class BaseApp:Application() {
    var car = Car(Engine(), Wheel())
}
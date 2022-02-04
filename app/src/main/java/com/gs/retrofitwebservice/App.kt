package com.gs.retrofitwebservice

import android.app.Application
import com.airbnb.mvrx.Mavericks

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
package me.ilker.yet_another_kmp

import android.app.Application
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {

        }
    }
}

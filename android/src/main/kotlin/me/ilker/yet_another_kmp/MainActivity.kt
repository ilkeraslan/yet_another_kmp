package me.ilker.yet_another_kmp

import DietSDK
import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import me.ilker.yet_another_kmp.shared.cache.DatabaseDriverFactory

class MainActivity : ComponentActivity() {
    private val sdk = DietSDK(DatabaseDriverFactory(this))
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainScope.launch {
            val result = sdk.getDiets(true)
            println(result)
        }
    }
}

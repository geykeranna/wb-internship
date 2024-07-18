package ru.testtask.testapplication

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.testtask.testapplication.di.modules.appModule
import ru.testtask.testapplication.di.modules.dataModule
import ru.testtask.testapplication.di.modules.domainModules

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModules, dataModule))
        }
    }
}
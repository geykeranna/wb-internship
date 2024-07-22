package ru.wb.testapplication

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.wb.testapplication.modules.appModule
import ru.wb.repository.data.di.dataModule
import ru.wb.domain.di.domainModules

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
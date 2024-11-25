package ru.wb.repository.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.wb.repository.data.sharedpreferences.login.SharedPrefLoginStorage
import ru.wb.repository.data.sharedpreferences.user.SharedPrefUserStorage

val sharedPreferencesModules = module {
    singleOf(::SharedPrefUserStorage)
    singleOf(::SharedPrefLoginStorage)
}
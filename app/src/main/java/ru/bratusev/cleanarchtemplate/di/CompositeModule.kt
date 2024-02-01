package ru.bratusev.cleanarchtemplate.di

import org.koin.dsl.module

val compositeModule = module {
    includes(appModule, dataModule, domainModule)
}
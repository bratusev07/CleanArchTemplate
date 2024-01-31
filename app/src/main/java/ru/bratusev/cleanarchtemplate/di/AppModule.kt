package ru.bratusev.cleanarchtemplate.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.bratusev.cleanarchtemplate.presentation.MainViewModel

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
        )
    }
}
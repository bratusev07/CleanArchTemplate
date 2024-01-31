package ru.bratusev.cleanarchtemplate.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.bratusev.domain.models.SaveUserNameParam
import ru.bratusev.domain.usecase.GetUserNameUseCase
import ru.bratusev.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    var resultLive : LiveData<String> = resultLiveMutable

    fun saveData(text: String) {
        val params =
            SaveUserNameParam(firstName = text.split(' ')[0], lastName = text.split(' ')[1])
        resultLiveMutable.value = "Save result = ${saveUserNameUseCase.execute(param = params)}"
    }

    fun loadData() {
        val userName = getUserNameUseCase.execute()
        resultLiveMutable.value = "Hello, ${userName.firstName} ${userName.lastName}!"
    }
}
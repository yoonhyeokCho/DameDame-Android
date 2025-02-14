package com.yangbong.core_ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yangbong.core_ui.util.Event
import kotlinx.coroutines.CoroutineExceptionHandler
import java.security.cert.CertificateException

abstract class BaseViewModel : ViewModel() {

    private val _moveToLogin = MutableLiveData<Event<Boolean>>()
    val moveToLogin: LiveData<Event<Boolean>> = _moveToLogin

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is CertificateException -> _moveToLogin.postValue(Event(true))
        }
    }
}

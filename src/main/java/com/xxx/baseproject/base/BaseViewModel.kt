package com.vn.custom.activity.base

import androidx.lifecycle.MutableLiveData

class BaseViewModel {
    var showLoading: MutableLiveData<Boolean?> = MutableLiveData()
    var showDialogWarning: MutableLiveData<String?> = MutableLiveData()
    var showDialogThenAutoBack: MutableLiveData<String?> = MutableLiveData()

    private fun handleLoading(show: Boolean) {
        showLoading?.value = show
    }

    protected fun showLoading() {
        handleLoading(true)
    }

    protected fun hideLoading() {
        handleLoading(false)
    }

    protected fun showDialog(message: String?) {
        showDialogWarning?.value = message
    }

    protected fun showDialogThenAutoBack(message: String?) {
        showDialogThenAutoBack?.value = message
    }
}
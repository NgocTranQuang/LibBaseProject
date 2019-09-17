package com.vn.custom.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.vn.custom.dialog.DialogUtils

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getViewModel(): BaseViewModel?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observer()
    }


    private fun observer() {
        getViewModel()?.showLoading?.observe(this, Observer {
            if (it == true) {
                showLoading()
            } else {
                hideLoading()
            }
        })
        getViewModel()?.showDialogWarning?.observe(this, Observer {
            showDialog(it)
        })
        getViewModel()?.showDialogThenAutoBack?.observe(this, Observer {
            showDialog(it) {
                finish()
            }
        })
    }

    private fun hideLoading() {

    }

    private fun showLoading() {

    }


    fun showDialog(message: String?) {
        DialogUtils.showDialog(this, message)
    }

    fun showDialog(message: String?, listener: () -> Unit) {
        DialogUtils.showDialog(this, message, listener)
    }
}
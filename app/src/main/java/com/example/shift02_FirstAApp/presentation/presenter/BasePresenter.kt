package com.example.shift02_FirstAApp.presentation.presenter

import com.example.shift02_FirstAApp.presentation.UI.ViewContract

open class BasePresenter <View : ViewContract> {
    var view:View? = null

    fun attachView(view: View) {
        this.view = view
        onViewAttached()
    }

    open fun onViewAttached() {

    }

    fun detachView() {
        view = null
    }
}
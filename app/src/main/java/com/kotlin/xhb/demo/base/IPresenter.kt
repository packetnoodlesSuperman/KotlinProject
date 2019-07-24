package com.kotlin.xhb.demo.base

/**
 * 泛型
 *
 */
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}

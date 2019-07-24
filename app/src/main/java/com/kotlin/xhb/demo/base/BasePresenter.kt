package com.kotlin.xhb.demo.base

open class BasePresenter<T: IBaseView> : IPresenter<T> {

    /**
     * 当我们不想对外公开某个方法时，可以使用修饰符private实现，例如
     * 此 setter 是私有的并且有默认实现
     */
    var mRootView: T? = null
        private set



    override fun attachView(mRootView: T) {
        this.mRootView = mRootView
    }

    override fun detachView() {
        mRootView = null
    }


}
package com.kotlin.xhb

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<CVB: ViewDataBinding> : AppCompatActivity() {

    lateinit var viewDataBinding: CVB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView<CVB>(this, initContentView())
        initData()
    }

    abstract fun initData()

    abstract fun initContentView(): Int

}
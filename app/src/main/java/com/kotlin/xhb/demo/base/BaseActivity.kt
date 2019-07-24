package com.kotlin.xhb.demo.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initData()
    }

    abstract fun layoutId(): Int

    abstract fun initData()
}
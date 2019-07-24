package com.kotlin.xhb.demo

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class App : Application() {

    companion object {
        //notNull 适用于那些无法在初始化阶段就确定属性值的场合
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}
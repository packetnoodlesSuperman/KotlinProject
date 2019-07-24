package com.kotlin.xhb.demo.utils

import android.os.Build

class AppUtils private constructor(){

    init {
        throw Error("not need instantiate!")
    }

    companion object {

        fun getDeviceModel(): String {
            var model: String? = Build.MODEL
            /**
             * 这是一个高阶函数
             */
            model = model?.trim {
                it <= ' '
            } ?: ""

            return model
        }

    }

}
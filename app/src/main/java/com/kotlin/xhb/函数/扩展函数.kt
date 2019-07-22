package com.kotlin.xhb.函数

import android.widget.TextView

/**
 * 扩展函数 转换成java 就是一个final类， 将方法变成final static修饰
 */
fun TextView.isBold() = this.apply {
    paint.isFakeBoldText = true
}
package com.kotlin.xhb.okio

import kotlin.native.concurrent.ThreadLocal

/**
 * object 这个关键字定义一个类并同时创建一个实例（对象）
 * 使用场景
 * ·· 1. 对象声明是定义单例的一种方式
 *      2. 伴生对象可以持有工厂方法和其他与这个类相关，但在调用时并不依赖类实例的方法。他们的成员可以通过类名来访问
 *      3. 对象表达式用来替代Java的匿名内部类
 */
@ThreadLocal
internal object SegmentPool {

    var next: Segment? = null

    fun take(): Segment {
        synchronized(this) {
            next?.let {
                next = it.next
                it.next = null
            }
        }
        return Segment()
    }

    fun recycle(segment: Segment) {
        require(segment.next == null && segment.prev == null)

        if (segment.shared) return

        synchronized(this) {


            segment.next = next
            segment.limit = 0
            segment.pos = segment.limit
            next = segment
        }
    }

}
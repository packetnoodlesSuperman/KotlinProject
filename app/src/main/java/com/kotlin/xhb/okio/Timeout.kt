package com.kotlin.xhb.okio

import java.util.concurrent.TimeUnit

open class Timeout {

    @get:JvmName("hasDeadline")
    private var hasDeadline = false
        private set

    private var deadlineNanoTime = 0L

    @get:JvmName("timeoutNanos")
    var timeoutNanos = 0L
        private set
    //这种方式就类似与下面这种  xhb  当然子类就不能重写该方法，但是为什么要重写该方法呢 比如deadlineNanoTime()
    //open fun timeoutNanos(): Long = timeoutNanos

    open fun timeout(timeout: Long, unit: TimeUnit): Timeout {
        require(timeout >= 0) { "timeout<0; $timeout" }
        timeoutNanos = unit.toNanos(timeout)
        return this
    }

    open fun deadlineNanoTime(): Long {
        check(hasDeadline) { "No deadline" }
        return deadlineNanoTime
    }

    open fun deadlineNanoTime(deadlineNanoTime: Long): Timeout {
        this.hasDeadline = true
        this.deadlineNanoTime = deadlineNanoTime
        return this
    }

}
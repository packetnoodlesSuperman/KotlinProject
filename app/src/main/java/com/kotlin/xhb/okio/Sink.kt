package com.kotlin.xhb.okio

import java.io.Closeable
import java.io.Flushable

/**
 * 1. 写
 * 2. 刷新流
 * 3. 超时机制
 * 4. 关闭流
 */
interface Sink : Closeable, Flushable {

    @Throws(IOException::class)
    fun write(source: Buffer, byteCount: Long)

    @Throws(IOException::class)
    override fun flush()

    fun timeout(): Timeout

    @Throws(IOException::class)
    override fun close()
}
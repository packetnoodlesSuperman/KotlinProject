package com.kotlin.xhb.okio

import java.io.Closeable
import java.io.Flushable

interface Sink : Closeable, Flushable {

    @Throws(IOException::class)
    fun write(source: Buffer, byteCount: Long)

    @Throws(IOException::class)
    override fun flush()

    fun timeout(): Timeout

    @Throws(IOException::class)
    override fun close()
}
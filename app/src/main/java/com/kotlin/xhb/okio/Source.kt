package com.kotlin.xhb.okio

import java.io.Closeable

interface Source : Closeable {
    @Throws(IOException::class)
    fun read(sink: Buffer, byteCount: Long): Long

    /** Returns the timeout for this source.  */
    fun timeout(): Timeout

    /**
     * Closes this source and releases the resources held by this source. It is an error to read a
     * closed source. It is safe to close a source more than once.
     */
    @Throws(IOException::class)
    override fun close()
}
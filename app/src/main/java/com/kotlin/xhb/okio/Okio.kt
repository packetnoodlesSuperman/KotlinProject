@file:JvmName("Okio")
package com.kotlin.xhb.okio

import java.io.OutputStream

/**
 * BufferedSource source = Okio.buffer(Okio.source(in));
 * String s = source.readUtf8();  //以UTF-8读
 * System.out.println(s);     //打印
 * source.close();
 */

fun Source.buffer(): BufferedSource = RealBufferedSource(this)

fun Sink.buffer(): BufferedSink = RealBufferedSink(this)

fun OutputStream.sink(): Sink = OutputStreamSink(this, Timeout())

private class OutputStreamSink(private val out: OutputStream, private val timeout: Timeout) : Sink {
    override fun write(source: Buffer, byteCount: Long) {

        var remaining = byteCount
        while (remaining > 0) {

            val head = source.head!!
            val toCopy = minOf(remaining, head.limit.toLong() - head.pos.toLong()).toInt()
            out.write(head.data, head.pos, toCopy)

        }
    }

    override fun flush() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun timeout(): Timeout {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
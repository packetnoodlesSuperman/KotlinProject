package com.kotlin.xhb.okio

import java.io.Closeable
import java.io.EOFException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.nio.ByteBuffer
import java.nio.channels.ByteChannel
import java.nio.charset.Charset
import java.security.InvalidKeyException
import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class Buffer : BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @JvmField
    internal var head: Segment? = null

    var size: Long = 0L
        internal set

    override fun buffer() = this

    override val buffer
        get() = this

    override fun outputStream(): OutputStream {
        return object : OutputStream() {
            override fun write(b: Int) {
                writeByte(b)
            }

            override fun write(data: ByteArray, offset: Int, byteCount: Int) {
                this@Buffer.write(data, offset, byteCount)
            }

            override fun flush() {}
            override fun close() {}
            override fun toString(): String = "${this@Buffer}.outputStream()"
        }
    }

    internal fun writableSegment(minimumCapacity: Int): Segment {
        require(minimumCapacity >= 1 && minimumCapacity <= Segment.SIZE) {"unexpected capacity"}

        if (head == null) {
            // Acquire a first segment.
            val result = SegmentPool.take()
            //因为Koltin中赋值不是表达式，
            //result.prev = result.next = result  所以这样不允许 会报错
            head = result
            result.prev = result
            result.next = result
            return result
        }

        /**
         * 画图示意 一个环形的双链表  往中间插入，--> 最新插入的segment就是 head的prev
         */
        var tail = head!!.prev
        if (tail!!.limit + minimumCapacity > Segment.SIZE || !tail.owner) {
            //这个tail不够写
            tail = tail.push(SegmentPool.take())
        }
        return tail
    }

}
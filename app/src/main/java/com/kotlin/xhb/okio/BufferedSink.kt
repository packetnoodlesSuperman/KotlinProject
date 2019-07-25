package com.kotlin.xhb.okio


import java.io.IOException
import java.io.OutputStream
import java.nio.channels.WritableByteChannel
import java.nio.charset.Charset

interface  BufferedSink : Sink, WritableByteChannel {

    fun buffer(): Buffer

    val buffer: Buffer

    @Throws(IOException::class)
    fun write(byteString: ByteString): BufferedSink

    @Throws(IOException::class)
    fun write(source: ByteArray): BufferedSink

    @Throws(IOException::class)
    fun write(source: ByteArray, offset: Int, byteCount: Int): BufferedSink

    @Throws(IOException::class)
    fun writeAll(source: Source): Long

    @Throws(IOException::class)
    fun write(source: Source, byteCount: Long): BufferedSink

    @Throws(IOException::class)
    fun writeUtf8(string: String): BufferedSink

    @Throws(IOException::class)
    fun writeUtf8(string: String, beginIndex: Int, endIndex: Int): BufferedSink

    @Throws(IOException::class)
    fun writeUtf8CodePoint(codePoint: Int): BufferedSink

    @Throws(IOException::class)
    fun writeString(string: String, charset: Charset): BufferedSink

    @Throws(IOException::class)
    fun writeString(string: String, beginIndex: Int, endIndex: Int, charset: Charset): BufferedSink

    @Throws(IOException::class)
    fun writeByte(b: Int): BufferedSink

    @Throws(IOException::class)
    fun writeShort(s: Int): BufferedSink

    @Throws(IOException::class)
    fun writeShortLe(s: Int): BufferedSink

    @Throws(IOException::class)
    fun writeInt(i: Int): BufferedSink

    @Throws(IOException::class)
    fun writeIntLe(i: Int): BufferedSink

    @Throws(IOException::class)
    fun writeLong(v: Long): BufferedSink

    @Throws(IOException::class)
    fun writeLongLe(v: Long): BufferedSink

    @Throws(IOException::class)
    fun writeDecimalLong(v: Long): BufferedSink

    @Throws(IOException::class)
    fun writeHexadecimalUnsignedLong(v: Long): BufferedSink

    @Throws(IOException::class)
    override fun flush()

    @Throws(IOException::class)
    fun emit(): BufferedSink

    @Throws(IOException::class)
    fun emitCompleteSegments(): BufferedSink

    fun outputStream(): OutputStream

}
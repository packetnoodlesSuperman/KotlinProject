package com.kotlin.xhb.okio

import java.io.IOException
import java.io.InputStream
import java.nio.channels.ReadableByteChannel
import java.nio.charset.Charset

interface BufferedSource : Source, ReadableByteChannel {

    fun buffer(): Buffer

    val buffer: Buffer

    @Throws(IOException::class)
    fun exhausted(): Boolean

    @Throws(IOException::class)
    fun require(byteCount: Long)

    @Throws(IOException::class)
    fun request(byteCount: Long): Boolean

    @Throws(IOException::class)
    fun readByte(): Byte

    @Throws(IOException::class)
    fun readShort(): Short

    @Throws(IOException::class)
    fun readShortLe(): Short

    @Throws(IOException::class)
    fun readInt(): Int

    @Throws(IOException::class)
    fun readIntLe(): Int

    @Throws(IOException::class)
    fun readLong(): Long

    @Throws(IOException::class)
    fun readLongLe(): Long

    @Throws(IOException::class)
    fun readDecimalLong(): Long

    @Throws(IOException::class)
    fun readHexadecimalUnsignedLong(): Long

    @Throws(IOException::class)
    fun skip(byteCount: Long)

    @Throws(IOException::class)
    fun readByteString(): ByteString

    @Throws(IOException::class)
    fun readByteString(byteCount: Long): ByteString

    @Throws(IOException::class)
    fun select(options: Options): Int

    @Throws(IOException::class)
    fun readByteArray(): ByteArray

    @Throws(IOException::class)
    fun readByteArray(byteCount: Long): ByteArray

    @Throws(IOException::class)
    fun read(sink: ByteArray): Int

    @Throws(IOException::class)
    fun readFully(sink: ByteArray)

    @Throws(IOException::class)
    fun read(sink: ByteArray, offset: Int, byteCount: Int): Int

    @Throws(IOException::class)
    fun readFully(sink: Buffer, byteCount: Long)

    @Throws(IOException::class)
    fun readAll(sink: Sink): Long

    @Throws(IOException::class)
    fun readUtf8(): String

    @Throws(IOException::class)
    fun readUtf8(byteCount: Long): String

    @Throws(IOException::class)
    fun readUtf8Line(): String?

    @Throws(IOException::class)
    fun readUtf8LineStrict(): String

    @Throws(IOException::class)
    fun readUtf8LineStrict(limit: Long): String

    @Throws(IOException::class)
    fun readUtf8CodePoint(): Int

    @Throws(IOException::class)
    fun readString(charset: Charset): String

        @Throws(IOException::class)
    fun readString(byteCount: Long, charset: Charset): String

    @Throws(IOException::class)
    fun indexOf(b: Byte): Long

    @Throws(IOException::class)
    fun indexOf(b: Byte, fromIndex: Long): Long

    @Throws(IOException::class)
    fun indexOf(b: Byte, fromIndex: Long, toIndex: Long): Long

    @Throws(IOException::class)
    fun indexOf(bytes: ByteString): Long

    @Throws(IOException::class)
    fun indexOf(bytes: ByteString, fromIndex: Long): Long

    @Throws(IOException::class)
    fun indexOfElement(targetBytes: ByteString): Long

    @Throws(IOException::class)
    fun indexOfElement(targetBytes: ByteString, fromIndex: Long): Long

    @Throws(IOException::class)
    fun rangeEquals(offset: Long, bytes: ByteString): Boolean

    @Throws(IOException::class)
    fun rangeEquals(offset: Long, bytes: ByteString, bytesOffset: Int, byteCount: Int): Boolean

    fun peek(): BufferedSource

    fun inputStream(): InputStream

}
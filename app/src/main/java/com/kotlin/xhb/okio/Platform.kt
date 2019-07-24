@file:JvmName("Platform")
package com.kotlin.xhb.okio

internal fun String.asUtf8ToByteArray(): ByteArray = toByteArray(Charsets.UTF_8)

internal fun ByteArray.toUtf8String(): String = String(this, Charsets.UTF_8)

typealias ArrayIndexOutOfBoundsException = java.lang.ArrayIndexOutOfBoundsException

internal inline fun <R> synchronized(lock: Any, block: () -> R): R {
    return kotlin.synchronized(lock, block)
}

typealias IOException = java.io.IOException

typealias EOFException = java.io.EOFException
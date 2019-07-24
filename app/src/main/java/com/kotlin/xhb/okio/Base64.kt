@file:JvmName("Base64")
package com.kotlin.xhb.okio

import com.kotlin.xhb.okio.ByteString.Companion.encodeUtf8
import kotlin.jvm.JvmName

internal val BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".encodeUtf8().data

internal val BASE64_URL_SAFE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".encodeUtf8().data

internal fun String.decodeBase64ToArray(): ByteArray? {
    var limit = length
    while (limit > 0) {
        val c = this[limit -1]
        if (c != '=' && c != '\n' && c != '\r' && c != ' ' && c != '\t') {
            break
        }
        limit--
    }
    val out = ByteArray((limit * 6L / 8L).toInt())
    var outCount = 0
    var inCount = 0

    var word = 0
    for (pos in 0 until limit) {
        val c = this[pos]

        val bits: Int
        if (c in 'A'..'Z') {
            // char ASCII value
            //  A    65    0
            //  Z    90    25 (ASCII - 65)
            bits = c.toInt() - 65
        } else if (c in 'a'..'z') {
            // char ASCII value
            //  a    97    26
            //  z    122   51 (ASCII - 71)
            bits = c.toInt() - 71
        } else if (c in '0'..'9') {
            // char ASCII value
            //  0    48    52
            //  9    57    61 (ASCII + 4)
            bits = c.toInt() + 4
        } else if (c == '+' || c == '-') {
            bits = 62
        } else if (c == '/' || c == '_') {
            bits = 63
        } else if (c == '\n' || c == '\r' || c == ' ' || c == '\t') {
            continue
        } else {
            return null
        }

        word = word shl 6 or bits

        inCount++
        if (inCount % 4 == 0) {
            out[outCount++] = (word shr 16).toByte()
            out[outCount++] = (word shr 8).toByte()
            out[outCount++] = word.toByte()
        }
    }

    val lastWordChars = inCount % 4
    when (lastWordChars) {
        1 -> {
            return null
        }
        2 -> {
            word = word shl 12
            out[outCount++] = (word shr 16).toByte()
        }
        3 -> {
            word = word shl 6
            out[outCount++] = (word shr 16).toByte()
            out[outCount++] = (word shr 8).toByte()
        }
    }

    if (outCount == out.size) return out

    return out.copyOf(outCount)
}

internal fun ByteArray.encodeBase64(map: ByteArray = BASE64): String {
    val length = (size + 2) / 3 * 4
    val out = ByteArray(length)
    var index = 0
    val end = size - size % 3
    var i = 0
    while (i < end) {
        val b0 = this[i++].toInt()
        val b1 = this[i++].toInt()
        val b2 = this[i++].toInt()
        out[index++] = map[(b0 and 0xff shr 2)]
        out[index++] = map[(b0 and 0x03 shl 4) or (b1 and 0xff shr 4)]
        out[index++] = map[(b1 and 0x0f shl 2) or (b2 and 0xff shr 6)]
        out[index++] = map[(b2 and 0x3f)]
    }
    when (size - end) {
        1 -> {
            val b0 = this[i].toInt()
            out[index++] = map[b0 and 0xff shr 2]
            out[index++] = map[b0 and 0x03 shl 4]
            out[index++] = '='.toByte()
            out[index] = '='.toByte()
        }
        2 -> {
            val b0 = this[i++].toInt()
            val b1 = this[i].toInt()
            out[index++] = map[(b0 and 0xff shr 2)]
            out[index++] = map[(b0 and 0x03 shl 4) or (b1 and 0xff shr 4)]
            out[index++] = map[(b1 and 0x0f shl 2)]
            out[index] = '='.toByte()
        }
    }
    return out.toUtf8String()
}

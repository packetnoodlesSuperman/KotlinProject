package com.kotlin.xhb.okio

import java.io.Serializable


open class ByteString internal constructor(
        internal val data: ByteArray) : Serializable {

    @Transient internal var hashCode: Int = 0
    @Transient internal var utf8: String? = null

    companion object {

        @JvmStatic
        fun String.encodeUtf8(): ByteString {
            val byteString = ByteString(asUtf8ToByteArray())
            byteString.utf8 = this
            return byteString
        }

    }

}
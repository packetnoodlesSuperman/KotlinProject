package com.kotlin.xhb.okio

internal class RealBufferedSink(
        @JvmField
        val sink: Sink
) : BufferedSink {

    @JvmField
    val bufferField = Buffer()

    @JvmField
    var closed: Boolean = false

    /**
     * inline 这个关键字用于函数声明,表示这个函数的内联的,编译器在编译时会对这种函数进行优化
     *
     *  https://www.jianshu.com/p/70b20229827d
     * 把这个函数的函数体复制到所有调用到它的地方.形参也会被复制到这个方法内使用到的地方
     */
    override val buffer: Buffer
        inline get() = bufferField

    override fun buffer() = bufferField

    override fun write(source: Buffer, byteCount: Long) {
        check(!closed) { "closed" }

        buffer.write(source, byteCount)
        emitCompleteSegments()
    }

    override fun write(byteString: ByteString): BufferedSink {
        check(!closed) { "closed" }

        buffer.write(byteString)
        return emitCompleteSegments()
    }

    override fun writeUtf8(string: String): BufferedSink {
        check(!closed) {"closed"}

        buffer.writeUtf8(string)
        return emitCompleteSegments()
    }

}
package com.kotlin.xhb.okio

/**
 * 型变  out(协变)  in(逆变)  https://www.jianshu.com/p/0c2948f7e656
 *
 * out 相当于java里面的 <? extend>    ? extends T 表示上界是T
 *     out代表泛型类中，类型参数 T 只能存在于方法的返回值中，即是作为输出
 * in 相当于java里面的 <? super>      ? super T 表示下界是T
 *     in代表泛型类中，类型参数T只能存在于方法的参数中，即是作为输入
 *
 * 1. 如果你的类是将泛型作为内部方法的返回，那么可以用out
 *  interface Production<out T> {
 *      fun produce(): T
 *  }
 *
 * 2. 如果你的类是将泛型对象作为函数的参数，那么可以用 in
 *  interface Consumer<in T> {
 *      fun consume(item: T)
 *  }
 *
 */
class Options private constructor(
        internal val byteStrings: Array<out ByteString>,
        internal val trie: IntArray
) : AbstractList<ByteString>(), RandomAccess {

    override val size: Int
        get() = byteStrings.size

    override fun get(index: Int) = byteStrings[index]

    companion object {

//        @JvmStatic
//        fun of(vararg byteStrings: ByteString): Options {
//            if (byteStrings.isEmpty()) {
//                return Options(arrayOf(), intArrayOf(0, -1))
//            }
//        }

    }

}
package com.kotlin.xhb.函数


/**
 * @Desc 高阶函数
 */
class 高阶函数 {

    fun main(args: Array<String>) {
        var test1 = test1(1, 2, add = { a, b -> a + b })
        println(test1.toString())


        //forEach高阶函数的使用
        val list = listOf<Int>(1,2,3,4,5,6,7,8)
        /**
         * public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
         *      for (element in this) action(element)
         * }
         */
        list.forEach{
           println(it.toString())
        }

        /**
         * public inline fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {
         *      return mapTo(ArrayList<R>(collectionSizeOrDefault(10)), transform)
         * }
         */
        list.map {  }
    }

    fun test1(a: Int, b: Int, add: (Int, Int) -> Int): Int{
        var result = add(a, b)
        return result
    }

    //或者
    fun test2(a: Int, b: Int, add: (Int, Int) -> Int) = add(a, b);

}

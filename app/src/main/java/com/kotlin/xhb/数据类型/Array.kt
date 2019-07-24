package com.kotlin.xhb.数据类型

class Array {

    //已经固定长度
    //一旦创建 长度就固定
    var test = arrayOf(1, 10, 11)
    var testCopy = Array(4){0;1} //空间大小为4
    var testArray = intArrayOf(1, 2, 3)

    var test2 = arrayOf<Boolean>(true, false)
    var test2Copy = booleanArrayOf(true, false)

    var test3 = arrayOf<String>("s", "t", "y")
    var test4 = arrayOf(1, true, "String")  //类型推导出是  Array<Any>

    var intArray: IntArray = intArrayOf(1,2,3,4)
    var floatArray: FloatArray = floatArrayOf(1.0F, 2F)


    fun test(){
        //java.lang.ArrayIndexOutOfBoundsException: length=3; index=100
        test.set(100, 10)
    }
}
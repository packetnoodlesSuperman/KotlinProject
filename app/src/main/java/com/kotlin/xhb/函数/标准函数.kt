package com.kotlin.xhb.函数

class 标准函数 {

    //可见修饰符 fun(函数声明-关键字) 函数名（参数：参数类型 ···）：返回值 { 方法体 }
    //Kotlin默认为public 可见性修饰符
    //（）圆括号必须存在，即使是没有参数的情况
    fun main(args: Array<String>): Unit {

    }

    //单表达式函数 可以不需要大括号
    //即函数具备返回值的时候，可以省略花括号并且在=赋值 返回值编辑器可以自动推断
    fun main0(args: Array<String>) = "test"

    //如果函数有返回值 可以这样
    var a = main(arrayOf("test"))
    //成员函数的使用：先初始化对象，在根据对象使用`中缀符号(.)`调用其成员函数
    var b = 标准函数().main(arrayOf("test"))

    //返回值Unit类型  不需显示写成Unit
    fun unitFun(): Unit {
        println("unitFun")
        return Unit //或者return

        //return Unit 可省略 或者 return 可省略
    }

    /**
     * @Desc 函数的参数
     */
    //numB、numC 和 bool 为默认参数 具有默认值 可以减少函数的重载
    fun funArgs(numA: Int, numB: Float = 2f, numC: Float = 1f, bool: Boolean = false) {
        println()
    }

    //命名参数
    //使用命名参数我们可以使代码更具有可读性
    var arg = funArgs(1, numB = 2f )


    //可变数量参数
    //vararg修饰的变量相当于一个固定类型的数组
    fun varargFun(numA: Int, vararg str: String) {
        for (s in str) {
            println(s)
        }
    }
}
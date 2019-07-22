package com.kotlin.xhb.函数

class Lambda {

    //lambda的语法
    //Lambda表达式总是被大括号括着
    //其参数(如果存在)在 -> 之前声明(参数类型可以省略)
    //函数体(如果存在)在 -> 后面
    fun main1(args: Array<String>) {
        //无参数类型
        var test = { println() }

        //有参数的情况
        var test1 : (Int, Int) -> Int = {a, b -> a+b }
        var test2 = {a: Int, b: Int -> a + b}

        //lambda作为函数中的参数的时候
        val test3 = test3(1, {num1, num2 -> num1+num2 })
    }

    //Lambda表达式的本质其实是匿名函数，因为在其底层实现中还是通过匿名函数来实现
    /**
     * 当Lambda表达式作为其一个参数时，只为其表达式提供了参数类型与返回类型
     * 则此函数为高阶函数
     * 在调用此高阶函数的时候我们要为该Lambda表达式写出它的具体实现
     */
    fun test3(a: Int, b: (num1: Int, num2: Int) -> Int) : Int {
        return a + b.invoke(3, 5)
    }

    /**
     * 下划线 "_" 的使用
     * 在使用Lambda表达式的时候，可以用下划线(_)表示未使用的参数，表示不处理这个参数
     */




}
package com.kotlin.xhb.okhttp.internal

class Util {

    /**
     * 内联函数 --->
     *   被inline标记的函数就是内联函数,其原理就是:在编译时期,把调用这个函数的地方用这个函数的方法体进行替换
     *
     * 为什么要使用内联函数inline? <还是有点不太明天？？？？？？？>  https://www.jianshu.com/p/ab877fe72b40
     *     我们在写代码的时候难免会遇到这种情况,就是很多处的代码是一样的,于是乎我们就会抽取出一个公共方法来进行调用,
     *     这样看起来就会很简洁;但是也出现了一个问题,就是这个方法会被频繁调用,就会很耗费资源
     *     对于编译器来说，调用method方法就要将参数和lambda表达式{"我是body的方法体"}进行传递，
     *     就要将method方法进行压栈出栈处理，这个过程就会耗费资源。如果是很多地方调用,就会执行很多次,这样就非常消耗资源了.
     *     于是乎就引进了inline
     */
    inline fun threadName(name: String, block: () -> Unit): Unit {
        val currentThread = Thread.currentThread()
        val oldName = currentThread.name
        try {
            block()
        } finally {
            currentThread.name = oldName
        }
    }

}
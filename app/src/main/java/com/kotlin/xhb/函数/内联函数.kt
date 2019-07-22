package com.kotlin.xhb.函数

class 内联函数 {

    var name: String? = null
    var age: Int? = null

    //在Kotlin中，使用inline修饰符标记内联函数


    fun test() {
       var a =  with(内联函数()) {
            this.name = "name"
            this.age = 20
            return@with this
        }

        /**
         * public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()
         * 接收一个对象receiver和一个函数block
         * 函数体是用这个对象来执行函数receiver.block()，相当于对receiver扩展了block函数
         *
         * 注意：“T.() -> R”表示这个传入的函数是对T的扩展函数，所以在函数体中才可以receiver.block()
         * 如果改成“() -> R”则receiver.block()会报错，直接使用block()才行
         */
    }

}
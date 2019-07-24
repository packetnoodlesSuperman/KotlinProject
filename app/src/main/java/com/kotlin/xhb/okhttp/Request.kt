package com.kotlin.xhb.okhttp

class Request internal constructor(
        @get:JvmName("url")
        val url: HttpUrl,

        @get:JvmName("method")
        val method: String

){



    open class Builder {

        /**
         * Kotlin的构造函数
         *     Kotlin分主构造器(primary constructor)和次级构造器(secondary constructor)
         *
         *  第一种： class 类名 constructor(形参。。。) --> 这是主构造器
         *      init{} 作为初始化代码块，他的作用是为了primary constructor服务的，
         *      由于Primary Constructor是放置在类的首部，是不能包含任何初始化执行语句的，
         *      那么这个时候就有了init的用武之地，我们可以把初始化执行语句放置在此处，为属性进行赋值。
         *  第二种: class 类名 (形参。。。) --> 这是主构造器
         *      当constructor关键字没有注解和可见性修饰符作用于它时
         *      constructor关键字可以省略（当然，如果有这些修饰时，是不能够省略的，并且constructor关键字位于修饰符后面）
         *
         * 我们如果没有为其显式提供Primary Constructor，Kotlin编译器会默认为其生成一个无参主构造，这点和Java是一样的
         *
         *  下面是次级构造器
         *     在类体中（class body）
         *     Secondary Constructor可以有多个，而Primary Constructor只会有一个。
         *
         *    constructor(context: Context) : this(context, null)
         *    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, R.attr.buttonStyle)
         *    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
         *    次级构造器 可以继承自己 或者父类构造器
         */
        internal constructor(request: Request) {

        }

    }
}
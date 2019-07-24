package com.kotlin.xhb.okhttp

import com.kotlin.xhb.okhttp.internal.connection.Transmitter
import okhttp3.internal.threadName
import java.io.IOException
import java.util.concurrent.atomic.AtomicInteger


/**
 * 权限修饰符
 * private：只能在当前源文件内使用
 * internal：同一模块内  （同一个module）
 */
internal class RealCall private constructor(val client: OkHttpClient,
                                              val originalRequest: Request,
                                              val forWebSocket: Boolean  ) : Call {

    /**
     * 两种延迟初始化的方式
     *
     * lateinit var 只能用来修饰类属性，不能用来修饰局部变量，并且只能用来修饰对象，
     *              不能用来修饰基本类型(因为基本类型的属性在类加载后的准备阶段都会被初始化为默认值)。
     * lateinit var 的作用也比较简单，就是让编译期在检查时不要因为属性变量未被初始化而报错 后续在哪里以及何时初始化还需要开发者自己决定。
     *
     * 另外一个 by lazy //指定了延迟初始化时的行为 在属性被第一次被使用的时候能自动初始化
     *      by lazy 本身是一种属性委托。属性委托的关键字是by
     *      by lazy 要求属性声明为val，即不可变变量，在java中相当于被final修饰
     *      by lazy 可以使用于类属性或者局部变量
     *
     *   val name: Int by lazy { 1 }    //用于属性延迟初始化
     *
     *   public fun foo() {             //用于局部变量延迟初始化
     *      val bar by lazy { "hello" }
     *   }
     *
     */
    private lateinit var transmitter: Transmitter

    var executed: Boolean = false

    override fun request(): Request = originalRequest

    fun enqueue(responseCallback: Callback) {
        synchronized(this) {
            //require + check就是在做前置条件的检查，通过了才可以执行真正的程序逻辑
            //assert负责确保程序执行完毕后的结果/内部状态是否符合预期

            //equire(Boolean) throw IllegalArgumentException  负责检查输入的参数
            //check(Boolean) throw IllegalStateException  负责检查自身是否万事俱备可以执行了
            //assert(Boolean) throw AssertionError
            check(!executed) { "Already Executed" }
            executed = true
        }
        transmitter.callStart()
    }

    fun redactedUrl(): String? = null
//            = originalRequest.url.redact()

    @Throws(IOException::class)
    fun getResponseWithInterceptorChain() {

    }

    //内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数
    //没有被inner 修饰的内部类都是静态的
    internal inner class AsyncCall(private val responseCallback: Callback) : Runnable {

        @Volatile
        private var callsPerHost = AtomicInteger(0)

        fun callsPerHost(): AtomicInteger = callsPerHost

        fun get(): RealCall = this@RealCall

        override fun run() {
            /**
             * threadName 是Util的内联函数
             * ${} 是字符串模板
             */
            threadName("OkHttp ${redactedUrl()}") {
                var signalledCallback = false
                transmitter.timeoutEnter()

                val response = getResponseWithInterceptorChain()
            }
        }

    }

    companion object {
        fun newRealCall(client: OkHttpClient, originalRequest: Request, forWebSocket: Boolean): RealCall {

            /**
             * public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
             * 主要的作用：是可以用来简化初始化对象的功能
             *
             * T.apply():是这个T的扩展函数，意思是T支持apply()函数
             * (block:T.()->Unit):函数类型，但是和前面说的不大一样的地方就是T.()
             *       如果 不加T，例如(block:()->Unit)我们就很容易看出是个函数，T.()的意思是在T里面的函数
             *       T.()->Unit里的this代表的是自身实例，而()->Unit里，this代表的是外部类的实例
             *
             * ():T  :返回的是T
             * return this 表示 apply函数的返回值是本身
             *
             * 标准函数库 https://www.jianshu.com/p/a2d96d935bcd
             *      --- 不需要返回他自己 this
             *              --- 需要扩展函数
             *                     --- Send THIS
             *                          ··· T.run()
             *                     --- Send IT
             *                          ··· T.let()
             *              --- 不需要扩展函数
             *                     --- 将自己作为实参传递
             *                          ··· with()
             *                     --- 不将自己作为实参传递
             *                          ··· run()
             *      --- 需要返回他自己 this
             *           --- Send THIS
             *               ··· T.apply()
             *           --- Send IT
             *                ··· T.also()
             *
             */
            return RealCall(client, originalRequest, forWebSocket).apply {
                transmitter = Transmitter(client, this)
            }
        }
    }


}
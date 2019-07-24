package com.kotlin.xhb.okhttp

import java.net.Proxy
import java.net.ProxySelector
import java.util.Objects
import javax.net.SocketFactory
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSocketFactory

/**
 * 没有加val或者var，就相当于在该类中没有这个属性的, 不能使用的, 这个参数的作用就是,传递给父类的构造方法
 * 使用var 可以在类中使用,相当于 我们声明了一个该类中定义了一个private 的成员变量
 * val表示不让修改该参数 加上了final 修饰符
 */
class Address(

    uriHost: String,

    uriPost: Int,

    /**
     * 在java调用的时候 get方法命名 为dns
     */
    @get:JvmName("dns")
    val dns: String,

    @get:JvmName("sslSocketFactory")
    val sslSocketFactory: SSLSocketFactory?

) {


}
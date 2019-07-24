package com.kotlin.xhb.okhttp

import java.net.InetSocketAddress
import java.net.Proxy

class Route(

        @get:JvmName("address")
        val address: Address,

        @get:JvmName("proxy")
        val proxy: Proxy,

        @get:JvmName("socketAddress")
        val socketAddress: InetSocketAddress
) {

    fun requiresTunnel() = address.sslSocketFactory != null && proxy.type() == Proxy.Type.HTTP

}
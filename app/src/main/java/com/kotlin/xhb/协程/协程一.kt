package com.kotlin.xhb.协程
import kotlinx.coroutines.*
import java.lang.Thread

class 协程一 {
    val thread: Thread = Thread.currentThread()

    suspend fun main() = runBlocking(Dispatchers.Main){
        GlobalScope.launch(Dispatchers.Main) {


        }
    }

}
package com.kotlin.xhb.okhttp.internal.io

import okio.Sink
import okio.Source
import okio.source
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

interface FileSystem {

    companion object {

        val SYSTEM: FileSystem = object : FileSystem {
            @Throws(FileNotFoundException::class)
            override fun source(file: File): Source = file.source()

            override fun sink(file: File): Sink {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun appendingSink(file: File): Sink {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun delete(file: File) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun exists(file: File): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun size(file: File): Long {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun rename(from: File, to: File) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun deleteContents(directory: File) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }

    @Throws(FileNotFoundException::class)
    fun source(file: File): Source

    @Throws(FileNotFoundException::class)
    fun sink(file: File): Sink

    @Throws(FileNotFoundException::class)
    fun appendingSink(file: File): Sink

    @Throws(IOException::class)
    fun delete(file: File)

    fun exists(file: File): Boolean

    fun size(file: File): Long

    @Throws(IOException::class)
    fun rename(from: File, to: File)

    @Throws(IOException::class)
    fun deleteContents(directory: File)
}
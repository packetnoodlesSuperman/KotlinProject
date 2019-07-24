package com.kotlin.xhb.okhttp

import com.kotlin.xhb.okhttp.internal.io.FileSystem
import okio.Buffer
import okio.BufferedSink
import okio.BufferedSource
import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.encodeUtf8
import okio.ByteString.Companion.toByteString
import okio.ForwardingSink
import okio.ForwardingSource
import okio.Sink
import okio.Source
import okio.buffer
import java.io.Closeable
import java.io.File
import java.io.Flushable
import java.io.IOException
import java.security.cert.Certificate
import java.security.cert.CertificateEncodingException
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.util.NoSuchElementException
import java.util.TreeSet

class Cache internal constructor(
        directory: File,
        maxSiz: Long,
        fileSystem: FileSystem
){
}
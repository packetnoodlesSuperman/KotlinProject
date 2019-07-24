package com.kotlin.xhb.okhttp

class HttpUrl internal constructor(

        @get:JvmName("scheme")
        val scheme: String,

        @get:JvmName("username")
        val username: String
){


    companion object {
        private val HEX_DIGITS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
        internal const val USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#"

        /**
         * Java调用的静态方法
         */
        @JvmStatic
        fun defaultPort(scheme: String): Int {
            return when(scheme) {
                "http" -> 80
                "https" -> 443
                else -> -1
            }
        }

        //返回此路径段列表的路径字符串
        /**
         * 扩展函数可以在已有类中添加新的方法，不会对原类做修改
         * 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数
         */
        internal fun List<String>.toPathString(out: StringBuilder) {
            for (i in 0 until size) {
                //每个路径前拼接一个 路径分隔符
                out.append('/').append(this[i])
            }
        }

        internal fun List<String>.toQueryString(out: StringBuilder) {
            for (i in 0 until size step 2) {
                val name = this[i]
                val value = this[i+1]
                if (i > 0) out.append('&')
                out.append(name)
                if (value != null) {
                    out.append("=").append(value)
                }
            }
        }

    }
}
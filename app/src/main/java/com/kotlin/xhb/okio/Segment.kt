package com.kotlin.xhb.okio

internal class Segment {

    /**
     * 使用 @JvmStatic 和 @JvmField 注解，才能使它们暴露为静态方法或静态字段
     *
     * @JvmField 消除了变量的getter与setter方法 ···
     * @JvmField 修饰的变量不能是private属性的
     * @JvmStatic 只能在object类或者伴生对象companion object中使用，而@JvmField没有这些限制
     * @JvmStatic 一般用于修饰方法，使方法变成真正的静态方法；如果修饰变量不会消除变量的getter与setter方法，
     *             但会使getter与setter方法和变量都变成静态
     */
    @JvmField
    val data: ByteArray

    @JvmField
    var pos: Int = 0

    @JvmField
    var limit: Int = 0

    @JvmField
    var shared: Boolean = false

    @JvmField
    var owner: Boolean = false

    @JvmField
    var next: Segment? = null

    @JvmField
    var prev: Segment? = null

    constructor() {
        this.data = ByteArray(SIZE)
        this.owner = true
        this.shared = false
    }

    constructor(data: ByteArray, pos: Int, limit: Int, shared: Boolean, owner: Boolean) {
        this.data = data
        this.pos = pos
        this.limit = limit
        this.shared = shared
        this.owner = owner
    }

    fun sharedCopy(): Segment {
        shared = true
        return Segment(data, pos, limit, true, false)
    }

    fun unsharedCopy() = Segment(data.copyOf(), pos, limit, false, true)

    fun pop(): Segment? {
        val result = if (next != this) next else null
        /**
         * !! 非空断言
         */
        prev!!.next = next
        next!!.prev = prev
        next = null
        prev = null
        return result
    }

    /**
     * Segment 双向循环链表图
     * writableSegment()中  当获取第一个Segment的时候 return segment.next = segment.prev = segment; 自己一个形成双循环
     */
    fun push(segment: Segment): Segment {
        segment.prev = this
        segment.next = next
        next!!.prev = segment
        this.next = segment
        return segment
    }

    companion object {

        /**
         * const 必须修饰val
         * const 只允许在top-level级别和object中声明
         *
         * const val 可见性为public final static，可以直接访问
         * val 可见性为private final static  并且会生成方法get方法
         */
        const val SIZE = 8192

        const val SHARE_MINIMUM = 1024
    }

}
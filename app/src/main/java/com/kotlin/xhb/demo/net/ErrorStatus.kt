package com.kotlin.xhb.demo.net

/**
 * 将类的声明和定义该类的单例对象结合在一起（即通过object就实现了单例模式）
 * 即将class关键字替换为object关键字，来声明一个类，与此同时也声明它的一个对象。只要编写这么多代码，这个类就已经是单例的了
 *
 * object ErrorStatus的类最终被编译成：
 *    一个类拥有一个静态成员来持有对自己的引用，
 *    并且这个静态成员的名称为INSTANCE，当然这个INSTANCE是单例的
 *
 * 但是它不能包含构造器（包括主构造器以及次级构造器）
 *
 * object有两种使用场景 一种是对象表达式,另一种是 对象声明
 */
object ErrorStatus {

    /**
     * @JvmField 消除了变量的getter与setter方法 ···
     * @JvmField 修饰的变量不能是private属性的
     * @JvmStatic 只能在object类或者伴生对象companion object中使用，而@JvmField没有这些限制
     * @JvmStatic 一般用于修饰方法，使方法变成真正的静态方法；如果修饰变量不会消除变量的getter与setter方法，
     *             但会使getter与setter方法和变量都变成静态
     * https://blog.csdn.net/maosidiaoxian/article/details/81778057
     */
    @JvmField
    val SUCCESS = 0


}
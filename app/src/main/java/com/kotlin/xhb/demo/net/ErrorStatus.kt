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
     * @JvmField 将属性编译为Java变量  --> 编译成java代码后 就是 ErrorStatus.SUCCESS
     * @JvmStatic 将对象的方法编译成功Java静态方法  --> 编译成java代码后 就是 ErrorStatus.静态方法
     * https://blog.csdn.net/maosidiaoxian/article/details/81778057
     */
    @JvmField
    val SUCCESS = 0


}
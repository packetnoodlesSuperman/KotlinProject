package com.kotlin.xhb.类与对象

/**
 * 类属性修饰符（标示类本身特性 classModifier）
 * 1. abstract 抽象类
 * 2. final 不可以继承 默认属性
 * 3. enum  枚举类
 * 4. open 类可以继承
 * 5. annotation 注解类
 * //访问权限修饰符 （_accessModifier_）
 * 6. private   仅在同一个文件中可见
 * 7. protected 同一个文件中或子类可见
 * 8. public    所有调用的地方都可见  默认public
 * 9. internal  同一个模块中可见
 */
class 类 {

    //匿名内部类 使用对象表达式来创建匿名内部类
    /**
     * object 这个关键字定义一个类并同时创建一个实例（对象）
     * 使用场景
     *      1. 对象声明是定义单例的一种方式
     *      2. 伴生对象可以持有工厂方法和其他与这个类相关，但在调用时并不依赖类实例的方法。他们的成员可以通过类名来访问
     * ·· 3. 对象表达式用来替代Java的匿名内部类
     */
    var test = object : TestInterface {
        override fun test() {
        }
    }

    //这属于嵌套类
    class Person{}


    //内部类 用inner关键字表示
    //内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数
    inner class OtherPerson {}


    //接口
    interface TestInterface {
        fun test()
    }

    /**
     * 数据类
     * 只需要在class 前加上data 关键字就能定义一个实现了toString 、equals 及hashCode 方法的类——数据类
     */
    data class Client(val name: String, val code: Int)

    /**
     * 密封类  用sealed关键词修饰
     */
    sealed class PlayerCmd {

    }


    /**
     * 内联类
     */

    /**
     * 枚举类
     */

    /**
     * 类委托
     */

}
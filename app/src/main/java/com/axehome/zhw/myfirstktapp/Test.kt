package com.axehome.zhw.myfirstktapp

import android.support.constraint.solver.widgets.Rectangle
import android.util.Log
import java.util.*

/**
 * Created by Axehome_Mr.z on 2018/12/18 11:45
 * $Describe
 */

class Test {


    /*--------------------------------------------第一部分  -----------------------------------------------------------*/

    /**1定义函数   start*/

    //定义一个返回值为Int类型  带两个int类型参数的函数
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    //定义一个将表达式作为函数体，返回值类型自动推断的函数
    fun sum1(a: Int, b: Int) = a + b

    //定义一个返回值无意义的函数
    fun printSum(a: Int, b: Int): Unit {
        Log.e("aaa", "(Test.kotlin:21)<--sum of $a and $b is ${a + b}-->")
    }

    //定义一个省略无意义值的函数
    fun printSum1(a: Int, b: Int) {
        Log.e("aaa", "(Test.Kotlin:26)<--sum of $a and $b is ${a + b}-->")
    }
    /**定义函数  end*/


    /**2定义变量     start*/

    //定义只读变量使用关键字 val ，只能赋值一次
    val a: Int = 2//立即赋值
    val b = 2;//赋值自动推断是Int类型
    val c: Int = 0//没有初始值会编译错误

    //定义可重新赋值的变量使用var关键字
    var a1: Int = 2//立即赋值
    var b1 = 2//赋值后即可自动推断Int类型
    var c1: Int = 0//必须为有初始值
    //可重新赋值
    fun test1() {
        c1 += b1
    }
    /**定义变量     end*/

    /**3注释       start*/

    //这个是单行注释
    /*...这个是多行注释...*/
    /**注释       end*/

    /**4使用字符串模版      start*/

    var a3 = 1
    val s3 = "a3 is $a3"

    fun test3() {
        a3 = 2
        val s31 = "${s3.replace("is", "was")},but now is $a3"
    }
    /**使用字符串模版      end*/


    /**5使用条件表达式      start*/
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    //if作为表达式
    fun maxof1(a: Int, b: Int) = if (a > b) a else b
    /**使用条件表达式      end*/


    /** 6使用可空值及null检测     start */
    //如果string的内容不是数字返回null
    fun parseInt(string: String): Int? {
        return string.toInt()
    }

    //使用返回可空值的函数
    fun printProduct(str1: String, str2: String) {
        val x = parseInt(str1)
        val y = parseInt(str2)
        if (x != null && y != null) Log.e("aaa", "(kotlin.java:95)<--x=${x} and y=${y}-->")
        else Log.e("aaa", "(kotlin.java:96)<--either x == null or y == null-->")
    }
    /** 使用条件表达式     end*/


    /** 7使用类型检测及自动类型转换   start*/

    //is运算符检测一个表达式是否某类型的一个实例。如果一个不可变的局部变量或者属性已经判断出为某类型，那么检测出后的分支中可以直接当做某类型使用，无需进行显式转换
    fun getStringLength(obj: Any): Int? {
        if (obj is String) return obj.length
        else return null
    }

    fun getStringLength1(obj: Any): Int? {
        if (obj is String && obj.length > 0) return obj.length

        return null
    }
    /** 使用类型检测及自动类型转换   end*/


    /** 8使用各种循环  start*/
    //使用for循环
    val list = listOf<String>("apple", "banana", "kiwifruit")
    val listInt = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    fun test8a() {
        for (item in list)
            println(item)
    }

    fun test8b() {
        for (index in list.indices) println("item at $index is ${list[index]}")
    }

    //使用while循环
    fun whileTest8a() {
        var index = 0
        while (index < list.size) {
            println("item at $index is ${list[index]}")
        }
    }

    //使用when表达式
    fun whenTest8a(obj: Any) {
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }
    }
    /** 使用各种循环  end*/

    /** 9使用区间（rang）  start */
    //使用in运算符来检测某个数字是否在指定的区间内
    fun test9rang() {
        val x = 10
        val y = 9
        if (x in 0..y + 1) Log.e("aaa", "(kotlin.java:154)<-- x=$x 在 0到${y + 1} 的区间内-->")
        else Log.e("aaa", "(kotlin.java:155)<--x=$x not in 0-${y + 1}-->")
    }

    //检测某个数字是否在指定区间外
    fun test9noinrang() {
        val x = 6
        if (x !in 0..6) Log.e("aaa", "(kotlin.java:160)<--不在-->")
        else Log.e("aaa", "(kotlin.java:161)<--在-->")
        val list = listOf("a", "b", "c", "d")

        if (-1 !in 0..list.lastIndex) Log.e("aaa", "(kotlin.java:165)<--not in -->")
        if (list.size !in list.indices) Log.e("aaa", "(kotlin.java:166)<--not in -->")
    }

    //区间迭代
    fun test9forrang() {
        for (x in 0..100) Log.e("aaa", "(kotlin].java:171)<--$x-->")
    }

    //数列迭代
    fun test9forarray() {
        for (x in 0..100 step 3) Log.e("aaa", "(kotlin.java:175)<--$x-->")
        for (x in 100 downTo 0 step 2) Log.e("aaa", "(kotlin.java:176)<--$x-->");
    }
    /** 使用区间（rang）  end */


    /** 10使用集合       start*/

    //对集合进行迭代
    fun test10forlist() {
        for (item in list) Log.e("aaa", "(kotlin.java:186)<--$item-->")

        when {
            "orange" in list -> Log.e("aaa", "(kotlin.java:189)<--bu zai-->")
            "apple" in list -> Log.e("aaa", "(kotlin.java:190)<--zai-->")
        }

        val fruitlist = listOf<String>("apple", "banana", "avocado", "kiwifruit", "orange")

        fruitlist
                .filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { Log.e("aaa", "(kotlin.java:199)<--$it-->"); }
    }
    /** 使用集合       end*/

    /** 11创建基本类及其实例   start*/
    val rectangle = MainActivity.Rectangle(5.0, 6.0)
    /** 创建基本类及其实例   end*/


    /*------------------------------------第二部分-------------------------------------------------------------------*/

    /** 1创建DTOs（POJOs/POCOs） */
    data class Cutomer(val name: String, val email: String)

    /** 2函数的默认参数 */
    fun foo(a: Int = 0, b: String = "") {

    }

    /** 3过滤list */
    fun foo3() {
        val positives = list.filter { x -> x.contains("a") }
        val positivess = listInt.filter { it > 3 }
        Log.e("aaa", "(kotlin.java:225)<--$positives-->")
        Log.e("aaa", "(kotlin.java:227)<--$positivess-->")
    }

    /** 4字符串内插 */
    fun foo4(name: String) {
        Log.e("aaa", "(kotlin.java:232)<--name = $name-->");
    }

    /** 5类型判断 */
    fun foo5(obj: Any) {
        when (obj) {
            is String -> ""
            is Int -> 0
            is Cutomer -> "come on"
            else -> "unKnown"
        }
    }

    /** 6遍历map/pair型list */
    val map = TreeMap<Char, Int>();

    fun foo6() {
        for (c in 'A'..'Z') {
            map[c] = c.toInt()
        }
        for ((key, map) in map) {
            Log.e("aaa", "(kotlin.java:255)<--$key -->  $map-->");
        }
    }


}
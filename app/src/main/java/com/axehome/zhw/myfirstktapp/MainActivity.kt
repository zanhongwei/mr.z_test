package com.axehome.zhw.myfirstktapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.solver.widgets.Rectangle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    //第三次更新

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        parsInt(3, 4)
//        foreachData()
//        val retangle = Rectangle(20.0, 20.0)
//        val triangle = Triangle(3.0, 4.0, 5.0)
//        fooo(1)
//        Log.e("aaa", "Area of rectangle is ${retangle.calculateArea()}, its perimeter is ${retangle.periment},it is${if (retangle.isSquare) "" else "not"} square")
//        Log.e("aaa", "Area of triangle is ${triangle.calculateArea()},its perimeter is ${triangle.periment}")
//        Log.e("aaa", "(MainActivity.java:26)<--${eval(Sum(Num(3), Num(4)))}-->");
//        for (i in 100 downTo 1 step 4) Log.e("aaa", "$i<--->" + fizzBuzz(i))

        val binaryReps = TreeMap<Char, String>()
        for (c in 'A'..'Z') {
            val binary = Integer.toBinaryString(c.toInt())
            binaryReps[c] = binary
        }

        for ((letter, binary) in binaryReps) {
            Log.e("aaa", "<--${letter} = ${binary}-->");
        }


        val user = User("张三", 12)

        tv_user.setText("This is ${user.name} and I'm ${user.age}")


        val employee = Employee("张三", "张三一")

        Log.e("aaa", "<--${employee.firstName}-->")

        val test = Test()
//        test.test10forlist()
        test.foo3()
//        test.foo6()

    }

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    fun isNotDigit(c: Char) = c !in '0'..'9'

    fun parsInt(a: Int, b: Int) = if (a > b) a else b


    fun parsSInt(a: Int, b: Int) = if (a > b) a else b;

    fun parseInt(str: String): String? {

        return str
    }


    fun getInt(str1: String, str2: String): String {

        val parseInt1 = parseInt(str1)
        val parseInt2 = parseInt(str2)

        if (parseInt1 == null) {
            return "str1 is null"
        }

        if (parseInt2 == null)
            return "str2 is null"

        return parseInt1 + parseInt2

    }

    fun foreachData() {
        val list = listOf("aaa", "bbb", "ccc", "ddd", "eee", "fff")

        for (i in 19 downTo 1 step 2)
            Log.e("aaa", "<--${i}-->")
        for (i in list.indices) {//输出集合下标的
            Log.e("aaa", "<---${i}--->")
        }
    }

    abstract class Shap(val sides: List<Double>) {
        val periment: Double get() = sides.sum()
        abstract fun calculateArea(): Double

    }

    interface RectangleProperties {
        val isSquare: Boolean
    }

    class Rectangle(
            val height: Double,
            val length: Double
    ) : Shap(listOf(height, length, height, length)), RectangleProperties {
        override val isSquare: Boolean
            get() = length == height

        override fun calculateArea(): Double {
            return height * length
        }
    }

    class Triangle(
            val sideA: Double,
            val sideB: Double,
            val sideC: Double
    ) : Shap(listOf(sideA, sideB, sideC)) {
        override fun calculateArea(): Double {
            val s = periment / 2
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
        }
    }

    data class Customer(val name: String, val age: Int, val email: String)

    fun fooo(param: Int) {
        val result = if (param == 1) "one"
        else if (param == 2) "two"
        else "three"

        Log.e("aaa", "<---${result}--->")
    }


    interface Expr
    class Num(val a: Int) : Expr
    class Sum(val left: Expr, val right: Expr) : Expr


    fun eval(e: Expr): Int =
            when (e) {
                is Num -> e.a
                is Sum -> eval(e.left) + eval(e.right)
                else -> throw IllegalArgumentException("Unknown expression")
            }


    fun fizzBuzz(i: Int) =
            when {
                i % 15 == 0 -> "FizzBuzz"
                i % 3 == 0 -> "Fizz"
                i % 5 == 0 -> "Buzz"
                else -> "$i"
            }


    fun getPecentage(number: Int) {
        val percentage = if (number in 1..100) number else throw IllegalArgumentException("I don't know  ")
    }


    class User(val name: String?, val age: Int?)


    interface Named {
        val name: String
    }

    interface Person : Named {
        val firstName: String
        val lastName: String

        override val name: String
            get() = "$firstName  $lastName"
    }


    data class Employee(
            override val firstName: String,
            override val lastName: String
    ) : Person

}




package io.access.kotlintraining

import org.junit.Test
import kotlin.test.assertEquals

class SampleTest {
    @Test
    fun testWelcome() {
        welcome()

        // Example of test
        val expected = 1
        val actual = 1
        assertEquals(expected, actual, "[want] $expected [got] $actual")
    }

    @Test
    fun testHello() {
        println("halo")
    }

    private fun fizzBuzz(number:Int) : String =
        when {
            number % 15 == 0 -> "fizzbuzz"
            number % 3 == 0  -> "fizz"
            number % 5 == 0  -> "buzz"
            else             -> "$number"
        }

    @Test
    fun testExercise1() {
        for(number in 1..1000) {
            println(fizzBuzz(number))
        }
    }

    private fun isLeapYear(y: Int) : Boolean = y % 400 == 0 || (y % 100 != 0 && y % 4 == 0)

    @Test
    fun testLeapYear() {
        assertEquals(true, isLeapYear(1600))
    }

    private fun power(a: Int, n: Int): Long {
        if (a < 0 || n < 0) {
            println("inputs must be positive. return 0")
            return 0
        }
        var res:Long = 1
        for (i in 1..n) res *= a
        return res
    }

    @Test
    fun testPower() {
        assertEquals(16, power(2, 4))
    }
}
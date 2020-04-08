package io.access.kotlintraining

import org.junit.Test
import java.lang.Exception
import kotlin.test.assertEquals
import java.util.Random

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

    private fun Int.isOdd() = this % 2 != 0
    private fun Int.isEven() = this % 2 == 0

    @Test
    fun test() {
        val a = 5
        println(a.isOdd())  // true
        println(a.isEven()) // false
    }

    class Dice constructor(val n: Int) {
        var counter : Int = 0
        fun roll() : Int {
            return if (counter >= 100) {
                throw Exception("Broken")
            } else {
                val random = Random()
                counter ++
                return random.nextInt(n)
            }
        }
    }

    @Test
    fun testDice() {
        val d = Dice(16)
        for (i in 1..100) {
            println(d.roll()) // 1〜16 までの数字
        }
        println(d.roll()) // Exception
    }

    class MyCustomClass {
        var counter: Int = 0
        var propertyWithCounter: Int = 0
            set(i) {
                this.counter++
                field = i
            }
    }

    @Test
    fun testMyCustomClass() {
        val p = MyCustomClass()
        p.propertyWithCounter = 123
        p.propertyWithCounter = 456
        p.propertyWithCounter = 789
        println(p.counter) // 3
    }

    class NabeAtsu {
        var counter:Int = 1

        fun next(): String {
            var result: String = ""
            if (counter % 3 == 0 || hasDigit3(counter))
                result = "Aho"
            else
                result = "$counter"
            this.counter ++
            return result
        }

        fun hasDigit3(n: Int) : Boolean {
            val string = n.toString()
            for(c in string) {
                if (c == '3') return true
            }
            return false
        }
    }

    // 呼び出しイメージ
    @Test
    fun testNabeAtsu() {
        val n = NabeAtsu()
        for (i in 1..100) {
            println(n.next())
        }
    }

    class Client (val personalInfo: PersonalInfo?)

    class PersonalInfo (val email: String?)

    interface Mailer {
        fun sendMessage(email: String, message: String)
    }

    class CosmosMailer: Mailer {
        override fun sendMessage(email: String, message: String){
            println("To: $email\nmessage: $message")
        }
    }

    private fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
        if (client == null || message == null) {
            return
        }

        val personalInfo: PersonalInfo = client.personalInfo ?: return

        val email: String = personalInfo.email ?: return

        mailer.sendMessage(email, message)
    }

    @Test
    fun main() {
        val personalInfo: PersonalInfo = PersonalInfo("antonio@abc-company.com")
        val client: Client = Client(personalInfo)
        val mailer: Mailer = CosmosMailer()
        sendMessageToClient(client, "Hello, Antonio!", mailer)
    }
}
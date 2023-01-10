package leetcode.exercise12

import org.junit.Assert
import org.junit.Test

class Test12 {

    @Test
    fun testIntToRoman1() {

        val intput : Int = 3;

        val output : String = intToRoman(intput);

        Assert.assertEquals("III", output);
    }

    @Test
    fun testIntToRoman2() {

        val intput : Int = 58;

        val output : String = intToRoman(intput);

        Assert.assertEquals("LVIII", output);
    }

    @Test
    fun testIntToRoman3() {
        val intput : Int = 1994;

        val output : String = intToRoman(intput);

        Assert.assertEquals("MCMXCIV", output);
    }

    @Test
    fun testIntToRoman4() {
        val intput : Int = 49;

        val output : String = intToRoman(intput);

        Assert.assertEquals("XLIX", output);
    }
}
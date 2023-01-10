package leetcode.exercise13

import org.junit.Assert
import org.junit.Test

class Test13 {

    @Test
    fun testRomanToInt1() {

        val input : String = "III";

        val output : Int = romanToInt(input);

        Assert.assertEquals(3, output);
    }

    @Test
    fun testRomanToInt2() {

        val input : String = "LVIII";

        val output : Int = romanToInt(input);

        Assert.assertEquals(58, output);
    }

    @Test
    fun testRomanToInt3() {

        val input : String = "MCMXCIV";

        val output : Int = romanToInt(input);

        Assert.assertEquals(1994, output);
    }

    @Test
    fun testRomanToInt4() {

        val input : String = "XLIX";

        val output : Int = romanToInt(input);

        Assert.assertEquals(49, output);
    }

}
package leetcode.exercise2264

import leetcode.exercise15.threeSum
import org.junit.Assert
import org.junit.Test

class Test2264 {

    @Test
    fun testLargestGoodInteger1() {

        val input : String = "6777133339";

        val output : String = largestGoodInteger(input);

        Assert.assertEquals("777", output);
    }

    @Test
    fun testLargestGoodInteger2() {

        val input : String = "2300019";

        val output : String = largestGoodInteger(input);

        Assert.assertEquals("000", output);
    }

    @Test
    fun testLargestGoodInteger3() {

        val input : String = "42352338";

        val output : String = largestGoodInteger(input);

        Assert.assertEquals("", output);
    }

    @Test
    fun testLargestGoodInteger4() {

        val input : String = "111";

        val output : String = largestGoodInteger(input);

        Assert.assertEquals("111", output);
    }
}
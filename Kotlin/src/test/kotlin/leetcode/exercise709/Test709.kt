package leetcode.exercise709

import leetcode.exercise1013.canThreePartsEqualSum
import org.junit.Assert
import org.junit.Test

class Test709 {

    @Test
    fun testToLowerCase1() {

        val input : String = "Hello";

        val output : String = toLowerCase(input);

        Assert.assertEquals("hello", output);
    }

    @Test
    fun testToLowerCase2() {

        val input : String = "here";

        val output : String = toLowerCase(input);

        Assert.assertEquals("here", output);
    }

    @Test
    fun testToLowerCase3() {

        val input : String = "LOVELY";

        val output : String = toLowerCase(input);

        Assert.assertEquals("lovely", output);
    }
}
package leetcode.exercise1309

import leetcode.exercise1013.canThreePartsEqualSum
import org.junit.Assert
import org.junit.Test

class Test1309 {

    @Test
    fun testFreqAlphabets1() {

        val input : String = "10#11#12";

        val output : String = freqAlphabets(input);

        Assert.assertEquals("jkab", output);
    }

    @Test
    fun testFreqAlphabets2() {

        val input : String = "1326#";

        val output : String = freqAlphabets(input);

        Assert.assertEquals("acz", output);
    }
}
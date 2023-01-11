package leetcode.exercise9

import leetcode.exercise12.intToRoman
import org.junit.Assert
import org.junit.Test

class Test9 {

    @Test
    fun testIsPalindrome1() {

        val intput : Int = 121;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(true, output);
    }

    @Test
    fun testIsPalindrome2() {

        val intput : Int = -121;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(false, output);
    }

    @Test
    fun testIsPalindrome3() {

        val intput : Int = 10;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(false, output);
    }

    @Test
    fun testIsPalindrome4() {

        val intput : Int = 10001;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(true, output);
    }

    @Test
    fun testIsPalindrome5() {

        val intput : Int = 1001;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(true, output);
    }

    @Test
    fun testIsPalindrome6() {

        val intput : Int = 101201;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(false, output);
    }

    @Test
    fun testIsPalindrome7() {

        val intput : Int = 110001;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(false, output);
    }

    @Test
    fun testIsPalindrome8() {

        val intput : Int = 0;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(true, output);
    }

    @Test
    fun testIsPalindrome9() {

        val intput : Int = 1;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(true, output);
    }

    @Test
    fun testIsPalindrome10() {

        val intput : Int = 9999;

        val output : Boolean = isPalindrome(intput);

        Assert.assertEquals(true, output);
    }
}
package leetcode.exercise26

import leetcode.exercise36.isValidSudoku
import org.junit.Assert
import org.junit.Test

class Test26 {

    @Test
    fun testRemoveDuplicates1() {

        val input : IntArray = intArrayOf(1,1,2);

        val output : Int = removeDuplicates(input);

        Assert.assertEquals(2, output);
        Assert.assertEquals(1, input[0]);
        Assert.assertEquals(2, input[1]);

    }

    @Test
    fun testRemoveDuplicates2() {

        val input : IntArray = intArrayOf(0,0,1,1,1,2,2,3,3,4);

        val output : Int = removeDuplicates(input);

        Assert.assertEquals(5, output);
        Assert.assertEquals(0, input[0]);
        Assert.assertEquals(1, input[1]);
        Assert.assertEquals(2, input[2]);
        Assert.assertEquals(3, input[3]);
        Assert.assertEquals(4, input[4]);



    }
}
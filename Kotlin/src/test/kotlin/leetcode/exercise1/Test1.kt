package leetcode.exercise1

import org.junit.Assert
import org.junit.Test;


internal class Test1 {

    @Test
    fun tesTwoSum1() {
        var nums : IntArray = intArrayOf(2,7,11,15)
        var target : Int = 9;
        var result : IntArray = twoSum(nums, target);

        Assert.assertEquals(0, result.get(0));
        Assert.assertEquals(1, result.get(1));
    }

    @Test
    fun testTwoSum2() {
        var nums : IntArray = intArrayOf(3,2,4)
        var target : Int = 6;
        var result : IntArray = twoSum(nums, target);

        Assert.assertEquals(1, result.get(0));
        Assert.assertEquals(2, result.get(1));
    }

    @Test
    fun testTwoSum3() {
        var nums : IntArray = intArrayOf(3,3)
        var target : Int = 6;
        var result : IntArray = twoSum(nums, target);

        Assert.assertEquals(0, result.get(0));
        Assert.assertEquals(1, result.get(1));
    }
}


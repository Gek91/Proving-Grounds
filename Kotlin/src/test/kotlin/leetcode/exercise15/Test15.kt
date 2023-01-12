package leetcode.exercise15

import leetcode.exercise13.romanToInt
import org.junit.Assert
import org.junit.Test

class Test15 {

    @Test
    fun testThreeSum1() {

        val input : IntArray = intArrayOf(-1,0,1,2,-1,-4);

        val output : List<List<Int>> = threeSum(input);

        Assert.assertEquals(2, output.size);
        Assert.assertTrue(output.contains(listOf(-1,-1,2)));
        Assert.assertTrue(output.contains(listOf(-1,0,1)));
    }

    @Test
    fun testThreeSum2() {

        val input : IntArray = intArrayOf(0,1,1);

        val output : List<List<Int>> = threeSum(input);

        Assert.assertEquals(0, output.size);
    }

    @Test
    fun testThreeSum3() {

        val input : IntArray = intArrayOf(0,0,0);

        val output : List<List<Int>> = threeSum(input);

        Assert.assertEquals(1, output.size);
        Assert.assertEquals(listOf(0,0,0), output.get(0));
    }

    @Test
    fun testThreeSum4() {

        val input : IntArray = intArrayOf(-1,0,1,2,-1,-4,-2,-3,3,0,4);

        val output : List<List<Int>> = threeSum(input);

        Assert.assertEquals(9, output.size);
        Assert.assertTrue(output.contains(listOf(-4,0,4)));
        Assert.assertTrue(output.contains(listOf(-4,1,3)));
        Assert.assertTrue(output.contains(listOf(-3,-1,4)));
        Assert.assertTrue(output.contains(listOf(-3,0,3)));
        Assert.assertTrue(output.contains(listOf(-3,1,2)));
        Assert.assertTrue(output.contains(listOf(-2,-1,3)));
        Assert.assertTrue(output.contains(listOf(-2,0,2)));
        Assert.assertTrue(output.contains(listOf(-1,-1,2)));
        Assert.assertTrue(output.contains(listOf(-1,0,1)));
    }

    @Test
    fun testThreeSum5() {

        val input : IntArray = intArrayOf(-2,0,1,1,2);

        val output : List<List<Int>> = threeSum(input);

        Assert.assertEquals(2, output.size);
        Assert.assertTrue(output.contains(listOf(-2,0,2)));
        Assert.assertTrue(output.contains(listOf(-2,1,1)));

    }

}
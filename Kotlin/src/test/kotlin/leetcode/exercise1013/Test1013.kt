package leetcode.exercise1013

import leetcode.exercise508.TreeNode
import leetcode.exercise508.findFrequentTreeSum
import org.junit.Assert
import org.junit.Test

class Test1013 {

    @Test
    fun testCanThreePartsEqualSum1() {

        val input : IntArray = intArrayOf(0,2,1,-6,6,-7,9,1,2,0,1);

        val output : Boolean = canThreePartsEqualSum(input);

        Assert.assertTrue(output);
    }

    @Test
    fun testCanThreePartsEqualSum2() {

        val input : IntArray = intArrayOf(0,2,1,-6,6,7,9,-1,2,0,1);

        val output : Boolean = canThreePartsEqualSum(input);

        Assert.assertFalse(output);
    }

    @Test
    fun testCanThreePartsEqualSum3() {

        val input : IntArray = intArrayOf(3,3,6,5,-2,2,5,1,-9,4);

        val output : Boolean = canThreePartsEqualSum(input);

        Assert.assertTrue(output);
    }

    @Test
    fun testCanThreePartsEqualSum4() {

        val input : IntArray = intArrayOf(18,12,-18,18,-19,-1,10,10);

        val output : Boolean = canThreePartsEqualSum(input);

        Assert.assertTrue(output);
    }

    @Test
    fun testCanThreePartsEqualSum5() {

        val input : IntArray = intArrayOf(1,-1,1,-1);

        val output : Boolean = canThreePartsEqualSum(input);

        Assert.assertFalse(output);
    }


}
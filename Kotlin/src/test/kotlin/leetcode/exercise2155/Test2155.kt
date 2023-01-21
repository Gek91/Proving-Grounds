package leetcode.exercise2155

import leetcode.exercise508.TreeNode
import leetcode.exercise508.findFrequentTreeSum
import org.junit.Assert
import org.junit.Test
import java.util.*

class Test2155 {

    @Test
    fun testMaxScoreIndices1() {

        val input : IntArray = intArrayOf(0,0,1,0);

        val output : List<Int> = maxScoreIndices(input);

        Assert.assertEquals(2, output.size);
        Assert.assertTrue(output.containsAll(listOf(4,2)));
    }

    @Test
    fun testMaxScoreIndices2() {

        val input : IntArray = intArrayOf(0,0,0);

        val output : List<Int> = maxScoreIndices(input);

        Assert.assertEquals(1, output.size);
        Assert.assertTrue(output.containsAll(listOf(3)));
    }

    @Test
    fun testMaxScoreIndices3() {

        val input : IntArray = intArrayOf(1,1);

        val output : List<Int> = maxScoreIndices(input);

        Assert.assertEquals(1, output.size);
        Assert.assertTrue(output.containsAll(listOf(0)));
    }

    @Test
    fun testMaxScoreIndices4() {

        val input : IntArray = intArrayOf(1,0,0,0);

        val output : List<Int> = maxScoreIndices(input);

        Assert.assertEquals(1, output.size);
        Assert.assertTrue(output.containsAll(listOf(4)));
    }
}
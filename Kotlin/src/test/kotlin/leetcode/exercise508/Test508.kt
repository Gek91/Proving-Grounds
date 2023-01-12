package leetcode.exercise508

import leetcode.exercise2264.largestGoodInteger
import org.junit.Assert
import org.junit.Test

class Test508 {

    @Test
    fun testFindFrequentTreeSum1() {

        val input : TreeNode = TreeNode(5);
        input.left = TreeNode(2);
        input.right = TreeNode(-3)

        val output : IntArray = findFrequentTreeSum(input);

        Assert.assertEquals(3, output.size);
        Assert.assertTrue(output.contains(2));
        Assert.assertTrue(output.contains(-3));
        Assert.assertTrue(output.contains(4));
    }

    @Test
    fun testFindFrequentTreeSum2() {

        val input : TreeNode = TreeNode(5);
        input.left = TreeNode(2);
        input.right = TreeNode(-5)

        val output : IntArray = findFrequentTreeSum(input);

        Assert.assertEquals(1, output.size);
        Assert.assertTrue(output.contains(2));
    }
}
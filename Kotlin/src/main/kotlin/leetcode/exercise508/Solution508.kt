package leetcode.exercise508

/*
https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */

/**
* Example:
* var ti = TreeNode(5)
* var v = ti.`val`
* Definition for a binary tree node.
*
*/
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun findFrequentTreeSum(root: TreeNode?): IntArray {

    val result : MutableMap<Int,Int> = HashMap();

    findSubtreeSum(root!!,result);

    val maxValue = result.values.maxOrNull();

    return result.filterValues { it == maxValue }.keys.toIntArray();
}

fun findSubtreeSum(subTreeRoot : TreeNode, resultCalculator : MutableMap<Int,Int>) : Int {

    val sum = subTreeRoot.`val` +
            when(subTreeRoot.left) { null -> 0; else -> findSubtreeSum(subTreeRoot.left!!, resultCalculator) } +
            when(subTreeRoot.right) { null -> 0; else -> findSubtreeSum(subTreeRoot.right!!, resultCalculator) };

    resultCalculator[sum] = resultCalculator.getOrDefault(sum, 0) +1;

    return sum;
}
package leetcode.exercise1

    /*
    https://leetcode.com/problems/two-sum/
     */

    fun twoSum(nums: IntArray, target: Int): IntArray {

        for((index,value) in nums.withIndex()) {
            for(i in index+1..nums.size-1) {
                if(value + nums.get(i) == target) {
                    return intArrayOf(index,i);
                }
            }
        }

        return IntArray(0);
    }

fun main(args: Array<String>) {

    var nums : IntArray = intArrayOf(2,7,11,15)
    var target : Int = 9;
    var result : IntArray = twoSum(nums, target);
}

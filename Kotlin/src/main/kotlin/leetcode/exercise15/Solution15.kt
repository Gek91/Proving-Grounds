package leetcode.exercise15

/*
https://leetcode.com/problems/3sum/
 */

fun threeSum(nums: IntArray): List<List<Int>> {

    val numsOrdered : List<Int> = nums.toList().sorted();

    val result : MutableList<List<Int>> = ArrayList<List<Int>>();
    var i = 0;
    var iValue = numsOrdered.get(i);
    while(iValue<= 0 && i < numsOrdered.size-2) {
        var left = i+1;
        var right = numsOrdered.size-1;

        while(left < right) {

            val leftValue = numsOrdered.get(left)
            val rightValue = numsOrdered.get(right);

            val sum = iValue + leftValue + rightValue;

            if(sum < 0) {
               left++;
            } else if(sum > 0) {
                right--;
            } else {
                result.add(listOf(iValue, leftValue, rightValue));
                while(numsOrdered[right] == numsOrdered[right - 1] && right > left) right--
                right--
                while(numsOrdered[left] == numsOrdered[left + 1] && left < right) left++
                left++
            }
        }

        while(i < numsOrdered.size-2 && numsOrdered[i] == numsOrdered[i+1]) i++
        i++;
        iValue = numsOrdered.get(i);
    }

    return result;
}


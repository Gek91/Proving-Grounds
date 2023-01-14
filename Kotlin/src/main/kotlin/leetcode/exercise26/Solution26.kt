package leetcode.exercise26


fun removeDuplicates(nums: IntArray): Int {

    var index = 1;
    var lastValue = nums[0];
    var count = 1;

    val iterator : Iterator<Int> = nums.iterator();
    iterator.next();

    for(value in iterator) {
        if(value > lastValue) {
            lastValue = value;
            nums[index] = value;
            index++;
            count++;
        }
    }

    return count;
}
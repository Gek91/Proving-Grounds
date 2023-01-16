package leetcode.exercise1013

fun canThreePartsEqualSum(arr: IntArray): Boolean {

    var sum = 0
    for (value in arr) {
        sum = sum + value;
    }

    if (sum % 3 != 0)
        return false

    val target = sum / 3;
    var temp = 0
    var found = 0
    for (value in arr) {
        temp = temp + value
        if (temp == target) {
            temp = 0
            found++
        }
    }
    return if (found >= 3)
        true;
    else
        false;
}
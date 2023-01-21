package leetcode.exercise1013

fun canThreePartsEqualSum1(arr: IntArray): Boolean {

    var lastIndexFirstSet = 0;
    var firstIndexLastSet = arr.size-1;

    var total = 0;
    arr.forEach { it -> total += it }
    if(total%3 != 0){
        return false
    }

    var target = total/3;
    var firstSetSum = 0;
    var lastSetSum = 0;
    lastSetSum += arr[firstIndexLastSet];
    firstSetSum += arr[lastIndexFirstSet];

    while(firstIndexLastSet - lastIndexFirstSet > 1) {

        if(firstSetSum != target) {
            lastIndexFirstSet++;
            firstSetSum += arr[lastIndexFirstSet];
        }

        if(lastSetSum != target) {
            firstIndexLastSet--;
            lastSetSum += arr[firstIndexLastSet];
        }

        if(firstSetSum == lastSetSum && lastSetSum == target && firstIndexLastSet - lastIndexFirstSet > 1) {
            var middleSetSum = 0;
            for(index in lastIndexFirstSet+1..firstIndexLastSet-1) {
                middleSetSum += arr[index];
            }

            if(middleSetSum == target) {
                return true;
            } else {
                firstIndexLastSet--;
                lastIndexFirstSet++;
                lastSetSum += arr[firstIndexLastSet];
                firstSetSum += arr[lastIndexFirstSet];
            }
        }

    }
    return false;
}

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
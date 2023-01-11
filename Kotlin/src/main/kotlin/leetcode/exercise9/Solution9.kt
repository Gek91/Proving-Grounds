package leetcode.exercise9

import kotlin.math.pow

/*
https://leetcode.com/problems/palindrome-number/
 */

fun isPalindrome(x: Int): Boolean {

    if(x >= 0) {
        val digitList : List<Int> = intToDigitList(x);
        return isListPalindrome(digitList);
    }

    return false;
}

private fun intToDigitList(number: Int): List<Int> {

    var numberHelper: Int = number;
    val digitsNumber : Int = number.toString().length;
    val result = ArrayList<Int>();

    for(i in digitsNumber-1 downTo 1) {
        val digitValueCalculation = 10.toDouble().pow(i).toInt();
        val digitValue = numberHelper/digitValueCalculation;
        numberHelper -= digitValueCalculation*digitValue;
        result.add(digitValue);
    }

    result.add(number%10);

    return result;
}

private fun isListPalindrome(digitList : List<Int>) : Boolean {

    var index : Int = 0;
    while(index < digitList.size/2) {

        if(digitList.get(index) != digitList.get(digitList.size-1-index)) {
            return false;
        }
        index++;
    }

    return true;
}
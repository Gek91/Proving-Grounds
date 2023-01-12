package leetcode.exercise2264

fun largestGoodInteger(num: String): String {

    var index = 0;
    var resultValue : Int = -1;

    while(index <= num.length-3) {

        val charValue = Character.getNumericValue(num.get(index));
        if(charValue > resultValue) {
            if(charValue == Character.getNumericValue(num.get(index + 1))) {
                index++;
                if(charValue == Character.getNumericValue(num.get(index + 1))) {
                    index++;
                    resultValue = charValue;
                }
            }
        }
        index++;
    }

    if(resultValue >= 0) {
        return resultValue.toString() + resultValue.toString() + resultValue.toString()
    } else {
        return  "";
    }
}
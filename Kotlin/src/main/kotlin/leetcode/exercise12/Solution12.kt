package leetcode.exercise12


fun intToRoman(num: Int): String {

    var value = num;
    val result : StringBuilder = StringBuilder();

    value = applyRomanNumberLogic(value, RomanNumber.M, result)
    value = applyRomanNumberLogic(value, RomanNumber.CM, result)
    value = applyRomanNumberLogic(value, RomanNumber.D, result)
    value = applyRomanNumberLogic(value, RomanNumber.CD, result)
    value = applyRomanNumberLogic(value, RomanNumber.C, result)
    value = applyRomanNumberLogic(value, RomanNumber.XC, result)
    value = applyRomanNumberLogic(value, RomanNumber.L, result)
    value = applyRomanNumberLogic(value, RomanNumber.XL, result)
    value = applyRomanNumberLogic(value, RomanNumber.X, result)
    value = applyRomanNumberLogic(value, RomanNumber.IX, result)
    value = applyRomanNumberLogic(value, RomanNumber.V, result)
    value = applyRomanNumberLogic(value, RomanNumber.IV, result)
    value = applyRomanNumberLogic(value, RomanNumber.I, result)

    return result.toString();
}

enum class RomanNumber(val romanValue : String , val intValue : Int) {
    I("I", 1),
    IV("IV", 4),
    V("V", 5),
    IX("IX", 9),
    X("X", 10),
    XL("XL", 40),
    L("L", 50),
    XC("XC", 90),
    C("C", 100),
    CD("CD", 400),
    D("D", 500),
    CM("CM", 900),
    M("M", 1000);
}

fun applyRomanNumberLogic(num: Int, romanNumber : RomanNumber, resultStringBuilder: StringBuilder ): Int {

    val times : Int = num / romanNumber.intValue;

    if(times > 0) {
        for(i in 1..times) {
            resultStringBuilder.append(romanNumber.romanValue);
        }

        return num - (romanNumber.intValue*times);
    }

    return num;
}
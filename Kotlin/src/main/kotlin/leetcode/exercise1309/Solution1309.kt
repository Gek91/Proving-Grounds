package leetcode.exercise1309

import java.lang.StringBuilder

fun freqAlphabets(s: String): String {

    var index = s.length-1;

    val stringBuilder : StringBuilder = StringBuilder("");

    while(index >= 0) {

        val character : Char = s[index];

        val charValue : String;

        if(character == '#') {
            charValue = ("" + s[index-2] + s[index-1]);
            index--;
            index--;
        } else {
            charValue = ("" + character);
        }
        stringBuilder.insert(0, (charValue.toInt()+96).toChar());
        index--;
    }

    return stringBuilder.toString();
}

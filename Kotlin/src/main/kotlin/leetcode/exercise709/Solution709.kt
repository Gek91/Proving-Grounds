package leetcode.exercise709

import java.lang.StringBuilder

fun toLowerCase(s: String): String {

    val stringBuilder = StringBuilder();

    for(character in s) {

        if(character.toInt() in 65..90) {
            stringBuilder.append((character.toInt() + 32).toChar());
        } else {
            stringBuilder.append(character)
        }
    }

    return stringBuilder.toString()
}
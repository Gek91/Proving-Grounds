package leetcode.exercise13

/*
https://leetcode.com/problems/roman-to-integer/
 */

fun romanToInt(s: String): Int {

    val stack : ArrayDeque<Char> = ArrayDeque(s.toCharArray().asList());

    var result = 0;

    while(!stack.isEmpty()) {
        val charValue = stack.removeFirst();
        when {
            charValue =='M' -> result += 1000;
            charValue == 'D' -> result += 500;
            charValue == 'C' && nextIsChar('M', stack) -> result += 900;
            charValue == 'C' && nextIsChar('D', stack) -> result += 400;
            charValue == 'C' -> result += 100;
            charValue == 'L' -> result += 50;
            charValue == 'X' && nextIsChar('C', stack) -> result += 90;
            charValue == 'X' && nextIsChar('L', stack) -> result += 40;
            charValue == 'X' -> result += 10;
            charValue == 'V' -> result += 5;
            charValue == 'I' && nextIsChar('X', stack) -> result += 9;
            charValue == 'I' && nextIsChar('V', stack) -> result += 4;
            charValue == 'I' -> result += 1;
        }
    }
    return result;
}

fun nextIsChar(charValue : Char, stack : ArrayDeque<Char>) : Boolean {
    if((stack.firstOrNull() ?: 'Z') == charValue) {
        stack.removeFirst();
        return true;
    }

    return false;
}


package leetcode.exercise2

import kotlin.math.max

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

    /*
    https://leetcode.com/problems/add-two-numbers/
     */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var result : ListNode = ListNode((l1?.`val` ?: 0) + (l2?.`val` ?: 0));
    val returnValue : ListNode = result;
    var l1List = l1?.next;
    var l2List = l2?.next;
    var carry = applyCarryLogic(returnValue);

    while(l1List != null || l2List != null || carry != 0) {

        result.next = ListNode((l1List?.`val` ?: 0) + (l2List?.`val` ?: 0) + carry);

        l1List = l1List?.next;
        l2List = l2List?.next;
        result = result.next!!;

        carry = applyCarryLogic(result)
    }

    return returnValue;
}

fun applyCarryLogic(nodeValue : ListNode): Int {

    if(nodeValue.`val` >= 10 ) {
        nodeValue.`val` = nodeValue.`val` -10;
        return 1;
    } else {
        return 0;
    }
}
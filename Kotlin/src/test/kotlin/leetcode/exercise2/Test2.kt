package leetcode.exercise2

import org.junit.Assert
import org.junit.Test

class Test2 {

    @Test
    fun testAddTwoNumbers1() {

        var helperList : ListNode;

        val l1 : ListNode = ListNode(2);
        helperList = ListNode(4);
        l1.next = helperList;
        helperList.next = ListNode(3);

        assertWithList(l1, arrayListOf(2,4,3));

        val l2 : ListNode = ListNode(5);
        helperList = ListNode(6);
        l2.next = helperList;
        helperList.next = ListNode(4);

        assertWithList(l2, arrayListOf(5,6,4));


        var result = addTwoNumbers(l1, l2);

        assertWithList(result!!, arrayListOf(7,0,8));
    }

    private fun assertWithList(listNode: ListNode, assertionValues : List<Int>) {

        var listNodeHelper : ListNode? = listNode;

        for(value in assertionValues) {
            Assert.assertEquals(value, listNodeHelper?.`val`);
            listNodeHelper = listNodeHelper?.next;
        }
    }

    @Test
    fun testAddTwoNumbers2() {

        var helperList : ListNode;

        val l1 : ListNode = ListNode(0);

        assertWithList(l1, arrayListOf(0));

        val l2 : ListNode = ListNode(0);

        assertWithList(l2, arrayListOf(0));


        var result = addTwoNumbers(l1, l2);

        assertWithList(result!!, arrayListOf(0));
    }

    @Test
    fun testAddTwoNumbers3() {

        var helperList : ListNode;

        val l1 : ListNode = ListNode(9);
        helperList = ListNode(9);
        l1.next = helperList;
        helperList.next = ListNode(9);
        helperList = helperList.next!!;
        helperList.next = ListNode(9);
        helperList = helperList.next!!;
        helperList.next = ListNode(9);
        helperList = helperList.next!!;
        helperList.next = ListNode(9);
        helperList = helperList.next!!;
        helperList.next = ListNode(9);

        assertWithList(l1, arrayListOf(9,9,9,9,9,9,9));

        val l2 : ListNode = ListNode(9);
        helperList = ListNode(9);
        l2.next = helperList;
        helperList.next = ListNode(9);
        helperList = helperList.next!!;
        helperList.next = ListNode(9);

        assertWithList(l2, arrayListOf(9,9,9,9));


        var result = addTwoNumbers(l1, l2);

        assertWithList(result!!, arrayListOf(8,9,9,9,0,0,0,1));
    }
}
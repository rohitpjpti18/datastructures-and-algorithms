package leetcode.linkedlist;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode node) {
        ListNode fastPtr, slowPtr;

        slowPtr = fastPtr = node;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }
}

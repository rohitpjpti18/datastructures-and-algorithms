package leetcode.linkedlist;

class ReverseLinkedList {

    // reverse linked list i
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode current, next, prev = null;

        current = head;
        next = current.next;
        current.next = prev;
        
        while(next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;

        return current;
    }
    

    // reverse linked list ii
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(123);
        dummyNode.next = head;

        ListNode leftPrev = dummyNode, current = head, prev = null, nextPtr;

        for(int i = 1; i<left; i++) {
            current = current.next;
            leftPrev = leftPrev.next;
        }

        for(int i = 0; i < right - left + 1; i++) {
            nextPtr = current.next;
            current.next = prev;
            prev = current;
            current = nextPtr;
        }

        leftPrev.next.next = current;
        leftPrev.next = prev;
        


        return dummyNode.next;
    }
}
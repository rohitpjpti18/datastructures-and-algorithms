package leetcode.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "[val: " + val + ", next: " + (next == null ? "null]" : next.val);
    }
}

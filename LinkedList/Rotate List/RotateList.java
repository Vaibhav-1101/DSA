/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode current = head;
        int length = 1;

        while (current.next != null) {
            length++;
            current = current.next;
        }

        current.next = head;
        k = length - (k % length);

        while (k > 0) {
            current = current.next;
            k--;
        }
        head = current.next;
        current.next = null;
        return head;

    }
}
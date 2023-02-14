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

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        ListNode current = head;
        ListNode next = null;
        int count = 1;
        ListNode list = head;
        boolean flag = true;

        while (current != null) {

            if (count % k == 0) {
                next = current.next;
                if (flag) {
                    list = current;
                    flag = false;
                }
                current.next = null;
                ListNode prev = reverse(start);
                dummy.next = prev;
                current = next;
                start.next = current;
                dummy = start;
                start = current;
                count++;
            } else {
                current = current.next;
                count++;
            }
        }
        return list;
    }
}
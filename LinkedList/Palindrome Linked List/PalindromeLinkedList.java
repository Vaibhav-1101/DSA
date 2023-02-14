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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        // 1) Finding the middle element of the linked list.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // Reverse linked list from next element of middle element.
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // Iterate through slow until fast reaches null as in odd element list we want
        // to skip the common element. eg 1 2 3 2 1. skipping 3
        if (fast != null) {
            slow = slow.next;
        }
        // Check if the same element exists in the linked list from the middle element.
        while (prev != null) {
            if (prev.val != slow.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}
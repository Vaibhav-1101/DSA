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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Creating a dummy node beacuse we might even need to delete the first element
        // of the list.(To delete an element we always find the previous node to node
        // that needs to be deleted)
        ListNode dummy = new ListNode(0);

        // Setting the dummy node as the first element.
        dummy.next = head;

        // Initilizing two pointers fast and slow.
        ListNode fast = dummy;
        ListNode slow = dummy;

        // The logic in this loop is we will first get the fast node to nth node.
        // Because if we close this n gap then we can just move fast and slow one by one
        // until fast reaches the end.
        while (fast.next != null) {
            if (n != 0) {
                fast = fast.next;
                n = n - 1;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        // Delete the node.
        slow.next = slow.next.next;
        // return the first element.
        return dummy.next;
    }
}
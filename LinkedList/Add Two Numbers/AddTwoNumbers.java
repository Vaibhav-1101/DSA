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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryforward = 0;
        ListNode head = l1;
        ListNode prev = null;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryforward;
            carryforward = 0;
            if (sum > 9) {
                carryforward = 1;
                l1.val = sum % 10;
            } else {
                l1.val = sum;
            }
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null && l2 == null) {
            carryForward(l1, carryforward);
        } else if (l1 == null && l2 != null) {
            ListNode current = l2;
            carryForward(l2, carryforward);
            prev.next = current;
        } else if (l1 == null && l2 == null) {
            if (carryforward == 1) {
                ListNode extraOne = new ListNode(1);
                prev.next = extraOne;
            }
        }
        return head;
    }

    void carryForward(ListNode l1, int carryforward) {
        ListNode prev = null;
        while (l1 != null) {
            int sum = l1.val + carryforward;
            carryforward = 0;
            if (sum > 9) {
                l1.val = 0;
                carryforward = 1;
            } else {
                l1.val = sum;
            }
            prev = l1;
            l1 = l1.next;
        }
        if (carryforward == 1) {
            ListNode extraOne = new ListNode(1);
            prev.next = extraOne;
        }
    }
}
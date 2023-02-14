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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If list1 is null then return list2.
        if (list1 == null)
            return list2;
        // If list2 is null then return list1.
        if (list2 == null)
            return list1;
        // Get smallest starting value list as list1.
        if (list1.val >= list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        // Keeping a head to the starting point of the list.
        ListNode head = list1;
        // A previous pointer so that we can always add elements in between two
        // elements.
        ListNode prev = null;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                prev = list1;
                list1 = list1.next;
            } else {
                ListNode current = prev.next;
                prev.next = list2;
                list2 = list2.next;
                prev.next.next = current;
                prev = prev.next;
            }
        }
        if (list1 == null && list2 != null) {
            prev.next = list2;
        }

        return head;
    }
}
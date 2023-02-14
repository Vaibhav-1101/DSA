/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA;
        ListNode pointer2 = headB;
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == pointer2) {
                return pointer1;
            }
            pointer1 = (pointer1 == null) ? pointer1 = headB : pointer1.next;
            pointer2 = (pointer2 == null) ? pointer2 = headA : pointer2.next;

        }
        return null;
    }
}
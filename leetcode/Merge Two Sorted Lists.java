/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = null;
        ListNode end = null;

        ListNode current1 = list1;
        ListNode current2 = list2;
        
        while (current1 != null || current2 != null) {
            int val = 0;
            if (current1 != null && current2 != null) {
                if (current1.val > current2.val) {
                    val = current2.val;
                    current2 = current2.next;
                } else {
                    val = current1.val;
                    current1 = current1.next;
                }
            } else if (current2 == null) {
                val = current1.val;
                current1 = current1.next;
            } else {
                val = current2.val;
                current2 = current2.next;
            }

            if (root == null) {
                root = new ListNode(val);
                end = root;
            } else {
                end.next = new ListNode(val);
                end = end.next;
            }
        }
        return root;
    }
}
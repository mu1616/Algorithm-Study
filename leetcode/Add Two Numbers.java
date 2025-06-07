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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode end = null;

        ListNode current1 = l1;
        ListNode current2 = l2;
        int temp = 0;
        while (current1 != null || current2 != null) {
            int sum = temp;
            if (current1 != null) {
                sum = sum + current1.val;
                current1 = current1.next;
            }
            if (current2 != null) {
                sum = sum + current2.val;
                current2 = current2.next;
            }
            int val = sum % 10;
            temp = sum / 10;
            
            if (root == null) {
                root = new ListNode();
                root.val = val;
                end = root;
            } else {
                end.next = new ListNode();
                end.next.val = val;
                end = end.next;
            }
        }
        if (temp == 1) {
            end.next = new ListNode();
            end.next.val = 1;
        }
        return root;
    }
}
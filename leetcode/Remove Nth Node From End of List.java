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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        
        if (list.size() == 1) {
            return null;
        }
        
        int removeNodeIndex = list.size() - n;
        if (removeNodeIndex - 1 >= 0 && removeNodeIndex + 1 < list.size()) {
            list.get(removeNodeIndex - 1).next = list.get(removeNodeIndex + 1);
            return head;
        }
        if (removeNodeIndex - 1 >= 0) {
            list.get(removeNodeIndex - 1).next = null;
            return head;
        }
        return list.get(1);
    }
}
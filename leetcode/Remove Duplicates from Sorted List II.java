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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Map<Integer, Integer> valueToCount = new HashMap<>();
        ListNode current = head;
        while (current != null) {
            valueToCount.put(current.val, valueToCount.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }
        ListNode resultHead = null;
        ListNode resultEnd = null;
        current = head;
        while (current != null) {
            if (valueToCount.get(current.val) == 1) {
                if (resultHead == null) {
                    resultHead = current;
                } else {
                    resultEnd.next = current;
                }
                resultEnd = current;
            }
            current = current.next;
        }
        if (resultEnd != null) {
            resultEnd.next = null;
        }
        return resultHead;
    }
}
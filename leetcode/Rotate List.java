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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        Deque<ListNode> deque = new LinkedList<>();
        ListNode current = head;
        while (current != null) {
            deque.addFirst(current);
            current = current.next;
        }
        for (int i = 0; i < k % deque.size(); i++) {
            deque.addLast(deque.removeFirst());
        }
        ListNode resultHead = deque.removeLast();
        current = resultHead;
        while (!deque.isEmpty()) {
            current.next = deque.removeLast();
            current = current.next;
        }
        current.next = null;
        return resultHead;
    }
}
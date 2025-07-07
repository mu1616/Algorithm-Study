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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Queue<ListNode> queue = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head.next;
        int length = 1;
        while (curr != null) {
            queue.offer(curr);
            stack.push(curr);
            length++;
            curr = curr.next;
        }

        curr = head;
        for (int i = 0; i < length - 1; i++) {
            if (i % 2 == 0) {
                curr.next = stack.pop();
            } else {
                curr.next = queue.poll();
            }
            curr = curr.next;
        }
        curr.next = null;
    }
}
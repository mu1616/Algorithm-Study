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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(new ListNode(0, head));
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        int i = 1;

        while (current != null) {
            nodes.add(current);
            if (i >= left && i <= right) {
                stack.push(current);
            }
            current = current.next;
            i++;
        }

        current = nodes.get(left - 1);
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        if (right + 1 <= nodes.size() - 1) {
            current.next = nodes.get(right + 1);
        } else {
            current.next = null;
        }
        return nodes.get(0).next;
    }
}
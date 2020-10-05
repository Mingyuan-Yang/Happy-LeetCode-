public class reverseNodes {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        int i = k;
        ListNode prev = head;
        while (i - 1 > 0) {
            prev = prev.next;
            if (prev == null) {
                return head;
            }
            i--;
        }
        ListNode temp = prev.next;
        prev.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(temp, k);
        return newHead;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

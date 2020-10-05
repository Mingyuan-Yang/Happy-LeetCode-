public class add {
    class ListNode {
        ListNode next;
        int val;
        ListNode (int val) {
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int val = 0;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while( l1 != null || l2 != null || val > 0) {
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (val > 9) {
                carry = 1;
                val %= 10;
            }
            temp.next = new ListNode(val);
            val = carry;
            carry = 0;
            temp = temp.next;
        }
        return dummy.next;
    }
}

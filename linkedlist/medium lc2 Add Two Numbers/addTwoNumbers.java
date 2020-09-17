public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int val = 0;
        int carry = 0;
        while (l1 != null || l2 != null || val > 0) {
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            }
            temp.next = new ListNode(val);
            val = carry;
            carry = 0;
            temp = temp.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        addTwoNumbers test = new addTwoNumbers();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        ListNode dummy = test.addTwoNumbers(l1, l2);
        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }
    }
}

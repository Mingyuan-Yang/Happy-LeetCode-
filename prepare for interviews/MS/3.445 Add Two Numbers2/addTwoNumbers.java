public class addTwoNumbers {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        if (len1 > len2) {
            int diff = len1 - len2;
            l2 = addZero(l2, diff);
        } else if (len1 < len2) {
            int diff = len2 - len1;
            l1 = addZero(l1, diff);
        }
        ListNode res = helper(l1, l2);
        if (res.val > 9) {
            ListNode prev = new ListNode(1);
            res.val -= 10;
            prev.next = res;
            res = prev;
        }
        return res;
    }
    private ListNode helper(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode temp = new ListNode(l1.val + l2.val);
        ListNode next = helper(l1.next, l2.next);
        if (next != null && next.val > 9) {
            temp.val += 1;
            next.val %= 10;
        }
        temp.next = next;
        return temp;
    }
    private ListNode addZero(ListNode l, int count) {
        while (count > 0) {
            ListNode prev = new ListNode(0);
            prev.next = l;
            l = prev;
            count--;
        }
        return l;
    }
    private int getLength(ListNode l) {
        int count = 0;
        while (l != null) {
            count++;
            l = l.next;
        }
        return count;
    }
}

public class merge {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        return partition(0, lists.length - 1, lists);
    }
    private ListNode partition(int start, int end, ListNode[] lists) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = partition(start, mid, lists);
        ListNode l2 = partition(mid +1, end, lists);
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
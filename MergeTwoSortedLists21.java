public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 != null) {
            if(l2 != null) {
                if (l1.val <= l2.val) {
                    return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
                } else {
                    return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
                }
            } else {
                return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
            }
        } else if(l2 != null) {
            return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
        } else {
            return null;
        }
    }
}

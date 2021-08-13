public class RemoveNthNodeFromEndList19 {

    int index = 0;
    int size = 0;
    boolean first = false;

    public ListNode removeNthFromEnd(ListNode head, int n) {

        index = n;

        if(head.next != null) {
            ListNode headUpdated = removeNthFromEndSuport(head);
            if(first) {
                return head.next;
            } else {
                return headUpdated;
            }

        } else {
            return null;
        }

    }

    public ListNode removeNthFromEndSuport(ListNode head) {
        boolean flag = false;
        if(head.next == null) {
            size++;
            if(size - index == 0) {
                first = true;
                index = -1;
                return head;
            }
            index--;
        } else {
            size++;
            removeNthFromEndSuport(head.next);
            if(index == 0) {
                head.next = head.next.next;

            } else if(index < 0) {
                return head;
            }
            index--;

        }
        return head;
    }


    public static void main(String[] args) {
        RemoveNthNodeFromEndList19 obj = new RemoveNthNodeFromEndList19();
        int[] i1 = {5,4,3,2,1};
        ListNode input1 = null;
        for(int i = 0; i < i1.length; i++) {
            input1 = new ListNode( i1[i], input1);
        }


        System.out.println(obj.removeNthFromEnd(input1, 2));
    }

}

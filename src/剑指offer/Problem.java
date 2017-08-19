package 剑指offer;

import java.util.ArrayList;

/**
 * Created by 1 on 2017/8/9.
 */
public class Problem {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> arrayList = new ArrayList<>();
        while (head.next != null) {
            arrayList.add(head);
            head = head.next;
        }
        arrayList.add(head);
        int n = arrayList.size()-k;
        if (n >= 0) {
            return arrayList.get(n);
        }
        return null;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newhead = null;
        ListNode p = null;
        while (head != null) {
            p = head.next;
            head.next = newhead;
            newhead = head;
            head = p;
        }

        return newhead;
    }
}

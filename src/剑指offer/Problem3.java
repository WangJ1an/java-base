package 剑指offer;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/9.
 */
public class Problem3 {

    /**
     * 输入两个单调递增的链表，
     * 输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {

        if(list1 == null){
               return list2;
        }
        if(list2 == null){
                return list1;
        }
        ListNode node = null;
        if (list1.val < list2.val) {
            node = list1;
            list1 = list1.next;
        } else {
            node = list2;
            list2 = list2.next;
        }
        ListNode p = node;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        while (list2 != null) {
            p.next = list2;
            p = p.next;
            list2 = list2.next;
        }
        while (list1 != null) {
            p.next = list1;
            p = p.next;
            list1 = list1.next;
        }
        return node;
    }

    @Test
    public void fun() {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(5);

        ListNode node = Merge(listNode1,listNode2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

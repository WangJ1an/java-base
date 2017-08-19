package 剑指offer;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by 1 on 2017/8/11.
 */
public class Problem18 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        HashMap<ListNode,Integer> hashMap = new HashMap<>();
        while (pHead1 != null) {
            hashMap.put(pHead1,1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (hashMap.containsKey(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        FindFirstCommonNode(listNode1,listNode2);
    }
}

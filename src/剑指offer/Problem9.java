package 剑指offer;

/**
 * Created by 1 on 2017/8/10.
 */
public class Problem9 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 输入一个复杂链表
     * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
     *  返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode pnode = pHead;
        while (pnode != null) {
            RandomListNode node = new RandomListNode(pnode.label);
            node.next = pnode.next;
            pnode.next = node;
            pnode = node.next;
        }
        pnode = pHead;
        while (pnode != null) {
            if (pnode.random != null) {
                pnode.next.random = pnode.random.next;
            }
            pnode = pnode.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pnode = pHead;
        while (pnode != null) {
            pnode.next = pnode.next.next;
            cur.next = cur.next.next;
            pnode = pnode.next;
            cur = cur.next;
        }
        return head;
    }
}

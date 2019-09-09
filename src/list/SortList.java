package list;

/**
 * @author Gentle
 * @date 2019/07/09 : 00:10
 * 链表排序
 */
public class SortList {
    /**
     * 冒泡排序
     *
     * @param head
     * @return
     */
    public static ListNode bubbleSort(ListNode head) {
        //链表为空或者仅有单个结点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode tail = null;

        while (cur.next != tail) {
            while (cur.next != tail) {
                if (cur.val > cur.next.val) {
                    int tmp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = tmp;
                }
                cur = cur.next;
            }
            //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            tail = cur;
            //遍历起始结点重置为头结点
            cur = head;
        }
        return head;
    }


    public ListNode sortList(ListNode head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }

    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head;
        ListNode p2 = head.next;

        //走到末尾才停
        while (p2 != end) {
            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val) {
                p1 = p1.next;
                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }


}

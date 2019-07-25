package list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Gentle
 * @date 2019/07/09 : 00:00
 * 判断链表是否有环
 */
public class LoopList {
    /**
     * 判断链表是否有环
     *
     * @param head 链表
     *                 处于同一个圈，第一个跑的慢，第二个跑的快，慢的肯定会被快的追上
     */
    private static boolean loopList(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow, fast;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 借助 set 集合进行判重
     * 重复的情况下，说明循环链表
     * @param head 链表
     * @return
     */
    public static boolean loopList2(ListNode head) {

        Set<Integer> set = new HashSet();

        ListNode temp = head;

        while (temp != null) {
            //判重，包含则说明循环
            if (set.contains(temp.val)) {
                return true;
            }
            //不存在则加入
            set.add(temp.val);
            temp = temp.next;
        }
        return false;

    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(20);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(8);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(51);
        listNode3.next = listNode4;
        listNode4.next = listNode;

        boolean b = loopList(listNode);
        System.out.println(b);
        System.out.println(loopList2(listNode));
    }

}

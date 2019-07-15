package list;

/**
 * @author Gentle
 * @date 2019/07/11 : 23:07
 */
public class MergeList {
    /**
     * 合并有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    private static  ListNode sortList(ListNode listNode){
        if (null==listNode){
            return null;
        }

        ListNode temp = listNode;
        





        return null;
    }



    /**
     * 输出链表
     *
     * @param node
     */
    public static void printlnListNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode tempList = node;

        while (tempList != null) {
            System.out.print(tempList.val + "  ");
            tempList = tempList.next;
        }
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


        ListNode listNode5 = new ListNode(8);
        ListNode listNode6 = new ListNode(1);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(4);
        listNode6.next = listNode7;
        ListNode listNode8 = new ListNode(88);
        listNode7.next = listNode8;
        ListNode listNode9 = new ListNode(3);
        listNode8.next = listNode9;

        ListNode listNode10 = mergeTwoLists(listNode, listNode5);

        printlnListNode(listNode10);

    }


}

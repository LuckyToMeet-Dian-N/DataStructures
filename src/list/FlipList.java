package list;

/**
 * 翻转链表
 *
 * @author Gentle
 * @date 2019/07/08 : 23:41
 */
public class FlipList {

    /**
     * 翻转链表
     *
     * @param head 链表
     */
    public  static ListNode flipList(ListNode head) {
        //翻转链表(递归方式)
        if (head.next == null) {
            return head;
        }
        ListNode listNode = flipList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
    /**
     * 输出链表
     * @param node
     */
    public static void printlnListNode(ListNode node){
        if (node==null){
            return;
        }
        ListNode tempList= node;

        while (tempList!=null){
            System.out.print(tempList.val+"  ");
            tempList=tempList.next;
        }
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(20);
        ListNode listNode1 = new ListNode(2);
        listNode.next=listNode1;
        ListNode listNode2 = new ListNode(5);
        listNode1.next=listNode2;
        ListNode listNode3 = new ListNode(8);
        listNode2.next=listNode3;
        ListNode listNode4 = new ListNode(51);
        listNode3.next=listNode4;

        ListNode listNode5 = flipList(listNode);
        System.out.println();
        printlnListNode(listNode5);
    }


}


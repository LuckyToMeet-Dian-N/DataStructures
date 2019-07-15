package list;

/**
 * @author Gentle
 * @date 2019/07/09 : 00:00
 * 判断链表是否有环
 */
public class LoopList {
    /**
     * 判断链表是否有环
     * @param listNode 链表
     *  处于同一个圈，第一个跑的慢，第二个跑的快，慢的肯定会被快的追上
     *
     */
    private static void loopList(ListNode listNode){
        if (listNode==null){
            return;
        }

        ListNode node= listNode;
        ListNode node2 = listNode.next;

        while (true){

           if (node==(node2)){
               System.out.println("链表有环");
               break;
           }
           node=node.next;
           node2=node2.next.next;
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
        listNode4.next=listNode;

        loopList(listNode);
    }

}

package list;

/**
 * 删除链表中重复元素
 * @author Gentle
 * @date 2019/07/23 : 10:32
 */
public class DeleteMuNode {
    /**
     * 去除重复元素
     * @param listNode
     * @return
     */
    public static ListNode deleteMuNode(ListNode listNode){

        if (listNode==null){
            return null;
        }
        ListNode temp = listNode;
        while (temp.next!=null){
            //判断下一个值和当前值是否一致。一致则去掉
            if (temp.next.val==temp.val){
                temp.next = temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next=listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next=listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next=listNode3;
        ListNode listNode4 = new ListNode(1);
        listNode3.next=listNode4;
        ListNode node = deleteMuNode(listNode);
        System.out.println(node);
    }

}

package list;

import java.util.Hashtable;
import java.util.List;

/**
 * @author Gentle
 * @date 2019/09/02 : 16:03
 * 链表拆分
 */
public class PartitionList {

    /**
     *
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(2);
        listNode4.next = listNode5;
        ListNode listNode6 = partitionList(listNode, 3);
        System.out.println(listNode6);
    }

    /**
     *  LeetCode 86
     * 设定大小值，进行列表拆分,按照 target 值大小前后进行拆分， 。
     * @param listNode
     * @param target
     * @return
     */
    public static ListNode partitionList(ListNode listNode ,int target){


        ListNode temp = new ListNode(0);
        ListNode temp2 =new ListNode(0);
        ListNode lessList=temp;
        ListNode moreList=temp2;

        while (listNode!=null){
            if (listNode.val<target){
                lessList.next = listNode;
                lessList  = lessList.next;
            }else {
                moreList.next =listNode;
                moreList = moreList.next;
            }
            listNode=listNode.next;
        }
        moreList.next=null;
        lessList.next =temp2.next;

        return temp.next;
    }


}

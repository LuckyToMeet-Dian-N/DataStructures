package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Gentle
 * @date 2019/09/02 : 15:04
 * 找出链表公共节点
 */
public class GetIntersectionList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(51);
        listNode3.next = listNode4;
//        listNode4.next = listNode;

        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(6);
        listNode5.next=listNode6;
//        listNode6.next=listNode4;
        boolean intersectionList = getIntersectionList(listNode, listNode5);
        System.out.println(intersectionList);
        boolean intersectionList2 = getIntersectionList2(listNode, listNode5);
        System.out.println(intersectionList2);
    }

    /**
     * 方法一：
     *      借助 Set 集合，空间复杂度 O（n），时间复杂度 O(n * log n)
     * @param listNode1 链表一
     * @param listNode2 链表而
     */
    public static boolean getIntersectionList(ListNode listNode1,ListNode listNode2){

        Set<ListNode> set =new HashSet<>();

        ListNode temp =listNode1;
        while (temp!=null){
            set.add(temp);
            temp=temp.next;
        }
        ListNode temp2 = listNode2;
        while (temp2!=null){
           if (set.contains(temp2)){
               return true;
           }
            temp2=temp2.next;
        }
        return false;
    }

    /**
     * 思路：
     *      找出长度，移动头结点之后比较，长的那个链表移动位置，变成和短链表长度一致，之后对比进行比较，一致说明相交，不一致说明没相交。
     *      该题可以变种，找出相交节点，将返回值变一下即可。
     * @param listNode1 链表一
     * @param listNode2 链表而
     * @return
     */
    public static boolean getIntersectionList2(ListNode listNode1,ListNode listNode2){
        int len1 =0;
        ListNode node =listNode1;
        while (node!=null){
            len1++;
            node=node.next;
        }
        int len2=0;
        ListNode node2 =listNode2;
        while (node2!=null){
            len2++;
            node2=node2.next;
        }
        ListNode listNode ;
        if (len1>len2){
            listNode=listNode1;
            int tempLen =len1-len2;
            while (tempLen!=0){
                listNode =listNode.next;
                tempLen--;
            }
            ListNode listNode3=listNode2;
            while (listNode!=null){
                if (listNode ==listNode3){
                    return true;
                }
                listNode=listNode.next;
                listNode3 =listNode3.next;
            }

        }else if (len1<len2){
            listNode=listNode2;
            int tempLen =len2-len1;
            while (tempLen!=0) {
                listNode = listNode.next;
                tempLen--;
            }
            ListNode listNode3=listNode2;
            while (listNode!=null){
                if (listNode ==listNode3){
                    return true;
                }
                listNode=listNode.next;
                listNode3 =listNode3.next;
            }
        }
        //最后一种情况就是链表长度相等。。直接遍历判断就好。easy.


        return false;
    }














}

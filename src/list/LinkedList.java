package list;

/**
 * 数据结构 -- 链表
 * 简单链表
 * @author Gentle
 * @date 2019/06/23 : 10:50
 */
public class LinkedList {
    private Node first;

    private Node last;

    private int size;

    /**
     * 链表节点
     */
    private class Node {
        private Node next;
        private Integer data;

        public Node(Integer data) {
            this.data = data;
        }
    }

    /**
     * 链表入队
     *
     * @param data
     */
    public void addLast(Integer data) {
        Node l = last;
        Node node = new Node(data);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }

    /**
     * 放入链表头部数据
     *
     * @param data 数据
     */
    public void addFirst(Integer data) {
        Node f = first;
        Node node = new Node(data);
        first = node;
        if (last == null) {
            last = node;
        } else {
            first.next = f;
        }
        size++;

    }

    /**
     * 移除链表
     */
    public void removeLast() {

        Node temp = first;
        while (true) {
            temp = temp.next;
            if (temp.next.next==null){
                temp.next=null;
                break;
            }
        }

    }


    /**
     * 遍历链表
     */
    public void disPlay() {
        Node temp = first;
        while (true) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
            if (temp.next==null){
                System.out.print(temp.data);
                break;
            }
        }

    }

    /**
     * 获取长度
     *
     * @return
     */
    public int size() {

        return size;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(3);
        linkedList.addFirst(30);
        linkedList.removeLast();
        linkedList.disPlay();

    }


}

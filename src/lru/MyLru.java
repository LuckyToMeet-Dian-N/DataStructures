package lru;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Gentle
 * @date 2019/07/15 : 18:27
 * 简单 LRU 实现
 */
public class MyLru {
    /**
     * 判断是否存在
     */
    private Set<Integer> set = new HashSet<>();
    /**
     * LRU 最大长度
     */
    private int length;

    /**
     * 头部
     */
    private Node1 head;
    /**
     * 尾部
     */
    private Node1 last;

    public MyLru(int length){
        this.length = length;
    }

    /**
     * 思路：
     * <p>
     * 判断投节点是否为空
     * 创建链表
     * 检查 set 中是否包含数据
     * 不包含则判断是否已经满了
     * 满了就移除最后一个，在加入
     * 不满，则在头部插入
     * 包含则忽略
     */
    private void setLru(int key) {
        Node1 node = head;

        Node1 end = last;

        if (end == null) {
            Node1 node1 = new Node1(key);
            head = node1;
            last = node1;
        } else {
            if (!set.contains(key)) {
                Node1 newNode = new Node1(key);
                if (set.size() >= length) {
                    remove(key);
                }
                newNode.next = node;
                head = newNode;

                set.add(key);
            }
        }
    }

    /**
     * 淘汰最后的数据
     * <p>
     * 思路：
     * 找到最后一个数据，然后将其置空
     * ```
     *
     * @param key 数据
     */
    private void remove(int key) {

            Node1 temp = head;
            while (null != temp){
                if (temp.next == last){
                    temp.next=null;
                    last=  temp;
                    set.remove(key);
                }
                temp = temp.next;
            }
    }

    public static void main(String[] args) {

        MyLru m = new MyLru(4);
        m.setLru(1);
        m.setLru(2);
        m.setLru(3);
        m.setLru(5);
        m.setLru(4);
        m.setLru(9);
        m.setLru(0);

    }


}

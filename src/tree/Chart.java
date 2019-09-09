package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 图的搜索
 * @author Gentle
 * @date 2019/08/08 : 15:52
 */
public class Chart {

    /**
     *   使用Queue实现BFS
     * @param root
     */
    public void BFSWithQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node);

            //在这里处理遍历到的Node节点

            if (node.children != null) {
                for (Node child : node.children) {
                    if (child != null && !visited.contains(child)){
                        queue.add(child);
                    }
                }
            }
        }
    }
}

class Node {

    Node[] children;

}
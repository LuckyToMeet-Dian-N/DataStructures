package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Gentle
 * @date 2019/08/08 : 15:41
 */
public class BFS {
    //使用Queue实现BFS
    public static void BFSWithQueue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            //在这里处理遍历到的TreeNode节点

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode2.left=treeNode6;

        BFSWithQueue(treeNode);


    }

}

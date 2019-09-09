package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gentle
 * 得到二叉树的镜像  —— 递归的方式
 */
public class MyTreeLearn {

    /**
     * 翻转二叉树
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if ((root.left == null) && (root.right == null)) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 判断两个二叉树是否一致
     *
     * @param t1 第一个树
     * @param t2 第二个树
     * @return
     */
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);

    }


    /**
     * 二叉树最大深度
     *
     * @param node 树节点
     * @return
     */
    public int maxDeath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 二叉树的最小深度
     *
     * @param root 树节点
     * @return
     */
    int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    /**
     * 二叉树元素个数
     *
     * @param root
     * @return
     */
    int numOfTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;
    }

    /**
     * 二叉树的前序遍历
     *
     * @param root   树根节点
     * @param result 结果集
     */
    public void preOrder2(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder2(root.left, result);
        preOrder2(root.right, result);

    }

    /**
     * 二叉树后续遍历
     *
     * @param root 根节点
     * @return
     */
    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        list.addAll(postOrder(root.left));
        list.addAll(postOrder(root.right));
        list.add(root.val);
        return list;
    }

    /**
     * 中序遍历
     * 递归
     */
    public void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.left);
            System.out.print(node.val + " ");
            midOrder(node.right);
        }
    }

    public static void main(String[] args) {

        int hash = hash("htps");
        int hash1 = hash("http");
        int hash2 = hash("http://ggjajfaiojriao.com/abc");
        int i = 1024;

        System.out.println(hash & (i - 1));
        System.out.println(hash1 & (i - 1));
        System.out.println(hash2 & (i - 1));


    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
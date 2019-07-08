package tree;

import java.util.LinkedList;


/**
 * 得到二叉树的镜像  —— 递归的方式
 */
public class Solution {


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


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
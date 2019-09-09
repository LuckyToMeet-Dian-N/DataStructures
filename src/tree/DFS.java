package tree;

/**
 * @author Gentle
 * @date 2019/08/08 : 15:42
 */
public class DFS {

    /**
     * DFS递归实现
     */
    public void DFSWithRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        //在这里处理遍历到的TreeNode节点

        if (root.left != null) {
            DFSWithRecursion(root.left);
        }
        if (root.right != null) {
            DFSWithRecursion(root.right);
        }
    }

}

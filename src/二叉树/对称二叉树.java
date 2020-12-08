package 二叉树;

/**
 * 给定一个二叉树，检查它是否是镜像对称的
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmertric(root.left, root.right);
    }

    private boolean isSymmertric(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return isSymmertric(t1.left, t2.right) && isSymmertric(t1.right, t2.left);
    }

}


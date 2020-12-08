package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            list.add(t.val);

            //先压入右节点，再压入左节点，这样弹栈遍历的顺序就是中左右
            if(t.right != null)
                stack.push(t.right);
            if(t.left != null)
                stack.push(t.left);
        }
        return list;
    }
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        //注意终结条件的设定，画图分析会比较清晰，添加了root!=null的条件才能进入循环或者转移到右子树
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            //左子树已经遍历完成或者为空，右子树不为空则转移到右子树
            root = root.right;
        }
        return list;
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<TreeNode> set = new HashSet<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            //不直接弹出，查看栈顶的右节点进行判断
            //ArrayDeque的peek是查看栈顶，jdk8的中文文档似乎有误
            root = stack.peek();

            if(set.contains(root) || root.right == null){
                //栈顶弹出，如果为空就可以结束了,root设置为null防止循环回到上面的语句时继续插入重复节点
                root = stack.pop();
                list.add(root.val);
                root = null;
            } else {
                //因为是后序遍历，不能直接弹出栈顶进行转移
                //添加进set表示访问过，转到右子树
                set.add(root);
                root = root.right;
            }
        }
        return list;
    }
}


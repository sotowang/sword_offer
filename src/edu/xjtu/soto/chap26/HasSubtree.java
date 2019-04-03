package edu.xjtu.soto.chap26;

import edu.xjtu.soto.TreeNode;

/**
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。二叉树节点的定义如下：
 */
public class HasSubtree {
    public static boolean hasSubtree(TreeNode root, TreeNode subRoor) {
        boolean result = false;
        if (root != null && subRoor != null) {
            if (root.val == subRoor.val) {
                result = doesTree1HasTree2(root, subRoor);
            }
            if (!result) {
                result = hasSubtree(root.left, subRoor);
            }
            if (!result) {
                result = hasSubtree(root.right, subRoor);
            }
        }
        return result;

    }

    private static boolean doesTree1HasTree2(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return doesTree1HasTree2(t1.left, t2.left)
                && doesTree1HasTree2(t1.right, t2.right);

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;

        boolean b = hasSubtree(root1, root3);

        System.out.println(b);
    }

}

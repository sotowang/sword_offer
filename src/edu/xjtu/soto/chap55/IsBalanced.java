package edu.xjtu.soto.chap55;

import edu.xjtu.soto.TreeNode;

/**
 *判断平衡二叉树
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return depth3(root) >= 0;
    }

    private int depth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth3(root.left);
        int right= depth3(root.right);

        return left >= 0 && right >= 0 && Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }


    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r5.left = r7;

        IsBalanced isBalanced = new IsBalanced();
        boolean b = isBalanced.isBalanced(r1);
        System.out.println(b);

    }
}

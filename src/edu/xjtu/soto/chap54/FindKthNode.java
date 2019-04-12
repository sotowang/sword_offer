package edu.xjtu.soto.chap54;

import edu.xjtu.soto.TreeNode;

import java.util.LinkedList;

/**
 * 题目：给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 例如，在图中的二叉搜索树里，按节点数值大小顺序，第三大节点的值是4.
 */
public class FindKthNode {
    public TreeNode findKthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p;
        int count = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                count++;
                if (count == k) {
                    return p;
                }
                root = p.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FindKthNode f = new FindKthNode();

        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);

        r5.left = r3;
        r5.right = r7;
        r3.left = r2;
        r3.right = r4;
        r7.left = r6;
        r7.right = r8;

        TreeNode res1 = f.findKthNode(r5, 10);
        System.out.println(res1.val);

    }
}

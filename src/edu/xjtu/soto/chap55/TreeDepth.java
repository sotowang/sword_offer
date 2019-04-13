package edu.xjtu.soto.chap55;

import edu.xjtu.soto.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根，叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    public int depth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth1(root.left) ;
        int right = depth1(root.right) ;

        return Math.max(left, right) + 1;
    }

    public int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        TreeNode p;

        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            depth++;
        }

        return depth;
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

        TreeDepth treeDepts = new TreeDepth();
        int res = treeDepts.depth1(r1);
        System.out.println(res);


        System.out.println(treeDepts.depth2(r1));

    }
}

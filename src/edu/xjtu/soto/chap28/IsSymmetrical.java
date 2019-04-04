package edu.xjtu.soto.chap28;

import edu.xjtu.soto.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class IsSymmetrical {

    /**
     * 使用递归
     * @param root
     * @return
     */
    public static boolean isSymmetrical(TreeNode root) {


        return isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);

    }

    /**
     * 使用队列
     * @param root
     * @return
     */
    public static boolean isSymmetrical2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root.left);
        queue2.offer(root.right);

        TreeNode p = null;
        TreeNode q = null;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            p = queue1.poll();
            q = queue2.poll();

            if (p == null && q == null) {
                continue;
            } else if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }

            queue1.offer(p.left);
            queue2.offer(q.right);

            queue1.offer(p.right);
            queue2.offer(q.left);

        }
        return true;


    }

    public static void main(String[] args) {
        TreeNode r8 = new TreeNode(8);
        TreeNode r6_1 = new TreeNode(6);
        TreeNode r6_2 = new TreeNode(6);
        TreeNode r5_1 = new TreeNode(5);
        TreeNode r5_2 = new TreeNode(5);
        TreeNode r7_1 = new TreeNode(7);
        TreeNode r7_2 = new TreeNode(7);



        r8.left = r6_1;
        r8.right = r6_2;
        r6_1.left = r5_1;
        r6_1.right = r7_1;
        r6_2.left = r7_2;
        r6_2.right = r5_2;


//        boolean b = isSymmetrical(r8);

//        System.out.println(b);

        System.out.println(isSymmetrical2(r8));

        TreeNode p7_1 = new TreeNode(7);
        TreeNode p7_2 = new TreeNode(7);
        TreeNode p7_3 = new TreeNode(7);
        TreeNode p7_4 = new TreeNode(7);
        TreeNode p7_5 = new TreeNode(7);
        TreeNode p7_6 = new TreeNode(7);

        p7_1.left = p7_2;
        p7_1.right = p7_3;
        p7_2.left = p7_4;
        p7_2.right = p7_5;
        p7_3.left = p7_6;

//        System.out.println(isSymmetrical(p7_1));
        System.out.println(isSymmetrical2(p7_1));

    }

}

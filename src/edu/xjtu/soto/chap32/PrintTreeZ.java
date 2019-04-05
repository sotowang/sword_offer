package edu.xjtu.soto.chap32;

import edu.xjtu.soto.TreeNode;

import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打针，第三行再按照从左到右的顺序打印，其他行以此类推，
 */
public class PrintTreeZ {

    public static void printTreeZ(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stackOdd = new LinkedList<>();
        LinkedList<TreeNode> stackEven = new LinkedList<>();

        TreeNode node = null;

        stackOdd.push(root);

        while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            if (!stackOdd.isEmpty()) {
                while (!stackOdd.isEmpty()) {
                    node = stackOdd.pop();
                    System.out.print(node.val + " ");
                    if (node.left != null) {
                        stackEven.push(node.left);
                    }
                    if (node.right != null) {
                        stackEven.push(node.right);
                    }

                }
            }else {

                while (!stackEven.isEmpty()) {
                    node = stackEven.pop();
                    System.out.print(node.val + " ");
                    if (node.right != null) {
                        stackOdd.push(node.right);
                    }
                    if (node.left != null) {
                        stackOdd.push(node.left);
                    }
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        TreeNode t8 = new TreeNode(8);
        TreeNode t6 = new TreeNode(6);
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t11 = new TreeNode(11);
        t8.left = t6;
        t8.right = t10;
        t6.left = t5;
        t6.right = t7;
        t10.left = t9;
        t10.right = t11;
        PrintTreeZ pz = new PrintTreeZ();
        pz.printTreeZ(t8);
    }


}

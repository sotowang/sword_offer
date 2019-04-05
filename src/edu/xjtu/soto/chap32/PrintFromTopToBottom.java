package edu.xjtu.soto.chap32;

import edu.xjtu.soto.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目一：不分行从上到下打印二叉树
 */
public class PrintFromTopToBottom {

    private ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
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

        PrintFromTopToBottom ptt = new PrintFromTopToBottom();
        ArrayList<Integer> res = ptt.printFromTopToBottom(t8);
        System.out.println(res);
    }

}

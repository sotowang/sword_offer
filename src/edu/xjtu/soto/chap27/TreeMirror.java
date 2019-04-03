package edu.xjtu.soto.chap27;

import edu.xjtu.soto.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：请完成一个函数，输入一棵二叉树，该函数输出它的镜像。
 */
public class TreeMirror {

    /**
     * 递归求镜像（先序遍历）
     * @param root
     * @return
     */
    public static TreeNode treeMirror1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //节省时间
        if (root.left != null) {
            treeMirror1(root.left);
        }
        if (root.right != null) {
            treeMirror1(root.right);
        }
        return root;
    }

    /**
     * 非递归，层次遍历
     * @param root
     */
    public static void treeMirror2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 非递归前序遍历
     * @param root
     */
    public static void treeMirror3(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                if (root.left != null || root.right != null) {
                    TreeNode temp = root.left;
                    root.left = root.right;
                    root.right = temp;
                }
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }

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

//        TreeNode treeNode = treeMirror1(root1);

//        treeMirror2(root1);
        treeMirror3(root1);
    }
}

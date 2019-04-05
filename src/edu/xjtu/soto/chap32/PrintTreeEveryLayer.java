package edu.xjtu.soto.chap32;

import edu.xjtu.soto.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class PrintTreeEveryLayer {
    private void printTreeEveryLayer(TreeNode root) {
        if (root == null) {
            return;
        }
        //下一层节点数
        int nextLevel = 0;

        //本层未打印节点数，第一层还未打印。故初始化为1
        int toBePrint = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.val + " ");
            toBePrint--;

            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }

            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
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

        PrintTreeEveryLayer ptl = new PrintTreeEveryLayer();
        ptl.printTreeEveryLayer(t8);

    }

}



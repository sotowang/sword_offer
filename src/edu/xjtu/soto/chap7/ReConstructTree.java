package edu.xjtu.soto.chap7;

import edu.xjtu.soto.TreeNode;

/**
 *输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class ReConstructTree {

    public TreeNode reconstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        return construct(preOrder,0,preOrder.length-1,inOrder, 0, inOrder.length-1);

    }

    private TreeNode construct(int[] preOrder, int startPre, int endPre, int[] intOrder, int startInOrder, int endInOrder) {

        if (startPre > endPre || startInOrder > endInOrder) {
            return null;
        }

        int rootValue = preOrder[startPre];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < endInOrder; i++) {
            if (intOrder[i] == rootValue) {
                root.left = construct(preOrder, startPre + 1, startPre+i-startInOrder, intOrder, startInOrder, i - 1);
                root.right = construct(preOrder, startPre + i-startInOrder+1, endPre, intOrder, i+1, endInOrder);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode v2 = new TreeNode(2);
        TreeNode v3 = new TreeNode(3);
        TreeNode v4 = new TreeNode(4);
        TreeNode v5 = new TreeNode(5);
        TreeNode v6 = new TreeNode(6);
        TreeNode v7 = new TreeNode(7);
        TreeNode v8 = new TreeNode(8);
        root.left = v2;
        root.right = v3;
        v2.left = v4;
        v4.right = v7;
        v3.left = v5;
        v3.right = v6;
        v6.left = v8;

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        ReConstructTree re = new ReConstructTree();
        TreeNode result = re.reconstructBinaryTree(pre, in);

        int count = 8;
        while (count-- > 0) {

            System.out.println(result.val);

            result = result.left;
        }


    }
}

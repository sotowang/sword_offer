package edu.xjtu.soto.chap36;

import edu.xjtu.soto.TreeNode;

/**
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Convert {
    private TreeNode preNode;

    public TreeNode convert(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode pRoot = root;

        //得到双向链表
        convertNode(root);

        //向左找到双向链表的头结点
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    //中序遍历改变指针
    private void convertNode(TreeNode root) {
        if (root == null) {
            return;
        }
        convertNode(root.left);

        root.left = preNode;

        if (preNode != null) {
            preNode.right = root;

        }
        preNode = root;

        convert(root.right);


    }

    public static void main(String[] args) {
        Convert convert = new Convert();

        TreeNode r1 = new TreeNode(10);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(14);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(8);
        TreeNode r6 = new TreeNode(12);
        TreeNode r7 = new TreeNode(16);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;

        TreeNode res = convert.convert(r1);

        while (res != null) {
            System.out.println(res.val);
            res = res.right;
        }
    }

}

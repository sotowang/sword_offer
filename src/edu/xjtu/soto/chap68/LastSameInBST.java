package edu.xjtu.soto.chap68;

import edu.xjtu.soto.TreeNode;

/**
 * 树结点最低公共结点祖先
 */
public class LastSameInBST {

    /**
     * 二叉查找树
     * @param root
     * @param a
     * @param b
     * @return
     */
    public TreeNode findLastSame(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) {
            return null;
        }
        TreeNode p = root;
        while (p != null) {
            if (p.val < a.val && p.val < b.val) {
                p = p.right;
            }
            if (p.val > a.val && p.val > b.val) {
                p = p.left;
            }
            if ((p.val > a.val && p.val < b.val) || (p.val < a.val && p.val > b.val)) {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        LastSameInBST l = new LastSameInBST();

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);


        r4.left = r2;
        r4.right = r6;
        r2.left = r1;
        r2.right = r3;
        r6.left = r5;
        r6.right = r7;

        System.out.println(l.findLastSame(r4,r1,r7).val);
        System.out.println(l.findLastSame(r4,r1,r3).val);

    }
}

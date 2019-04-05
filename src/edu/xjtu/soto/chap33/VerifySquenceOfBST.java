package edu.xjtu.soto.chap33;

/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回true，否则返回false，假设输入的数组的任意两个数字都互不相同。
 * 例如。输入数组（5，7，6，9，11，10，8}，则返回true，因为这个整数良列是图4.9二叉搜索树的后序遍历结果。
 * 如果输入的数组是{7，4，6，5}，由于没有哪棵二叉搜索树的后序遍历结果是这个序列，因此返回false。
 */
public class VerifySquenceOfBST {
    public boolean verify(int[] post) {
        if (post == null || post.length <= 0) {
            return false;
        }
        return isSearchBST(post, 0, post.length - 1);

    }

    private boolean isSearchBST(int[] post, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int root = post[end];

        //在二叉搜索树中左子树节点的值小于根节点的值
        int i = 0;
        for (; i < end; i++) {
            if (post[i] > root) {
                break;
            }
        }
        //在二叉搜索树中右子树节点的值大于根节点的值
        int j = i;
        for (; j < end; j++) {
            if (post[j] < root) {
                return false;
            }
        }

        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = isSearchBST(post, begin,i-1);
        }

        //判断左子树是不是二叉搜索树
        boolean right = true;
        if (j < end - 1) {
            right = isSearchBST(post, i, j);
        }

        return left && right;

    }

    public static void main(String[] args) {
        int[] post1 = {5, 7, 6, 9, 11, 10, 8};
        int[] post2 = {7, 4, 6, 5};
        int[] post3 = {7};

        VerifySquenceOfBST vb = new VerifySquenceOfBST();
        System.out.println(vb.verify(post1));
        System.out.println(vb.verify(post2));
        System.out.println(vb.verify(post3));
    }
}

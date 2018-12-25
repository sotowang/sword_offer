import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public  class Solution {


    public static void main(String[] args) {

        /**
         * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
         * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
         *
         */

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);

        printTree(root);




        /**
         * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
         * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
         */
//        StringBuffer str = new StringBuffer("We Are Happy");
//        String str1 = replaceSpace(str);


        /**
         * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
         */
//        ListNode head = new ListNode(-1);
//
//        for (int i = 0; i < 10; i++) {
//            ListNode p = new ListNode(i);
//            p.next = head.next;
//            head.next = p;
//
//        }
//        ArrayList<Integer> arrayList = new ArrayList<>(printListFromTailToHead(head.next));
//
//        System.out.println(arrayList);





    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre+i-startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i-startIn+1, endPre, in, i + 1, endIn);
            }
        }

        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }

        return arrayList;
    }



    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer new_str = new StringBuffer();
        int a;
        while ( ( a = str.indexOf(" ")) > -1) {
            str.replace(a, a + 1, "%20");
        }

        return str.toString();
    }


}


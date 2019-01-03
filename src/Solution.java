import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        /**
         * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
         * 如果是则输出Yes,否则输出No。
         * 假设输入的数组的任意两个数字都互不相同。
         */
//        int[] sequence = {3, 6, 5, 15, 20,10};
        int[] sequence = {7,4,6,5};

        System.out.println(VerifySquenceOfBST(sequence));

        /**
         * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
         */


        /**
         *
         * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
         * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
         * （注意：这两个序列的长度是相等的）
         */
//        int[] pushA = {1, 2, 3, 4, 5};
//        int[] popA = {4, 3, 5, 1, 2};
//        System.out.println(IsPopOrder(pushA, popA));


        /**
         * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
         * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
         * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
         */
//        int[][] matrix = {{4, 5,6}, {7, 8,9}};
//        System.out.println(matrix[0].length);

//        ListNode head1 = new ListNode(-1);
//        ListNode head2 = new ListNode(-1);
////
//        for (int i = 6; i > 0; ) {
//            ListNode p = new ListNode(i);
//            p.next = head1.next;
//            head1.next = p;
//            i -= 2;
//        }
//        for (int i = 6; i > 1; ) {
//            ListNode p = new ListNode(i);
//            p.next = head1.next;
//            head2.next = p;
//            i -= 2;
//        }
//
//
//        ListNode result = Merge(head1.next, head2.next);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }

        /**
         * 输入一个链表，反转链表后，输出新链表的表头。
         */
//        System.out.println(ReverseList(head1).val);

//        for (int i = 0; i < 10; i++) {
//            head = head.next;
//            System.out.print(head.val);
//        }
        /**
         * 输入一个链表，输出该链表中倒数第k个结点。
         */
//        head = FindKthToTail(head.next, 11);


//        System.out.println(head.val);


        /**
         * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
         * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
         */
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        reOrderArray(array);
//        for (int i = 0; i < array.length; i++) {
//
//            System.out.print(array[i]);
//        }

        /**
         * 给定一个double类型的浮点数base和int类型的整数exponent。
         * 求base的exponent次方。
         */
//        System.out.println(Power(2, -1));

        /**
         * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
         */
//        System.out.println(NumberOf1(10));

        /**
         * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
         * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
         * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
         * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
         */
//        int[] array = {3, 3, 4, 5, 1, 2,2};
//        System.out.println(minNumberInRotateArray(array));


        /**
         * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
         * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
         */
//        System.out.println(JumpFloor(5));


        /**
         * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
         * n<=39
         */
//        System.out.println(Fibonacci(6));

        /**
         * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
         */
////        pop();
//        push(1);
//        System.out.println(pop());


        /**
         * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
         * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
         *
         */

//        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
//        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
//        TreeNode root = reConstructBinaryTree(pre, in);
//
//        printTree(root);


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
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return judge(0, sequence.length - 1, sequence);
    }

    public static boolean judge(int start, int end, int[] sequence) {
        if (start >= end) {
            return true;
        }
        int i = start;
        while (sequence[i] < sequence[end]) {
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return judge(start, i-1, sequence) && judge(i , end - 1, sequence);

    }


    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            arrayList.add(treeNode.val);

        }

        return arrayList;
    }


    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * （注意：这两个序列的长度是相等的）
     */

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //注意这个判定顺序
            while (!stack.empty() && stack.peek() == popA[popIndex] ) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.empty();

    }


    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */
    Stack<Integer> stack = new Stack<>();

    public void push2(int node) {
        stack.push(node);
    }

    public void pop2() {
        stack.pop();
    }

    public int top() {
        return 0;

    }

    public int min() {
        return 0;
    }


    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        return null;
    }

    private static ArrayList<Integer> turn(int[][] matrix) {
        return null;

    }

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp;
        if (root != null) {
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }


    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isSubtree(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean isSubtree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node2 == null) {
            return true;
        }
        if (node1.val == node2.val) {
            return isSubtree(node1.left, node2.left) && isSubtree(node1.right, node2.right);
        } else
            return false;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = list1;
        ListNode q = list2;
        ListNode l1, l2, r = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                l1 = p;
                p = p.next;
                l1.next = null;
                r.next = l1;
                r = l1;
            } else {
                l2 = q;
                q = q.next;
                l2.next = null;
                r.next = l2;
                r = l2;
            }
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return head.next;
    }


    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode p = head;
        ListNode q;
        ListNode l = new ListNode(0);
        l.next = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = l.next;
            l.next = q;
        }
        head = l.next;
        return head;

    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public static ListNode FindKthToTail(ListNode head, int k) {

        ListNode q = head;
        if (k <= 0 || head == null) {
            return null;
        }
        for (int i = 0; i < k - 1; i++) {
            if (q.next != null) {
                q = q.next;
            } else {
                return null;
            }
        }

        while (q.next != null && q != null) {
            head = head.next;
            q = q.next;
        }
        return head;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static void reOrderArray(int[] array) {
        int[] new_array = new int[array.length];
        int k = 0;
        int m = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                array[k++] = array[i];
            } else
                new_array[m++] = array[i];
        }
        for (int j = 0; j < m; j++) {
            array[k++] = new_array[j];
        }
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。
     * 求base的exponent次方。
     */
    public static double Power(double base, int exponent) {
        double result = 1;
        int flag = 1;
        if (exponent < 0) {
            exponent = -exponent;
            flag = 0;
        }
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }
        return flag == 1 ? result : 1 / result;
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else
                break;
        }
        return min;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    public static int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     */
    public static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }


    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Query is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }


    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

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
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
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
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer new_str = new StringBuffer();
        int a;
        while ((a = str.indexOf(" ")) > -1) {
            str.replace(a, a + 1, "%20");
        }

        return str.toString();
    }


}


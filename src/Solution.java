import java.util.*;

public class Solution {


    public static void main(String[] args) {

        /**
         * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
         * 如果是则输出Yes,否则输出No。
         * 假设输入的数组的任意两个数字都互不相同。
         */
////        int[] sequence = {3, 6, 5, 15, 20,10};
//        int[] sequence = {7, 4, 6, 5};
//
//        System.out.println(VerifySquenceOfBST(sequence));

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
//        Permutation("1223");
//        int[] a = {2,2,2,2,2,1,3,4,5};
//        System.out.println(MoreThanHalfNum_Solution(a));

//        int[] input = {4,5,1,6,2,7,3,8};
//        System.out.println(GetLeastNumbers_Solution(input, 10));
//        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
//        int[] array2 = {-2,-8,-1,-5,-9};
//        int[] array3 = {1,-2,3,10,-4,7,2,-5};
//        System.out.println(FindGreatestSumOfSubArray(array));

//        System.out.println(Sum_Solution(3));
        //
//        System.out.println(Add(-1,-2));
//        System.out.println(StrToInt("-123"));
//        System.out.println(LeftRotateString("abcXYZdef",3));
//        System.out.println(ReverseSentence("student. a am I"));
//        System.out.println(ReverseSentence("I am a student."));
//        int[] number = {1, 0, 0, 0, 5};
//        int[] number1 = {3,0,0,0,0};
//        System.out.println(isContinuous(number1));
        //
//        System.out.println(LastRemaining_Solution(6,2));
//        System.out.println(FirstNotRepeatingChar("absh"));
//        System.out.println(FindContinuousSequence(15));

//        int[] array = {3, 5, 8, 10, 11};
//        System.out.println(FindNumbersWithSum(array,83));

        char[] str = {'+','1','0','0'};
        System.out.println(isNumeric(str));
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     *
     * @param node
     */
    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> stackMin = new Stack<>();
    private static Integer temp = null;
    public void push_1(int node) {
        if (temp != null) {
            if (node < temp) {
                stackMin.push(node);
                temp = node;
            }
            stack.push(node);
        }else {
            temp = node;
            stack.push(node);
            stackMin.push(node);
        }
    }

    public void pop_1() {
        if (stack.peek() == stackMin.peek()) {
            stackMin.pop();
        }
        stack.pop();
    }

    public int top_1() {
        return stack.peek();
    }

    public int min_1() {
        return stackMin.peek();
    }
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (pHead1 != null) {
            hashMap.put(pHead1, null);
            pHead1 = pHead1.next;
        }
        while ((pHead2 != null)) {
            if (hashMap.containsKey(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     */
    public static int index = 0;
    public static TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot != null) {
            TreeNode lnode = KthNode(pRoot.left, k);
            if (lnode != null) {
                return lnode;
            }
            index++;
            if (index == k) {
                return pRoot;
            }
            TreeNode rnode = KthNode(pRoot.right, k);
            if (rnode != null) {
                return rnode;
            }

        }

        return null;

    }
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

    /*
    以下对正则进行解释:
    [\\+\\-]?            -> 正或负符号出现与否
    \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
    (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                            否则一起不出现
    ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                            紧接着必须跟着整数；或者整个部分都不出现
    */
    public static boolean isNumeric(char[] str) {
        String str2 = String.valueOf(str);
        return str2.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array.length == 0 || array == null) {
            return arrayList;
        }
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                arrayList.add(array[i]);
                arrayList.add(array[j]);
                break;
            } else if (array[i] + array[j] > sum) {
                j--;
            }else
                i++;

        }
        return arrayList;
    }



    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     * 输出描述:
     */
    public static  ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        int begin = 1;
        int end = 2;
        ArrayList<ArrayList<Integer>> result  = new ArrayList<>();
        while (end > begin) {

            int add = (begin+end)*(end - begin + 1) / 2;
            if (add < sum) {
                end++;
            } else if (add > sum) {
                begin++;
            }else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = begin; i <= end; i++) {
                    arrayList.add(i);
                }
                result.add(arrayList);
                begin += 2;
                end++;
            }
        }
        return result;
    }
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     */
    public static int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return -1;
        }
        int[] count = new int[58];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)-65] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
     * HF作为牛客的资深元老,自然也准备了一些小游戏。
     * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
     * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。每
     * 次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
     * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
     * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     */
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int count = n;
        int step = 0;
        int i = -1;
        while (count > 0) {
            i++;
            if (i >= n) {
                i = 0;
            }
            if (array[i] != -1) {
                step++;
            }
            if (step == m) {
                count--;
                step = 0;
                array[i] = -1;
            }
        }
        return i;
    }
    /**
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
     * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上
     * 面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
     * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
     * 为了方便起见,你可以认为大小王是0。
     */
    public static boolean isContinuous(int [] numbers) {
        if (numbers.length != 5) {
            return false;
        }
        int max = -1;
        int min = 14;
        Arrays.sort(numbers);
        for (int number : numbers) {
            if (number > 13 || number < 0) {
                return false;
            }else if (number != 0){
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }

        }
        if (max - min > 4) {
            return false;
        }
        int numOfZero = 0;
        int interval = 0;
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            interval += numbers[i + 1] - numbers[i] - 1;

        }
        if (numOfZero >= interval) {
            return true;
        }
        return false;

    }


    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
     * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length-1; i >= 0; i--) {
            stringBuilder.append(strings[i]);
            if (i > 0) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/12d959b108cb42b1ab72cef4d36af5ec
     * 来源：牛客网
     * <p>
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
    public static String LeftRotateString(String str, int n) {
        if (str == "" || str == null || str.length() == 0) {
            return "";
        }
        int len = str.length();
        str += str;
        return str.substring(n, len+n);
    }



    /**
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0。
     * 输入描述:
     * 输入一个字符串,包括数字字母符号,可以为空
     * 输出描述:
     * 如果是合法的数值表达则返回该数字，否则返回0
     */
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        if (str.length() == 1) {
            if (chars[0] <= '9' && chars[0] >= '0') {
                return chars[0] - '0';
            }
        }
        int flag = 1;
        int num = 0;
        if (chars[0] == '-') {
            flag = -1;
        } else if (chars[0] == '+') {
            flag = 1;
        } else if (chars[0] <= '9' && chars[0] >= '0') {
            num += (chars[0] - '0');
        } else
            return 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                num = num * 10 + (chars[i] - '0');
            }else
                return 0;
        }
        return num * flag;

    }
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
    public static int Add(int num1,int num2) {
        int a = num1 ^ num2;
        int b = (num1 & num2) << 1;

        return a+b;
    }
    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean a = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        return 0;
    }

    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
     * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
            if (array.length == 0) {
                return 0;
            }
            int max = array[0];
            int sum = array[0];
            for (int i = 1; i < array.length; i++) {
                sum += array[i];
                if (sum < 0) {
                    sum = array[++i];
                }
                if (sum > max) {
                    max = sum;
                }
            }

            return max;


    }


    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k < 0 || k > input.length) {
            return arrayList;
        }
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        int max = 0;
        int index = 0;
        for (int i = k; i < input.length; i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j) > max) {
                    max = arrayList.get(j);
                    index = j;
                }
            }
            if (max > input[i]) {
                max = 0;
                arrayList.set(index, input[i]);
            }
        }
        return arrayList;
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int key = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == key) {
                count++;
            }else
                count--;

            if (count == 0) {
                count = 1;
                key = array[i];
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                count++;
            }
        }
        return count > array.length / 2 ? key : 0;
    }

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */

    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while(true){
            int lIndex = len-1;
            int rIndex;
            while(lIndex>=1 && chars[lIndex-1]>=chars[lIndex]){
                lIndex--;
            }
            if(lIndex == 0)
                break;
            rIndex = lIndex;
            while(rIndex<len && chars[rIndex]>chars[lIndex-1]){
                rIndex++;
            }
            swap(chars,lIndex-1,rIndex-1);
            reverse(chars,lIndex);

            list.add(String.valueOf(chars));
        }

        return list;

    }

    private static void reverse(char[] chars, int k) {
        if (chars == null || chars.length == 0) {
            return;
        }

        int m = chars.length-1;
        for (int i = k; i < chars.length - 1; i++) {
            if (i <= m) {
                swap(chars, i, m--);
            }else
                break;

        }

    }

    private static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }


    /**
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0。
     */
//    public int StrToInt(String str) {
//        char[] a = str.toCharArray();
//        int sign = 0;
//        if (str == "" || str == "0") {
//            return 0;
//        }
//        if (str[0] == "-") {
//
//        }
//    }




    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);

    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }

    }

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */

    Boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(left, right) + 1;
    }

    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);

    }


    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。
     * 假设输入的数组的任意两个数字都互不相同。
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
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
        return judge(start, i - 1, sequence) && judge(i, end - 1, sequence);

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
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.empty();

    }


    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */
    Stack<Integer> stack11 = new Stack<>();

    public void push2(int node) {
        stack11.push(node);
    }

    public void pop2() {
        stack11.pop();
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


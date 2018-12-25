import java.util.ArrayList;
import java.util.Stack;

public  class Solution {


    public static void main(String[] args) {
//        StringBuffer str = new StringBuffer("We Are Happy");
//        String str1 = replaceSpace(str);

        ListNode head = null;

        for (int i = 0; i < 10; i++) {
            ListNode listNode = new ListNode(i);
            listNode.next = null;
            head.next = listNode;

        }
        ArrayList<Integer> arrayList = new ArrayList<>(printListFromTailToHead(head));

        System.out.println(arrayList);

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


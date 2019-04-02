# 面试题2

## 单例模式

设计一个类，只能生成该类的一个实例

单例模式需要满足如下规则：

- 构造函数私有化（private），使得不能直接通过new的方式创建实例对象；
- 通过new在代码内部创建一个（唯一）的实例对象；
- 定义一个public static的公有静态方法，返回上一步中创建的实例对象；由于在静态方法中，所以上一步的对象也应该是static的。

### 饿汉式单例

```java
public class EagerSIngleton {

    //类加载时先New一个出来
    private static EagerSIngleton eagerSIngleton = new EagerSIngleton();
    private EagerSIngleton() {

    }

    public static EagerSIngleton getInstance() {
        return eagerSIngleton;
    }

    public static void main(String[] args) {
        EagerSIngleton s1 = EagerSIngleton.getInstance();
        EagerSIngleton s2 = EagerSIngleton.getInstance();

        System.out.println(s1 == s2);

    }
}
```

### 懒汉式单例

```java
public class LazySingleton {
    private LazySingleton() {

    }

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
```



# 面试题3

## 数组中的重复数字

在一个长度为n的数组里的所有数字都在0~n-1的范围内，数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次，请找出数组中任意一个重复的数字.

> 例如：如果输入长度为7的数组{2,3,1,0,2,5,3}那么对应的输出是重复的数字2或者3

### 使用数组排序

```java
public Boolean duplicate1(int[] arrays,int length,int[] duplicate) {
        if (arrays == null || arrays.length != length || length == 0  ) {
            return false;
        }
        Arrays.sort(arrays);
        for (int i = 0; i < arrays.length - 1; i++) {
            if (arrays[i] == arrays[i + 1]) {
                duplicate[0] = arrays[i];
                return true;
            }
        }

        return false;
    }
```

### 交换数组元素位置

```java
public Boolean duplicate2(int[] arrays, int length, int[] duplicate) {
        if (arrays == null || arrays.length != length || length == 0  ) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (arrays[i] < 0 || arrays[i] > length-1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (i != arrays[i]) {
                if (arrays[arrays[i]] == arrays[i]) {
                    duplicate[0] = arrays[i];
                    return true;
                }
                swap(arrays, i, arrays[i]);
            }

        }



        return false;
    }
```



### 测试用例

* 长度为n的数组里包含一个或多个重复的数字
* 数组中不包含重复的数字
* 无效输入测试用例（输入空指针；长度为n的数组中包含0~n-1之外的数字）

## 不修改数组找出重复的数字

在一个长度为n+1的数组里的所有数字都在1-n 的范围内，所以数组中至少有一个数字是重复的，请找出数组中任意一个重复的数字，但不能修改输入的数组。

>  例如：如果输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的输出重复数字为2或3

```java
public int duplicate(int[] arrays, int length, int[] duplicate) {
        if (arrays == null || arrays.length <= 0 || length != arrays.length) {
            return 0;
        }
        for (int i = 1; i < length ; i++) {
            if (arrays[i] < 1 || arrays[i] > length - 1) {
                return 0;
            }


        }
        for (int i = 1; i < length; i++) {
            if (arrays[i] == duplicate[arrays[i]]) {
                return arrays[i];
            }
            duplicate[arrays[i]] = arrays[i];
        }

        return 0;
    }

```



# 面试题4:

## 二维数组中的查找

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

> 例如下面的二维数组就是每行，每眼列都递增排序。如果在这个数组中查找数字7，则返回truel；旭盯想找数字5，由于数组不含有该数字，则返回false

| 1    | 2    | 8    | 9    |
| ---- | ---- | ---- | ---- |
| 2    | 4    | 9    | 12   |
| 4    | 7    | 10   | 13   |
| 6    | 8    | 11   | 15   |

### 二分法查找

### 利用二维数组特性缩小范围

首先选取数组中右上角的数字，如果该数字等于要查找的数字，则查找过程结束；如果该数字大于要查找的数字，则剔除这个数字所在的列；如果该数字小于要查找的数字，则剔除为个数字所在的行。也就是说，如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或一列，这样每一步都可以缩小查找的范围，直到查找的数字，或者查找范围为空。

```java
public boolean find2(int[][] arrays, int target) {
        if (arrays == null || arrays.length <= 0) {
            return false;
        }

        int row = 0;
        int rows = arrays.length;
        int cols = arrays[0].length-1;

        while (row < rows && cols >= 0) {
            if (arrays[row][cols] > target) {
                cols--;
            }else if (arrays[row][cols] <target) {
                row++;
            } else{
                return true;
            }
        }
        return false;

    }

```

### 测试用例

* 二维数组中包含查找的数字（查找的数字是数组中的最大值和最小值；查找的数字介于数组中的最大值与最小值之间）
* 二维数组中没有查找的数字（查找的数字大于数组中的最大值；查找的数字小于数组中的最小值；查找的数字在数组的最大值和最小值之间但数组中没有这个数字）
* 特殊输入测试（输入空指针）

# 面试题5

## 替换空格

题目：请实现一个函数。把字符串中的每个空格替换成”％20“。例如，输入”We are happy“,则输出”We%20are%20happy“

### 使用Java内置方法

```java
public String replaceBlank1(StringBuffer s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        return s.toString().replace(" ", "%20");
    }
```

### 从后往前扫描

**从前往后扫描要移动那么多次，不妨反过来从后往前扫描试试。**

- 先遍历一遍原字符串，统计空格字符的个数。
- 由于要将空格（一个字符）变成`%20`（三个字符），所以需要将原字符串增长`2 * 空格数`
- 设置两个指针，一个指针oldP指向原字符串的末尾；另一个指针newP指向增长后的新字符串末尾。不断将oldP处的字符移动到newP处，然后两个指针都要左移；如果oldP处字符是空格，就在newP处设置三个字符：按顺序分别是`0、2、%`，同样的两个指针相应的左移。

```java
public String replaceBlank2(StringBuffer s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int spaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)== ' ') {
                spaceNum++;
            }
        }
        int oldP = s.length() - 1;
        s.setLength(s.length() + 2 * spaceNum);
        int newP = s.length() - 1;
        while (oldP >= 0 && oldP != newP) {
            if (s.charAt(oldP) == ' ') {
                s.setCharAt(newP--, '0');
                s.setCharAt(newP--, '2');
                s.setCharAt(newP--, '%');
            } else {
                s.setCharAt(newP--, s.charAt(oldP));
            }
            oldP--;
        }
        return s.toString();
    }
```

### 测试用例

* 输入的字符串中包含空格（空格位于字符串的最前面；空格位于字符串的最后面，空格位于字符串的中间，字符串中有连续多个空格
* 输入的字符串中没有空格
* 特殊输入测试（字符串是一个nullptr指针；字符串是一个空字符串；字符串只有一个空格字符；字符串中有连续多个空格）

## 相关题目

有两个有序的数组A1和A2，A1末尾有足够空间容纳A2。实现一个函数将A2的所有数字插入到A1中，并且所有数字是有序的。

**因为空闲的空间在A1的末尾，所以从后往前比较两个A1和A2的数字，将更大的那个移动到A1的末尾，然后左移指针，继续比较两个数组中的数。当某个数组中的元素被取完了，就直接从另外一个数组取。**

比如下面的例子

```
A1 = [1, 2 ,4 ,7, 9, , , ...]
A2 = [3, 5, 8, 10, 12]
```

假设A1的长度为10，现暂时只有5个元素，这个长度刚好能装下A2。从后往前比较A1和A2：12比9大，将12移动到A1[9]中，然后9和10继续比较，10移动到A1[8]中，9和8比较9移动到A1[7]中，如此这般直到扫描完两个数组，所有数字也都有序了。

```java
public class MergeTwoSortedArray {

    public static void merge(Integer[] a, Integer[] b) {
        if (a.length < b.length) {
            return;
        }
        int la = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                la++;
            }
        }
        la--;
        int k = la + b.length ;
        int lb = b.length-1;
        while (k >= 0 && lb>=0) {
            if (b[lb] > a[la]) {
                a[k--] = b[lb--];
            } else if (b[lb] < a[la]) {
                a[k--] = a[la--];
            } else if (b[lb] == a[la]) {
                a[k--] = a[la--];
                lb--;
            }
        }

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < 4; i++) {
            a[i] = 2 * i + 1;
        }
        Integer[] b = {1, 4, 6, 8};
        merge(a, b);
        System.out.println(Arrays.toString(a));
    }
}

```

# 面试题6

题目：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。

链表定义如下

```java
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
```

## 使用栈

```java
public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }
        return new ArrayList<>(stack);
    }
```

## 递归

```java
public  ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        printListFromTailToHead2(listNode.next);

        arrayList.add(listNode.val);
        return arrayList;

    }
```

## 测试用例

* 功能测试（输入的链表有多个节点；输入的链表只有一个节点）
* 特殊输入测试（输入的链表头节点指针为nullptr）

# 面试题7

## 重建二叉树

题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4，7，2，1，5，3，8，6}，则重建二叉树并输入它的头节点，二叉树和定义如下：

```java

public class TreeNode {
    
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
```

## 递归

```java
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
```

# 面试题8

题目：给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一节点？树中的节点除了有两个分别指向左，右节点的指针，还有一个指向父节点的指针。

```java
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
```



要找出中序遍历的下一个结点，要分几种情况探讨。

- 如果当前结点的右子结点不为空，那么下一个结点就是以该右子结点为根的子树的最左子结点；
- 如果当前结点的右子结点为空，看它的父结点。此时分两种情况，如果父结点的右子结点就是当前结点，说明这个结点在中序遍历中已经被访问过了，需要继续往上看其父结点...直到父结点的左子结点是当前结点为止，该父结点就是下一个结点。如果在一直往上的过程中已经到达根结点，而根结点的父结点为null，这种情况说明当前结点已经是中序序列的最后一个结点了，不存在下一个结点，应该返回null.

```java
public static TreeLinkNode getNextNode(TreeLinkNode target) {
        if (target == null) {
            return null;
        }

        if (target.right != null) {
            target = target.right;
            while (target.left != null) {
                target = target.left;
            }
            return target;
        }
        if (target.right == null) {
            if (target == target.next.left) {
                return target.next;
            } else {
                target = target.next;
                while (target.next != null && target != target.next.left ) {
                    target = target.next;
                }
                if (target.next == null) {
                    return null;
                } else {
                    return target.next;
                }
            }
        }
        return null;
    }
```



## 测试用例

* 普通二叉树（完全二叉树，不完全二叉树）
* 特殊二叉树（所有节点都没有右子节点的二叉树；所有节点都没有左子节点的二叉树；只有一个节点的二叉树；二叉树的根节点指针为null）
* 不同位置的节点的下一个节点（下一个节点为当前节点的右子节点，右子树的最左子节点，父节点，跨层的父节点等；当前节点没有下一个节点）

# 面试题9

题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead,分别完成在队列尾部插入节点和在队列头部删除节点的功能。

```java
 private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();

    public void enqueue(int node) {
        stack1.push(node);
    }

    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

```

## 测试用例

* 往空的队列里添加，删除元素
* 往非空的队列里添加，删除元素
* 连续删除元素直至队列为空

## 相关题目

题目：两个队列模拟一个栈

刚开始两个队列都为空，进栈时，可以进入任意一个队列。不妨默认进入`Queue a`。后续进栈时操作，哪个队列不为空（将看到，另外一个队列肯定为空）就进入该队列中。出栈操作，**最后进入队列的要先出栈**，而此时要出栈的元素在队列最后，但是队列只支持在队列头删除，因此将除了最后一个元素之外的所有元素都删除并复制一份到另一个队列`Queue another`，然后出列最后一个元素即可。此时`Queue a`成了空队列。之后每次出列操作都像上述以样：将不为空的队列中除最后一个元素的其余元素删除并复制到另一个空队列中，再删除原队列中唯一一个元素并弹出。**每次出栈操作后，总有一个队列是空的。又因为进栈时也是进入不为空的那个队列，因此进出栈操作时总有一个队列是空的。**

这两个队列不像上面的例子中有明确的分工，在两个队列实现栈的例子中，它们交替实现进栈或出栈的功能。

总结一下：

- 进栈，进入不为空的那个队列中
- 出栈，将不为空队列中除倒数最后一个元素外的其余元素移动到另一个空队列中，紧接着弹出原队列的最后一个元素。

```java
public class TwoQueueImpStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int node) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.offer(node);
        } else if (!q1.isEmpty()) {
            q1.offer(node);
        } else {
            q2.offer(node);
        }
    }

    public int pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        if (!q1.isEmpty()) {
            for (int i = 0; i < q1.size()-1; i++) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else{
            for (int i = 0; i < q2.size()-1; i++) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }


    }

    public static void main(String[] args) {
        TwoQueueImpStack a = new TwoQueueImpStack();
        a.push(54);
        a.push(55);
        a.push(56);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(53);
        System.out.println(a.pop());
        a.push(52);
        System.out.println(a.pop());
        System.out.println(a.pop());
    }

}
```

# 面试题10

题目一：求斐波那契数列的第n项

写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。斐波那契数列的定义如下：
$$
f(n) =
\begin{cases}
0  & \text{n=0} \\
1 & \text{n=1} \\
f(n-1)+f(n-2)  &\text{n>1}
\end{cases}
$$

## 非递归

```java
public static long fibonacci(int n) {
        if (n < 0) {
            throw  new RuntimeException("非法数字");
        }
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        long MinOne = 1;
        long MinTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = MinOne + MinTwo;
            MinTwo = MinOne;
            MinOne = fibN;
        }
        return fibN;

    }
```

## 递归

```java
public static long finbonacci2(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        return finbonacci2(n - 1) + finbonacci2(n - 2);
    }
```

## 青蛙跳台阶问题

题目2: 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶，求该青蛙跳上一个n级台阶总共有多少种跳法。



到达1级台阶只有1种可能，到达2级台阶有2种可能；可记为f(1) = 1,f(2) = 2。要到达3级台阶，可以选择在1级台阶处起跳，也可以选择在2级台阶处起跳，所以只需求到达1级台阶的可能情况 + 到达2级台阶的可能情况，即f(3) = f(2) +f(1)

同理到达n级台阶，可以在n-1级台阶起跳，也可在n-2级台阶起跳，f(n) = f(n-2)+f(n-1)

可以看做是斐波那契数列。

```java
public static long fabonacci(long n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n < 1) {
            throw new RuntimeException("非法值");
        }
        long a = 1;
        long b = 2;
        long f = 0;
        for (int i = 3; i <= n; i++) {
            f = a + b;
            a = b;
            b = f;
        }
        return f;
    }
```

### 测试用例

* 功能测试（输入3，5，10）
* 边界值测试（如输入0，1，2）
* 性能测试（输入较大的数字，如40，50，100等）

# 面试题11

## 快速排序

```java
public static void quickSort(int[] array,int low,int high) {

        int i = low;
        int j = high;

        if (low < high) {
            int piv = array[low];
            while (low < high) {
                while (low<high && array[high] >= piv) {
                    high--;
                }
                if (low < high) {
                    array[low] = array[high];
                    low++;
                }
                while (low < high && array[low] < piv) {
                    low++;
                }
                if (low < high) {
                    array[high] = array[low];
                    high--;
                }
            }
            array[low] = piv;
            quickSort(array, i, low - 1);
            quickSort(array, low + 1, j);
        }

    }
```

## 对年龄排序O(n)

题目：请实现一个排序算法，要求时间效率为O（n）

> 对公司所有员工的年龄排序，公司员工人数几万，可以使用辅助空间

```java
public static void ageSort(int[] ages) {

        if (ages == null) {
            return;
        }
        int[] temp = new int[100];
        for (int i = 0; i < ages.length; i++) {
            temp[ages[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < temp[i]; j++) {
                ages[index++] = i;
            }
        }


    }
```

公司员工的年龄有一个范围，在上面的代码中，允许的范围是0-99岁。数组temp胜来统计每个年龄出现的次数，某个年龄出现了多少次，就在数组ages里设置几次该年龄，这就相当于组数组ages排序了。该方法用长度100的整数数组作为辅助空间换来了O（n）的时间效率。

## 旋转数组的最小数字

题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转。输出旋转数组的最小元素。例如，数组{3,4,5,1,2}为{1，2，3，4，5}的一个旋转，该数组的最小值为1

```java
public class SpanArrayMin {
    public static int spanArrayMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("非法输入");
        }
        int low = 0;
        int high = array.length - 1;
        if (array[low] < array[high]) {
            return array[low];
        }
        while (low + 1 != high) {
            int mid = (low + high) / 2;
            if (array[mid] == array[low] && array[mid] == array[high]) {
                return inorder(array, low, high);
            }
            if (array[mid] >= array[low]) {
                low = mid;
            }
            if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[high];

    }

    private static int inorder(int[] array, int low, int high) {
        int res = array[low];
        for (int i = low; i < high; i++) {
            if (array[i] < res) {
                res = array[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 0, 2, 3};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        int[] array3 = {1, 0, 1, 1, 1};
        int[] array4 = {1, 1, 1, 0, 1};
        int[] array5 = {1, 1, 1, 1, 1};

        System.out.println(spanArrayMin(array1));
        System.out.println(spanArrayMin(array2));
        System.out.println(spanArrayMin(array3));
        System.out.println(spanArrayMin(array4));
        System.out.println(spanArrayMin(array5));


    }
}

```

### 测试用例

* 功能测试（输入的数组是升序排序数组的一个旋转，数组中有重复数字或者没有重复数字）
* 边界值测试（输入的数组是一个升序排序的数组，只包含一个数字的数组）
* 特殊输入测试（输入null指针）



## 冒泡排序

```java
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < array.length ; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    flag = true;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        bubbleSort(array);

        System.out.println(Arrays.toString(array));

    }

}
```

# 面试题12

## 矩阵中的路径

题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左，右，上，下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3x4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的每一行第二个格子之后，路径不能再次进入这个格子。

| a    | `b`  | t    | g    |
| ---- | ---- | ---- | ---- |
| c    | `f`  | `c`  | s    |
| j    | d    | `e`  | h    |

## 回溯算法

这有点像图的深度优先搜索。除了矩阵边界，每个点都可以在4个方向上选择任意一个前进。当某一条路径失败后，需要回溯到上一次选择处，选择另一个方向再尝试。如果该处的方向都被尝试过了，继续回溯到上次选择处...每一次选择都会来到一个新的格子，在这个格子处又有若干个方向可选择，就这样不断前进、回溯、再前进，直到找到一条满足要求的路径为止；如果所有点都作为起点搜索一遍后还是没有找到满足要求的路径，说明在这个矩阵中不存在该条路径。

上面的描述，使用递归比较好理解。还有一点需要注意，由于路径上访问过的点不能进入第二次，所以需要一个`boolean[] marked`标记那些**当前路径上被访问过的点**。

```java
public class HasPath {
    public static boolean hasPath(char[] matrix, char[] str, int rows, int cols) {
        if (matrix == null || str == null || str.length == 0 || rows < 1 || cols < 1) {
            return false;
        }
        boolean[] marked = new boolean[rows * cols];

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength,marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] marked) {
        int index = row * cols + col;
        if (row < 0 || col < 0 || marked[index] || matrix[index] != str[pathLength] || col > cols || row > rows) {
            return false;
        }
        //递归深度到了字符串尾
        if (pathLength == str.length - 1) {
            return true;
        }
        marked[index] = true;

        if (hasPathCore(matrix, rows, cols, row-1, col, str, pathLength+1, marked) ||
                hasPathCore(matrix, rows, cols, row+1, col, str, pathLength+1, marked) ||
                hasPathCore(matrix, rows, cols, row, col-1, str, pathLength+1, marked) ||
                hasPathCore(matrix, rows, cols, row, col+1, str, pathLength+1, marked)) {
            return true;
        }


        // 对于搜索失败需要回溯的路径上的点，则要重新标记为“未访问”，方便另辟蹊径时能访问到
        marked[index] = false;
        return false;
    }

    public static void main(String[] args){
        String m = "abtgcfcsjdeh";
        char[] matrix = m.toCharArray();
        char[] path1 = {'b', 'f','c','f', 'f', 'e'};
        char[] path2 = {'a','b','f','d'};
        boolean b1 = hasPath(matrix, path1, 3, 4);
        boolean b2 = hasPath(matrix, path2, 3, 4);
        System.out.println(b1 + "\n" +  b2);

    }


}
```

递归方法` hasPathTo`中有个参数len，它表示当前递归的深度。第一次调用传入0，之后在其基础上的每一次递归调用len都会加1，递归的深度也反映了当前路径上有几个字符匹配相等了。能**绕过**下面的if判断，说明当前字符匹配相等了。接下来判断递归深度是否到达字符串末尾，比如字符串`abc`，第一次调用hasPath（传入len为0，递归深度为0）绕过了第一个if，说明字符a已经匹配相等，再判断`len == str.length - 1`不通过；再次递归，此时深度为1，绕过了第一个if，说明字符b已经匹配相等，再判断`len == str.length - 1`不通过；再次递归，此时深度为2，绕过了第一个if，说明字符c已经匹配相等，所有字符匹配相等，因此再次判断`len == str.length - 1`通过，应该返回true.

还有注意：四个方向搜索不是同时发生的，当某一个方向搜索失败后，会退回来进行下一个方向的搜索，回溯法就体现在此。

当搜索失败时，别忘了`marked[index] = false;`，将搜索失败路径上点重新标记为“未访问”，以便回溯后选择其他方向继续前进时能再次访问到这些点。

### 测试用例

* 功能测试（在多行多列的矩阵中存在或者不存在路径）
* 边界值测试（矩阵只有一行或者只有一列：矩阵和路径中的所有字母都是相同的）
* 特殊输入测试（输入null）

# 面试题13

## 机器人的运动范围

题目：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每次可以向左 右、上、下、移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格（35,37）,因为3+5+3+7=18。但它不能进入方格（35，38），因为3+5+3+8=19.请问庐机器人能够到达多少个格子？

## 回溯算法

此题和*面试题12——矩阵中的路径*有相似之处，依然是回溯法。每来到一个新的且满足条件的格子时，计数加1。除矩形的边界外，任意一个方格都有四个方向可以选择，选择任一方向后来到新的格子又可以选择四个方向，但是一个到达过的格子不能进入两次，因为这将导致对同一个格子的重复计数。也就是说，**一个格子一旦满足条件进入后，就被永久标记为“访问过”，一个满足条件的格子只能使计数值加1。**这是和面试题12有区别的地方（那个例子中是搜索路径，失败路径上的点要重新标记为“未访问”，因为另开辟的新路径需要探索这些点）。

这道题用通俗的话来讲就是：m行n列的所有方格中，有多少个满足**行坐标和列坐标的数位之和小于等于门限值k**的格子？

代码和面试题12长得有点像，但是两个问题是有明显区别的！

```java
public class MovingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean marked[] = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, marked);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] marked) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, marked)) {
            marked[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, marked)
                    + movingCountCore(threshold, rows, cols, row + 1, col, marked)
                    + movingCountCore(threshold, rows, cols, row, col - 1, marked)
                    + movingCountCore(threshold, rows, cols, row, col + 1, marked);
        }


        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] marked) {
        if (row >= 0 && row< rows && col>=0 && col<cols && getDigitSum(row) + getDigitSum(col) <= threshold
        && !marked[row*cols+col]) {
            return true;
        }
        return false;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        int count = movingCount(2, 3, 4);
        System.out.println(count);
    }

}

```

## 测试用例

* 功能测试（方格为多行多列；k为正数）
* 边界值测试（方格只有一行或者一列;k等于0）
* 特殊输入测试（k 为负数）

# 面试题14

## 剪绳子

题目：给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1]....,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2，3，3的三段，此时得到的最在乘积是18.

### 动态规划算法

首先定义函数f（n）为把长度为n的绳子剪成若干段后各段长度乘积的最大值。在剪第一刀的时候，我们有n-1种可能的选择，也就是剪出来的第一段绳子的可能长度分别不1，2，...，n-1。因此，f(n) = max(f(i)xf(n-i))，其中0<i<n

```java
public static int maxProductAfterCutting_solution(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];

        //先存绳子的长度
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;

    }
```

### 贪婪算法

如果我们按照如下的策略来剪绳子，则得到的各段绳子的长度的乘积将最大：当n>=5时，我们尽可能多地剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。为种思路对应的参考代码如下：

```java
public static int maxProductAfterCutting_solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = length / 3;
        //当绳子最后剩下的长度为4的时候，不能再剪长度为3的绳子段
        //此时更好的方法是殷绳子剪成长度为2的两段，因为2x2>1x3
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3) * Math.pow(2, timesOf2));


    }
```

### 测试用例

* 功能测试（绳子的初始长度大于5）
* 边界值测试（绳子的初始长度分别为0，1，2，3，4）

# 面试题15

## 二进制中1的个数

题目:请实现一个函数，输入一个整数，输出该数二进制表示中1的个数，例如，把9表示成二进制是1001，有2位是1.因此，如果输入9，则该函数输出2.

> 容易想到的思路：该数的各位不断和1相与，然后将该数右移1位，直到所有位都比较过。

### 右移版本

**错误代码：**

```java
public static int numberOf1(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
```

**注意！上面的代码是错误的！对于非负数来说没有问题，但是当传入负数的时候，由于`>>`是带符号的右移，对于负数来说高位会以1补位，n永远也不会等于9，因此会出现无限循环。**

在Java中右移分两种，一种是上面那样带符号的右移，用`>>`表示，如果数是正数高位以0补位，如果是负数高位以1补位；还有就是无符号的右移，用`>>>`表示，不论正负数，统统高位以0补位。因此只需改动将上述程序的`>>`改成`>>>`即可通过。

**正解代码**

```java
public static int numberOf1(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }
```

### 左移版本

上面的第一个程序之所以会出现无限循环，是因为我们改变了被输入的数本身。换个角度，我们不改变输入的数，而是通过改变一个变量，那么不管是输入正负数都能得到正确答案。

所以用一个1和输入数的每一位相与，然后将这个1不断**左移**。

```java
public static int numberOf1Left(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;

    }
```

在这个解法中，循环的次数等于整数二进制的位数，32位的整数需要循环32次。下面介绍一种算法，整数中有几个1就只需要循环几次

### 给人 带来惊喜的解法

把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变成0.那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。

```java
public static int numberOf1Best(int num) {
        int count = 0;
        while (num != 0) {
            num = (num - 1) & num;
            count++;
        }

        return count;
    }

```

## 测试用例

* 正数（包括边界值1，0x7FFFFFFF）
* 负数（包括边界值0x80000000，0xFFFFFFFF）
* 0

## 一个整数是否为2的整数次方

题目：用一条语句判断一个整数是不是2的整数次方。

> 一个整数如果是2的整数次方，那么它的二进制表示中有且只有一位是1，而其他所有位都是0.根据前面的分析，把这个整数减去1之后再和它自己做与运算，这个整数中唯一的1就会变成0

```java
 public static boolean powOf2(int n) {
        return ((n - 1) & n) == 0;
    }
```

## 改变m二进制位得到n

题目：输入两个整数m和n，计算需要改变m的二朝向表示中的多少位才能得到n。

> 比如10的二进制表示为1010，13的二进制表示为1101。需要改变1010中的3位才能得到1101。
>

我们可以分为两步解决这个问题：

​	第一步求这两个数的异或；

​	第二步统计异或结果中1的位数

```java
public static int changeM2N(int m, int n) {
        int a = m ^ n;
        int count = 0;
        while (a != 0) {
            count++;
            a = (a - 1) & a;
        }
        return count;
    }
```

# 面试题16

## 数值的整数次方

题目：实现了函数double Power(double base,int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。



### 连乘

```java
 public static double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double result = 1.0;
        int positiveExponent = Math.abs(exponent);
        for (int i = 0; i < positiveExponent; i++) {
            result = result * base;
        }
        return exponent < 0 ? 1 / result : result;
    }
```

### 快速幂

我们要求
$$
a^n
$$
，分n为奇数和偶数两种情况，如下


$$
a^n = a ^{n /2}  \times  a ^{n /2} 
$$
 ，n为偶数


$$
a^n = a ^{(n-1) /2}  \times  a ^{(n-1) /2} \times a
$$
，n为奇数

假如要求
$$
2^{32}
$$
，按照上面连乘的思路，需要进行31次乘法；采用上面的公式，只需要5次：先求平方，然后求四次方、八次方、十六次方，最后三十二次方。将时间复杂度降到了O(lg n)。

```java
public static double power2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double result = 1.0;
        int positiveExponent = Math.abs(exponent);

        while (positiveExponent != 1) {

            //判断是否为奇数
            if ((positiveExponent & 1) == 1) {
                result = result * base;
            }
            base = base * base;

            //positiveExponent 除以2
            positiveExponent = positiveExponent >> 1;
        }

        return exponent < 0 ? 1 / (result * base) : result * base;

    }
```

# 面试题17

## 打印从1到最大的n位数

题目：输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1，2，3一直到最大的3位数999

> 这道题有陷阱，可能容易想到输入4就打印1~9999，输入5就打印1~99999...那我要是输入100呢？int型不能表示出来吧，甚至更大的值，即便是long型也不能表示出来。

这是一道**大数问题**，牵涉到大数问题我们可以将其转化为字符串表示。因为字符串任意长度都行。

### 在字符串上模拟数字的加法

本题要求按照递增顺序打印出1~最大的n位十进制数，所以字符串的长度定也应该是n。首先将长度为n的字符串中每个字符初始化为0，比如n = 3时，字符串一开始为`000`。我们要做的只有两步：

- 模拟数字那样在字符串上做加法；
- 将字符串表达的数字打印出来，为了可读性需要忽略不必要的0；

从第一步得知，需要经常改变字符串，我们知道**Java中字符串是不可变对象，意味着每次对String的改变都会产生一个新的字符串对象**，这将浪费大量空间，所以在下面的程序中将使用`StringBuilder`。根据这些描述，可写出如下代码。

```java
package edu.xjtu.soto.chap17;

/**
 * 从1至m位 所有的数
 */

public class PrintToMaxOfNDigits {

    /**
     * 使用字符串模拟数字加法
     * @param n
     */
    public static void printToMaxOfNDigits1(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(0);
        }

        while (stillIncrease(sb)) {
            print(sb);
        }
    }

    /**
     * 判断sb是否还能增加1
     * @param sb
     * @return
     */
    private static boolean stillIncrease(StringBuilder sb) {
        int len = sb.length();
        int token = 0;
        for (int i = len - 1; i >= 0; i--) {
            int sum = sb.charAt(i) - '0' + token;
            if (i == len - 1) {
                sum++;
            }
            if (sum == 10) {

                if (i == 0) {
                    return false;
                } else {
                    //进位
                    sb.setCharAt(i, '0');
                    token = 1;

                }
            } else {
                //没有进位
                sb.setCharAt(i, (char) (sum + '0'));

                //自增完退出
                return true;
            }

        }
        return false;
    }

    private static void print(StringBuilder sb) {
        int start = sb.length();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;

            }
        }
        if (start < sb.length()) {
            System.out.println(sb.substring(start));
        }

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("010");
//        print(sb);

        printToMaxOfNDigits1(1);

    }
}

```

`stillIncrease`方法会对当前数进行加1操作，该方法返回一个布尔值，用来表明当前数还能不能继续增长。比如n = 3时，当前数为999已经是最大了，不能再增长，此时如果调用该方法就应该返回false，因此跳出循环，不会打印1000（虽然不打印，但实际在该方法中字符串已经从"999"被更新到了“1000”）。当当前数可以继续增长时，会先对个位上的数进行自增操作，如果此时得到的sum < 10，说明不需向前进位，直接退出并返回；如果sum == 10，说明需要向前进位，需要将当前位设置为0，然后进位设置为1，在下一循环中，需要加到在前一位上，继续判断这一位上需不需要进位......直到某位上sum  < 10循环才终止。

`print`方法，为了符合人的阅读习惯，比如"002"其实就是数字2，应保证**从左到右第一个不为0的数前面的0不会被打印出来。**

### 递归求解

```java
public class printFrom1ToMaxOfNDigitRecur {
    public static void printFrom1ToMaxOfNDigitRecur(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }

        printRecur(sb, n, -1);


    }

    private static void printRecur(StringBuilder sb, int len, int index) {
        if (index == len - 1) {
            print(sb);
            return;
        }
        for (int i = 0; i < 10; i++) {
            sb.setCharAt(index+1, (char) (i + '0'));
            printRecur(sb,len,index+1);
        }


    }

    private static void print(StringBuilder sb) {
        int start = sb.length();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;

            }
        }
        if (start < sb.length()) {
            System.out.println(sb.substring(start));
        }

    }

    public static void main(String[] args) {
        printFrom1ToMaxOfNDigitRecur(2);
    }

}

```

# 面试题18

## 删除指定链表节点

题目：在O（1）时间内删除链表节点

给定单向链表的头指针和一个节点指针，定义一个函数在O（1）时间内删除该节点，链表节点与函数的定义如下：

```java
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
```

```java
public class DeleteNode {
    public static void deleteNode(ListNode head, ListNode p) {
        if (head == null || p == null) {
            return;
        }

        //要删除的节点不是尾节点
        if (p.next != null) {
            ListNode pNext = p.next;
            p.val = pNext.val;
            p.next = pNext.next;
            pNext = null;
            //是尾节点也是头节点
        } else if (head == p) {
            head = head.next;
            //仅是尾节点
        } else {
            ListNode first = head;
            while (first.next != p) {
                first = first.next;
            }
            first.next = null;
        }
    }

}
```

## 删除链表中的重复结点

题目：在一个排序的链表中，如何删除重复的节点？

> 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

注意重复的结点不保留：并不是将重复结点删除到只剩一个，而是重复结点的全部会被删除。所以链表1->2->3->3->4->4->5 处理后不是1->2->3->4->5。



```java
public class DeleteDuplication {
    /**
     * 重新添加头结点
     * @param head
     */
    public static void deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode first = new ListNode(head.val - 1);
        first.next = head;
        ListNode pre = first;
        ListNode p = pre.next;
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                p = p.next;
                pre = pre.next;
            } else {
                p = p.next;
                while (p.val == p.next.val) {
                    p = p.next;
                }
                p = p.next;
                pre.next = p;
            }

        }

        head = first.next;
        first = null;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node31 = new ListNode(3);
        ListNode node32 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node41 = new ListNode(4);
        ListNode node42 = new ListNode(4);
        ListNode node51 = new ListNode(5);
        node11.next = node21;
        node21.next = node31;
        node31.next = node32;
        node32.next = node33;
        node33.next = node41;
        node41.next = node42;
        node42.next = node51;

        deleteDuplicate(node11);

        while (node11 != null) {
            System.out.println(node11.val);
            node11 = node11.next;
        }
    }


}
```

# 面试题19

## 正则表达式匹配

题目：请实现一个函数用来匹配包含`.`和`*`的正则表达式。模式中的字符`.`表示任意一个字符，而`*`表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串`aaa`与模式`a.a`和`ab*ac*a`匹配，但与`aa.a`和`ab*a`不匹配。

注意`.`就是一个字符，而`*`前面必须有一个字符（可以是`.`）才有意义，所以可以将`x*`看成一个整体，其中x表示任意字符。`*`在匹配时有两种情况，第二个字符是`*`或者不是。

- 第二个字符不是`*`号。这种情况很简单，第二个字符要么是`.`要么是一个具体的字符。此时如果第一个字符匹配成功了，只需将模式和文本指针都前进一位。比如`ab`和`ac`以及`ab`和`.b`，分别对应着字符一样、模式字符为`.`的情况。**第一个字符匹配失败了，直接就可以得出结论——匹配失败。**

- 第二个字符是`*`。有几种情况：

  1、`*`匹配0次，比如`a*ab`和`ab`匹配，此时需要将模式指针前移2位，文本指针保持不动；

  2、`*`匹配了1次，比如`a*b`和`ab`匹配，此时需要将模式指针前移2位，文本指针前移1位；

  3、`*`匹配了多次，比如`a*b`和`aaab`匹配，此时需要将模式保持不动，文本指针前移1位；

  **同样的比较第二个字符的前提是第一个字符已经匹配成功。**



我们将长度任意的模式和文本分解成一个或者两个字符，可以用递归地方法写出如下程序：

```java
public class Match {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    private static boolean matchCore(char[] str, char[] pattern, int s, int p) {
        if (s == str.length && p == pattern.length) {
            return true;
        }

        //模式串到头 ，文本串未到头 匹配失败
        if (p == pattern.length && s < str.length) {
            return false;
        }

        // 两种情况，1、模式和文本都没有到结尾
        // 2、或者文本到了结尾而模式还没有到结尾，此时肯定会调用else分支
        // 第二个字符是*
        if (p < pattern.length - 1 && pattern[p + 1] == '*') {
            if (s < str.length && str[s] == pattern[p] || (pattern[p] == '.' && s < str.length)) {
                return matchCore(str, pattern, s, p + 2) ||
                        matchCore(str, pattern, s + 1, p + 2) ||
                        matchCore(str, pattern, s + 1, p);
            }else {
                return matchCore(str, pattern, s, p + 2);
            }
        }

        //第二个字符不是*
        if ((s < str.length && str[s] == pattern[p]) || (pattern[p] == '.' && s < str.length)) {
            return matchCore(str, pattern, s + 1, p + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = match("aaa".toCharArray(), "a.a".toCharArray());
        System.out.println(b);
    }
}

```

如果匹配的最后两个指针都到达末尾，说明完全匹配上了，返回true。如果模式指针先于文本到达末尾，一定是匹配失败了，举个例子，`a*bcd`和`abcdefg`。

接下来的两个if分别是第二个字符为`*`和不为`*`的情况。

- 第二个字符为`*`。在保证第一个字符已经匹配上的情况下，`*`可以有三种匹配方式，有任一种方式匹配成功即可，所以return语句中用的是`||`。
- 第二个字符不为`*`。当第一个字符已经匹配上的情况下，直接将模式和文本的指针前移一位，即比较下一个字符。

如果不是上面的情况（比如第一个字符就匹配失败了），返回false。

# 面试题20

## 表示数值的字符串

题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数），例如，字符串“+100”，“5e2”，“-123”，“3.1416”及“-1E-16”都表示数值，但"12e"，"1a3.14"，“1.2.3”，“+-5”及“12e+5.4”都不是。

### 正则表达式

```java
/**
     * 正则表达式匹配
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[\\+\\-]?[0-9]*(\\.[0-9]+)?([Ee][\\+\\-]?[0-9]+)?");
    }
```







---

# 面试题38

## 字符串的排列

题目：输入一个字符串，打印出该字符串中字符的所有排列。

例如：输入字符串abc，则打印出由字符a、b、c所能排列出来的甩有字符串abc、acb、bac、bca、cab和cba

```java
public class Permutation {


    public static ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        permutationCore(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;

    }

    private static void permutationCore(char[] chars,int begin, ArrayList<String> result) {
        if (begin == chars.length - 1) {
            String s = String.valueOf(chars);
            if (!result.contains(s)) {
                result.add(s);
                return;
            }
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            permutationCore(chars, begin + 1, result);
            //交换后再交换回来
            swap(chars, i, begin);
        }

    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> result = permutation("abc");

        for (String s : result
        ) {
            System.out.println(s);

        }
    }
}

```

### 测试用例

* 功能测试（输入的字符串中有一个或者多个字符）。	
* 特殊输入测试（输入的字符串的内容为空或者null）

## 字符串的组合

如果要求字符的所有组合呢？比如abc，所有组合情况是`[a, b, c, ab, ac, bc, abc]`，包含选择1个、2个、3个字符进行组合的情况，即
$$
\sum{C_3^1 + C_3^2 + C_3^ 3}
$$
。这可以用一个for循环完成。所以关键是如何求得在n个字符里选取m个字符总共的情况数，即如何求C(n, m)

n个字符里选m个字符，有两种情况：

- 第一个字符在组合中，则需要从剩下的n-1个字符中再选m-1个字符；
- 第一个字符不在组合中，则需要从剩下的n-1个字符中选择m个字符。

上面表达的意思用数学公式表示就是
$$
C_n^m = C_{n-1}^{m-1} + C_{n-1}^m
$$


全排列的过程：

- 选择第一个字符
- 获得第一个字符固定下来之后的所有的全排列
  - 选择第二个字符
  - 获得第一+ 二个字符固定下来之后的所有的全排列

从这个过程可见，这是一个递归的过程。

```java
public class Permutation2 {
    public static ArrayList<String> permutation2(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            permutationCore(str, i,sb, result);
        }

        return result;
    }

    private static void permutationCore(String str, int num, StringBuilder sb ,ArrayList<String> list) {
        if (num == 0) {
            if (!list.contains(sb.toString())) {
                list.add(sb.toString());
                return;
            }
        }
        if (str.length() == 0) {
            return;
        }
        // 公式C(n, m) = C(n-1, m-1)+ C(n-1, m)
        // 第一个字符是组合中的第一个字符，在剩下的n-1个字符中选m-1个字符
        sb.append(str.charAt(0));  //选中第一个字符
        permutationCore(str.substring(1), num - 1, sb, list);


        // 第一个字符不是组合中的第一个字符，在剩下的n-1个字符中选m个字符
        sb.deleteCharAt(sb.length() - 1);
        permutationCore(str.substring(1), num, sb, list);


    }

    public static void main(String[] args) {
        ArrayList list1 = permutation2("abc");
        System.out.println(list1);
        ArrayList list2 = permutation2("abcca");
        System.out.println(list2);
    }
}

```

## 正方体的八个顶点

题目：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。

> 这相当于先得到a1、a2、a3、a4、a5、a6、a7和a8这8数字的所有排列，然后判断有没有某一个排列符合题目给定的条件，即a1+a2+a3+a4 = a5+a6+a7+a8,a1+a3+a5+a7 = a2+a4+a6+a8.并且 a1+ a2+a5+a6=a3+a4+a7+a8

```java
public class Permutation3 {
    public static ArrayList<int[]> possibilitiesOfCube(int[] array) {
        ArrayList<int[]> list = new ArrayList<>();
        if (array == null || array.length != 8) {
            return list;
        }
        ArrayList<int[]> result = new ArrayList<>();

        permutation(array, 0, list);
        if (list.size() > 0) {
            for (int[] a : list) {
                if (check(a)) {
                    result.add(a);
                }
            }

        }
        return result;
    }

    private static void permutation(int[] array, int begin, ArrayList<int[]> result) {
        if (begin == array.length - 1) {
            if (!has(result, array)) {
                result.add(Arrays.copyOf(array, array.length));
                return;
            }
        }

        for (int i = begin; i < array.length; i++) {
            swap(array, i, begin);
            permutation(array, begin + 1, result);
            swap(array, i, begin);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * list中的数组是包含array
     *
     * @param list
     * @param array
     * @return
     */
    private static boolean has(ArrayList<int[]> list, int[] array) {
        for (int i = 0; i < list.size(); i++) {
            if (equal(list.get(i), array)) {
                return true;
            }
        }
        return false;
    }

    /**
     * array1是否与array2值相等
     *
     * @param array1
     * @param array2
     * @return
     */
    private static boolean equal(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断各边和是满足要求
     *
     * @param array
     * @return
     */
    private static boolean check(int[] array) {

        if (array[0] + array[1] + array[2] + array[3] == array[4] + array[5] + array[6] + array[7]
                && array[0] + array[2] + array[4] + array[6] == array[1] + array[3] + array[5] + array[7]
                && array[0] + array[1] + array[4] + array[5] == array[2] + array[3] + array[6] + array[7]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] A = {1,2,3,1,2,3,2,2};
        int[] B = {1,2,3,1,8,3,2,2};
        List<int[]> list = possibilitiesOfCube(B);
        System.out.println("有" + list.size() + "种可能");
        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
```











---

# --发糖果

有N个孩子站成一排，每个孩子有一个分值。给这些孩子派发糖果，需要满足如下需求：

1、每个孩子至少分到一个糖果

2、分值更高的孩子比他相邻位的孩子获得更多的糖果

求至少需要分发多少糖果？

## 贪心算法

思路：

1. 从左到右处理递增序列，分数更高的孩子获得更多的糖果
2. 从右到左处理递增序列（即从左到右的递减序列），分数更高的孩子获得更多的糖果，两个递增序列重复的部分，取最大值（因左右两侧都需满足）

```java
public class Candy {
    public static int candy(int[] scores, int[] candys) {
        if (scores == null || scores.length < 1 || candys.length < scores.length) {
            return 0;
        }
        if (scores.length == 1) {
            candys[0] = 1;
        }
        Arrays.fill(candys, 1);
        for (int i = 0; i < scores.length-1; i++) {
            if (scores[i] < scores[i + 1]) {
                candys[i+1]++;
            }
        }
        for (int i = scores.length - 1; i > 0; i--) {
            if (scores[i] < scores[i - 1] && candys[i] >= candys[i - 1]) {
                candys[i - 1] = candys[i] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < candys.length; i++) {
            sum += candys[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] scores1 = {1,2,2};
        int[] scores2 = {1,0,2};
        int[] candys = new int[scores1.length];

        int sum1 = candy(scores1, candys);
//        int sum2 = candy(scores2, candys);

        System.out.println(Arrays.toString(candys));
        System.out.println(sum1);
    }
}

```


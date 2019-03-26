package edu.xjtu.soto.chap8;


import edu.xjtu.soto.TreeLinkNode;

/**
 * 题目：给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一节点？树中的节点除了有两个分别指向左，右节点的指针，还有一个指向父节点的指针。
 */
public class NextNode {

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

    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode("a");
        TreeLinkNode b = new TreeLinkNode("b");
        TreeLinkNode c = new TreeLinkNode("c");
        TreeLinkNode d = new TreeLinkNode("d");
        TreeLinkNode e = new TreeLinkNode("e");
        TreeLinkNode f = new TreeLinkNode("f");
        TreeLinkNode g = new TreeLinkNode("g");
        TreeLinkNode h = new TreeLinkNode("h");
        TreeLinkNode i = new TreeLinkNode("i");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = h;
        h.right = i;
        c.left = f;
        c.right = g;
        b.next = a;
        c.next = a;
        d.next = b;
        e.next = b;
        f.next = c;
        g.next = c;
        h.next = e;
        i.next = e;


        System.out.println(getNextNode(i).val);
        System.out.println(getNextNode(g));

    }

}

package edu.xjtu.soto.chap68;

import edu.xjtu.soto.CommonTreeNode;

import java.util.LinkedList;

/**
 * 普通树查找
 */
public class LastSameInCommonTree {
    public CommonTreeNode findLastSame(CommonTreeNode root, CommonTreeNode a, CommonTreeNode b) {
        if (root == null || a == null || b == null) {
            return null;
        }
        LinkedList<CommonTreeNode> path1 = new LinkedList<>();
        LinkedList<CommonTreeNode> path2 = new LinkedList<>();
        collectNode(root, a, path1);
        collectNode(root, b, path2);

        CommonTreeNode node = getLastSameNode(path1, path2);

        return node;

    }

    private boolean collectNode(CommonTreeNode root, CommonTreeNode a, LinkedList<CommonTreeNode> path) {
        path.add(root);
        if (root == a) {
            return true;
        }
        for (CommonTreeNode p : root.children) {
            if (collectNode(p, a, path)) {
                return true;
            }
        }
        path.remove(root);
        return false;
    }

    private CommonTreeNode getLastSameNode(LinkedList<CommonTreeNode> path1, LinkedList<CommonTreeNode> path2) {
        CommonTreeNode common = null;
        while (!path1.isEmpty() && !path2.isEmpty()) {
            if (path1.peek() == path2.removeFirst()) {
                common = path1.removeFirst();
            }
        }
        return common;
    }


    public static void main(String[] args) {
        CommonTreeNode a = new CommonTreeNode("A");
        CommonTreeNode b = new CommonTreeNode("B");
        CommonTreeNode c = new CommonTreeNode("C");
        CommonTreeNode d = new CommonTreeNode("D");
        CommonTreeNode e = new CommonTreeNode("E");
        CommonTreeNode f = new CommonTreeNode("F");
        CommonTreeNode g = new CommonTreeNode("G");

        a.children.add(b);
        a.children.add(c);
        a.children.add(d);

        b.children.add(e);
        b.children.add(f);

        c.children.add(g);


        LastSameInCommonTree l = new LastSameInCommonTree();
        LinkedList<CommonTreeNode> path1 = new LinkedList<>();
        LinkedList<CommonTreeNode> path2 = new LinkedList<>();
        System.out.println(l.findLastSame(a, e, g).val);
        System.out.println(l.findLastSame(a, e, f).val);

    }
}


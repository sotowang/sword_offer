package edu.xjtu.soto.chap37;

import edu.xjtu.soto.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class SerializeBT {
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        preOrxder(root, sb);

        return sb.toString();

    }

    private void preOrxder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val).append(" ");

        preOrxder(root.left, sb);
        preOrxder(root.right, sb);
    }


    private TreeNode deSerialize(String sb) {
        if (sb == null || sb.length() == 0) {
            return null;
        }

        String[] seq = sb.split("\\s");

        return reconstructBST(seq);
        


    }

    private int index = -1;
    private TreeNode reconstructBST(String[] seq) {
        index++;
        if (seq.length == 0) {
            return null;
        }

        //注意这里的写法
        if (seq[index].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(seq[index]));

        root.left = reconstructBST(seq);
        root.right = reconstructBST(seq);


        return root;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        r1.left = r2;
        r1.right = r3;

        r2.left = r4;
        r3.left = r5;
        r3.right = r6;

        SerializeBT sb = new SerializeBT();
        String str = sb.serialize(r1);
        System.out.println(str);


        TreeNode r = sb.deSerialize(str);
        System.out.println(r);

    }
}

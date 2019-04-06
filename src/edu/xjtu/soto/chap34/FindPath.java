package edu.xjtu.soto.chap34;

import edu.xjtu.soto.TreeNode;

import java.util.ArrayList;

/**
 * 题目：输入一棵二叉树和一个整数，
 * 打印出二叉树中节点值的和为输入整数的所有路径，从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root, target, path, result);
        return result;

    }

    private void preOrder(TreeNode root, int curValue, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }

        //模拟节点进栈
        path.add(root.val);
        curValue -= root.val;

        // 只有在叶子结点处才判断是否和目标值相同，若相同加入列表中
        if (root.left == null && root.right == null) {
            if (curValue == 0) {
                result.add(new ArrayList<>(path));
            }
        }
        preOrder(root.left, curValue, path, result);
        preOrder(root.right, curValue, path, result);

        path.remove(path.size() - 1);
        curValue += root.val;

    }

    public static void main(String[] args) {
        FindPath fp = new FindPath();
        TreeNode root = new TreeNode(10);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(12);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(7);


        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;


        ArrayList<ArrayList<Integer>> res = fp.findPath(root, 22);

        System.out.println(res);


    }
}

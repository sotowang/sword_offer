package edu.xjtu.soto.chap12;

/**
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左，右，上，下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3x4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下划线标出）。
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的每一行第二个格子之后，路径不能再次进入这个格子。
 */
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
        char[] path3 = m.toCharArray();
//        boolean b1 = hasPath(matrix, path1, 3, 4);
//        boolean b2 = hasPath(matrix, path2, 3, 4);
        boolean b3 = hasPath(matrix, path3, 3, 4);
//        System.out.println(b1 + "\n" + b2 + "\n" + b3);
        System.out.println(b3);

    }


}

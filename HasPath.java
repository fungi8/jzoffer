package jzoffer;

/**
 * create by fungus on 2018/6/28
 * 请设计一个函数，用来判断
 * 在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * <p>
 * 路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * <p>
 * 例如  a s a 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * b f d
 * c c e
 * e s e
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 **/


/**
 * 链接：https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
 * 来源：牛客网
 * <p>
 * 分析：回溯算法
 *  这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的
 * 第i个位置。如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
 * 重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
 * 　　由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个
 * 字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
 * 　　由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。 当矩阵中坐标为（row,col）的
 * 格子和路径字符串中相应的字符一样时，从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下一个字符
 * 如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，我们需要回到前一个，然后重新定位。
 * 　　一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
 */
public class HasPath {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchFromHere(matrix, rows, cols, i, j, 0, str, visited))
                    return true;
        }
        }
        return false;
    }

    private static boolean searchFromHere(char[] matrix, int rows, int cols, int r, int c, int index, char[] str, boolean[] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r * cols + c] != str[index] || visited[r * cols + c])
            return false;
        if (index == str.length - 1)
            return true;
        visited[r * cols + c] = true;
        if (searchFromHere(matrix, rows, cols, r - 1, c, index + 1, str, visited) ||
                searchFromHere(matrix, rows, cols, r + 1, c, index + 1, str, visited) ||
                searchFromHere(matrix, rows, cols, r, c - 1, index + 1, str, visited) ||
                searchFromHere(matrix, rows, cols, r, c + 1, index + 1, str, visited)) {
            return true;
        }
        visited[r * cols + c] = false;
        return false;
    }


    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        hasPath(arr, 3, 4, str);
    }

}

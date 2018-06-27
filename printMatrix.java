package jzoffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <time>
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 */
public class printMatrix {

    public static class Solution {
        static ArrayList<Integer> aList = new ArrayList<>();
        public static ArrayList<Integer>  printMatrix(int[][] matrix) {
            int leftTopRow = 0;
            int leftTopColumn = 0;
            int rightBottomRow = matrix.length - 1;
            int rightBottomColumn = matrix[0].length - 1;
            while (leftTopRow <= rightBottomRow && leftTopColumn <= rightBottomColumn) {
                aList.addAll(print(matrix, leftTopRow, leftTopColumn, rightBottomRow,rightBottomColumn));
                leftTopRow++;
                leftTopColumn++;
                rightBottomRow--;
                rightBottomColumn--;
            }
            return aList;
        }

        // one cycle print
        public static ArrayList print(int[][] matrix, int leftTopRow, int leftTopColumn, int rightBottomRow, int rightBottomColumn) {
            ArrayList<Integer> list = new ArrayList<>();
            int a, b; //左上角点横纵坐标
            int c, d; //右下角点横纵坐标
            a = leftTopRow;
            b = leftTopColumn;
            c = rightBottomRow;
            d = rightBottomColumn;
            //only one value
//            if (leftTopColumn == rightBottomColumn && leftTopRow == rightBottomRow) {
//                list.add(matrix[a][b]);
//            }
            //only one column
            if (leftTopColumn == rightBottomColumn) {
                while (leftTopRow <= rightBottomRow) {
                    list.add(matrix[leftTopRow++][leftTopColumn]);
                }
                return list;
            }
                //only one row
            if (leftTopRow == rightBottomRow) {
                while (leftTopColumn <= rightBottomColumn) {
                    list.add(matrix[leftTopRow][leftTopColumn++]);
                }
                return list;
            }
            int tmp = b;
            while (tmp < d) list.add(matrix[a][tmp++]);
            tmp = a;
            while (tmp < c) list.add(matrix[tmp++][d]);
            tmp = d;
            while (tmp > b) list.add(matrix[c][tmp--]);
            tmp = c;
            while (tmp > a) list.add(matrix[tmp--][b]);
            return list;
        }

        public static void main(String[] args) {
            int[][] asad = {{1,2,3,4,5}};
            ArrayList arrayList = printMatrix(asad);
            System.out.println(arrayList);
        }
    }
}

package main.test.question.arrays;

import java.util.Arrays;

/***
 *  @author : lirui
 *  @date :  2021/12/3
 *  @description : 正90°旋转矩阵
 *  给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *  1.
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *  2.
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 ***/
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int lastI = n - 1 - i;
                int lastJ = n - 1 - j;
                // 右存入temp
                temp = matrix[j][lastI];
                // 上赋值给右
                matrix[j][lastI] = matrix[i][j];
                // 左赋值给上
                matrix[i][j] = matrix[lastJ][i];
                // 下赋值给左
                matrix[lastJ][i] = matrix[lastI][lastJ];
                // temp(原右)赋值给下
                matrix[lastI][lastJ] = temp;
            }
        }
    }
}

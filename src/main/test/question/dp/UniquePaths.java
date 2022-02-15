package main.test.question.dp;

/***
 *  @author : lirui
 *  @date :  2022/2/15
 *  @description : 一个机器人位于一个 m x n 网格的左上角
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * 问总共有多少条不同的路径？
 ***/
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        // 参数错误
        if (m <= 0 || n <= 0) {
            return 0;
        }
        // 字典矩阵
        int[][] dp = new int[m][n];
        // 边界条件, 第一行和第一列都只有一种路径
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 递推公式, 从(1,1)开始,每个坐标的路径数都等于其左边和上边路径数之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

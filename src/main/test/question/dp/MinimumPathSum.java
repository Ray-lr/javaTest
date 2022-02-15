package main.test.question.dp;

/***
 *  @author : lirui
 *  @date :  2022/2/15
 *  @description :
 *  给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 ***/
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] m = {
                {1, 3, 8},
                {1, 5, 4},
                {6, 2, 1}};
        System.out.println(minimumPathSum(m));
    }

    public static int minimumPathSum(int[][] matrix) {
        // 矩阵的长宽
        int m = matrix.length;
        int n = matrix[0].length;
        // 参数错误判断
        if (n < 1) {
            return 0;
        }
        // 字典矩阵,每个点表示到达当前点的最小和
        int[][] dp = new int[m][n];
        // 边界条件,第一个点直接赋值
        dp[0][0] = matrix[0][0];
        // 第一行每个点都等于当前节点的数 加上其左边节点的最小和
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }
        // 第一列每个点都等于当前节点的数 加上其上边节点的最小和
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }
        // 递推公式
        // 从(1,1)开始,每个节点都等于当前节点的数 加上其左和其上节点中的最小和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}

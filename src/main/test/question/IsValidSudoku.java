package main.test.question;

import java.util.HashMap;
import java.util.Map;

/***
 *  @author : lirui
 *  @date :  2021/11/26
 *  @description : 
 *  请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 ***/
public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] sudo = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku1(sudo));
    }

    /**
     * @param board : 数独
     * @return : 是否有效
     * @author : lirui
     * @date :  2021/12/2
     * @description : 分别判断纵横和每个九宫格的数字是否有重复
     **/
    public static boolean isValidSudoku1(char[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map9 = new HashMap<>();
        for (int i = 0, boardLength = board.length; i < boardLength; i++) {
            // 横向9个数判断重复
            char[] chars = board[i];
            for (char aChar : chars) {
                if (aChar != '.') {
                    if (map.containsKey((int) aChar)) {
                        return false;
                    } else {
                        map.put((int) aChar, 1);
                    }
                }
            }
            // 清除临时map
            map.clear();
            // 纵向判断重复
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (map.containsKey((int) board[j][i])) {
                        return false;
                    } else {
                        map.put((int) board[j][i], 1);
                    }
                }
                // 如果在9宫格左上角,判断9宫格重复
                if (i % 3 == 0 && j % 3 == 0) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (board[i + k][j + l] != '.') {
                                if (map9.containsKey((int) board[i + k][j + l])) {
                                    return false;
                                } else {
                                    map9.put((int) board[i + k][j + l], 1);
                                }
                            }
                        }
                    }
                    map9.clear();
                }
            }
            map.clear();
        }
        return true;
    }

    // 分别用三个二维数组,表示某行某列或者某个九宫格,是否已有该数字
    public static boolean isValidSudoku2(char[][] board) {
        int length = board.length;
        boolean[][] column = new boolean[length][length];
        boolean[][] row = new boolean[length][length];
        boolean[][] cell = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // 第几个九宫格
                int k = i / 3 * 3 + j / 3;
                // 下标从0开始,所以要把1-9的数字改成0-8
                int num = board[i][j] - '0' - 1;
                // 三个里面只要有一个有当前值,即为重复
                if (column[i][num] || row[num][j] || cell[k][num]) {
                    return false;
                }
                // 都没有,再将当前值作为位置,分别放入true
                column[i][num] = row[num][j] = cell[k][num] = true;
            }
        }
        return true;
    }

    // 分别用三个一维数组表示行列或者九宫格里,当前数字是否出现过
    public static boolean isValidSudoku3(char[][] board) {
        int length = board.length;
        short[] column = new short[length];
        short[] row = new short[length];
        short[] cell = new short[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // 第几个九宫格
                int k = i / 3 * 3 + j / 3;
                // 数值(下标从0开始,所以要把1-9的数字改成0-8)
                int num = 1 << board[i][j] - '0' - 1;
                // 该数值对应的位上为1,即为重复
                if ((column[i] & num) != 0 || (row[j] & num) != 0 || (cell[k] & num) != 0) {
                    return false;
                }
                // 将该数字对应的位 置为1
                column[i] |= num;
                row[j] |= num;
                cell[k] |= num;
            }
        }
        return true;
    }
}

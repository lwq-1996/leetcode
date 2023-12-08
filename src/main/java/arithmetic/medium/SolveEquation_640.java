package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: SolveEquation_640
 * @Author: LWQ
 * @Data: 2023/12/4 22:53
 * @Description: medium
 */

/**
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解或存在的解不为整数，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 *
 *
 * 提示:
 *
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * 方程由绝对值在 [0, 100]  范围内且无任何前导零的整数和变量 'x' 组成。
 */
public class SolveEquation_640 {

    public String solveEquation(String equation) {
        return "";
    }

    public static void main(String[] args) {
        SolveEquation_640 target = new SolveEquation_640();
        String equation = "x+5-3+x=6+x-2";
        String result = target.solveEquation(equation);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/8 12:31
     * @Param [s]
     * @return java.lang.String
     * @Description: 模拟
     */
    public String solveEquation2(String s) {
        int x = 0, num = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0, op = 1; i < n; ) {
            if (cs[i] == '+') {
                op = 1; i++;
            } else if (cs[i] == '-') {
                op = -1; i++;
            } else if (cs[i] == '=') {
                x *= -1; num *= -1; op = 1; i++;
            } else {
                int j = i;
                while (j < n && cs[j] != '+' && cs[j] != '-' && cs[j] != '=') j++;
                if (cs[j - 1] == 'x') x += (i < j - 1 ? Integer.parseInt(s.substring(i, j - 1)) : 1) * op;
                else num += Integer.parseInt(s.substring(i, j)) * op;
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        else return "x=" + (num / -x);
    }
}

package tag.stackAndRecursion.parentheses;

/**
 * @Projectname: leetcode
 * @Filename: LongestValidParentheses_32_TODO
 * @Author: LWQ
 * @Data: 2024/1/13 15:05
 * @Description: hard
 */

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class LongestValidParentheses_32_HARD {

    public int longestValidParentheses(String s) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        LongestValidParentheses_32_HARD target = new LongestValidParentheses_32_HARD();
        String s = "(()";
        int result = target.longestValidParentheses(s);
        System.out.println(result);
    }
}
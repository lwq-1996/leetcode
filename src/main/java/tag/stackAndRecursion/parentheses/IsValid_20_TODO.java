package tag.stackAndRecursion.parentheses;

/**
 * @Projectname: leetcode
 * @Filename: IsValid_20_TODO
 * @Author: LWQ
 * @Data: 2024/1/13 14:57
 * @Description: easy
 */

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid_20_TODO {

    public boolean isValid(String s) {
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        IsValid_20_TODO target = new IsValid_20_TODO();
        String s = "()";
        boolean result = target.isValid(s);
        System.out.println(result);
    }
}

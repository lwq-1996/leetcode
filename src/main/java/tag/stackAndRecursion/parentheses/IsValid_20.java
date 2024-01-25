package tag.stackAndRecursion.parentheses;

/**
 * @Projectname: leetcode
 * @Filename: IsValid_20_TODO
 * @Author: LWQ
 * @Data: 2024/1/13 14:57
 * @Description: easy
 */

import java.util.*;

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
public class IsValid_20 {

    /**
     * t通过：
     * 时间详情：1ms，击败 98.59%使用 Java 的用户
     * 内存详情：40.48MB，击败 19.99%使用 Java 的用户
     *
     * @param s
     * @return
     * @desception：栈
     */
    public boolean isValid(String s) {
        int len = s.length();
        Deque<Character> deque = new ArrayDeque<>();
        boolean t = true;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' :
                    deque.push(c);
                    break;
                case '{' :
                    deque.push(c);
                    break;
                case '[' :
                    deque.push(c);
                    break;
                case ')' :
                    t = !deque.isEmpty() && deque.pop() == '(';
                    break;
                case '}' :
                    t = !deque.isEmpty() && deque.pop() == '{';
                    break;
                case ']' :
                    t = !deque.isEmpty() && deque.pop() == '[';
                    break;
            }
            if (!t) {
                return false;
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        IsValid_20 target = new IsValid_20();
        String s = "()";
        boolean result = target.isValid(s);
        System.out.println(result);
    }

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

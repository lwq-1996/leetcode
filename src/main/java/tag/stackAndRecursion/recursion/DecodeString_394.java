package tag.stackAndRecursion.recursion;

/**
 * @Projectname: leetcode
 * @Filename: DecodeString_394_TODO
 * @Author: LWQ
 * @Data: 2024/1/13 15:18
 * @Description: medium
 */

import java.util.*;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class DecodeString_394 {

    /**
     * 通过：
     * 时间详情：1ms，击败 77.94%使用 Java 的用户
     * 内存详情：40.43MB，击败 25.57%使用 Java 的用户
     *
     * @param s
     * @return
     * @desception:模拟
     *  数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止。
     */
    public String decodeString(String s) {
        Deque<Integer> digitDeque = new ArrayDeque<>();
        Deque<String> stringDeque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
                continue;
            }
            if (cur > 0) {
                digitDeque.push(cur);
                cur = 0;
            }
            if (']' == c) {
                StringBuilder stringBuilder = new StringBuilder();
                while (!stringDeque.isEmpty()) {
                    if ("[".equals(stringDeque.peek())) {
                        stringDeque.pop();
                        break;
                    }
                    stringBuilder.insert(0, stringDeque.pop());
                }
                int pop = digitDeque.pop();
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < pop; j++) {
                    builder.append(stringBuilder);
                }
                stringDeque.push(builder.toString());
            } else {
                stringDeque.push(Character.toString(c));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stringDeque.isEmpty()) {
            result.append(stringDeque.pollLast());
        }
        return result.toString();
    }


    public static void main(String[] args) {
        DecodeString_394 target = new DecodeString_394();
        String s = "3[a]2[bc]";
        String result = target.decodeString(s);
        System.out.println(result);
    }

    /**
     * @param s
     * @return
     * @desception：栈操作
     */
    int ptr;
    public String decodeString2(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    /**
     * @param s
     * @return
     * @desception：递归
     */
    String src;
    public String decodeString3(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}

package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: ReverseWords_151
 * @Author: LWQ
 * @Data: 2023/11/25 12:52
 * @Description: medium
 */

import java.util.*;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 *
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 */
public class ReverseWords_151 {

    /**
     * 通过：
     * 时间详情；5ms，击败 69.79%使用 Java 的用户
     * 内存详情：42.67MB，击败 12.61%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/27 12:41
     * @Param [s]
     * @return java.lang.String
     * @Description: 使用语言特性API - 循环
     */
    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length-1; i >= 0; i--) {
            if (split[i].length() < 1) {
                continue;
            }
            stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    public String reverseWords4(String s) {
        s.trim();
        Deque<String> d = new ArrayDeque<String>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (stringBuilder.length() > 0 && s.charAt(i) == ' ') {
                d.offerFirst(stringBuilder.toString());
                stringBuilder.setLength(0);
            } else if (s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
            }
        }
        // 最后一个单词
        if (stringBuilder.length() > 0) {
            d.offerFirst(stringBuilder.toString());
        }
        return String.join(" ", d);
    }

    public static void main(String[] args) {
        ReverseWords_151 target = new ReverseWords_151();
        String s = "the sky is blue";
        String result = target.reverseWords4(s);
        System.out.println(result);
    }

    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * @Author LWQ
     * @Date 2023/11/27 12:51
     * @Param [s]
     * @return java.lang.String
     * @Description: 双端队列
     */
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

}

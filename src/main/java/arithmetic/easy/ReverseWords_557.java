package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: ReverseWords_557
 * @Author: LWQ
 * @Data: 2023/11/25 12:50
 * @Description: easy
 */

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 */
public class ReverseWords_557 {

    /**
     * 通过：
     * 时间详情：3ms，击败 92.59%使用 Java 的用户
     * 内存详情：43.46MB，击败 5.69%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/27 12:19
     * @Param [s]
     * @return java.lang.String
     * @Description: 暴力破解
     *      按空格拆分，随后拼接每一个单词的翻转
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(new StringBuilder(split[i]).reverse()).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    /**
     * 通过：
     * 时间详情：4ms，击败 79.94%使用 Java 的用户
     * 内存详情：43.16MB，击败 30.25%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/27 12:32
     * @Param [s]
     * @return java.lang.String
     * @Description: 将单词顺序翻转，再整体翻转
     */
    public String reverseWords2(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length-1; i >= 0; i--) {
            stringBuilder.append(split[i]).append(" ");
        }
        stringBuilder.reverse();
        return stringBuilder.substring(1);
    }

    public static void main(String[] args) {
        ReverseWords_557 target = new ReverseWords_557();
        String s = "Let's take LeetCode contest";
        String result = target.reverseWords(s);
        System.out.println(result);
    }
}

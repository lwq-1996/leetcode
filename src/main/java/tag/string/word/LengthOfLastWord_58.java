package tag.string.word;

/**
 * @Projectname: leetcode
 * @Filename: LengthOfLastWord_58
 * @Author: LWQ
 * @Data: 2023/11/22 13:31
 * @Description: easy
 */

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 */
public class LengthOfLastWord_58 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.79MB，击败 18.86%使用 Java 的用户
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        int length = trim.length();
        int result = 0;
        for (int i = length-1; i >= 0; i--) {
            if (!Character.isLetter(trim.charAt(i))) {
                return result;
            }
            result++;
        }
        return result;
    }

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情；40.01MB，击败 5.13%使用 Java 的用户
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        String[] split = s.split(" ");
        return split[split.length-1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord_58 target = new LengthOfLastWord_58();
        String s = "Hello World";
        int result = target.lengthOfLastWord(s);
        System.out.println(result);
    }
}

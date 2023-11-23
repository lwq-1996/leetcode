package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: DetectCapitalUse_520
 * @Author: LWQ
 * @Data: 2023/11/22 13:20
 * @Description: easy
 */

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 *
 * 输入：word = "FlaG"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 */
public class DetectCapitalUse_520 {

    /**
     * 通过：
     * 时间详情：1ms，击败 64.06%使用 Java 的用户
     * 内存详情：40.13MB，击败 6.97%使用 Java 的用户
     * @param word
     * @return
     * @desception：ascii码对照
     *      'a' 97
     *      'z' 122
     *      'A' 65
     *      'Z' 90
     *      第一位为小写时需要额外判断第二位是否也为小写，随后的每一位都需要与第二位相同
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 通过：
     * 时间详情：1ms，击败 64.06%使用 Java 的用户
     * 内存详情：40.10MB，击败 7.57%使用 Java 的用户
     * @param word
     * @return
     * @desception：是否全部为大写 || 第二位开始后面全部为小写
     *  如果第二个字母开始后面全部为小写，就不用管首字母是否为大写了。
     */
    public boolean detectCapitalUse2(String word) {
        String substring = word.substring(1);
        return word.equals(word.toUpperCase()) || substring.equals(substring.toLowerCase());
    }

    public static void main(String[] args) {
        DetectCapitalUse_520 target = new DetectCapitalUse_520();
        String word = "abAc";
        boolean result = target.detectCapitalUse2(word);
        System.out.println(result);
    }
}

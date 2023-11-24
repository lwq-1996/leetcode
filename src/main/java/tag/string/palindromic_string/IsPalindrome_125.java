package tag.string.palindromic_string;

/**
 * @Projectname: leetcode
 * @Filename: IsPalindrome_125
 * @Author: LWQ
 * @Data: 2023/11/22 13:23
 * @Description: easy
 */


import java.util.regex.Pattern;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */
public class IsPalindrome_125 {

    /**
     * 通过：
     * 时间详情：2ms，击败 96.32%使用 Java 的用户
     * 内存详情：41.33MB，击败 55.71%使用 Java 的用户
     * @param s
     * @return
     * @desception：双指针，主要考虑怎么判断是否是字符或数字。
     *    plan-B：先筛选去掉非字符及数字，再翻转比较
     *      Character.isLetterOrDigit()  -判断是否是字符或数字
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, rigih = s.length()-1;
        while (left < rigih) {
            char pre = s.charAt(left);
            char sub = s.charAt(rigih);
            if (!Character.isLetterOrDigit(pre)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(sub)) {
                rigih--;
                continue;
            }
            if (pre != sub) {
                return false;
            }
            left++;
            rigih--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome_125 target = new IsPalindrome_125();
        String s = "A man, a plan, a canal: Panama";
        s = "0P";
        boolean result = target.isPalindrome(s);
        System.out.println(result);
    }
}

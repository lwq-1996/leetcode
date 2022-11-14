package arithmetic.easy;

import java.util.Locale;

/**
 * @Projectname: leetcode
 * @Filename: IsPalindrome_125
 * @Author: LWQ
 * @Data:2022/11/14 17:12
 * @Description: leetcode_practice
 * 
 * 
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsPalindrome_125 {

    public boolean isPalindrome(String s) {
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome_125 isPalindrome_125 = new IsPalindrome_125();
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        boolean palindrome = isPalindrome_125.isPalindrome(s);
        System.out.println(palindrome);
    }
}

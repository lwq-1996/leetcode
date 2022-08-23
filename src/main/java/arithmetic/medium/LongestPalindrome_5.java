package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: LongestPalindrome_5
 * @Author: LWQ
 * @Data:2022/8/24 00:42
 * @Description: leetcode_practice
 */

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        /// TODO 双向指针？从左向右遍历，每一个字符没有匹配项就截取掉
        /// TODO 取一个首节点，依次取匹配字符串 s，匹配上就加一位
        /// TODO 转换出一个 Char[]，作为辅助是否更容易，但应该有不需要Char数组的方法

        return s;
    }

    public static void main(String[] args) {
        LongestPalindrome_5 longestPalindrome_5 = new LongestPalindrome_5();
        String s = "babad";
        String result = longestPalindrome_5.longestPalindrome(s);
        System.out.println(result);
        System.out.println(s.indexOf("a"));
    }
}

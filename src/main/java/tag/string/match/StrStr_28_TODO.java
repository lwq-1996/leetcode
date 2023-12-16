package tag.string.match;

/**
 * @Projectname: leetcode
 * @Filename: StrStr_28_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:44
 * @Description: easy
 */

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class StrStr_28_TODO {

    public int strStr(String haystack, String needle) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        StrStr_28_TODO target = new StrStr_28_TODO();
        String haystack = "sadbutsad", needle = "sad";
        int result = target.strStr(haystack, needle);
        System.out.println(result);
    }
}

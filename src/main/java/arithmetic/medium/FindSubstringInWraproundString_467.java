package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: FindSubstringInWraproundString_467
 * @Author: LWQ
 * @Data: 2023/11/25 13:17
 * @Description: medium
 */

import java.util.Arrays;

/**
 * 定义字符串 base 为一个 "abcdefghijklmnopqrstuvwxyz" 无限环绕的字符串，所以 base 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 给你一个字符串 s ，请你统计并返回 s 中有多少 不同非空子串 也在 base 中出现。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "a"
 * 输出：1
 * 解释：字符串 s 的子字符串 "a" 在 base 中出现。
 * 示例 2：
 *
 * 输入：s = "cac"
 * 输出：2
 * 解释：字符串 s 有两个子字符串 ("a", "c") 在 base 中出现。
 * 示例 3：
 *
 * 输入：s = "zab"
 * 输出：6
 * 解释：字符串 s 有六个子字符串 ("z", "a", "b", "za", "ab", and "zab") 在 base 中出现。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */
public class FindSubstringInWraproundString_467 {

    /**
     * 通过：
     * @Author LWQ
     * @Date 2023/12/4 13:19
     * @Param [s]
     * @return int
     * @Description: 动态规划
     *  连续字母，每多一位，可能性+（上一位+1），即阶和
     */
    public int findSubstringInWraproundString(String s) {
        int[] arr = new int[26];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0 && (c - s.charAt(i-1) + 26) % 26 == 1) {
                // 连续字母
                k++;
            } else {
                k = 1;
            }
            // 若有重复字母段，记录最大的
            arr[c - 'a'] = Math.max(arr[c - 'a'], k);
        }

        return Arrays.stream(arr).sum();
    }

    public static void main(String[] args) {
        FindSubstringInWraproundString_467 target = new FindSubstringInWraproundString_467();
        String s = "abcdvw";
        int result = target.findSubstringInWraproundString(s);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/4 12:51
     * @Param [p]
     * @return int
     * @Description: 动态规划
     * 由于 s 是周期字符串，对于在 s 中的子串，只要知道子串的第一个字符（或最后一个字符）和子串长度，就能确定这个子串。例如子串以 ‘d’ 结尾，长度为 3，那么该子串为 “bcd”。
     *
     * 题目要求不同的子串个数，那么对于两个以同一个字符结尾的子串，长的那个子串必然包含短的那个。例如 “abcd” 和 “bcd” 均以 ‘d’ 结尾，“bcd” 是 “abcd” 的子串。
     *
     * 据此，我们可以定义 dp[α] 表示 p 中以字符 α 结尾且在 s 中的子串的最长长度，知道了最长长度，也就知道了不同的子串的个数。
     *
     * 如何计算 dp[α] 呢？我们可以在遍历 p 时，维护连续递增的子串长度 k。具体来说，遍历到 p[i] 时，如果 p[i] 是 p[i−1] 在字母表中的下一个字母，则将 k 加一，否则将 k 置为 1，表示重新开始计算连续递增的子串长度。然后，用 k 更新 dp[p[i]] 的最大值。
     *
     * 遍历结束后，p 中以字符 c 结尾且在 s 中的子串有 dp[c] 个。例如 dp[‘d’]=3 表示子串 “bcd”、“cd” 和 “d”。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/unique-substrings-in-wraparound-string/solutions/1514359/huan-rao-zi-fu-chuan-zhong-wei-yi-de-zi-ndvea/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findSubstringInWraproundString2(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25
                ++k;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}

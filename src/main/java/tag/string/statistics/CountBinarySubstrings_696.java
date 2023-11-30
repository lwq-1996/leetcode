package tag.string.statistics;

/**
 * @Projectname: leetcode
 * @Filename: CountBinarySubstrings_696
 * @Author: LWQ
 * @Data: 2023/11/25 13:15
 * @Description: easy
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 *
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 *
 *
 * 示例 1：
 *
 * 输入：s = "00110011"
 * 输出：6
 * 解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 * 示例 2：
 *
 * 输入：s = "10101"
 * 输出：4
 * 解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 */
public class CountBinarySubstrings_696 {

    /**
     * 通过：：8ms，击败 92.69%使用 Java 的用户
     * 内存详情：3.43MB，击败 5.17%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/30 13:30
     * @Param [s]
     * @return int
     * @Description:
     *  我们可以将字符串 s 按照 0 和 1 的连续段分组，存在 counts 数组中，例如 s=00111011，可以得到这样的 counts 数组：counts={2,3,1,2}。
     *
     * 这里 counts 数组中两个相邻的数一定代表的是两种不同的字符。假设 counts 数组中两个相邻的数字为 u 或者 v，它们对应着 u 个 0 和 v 个 1，或者 u 个 1 和 v 个 0。它们能组成的满足条件的子串数目为 min{u,v}，即一对相邻的数字对答案的贡献。
     *
     * 我们只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/count-binary-substrings/solutions/367704/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countBinarySubstrings(String s) {
        int cur = 0, last = 0, n = s.length(), result = 0;
        while (cur < n) {
            int count = 0;
            char c = s.charAt(cur);
            // 以下两行可省略
            cur++;
            count++;
            while (cur < n && c == s.charAt(cur)) {
                count++;
                cur++;
            }
            result += Math.min(last, count);
            last = count;
        }
        return result;
    }

    public static void main(String[] args) {
        CountBinarySubstrings_696 target = new CountBinarySubstrings_696();
        String s = "00110011";
        int result = target.countBinarySubstrings(s);
        System.out.println(result);
    }

    public int countBinarySubstrings2(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }

    /**
     * @Author LWQ
     * @Date 2023/11/30 13:35
     * @Param [s]
     * @return int
     * @Description:
     * 对于某一个位置 i，其实我们只关心 i−1 位置的 counts 值是多少，所以可以用一个 last 变量来维护当前位置的前一个位置，这样可以省去一个 counts 数组的空间。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/count-binary-substrings/solutions/367704/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countBinarySubstrings3(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
}

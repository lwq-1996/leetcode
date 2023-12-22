package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: CountSubstrings_647_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:53
 * @Description: medium
 */

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 */
public class CountSubstrings_647 {

    /**
     * 通过：
     * 时间详情：5ms，击败 64.25%使用 Java 的用户
     * 内存详情：44.21MB，击败 5.01%使用 Java 的用户
     *
     * @param s
     * @return
     * @desception：中心拓展法
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += comp(s, i, i);
            result += comp(s, i, i+1);
        }
        return result;
    }

    public Integer comp(String s, Integer left, Integer right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubstrings_647 target = new CountSubstrings_647();
        String s = "aaa";
        int result = target.countSubstrings(s);
        System.out.println(result);
    }

    /**
     * @param s
     * @return
     * @desception：中心拓展法
     */
    public int countSubstrings2(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    /**
     * @param s
     * @return
     * @desception：Manacher 算法
     */
    public int countSubstrings3(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }

}

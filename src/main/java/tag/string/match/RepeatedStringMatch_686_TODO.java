package tag.string.match;

/**
 * @Projectname: leetcode
 * @Filename: RepeatedStringMatch_686_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:46
 * @Description: medium
 */

import java.time.Clock;
import java.util.Arrays;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 *
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 *
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 *
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 */
public class RepeatedStringMatch_686_TODO {

    /**
     * FAIL
     * @param a
     * @param b
     * @return
     * @desception：比较前后是否需要重叠
     *  a = "aaaaaaaaaaaaaaaaaaaaaab", b = "ba";
     */
    public int repeatedStringMatch(String a, String b) {
        if (b.length() < 1) {
            return 0;
        }

        String[] split = b.split(a);
        int result = split.length-1;
        // 分割失败
        if (split.length == 1) {
            if (a.contains(b)) {
                return 1;
            } else {
                return -1;
            }
        }
        // 刚好全部截取完
        if (split.length == 0) {
            return b.length()/a.length();
        }

        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i])) {
                continue;
            }
            if (i == 0 && b.startsWith(split[i])) {
                result++;
                continue;
            }
            if (i == split.length-1 && b.endsWith(split[i])) {
                result++;
                continue;
            }
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatedStringMatch_686_TODO target = new RepeatedStringMatch_686_TODO();
        String a = "abcd", b = "cdabcdab";
        a = "a";
        b = "aa";
        int result = target.repeatedStringMatch2(a, b);
        System.out.println(result);
    }

    /**
     * @param a
     * @param b
     * @return
     * @desception：卡常
     */
    public int repeatedStringMatch2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        Clock clock = Clock.systemDefaultZone();
        long start = clock.millis();
        while (clock.millis() - start < 100) {
            if (sb.indexOf(b) != -1) return ans;
            sb.append(a);
            ans++;
        }
        return -1;
    }

    /**
     * @param a
     * @param b
     * @return
     * @desception：上下界性质
     */
    public int repeatedStringMatch3(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = sb.indexOf(b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    /**
     * @param a
     * @param b
     * @return
     * @desception：KMP
     */
    public int repeatedStringMatch4(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = strStr(sb.toString(), b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }
        return -1;
    }

    /**
     * @param a
     * @param b
     * @return
     * @字符串哈希
     */
    public int repeatedStringMatch5(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = strHash(sb.toString(), b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }
    int strHash(String ss, String b) {
        int P = 131;
        int n = ss.length(), m = b.length();
        String str = ss + b;
        int len = str.length();
        int[] h = new int[len + 10], p = new int[len + 10];
        p[0] = 1;
        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + str.charAt(i);
        }
        int r = len, l = r - m + 1;
        int target = h[r] - h[l - 1] * p[r - l + 1]; // b 的哈希值
        for (int i = 1; i <= n; i++) {
            int j = i + m - 1;
            int cur = h[j] - h[i - 1] * p[j - i + 1]; // 子串哈希值
            if (cur == target) return i - 1;
        }
        return -1;
    }
}

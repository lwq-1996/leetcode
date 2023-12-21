package tag.string.match;

/**
 * @Projectname: leetcode
 * @Filename: RepeatedSubstringPattern_459_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:48
 * @Description: easy
 */

import java.util.Arrays;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class RepeatedSubstringPattern_459 {

    public boolean repeatedSubstringPattern(String s) {
        System.out.println((s + s).indexOf(s, 1));
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern_459 target = new RepeatedSubstringPattern_459();
        String s = "aba";
        boolean result = target.repeatedSubstringPattern(s);
        System.out.println(result);
    }

    /**
     * @param s
     * @return
     * @desception：枚举
     */
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param s
     * @return
     * @desception：字符串匹配
     * 我们将两个 s 连在一起，并移除第一个和最后一个字符。如果 s 是该字符串的子串，那么 s 就满足题目要求。
     */
    public boolean repeatedSubstringPattern3(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    /**
     * @param s
     * @return
     * @desception：KMP
     */
    public boolean repeatedSubstringPattern4(String s) {
        return kmp(s + s, s);
    }

    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 1; i < n - 1; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param s
     * @return
     * @desception：KMP优化
     */
    public boolean repeatedSubstringPattern5(String s) {
        return kmp(s);
    }

    public boolean kmp(String pattern) {
        int n = pattern.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
    }

    /**
     * @param s
     * @return
     * @desception：s + s，去除首位后，还包含s
     */
    public boolean repeatedSubstringPattern6(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}

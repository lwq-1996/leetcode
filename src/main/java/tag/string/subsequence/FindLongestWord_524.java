package tag.string.subsequence;

/**
 * @Projectname: leetcode
 * @Filename: FindLongestWord_524_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:19
 * @Description: medium
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 */
public class FindLongestWord_524 {

    /**
     * 通过：
     * 时间详情：15ms，击败 87.98%使用 Java 的用户
     * 内存详情：43.03MB，击败 67.14%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/16 15:39
     * @Param [s, dictionary]
     * @return java.lang.String
     * @Description: 双指针 + 遍历比较（同 _392，在外面套了一层集合）
     * 如果答案不止一个，返回长度最长且字母序最小的字符串。 --此处说的最小是指字典序最小
     * String 的 compareTo() 可进行字典序比较
     */
    public String findLongestWord(String s, List<String> dictionary) {
        // 长度相同时，需要按照字典序取最小
        Collections.sort(dictionary);
        char[] chrs = s.toCharArray();
        int l1 = chrs.length;
        String result = "";
        for (int i = 0; i < dictionary.size(); i++) {
            String t = dictionary.get(i);
            int l2 = t.length();
            int m = 0, n = 0;
            while (m < l1 && n < l2) {
                if (t.charAt(n) == chrs[m]) {
                    n++;
                }
                m++;
            }

            if (n == l2) {
                result = result.length() < l2 ? t : result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindLongestWord_524 target = new FindLongestWord_524();
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea", "ab");
        String result = target.findLongestWord3(s, dictionary);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/16 15:43
     * @Param [s, dictionary]
     * @return java.lang.String
     * @Description: 双指针
     */
    public String findLongestWord2(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }

    /**
     * @Author LWQ
     * @Date 2023/12/16 15:49
     * @Param [s, dictionary]
     * @return java.lang.String
     * @Description: 排序，按照 长度 + 字典序 进行排序，随后找出字典中第一个能匹配的字符即为结果
     */
    public String findLongestWord3(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                } else {
                    return word1.compareTo(word2);
                }
            }
        });
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                return t;
            }
        }
        return "";
    }

    /**
     * @Author LWQ
     * @Date 2023/12/16 15:51
     * @Param [s, dictionary]
     * @return java.lang.String
     * @Description: 动态规划（同 _392/Plan3），对template（s）进行预处理
     */
    public String findLongestWord4(String s, List<String> dictionary) {
        int m = s.length();
        int[][] f = new int[m + 1][26];
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        String res = "";
        for (String t : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > res.length() ||  (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}

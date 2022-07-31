package arithmetic.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set set = new HashSet<>();
        int star = -1;
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while(star + 1 < length && !set.contains(s.charAt(star + 1))) {
                set.add(s.charAt(star + 1));
                ++star;
            }
            result = Math.max(result, star - i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring_3 = new LengthOfLongestSubstring_3();
        int i = lengthOfLongestSubstring_3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
        lengthOfLongestSubstring_3.lengthOfLongestSubstringPer("abcabcbb");
    }

    /**
     * 优秀方案
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringPer(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}

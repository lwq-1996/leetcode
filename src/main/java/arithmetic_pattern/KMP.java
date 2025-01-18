package arithmetic_pattern;

/**
 * @Projectname: leetcode
 * @Filename: KMP
 * @Author: LWQ
 * @Data: 2025/1/7 14:47
 * @Description: KMP算法
 *  核心next数组（最长公共前后缀）
 */

public class KMP {

    /**
     * @Author LWQ
     * @Date 2025/1/7 14:55
     * @Param [s1, s2]
     * @return int
     * @Description: s1 中寻找 s2 字串的开头下标位置
     */
    public static int kmp(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int n = s1.length(), m = s2.length();
        // x(s1的当前比较位置) y(s2的当前比较位置)
        int x = 0, y = 0;
        int[] next = nextArray(arr2, m);

        while (x < n && y < m) {
            if (arr1[x] == arr2[y]) {
                // 两字串当前位置相同，后移比较
                x++;
                y++;
            } else if (y == 0) {
                // 当前s1中没有能匹配的位置，s1后移进行，此时s1与s2头开始比较
                x++;
            } else {
                // 跳跃比较位置(最长公共前缀 next 数组)
                y = next[y];
            }
        }

        return y == m ? x - y: -1;
    }

    /**
     * @Author LWQ
     * @Date 2025/1/7 17:26
     * @Param [pattern, len]
     * @return int[]
     * @Description: 当前位置之前的子串的最长公共前后缀（不包含当前字符、不包含整个字串自身）
     *  next[i] 记录的是i - 1 的字串的最长公共前后缀，即当前位置之前的字串。
     */
    private static int[] nextArray(char[] pattern, int len) {
        if (len == 1) {
            return new int[]{-1};
        }
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        for (int i = 2; i < len; i++) {
            int t = i - 1;
            // pattern[i - 1] 计算的是当前位置之前的最长公共前后缀，结果中不包含最后一位的next值
            while (t > 0 && pattern[next[t]] != pattern[i - 1]) {
                t = next[t];
            }

            // next[0] = -1， + 1为0
            next[i] = next[t] + 1;
        }

        return next;
    }

    private static int[] nextArray2(char[] pattern, int len) {
        if (len == 1) {
            return new int[]{-1};
        }
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;

        int t = 2, cn = 0;
        while (t < len) {
            if (pattern[t - 1] == pattern[cn]) {
                next[t++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[t] = 0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        KMP.kmp("abddfaa", "aabaacaa");
    }

}

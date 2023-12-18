package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: IsSubsequence_392_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:17
 * @Description: easy
 */

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class IsSubsequence_392 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.50MB，击败 45.23%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/16 13:52
     * @Param [s, t]
     * @return boolean
     * @Description: 遍历，逐个比较
     */
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        int cur = 0;
        for (int i = 0; i < l1; i++) {
            char c = s.charAt(i);
            while (cur < l2) {
                if (c == t.charAt(cur)) {
                    break;
                }
                cur++;
            }
            cur++;
            if (cur > l2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsSubsequence_392 target = new IsSubsequence_392();
        String s = "abcc";
        String t = "ahbgdc";
        boolean result = target.isSubsequence3(s, t);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/16 14:01
     * @Param [s, t]
     * @return boolean
     * @Description: 双指针
     */
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * @Author LWQ
     * @Date 2023/12/16 14:02
     * @Param [s, t]
     * @return boolean
     * @Description: 动态规划 （较类似于 KMP算法，先做预处理）
     *
     * 该解法中对 t 的处理与 s 无关，且预处理完成后，可以利用预处理数组的信息，线性地算出任意一个字符串 s 是否为 t 的子串。这样我们就可以解决「后续挑战」啦。
     * 前面的双指针的做法，我们注意到我们有大量的时间用于在 t 中找到下一个匹配字符。
     *
     * 这样我们可以预处理出对于 ttt 的每一个位置，从该位置开始往后每一个字符第一次出现的位置。
     *
     * 我们可以使用动态规划的方法实现预处理，令 f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置。在进行状态转移时，如果 t 中位置 i 的字符就是 j，
     * 那么 f[i][j]=i，否则 j 出现在位置 i+1 开始往后，即 f[i][j]=f[i+1][j]，因此我们要倒过来进行动态规划，从后往前枚举 i。
     * 假定下标从 0 开始，那么 f[i][j] 中有 0≤i≤m−10 ，对于边界状态 f[m−1][..]，我们置 f[m][..] 为 m，让 f[m−1][..] 正常进行转移。这样如果 f[i][j]=m，
     * 则表示从位置 i 开始往后不存在字符 j。
     *
     * 这样，我们可以利用 f 数组，每次 O(1) 地跳转到下一个位置，直到位置变为 m 或 s 中的每一个字符都匹配成功。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/is-subsequence/solutions/346539/pan-duan-zi-xu-lie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isSubsequence3(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    // 当前位置的坐标
                    f[i][j] = i;
                else
                    // 从后面拿上来，将下面的比对结果复制到当前行，当前行只需要寻找当前位置的坐标即可，已经寻找过的直接拿取
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            // 不存在
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            // 每一行中包含当前位置自己，位置在跳跃后的位置可理解为当前数已匹配完成，要去比较下一位，所以需要往下挪一位
            // 下移一位，行中包含当前数的位置
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}

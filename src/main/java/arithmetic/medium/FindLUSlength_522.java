package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: FindLUSlength_522_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:24
 * @Description: medium
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 *
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 *
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 *
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *
 *
 * 示例 1：
 *
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 *
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 *
 *
 * 提示:
 *
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 */
public class FindLUSlength_522 {

    /**
     * ABANDON
     * @Author LWQ
     * @Date 2023/12/17 11:04
     * @Param [strs]
     * @return int
     * @Description: 跨元素存在字串无法处理
     * {"abaa","abaa","eaec","eaec","eae","z"}
     */
    public int findLUSlength(String[] strs) {
        List<String> list = Arrays.asList(strs);
        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    return a.compareTo(b);
                }
            }
        });

        int size = list.size();
        int cur = size - 2;
        String comp = list.get(size-1);
        while (cur >= 0) {
            String to = list.get(cur);
            if (!comp.equals(to)) {
                return comp.length();
            } else if (cur == 0) {
                // 此时最前方的两位相等，再往前已没有元素，没有特殊序列
                return -1;
            }

            // 找下一个非子串
            while (cur > 0) {
                String next = list.get(--cur);
                // 长度相等但值不一致
                if (comp.length() == next.length() && !comp.equals(next)) {
                    break;
                }
                // 长度不一致且非字串
                if (!compare(next, comp)) {
                    break;
                }
                // 没有非字串
                if (cur == 0) {
                    return -1;
                }
            }

            // 找到最前面的一个才与其他不一致
            if (cur == 0) {
                return list.get(0).length();
            }
            comp = list.get(cur--);
        }

        return comp.length();
    }

    // a 是不是 b 的字串
    public Boolean compare(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        if (l1 > l2) {
            return false;
        }
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == l1;
    }

    public static void main(String[] args) {
        FindLUSlength_522 target = new FindLUSlength_522();
        String[] strs = {"aba","cdc","eae"};
        strs = new String[]{"a","b","c","d","e","f","a","b","c","d","e","f"};
        strs = new String[]{"abaa","abaa","eaec","eaec","eae","z"};
        int result = target.findLUSlength(strs);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/17 11:07
     * @Param [strs]
     * @return int
     * @Description: 枚举每个字符串
     * 对于给定的某个字符串 str[i]，如果它的一个子序列 sub 是「特殊序列」，那么 str[i] 本身也是一个「特殊序列」。
     *
     * 这是因为如果 sub 没有在除了 str[i] 之外的字符串中以子序列的形式出现过，那么给 sub 不断地添加字符，它也不会出现。而 str[i] 就是 sub 添加若干个（可以为零个）字符得到的结果。
     *
     * 因此我们只需要使用一个双重循环，外层枚举每一个字符串 str[i] 作为特殊序列，内层枚举每一个字符串 str[j](i≠j)，判断 str[i] 是否不为 str[j] 的子序列即可。
     *
     * 要想判断 str[i] 是否为 str[j] 的子序列，我们可以使用贪心 + 双指针的方法：即初始时指针 pti和 ptj
     * 	
     * 分别指向两个字符串的首字符。如果两个字符相同，那么两个指针都往右移动一个位置，表示匹配成功；否则只往右移动指针 ptj，表示匹配失败。如果 pti 遍历完了整个字符串，就说明 str[i] 是 str[j] 的子序列。
     *
     * 在所有满足要求的 str[i] 中，我们选出最长的那个，返回其长度作为答案。如果不存在满足要求的字符串，那么返回 −1。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/longest-uncommon-subsequence-ii/solutions/1623415/zui-chang-te-shu-xu-lie-ii-by-leetcode-s-bo2e/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findLUSlength2(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}

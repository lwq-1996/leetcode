package tag.string.subsequence;

/**
 * @Projectname: leetcode
 * @Filename: FindLUSlength_522_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:24
 * @Description: medium
 */

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
public class FindLUSlength_522_TODO {

    public int findLUSlength(String[] strs) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        FindLUSlength_522_TODO target = new FindLUSlength_522_TODO();
        String[] strs = {"aba","cdc","eae"};
        int result = target.findLUSlength(strs);
        System.out.println(result);
    }
}

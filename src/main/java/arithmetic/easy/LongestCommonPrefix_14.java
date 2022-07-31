package arithmetic.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i ++) {
            if (strs[i].startsWith(prefix)) {
                continue;
            }
            while (prefix.length() > 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (strs[i].startsWith(prefix)) {
                    break;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 longestCommonPrefix_14 = new LongestCommonPrefix_14();
        String[] strs = {"flower","flow","flight"};
        String[] strings = {"a","a","b"};
        String s = longestCommonPrefix_14.longestCommonPrefix(strings);
        String s1 = longestCommonPrefix_14.longestCommonPrefixPer(strs);
        String s2 = longestCommonPrefix_14.longestCommonPrefixPer(strings);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * 写法更优雅
     * @param strs
     * @return
     */
    public String longestCommonPrefixPer(String[] strs) {
        String prefix = strs[0];

        for (String compare : strs) {
            while (!compare.startsWith(prefix) && prefix.length() != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}

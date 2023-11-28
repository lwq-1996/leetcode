package tag.string.statistics;

/**
 * @Projectname: leetcode
 * @Filename: IsAnagram_242
 * @Author: LWQ
 * @Data: 2023/11/25 13:03
 * @Description: easy
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram_242 {

    /**
     * 通过：
     * 时间详情：1ms，击败 100.00%使用 Java 的用户
     * 内存详情：42.22MB，击败 43.42%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/28 12:50
     * @Param [s, t]
     * @return boolean
     * @Description: 计数
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int [] arr = new int[26];
        for (char var0 : s.toCharArray()) {
            arr[var0 - 'a']++;
        }
        for (char var1 : t.toCharArray()) {
            arr[var1 - 'a']--;
        }
        for (int count : arr) {
            if (count != 0) {
                return false;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        IsAnagram_242 target = new IsAnagram_242();
        String s = "anagram";
        String t = "nagaram";
        boolean result = target.isAnagram(s, t);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/11/28 13:00
     * @Param [s, t]
     * @return boolean
     * @Description: 进阶
     *  对于进阶问题，Unicode 是为了解决传统字符编码的局限性而产生的方案，它为每个语言中的字符规定了一个唯一的二进制编码。
     *  而 Unicode 中可能存在一个字符对应多个字节的问题，为了让计算机知道多少字节表示一个字符，面向传输的编码方式的 UTF−8 和 UTF−16 也随之诞生逐渐广泛使用，
     *  具体相关的知识读者可以继续查阅相关资料拓展视野，这里不再展开。
     *
     * 回到本题，进阶问题的核心点在于「字符是离散未知的」，因此我们用哈希表维护对应字符的频次即可。
     * 同时读者需要注意 Unicode 一个字符可能对应多个字节的问题，不同语言对于字符串读取处理的方式是不同的。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/valid-anagram/solutions/493231/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

}

package tag.string.statistics;

/**
 * @Projectname: leetcode
 * @Filename: FindTheDifference_389
 * @Author: LWQ
 * @Data: 2023/11/25 12:57
 * @Description: easy
 */

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */
public class FindTheDifference_389 {

    /**
     * 通过：
     * 时间详情：2ms，击败 78.41%使用 Java 的用户
     * 内存详情：40.02MB，击败 9.12%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/28 12:28
     * @Param [s, t]
     * @return char
     * @Description: 异或
     *      codePointAt() : 返回指定索引处的字符（Unicode 码位）
     */
    public char findTheDifference(String s, String t) {
        int xor = 0;
        for (int i = 0; i < s.length(); i++) {
            xor ^= s.codePointAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            xor ^= t.codePointAt(i);
        }

        return (char) xor;
    }

    /**
     * 通过：
     * 时间详情：1ms，击败 98.65%使用 Java 的用户
     * 内存详情：40.14MB，击败 5.39%使用 Java 的用户
     * 
     * @Author LWQ
     * @Date 2023/11/28 12:34
     * @Param [s, t]
     * @return char
     * @Description:
     */
    public char findTheDifference2(String s, String t) {
        int xor = 0;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            xor ^= sArr[i];
        }
        for (int i = 0; i < tArr.length; i++) {
            xor ^= tArr[i];
        }

        return (char) xor;
    }

    public static void main(String[] args) {
        FindTheDifference_389 target = new FindTheDifference_389();
        String s = "abcd";
        String t = "abcde";
        char result = target.findTheDifference(s, t);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/11/28 12:36
     * @Param [s, t]
     * @return char
     * @Description: 求和
     *      将字符串 s 中每个字符的 ASCII 码的值求和，得到 As；对字符串 t 同样的方法得到 At。两者的差值 At−As即代表了被添加的字符。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/find-the-difference/solutions/525705/zhao-bu-tong-by-leetcode-solution-mtqf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public char findTheDifference3(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}

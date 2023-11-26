package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: ReverseStr_541
 * @Author: LWQ
 * @Data: 2023/11/25 12:48
 * @Description: easy
 */

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class ReverseStr_541 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：42.71MB，击败 5.03%使用 Java 的用户
     * @param s
     * @param k
     * @return
     * @desception：使用 l 和 r 两个指针分别圈出每次需要翻转的“理论”范围，
     *  每次翻转完更新 l 和 r，同时注意范围 [l,r] 内不足 k 个的情况（将 r 与真实边界 n - 1取个 min）
     *
     */
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i += 2*k) {
            int right = i + k - 1;
            reverse(cs, i, Math.min(right, cs.length-1));
        }

        return String.valueOf(cs);
    }

    // 交换
    private void reverse(char[] cs, int left, int right) {
        while (left < right) {
            char tmp = cs[left];
            cs[left++] = cs[right];
            cs[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseStr_541 target = new ReverseStr_541();
        String s = "abcdefg";
        int k = 2;
        String result = target.reverseStr(s, k);
        System.out.println(result);
    }
}

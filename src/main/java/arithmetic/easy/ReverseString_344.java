package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: ReverseString_344
 * @Author: LWQ
 * @Data: 2023/11/25 12:45
 * @Description: easy
 */

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class ReverseString_344 {

    /**
     *通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：49.91MB，击败 5.03%使用 Java 的用户
     * @param s
     * @desceptiion：双指针
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString_344 target = new ReverseString_344();
        char[] s = {'h','e','l','l','o'};
        target.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}

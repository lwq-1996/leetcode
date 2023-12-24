package tag.bit.fast_power;

/**
 * @Projectname: leetcode
 * @Filename: SuperPow_372_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 13:14
 * @Description: medium
 */

/**
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *
 *
 * 提示：
 *
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 */
public class SuperPow_372_TODO {

    public int superPow(int a, int[] b) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        SuperPow_372_TODO target = new SuperPow_372_TODO();
        int a = 2;
        int[] b = {3};
        int result = target.superPow(a, b);
        System.out.println(result);
    }
}

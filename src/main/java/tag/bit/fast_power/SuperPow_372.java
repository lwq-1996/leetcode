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
public class SuperPow_372 {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        SuperPow_372 target = new SuperPow_372();
        int a = 2;
        int[] b = {3};
        int result = target.superPow(a, b);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2024/1/13 13:54
     * @Param [a, b]
     * @return int
     * @Description: 倒序遍历
     */
    public int superPow2(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow2(a, b[i]) % MOD);
            a = pow2(a, 10);
        }
        return ans;
    }

    public int pow2(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

    /**
     * @Author LWQ
     * @Date 2024/1/13 13:56
     * @Param [a, b]
     * @return int
     * @Description: 秦九韶算法（正序遍历）
     */
    public int superPow3(int a, int[] b) {
        int ans = 1;
        for (int e : b) {
            ans = (int) ((long) pow3(ans, 10) * pow3(a, e) % MOD);
        }
        return ans;
    }

    public int pow3(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }
}

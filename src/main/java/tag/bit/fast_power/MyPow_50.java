package tag.bit.fast_power;

/**
 * @Projectname: leetcode
 * @Filename: MyPow_50_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 13:13
 * @Description: medium
 */

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -104 <= xn <= 104
 */
public class MyPow_50 {

    /**
     * 超时：
     * x = 2.00000
     * n = -2147483648
     * @Author LWQ
     * @Date 2024/1/13 12:34
     * @Param [x, n]
     * @return double
     * @Description: 模拟
     */
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        boolean negative = n > 0;
        long m = Math.abs((long) n);

        double result = x;
        for (int i = 1; i < m; i++) {
            result *= x;
        }
        return negative ? result : 1/result;
    }

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：41.36MB，击败 16.39%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2024/1/13 13:02
     * @Param [x, n]
     * @return double
     * @Description: 分治、递归
     * n为偶数时：y * y
     * n为基数时需要额外乘上x：y * y * x
     */
    public double myPow2(double x, int n) {
        return n > 0 ? quickMul(x, n) : 1/quickMul(x, -n);
    }

    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n/2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        MyPow_50 target = new MyPow_50();
        double x = 2.0;
        int n = 10;
        double result = target.myPow2(x, n);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2024/1/13 13:36
     * @Param [x, n]
     * @return double
     * @Description: 快速幂 + 迭代
     * https://leetcode.cn/problems/powx-n/solutions/238559/powx-n-by-leetcode-solution/
     *
     * x^2 * x^3 = x^(2+3)
     * n的二进制表示的每一位1都表示一个计算元素
     */
    public double myPow3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}

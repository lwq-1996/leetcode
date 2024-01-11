package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: FindNthDigit_400_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 13:06
 * @Description: medium
 */

/**
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 */
public class FindNthDigit_400 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.23MB，击败 17.28%使用 Java 的用户
     *
     * @param n
     * @return
     * @desception：找规律，首先找出结果位于哪个区间、再找出具体数、最后在结果数中找出第几位
     * 范围          有多少个数    位数
     * 10~99        90          *2
     * 100~999      900         *3
     * 1000~9999    9000        *4
     */
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int digit = 1, rank = 1;
        // 找出结果位于那个区间
        while (n > 0) {
            long cur = (long) 9 * digit * rank;
            /*// 防止int越界
            if (cur < 0) {
                cur = Integer.MAX_VALUE;
            }*/
            if (cur > n) {
                break;
            }
            n -= cur;
            digit *= 10;
            rank++;
        }

        // 结果位于哪个具体的数
        int remainder = n % rank;
        // n/rank刚好除尽时为上一个数的最后一位，需要减掉1
        int div = digit + n/rank + (remainder == 0 ? -1 : 0);
        /*if (n < rank) {

        } else if (n == rank) {
            div--;
        }else if (remainder == 0) {
            div--;
        }*/

        char[] chars = Integer.toString(div).toCharArray();
        // 刚好除尽，为当前数最后一位
        if (remainder == 0) {
            return chars[chars.length-1] - '0';
        }

        return chars[remainder-1] - '0';
    }

    public static void main(String[] args) {
        FindNthDigit_400 target = new FindNthDigit_400();
        int n = 1000000000;
        int result = target.findNthDigit(n);
        System.out.println(result);
    }

    public int findNthDigit2(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}

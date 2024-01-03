package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: AddDigits_258_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:50
 * @Description: easy
 */

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 2:
 *
 * 输入: num = 0
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1
 *
 *
 * 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
 */
public class AddDigits_258 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.93MB，击败 5.03%使用 Java 的用户
     *
     * @param num
     * @return
     * @desception：模拟
     *  遍历计算
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
            if (num == 0 && result >= 10) {
                num = result;
                result = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AddDigits_258 target = new AddDigits_258();
        int num = 19;
        int result = target.addDigits(num);
        System.out.println(result);
    }

    /**
     * @param num
     * @return
     * @desception：数学
     */
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigits3(int num) {
        if (num==0) return 0;
        if (num%9==0) return 9;
        return num%9;
    }
}

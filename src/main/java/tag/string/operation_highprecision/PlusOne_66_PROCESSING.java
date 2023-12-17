package tag.string.operation_highprecision;

/**
 * @Projectname: leetcode
 * @Filename: PlusOne_66_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:27
 * @Description: easy
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne_66_PROCESSING {

    /**
     * 通过：
     * 时间详情：1ms，击败 4.78%使用 Java 的用户
     * 内存详情：40.29MB，击败 5.20%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 13:14
     * @Param [digits]
     * @return int[]
     * @Description: 使用额外空间
     */
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int digit = digits[i];
            stack.push((digit+count) % 10);
            count = (digit+count)/10;
        }
        // 加一后位数发生变化
        if (count == 1) {
            stack.push(count);
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.69MB，击败 84.69%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 13:34
     * @Param [digits]
     * @return int[]
     * @Description: 倒序遍历寻找第一位不为 9 的数，该位+1，后面全部为0
     */
    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        int cur = len - 1;
        while (cur >= 0) {
            if (digits[cur] < 9) {
                break;
            }
            cur--;
        }

        int[] result;
        // 全为 9，数组大小需要加一位
        if (cur < 0) {
            result = new int[len+1];
            result[0] = 1;
            return result;
        }

        result = Arrays.copyOf(digits, len);
        result[cur] = digits[cur]+1;
        // 后面全部置 0
        for (int i = cur+1; i < len; i++) {
            result[i] = 0;
        }

        return result;
    }

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.95MB，击败 40.69%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 13:59
     * @Param [digits]
     * @return int[]
     * @Description: 数组原地计算，最后统计是否最高位进位
     */
    public int[] plusOne3(int[] digits) {
        int len = digits.length;
        // +1
        int count = 1;
        for (int i = len-1; i >= 0; i--) {
            int digit = digits[i];
            digits[i] = (digit+count) % 10;
            count = (digit+count) / 10;
            if (count < 1) {
                break;
            }
        }

        if (count > 0) {
            digits = new int[len+1];
            digits[0] = 1;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne_66_PROCESSING target = new PlusOne_66_PROCESSING();
        int[] digits = {1,2,3};
//        digits = new int[]{9,9,9};
        int[] result = target.plusOne3(digits);
        System.out.println(Arrays.toString(result));
    }
}

package arithmetic.easy;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 
 *
 * 示例1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne_66 {


    /**
     * 转成数字会有 int整型溢出的问题，会与结果不符
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        double temp = 0;
        int current = digits.length -1;
        for (int i = 0; i < digits.length; i++) {
            temp += Math.pow(10, current) * digits[i];
            --current;
        }

        temp += 1;
        int size = (int) Math.log10(temp);
        int[] result = new int[size + 1];
        for (int i = 0; i < result.length; i++) {
            double dd = temp/Math.pow(10, size);
            result[i] = (int)(dd);
            temp = temp%Math.pow(10, size);
            --size;
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne_66 plusOne_66 = new PlusOne_66();
        int[] digits = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5};
        int[] ints = plusOne_66.plusOne(digits);
        System.out.println(Arrays.toString(ints));

        int[] digits2 = {1, 2, 3, 4};
        int[] ints2 = plusOne_66.plusOne(digits);
        System.out.println(Arrays.toString(ints2));
    }

    /**
     *  尾数不是9，直接尾数 +1返回，
     *  每进入下一次for循环，代表上一位为9，已经进位，本次循环再次判断是否为9，不为9当前位 +1返回，
     *  若for循环结束未结束返回，说明所有的都是9，新建大1的数组，首位置为1，其余位默认为0
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}

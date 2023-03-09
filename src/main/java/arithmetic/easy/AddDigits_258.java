package arithmetic.easy;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2 
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于2 是一位数，所以返回 2。
 * 示例 2:
 *
 * 输入: num = 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddDigits_258 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了99.24%的用户
     * 通过测试用例：1101 / 1101
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int result = num;
        while (result > 9) {
            num = result;
            result = 0;
            while (num > 0) {
                result += (num%10);
                num /= 10;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AddDigits_258 addDigits_258 = new AddDigits_258();
        int num = 10;
        int result = addDigits_258.addDigits(num);
        System.out.println(result);
    }

    /**
     * 数学方案
     * @param num
     * @return
     */
    public int addDigits2(int num){
        return (num-1)%9+1;
    }

    /**
     * 递归
     */
    public int addDigits3(int num) {

        if (num < 10) {
            return num;
        }

        return addDigits3(num / 10+ num % 10);
    }
}

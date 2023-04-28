package arithmetic.medium;

/**
 * 给你两个整数，被除数dividend和除数divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 *
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 *
 * 返回被除数dividend除以除数divisor得到的 商 。
 *
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231, 231− 1] 。本题中，如果商 严格大于 231− 1 ，则返回 231− 1 ；如果商 严格小于 -231 ，则返回 -231 。
 *
 * 
 *
 * 示例1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * 示例2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 * 
 *
 * 提示：
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Divide_29 {

    // 未完成
    public int divide2(int dividend, int divisor) {
        /**
         * 模拟计算机除法运算
         *  1. 按照除数高位到低位的数字依次和除数进行比较；
         *  2. 如果大于等于被除数，则此步结果记为1，并求得余数；
         *  3. 如果小于被除数，则此步结果记为0，将上一步的余数左移一位加上上一位的数字再次比较，以此类推；
         *  4. 最后将结果相连，即得出商，最后的余数即为求余的结果。
         *
         *  Integer.toBinaryString(num); num为负数时，该方法返回的是补码
         *  处理负数、处理int边界值 -2147483648
         */

        if (dividend == divisor) {return 1;}
        if (dividend == -divisor) {return -1;}
        if (dividend != -2147483648 && ((dividend < divisor && dividend > 0) || (dividend > divisor && dividend < 0 && divisor < 0)) || (dividend != divisor && divisor == -2147483648)) {
            return 0;
        }
        boolean flag = true;
        if (dividend < 0) {
            dividend = -dividend;
            flag = flag ? false : true;
        }
        if (divisor < 0) {
            divisor = -divisor;
            flag = flag ? false : true;
        }

        byte[] bytes = Integer.toBinaryString(dividend).getBytes();
        int result = 0;
        int remainder = 0;
        for (int i = 0; i < bytes.length; i++) {
            result <<= 1;
            int curreent = bytes[i] - 48;
            remainder = (remainder << 1) + curreent;
            if (remainder >= divisor) {
                result += 1;
                remainder -= divisor;
            } else {
                result += 0;
            }
        }

        if (result == 0) {
            return 0;
        }
        return flag ? ((-result == -2147483648) ? (result - 1) : result) : -result;
    }

    public int divide(int dividend, int divisor) {
        /**
         * 模拟计算机除法运算（只支持正数除法运算）：
         *  1. 按照除数高位到低位的数字依次和除数进行比较；
         *  2. 如果大于等于被除数，则此步结果记为1，并求得余数；
         *  3. 如果小于被除数，则此步结果记为0，将上一步的余数左移一位加上上一位的数字再次比较，以此类推；
         *  4. 最后将结果相连，即得出商，最后的余数即为求余的结果。
         */
        byte[] bytes = Integer.toBinaryString(dividend).getBytes();
        int result = 0;
        int remainder = 0;
        for (int i = 0; i < bytes.length; i++) {
            result <<= 1;
            int curreent = bytes[i] - 48;
            remainder = (remainder << 1) + curreent;
            if (remainder >= divisor) {
                result += 1;
                remainder -= divisor;
            } else {
                result += 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Divide_29 divide_29 = new Divide_29();
        int dividend =  -2147483648;
        int divisor = 1;
        dividend = -222;
        divisor = -3;
        int result = divide_29.divide2(dividend, divisor);
        System.out.println(result);
    }

    public int divide3(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}

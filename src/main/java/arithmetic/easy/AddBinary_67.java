package arithmetic.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 * 
 *
 * 示例1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary_67 {

    /**
     * 执行用时：
     * 2 ms, 在所有 Java 提交中击败了27.62%的用户
     * 内存消耗：
     * 41.5 MB, 在所有 Java 提交中击败了15.71%的用户
     */
    public String addBinary_1(String a, String b){
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        char[] chars_a = a.toCharArray();
        char[] chars_b = b.toCharArray();
        int num_a = 0;
        int num_b = 0;
        int current = 0;
        int carry = 0;
        int temp = 0;
        StringBuilder builder = new StringBuilder();

        while (current < chars_a.length || current < chars_b.length || carry == 1) {
            num_a = current < chars_a.length ? Integer.valueOf(String.valueOf(chars_a[current])) : 0;
            num_b = current < chars_b.length ? Integer.valueOf(String.valueOf(chars_b[current])) : 0;
            temp = num_a + num_b + carry;
            carry = temp/2;
            builder.append(temp%2);
            ++current;
        }

        return builder.reverse().toString();
    }

    /**
     * 模拟进位
     */
    public String addBinary_2(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while(i >= 0 || j >= 0) {
            // 看相加后是1 还是 0
            if(i >= 0) c += a.charAt(i --) - '0';
            if(j >= 0) c += b.charAt(j --) - '0';
            stb.append(c % 2);
            // 右移保留相加后的进位数
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }

    public static void main(String[] args) {
        AddBinary_67 addBinary_67 = new AddBinary_67();
        String a = "1010";
        String b = "1011";

        String s = addBinary_67.addBinary_2(a, b);
        System.out.println(s);
        char[] chars = a.toCharArray();
        System.out.println(Integer.valueOf(String.valueOf(chars[0])));
    }
}

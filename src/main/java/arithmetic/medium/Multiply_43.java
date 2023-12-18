package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: Multiply_43_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:33
 * @Description: medium
 */

/**
 * @给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class Multiply_43 {

    /**
     * 通过：
     * 时间详情：14ms，击败 36.47%使用 Java 的用户
     * 内存详情：42.55MB，击败 34.35%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 14:55
     * @Param [num1, num2]
     * @return java.lang.String
     * @Description: 模拟，做加法，遍历逐个计算
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();

        StringBuilder result = new StringBuilder();
        for (int i = l1-1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            // 进位数
            int carry = 0;
            StringBuilder multiply = new StringBuilder();
            // 计算乘积
            for (int j = l2-1; j >= 0; j--) {
                int mul = 1;
                mul = n1 * (num2.charAt(j) - '0') + carry;
                multiply.append(mul % 10);
                carry = mul / 10;
            }
            // 首位进位
            if (carry > 0) {
                multiply.append(carry);
            }
            multiply.reverse();
            // 差位补0
            for (int k = 0; k < l1-i-1; k++) {
                multiply.append("0");
            }
            result = add(result.toString(), multiply.toString());
        }
        return result.toString();
    }

    public StringBuilder add(String a, String b) {
        StringBuilder add = new StringBuilder();
        int l1 = a.length()-1, l2 = b.length()-1;
        int sum = 0;
        while (l1 >= 0 || l2 >= 0) {
            sum += l1>=0 ? a.charAt(l1)-'0' : 0;
            sum += l2>=0 ? b.charAt(l2)-'0' : 0;
            add.append(sum % 10);
            sum /= 10;
            l1--;
            l2--;
        }
        if (sum > 0) {
            add.append("1");
        }
        return add.reverse();
    }

    /**
     * 通过：
     * 时间详情：1ms，击败 100.00%使用 Java 的用户
     * 内存详情：40.55MB，击败 52.52%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 15:46
     * @Param [num1, num2]
     * @return java.lang.String
     * @Description: 做乘法，同Plan3
     */
    public String multiply3(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans = new int[l1+l2];

        for (int i = l1-1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = l2-1; j >= 0; j--) {
                ans[i+j+1] += (n1 * (num2.charAt(j) - '0'));
            }
        }

        // 处理进位
        for (int i = ans.length-1; i > 0 ; i--) {
            ans[i-1] += (ans[i] / 10);
            ans[i] %= 10;
        }

        StringBuilder result = new StringBuilder();
        int index = ans[0] == 0 ? 1 : 0;
        while (index < ans.length) {
            result.append(ans[index++]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Multiply_43 target = new Multiply_43();
        String num1 = "123", num2 = "34";
        String result = target.multiply3(num1, num2);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/17 15:32
     * @Param [num1, num2]
     * @return java.lang.String
     * @Description: 做乘法
     * 使用数组记录计算过程中的值，每次记录乘积，最后同一处理进位
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}

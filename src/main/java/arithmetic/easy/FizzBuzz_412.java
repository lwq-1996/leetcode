package arithmetic.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: FizzBuzz_412
 * @Author: LWQ
 * @Data: 2023/12/4 22:40
 * @Description: easy
 */

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 *
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * 示例 3：
 *
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 104
 */
public class FizzBuzz_412 {

    /**
     * 通过：
     * 时间详情：1ms，击败 99.32%使用 Java 的用户
     * 内存详情：43.24MB，击败 85.97%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/5 12:59
     * @Param [n]
     * @return java.util.List<java.lang.String>
     * @Description:
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            int remainder_3 = i % 3;
            int remainder_5 = i % 5;
            if (remainder_3 == 0 && remainder_5 == 0) {
                result.add("FizzBuzz");
            } else if (remainder_3 == 0) {
                result.add("Fizz");
            } else if (remainder_5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz_412 target = new FizzBuzz_412();
        int n = 3;
        List<String> list = target.fizzBuzz(n);
        System.out.println(list);
    }
}

package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: Compress_443
 * @Author: LWQ
 * @Data: 2023/12/4 22:58
 * @Description: medium
 */

/**
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 *
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 *
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 *
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
 * 示例 3：
 *
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 *
 *
 * 提示：
 *
 * 1 <= chars.length <= 2000
 * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 */
public class Compress_443 {

    /**
     * 题目判定有问题
     * @Author LWQ
     * @Date 2023/12/11 13:00
     * @Param [chars]
     * @return int
     * @Description: 题目判定有问题
     * 题目判定有问题，需要在原数组中将新的压缩字符按序压入chars
     * 若使用当前字符与下一字符相比，会出现提前将chars元素变更，导致结果错误的情况。需要使用当前字符与上一字符进行比较；
     */
    public int compress(char[] chars) {
        int length = chars.length;
        if (length == 1) {
            return 1;
        }
        int write = 0, count = 0;
        char current = chars[0];
        for (int i = 0; i < length; i++) {
            if (current == chars[i]) {
                count++;
                continue;
            }

            chars[write++] = current;
            current = chars[i];
            write = reverse(chars, write, count);
            // 当前已统计，从1开始
            count = 1;
        }

        chars[write++] = current;
        reverse(chars, write, count);

        return write;
    }

    public int reverse(char[] chars, int write, int count) {
        while (count > 0) {
            if (count > 10) {
                chars[write++] = (char) ('0' + count/10);
                count %= 10;
            } else {
                if (count > 1) {
                    chars[write++] = (char) ('0' + count);
                }
                count = 0;
            }
        }
        return write;
    }



    public static void main(String[] args) {
        Compress_443 target = new Compress_443();
        char[] chars = {'a','a','b','b','c','c','c'};
//        chars = new char[]{'a'};
        chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int result = target.compress(chars);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/11 12:56
     * @Param [chars]
     * @return int
     * @Description: 双指针
     */
    public int compress2(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse2(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse2(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

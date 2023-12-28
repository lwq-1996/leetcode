package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: ValidUtf8_393_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:44
 * @Description: medium
 */

/**
 * 给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 * 这是 UTF-8 编码的工作方式：
 *
 *       Number of Bytes  |        UTF-8 octet sequence
 *                        |              (binary)
 *    --------------------+---------------------------------------------
 *             1          | 0xxxxxxx
 *             2          | 110xxxxx 10xxxxxx
 *             3          | 1110xxxx 10xxxxxx 10xxxxxx
 *             4          | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * x 表示二进制形式的一位，可以是 0 或 1。
 *
 * 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 *
 *
 * 示例 1：
 *
 * 输入：data = [197,130,1]
 * 输出：true
 * 解释：数据表示字节序列:11000101 10000010 00000001。
 * 这是有效的 utf-8 编码，为一个 2 字节字符，跟着一个 1 字节字符。
 * 示例 2：
 *
 * 输入：data = [235,140,4]
 * 输出：false
 * 解释：数据表示 8 位的序列: 11101011 10001100 00000100.
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个 3 字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 *
 * 提示:
 *
 * 1 <= data.length <= 2 * 104
 * 0 <= data[i] <= 255
 */
public class ValidUtf8_393 {

    /**
     * 通过：
     * 时间详情：1ms，击败 99.49%使用 Java 的用户
     * 内存详情：43.72MB，击败 5.13%使用 Java 的用户
     *
     * @param data
     * @return
     * @desception：逐位遍历,模拟
     */
    public boolean validUtf8(int[] data) {
        // count - 后续需要识别的字节数
        int count = 0, len = data.length;
        for (int i = 0; i < len; i++) {
            int n = data[i];
            if (count > 0) {
                // 不为10开头
                if (n >> 6 != 2) {
                    return false;
                }
                count--;
                continue;
            }

            // 一字节
            if (n >> 7 == 0) {
                continue;
            }

            // 多字节
            // 高位数，当前数为第一字节，count为后续需要识别的字节数，所以从第二位开始统计
            int high = Integer.highestOneBit(n) >> 1;
            while ((n & high) == high) {
                count++;
                high >>= 1;
                // 最长4各字节，后续需要识别的字节数大于3则错误
                if (count > 3) {
                    return false;
                }
            }

            // 字节开头为 10xxxxxx 时错误
            if (count < 1) {
                return false;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        ValidUtf8_393 target = new ValidUtf8_393();
        int[] data = {197,130,197,130,1};
        data = new int[]{145};
        System.out.println(Integer.toBinaryString(145));
        boolean result = target.validUtf8(data);
        System.out.println(result);
    }
}

package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: MaximumSwap_670_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 13:01
 * @Description: medium
 */

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 */
public class MaximumSwap_670 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.28MB，击败 13.15%使用 Java 的用户
     *
     * @param num
     * @return
     * @desception：遍历
     * 使用额外空间下寻找最大数与最小数
     */
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int len = chars.length;
        int maxId = len - 1;
        int min = -1, max = -1;
        for (int i = len-1; i >= 0; i--) {
            if (chars[i] > chars[maxId]) {
                maxId = i;
            } else if (chars[i] < chars[maxId]) {
                max = maxId;
                min = i;
            }
        }

        if (min >= 0) {
            swap(chars, min, max);
            return Integer.parseInt(new String(chars));
        }

        return num;
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {
        MaximumSwap_670 target = new MaximumSwap_670();
        int num = 9987;
        int result = target.maximumSwap(num);
        System.out.println(result);
    }

    /**
     * @param num
     * @return
     * @desception：直接遍历
     * 由于对于整数 num 的十进制数字位长最长为 8 位，任意两个数字交换一次最多有 28 种不同的交换方法，因此我们可以尝试遍历所有可能的数字交换方法即可，并找到交换后的最大数字即可。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/maximum-swap/solutions/1818457/zui-da-jiao-huan-by-leetcode-solution-lnd5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maximumSwap2(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap2(charArray, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                swap2(charArray, i, j);
            }
        }
        return maxNum;
    }

    public void swap2(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    /**
     * @param num
     * @return
     * @desception：贪心
     */
    public int maximumSwap3(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIdx = n - 1;
        int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] > charArray[maxIdx]) {
                maxIdx = i;
            } else if (charArray[i] < charArray[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 >= 0) {
            swap3(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }

    public void swap3(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}

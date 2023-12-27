package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: TotalHammingDistance_477_PROCESSING
 * @Author: LWQ
 * @Data: 2023/12/27 13:01
 * @Description: medium
 */

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间 汉明距离的总和 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,14,2]
 * 输出：6
 * 解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6
 * 示例 2：
 *
 * 输入：nums = [4,14,4]
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 109
 * 给定输入的对应答案符合 32-bit 整数范围
 */
public class TotalHammingDistance_477 {

    /**
     * 通过：
     * 时间详情：2041ms，击败 6.10%使用 Java 的用户
     * 内存详情：43.65MB，击败 18.59%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/27 13:04
     * @Param [nums]
     * @return int
     * @Description: 暴力破解
     */
    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                result += Integer.bitCount(nums[i] ^ nums[j]);
//                result += hammingDistance(nums[i] ^ nums[j]);
            }
        }

        return result;
    }

    public int hammingDistance(int xoy) {
        int count = 0;
        while (xoy != 0) {
            xoy &= xoy - 1;
            count++;
        }
        return count;
    }

    /**
     * 通过：
     * 时间详情：17ms，击败 33.54%使用 Java 的用户
     * 内存详情：43.74MB，击败 14.63%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/27 20:10
     * @Param [nums]
     * @return int
     * @Description: 使用64位数组记录每个位的1出现次数，最后统一统计
     */
    public int totalHammingDistance2(int[] nums) {
        int len = nums.length;
        int result = 0;
        int[] arr = new int[64];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j <= 64 & num != 0; j++) {
                if ((num & 1) == 1) {
                    arr[64-j] ++;
                }
                num >>>= 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[i] != len) {
                result += arr[i] * (len-arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TotalHammingDistance_477 target = new TotalHammingDistance_477();
        int[] nums = {4,14,4,14};
        int result = target.totalHammingDistance2(nums);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }

    /**
     * @Author LWQ
     * @Date 2023/12/27 20:18
     * @Param [nums]
     * @return int
     * @Description: 逐位统计
     * 在计算汉明距离时，我们考虑的是同一比特位上的值是否不同，而不同比特位之间是互不影响的。
     *
     * 对于数组 nums 中的某个元素 val，若其二进制的第 i 位为 1，我们只需统计 nums 中有多少元素的第 i 位为 0，
     * 即计算出了 val 与其他元素在第 i 位上的汉明距离之和。
     *
     * 大体思想同Plan2，但是省略了总的统计过程，更快速的计算每个位置位不同的数量
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/total-hamming-distance/solutions/798048/yi-ming-ju-chi-zong-he-by-leetcode-solut-t0ev/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int totalHammingDistance3(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}

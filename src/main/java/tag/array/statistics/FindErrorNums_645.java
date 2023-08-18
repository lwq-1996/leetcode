package tag.array.statistics;

/**
 * @Projectname: leetcode
 * @Filename: FindErrorNums_645
 * @Author: LWQ
 * @Data:2023/8/16 22:43
 * @Description: easy
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 */
public class FindErrorNums_645 {

    /**
     * 通过
     * 时间详情: 2ms, 击败 74.66%使用 Java 的用户
     * 内存详情: 42.88mb, 击败 25.78%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description: 原数组中没有数字0，窗口数组大小需要比原数组大2，一个是第0位，一个是比原数组大1的值
     */
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] window = new int[10002];
        for (int i = 0; i < nums.length; i++) {
            if (window[nums[i]] == 1) {
                result[0] = nums[i];
            }
            window[nums[i]] = 1;
        }

        for (int i = 1; i < window.length; i++) {
            if (window[i] == 0) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

    /**
     * 通过
     * 时间详情: 10ms, 击败 49.17%使用 Java 的用户
     * 内存详情: 42.71mb, 击败 59.50%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description: 排序后寻找相邻节点
     */
    public int[] findErrorNums02(int[] nums) {
        if (nums[0] == nums[1] && nums[0] == 1) {
            return new int[]{1,2};
        }

        Arrays.sort(nums);
        int[] result = new int[]{-1,-1};
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                result[0] = prev;
            }
            if (nums[i] - prev > 1) {
                result[1] = nums[i] - 1;
            }
            prev = nums[i];
        }
        if (result[1] == -1) {
            result[1] = nums[nums.length-1] + 1;
        }
        return result;
    }

    /**
     * 通过
     * 时间详情: 12ms, 击败 27.87%使用 Java 的用户
     * 内存详情: 42.54mb, 击败 85.20%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/8/18 12:30
     * @Param [nums]
     * @return int[]
     * @Description: 哈希表：
     *      不对数组本身处理，处理默认长度数字集合，重复数字出现两次，错误数字出现0次
     */
    public int[] findErrorNums03(int[] nums) {
        int length = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>((int) (nums.length/0.75 + 1));
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= length; i++) {
            Integer count = map.getOrDefault(i, 0);
            if (count == 1) {
                continue;
            }else if (count == 2) {
                result[0] = i;
            } else if (count == 0) {
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindErrorNums_645 target = new FindErrorNums_645();
        int[] nums = {1,5,3,2,2,7,6,4,8,9};
        int[] result = target.findErrorNums04(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 通过
     * 时间详情: 2ms, 击败 74.66%使用 Java 的用户
     * 内存详情: 42.71MB, 击败 59.50%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/8/18 13:11
     * @Param [nums]
     * @return int[]
     * @Description: 位运算：
     *      使用位运算，可以达到 O(n) 的时间复杂度和 O(1) 的空间复杂度。
     *
     * 重复的数字在数组中出现 2 次，丢失的数字在数组中出现 0 次，其余的每个数字在数组中出现 1 次。由此可见，重复的数字和丢失的数字的出现次数的奇偶性相同，且和其余的每个数字的出现次数的奇偶性不同。如果在数组的 n 个数字后面再添加从 1 到 n 的每个数字，得到 2n 个数字，则在 2n 个数字中，重复的数字出现 3 次，丢失的数字出现 1 次，其余的每个数字出现 2 次。根据出现次数的奇偶性，可以使用异或运算求解。
     *
     * 用 x 和 y 分别表示重复的数字和丢失的数字。考虑上述 2n 个数字的异或运算结果 xor，由于异或运算 ⊕ 满足交换律和结合律，且对任何数字 a 都满足 a⊕a=0 和 0⊕a=a，因此 xor=x⊕x⊕x⊕y=x⊕y，即 x 和 y 的异或运算的结果。
     *
     * 由于 x≠y，因此 xor≠0，令 lowbit=xor&(−xor)，则 lowbit 为 x 和 y 的二进制表示中的最低不同位，可以用 lowbit 区分 x 和 y。
     *
     * 得到 lowbit 之后，可以将上述 2n 个数字分成两组，第一组的每个数字 a 都满足 a & lowbit = 0，第二组的每个数字 b 都满足 b & lowbit ≠ 0。
     *
     * 创建两个变量 num1 和 num2，初始值都为 0，然后再次遍历上述 2n 个数字，对于每个数字 a，如果 a&lowbit=0，则令 num1=num1⊕a，否则令 num2=num2⊕a。
     *
     * 遍历结束之后，num1 为第一组的全部数字的异或结果，num2 为第二组的全部数字的异或结果。由于同一个数字只可能出现在其中的一组，且除了 x 和 y 以外，每个数字一定在其中的一组出现 2 次，因此 num1 和 num2分别对应 x 和 y 中的一个数字，但是具体对应哪个数还未知。
     *
     * 为了知道 num1 和 num2 分别对应 x 和 y 中的哪一个数字，只需要再次遍历数组 nums 即可。如果数组中存在元素等于 num1 ，则有 x=num1 和 y=num2 ，否则有 x=num2和 y=num1。
     */
    public int[] findErrorNums04(int[] nums) {
        int xor = 0;
        int length = nums.length;

        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= length ; i++) {
            xor ^= i;
        }
        // 此时xoy = 重复数 ^ 重复数 ^ 重复数 ^ 丢失数

        /**
         * lowbit 为 重复数与丢失数的最低不同位，用于分别统计两组数字，分别得到重复数与丢失数
         *  两个数的异或结果的最低有效位，即为这两个数的最低不同位
         *  获取一个数的最低有效位： a & (-a)
         *  根据 每个数字 & lowbit ：
         *      == 0 的数字分为一组，其中包括 重复数/丢失数
         *      != 0 的数字分为一组，其中包括 丢失数/重复数
         *
         */
        int lowbit = xor & (-xor);
        int var0 = 0, var1 = 0;

        for (int num : nums) {
            if ((num & lowbit) == 0) {
                var0 ^= num;
            } else {
                var1 ^= num;
            }
        }
        for (int i = 1; i <= length; i++) {
            if ((i & lowbit) == 0) {
                var0 ^= i;
            } else {
                var1 ^= i;
            }
        }
        // 此时 var0、var1 分别为 重复数、丢失数，需要区分哪个是重复数/丢失数

        for (int num : nums) {
            if (num == var0) {
                // var0 为重复数
                return new int[]{var0, var1};
            }
        }
        // var0 在数组中不存在，var0为丢失数
        return new int[]{var1, var0};
    }
}

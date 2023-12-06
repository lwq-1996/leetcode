package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: OptimalDivision_553
 * @Author: LWQ
 * @Data: 2023/12/4 22:48
 * @Description: medium
 */

/**
 * 给定一正整数数组 nums，nums 中的相邻整数将进行浮点除法。例如， [2,3,4] -> 2 / 3 / 4 。
 *
 * 例如，nums = [2,3,4]，我们将求表达式的值 "2/3/4"。
 * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，以便计算后的表达式的值为最大值。
 *
 * 以字符串格式返回具有最大值的对应表达式。
 *
 * 注意：你的表达式不应该包含多余的括号。
 *
 *
 *
 * 示例 1：
 *
 * 输入: [1000,100,10,2]
 * 输出: "1000/(100/10/2)"
 * 解释: 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
 * 因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
 *
 * 其他用例:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 *
 *
 * 示例 2:
 *
 * 输入: nums = [2,3,4]
 * 输出: "2/(3/4)"
 * 解释: (2/(3/4)) = 8/3 = 2.667
 * 可以看出，在尝试了所有的可能性之后，我们无法得到一个结果大于 2.667 的表达式。
 *
 *
 * 说明:
 *
 * 1 <= nums.length <= 10
 * 2 <= nums[i] <= 1000
 * 对于给定的输入只有一种最优除法。
 */
public class OptimalDivision_553 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：38.74MB，击败 95.00%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/6 13:29
     * @Param [nums]
     * @return java.lang.String
     * @Description: 脑经急转弯
     *      如果想要结果最大，那么实际就是要第二个数要最小，那么第一个数除以最小的第二个数，才会获得最大结果，第二个数一直往后除那就是最小值
     *      从结果出发，加括号这一操作的结果无非就是把算式中的部分除号变成乘号。 要想得到最大值，只需要让算式里的乘号尽可能多，除了第一个除号没法变之外，把从第二个数开始的所有数括起来就可以让后面的所有除号变成乘号。
     *      (不需要冗余括号，即 2/3 不可写成 2/(3)
     */
    public String optimalDivision(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return Integer.toString(nums[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]).append("/");
        if (length > 2) {
            stringBuilder.append("(");
        }
        for (int i = 1; i < length; i++) {
            stringBuilder.append(nums[i]);
            if (i != length-1) {
                stringBuilder.append("/");
            } else if (i > 1){
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        OptimalDivision_553 target = new OptimalDivision_553();
        int[] nums = {1000,100,10,2};
        String result = target.optimalDivision(nums);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/6 13:33
     * @Param [nums]
     * @return java.lang.String
     * @Description: 动态规划
     */
    public String optimalDivision2(int[] nums) {
        int n = nums.length;
        Node[][] dp = new Node[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Node();
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i].minVal = nums[i];
            dp[i][i].maxVal = nums[i];
            dp[i][i].minStr = String.valueOf(nums[i]);
            dp[i][i].maxStr = String.valueOf(nums[i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                for (int k = j; k < j + i; k++) {
                    if (dp[j][j + i].maxVal < dp[j][k].maxVal / dp[k + 1][j + i].minVal) {
                        dp[j][j + i].maxVal = dp[j][k].maxVal / dp[k + 1][j + i].minVal;
                        if (k + 1 == j + i) {
                            dp[j][j + i].maxStr = dp[j][k].maxStr + "/" + dp[k + 1][j + i].minStr;
                        } else {
                            dp[j][j + i].maxStr = dp[j][k].maxStr + "/(" + dp[k + 1][j + i].minStr + ")";
                        }
                    }
                    if (dp[j][j + i].minVal > dp[j][k].minVal / dp[k + 1][j + i].maxVal) {
                        dp[j][j + i].minVal = dp[j][k].minVal / dp[k + 1][j + i].maxVal;
                        if (k + 1 == j + i) {
                            dp[j][j + i].minStr = dp[j][k].minStr + "/" + dp[k + 1][j + i].maxStr;
                        } else {
                            dp[j][j + i].minStr = dp[j][k].minStr + "/(" + dp[k + 1][j + i].maxStr + ")";
                        }
                    }
                }
            }
        }
        return dp[0][n - 1].maxStr;
    }

}

class Node {
    double maxVal, minVal;
    String minStr, maxStr;

    public Node() {
        this.minVal = 10000.0;
        this.maxVal = 0.0;
    }
}

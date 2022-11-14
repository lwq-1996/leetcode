package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: MaxProfit_121
 * @Author: LWQ
 * @Data:2022/11/14 15:06
 * @Description: leetcode_practice
 * 
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaxProfit_121 {

    /**
     * 超时
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        boolean flag = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return 0;
        }

        int maxPrices = 0;
        int star = 0;
        int end = star + 1;
        while (star < prices.length) {
            if (end >= prices.length) {
                star++;
                end = star + 1;
                continue;
            }

            if (prices[end] - prices[star] > maxPrices) {
                maxPrices = prices[end] - prices[star];
            }
            end++;

        }

        return maxPrices;
    }

    public static void main(String[] args) {
        MaxProfit_121 maxProfit_121 = new MaxProfit_121();
        int[] prices = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        int maxProfit = maxProfit_121.maxProfit2(prices);
        System.out.println(maxProfit);
    }

    /**
     * 动态规划：前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     *  1. 记录【今天之前买入的最小值】
     *  2. 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     *  3. 比较【每天的最大获利】，取最大值即可
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}

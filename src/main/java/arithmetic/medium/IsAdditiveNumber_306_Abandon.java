package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: IsAdditiveNumber_306_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:35
 * @Description: medium
 */

/**
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2：
 *
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 *
 * 提示：
 *
 * 1 <= num.length <= 35
 * num 仅由数字（0 - 9）组成
 *
 *
 * 进阶：你计划如何处理由过大的整数输入导致的溢出?
 */
public class IsAdditiveNumber_306_Abandon {

    /**
     * ABANDON
     * @Author LWQ
     * @Date 2023/12/17 15:54
     * @Param [num]
     * @return boolean
     * @Description: 我甚至以为会有什么巧妙的解法
     */
    public boolean isAdditiveNumber(String num) {
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        IsAdditiveNumber_306_Abandon target = new IsAdditiveNumber_306_Abandon();
        String num = "199100";
        boolean result = target.isAdditiveNumber2(num);
        System.out.println(result);
        System.out.println(35/2);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/17 16:14
     * @Param [num]
     * @return boolean
     * @Description: 穷举累加序列第一个数字和第二个数字的所有可能性
     * 一个累加序列，当它的第一个数字和第二个数字以及总长度确定后，这整个累加序列也就确定了。
     * 根据这个性质，我们可以穷举累加序列的第一个数字和第二个数字的所有可能性，对每个可能性，进行一次合法性的判断。
     * 当出现一次合法的累加序列后，即可返回 true。当所有可能性都遍历完仍无法找到一个合法的累加序列时，返回 false。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/additive-number/solutions/1200446/lei-jia-shu-by-leetcode-solution-cadc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isAdditiveNumber2(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; ++secondStart) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; ++secondEnd) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += s.charAt(firstEnd) - '0';
                --firstEnd;
            }
            if (secondEnd >= secondStart) {
                cur += s.charAt(secondEnd) - '0';
                --secondEnd;
            }
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
    }
}

package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: IsHappy_202
 * @Author: LWQ
 * @Data:2022/11/17 17:12
 * @Description: leetcode_practice
 * 
 * 
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 * 
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsHappy_202 {

    public boolean isHappy(int n) {
        /**
         * 观看解题思路后编写：
         *  快慢指针
         *  存在某种循环，那快指针每次会比慢指针多走一步，最终二者会相遇,最后比较二者结果即可
         */
        int fast = n;
        int slow = n;
        do {
          slow = getSquareSum(slow);
          fast = getSquareSum(fast);
          fast = getSquareSum(fast);
        } while (fast != slow);

        if (fast == 1) {
            return true;
        }
        return false;
    }

    public static int getSquareSum(int param) {
        int result = 0;
        int remainder;
        while (param != 0) {
            remainder = param % 10;
            result = result + remainder * remainder;
            param /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        IsHappy_202 isHappy_202 = new IsHappy_202();
        int n = 2;
        boolean happyFlag = isHappy_202.isHappy(n);
        System.out.println(happyFlag);
    }


    /**
     * 参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
     * 如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
     * 两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);
        if (fast == 1)
            return true;
        else return false;
    }

    private int squareSum(int m) {
        int squaresum = 0;
        while (m != 0) {
            squaresum += (m % 10) * (m % 10);
            m /= 10;
        }
        return squaresum;
    }

}

package tag.bit.simple_math_problem;

/**
 * @Projectname: leetcode
 * @Filename: ConstructRectangle_492_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 13:07
 * @Description: easy
 */

import java.util.Arrays;

/**
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 所以，现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *
 * 你设计的矩形页面必须等于给定的目标面积。
 * 宽度 W 不应大于长度 L ，换言之，要求 L >= W 。
 * 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 返回一个 数组 [L, W]，其中 L 和 W 是你按照顺序设计的网页的长度和宽度。
 *
 *
 * 示例1：
 *
 * 输入: 4
 * 输出: [2, 2]
 * 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
 * 但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
 * 示例 2:
 *
 * 输入: area = 37
 * 输出: [37,1]
 * 示例 3:
 *
 * 输入: area = 122122
 * 输出: [427,286]
 *
 *
 * 提示:
 *
 * 1 <= area <= 107
 */
public class ConstructRectangle_492 {

    /**
     * 通过：
     * 时间详情：37ms，击败 19.78%使用 Java 的用户
     * 内存详情：39.74MB，击败 13.48%使用 Java 的用户
     *
     * @param area
     * @return
     * @desception：循环遍历
     */
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        for (int w = 1; w <= area; w++) {
            if (area % w != 0) {
                continue;
            }
            int l = area / w;
            if (w > l) {
                break;
            }
            result[0] = l;
            result[1] = w;
        }

        return result;
    }

    public static void main(String[] args) {
        ConstructRectangle_492 target = new ConstructRectangle_492();
        int area = 4;
        int[] result = target.constructRectangle(area);
        System.out.println(Arrays.toString(result));
    }

    public int[] constructRectangle2(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}

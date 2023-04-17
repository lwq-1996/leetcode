package arithmetic.medium;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea_11 {

    /**
     * 暴力破解，运行超时
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = (j - i) * Math.min(height[i], height[j]);
                maxArea = area > maxArea ? area : maxArea;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea_11 maxArea_11 = new MaxArea_11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea_11.maxArea2(height);
        System.out.println(maxArea);
    }

    /**
     * 这里用到了动态规划，基本的表达式: area = min(height[i], height[j]) * (j - i) 使用两个指针，值小的指针向内移动，这样就减小了搜索空间
     * 因为面积取决于指针的距离与值小的值乘积，如果值大的值向内移动，距离一定减小，而求面积的另外一个乘数一定小于等于值小的值，因此面积一定减小，
     * 而我们要求最大的面积，因此值大的指针不动，而值小的指针向内移动遍历
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int size = height.length;
        int left=0, right=size-1;
        int ans = 0;
        while(left < right){
            ans = Math.max(ans, (right-left)*Math.min(height[left], height[right]));
            if(height[left] > height[right]) --right;
            else ++left;
        }
        return ans;
    }
}

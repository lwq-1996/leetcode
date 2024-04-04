package tag.other;

/**
 * @Projectname: leetcode
 * @Filename: Combine_77
 * @Author: LWQ
 * @Data: 2024/4/4 13:08
 * @Description:
 */

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combine_77 {
    List<List<Integer>> list = new ArrayList<>();

    /**
     * @Author LWQ
     * @Date 2024/4/4 13:49
     * @Param [n, k]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @Description: 回溯 + 枝剪
     *    执行用时分布：30ms，击败12.13%使用 Java 的用户
     *    消耗内存分布：92.44MB击败35.02%使用 Java 的用户
     */
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[k];
        this.dfs(arr, n, k, 0);
        return list;
    }

    private void dfs(int[] arr, int n, int k, int cur) {
        if (k == cur) {
            List<Integer> ilist = new ArrayList<>(cur);
            for (int i = 0; i < arr.length; i++) {
                ilist.add(arr[i]);
            }
            list.add(ilist);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (cur > 0 && i <= arr[cur - 1]) {
                continue;
            }
            arr[cur] = i;
            dfs(arr, n, k, cur + 1);
        }
    }

    public static void main(String[] args) {
        Combine_77 target = new Combine_77();
        int n = 4;
        int k = 2;
        List<List<Integer>> result = target.combine(n, k);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    /**
     * @Author LWQ
     * @Date 2024/4/4 13:53
     * @Param [n, k]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @Description: 回溯 + 枝剪
     *  执行用时分布：23ms，击败36.83%使用 Java 的用户
     *  消耗内存分布：90.09MB，击败66.45%使用 Java 的用户
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }
}

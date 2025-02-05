package arithmetic_pattern.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: BucketSort
 * @Author: LWQ
 * @Data: 2025/2/5 15:12
 * @Description:
 *
 * 桶排序（Bucket Sort）其算法原理是将数组分到有限数量的桶里，再对每个桶分别排好序（
 * 可以是递归使用桶排序，也可以是使用其他排序算法将每个桶分别排好序），最后一次将每个桶中排好序的数输出。
 * ————————————————
 * 时间复杂度: O(N + K) K为桶的数量。
 * 最坏时间复杂度：O(N * N)
 */

public class BucketSort {


    public void bucketSort(int[] nums) {
        int n = nums.length;
        int mn = nums[0], mx = nums[0];
        // 找出数组中的最大最小值
        for (int i = 1; i < n; i++) {
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);
        }
        int size = (mx - mn) / n + 1; // 每个桶存储数的范围大小，使得数尽量均匀地分布在各个桶中，保证最少存储一个
        int cnt = (mx - mn) / size + 1; // 桶的个数，保证桶的个数至少为1
        List<Integer>[] buckets = new List[cnt]; // 声明cnt个桶
        for (int i = 0; i < cnt; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 扫描一遍数组，将数放进桶里
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - mn) / size;
            buckets[idx].add(nums[i]);
        }
        // 对各个桶中的数进行排序，这里用库函数快速排序
        for (int i = 0; i < cnt; i++) {
            buckets[i].sort(null); // 默认是按从小打到排序
        }
        // 依次将各个桶中的数据放入返回数组中
        int index = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                nums[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {19, 27, 35, 43, 31, 22, 54, 66, 78};
        BucketSort bucketSort = new BucketSort();
        bucketSort.bucketSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}

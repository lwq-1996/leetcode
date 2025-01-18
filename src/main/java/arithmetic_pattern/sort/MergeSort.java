package arithmetic_pattern.sort;

import java.util.Arrays;

/**
 * @Projectname: arithmetic
 * @Filename: MergeSort
 * @Author: LWQ
 * @Data: 2024/3/31 09:40
 * @Description: 归并算法
 * 思路：
 *  归并排序算法有两个基本的操作，一个是分，也就是把原数组划分成两个子数组的过程。另一个是治，它将两个有序数组合并成一个更大的有序数组。
 *
 *  1.将待排序的线性表不断地切分成若干个子表，直到每个子表只包含一个元素，这时，可以认为只包含一个元素的子表是有序表。
 *  2.将子表两两合并，每合并一次，就会产生一个新的且更长的有序表，重复这一步骤，直到最后只剩下一个子表，这个子表就是排好序的线性表。
 * ————————————————
 *
 * 时间复杂度: O(nlogn)。
 * 空间复杂度: O(N)，归并排序需要一个与原数组相同长度的数组做辅助来排序。
 * 稳定性: 稳定。
 */

public class MergeSort {

    public void mergeSort(int[] arr) {
        int[] sort = this.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sort[i];
        }
    }

    private int[] sort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[] {arr[left]};
        }

        int mid = left + (right - left) / 2;
        int[] ints = new int[right - left + 1];
        int[] leftarr = sort(arr, left, mid);
        int[] rightarr = sort(arr, mid + 1, right);

        int l = 0, r = 0;
        for (int i = 0; i < ints.length; i++) {
            if (l < leftarr.length && r < rightarr.length) {
                ints[i] = leftarr[l] < rightarr[r] ? leftarr[l++] : rightarr[r++];
                continue;
            }
            if (l < leftarr.length) {
                ints[i] = leftarr[l++];
            }
            if (r < rightarr.length) {
                ints[i] = rightarr[r++];
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,-1,7,2};
        MergeSort target = new MergeSort();

        target.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

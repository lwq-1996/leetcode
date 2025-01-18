package arithmetic_pattern.sort;

import java.util.Arrays;

/**
 * @Projectname: arithmetic
 * @Filename: SelectSort
 * @Author: LWQ
 * @Data: 2024/3/26 20:51
 * @Description: 选择排序
 * 思路：
 *  每次从待排序列中选出一个最小值，然后放在序列的起始位置，直到全部待排数据排完即可。
 *  实际上，我们可以一趟选出两个值，一个最大值一个最小值，然后将其放在序列开头和末尾，这样可以使选择排序的效率快一倍。
 *  ————————————————
 *
 * 时间复杂度：最坏情况：O(N^2)
 *  最好情况：O(N^2)
 *  空间复杂度：O(1)
 */

public class SelectSort {

    public void selectSort(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int min = left;
            int max = right;
            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            this.swap(arr, left, min);
            // 防止最大的值被换走，max在最开始的位置，交换完最小值后max位置发送了变化，被交换走了
            if (max == left) {
                max = min;
            }
            this.swap(arr, right, max);
            left++;
            right--;
        }

    }

    private void swap(int[] arr, int index_1, int index_2) {
        arr[index_1] = arr[index_1] ^ arr[index_2];
        arr[index_2] = arr[index_1] ^ arr[index_2];
        arr[index_1] = arr[index_1] ^ arr[index_2];
    }

    public static void main(String[] args) {
        int[] arr = {0,3,-1,7,2};
        SelectSort target = new SelectSort();

        target.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

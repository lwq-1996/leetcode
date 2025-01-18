package arithmetic_pattern.sort;

import java.util.Arrays;

/**
 * @Projectname: arithmetic
 * @Filename: BubbleSort
 * @Author: LWQ
 * @Data: 2024/3/26 21:19
 * @Description: 冒泡排序
 * 思路：
 *  左边大于右边交换，一趟排下来最大的在右边
 * ————————————————
 *
 * 时间复杂度：最坏情况：O(N^2)
 *  最好情况：O(N)
 *  空间复杂度：O(1)
 */

public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int len = arr.length;
        int end = len;
        while (end > 0) {
            for (int i = 1; i < end; i++) {
                if (arr[i] < arr[i - 1]) {
                    this.swap(arr, i, i-1);
                }
            }
            end--;
        }

    }

    private void swap(int[] arr, int l, int r) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }

    public static void main(String[] args) {
        int[] arr = {0,3,-1,7,2};
        BubbleSort target = new BubbleSort();

        target.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

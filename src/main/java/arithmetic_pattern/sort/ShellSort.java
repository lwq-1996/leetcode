package arithmetic_pattern.sort;

import java.util.Arrays;

/**
 * @Projectname: arithmetic
 * @Filename: ShellSort
 * @Author: LWQ
 * @Data: 2024/3/25 22:27
 * @Description: 希尔排序
 * 思路：
 *  希尔排序，先将待排序列进行预排序，使待排序列接近有序，然后再对该序列进行一次插入排序，此时插入排序的时间复杂度为O(N)，
 * ————————————————
 *
 * 步骤：
 *  1.先选定一个小于N的整数gap作为第一增量，然后将所有距离为gap的元素分在同一组，并对每一组的元素进行直接插入排序。然后再取一个比第一增量小的整数作为第二增量，重复上述操作…
 *  2.当增量的大小减到1时，就相当于整个序列被分到一组，进行一次直接插入排序，排序完成。
 * ————————————————
 *
 * 时间复杂度平均：O(N^1.3)
 * 最坏时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 */

public class ShellSort {

    public void shellSortImpl(int[] arr) {
        int len = arr.length;
        int gap = len;
        while (gap > 1) {
            gap /= 2;

            // 以下为插入排序
            for (int i = gap; i < len - gap; i++) {
                int index = i;
                int current = arr[index + gap];
                while (index >= 0) {
                    if (current < arr[index]) {
                        arr[index + gap] = arr[index];
                        index -= gap;
                    } else {
                        break;
                    }
                }

                arr[index + gap] = current;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,3,-1,7,2};
        ShellSort target = new ShellSort();

        target.shellSortImpl(arr);
        System.out.println(Arrays.toString(arr));
    }
}

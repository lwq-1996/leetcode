package arithmetic_pattern.sort;

import java.util.Arrays;

/**
 * @Projectname: arithmetic
 * @Filename: QuickSort
 * @Author: LWQ
 * @Data: 2024/3/31 10:18
 * @Description: 快速排序
 * 算法思路
 *  通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 *  整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 快速排序算法通过多次比较和交换来实现排序，其排序流程如下：
 *  1、首先设定一个分界值，通过该分界值将数组分成左右两部分。
 *  2、将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值。
 *  3、然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 *  4、重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。
 * 概括来说为 挖坑填数 + 分治法。
 * ————————————————
 * 时间复杂度: O(nlogn)。
 */

public class QuickSort {
    
    public void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    /**
     * @Author LWQ
     * @Date 2024/3/31 11:04
     * @Param [arr, left, right]
     * @return void
     * @Description: 挖坑法
     */
    private void qsort(int[] arr, int left, int right) {
        int pivot = arr[left];
        int hole = left;
        int l = left, r = right;

        while (left < right) {
            // 先找大
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[hole] = arr[right];
            hole = right;

            // 找小
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[hole] = arr[left];
            hole = left;
        }
        // 相遇后把坑填上
        arr[hole] = pivot;

        if (hole > l + 1) {
            qsort(arr, l, hole - 1);
        }
        if (hole < r - 1) {
            qsort(arr, hole + 1, r);
        }
    }

    /**
     * @Author LWQ
     * @Date 2024/3/31 11:42
     * @Param [arr, start, end]
     * @return void
     * @Description: 交换法
     */
    private void qsort2(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) qsort2(arr,start,i-1);
        if (j+1<end) qsort2(arr,j+1,end);
    }

    public static void main(String[] args) {
        int[] arr = {0,3,-1,7,2};
        QuickSort target = new QuickSort();

        target.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package arithmetic_pattern.sort;

import java.util.Arrays;

/**
* @Projectname: arithmetic
* @Filename: InsertSort
* @Author: LWQ
* @Data: 2024/3/25 22:02
* @Description: 插入排序：
 *
 *  思路：
 * 在待排序的元素中，假设前n-1个元素已有序，现将第n个元素插入到前面已经排好的序列中，使得前n个元素有序。按照此法对所有元素进行插入，直到整个序列有序。
 * 但我们并不能确定待排元素中究竟哪一部分是有序的，所以我们一开始只能认为第一个元素是有序的，依次将其后面的元素插入到这个有序序列中来，直到整个序列有序为止。
 * ————————————————
 *
 * 步骤：
 *  1.从第一个元素开始，该元素可以认为已经被排序
 *  2.取下一个元素tem，从已排序的元素序列从后往前扫描
 *  3.如果该元素大于tem，则将该元素移到下一位
 *  4.重复步骤3，直到找到已排序元素中小于等于tem的元素
 *  5.tem插入到该元素的后面，如果已排序所有元素都大于tem，则将tem插入到下标为0的位置
 *  6.重复步骤2~5
 * ————————————————
 *  时间复杂度：最坏情况下为O(N*N)，此时待排序列为逆序，或者说接近逆序
 *  最好情况下为O(N)，此时待排序列为升序，或者说接近升序。
 *  空间复杂度：O(1)
*/

public class InsertSort {

    /**
     * @Author LWQ
     * @Date 2024/3/25 22:21
     * @Param [arr]
     * @return void
     * @Description: 降序排序
     */
    public void insertSortDesc(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            // 有序序列的最大下标
            int index = i;
            // 当前进行排序的元素
            int current = arr[index + 1];
            while (index >= 0) {
                if (current < arr[index]) {
                    // 比当前数小则后移
                    arr[index + 1] = arr[index];
                    index--;
                } else {
                    // 找到需要插入的位置，跳出
                    break;
                }
            }
            // 交换，有可能自己与自己交换
            arr[index + 1] = current;
        }
    }

    /**
     * @Author LWQ
     * @Date 2024/3/25 22:22
     * @Param [arr]
     * @return void
     * @Description: 升序排序
     */
    public void insertSortAsc(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            // 有序序列的最大下标
            int index = i;
            // 当前进行排序的元素
            int current = arr[index + 1];
            while (index >= 0) {
                if (current < arr[index]) {
                    // 比当前数大则后移
                    arr[index + 1] = arr[index];
                    index--;
                } else {
                    // 找到需要插入的位置，跳出
                    break;
                }
            }
            // 交换，有可能自己与自己交换
            arr[index + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,3,-1,7,2};
        InsertSort target = new InsertSort();

        target.insertSortDesc(arr);
        System.out.println(Arrays.toString(arr));

        target.insertSortAsc(arr);
        System.out.println(Arrays.toString(arr));
    }
}

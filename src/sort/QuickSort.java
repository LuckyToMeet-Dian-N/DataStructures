package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Gentle
 * @date 2019/06/22 : 20:11
 */
public class QuickSort {


    /**
     * 排序后的数组
     *
     * @param list  需要排序的数组
     * @param left  索引
     * @param right 索引
     * @return
     */
    public static String quickSort(int[] list, int left, int right) {
        if (left > right) {
            return Arrays.toString(list);
        }

        int temp = list[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (list[j] >= temp && i < j) {
                j--;
            }
            list[i] = list[j];
            while (list[i] <= temp && i < j) {
                i++;
            }
            list[j] = list[i];

        }

        list[i] = temp;
        quickSort(list, left, right - 1);
        quickSort(list, left + 1, right);

        return Arrays.toString(list);
    }

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println("排序后的数组：" + quickSort(arr, 0, arr.length - 1));

    }

}

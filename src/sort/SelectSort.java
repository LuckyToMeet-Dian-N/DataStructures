package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author Gentle
 * @date 2019/06/22 : 20:48
 */
public class SelectSort {
    /**
     * 选择排序
     *
     * @param arr 需要排序的数组
     * @return
     */
    public static String selectSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            //当第一个是最小的
            int min = i;

            for (int j = i + 1; j < len ; j++) {
                //假设 min 索引对应的值是最小的然后进行比较
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //元素交换
            if (min != arr[i]) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        int[] arr2 = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println("排序后的数组：" + selectSort(arr));
        System.out.println("排序后的数组：" + selectSort2(arr2));
    }

    public static String selectSort2(int[] arr) {

        int len = arr.length ;
        int temp;
        for (int i = 0; i < len-1; i++) {
            for (int j = i + 1; j < len; j++) {
                //比较下一个是不是比自己，是就交换
                if (arr[i] > arr[j]) {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return Arrays.toString(arr);
    }

}

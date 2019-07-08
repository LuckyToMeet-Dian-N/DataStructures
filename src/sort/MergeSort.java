package sort;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 归并排序
 * @author Gentle
 * @date 2019/06/25 : 18:05
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        int[] temp = {0,8,777,0,9,0,45654,8,5,57467};
        mergeSort(arr,111,args.length-1,temp);
        System.out.println("排序后的数组：" + Arrays.toString(
                arr
        ));
    }

    /**
     * 归并排序

     * @return
     */
//    public static String mergeSort(int[] arr){
//
//
//
//
//
//        return Arrays.toString(arr);
//    }

    public static void mergeSort(int[] a, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;

            mergeSort(a, first, mid, temp);//左边有序
            mergeSort(a, mid + 1, last, temp);//右边有序
           
            mergeArray(a, first, mid, last, temp); //再将两个有序序列合并.
        }
    }

        private static void mergeArray(int[] a, int first, int mid, int last, int[] temp){
            int i = first, j=mid+1;//设置两个数组的起始边界
            int m=mid, n=last;//设置两个数组的结束边界

            int k=0;

            while (i <= m && j<=n){
                if(a[i] <= a[j]){
                    temp[k++] = a[i++];
                }else {
                    temp[k++] = a[j++];
                }
            }

            while (i<=m){
                temp[k++] = a[i++];
            }

            while (j <= n){
                temp[k++] = a[j++];
            }

            for(i=0; i<k; i++){
                a[first+i] = temp[i];
            }
        }

}

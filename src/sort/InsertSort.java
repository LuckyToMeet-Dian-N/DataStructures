package sort;

import java.util.Arrays;

/**
 * @author Gentle
 * @date 2019/06/23 : 10:08
 */
public class InsertSort {

    /**
     * 插入排序
     * @param arr 需要排序的数组
     * @return
     *
     * 原理：
     * 最外层循环中，取出一个元素，（无序的意思是从第二个开始）
     * 现在我们有 5 个元素分别为 1 8 4 3 9  ，那么我们开始排序。
     * 取出第二个元素作为临时元素  temp = arr[1] 既 temp = 8
     *
     * 接下来我们就是要进行比较了，比较肯定是需要从前一个元素开始比
     * j[0] = 1, 8 是大于1 所以不需要排序
     * 接下来我们拿到的是 第三个元素 arr[2] = 4，与 第二个对比 既 arr[1] = 8
     * 发现第二个元素比自己大，所以会进行一次交换,没有后，则在最后将临时元素赋值上去
     */
    public static String insertSort(int[] arr){
        int len = arr.length;
        for (int i=1;i<len;i++){
            //临时存储
            int temp = arr[i];
            int j;
            //找到上一个元素，进行比较，大则进行交换
            for (j=i-1;j>=0&&arr[j]>temp;j--){
                arr[j+1] =arr[j];
            }
            arr[j+1] =temp;
        }
        return Arrays.toString(arr);
    }
    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println("排序后的数组：" + insertSort(arr));
    }

}

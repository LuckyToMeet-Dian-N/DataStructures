package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Gentle
 * @date 2019/06/22 : 20:20
 */
public class BubbleSort {
    /**
     * 排序后数组
     * @param list 排序的数组
     * @return
     */
    public static String  bubbleSort(int[] list){
        int len = list.length;
        //最大是 N-1 轮
        for (int i=0;i<len-1;i++){
            //每轮交换次数
            for (int j=0;j<len-1-i;j++){
                if (list[j]>list[j+1]){
                    int temp = list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
        return Arrays.toString(list);
    }

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println("排序后的数组：" + bubbleSort(arr));
    }


}

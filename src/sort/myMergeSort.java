package sort;

public class myMergeSort {

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        printArray("排序前：", a);
        mergeSort(a);
        printArray("排序后：", a);
    }

    /**
     *
     * @param pre
     * @param a
     */
    private static void printArray(String pre, int[] a) {
        System.out.print(pre + "\n");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 开始排序
     * @param a 排序数组
     */
    private static void mergeSort(int[] a) {
        Sort(a, 0, a.length - 1);
    }

    /**
     * 排序
     * @param a
     * @param left
     * @param right
     */

    private static void Sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        //二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        Sort(a, left, mid);
        Sort(a, mid + 1, right);
        merge(a, left, mid, right);

    }


    private static void merge(int[] a, int left, int mid, int right) {

        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1]) {
                tmp[tIndex++] = a[left++];
            } else {
                tmp[tIndex++] = a[r1++];
            }
        }
        // 将左边剩余的归并
        while (left <= mid) {
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while (r1 <= right) {
            tmp[tIndex++] = a[r1++];
        }

        //从临时数组拷贝到原数组
        while (cIndex <= right) {
            a[cIndex] = tmp[cIndex];
            cIndex++;
        }

    }


}
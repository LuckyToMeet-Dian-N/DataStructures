package sort;

/**
 * @author Gentle
 * @date 2019/07/10 : 09:22
 */
public class HeadSort {

    public static void main(String[] args) {
        int[] nums = {16, 7, 3, 20, 17, 8};
        heapSortAsc(nums, nums.length);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 堆排序(从小到大)
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * n -- 数组的长度
     *
     * @param a
     * @param n
     */
    public static void heapSortAsc(int[] a, int n) {
        int i, tmp;
        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, n - 1);
        }
        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxHeapDown(a, 0, i - 1);
        }
    }

    /**
     * (最大)堆的向下调整算法
     * <p>
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     * 其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     * end   -- 截至范围(一般为数组中最后一个元素的索引)
     *
     * @param a
     * @param start
     * @param end
     */
    public static void maxHeapDown(int[] a, int start, int end) {
        // 当前(current)节点的位置
        int c = start;
        // 左(left)孩子的位置
        int l = 2 * c + 1;
        // 当前(current)节点的大小
        int tmp = a[c];
        for (; l <= end; c = l, l = 2 * l + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if (l < end && a[l] < a[l + 1]) {
                l++;        // 左右两孩子中选择较大者，即m_heap[l+1]
            }
            if (tmp >= a[l]) {
                // 调整结束
                break;
            } else {
                // 交换值
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }



















    static void heapSort(int []a,int len){
        int i;
        for(i=len/2;i>=0;i--){ /*把a[]构造成一个大顶堆*/
            HeapAdjust(a,i,len);
        }
        for(i=len;i>0;i--){
            swap(a,0,i); /*交换堆顶最大元素和堆尾最小元素*/
            HeapAdjust(a,0,i-1);  /*把交换后的堆a[0,i-1]，再次构造成大顶顶，使堆顶元素为最大值*/
        }
    }
    static void HeapAdjust(int []a,int start,int len){
        int temp,j;
        temp=a[start];
        for(j=2*start;j<=len;j*=2){   /*从index最大的有孩子的节点开始筛选，堆排*/
            if(j<len&&a[j]<a[j+1])    /*是index=j的元素为较大的元素*/
                j++;
            if(temp>=a[j])
                break;
            a[start]=a[j];            /*将较大元素赋值给父节点*/
            start=j;
        }
        a[start]=temp;
    }
    static void swap(int a[],int low,int high){
        int temp=a[low];
        a[low]=a[high];
        a[high]=temp;
    }




}

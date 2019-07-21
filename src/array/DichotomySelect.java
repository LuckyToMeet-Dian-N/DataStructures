package array;

/**
 * 数组的二分查找
 *
 * @author Gentle
 * @date 2019/07/21 : 11:42
 */
public class DichotomySelect {
    /**
     * 二分查找
     * 异常情况：
     * 数组为空，数组长度为 0。
     * 数据不存在。返回 -1
     * 思路：
     * 准备两个指针。一个指向投，一个指向尾巴。取中间值
     *
     *     1  2  3  4    5    6  7  8  9
     *    low          center        height
     *    寻找 4
     *    第一次计算 center = (0 + 8) /2= 4
     *    arr[4] 的值是 5 大于要寻找的 4 ，往左区域
     *    也就是 height = center -1 得到 3
     *     1     2        3     4  5  6  7  8  9
     *   low            height
     *   center
     *
     *     1     2        3     4  5  6  7  8  9
     *   center         height
     *          low
     *      以此类推
     *
     * @return
     */
    private static int dichotomvSelect(int[] arr, int key) {

        int low = 0;
        int height = arr.length - 1;
        int center;

        while (low <= height) {
            center = (low + height) / 2;
            if (arr[center] > key) {
                height = center - 1;
            } else if (arr[center] < key) {
                low = center + 1;
            } else {
                return center;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        int i = dichotomvSelect(arr, 4);
        System.out.println(i);


    }
}

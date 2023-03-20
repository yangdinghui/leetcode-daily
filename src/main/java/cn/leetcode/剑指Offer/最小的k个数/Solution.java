package cn.leetcode.剑指Offer.最小的k个数;

import java.util.Arrays;

/**
 * @author yangdh
 * @desc 最小的k个数
 * 数组 分治 快速选择 排序
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * @date 2023/3/20 20:07
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null) return null;
        if (k == 0) return new int[0];
        Arrays.sort(arr);
        int[] ints = new int[k];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = arr[i];
            if (i == k - 1) {
                break;
            }
        }
        return ints;
    }

    /**
     * 快速排序算法有两个核心点，分别为 “哨兵划分” 和 “递归”
     * 哨兵划分操作： 以数组某个元素（一般选取首元素）为 基准数 ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边;
     * 递归： 对 左子数组 和 右子数组 递归执行 哨兵划分，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序。
     * 时间复杂度: O(NlogN),库函数、快排等排序算法的平均时间复杂度为 O(NlogN),
     * 空间复杂度: O(N),快速排序的递归深度最好（平均）为 O(logN),最差情况（即输入数组完全倒序）为O(N)
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

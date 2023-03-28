package cn.leetcode.剑指Offer.构建乘积数组;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yangdh
 * @desc 构建乘积数组:给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 数组 前缀和
 * @date 2023/3/24 17:52
 */
public class Solution23032602 {
    /**
     * 时间过长
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int tmp = 1;
            for (int j = 0; j < a.length; j++) {
                if (i != j) {
                    tmp *= a[j];
                }
            }
            arr[i] = tmp;
        }
        return arr;
    }

    public static int[] constructArr2(int[] a) {
        int length = a.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = a[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= a[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr2(new int[]{1, 2, 3, 4, 5})));
    }
}

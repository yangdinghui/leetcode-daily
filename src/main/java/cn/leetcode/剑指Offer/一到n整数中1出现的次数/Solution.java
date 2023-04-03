package cn.leetcode.剑指Offer.一到n整数中1出现的次数;

/**
 * @author yangdh
 * @desc 1～n整数中1出现的次数
 * 递归 数学 动态规划
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * 限制：
 * 1 <= n < 2^31
 * @date 2023/4/1 11:28
 */
public class Solution {
    // 12      -> 1 2 3 4 5 6 7 8 9 10 | 11 12 13 14 15 16 17 18 19 20
    // 12%10 = 2
    // 12/10 = 1
    // 1*1+1*1=2
    //
    public static int countDigitOne(int n) {
        int ori_n = n;
        int res = 0;
        long base = 1;  //这里把base写成Long只是为了应付测例：1410065408;不然base*=10之后会超出int的表示范围
        while (n > 0) {
            int ones_place = n % 10;  //当前位
            int others_place = n / 10;  //其余高位
            if (ones_place > 1) {
                res += others_place * base + 1 * base;
            } else if (ones_place == 1) {
                res += others_place * base + (ori_n % base + 1);  //ori_n%base 是为了取除了当前位、其余高位之外的其余低位
            } else {
                res += others_place * base;
            }
            base *= 10;
            n /= 10;
        }
        return res;
    }

    public int countDigitOne2(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

    public int countDigitOne3(int n) {
        // "1"出现的次数 = sum ("1"在各个计数位上出现的次数)
        // 从个位开始向最高位统计
        // 3101592
        // 将数字拆分为[a...][cur][b...]
        // cur 为当前位
        long base = 1, res = 0;
        while (base <= n) {
            // 计算 a..., cur, b...
            long a, cur, b;
            a = n / base / 10;
            cur = (n / base) % 10;
            b = n % base;
            // 将当前位设为1，考察其他部分的变化范围
            if (cur > 1) {
                // 一、cur > 1，
                // [3101 ] 5 [92]
                // 变化范围：[0-3101] 1 [0-99]
                // 总个数： (a+1) * base
                res += (a + 1) * base;
            } else if (cur == 1) {
                // 二、cur == 1，
                // [310] 1 [592]
                // 1、变化范围 [0-309] 1 [0-999]
                // a * base
                // 2、变化范围 [310] 1 [0-592]
                // 1 * (b+1)
                // 总个数：a *base + (b + 1)
                res += a * base + b + 1;

            } else {
                // 三、cur < 1，
                // [31] 0 [1592]
                // 变化范围 [0-30] 1 [0-9999]
                // 总个数 a * base
                res += a * base;
            }
            // 统计更高一位
            base *= 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(12));
    }
}

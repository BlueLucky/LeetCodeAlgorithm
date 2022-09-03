package com.lucky.leecode.dynamic;

/**
 * 基础动态规划算法
 */
public class DynamicAlgorithm {
    /**
     * 爬楼梯
     * <p>
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 思路：
     * 这题我们可以参照之前分析的青蛙跳台阶问题，其实原理是完全一样的
     * 我们来分析一下：
     *
     * 当n等于1的时候，只需要跳一次即可，只有一种跳法，记f(1)=1
     * 当n等于2的时候，可以先跳一级再跳一级，或者直接跳二级，共有2种跳法，记f(2)=2
     * 当n等于3的时候，他可以从一级台阶上跳两步上来，也可以从二级台阶上跳一步上来，所以总共有f(3)=f(2)+f(1)；
     * 同理当等于n的时候，总共有f(n)=f(n-1)+f(n-2)(这里n>2)种跳法。
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
       if(n<=1){
           return 1;
       }
       int caches[] = new int[n+1];
       caches[1] = 1;
       caches[2] = 2;
       for (int i=3;i<=n;i++){
           caches[i] = caches[i-1]+caches[i-2];
       }
       return caches[n];
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
       if(prices==null||prices.length==0){
           return 0;
       }
       int maxPro = 0;
       int min = prices[0];
       for (int i=1;i<prices.length;i++){
           if(min>prices[i]){
               min = prices[i];
           }
           if(maxPro<prices[i]-min){
               maxPro = prices[i]-min;
           }
       }
       return maxPro;
    }

    /**
     * 打家劫舍
     *
     * 你是一个专业的小偷，计划偷窃沿街的房屋。
     * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //
        if(nums==null||nums.length==0){
          return 0;
        }
        int len = nums.length;
        //统计给个节点的金额，在偷与不到的情况下
        int[][] dx = new int[len][2];
        dx[0][0] = 0; //没有偷
        dx[0][1] = nums[0]; //偷了第一家
        for(int i=1;i<len;i++){
            dx[i][0] = Math.max(dx[i-1][1],dx[i-1][0]); // 偷与不偷都可以，取最大值。
            dx[i][1] = dx[i-1][0]+nums[i];
        }
        return Math.max(dx[len-1][0],dx[len-1][1]);
    }
}

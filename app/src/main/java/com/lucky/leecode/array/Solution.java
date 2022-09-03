package com.lucky.leecode.array;

import java.util.Random;

/**
 * 随机打乱数组
 */
public class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if(nums==null){
            return nums;
        }
        int[] arr = nums.clone();
        for(int i=1;i< arr.length;i++){
            int j = random.nextInt(i+1);
            swap(arr,i,j);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }
}

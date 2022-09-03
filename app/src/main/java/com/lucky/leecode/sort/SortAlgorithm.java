package com.lucky.leecode.sort;

/**
 * 排序和搜索
 */
public class SortAlgorithm {

    /**
     * 合并两个有序数组
     *
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
     * 为了应对这种情况，nums1 的初始长度为 m + n，
     * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for (int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int[] result = new int[m+n];
        int firstIndex = 0;
        int secondIndex = 0;
        int index = 0;
        while ((firstIndex<m&&secondIndex<n)&&index<(m+n)){
            System.out.println("index:"+index+" firstIndex:"+firstIndex+" secondIndex:"+secondIndex);
            if((nums1[firstIndex]<=nums2[secondIndex])){
                result[index++] = nums1[firstIndex++];
            }else {
                result[index++] = nums2[secondIndex++];
            }
        }
        System.out.println("index:"+index+" firstIndex:"+firstIndex+" secondIndex:"+secondIndex);
        if(firstIndex<m){
            for(int i=firstIndex;i<m;i++){
                result[index++] = nums1[i];
            }
        }
        if(secondIndex<n){
            for(int i=secondIndex;i<n;i++){
                result[index++] = nums2[i];
            }
        }
        for (int i=0;i<result.length;i++){
            nums1[i] = result[i];
        }
    }

    /**
     * 第一个错误的版本
     *
     * 你是产品经理，目前正在带领一个团队开发新的产品。
     * 不幸的是，你的产品的最新版本没有通过质量检测。
     * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     *
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *
     * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。
     * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isVesion = isBadVersion(mid);
            if (isVesion) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version){
        return version==2;
    }
}

package com.lucky.leecode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 其他类型的算法
 */
public class OtherAlgorithm {
    /**
     * 位1的个数
     *
     *编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * 1. 请注意，在某些语言（如 Java）中，没有无符号整数类型。
     * 在这种情况下，输入和输出都将被指定为有符号整数类型，
     * 并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 2. 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
     *
     *  思路：
     *   通过位移操作处理。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n!=0){
           n &= (n-1);
           res++;
        }
        return res;
    }

    /**
     * 汉明距离
     *
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离.
     *
     * ^异或：
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int result = 0;
        int xor = x ^ y;
        while (xor != 0) {
            result += xor & 1;
            xor = xor >>> 1;
        }
        return result;
    }

    /**
     * 颠倒二进制位
     *
     * 颠倒给定的 32 位无符号整数的二进制位。
     *
     * 1. 请注意，在某些语言（如 Java）中，没有无符号整数类型。
     * 在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
     * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 2. 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
     * 因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825
     *
     * 思路：
     *  循环遍历
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }

    /**
     * 杨辉三角
     *
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * 例如：
     *                    1
     *                  1   1
     *                 1   2   1
     *                1   3   3  1
     *               1  4   6   4  1
     *              1  5  10  10  5  1
     *             1  6  15  20  15  6  1
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i=2;i<=numRows;i++){
            List<Integer> itemList = new ArrayList<>();
            for (int j=0;j<i;j++){
                //拿到上一行的数据
               List<Integer> preList = result.get(i-2);
               int left = 0;
               if((j-1)>=0){
                   left = preList.get(j-1);
               }
               int right = 0;
               if(j<preList.size()){
                   right = preList.get(j);
               }
               itemList.add(left+right);
            }
            result.add(itemList);
        }
        return  result;
    }

    /**
     * 有效的括号
     *
     *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *  有效字符串需满足：
     *  1. 左括号必须用相同类型的右括号闭合。
     *  2. 左括号必须以正确的顺序闭合。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        Stack<Character> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char itemChar = s.charAt(i);
            if (isValidLeft(itemChar)) {
                left.push(itemChar);
            } else {
                if(left.isEmpty()){
                    return false;
                }
                char pop = left.pop();
                if (!isMatch(pop, itemChar)) {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    private boolean isValidLeft(char left){
        switch (left){
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private boolean isValidRight(char right){
        switch (right){
            case ')':
            case '}':
            case ']':
                return true;
            default:
                return false;
        }
    }

    private boolean isMatch(char left,char right){
        int value = Math.abs(left - right);
        return value==1||value==2;
    }

    /**
     * 缺失数字
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        boolean[] status = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int value = nums[i]-1;
            if(value>=0){
                status[value] = true;
            }
        }
        for (int i=0;i<status.length;i++){
            if(!status[i]){
                return i+1;
            }
        }
        return -1;
    }
}

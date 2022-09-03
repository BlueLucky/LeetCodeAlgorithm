package com.lucky.leecode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 数组相关的基础算法
 */
public class ArrayAlgorithm {

    /**
     * 整数反转
     * <p>
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int value = Math.abs(x);
        char[] valueChars = String.valueOf(value).toCharArray();
        reverseString(valueChars);
        int resultValue = 0;
        try {
            resultValue = Integer.parseInt(String.valueOf(valueChars));
        } catch (Exception e) {
            return 0;
        }
        if (x < 0) {
            return -resultValue;
        } else {
            return resultValue;
        }
    }

    /**
     * 反转字符串
     * <p>
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        while (head < tail) {
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            head++;
            tail--;
        }
    }

    /**
     * 旋转图像
     * <p>
     * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * <p>
     * 解图思路：
     * 1 2 3         3 2 1               7 4 1
     * 4 5 6 -行反转> 6 5 4 - 对角线交换->  8 5 2
     * 7 8 9         9 8 7               9 6 3
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        //1. 行反转
        for (int i = 0; i < size; i++) {
            reverse(matrix[i], 0, matrix[i].length - 1);
        }
        //2.反对接线替换
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][size - i - 1];
                matrix[size - j - 1][size - i - 1] = temp;
            }
        }
    }

    /**
     * 有效的数独
     * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * <p>
     * 数字1-9在每一行只能出现一次。
     * 数字1-9在每一列只能出现一次。
     * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
     *
     * @param board
     * @return
     */

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char valueChar = board[i][j];
                if (valueChar != '.') {
                    int num = Integer.parseInt(String.valueOf(valueChar)) - 1;
                    System.out.println("num:" + num);
                    System.out.println("i:" + i + " ,j:" + j);
                    int blockIndex = i / 3 * 3 + j / 3;
                    System.out.println("blockIndex:" + blockIndex);
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkChatsRepeat(char[] chars) {
        Set<Character> setChars = new HashSet();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '.') {
                boolean isAdd = setChars.add(chars[i]);
                if (!isAdd) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 两数之和
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     *
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 移动零
     * <p>
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 解题思路：
     * 定义一个移动游标， 遍历数组中不等于空的数据前移。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carryValue = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int lastValue = digits[i] + 1;
                if (lastValue == 10) {
                    result.add(0);
                    carryValue = 1;
                } else {
                    result.add(lastValue);
                }
            } else {
                int value = digits[i] + carryValue;
                if (value == 10) {
                    result.add(0);
                    carryValue = 1;
                } else {
                    result.add(value);
                    carryValue = 0;
                }
            }
        }
        if (carryValue != 0) {
            result.add(carryValue);
        }

        int[] resultArray = new int[result.size()];
        for (int i = result.size() - 1; i >= 0; i--) {
            resultArray[(result.size() - 1 - i)] = result.get(i);
        }
        return resultArray;
    }

    /**
     * 两个数组的交集 II
     * <p>
     * 1. 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 2. 如果nums1的大小比nums2 小，哪种方法更优？
     * 3. 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);
        List<Integer> result = new ArrayList<>();
        int nums1Lenght = nums1.length;
        int nums2Lenght = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1Lenght && index2 < nums2Lenght) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                result.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }


    /**
     * 找打出现一次的元素
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        sort(nums);
        printArray(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if ((i + 1) > nums.length - 1) {
                return nums[i];
            } else {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            //优化最好情况下，时间复杂度未O(n)
            boolean isDoSwapper = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isDoSwapper = true;
                }
            }
            if (!isDoSwapper) {
                break;
            }
        }
    }

    /**
     * 数组选装
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); //整个数组反转
        reverse(nums, 0, k - 1); // 前半部分反转
        reverse(nums, k, nums.length - 1);//后半部分反转
    }

    /**
     * 反转
     *
     * @param arr
     * @param left
     * @param right
     */
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int posiont1, int position2) {
        int temp = nums[posiont1];
        nums[posiont1] = nums[position2];
        nums[position2] = temp;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int dxPrice = prices[i] - prices[i - 1];
            System.out.println("dxPrice:" + dxPrice);
            if (dxPrice > 0) {
                maxProfit += dxPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 删除重复数组元素
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        for (int i = index + 1; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
            nums[i] = -1;
        }
        System.out.println();
        return index + 1;
    }

    /**
     * 最大子序列的和
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int maxSub(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftMax = maxSub(nums, left, mid);
        int rightMax = maxSub(nums, mid + 1, right);

        int midLeft = nums[mid];
        int midRight = nums[mid + 1];

        int temp = 0;
        for (int i = mid; i >= left; i--) {
            temp += nums[i];
            if (temp > midLeft) {
                midLeft = temp;
            }
        }
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp += nums[i];
            if (temp > midRight) {
                midRight = temp;
            }
        }
        int max = midLeft + midRight;
        if (max < leftMax) {
            max = leftMax;
        }
        if (max < rightMax) {
            max = rightMax;
        }
        return max;
    }

    private void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 重塑矩阵
     * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
     *给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
     *重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
     * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat==null){
            return mat;
        }
        int orgSize = mat.length*mat[0].length;
        if(orgSize!=r*c){
            return mat;
        }
        int retR = 0;
        int retC = 0;
        int[][] result = new int[r][c];
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[i].length;j++){
                if(retC==c-1){
                    result[retR][retC] = mat[i][j];
                    retC=0;
                    retR++;
                }else{
                    result[retR][retC++] = mat[i][j];
                }
            }
        }
        return result;
    }

    /**
     * 矩阵置零
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if(row.contains(i)||col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

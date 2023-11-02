package com.lucky.leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public void printArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 重塑矩阵
     * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
     * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
     * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null) {
            return mat;
        }
        int orgSize = mat.length * mat[0].length;
        if (orgSize != r * c) {
            return mat;
        }
        int retR = 0;
        int retC = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (retC == c - 1) {
                    result[retR][retC] = mat[i][j];
                    retC = 0;
                    retR++;
                } else {
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
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 多数元素
     * <p>
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 思路：
     * 因为众数大于n/2，假如我们令众数为1，其他数为 -1，那么他们的和一定是正数，至少是1。
     * 当我们不知道谁是众数的情况下，我们可以令第一个元素为众数，若下一个元素是它则+1，下一个不是则减1，若减到0，
     * 下一个不是它，则令下一个元素是众数，下一个是它则自增。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                ++count;
            } else {
                if (nums[i] == result) {
                    ++count;
                } else {
                    --count;
                }
            }
        }
        return result;
    }

    /**
     * 三数之和
     * <p>
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * <p>
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                int sum = nums[L] + nums[i] + nums[R];
                if (sum == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[L]);
                    item.add(nums[i]);
                    item.add(nums[R]);

                    result.add(item);

                    while (L < R && nums[L + 1] == nums[L]) ++L;
                    while (L < R && nums[R - 1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if (sum < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return result;
    }

    /**
     * 寻找两个正序数组的中位数
     * <p>
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergerLength = nums1.length + nums2.length;
        int[] result = new int[mergerLength];
        int index = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < nums1.length || secondIndex < nums2.length) {
            if (firstIndex < nums1.length && secondIndex < nums2.length) {
                if (nums1[firstIndex] < nums2[secondIndex]) {
                    result[index++] = nums1[firstIndex++];
                } else {
                    result[index++] = nums2[secondIndex++];
                }
            } else if (firstIndex < nums1.length) {
                result[index++] = nums1[firstIndex++];
            } else if (secondIndex < nums2.length) {
                result[index++] = nums2[secondIndex++];
            }
        }
        int mid = mergerLength / 2;
        if (mergerLength % 2 == 0) {
            return (result[mid] + result[mid - 1]) / 2.0;
        } else {
            return result[mid];
        }
    }

    /**
     * 颜色分类
     * <p>
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库的sort函数的情况下解决这个问题。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1;
        while (left < nums.length - 1 && nums[left] == 0) {
            left++;
        }
        while (right >= 0 && nums[right] == 2) {
            right--;
        }
        int mid = left;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, mid++, left++);
            } else if (nums[mid] == 2) {
                swap(nums, mid, right--);
            } else {
                mid++;
            }
        }
    }

    /**
     * 合并区间
     * <p>
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int left = intervals[0][0], right = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        result.add(new int[]{left, right});

        int[][] arrayInt = new int[result.size()][2];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = result.get(i);
        }
        return arrayInt;
    }

    /**
     * 螺旋矩阵 II
     * <p>
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int up = 0, low = n - 1;
        int left = 0, right = n - 1;
        int sum = 1;
        while (sum <= n * n) {
            if (up <= low) {
                for (int i = left; i <= right; i++) {
                    result[up][i] = sum++;
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= low; i++) {
                    result[i][right] = sum++;
                }
                right--;
            }
            if (up <= low) {
                for (int i = right; i >= left; i--) {
                    result[low][i] = sum++;
                }
                low--;
            }
            if (left <= right) {
                for (int i = low; i >= up; i--) {
                    result[i][left] = sum++;
                }
                left++;
            }
        }
        return result;
    }

    /**
     * 搜索二维矩阵 II
     * <p>
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * 1. 每行的元素从左到右升序排列。
     * 2. 每列的元素从上到下升序排列。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] > target) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 无重叠区间
     * <p>
     * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //尾升序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int counts = 1;
        int endValue = intervals[0][1];
        for (int[] interval : intervals) {
            int startValue = interval[0];
            if (startValue >= endValue) {
                counts++;
                endValue = interval[1];
            }
        }
        return intervals.length - counts;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 原始数组
     * @param val  需要删除的值
     * @return 返回删除后的数组长度
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tIndex = 0; //相同值的位置
        int dIndex = 0; //不同值的位置
        int size = nums.length;
        while (dIndex < size) {
            if (tIndex != dIndex) {
                if (tIndex < dIndex) {
                    if (nums[tIndex] == nums[dIndex]) {
                        dIndex = dIndex + 1;
                    } else {
                        swap(nums, tIndex, dIndex);
                        tIndex = tIndex + 1;
                        dIndex = dIndex + 1;
                    }
                } else {
                    dIndex = dIndex + 1;
                }

            } else {
                if (nums[tIndex] != val) {
                    tIndex = tIndex + 1;
                }
                if (nums[dIndex] == val) {
                    dIndex = dIndex + 1;
                }
            }
            System.out.println("tIndex:" + tIndex + ",dIndex:" + dIndex);
        }
        printArray(nums);
        return tIndex;
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums 原始数组
     * @return 删除后的数组个数
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int currentValue = nums[0];
        int tCount = 1;
        int moveIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (currentValue == nums[i]) {
                if (tCount < 2) {
                    tCount++;
                    if (moveIndex != -1) {
                        nums[moveIndex] = nums[i];
                        moveIndex++;
                    }
                } else {
                    if (moveIndex == -1) {
                        moveIndex = i;
                    }
                }
            } else {
                tCount = 1;
                currentValue = nums[i];
                if (moveIndex != -1) {
                    nums[moveIndex] = nums[i];
                    moveIndex++;
                }
            }
        }
        if (moveIndex == -1) {
            moveIndex = nums.length;
        }
        printArray(nums);
        return moveIndex;
    }

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * @param nums 原始数据
     * @return 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        //不需要跳
        if (nums.length == 1) {
            return true;
        }
        List<Byte> status = new ArrayList<>();
        for (int i = nums.length-1; i > 0; i--) {
            //找到0的位置，判断这个位置是否能够跨越
            if (nums[i] == 0) {
                if (i != nums.length - 1) {
                    status.add((byte) 0);
                    for (int j = 0; j < i; j++) {
                        int step = j + nums[j];
                        if (step > i || i == nums.length - 1) {
                            status.set(status.get(status.size() - 1), (byte) 1);
                            break;
                        }
                    }
                }
            }
        }
        boolean canJump = true;
        for (int i = 0; i < status.size(); i++) {
            if (status.get(i) == 0) {
                canJump = false;
            }
        }
        return canJump;
    }
}

package com.lucky.leecode;

import com.lucky.leecode.array.ArrayAlgorithm;
import org.junit.Test;
import java.util.List;

public class ArrayUnitTest {

    @Test
    public void testMajorNum(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        System.out.println("test1："+arrayAlgorithm.majorityElement(new int[]{3,2,3}));
        System.out.println("test2："+arrayAlgorithm.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    @Test
    public void testTreeAdd(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        List<List<Integer>> result = arrayAlgorithm.threeSum(new int[]{-1,0,1,2,-1,-4});
        printList(result);

        List<List<Integer>> result2 = arrayAlgorithm.threeSum(new int[]{0,1,1});
        printList(result2);

        List<List<Integer>> result3 = arrayAlgorithm.threeSum(new int[]{0,0,0});
        printList(result3);
    }

    private void printList(List<List<Integer>> lists){
        for (List<Integer> list:lists){
            for (Integer value:list){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testFindMidSum(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        System.out.println("test1:"+arrayAlgorithm.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println("test2:"+arrayAlgorithm.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println("test3:"+arrayAlgorithm.findMedianSortedArrays(new int[]{1,2},new int[]{}));
        System.out.println("test4:"+arrayAlgorithm.findMedianSortedArrays(new int[]{},new int[]{3,4}));
    }

    @Test
    public void testSortColors(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        int[] test1 = new int[]{2,0,2,1,1,0};
        arrayAlgorithm.sortColors(test1);
        arrayAlgorithm.printArray(test1);

        int[] test2 = new int[]{2,0,1};
        arrayAlgorithm.sortColors(test2);
        arrayAlgorithm.printArray(test2);
    }

    @Test
    public void testMegerNus(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        int[][] result = arrayAlgorithm.merge(new int[][]{{1,5},{2,6},{8,10},{15,18}});
        arrayAlgorithm.printArray(result);
        int[][] result1 = arrayAlgorithm.merge(new int[][]{{1,4},{4,5}});
        arrayAlgorithm.printArray(result1);
        int[][] result2 = arrayAlgorithm.merge(new int[][]{});
        arrayAlgorithm.printArray(result2);
    }

    @Test
    public void testGenerateMatrix(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        int[][] result = arrayAlgorithm.generateMatrix(3);
        arrayAlgorithm.printArray(result);
        int[][] result1 = arrayAlgorithm.generateMatrix(1);
        arrayAlgorithm.printArray(result1);
    }

    @Test
    public void testSearchMatrix(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        System.out.println("search:"+arrayAlgorithm.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19}
                ,{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));

        System.out.println("search:"+arrayAlgorithm.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19}
                ,{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
    }

    @Test
    public void testRemoveElement(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        int test1[] = new int[]{3,2,2,3};
        arrayAlgorithm.removeElement(test1,3);
//        arrayAlgorithm.removeElement(test1,2);
        int test2[] = new int[]{0,1,2,2,3,0,4,2};
        arrayAlgorithm.removeElement(test2,2);
    }

    @Test
    public void testRemoveDuplicates(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        int test1[] = new int[]{1,1,1,2,2,3};
        arrayAlgorithm.removeDuplicates(test1);
    }

    @Test
    public void testRemoveDuplicates2(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
        int test1[] = new int[]{1,1,1,2,2,3};
        int result1 = arrayAlgorithm.removeDuplicates2(test1);
        System.out.println("result1:"+result1);
        int test2[] = new int[]{0,0,1,1,1,1,2,3,3};
        result1 = arrayAlgorithm.removeDuplicates2(test2);
        System.out.println("result2:"+result1);

        int test3[] = new int[]{0};
        result1 = arrayAlgorithm.removeDuplicates2(test3);
        System.out.println("result3:"+result1);

        int test4[] = new int[]{1,1};
        result1 = arrayAlgorithm.removeDuplicates2(test4);
        System.out.println("result4:"+result1);

        int test5[] = new int[]{1,1,2};
        result1 = arrayAlgorithm.removeDuplicates2(test5);
        System.out.println("result5:"+result1);
    }

    @Test
    public void testCanJump(){
        ArrayAlgorithm arrayAlgorithm = new ArrayAlgorithm();
//        int test1[] = new int[]{2,3,1,1,4};
//        System.out.println(arrayAlgorithm.canJump(test1));
//        int test2[] = new int[]{3,2,1,0,4};
//        System.out.println(arrayAlgorithm.canJump(test2));
//        int test3[] = new int[]{0};
//        System.out.println(arrayAlgorithm.canJump(test3));
//        int test4[] = new int[]{1,1,1,0};
//        System.out.println(arrayAlgorithm.canJump(test4));
//        int test5[] = new int[]{1,1,2,2,0,1,1};
//        System.out.println(arrayAlgorithm.canJump(test5));

        int test6[] = new int[]{3,0,0,0};
        System.out.println(arrayAlgorithm.canJump(test6));
    }
}

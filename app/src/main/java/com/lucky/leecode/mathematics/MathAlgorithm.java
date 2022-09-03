package com.lucky.leecode.mathematics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class MathAlgorithm {
    /**
     * Fizz Buzz
     *
     *给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
     * 1. answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
     * 2. answer[i] == "Fizz" 如果 i 是 3 的倍数。
     * 3. answer[i] == "Buzz" 如果 i 是 5 的倍数。
     * 4. answer[i] == i （以字符串形式）如果上述条件全不满足。
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
         List<String> result = new ArrayList<>();
         for(int i=1;i<=n;i++){
             boolean isFizz = isFizz(i);
             boolean isBuzz = isBuzz(i);
             if(isFizz&&isBuzz){
                 result.add("FizzBuzz");
             }else if(isFizz){
                 result.add("Fizz");
             }else if(isBuzz){
                 result.add("Buzz");
             }else{
                 result.add(i+"");
             }
         }
         return result;
    }

    private boolean isFizz(int n){
        return n%3==0;
    }
    private boolean isBuzz(int n){
        return n%5==0;
    }

    /**
     * 计数质数
     *
     * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i=0;i<n;i++){
            if(isPrimes(i)){
                count++;
            }
        }
        return count;
    }

    /**
     * 判断是否是质数
     * 在一般领域，对正整数n，如果用2到 之间的所有整数去除，均无法整除，则n为质数。
     * 质数大于等于2 不能被它本身和1以外的数整除
     *
     * @param n
     * @return
     */
    private boolean isPrimes(int n){
        if(n<=3){
            return n>1;
        }
        for (int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    /**
     * 3的幂
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     *
     *  1162261467 是int整数中最大的3的次幂数。
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        return 1162261467 % n == 0;
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符           数值
     *  I             1
     *  V             5
     *  X             10
     *  L             50
     *  C             100
     *  D             500
     *  M             1000
     *
     * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为X+V+II。
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character,Integer> keyMap = new HashMap<>();
        keyMap.put('I',1);
        keyMap.put('V',5);
        keyMap.put('X',10);
        keyMap.put('L',50);
        keyMap.put('C',100);
        keyMap.put('D',500);
        keyMap.put('M',1000);
        int result =0;
        int megerValue = 0;
        for (int i=0;i<s.length();i++){
            int currentValue = keyMap.get(s.charAt(i));
            int nextValue = 0;
            if((i+1)<=s.length()-1){
                nextValue = keyMap.get(s.charAt(i+1));
            }
            if(nextValue <= currentValue){
                result += currentValue+megerValue;
                megerValue = 0;
                System.out.println(s.charAt(i));
            }else{
                megerValue -= currentValue;
                System.out.print(s.charAt(i)+" ");
            }
        }
        return result;
    }
}

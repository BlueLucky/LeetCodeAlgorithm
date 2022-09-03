package com.lucky.leecode.strings;

/**
 * 字符串基础算法
 */
public class StringAlgorithm {
    /**
     * 最长公共前缀
     * <p>
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String commPre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String value = strs[i];
            if (value.length() <= 0) {
                return "";
            }
            System.out.println("value:" + value + " commPre:" + commPre);
            for (int j = 0; j < value.length(); j++) {
                if (commPre.length() > j && commPre.charAt(j) != value.charAt(j)) {
                    commPre = commPre.substring(0, j);
                    break;
                }
                if (commPre.length() > value.length() && j == value.length() - 1) {
                    commPre = commPre.substring(0, value.length());
                }
            }
        }
        return commPre;
    }

    /**
     * 外观数列
     * <p>
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     * 外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     * 1. countAndSay(1) = "1"
     * 2. countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }
        String countAndSay = countAndSay(n - 1);
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < countAndSay.length(); i++) {
            if ((i + 1) < countAndSay.length() && countAndSay.charAt(i) != countAndSay.charAt(i + 1)) {
                count++;
                stringBuilder.append(count).append(countAndSay.charAt(i));
                count = 0;
            } else {
                count++;
            }
        }
        stringBuilder.append(count).append(countAndSay.charAt(countAndSay.length() - 1));

        return stringBuilder.toString();
    }

    /**
     * 实现strStr()函数。
     * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     * 说明：
     * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() <= 0) {
            return 0;
        }
        if (haystack == null || haystack.length() <= 0) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int hIndex = 0;
        int nIndex = 0;
        while (hIndex < haystack.length() && nIndex < needle.length()) {
            System.out.println("hIndex:" + hIndex + " ,nIndex：" + nIndex);
            if (haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                hIndex++;
                nIndex++;
            } else {
                hIndex = hIndex - nIndex + 1;
                nIndex = 0;
            }
            if (nIndex == needle.length()) {
                return hIndex - nIndex;
            }
        }
        return -1;
    }


    public int myAtoi2(String str) {
        char[] chars = str.trim().toCharArray();
        boolean isNegative = false;
        int result = 0;
        int index = 0;
        int length = chars.length;
        //过滤字符串前空字符
        while (index < length && chars[index] == ' ') {
            index++;
        }
        if (index >= length) {
            return 0;
        }
        if (chars[index] == '-' || chars[index] == '+') {
            if (chars[index] == '-') {
                isNegative = true;
            }
            index++;
        }
        while (index < length) {
            int digit = chars[index] - '0';
            System.out.print("digit:" + digit + " ");
            if (digit > 9 || digit < 0) {
                break;
            }
            int temp = result;
            result = result * 10 + digit;
            System.out.println("result:" + result);
            if (result / 10 != temp) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            index++;
        }
        if (isNegative) {
            return result * -1;
        } else {
            return result;
        }
    }

    /**
     * 字符串转换整数 (atoi)
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        boolean isNegative = false;
        int result = 0;
        int limit = -Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            char value = chars[i];
            if (value == '-' && (i + 1) < chars.length && Character.isDigit(chars[i + 1])) {
                isNegative = true;
            }
            if (Character.isDigit(chars[i])) {
                int digit = Character.digit(chars[i], 10);
                //进制
                result *= 10;

                if (result < limit + digit) {
                    return -1;
                }
                result -= digit;

                if ((i + 1) < chars.length && !Character.isDigit(chars[i + 1])) {
                    break;
                }
            }
        }
        if (isNegative) {
            return result;
        } else {
            return -result;
        }
    }

    /**
     * 验证回文串
     * <p>
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个回文串。
     * 字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是回文串，返回 true ；否则，返回 false 。
     *
     * @param s 需要验证的字符串
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.length() <= 0) {
            return true;
        }

        char[] chars = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (head <= tail) {
            if (chars[head] == chars[tail]) {
                head++;
                tail--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 有效的字母异位词
     * <p>
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int sCounts[] = new int[26];
        int tCounts[] = new int[26];

        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            sCounts[sChars[i] - 'a']++;
        }
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tCounts[tChars[i] - 'a']++;
        }
        for (int i = 0; i < sCounts.length; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串中的第一个唯一字符
     * <p>
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * <p>
     * 解题思路：
     * 1. 遍历字符串的字符重复数
     * 2. 找出第一个不重复的字符
     *
     * @param s 输入String
     * @return 返回位置
     */
    public int firstUniqChar(String s) {
        int counts[] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 赎金信
     *
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int sCounts[] = new int[26];
        int tCounts[] = new int[26];

        char[] sChars = ransomNote.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            sCounts[sChars[i] - 'a']++;
        }
        char[] tChars = magazine.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tCounts[tChars[i] - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = sChars[i]-'a';
            if (sCounts[index] > tCounts[index]) {
                return false;
            }
        }
        return true;
    }
}

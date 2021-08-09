package p0014;

/**
 * Created by baimn on 2021/8/9.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        return v2(strs);
    }

    /*
    v1
    选取第一个单词为基准，逐个字母寻找是否重复
    runtime:1MS 58%
    memory:37MB 58%
    */
    public String v1(String[] strs) {
        int len = strs.length;
        int count = 0;
        String benchmark = strs[0];
        boolean stop = false;
        for (int i = 0; i < benchmark.length() && !stop; i++) {
            char letter = benchmark.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < i + 1) {
                    stop = true;
                    break;
                } else if (letter == strs[j].charAt(i)) {
                    count = (j == len - 1) ? count + 1 : count;
                    continue;
                } else {
                    stop = true;
                    break;
                }
            }
        }
        return benchmark.substring(0, count);
    }

    /*
    v2
    取两个string的common，并逐个向后寻找
    runtime:0MS 100%
    memory:37MB 58%
    */
    public String v2(String[] strs) {
        int len = strs.length;
        int count = 0;
        String common = "";
        if (1 == len) {
            return strs[0];
        }
        common = commonOfTwo(strs[0], strs[1]);
        if (common.length() == 0) {
            return common;
        }
        for (int i = 1; i < len; i++) {
            if (common.length() == 0) {
                return common;
            }
            common = commonOfTwo(common, strs[i]);
        }
        return common;
    }

    public String commonOfTwo(String str1, String str2) {
        int small = str1.length() < str2.length() ? str1.length() : str2.length();
        int same = 0;
        for (int i = 0; i < small; ) {
            if (str1.charAt(i) == str2.charAt(i)) {
                same++;
                i++;
            } else {
                break;
            }
        }
        return str1.substring(0, same);
    }

}
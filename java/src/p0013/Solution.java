package p0013;

/**
 * Created by baimn on 2021/7/17.
 */

class Solution {
    public int romanToInt(String s) {
        return v1(s);
    }


    /*
    v1粗暴破解
    逐字符确认数字
    只有1、10、100可能是正或者负
    5、50、500,以及1000（本题目下）则必然正数
     */
    public int v1(String s) {
        int[] arr = translate(s);
        int res = sumArr(arr);
        return res;
    }

    /*
    将罗马字符串输出为int数组
    */
    public int[] translate(String s) {
        int len = s.length();
        int[] intArr = new int[len];
        for (int i = 0; i < len; ++i) {
            intArr[i] = lookUp(s, i);
        }
        return intArr;
    }

    /*
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
     */
    public int lookUp(String str, int index) {
        char letter = str.charAt(index);
        int symbol = 1;
        switch (letter) {
            case 'I':
                symbol = (index + 1 < str.length() && (str.charAt(index + 1) == 'V' || str.charAt(index + 1) == 'X')) ? -1 : 1;
                return 1 * symbol;
            case 'V':
                return 5;
            case 'X':
                symbol = (index + 1 < str.length() && (str.charAt(index + 1) == 'L' || str.charAt(index + 1) == 'C')) ? -1 : 1;
                return 10 * symbol;
            case 'L':
                return 50;
            case 'C':
                symbol = (index + 1 < str.length() && (str.charAt(index + 1) == 'D' || str.charAt(index + 1) == 'M')) ? -1 : 1;
                return 100 * symbol;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /*
    数组逐项加和
    */
    public int sumArr(int[] array) {
        int ret = 0;
        for (int i = 0; i < array.length; ++i) {
            ret += array[i];
        }
        return ret;
    }
}


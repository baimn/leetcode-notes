package p0008;

/**
 * Created by baimn on 2021/10/31.
 */

class Solution {
    public int myAtoi(String str) {
        return v1(str);
    }

    public int v1(String str) {
        int sign = 1, num = 0, i = 0;
        int len = str.length();
        char c;
        while (i < len && str.charAt(i) == ' ') { // blank spaces in the beginning
            i++;
        }
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) { // sign
            sign = (str.charAt(i) == '+' ? 1 : -1);
            i++;
        }
        while (i < len && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) { // number
            c = str.charAt(i);
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && c - '0' > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                num = num * 10 + (c - '0');
            }
            i++;
        }
        return sign * num;
    }
}

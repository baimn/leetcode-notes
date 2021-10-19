package p0007;

/**
 * Created by baimn on 2021/10/19.
 */
class Solution {
    public int reverse(int x) {
        return v1(x);
    }

    public int v1(int x) {
        // MAX_VALUE is   2,147,483,647
        // MIN_VALUE is  -2,147,483,648
        int result = 0, index = 0;
        boolean isFullSize = x / 1000000000 != 0;
        boolean isPositive = x > 0;
        int[] positive = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        int[] negative = {2, 1, 4, 7, 4, 8, 3, 6, 4, 8};
        int[] value = new int[10];
        while (x != 0) {
            result *= 10;
            int digit = x % 10;
            result += digit;
            x /= 10;
            if (isFullSize) {// store the digits when x is full size
                value[index] = Math.abs(digit);
                index++;
            }
        }
        if (isFullSize) {// check whether out of boundary
            int[] toCompare = isPositive ? positive : negative;
            for (int i = 0; i < 10; ++i) {
                // you can return once difference happens
                if (value[i] != toCompare[i]) {
                    return value[i] > toCompare[i] ? 0 : result;
                }
            }
        }
        return result;
    }
}
package p0009;

/**
 * Created by baimn on 2021/11/14.
 */
class Solution {
    public boolean isPalindrome(int x) {
        return v2(x);
    }

    //use size to deal with xs with different sizes
    // O(2n)
    public boolean v1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int size = 1, ori = x, cal = 0;
        while (ori >= 10) {
            size *= 10;
            ori /= 10;
        }
        while (x >= 0 & size > 0) {
            if (x % 10 != x / size) {
                return false;
            }
            x -= (x / size) * size;
            x /= 10;
            size /= 100;
        }
        return true;
    }

    //reverse the num and then compare the reverted with the origin
    // O(n)
    public boolean v2(int x) {

        boolean res = false;
        int highest = x / (int) Math.pow(10, 10), lowest = x % 10;
        if (highest > 0) { // the integer is full size (10 digits)
            if (highest == lowest) {
                x %= x / Math.pow(10, 10); // remove highest from x
                x /= 10; // remove lowest from x
            } else {
                return false;
            }
        }
        int num = x, rev = 0, item = 0;
        while (num > 0) {
            item = num % 10; // this digit to deal with
            num /= 10;
            rev = rev * 10 + item;
        }
        if (x == rev) {
            res = true;
        }
        return res;
    }
}
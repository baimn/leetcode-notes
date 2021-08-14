package p0011;

/**
 * Created by baimn on 2021/8/14.
 */
class Solution {
    public int maxArea(int[] height) {
        return v2(height);
    }

    /*
    v1
    TIME LIMIT EXCEEDED
    */
    public int v1(int[] arr) {
        int ret = 0;
        int left = 0, right = 0, width = 0, high = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            left = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                right = arr[j];
                width = j - i;
                high = min(left, right);
                ret = max(ret, width * high);
            }
        }
        return ret;
    }

    /*
    choose the min value two int
    */
    public int min(int a, int b) {
        return (a <= b ? a : b);
    }

    /*
    choose the max value two int
    */
    public int max(int a, int b) {
        return a >= b ? a : b;
    }

    /*
   v2
   use two pointers, for left and right respectively
   narrow down the range,
   Runtime: 5ms, 11%
   Memory:79MB,5%
   */
    public int v2(int[] arr) {
        int ret = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            ret = max(ret, (right - left) * min(arr[left], arr[right]));
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }

}
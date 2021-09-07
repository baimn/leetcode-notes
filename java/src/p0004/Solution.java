package p0004;

/**
 * Created by baimn on 2021/9/7.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return v1(nums1, nums2);
    }

    //v1
    //runtime:2ms,99%,memory:39MB,98%
    //use an array (co) to store the items from the beginning to the median
    //interpolate is to deal with odd and even
    //empty1 and 2 to deal with the situation where nums1 and nums2 are fully stored in co
    public double v1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = ((m + n) / 2) + 1;
        int[] co = new int[len];
        boolean interpolate = (m + n) % 2 == 0 ? true : false;
        boolean empty1 = m == 0 ? true : false;
        boolean empty2 = n == 0 ? true : false;
        for (int p1 = 0, p2 = 0, p = 0; p < len; ++p) {
            if (empty1) {
                co[p] = nums2[p2];
                p2++;
                continue;
            }
            if (empty2) {
                co[p] = nums1[p1];
                p1++;
                continue;
            }
            if (nums1[p1] <= nums2[p2]) {
                co[p] = nums1[p1];
                p1++;
                empty1 = (p1 == m) ? true : false;
            } else {
                co[p] = nums2[p2];
                p2++;
                empty2 = (p2 == n) ? true : false;
            }
        }
        if (interpolate) {
            return ((double) co[len - 1] + (double) co[len - 2]) / 2;
        } else {
            return (double) co[len - 1];
        }
    }
}
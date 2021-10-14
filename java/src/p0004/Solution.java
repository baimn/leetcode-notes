class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return v2(nums1, nums2);
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

    //v2
    //try to use binary search
    public double v2(int[] nums1, int[] nums2) {
        // to garantee nums 1 is the shorter(or equal), nums2 is the longer
        // when nums1 is shorter than or equal to nums2, it's fine.
        // when vice versa, we swap the arrays.
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int median1 = 0, median2 = 0;

        while (left <= right) {
            int p1 = (left + right) / 2;
            int p2 = (m + n + 1) / 2 - p1;
            // to make sure the order
            int nums_p1_pre = (p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1]);
            int nums_p1 = (p1 == m ? Integer.MAX_VALUE : nums1[p1]);
            int nums_p2_pre = (p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1]);
            int nums_p2 = (p2 == n ? Integer.MAX_VALUE : nums2[p2]);
            // cross compare
            // via the above transform, we only need to compare nums_p1_pre vs. nums_p2
            if (nums_p1_pre <= nums_p2) {
                median1 = Math.max(nums_p1_pre, nums_p2_pre);
                median2 = Math.min(nums_p1, nums_p2);
                left = p1 + 1;
            } else {
                right = p1 - 1;
            }

        }
        //calculate the result

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
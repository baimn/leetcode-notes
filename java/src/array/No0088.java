class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        v3(nums1, m, nums2, n);
    }

    //v1
    //Runtime:0ms,100%,Memory:38.9MB,81.89%
    //还是先按本方法试一下，逐项比较，将数字nums1逐项向后移
    public void v1(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0;//nums1 有序的数值(检查没问题)
        int n2 = 0;//nums2 有序的数值(nums2插入nums1的计数)
        for (int i = 0; n2 < n; ++i) {
            if (n1 == m) {//nums1全走完了，直接拿nums2的值赋值
                nums1[i] = nums2[n2];
                ++n2;
                continue;
            } else {
                if (nums1[i] <= nums2[n2]) {
                    ++n1;
                } else {
                    for (int k = (i + m - n1); k > i; --k) {
                        nums1[k] = nums1[k - 1];
                    }
                    nums1[i] = nums2[n2];
                    ++n2;
                }
            }

        }
    }

    //v2
    //Runtime:0ms,100%,Memory:39.5MB,13.15%
    //丧心病狂，只是O(n)的插入加上一个java自己的sort
    public void v2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++)
            nums1[m + i] = nums2[i];
        Arrays.sort(nums1);
    }

    //v3
    //Runtime:0ms,100%,Memory:39MB,71.29%
    //这次从后往前走，只需要取两个数组大的值，赋给最后一位
    //应该更能利用原数组有序的优势
    //leetcode这个runtime实在没有参考价值，这个显然比v1强啊。。
    public void v3(int[] nums1, int m, int[] nums2, int n) {
        if (0 == n) {
            return;
        }
        int current = m + n - 1;
        int k1 = m - 1;
        int k2 = n - 1;
        while (current >= 0 && k2 >= 0) {
            if (k1 >= 0 && nums1[k1] > nums2[k2]) {//取较大值
                nums1[current] = nums1[k1--];
            } else {
                nums1[current] = nums2[k2--];
            }
            --current;
        }
    }
}
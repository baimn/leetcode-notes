package p0035;
class Solution {
    public int searchInsert(int[] nums, int target) {
        return v2(nums, target);
    }

    //v1
    //Runtime: 0ms, 100%, Memory:38.9MB,28.62%
    //本题实质上为寻找>=target的数值的下标
    public int v1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    //v2
    //Runtime: 0ms, 100%, Memory:38.4MB,92.36%
    //使用二分查找，稍微优化一下
    public int v2(int[] nums, int target) {
        if (nums.length > 0 && nums[0] >= target) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}